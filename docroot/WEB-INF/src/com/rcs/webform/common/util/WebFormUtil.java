package com.rcs.webform.common.util;

import java.util.List;

import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;
import com.rcs.webform.entity.dto.FormDTO;
import com.rcs.webform.model.Form;
import com.rcs.webform.model.FormItem;
import com.rcs.webform.model.FormItemOption;
import com.rcs.webform.model.FormToPorletMap;
import com.rcs.webform.service.FormItemLocalServiceUtil;
import com.rcs.webform.service.FormItemOptionLocalServiceUtil;
import com.rcs.webform.service.FormLocalServiceUtil;
import com.rcs.webform.service.FormToPorletMapLocalServiceUtil;


/**
 * Web form utilities class
 * 
 * @author tito
 * @author mfauzan_abdi
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
	
	/**
	 * get FormItems Form
	 * 
	 * @param portletId
	 * @return
	 */
	public static List<FormItem> getPortletFormItems(String portletId){
		try {
			FormToPorletMap formToPorletMap = getFormToPortletMap(portletId);
			return FormItemLocalServiceUtil.getFormItemsByFormId(formToPorletMap.getFormId());
		} catch (Exception ignored) {
		}
		return null;
	}
	
	public static FormDTO createDefaultFormInformation(){
		FormDTO formDto = new FormDTO();
		formDto.setTitle("Title");
		formDto.setDesc("Description");
		formDto.setSuccessMessage("Successfully saved the form data");
		formDto.setSuccessURL("");
		formDto.setUseCaptcha(false);
		formDto.setSubmitLabel("Submit");
		formDto.setSubmitAttrClass("btn btn-primary");
		return formDto;
	}
	
	public static String getEmailFromAddress(PortletPreferences preferences, long companyId){
		try {
			return PortalUtil.getEmailFromAddress(preferences, companyId, StringPool.BLANK);
		} catch (SystemException e) {
			return StringPool.BLANK;
		}
		
	}
	
	public static String getEmailFromName(PortletPreferences preferences, long companyId) {
		try {
			return PortalUtil.getEmailFromName(preferences, companyId, StringPool.BLANK);
		} catch (SystemException e) {
			return StringPool.BLANK;
		}
	}
	
	public static List<Form> getAllForms(){
		try {
			return FormLocalServiceUtil.getForms(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			return null;
		}
		
	}

/**
	 * get FormItemOptions 
	 * 
	 * @param formItemId
	 * @return
	 */
	public static List<FormItemOption> getFormItemOptions(Long formItemId){
		try {
			return FormItemOptionLocalServiceUtil.getFormItemOptionsByFormItemId(formItemId);
		} catch (Exception ignored) {
		}
		return null;
	}
	
}
