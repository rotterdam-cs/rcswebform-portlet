package com.rcs.webform.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rcs.webform.common.JsonResponse;
import com.rcs.webform.common.enums.FormItemType;
import com.rcs.webform.common.util.EntityDtoConverter;
import com.rcs.webform.model.Form;
import com.rcs.webform.model.FormItem;
import com.rcs.webform.model.FormToPorletMap;
import com.rcs.webform.model.SubmittedData;
import com.rcs.webform.service.FormItemLocalServiceUtil;
import com.rcs.webform.service.FormLocalServiceUtil;
import com.rcs.webform.service.FormToPorletMapLocalServiceUtil;
import com.rcs.webform.service.SubmittedDataLocalServiceUtil;
import com.rcs.webform.service.persistence.SubmittedDataPK;

/**
 * Portlet implementation class WebFormPortlet
 */
public class WebFormPortlet extends MVCPortlet {

    private static Log log = LogFactoryUtil.getLog(WebFormPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        try {
            JsonResponse jsonResponse = new JsonResponse();
            String portletId = PortalUtil.getPortletId(renderRequest);
            log.info("Portlet id : " + portletId);

            FormToPorletMap formToPorletMap = FormToPorletMapLocalServiceUtil.getFormToPortletMapByPortletId(portletId);

            Form form = FormLocalServiceUtil.getFormByFormId(formToPorletMap.getFormId());
            List<FormItem> formItems = FormItemLocalServiceUtil.getFormItemByFormId(form.getFormId());

            jsonResponse.setMessage(renderRequest.getLocale().getDisplayCountry());
            jsonResponse.setData(EntityDtoConverter.formEntityToDto(form, formItems, renderRequest.getLocale()));
            renderRequest.setAttribute("Data", jsonResponse);
            renderRequest.setAttribute("Form", EntityDtoConverter.formEntityToDto(form, formItems, renderRequest.getLocale()));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        super.doView(renderRequest, renderResponse);
    }

    public void submitForm(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
        try {
            saveSubmittedData(actionRequest);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
        try {
            CaptchaUtil.serveImage(resourceRequest, resourceResponse);
        } catch (Exception ignored) {
        }
    }

    private void saveSubmittedData(ActionRequest actionRequest) {
        try {
            String portletId = PortalUtil.getPortletId(actionRequest);
            Date now = new Date();
            Locale userLocale = actionRequest.getLocale();

            FormToPorletMap formToPorletMap = FormToPorletMapLocalServiceUtil.getFormToPortletMapByPortletId(portletId);
            Form form = FormLocalServiceUtil.getForm(formToPorletMap.getFormId());
            List<FormItem> formItems = FormItemLocalServiceUtil.getFormItemByFormId(form.getFormId());

            long formId = form.getFormId();
            long submittedDataId = CounterLocalServiceUtil.increment(SubmittedData.class.getName());

            for (FormItem formItem : formItems) {

                if (!formItem.getType().equals(FormItemType.SECTION.toString())) {

                    SubmittedDataPK submittedDataPK = new SubmittedDataPK(submittedDataId, formId, portletId, formItem.getFormItemId());
                    SubmittedData submittedData = SubmittedDataLocalServiceUtil.createSubmittedData(submittedDataPK);
                    submittedData.setActive(true);
                    submittedData.setCreationDate(now);
                    submittedData.setModificationDate(now);
                    
                    // clean user input
                    String userInput = ParamUtil.get(actionRequest, formItem.getLabel(actionRequest.getLocale()), "");
                    if (formItem.getType().equals(FormItemType.CHECKBOX.toString())) {
                        StringBuilder cbInputBuilder = new StringBuilder();
                        for (String entry : Arrays.asList(ParamUtil.getParameterValues(actionRequest, formItem.getLabel(actionRequest.getLocale())))) {
                            cbInputBuilder.append(entry);
                            cbInputBuilder.append(",");
                        }
                        userInput = cbInputBuilder.substring(0, cbInputBuilder.lastIndexOf(","));
                    } else {
                        if (userInput == null) {
                            userInput = "";
                        } else if (formItem.getType().equals(FormItemType.OPTIONS.toString())
                                || formItem.getType().equals(FormItemType.RADIO_BUTTON.toString())) {
                            userInput = formItem.getOptions(Locale.ENGLISH).split(",")[getOptionIdxInDefaultLanguage(formItem.getOptionsMap(), userInput,
                                    userLocale)];
                        }
                    }
                    submittedData.setUserInput(userInput);
                    SubmittedDataLocalServiceUtil.updateSubmittedData(submittedData);
                }
            }
            if (!SessionErrors.isEmpty(actionRequest)) {
                return;
            }
        } catch (Exception e) {
            log.error("Exception while submitting user input : " + e.getMessage(), e);
        }
    }

    private int getOptionIdxInDefaultLanguage(Map<Locale, String> optionsMap, String userInput, Locale userLocale) {
        ArrayList<String> options = new ArrayList<String>(Arrays.asList(optionsMap.get(userLocale).split(",")));
        return options.indexOf(userInput);
    }
}
