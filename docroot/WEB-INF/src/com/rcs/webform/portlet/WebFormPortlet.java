package com.rcs.webform.portlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rcs.webform.common.JsonResponse;
import com.rcs.webform.common.util.EntityDtoConverter;
import com.rcs.webform.common.util.WebFormUtil;
import com.rcs.webform.entity.dto.FormDTO;
import com.rcs.webform.model.Form;
import com.rcs.webform.model.FormItem;
import com.rcs.webform.model.FormToPorletMap;
import com.rcs.webform.service.FormItemLocalServiceUtil;
import com.rcs.webform.service.FormLocalServiceUtil;
import com.rcs.webform.service.FormToPorletMapLocalServiceUtil;

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
            
            Form form = FormLocalServiceUtil.getForm(formToPorletMap.getFormId());
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
        
        String portletId = PortalUtil.getPortletId(actionRequest);
        PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletId);
        
        boolean requireCaptcha = false;
        int onSubmitValue = GetterUtil.getInteger(preferences.getValue("onSubmitValue", "1")); // 1: showing success message, 2: redirect to specified URL
        boolean sendAsEmail = GetterUtil.getBoolean(preferences.getValue("sendAsEmail", StringPool.BLANK));
        boolean saveToDatabase = GetterUtil.getBoolean(preferences.getValue("saveToDatabase", StringPool.BLANK));
        
        Form form = null;
        String successUrl = "";
        
        //Get form
        try {
        	form = WebFormUtil.getPortletForm(portletId);
		} catch (Exception e) {
		}
        
        if (form!=null){
        	requireCaptcha = form.getUseCaptcha();
        	if (onSubmitValue==2) 
        		successUrl = form.getSuccessURL();
        	
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
        
        if (validationErrors.isEmpty()){
        	boolean emailSuccess = true;
        	boolean databaseSuccess = true;
        	
        	// Send submitted form data as email
            if (sendAsEmail){
            	//emailSuccess = sendAsEmail();
            }
            
            // Save submitted form data to database
            if (saveToDatabase) {
            	//databaseSuccess = saveToDatabase();
            }
            
            // On successfully submitted value
            // Including successfully send as email and save to database
            if (emailSuccess && databaseSuccess){
            	if (onSubmitValue == 1){
                	SessionMessages.add(actionRequest, "success");
                } else if (onSubmitValue == 2){
                	SessionMessages.add(actionRequest, portletId + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
                }
            } else {
            	SessionErrors.add(actionRequest, "error");
            }
            
        } else {
        	// --Build form validation error here--
        }
        
        if (SessionErrors.isEmpty(actionRequest) && Validator.isNotNull(successUrl)){
        	actionResponse.sendRedirect(successUrl);
        }
        
        
    }
    
    public void serveResource(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse){
    	try {
			CaptchaUtil.serveImage(resourceRequest, resourceResponse);
		} catch (Exception ignored) {
		}
    }
    
    protected boolean saveToDatabase(){
    	return true;
    }
    
    protected boolean sendAsEmail(){
    	return true;
    }
}
