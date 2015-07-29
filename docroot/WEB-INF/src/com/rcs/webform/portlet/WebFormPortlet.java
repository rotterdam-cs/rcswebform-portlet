package com.rcs.webform.portlet;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rcs.webform.common.JsonResponse;
import com.rcs.webform.common.util.EntityDtoConverter;
import com.rcs.webform.model.Form;
import com.rcs.webform.model.FormItem;
import com.rcs.webform.service.FormItemLocalServiceUtil;
import com.rcs.webform.service.FormLocalServiceUtil;

/**
 * Portlet implementation class WebFormPortlet
 */
public class WebFormPortlet extends MVCPortlet {
 
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        try {
            JsonResponse jsonResponse = new JsonResponse();
            
            Form form = FormLocalServiceUtil.getForm(0);
            for(Map.Entry<Locale, String> entry : form.getDescMap().entrySet()) 
            System.out.println(entry.getKey().getDisplayCountry() + " : "+entry.getValue());
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
}
