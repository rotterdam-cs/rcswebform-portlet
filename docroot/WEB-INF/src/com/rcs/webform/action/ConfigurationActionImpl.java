package com.rcs.webform.action;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.rcs.webform.common.enums.FormItemType;
import com.rcs.webform.common.enums.ValidationType;
import com.rcs.webform.model.Form;
import com.rcs.webform.model.FormItem;
import com.rcs.webform.model.FormItemOption;
import com.rcs.webform.model.FormToPorletMap;
import com.rcs.webform.service.FormItemLocalServiceUtil;
import com.rcs.webform.service.FormItemOptionLocalServiceUtil;
import com.rcs.webform.service.FormLocalServiceUtil;
import com.rcs.webform.service.FormToPorletMapLocalServiceUtil;

public class ConfigurationActionImpl extends DefaultConfigurationAction {

    private static Log log = LogFactoryUtil.getLog(ConfigurationActionImpl.class);

    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        if (!SessionErrors.isEmpty(actionRequest)) {
            return;
        }

        Locale defaultLocale = LocaleUtil.getDefault();
        String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

        String portletResource = ParamUtil.getString(actionRequest, "portletResource");

        PortletPreferences preferences = actionRequest.getPreferences();

        // Save title and description to portlet preferences
        LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "title");
        LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "description");

        String tabValue = ParamUtil.getString(actionRequest, "tabsValue", "Form Information");
        actionRequest.setAttribute("tabsValue", tabValue);

        // Save form configuration to database
        ServiceContext formServiceContext = ServiceContextFactory.getInstance(Form.class.getName(), actionRequest);
        Long formId = null;
        if (ParamUtil.getLong(actionRequest, "formId") != 0) {
            formId = ParamUtil.getLong(actionRequest, "formId");
        }
        boolean useCaptcha = ParamUtil.getBoolean(actionRequest, "requireCaptcha");
        String successUrl = ParamUtil.getInteger(actionRequest, "onSubmitData") == 2 ? ParamUtil.getString(actionRequest, "submitSuccessURL") : "";
        String formAttrId = ParamUtil.getString(actionRequest, "formCssId");
        String formAttrClass = ParamUtil.getString(actionRequest, "formCssClass");
        String submitAttrId = ParamUtil.getString(actionRequest, "submitCssId");
        String submitAttrClass = ParamUtil.getString(actionRequest, "submitCssClass");

        Map<Locale, String> titleMap = LocalizationUtil.getLocalizationMap(actionRequest, "title");
        Map<Locale, String> descMap = LocalizationUtil.getLocalizationMap(actionRequest, "description");
        Map<Locale, String> successMsgMap = ParamUtil.getInteger(actionRequest, "onSubmitData") == 1 ? LocalizationUtil.getLocalizationMap(actionRequest,
                "submitSuccessMsg") : null;
        Map<Locale, String> submitLabelMap = LocalizationUtil.getLocalizationMap(actionRequest, "submitBtnLabel");

        Form savedForm = FormLocalServiceUtil.save(formId, formServiceContext, formAttrId, formAttrClass, titleMap, descMap, useCaptcha, successMsgMap,
                successUrl, submitLabelMap, submitAttrId, submitAttrClass);

        // Save form-portlet mapping to database
        ServiceContext formPortletMappingServiceContext = ServiceContextFactory.getInstance(FormToPorletMap.class.getName(), actionRequest);
        Long formToPortletId = null;
        if (ParamUtil.getLong(actionRequest, "formToPortletMapId") != 0) {
            formToPortletId = ParamUtil.getLong(actionRequest, "formToPortletMapId");
        }
        FormToPorletMapLocalServiceUtil.save(formToPortletId, portletResource, savedForm.getFormId(), formPortletMappingServiceContext);

        if (savedForm.getFormId() != 0) {
            saveFormItems(actionRequest, defaultLocale, savedForm.getFormId());
        }

        if (SessionErrors.isEmpty(actionRequest)) {
            preferences.store();
        }

        super.processAction(portletConfig, actionRequest, actionResponse);
    }

    public String render(PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
        String type = ParamUtil.getString(renderRequest, "type");
        if (type.equals("formItem")) {
            return "/jsp/edit_field.jsp";
        } else if (type.equals("optionField")) {
            String formItemIndex = ParamUtil.getString(renderRequest, "formItemIndex");
            String fieldOptionsValue = ParamUtil.getString(renderRequest, "fieldOptionsIndex");
            boolean ignoreRequestValue = ParamUtil.getBoolean(renderRequest, "ignoreRequestValue");
            int fieldOptionsIndex = Integer.parseInt(fieldOptionsValue.substring(17));
            renderRequest.setAttribute("fieldOptionsIndex", fieldOptionsIndex);
            renderRequest.setAttribute("formItemIndex", formItemIndex);
            renderRequest.setAttribute("ignoreRequestValue", ignoreRequestValue);
            return "/jsp/option_field.jsp";
        } else {
            return "/jsp/configuration.jsp";
        }

    }

    /**
     * Save Form Items
     * 
     * @param actionRequest
     * @param defaultLocale
     * @param formId
     */
    private void saveFormItems(ActionRequest actionRequest, Locale defaultLocale, Long formId) {
        try {
            boolean updateFields = ParamUtil.getBoolean(actionRequest, "updateFields");

            boolean sendAsEmail = ParamUtil.getBoolean(actionRequest, "preferences--sendAsEmail--");
            boolean saveToDatabase = ParamUtil.getBoolean(actionRequest, "preferences--saveToDatabase--");
            if (!sendAsEmail && !saveToDatabase) {
                SessionErrors.add(actionRequest, "error-storage-not-choosen");
            }

            if (updateFields) {
                int i = 1;

                int[] formFieldsIndexes = StringUtil.split(ParamUtil.getString(actionRequest, "formFieldsIndexes"), 0);
                ServiceContext serviceContext = ServiceContextFactory.getInstance(FormItem.class.getName(), actionRequest);

                /* save form items */
                for (int formFieldsIndex : formFieldsIndexes) {
                    Map<Locale, String> fieldLabelMap = LocalizationUtil.getLocalizationMap(actionRequest, "fieldLabel" + formFieldsIndex);

                    if (Validator.isNull(fieldLabelMap.get(defaultLocale))) {
                        continue;
                    }

                    Long formItemId = ParamUtil.getLong(actionRequest, "formItemId" + formFieldsIndex);
                    String fieldType = ParamUtil.getString(actionRequest, "fieldType" + formFieldsIndex);
                    String validationType = ParamUtil.getString(actionRequest, "fieldInputType" + formFieldsIndex);
                    int inputTypeMaxLength = ParamUtil.getInteger(actionRequest, "inputMaxLength" + formFieldsIndex);
                    boolean fieldOptional = !ParamUtil.getBoolean(actionRequest, "fieldOptional" + formFieldsIndex);
                    String fieldValidationScript = ParamUtil.getString(actionRequest, "fieldValidationScript" + formFieldsIndex);
                    String fieldValidationErrorMessage = ParamUtil.getString(actionRequest, "fieldValidationErrorMessage" + formFieldsIndex);
                    Map<Locale, String> fieldHintMessageMap = LocalizationUtil.getLocalizationMap(actionRequest, "fieldHintMessage" + formFieldsIndex);
                    String formItemAttrClass = ParamUtil.getString(actionRequest, "formItemCssClass" + formFieldsIndex);
                    String labelAttrClass = ParamUtil.getString(actionRequest, "formLabelCssClass" + formFieldsIndex);
                    String inputAttrClass = ParamUtil.getString(actionRequest, "formInputCssClass" + formFieldsIndex);
                    Map<Locale, String> mandatoryErrorMessageMap = LocalizationUtil
                            .getLocalizationMap(actionRequest, "mandatoryErrorMessage" + formFieldsIndex);
                    Map<Locale, String> validationErrorMessageMap = LocalizationUtil.getLocalizationMap(actionRequest, "validationErrorMessage"
                            + formFieldsIndex);
                    Map<Locale, String> maxLengthErrorMessageMap = LocalizationUtil
                            .getLocalizationMap(actionRequest, "maxLengthErrorMessage" + formFieldsIndex);
                    String fieldValidationRegex = ParamUtil.getString(actionRequest, "fieldValidationRegex" + formFieldsIndex);
                    String formLayout = ParamUtil.getString(actionRequest, "formLayout" + formFieldsIndex);
                    Map<Locale, String> fieldDefaultValueMap = LocalizationUtil.getLocalizationMap(actionRequest, "fieldDefaultValue" + formFieldsIndex);
                    String dateFormat = ParamUtil.getString(actionRequest, "dateFormat" + formFieldsIndex);

                    if (Validator.isNotNull(fieldValidationScript) ^ Validator.isNotNull(fieldValidationErrorMessage)) {

                        SessionErrors.add(actionRequest, "validationDefinitionInvalid" + i);
                    }

                    if (!fieldType.equals(FormItemType.TEXT_FIELD.name())) {
                        validationType = FormItemType.NONE.name();
                        inputTypeMaxLength = 0;
                    }
                    
                    if (validationType.equals(ValidationType.PHONE_NUMBER.name())
                            || validationType.equals(ValidationType.EMAIL.name())
                            || validationType.equals(ValidationType.REGEX.name())) {
                        inputTypeMaxLength = 0;
                    }


                    FormItem formItem = FormItemLocalServiceUtil.save(formItemId, formId, fieldLabelMap, fieldType, fieldOptional, fieldValidationRegex,
                            validationType, i, inputTypeMaxLength, fieldHintMessageMap, serviceContext, formItemAttrClass, labelAttrClass, inputAttrClass,
                            mandatoryErrorMessageMap, validationErrorMessageMap, maxLengthErrorMessageMap, formLayout, fieldDefaultValueMap, dateFormat);

                    // options handler
                    int optionsIndex = ParamUtil.getInteger(actionRequest, "fieldOptionsIndex" + formFieldsIndex);
                    for (int index = 0; index <= optionsIndex; index++) {
                        Long formItemOptionId = ParamUtil.getLong(actionRequest, "formItemOptionId" + index + "_" + formFieldsIndex);
                        String optionValue = ParamUtil.getString(actionRequest, "fieldOptionsValue" + index + "_" + formFieldsIndex);
                        Map<Locale, String> optionLabelMap = LocalizationUtil.getLocalizationMap(actionRequest, "fieldOptionsLabel" + index + "_"
                                + formFieldsIndex);
                        if (Validator.isNull(optionValue) || Validator.isNull(optionLabelMap.get(defaultLocale))) {
                            continue;
                        }
                        FormItemOptionLocalServiceUtil.save(formItemOptionId, formItem.getFormItemId(), optionValue, optionLabelMap, serviceContext);
                    }

                    i++;
                }

                /* hard delete form item options */
                String[] deletedFormItemOptionIds = ParamUtil.getString(actionRequest, "deletedFormItemOptionIds").split(",");
                if (deletedFormItemOptionIds[0] != "") {
                    for (String formItemOptionId : deletedFormItemOptionIds) {
                        FormItemOptionLocalServiceUtil.deleteFormItemOption(Long.parseLong(formItemOptionId));
                    }
                }

                /* soft delete form items */
                String[] deletedFormItemIds = ParamUtil.getString(actionRequest, "deletedFormItemIds").split(",");
                if (deletedFormItemIds[0] != "") {
                    for (String formItemId : deletedFormItemIds) {
                        // hard delete form item options
                        FormItemOptionLocalServiceUtil.deleteFormItemOptionByFormItem(Long.parseLong(formItemId));

                        FormItemLocalServiceUtil.delete(Long.parseLong(formItemId), serviceContext);
                    }
                }

            }
        } catch (Exception e) {
            log.error("Exception while update form items: " + e.getMessage(), e);
        }

    }

}
