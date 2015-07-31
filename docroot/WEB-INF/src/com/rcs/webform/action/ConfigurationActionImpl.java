package com.rcs.webform.action;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.rcs.webform.model.Form;
import com.rcs.webform.model.FormItem;
import com.rcs.webform.model.FormToPorletMap;
import com.rcs.webform.service.FormItemLocalServiceUtil;
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

		//Save form configuration to database
		ServiceContext formServiceContext = ServiceContextFactory.getInstance(Form.class.getName(), actionRequest);
		Long formId = null;
		if(ParamUtil.getLong(actionRequest, "formId")!=0){
			formId = ParamUtil.getLong(actionRequest, "formId");
		}
		boolean useCaptcha = ParamUtil.getBoolean(actionRequest, "requireCaptcha");
		String successUrl = ParamUtil.getInteger(actionRequest, "onSubmitData")==2 ? ParamUtil.getString(actionRequest, "submitSuccessURL") : "";
		String formAttrId = ParamUtil.getString(actionRequest, "formCssId");
		String formAttrClass = ParamUtil.getString(actionRequest, "formCssClass");
		String submitAttrId = ParamUtil.getString(actionRequest, "submitCssId");
		String submitAttrClass = ParamUtil.getString(actionRequest, "submitCssClass");
		
		Map<Locale, String> titleMap = LocalizationUtil.getLocalizationMap(actionRequest, "title");
		Map<Locale, String> descMap = LocalizationUtil.getLocalizationMap(actionRequest, "description");
		Map<Locale, String> successMsgMap = ParamUtil.getInteger(actionRequest, "onSubmitData")==1 ? LocalizationUtil.getLocalizationMap(actionRequest, "submitSuccessMsg") : null;
		Map<Locale, String> submitLabelMap = LocalizationUtil.getLocalizationMap(actionRequest, "submitBtnLabel");
		
		Form savedForm = FormLocalServiceUtil.save(formId, formServiceContext, formAttrId, formAttrClass, titleMap, descMap, useCaptcha, successMsgMap, successUrl, submitLabelMap, submitAttrId, submitAttrClass);
		
		//Save form-portlet mapping to database
		ServiceContext formPortletMappingServiceContext = ServiceContextFactory.getInstance(FormToPorletMap.class.getName(), actionRequest);
		Long formToPortletId = null;
		if (ParamUtil.getLong(actionRequest, "formToPortletMapId")!=0){
			formToPortletId = ParamUtil.getLong(actionRequest, "formToPortletMapId");
		}
		FormToPorletMapLocalServiceUtil.save(formToPortletId, portletResource, savedForm.getFormId(), formPortletMappingServiceContext);

		if(savedForm.getFormId() != 0){
			saveFormItems(actionRequest, defaultLocale, savedForm.getFormId());
		}
		
		if (SessionErrors.isEmpty(actionRequest)) {
			preferences.store();
		}

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	public String render(PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		String cmd = ParamUtil.getString(renderRequest, Constants.CMD);

		if (cmd.equals(Constants.ADD)) {
			return "/jsp/edit_field.jsp";
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
	private void saveFormItems(ActionRequest actionRequest, Locale defaultLocale, Long formId){
		try {
			boolean updateFields = ParamUtil.getBoolean(actionRequest, "updateFields");
	
			if (updateFields) {
				int i = 1;
	
				int[] formFieldsIndexes = StringUtil.split(ParamUtil.getString(actionRequest, "formFieldsIndexes"), 0);
	
				for (int formFieldsIndex : formFieldsIndexes) {
					Map<Locale, String> fieldLabelMap = LocalizationUtil.getLocalizationMap(actionRequest, "fieldLabel" + formFieldsIndex);
	
					if (Validator.isNull(fieldLabelMap.get(defaultLocale))) {
						continue;
					}
					
					Long formItemId = ParamUtil.getLong(actionRequest, "formItemId" + formFieldsIndex);
					String fieldType = ParamUtil.getString(actionRequest, "fieldType" + formFieldsIndex).split(":")[0];
					String validationType = ParamUtil.getString(actionRequest, "fieldType" + formFieldsIndex).split(":")[1];
					boolean fieldOptional = ParamUtil.getBoolean(actionRequest, "fieldOptional" + formFieldsIndex);
					Map<Locale, String> fieldOptionsMap = LocalizationUtil.getLocalizationMap(actionRequest, "fieldOptions" + formFieldsIndex);
					String fieldValidationScript = ParamUtil.getString(actionRequest, "fieldValidationScript" + formFieldsIndex);
					String fieldValidationErrorMessage = ParamUtil.getString(actionRequest, "fieldValidationErrorMessage" + formFieldsIndex);
					
					if (Validator.isNotNull(fieldValidationScript) ^ Validator.isNotNull(fieldValidationErrorMessage)) {
	
						SessionErrors.add(actionRequest, "validationDefinitionInvalid" + i);
					}
	
					ServiceContext serviceContext = ServiceContextFactory.getInstance(FormItem.class.getName(), actionRequest);
					FormItemLocalServiceUtil.save(formItemId, formId, fieldLabelMap, fieldType, fieldOptionsMap, fieldOptional,
							fieldValidationScript, validationType, fieldValidationErrorMessage, serviceContext);
	
					i++;
				}
	
				if (!SessionErrors.isEmpty(actionRequest)) {
					return;
				}
	
			}
		} catch (Exception e) {
	        log.error("Exception while update form items: " + e.getMessage(), e);
	    }
		
	}
	
}
