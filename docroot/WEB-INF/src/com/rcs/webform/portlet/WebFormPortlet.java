package com.rcs.webform.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rcs.webform.common.JsonResponse;
import com.rcs.webform.common.enums.FormItemType;
import com.rcs.webform.common.util.EntityDtoConverter;
import com.rcs.webform.common.util.WebFormUtil;
import com.rcs.webform.entity.dto.FormDTO;
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
        JsonResponse jsonResponse = new JsonResponse();
        String portletId = PortalUtil.getPortletId(renderRequest);
        FormDTO formDto = new FormDTO();
        try {
            FormToPorletMap formToPorletMap = FormToPorletMapLocalServiceUtil.getFormToPortletMapByPortletId(portletId);

            Form form = FormLocalServiceUtil.getFormByFormId(formToPorletMap.getFormId());
            List<FormItem> formItems = FormItemLocalServiceUtil.getFormItemsByFormId(form.getFormId());

            formDto = EntityDtoConverter.formEntityToDto(form, formItems, renderRequest.getLocale());
        } catch (Exception e) {
            log.info("No form data found on this portlet. Default form information is used.");
            formDto = WebFormUtil.createDefaultFormInformation();
        }
        jsonResponse.setData(formDto);
        jsonResponse.setMessage(renderRequest.getLocale().getDisplayCountry());
        renderRequest.setAttribute("Data", jsonResponse);

        super.doView(renderRequest, renderResponse);
    }

    public void submitForm(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        log.info("##### Processing submitted form data #####");

        ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String portletId = PortalUtil.getPortletId(actionRequest);
        PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletId);

        boolean requireCaptcha = false;
        int onSubmitValue = GetterUtil.getInteger(preferences.getValue("onSubmitValue", "1")); // 1: showing success message, 2: redirect to specified URL
        boolean sendAsEmail = GetterUtil.getBoolean(preferences.getValue("sendAsEmail", StringPool.BLANK));
        boolean saveToDatabase = GetterUtil.getBoolean(preferences.getValue("saveToDatabase", StringPool.BLANK));

        Form form = null;
        String successUrl = "";

        // Get form
        try {
            form = WebFormUtil.getPortletForm(portletId);
        } catch (Exception e) {
        }

        if (form != null) {
            requireCaptcha = form.getUseCaptcha();
            if (onSubmitValue == 2) successUrl = form.getSuccessURL();

        }

        // Captcha checking
        if (requireCaptcha) {
            try {
                CaptchaUtil.check(actionRequest);
            } catch (CaptchaTextException cte) {
                SessionErrors.add(actionRequest, CaptchaTextException.class.getName());
                return;
            }
        }

        // --Build submitted form data here--

        // Validate submitted form data
        Set<String> validationErrors = new HashSet<String>();
        try {
            // --Add validation method here--
        } catch (Exception e) {
            SessionErrors.add(actionRequest, "validationScriptError", e.getMessage().trim());
            return;
        }

        if (validationErrors.isEmpty()) {
            boolean emailSuccess = true;
            boolean databaseSuccess = true;

            // Send submitted form data as email
            if (sendAsEmail) {
                emailSuccess = sendAsEmail(preferences, portletId, actionRequest, themeDisplay.getCompanyId());
            }

            // Save submitted form data to database
            if (saveToDatabase) {
                databaseSuccess = saveToDatabase(actionRequest);
            }

            // On successfully submitted value
            // Including successfully send as email and save to database
            if (emailSuccess && databaseSuccess) {
                if (onSubmitValue == 1) {
                    SessionMessages.add(actionRequest, "success");
                } else if (onSubmitValue == 2) {
                    SessionMessages.add(actionRequest, portletId + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
                }
            } else {
                SessionErrors.add(actionRequest, "error");
            }

        } else {
            // --Build form validation error here--
        }

        if (SessionErrors.isEmpty(actionRequest) && Validator.isNotNull(successUrl)) {
            actionResponse.sendRedirect(successUrl);
        }

    }

    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
        try {
            CaptchaUtil.serveImage(resourceRequest, resourceResponse);
        } catch (Exception ignored) {
        }
    }

    protected boolean saveToDatabase(ActionRequest actionRequest) {
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
            return true;
        } catch (Exception e) {
            log.error("Exception while submitting user input : " + e.getMessage(), e);
            return false;
        }
    }

    protected boolean sendAsEmail(PortletPreferences preferences, String portletId, 
    		ActionRequest actionRequest, long companyId) {
        try {
            String emailAdresses = preferences.getValue("emailAddress", StringPool.BLANK);
            String subject = preferences.getValue("subject", StringPool.BLANK);
            String body = getMailBody(portletId, actionRequest);
            
            if (Validator.isNull(emailAdresses)){
                log.error("Email could not be sent. No email address is configured.");
                return false;
            }
            
            if (Validator.isNull(body)){
            	log.error("Email could not be sent. Empty email body.");
                return false;
            }
            
            InternetAddress emailAddressFrom = new InternetAddress(
            		WebFormUtil.getEmailFromAddress(preferences, companyId), 
            		WebFormUtil.getEmailFromName(preferences, companyId));
            MailMessage mailMessage = new MailMessage(emailAddressFrom, subject, body, false);
            InternetAddress[] toAddresses = InternetAddress.parse(emailAdresses);
            mailMessage.setTo(toAddresses);
            
            MailServiceUtil.sendEmail(mailMessage);
        } catch (Exception e) {
            log.error("Email could not be sent: " + e.getMessage(), e);
            return false;
        }
        return true;
    }
    
    protected String getMailBody(String portletId, ActionRequest actionRequest){
    	String mailBody = "";
    	try {
			StringBundler sb = new StringBundler();
			
			Form form = WebFormUtil.getPortletForm(portletId);
			List<FormItem> formItems = FormItemLocalServiceUtil.getFormItemByFormId(form.getFormId());
			
			for (FormItem formItem : formItems){
				String userInput = ParamUtil.get(actionRequest, formItem.getLabel(actionRequest.getLocale()), "");
				
				sb.append(formItem.getLabel());
				sb.append(" : ");
				
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
                        		actionRequest.getLocale())];
                    }
                }
				
				sb.append(userInput);
				sb.append(CharPool.NEW_LINE);
			}
			
			mailBody = sb.toString();
		} catch (Exception e) {
			log.error("Exception while getting mail body : " + e.getMessage(), e);
		}
    	return mailBody;
    }

    private int getOptionIdxInDefaultLanguage(Map<Locale, String> optionsMap, String userInput, Locale userLocale) {
        ArrayList<String> options = new ArrayList<String>(Arrays.asList(optionsMap.get(userLocale).split(",")));
        return options.indexOf(userInput);
    }
}
