/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rcs.webform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.rcs.webform.model.Form;
import com.rcs.webform.model.FormItem;
import com.rcs.webform.service.base.FormLocalServiceBaseImpl;
import com.rcs.webform.service.persistence.FormUtil;

/**
 * The implementation of the form local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rcs.webform.service.FormLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ryusuf
 * @see com.rcs.webform.service.base.FormLocalServiceBaseImpl
 * @see com.rcs.webform.service.FormLocalServiceUtil
 */
public class FormLocalServiceImpl extends FormLocalServiceBaseImpl {
	
	private static Log log = LogFactoryUtil.getLog(FormLocalServiceImpl.class);
	
	public Form add(Long formId, ServiceContext serviceContext, String title, String description, boolean useCaptcha,
			String successMessage, String successUrl, String submitLabel){
		return null;
	}
	
	public Form save(Long formId, ServiceContext serviceContext, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, 
			boolean useCaptcha, Map<Locale, String> successMessageMap, String successUrl, Map<Locale, String> submitLabelMap){
		return null;
	}
	
	public Form save(Long formId, ServiceContext serviceContext, String formAttrId, String formAttrClass, Map<Locale, String> titleMap, 
			Map<Locale, String> descriptionMap, boolean useCaptcha, Map<Locale, String> successMessageMap, String successUrl, 
			Map<Locale, String> submitLabelMap, String submitAttrId, String submitAttrclass){
		User user = null;
		Form form = null;
		Date now = new Date();
		
		try {
			user = userLocalService.getUserById(serviceContext.getUserId());
			if(formId == null){
				formId = counterLocalService.increment(Form.class.getName());
				form = formPersistence.create(formId);
			} else {
				form = formPersistence.findByPrimaryKey(formId);
			}
			
			form.setActive(true);
			form.setCreationDate(serviceContext.getCreateDate(now));
			form.setModificationDate(serviceContext.getCreateDate(now));
			form.setModificationUser(user.getFullName());
			form.setGroupId(serviceContext.getScopeGroupId());
			form.setCompanyId(serviceContext.getCompanyId());
			form.setUserId(user.getUserId());
			form.setUserName(user.getEmailAddress());
			form.setFormAttrId(formAttrId);
			form.setFormAttrClass(formAttrClass);
			form.setTitleMap(titleMap);
			form.setDescMap(descriptionMap);
			form.setUseCaptcha(useCaptcha);
			if(successMessageMap==null){
				form.setSuccessMessage("");
			} else {
				form.setSuccessMessageMap(successMessageMap);
			}
			form.setSuccessURL(successUrl);
			form.setSubmitLabelMap(submitLabelMap);
			form.setSubmitAttrClass(submitAttrclass);
			form.setSubmitAttrId(submitAttrId);
			
			formPersistence.update(form);
		} catch (Exception e) {
			log.error("Exception while saving form: " + e.getMessage(), e);
		}
		
		return form;
	}
	
    public Form getFormByFormId(long formId) {
        try {
            return FormUtil.findByFormIdAndActive(formId);
        } catch (Exception e) {
            log.error("Exception while getting form by id [" + formId + "] : " + e.getMessage());
            return null;
        }
    }

	
}