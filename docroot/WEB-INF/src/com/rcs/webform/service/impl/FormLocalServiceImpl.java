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

import java.util.Date;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.rcs.webform.model.Form;
import com.rcs.webform.service.base.FormLocalServiceBaseImpl;

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
		User user = null;
		Form form = null;
		Date now = new Date();
		
		try {
			user = userLocalService.getUserById(serviceContext.getUserId());
			if(formId == null){
				formId = counterLocalService.increment(Form.class.getName());
			}
			form = formPersistence.create(formId);
			form.setActive(true);
			form.setCreationDate(serviceContext.getCreateDate(now));
			form.setModificationDate(serviceContext.getCreateDate(now));
			form.setModificationUser(user.getFullName());
			form.setGroupId(serviceContext.getScopeGroupId());
			form.setCompanyId(serviceContext.getCompanyId());
			form.setUserId(user.getUserId());
			form.setUserName(user.getEmailAddress());
			form.setFormAttrId("");
			form.setFormAttrClass("");
			form.setTitle(title);
			form.setDesc(description);
			form.setUseCaptcha(useCaptcha);
			form.setSuccessMessage(successMessage);
			form.setSuccessURL(successUrl);
			form.setSubmitLabel(submitLabel);
			form.setSubmitAttrClass("");
			form.setSubmitAttrId("");
			
			formPersistence.update(form);
		} catch (Exception e) {
			log.error("Exception while adding form: " + e.getMessage(), e);
		}
		
		return form;
	}
	
}