package com.rcs.webform.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rcs.webform.common.JsonResponse;
import com.rcs.webform.common.util.EntityDtoConverter;
import com.rcs.webform.model.Form;
import com.rcs.webform.model.FormItem;
import com.rcs.webform.model.FormToPorletMap;
import com.rcs.webform.service.FormItemLocalServiceUtil;
import com.rcs.webform.service.FormLocalServiceUtil;
import com.rcs.webform.service.FormToPorletMapLocalServiceUtil;
import com.sun.corba.se.spi.orb.StringPair;

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
            String portletId = PortalUtil.getPortletId(actionRequest);
            log.info("Portlet id : " + portletId);

            FormToPorletMap formToPorletMap = FormToPorletMapLocalServiceUtil.getFormToPortletMapByPortletId(portletId);

            Form form = FormLocalServiceUtil.getForm(formToPorletMap.getFormId());
            List<FormItem> formItems = FormItemLocalServiceUtil.getFormItemByFormId(form.getFormId());
            
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    private int getOptionIdxInDefaultLanguage(Map<Locale, String> optionsMap, String userInput, Locale userLocale){
        ArrayList<String> options = new ArrayList<String>(Arrays.asList(optionsMap.get(userInput).split(",")));
        return options.indexOf(userInput); 
    }
}
