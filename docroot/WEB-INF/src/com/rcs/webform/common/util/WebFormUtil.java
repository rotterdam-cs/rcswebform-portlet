package com.rcs.webform.common.util;

import com.rcs.webform.model.Form;
import com.rcs.webform.model.FormToPorletMap;
import com.rcs.webform.service.FormLocalServiceUtil;
import com.rcs.webform.service.FormToPorletMapLocalServiceUtil;


/**
 * Web form utilities class
 * 
 * @author tito
 *
 */
public class WebFormUtil {
	
	public static Form getPortletForm(String portletId){
		try {
			FormToPorletMap formToPorletMap = getFormToPortletMap(portletId);
			return FormLocalServiceUtil.getForm(formToPorletMap.getFormId());
		} catch (Exception ignored) {
		}
		return null;
	}
	
	public static FormToPorletMap getFormToPortletMap(String portletId){
		try {
			return FormToPorletMapLocalServiceUtil.getFormToPortletMapByPortletId(portletId);
		} catch (Exception ignored) {
		}
		return null;
	}
	
}
