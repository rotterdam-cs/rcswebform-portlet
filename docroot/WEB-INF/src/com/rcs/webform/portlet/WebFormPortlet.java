package com.rcs.webform.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.filter.ActionFilter;

import sun.util.logging.resources.logging;

import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rcs.webform.action.ConfigurationActionImpl;
import com.rcs.webform.common.JsonResponse;
import com.rcs.webform.common.util.EntityDtoConverter;
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
        try {
            JsonResponse jsonResponse = new JsonResponse();
            String portletId = PortalUtil.getPortletId(renderRequest);
            log.info("Portlet id : "+portletId);
                       
            FormToPorletMap formToPorletMap = FormToPorletMapLocalServiceUtil.getFormToPortletMapByPortletId(portletId);
            
            Form form = FormLocalServiceUtil.getForm(formToPorletMap.getFormId());
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
        
    }
    
    public void serveResource(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse){
    	try {
			CaptchaUtil.serveImage(resourceRequest, resourceResponse);
		} catch (Exception ignored) {
		}
    }
}
