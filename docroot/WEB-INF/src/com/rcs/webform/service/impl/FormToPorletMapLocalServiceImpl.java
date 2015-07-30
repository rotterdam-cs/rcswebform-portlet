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
import com.rcs.webform.model.FormToPorletMap;
import com.rcs.webform.service.base.FormToPorletMapLocalServiceBaseImpl;
import com.rcs.webform.service.persistence.FormToPorletMapUtil;

/**
 * The implementation of the form to porlet map local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.rcs.webform.service.FormToPorletMapLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 * </p>
 *
 * @author ryusuf
 * @see com.rcs.webform.service.base.FormToPorletMapLocalServiceBaseImpl
 * @see com.rcs.webform.service.FormToPorletMapLocalServiceUtil
 */
public class FormToPorletMapLocalServiceImpl extends FormToPorletMapLocalServiceBaseImpl {

    private static Log log = LogFactoryUtil.getLog(FormToPorletMapLocalServiceImpl.class);

    /*
     * NOTE FOR DEVELOPERS:
     * 
     * Never reference this interface directly. Always use {@link com.rcs.webform.service.FormToPorletMapLocalServiceUtil} to access the form to porlet map
     * local service.
     */

    public FormToPorletMap getFormToPortletMapByPortletId(final String portletId) {
        try {
            return FormToPorletMapUtil.findByPortletId(portletId);
        } catch (Exception e) {
            log.error("Exception while getting form to portlet map by Portlet id [" + portletId + "] : " + e.getMessage());
            return null;
        }
    }

    public FormToPorletMap save(Long formToPortletId, String namespace, Long formId, ServiceContext serviceContext) {
        User user = null;
        FormToPorletMap formToPortletMap = null;
        Date now = new Date();

        try {
            user = userLocalService.getUserById(serviceContext.getUserId());
            if (formToPortletId == null) {
                formToPortletId = counterLocalService.increment(FormToPorletMap.class.getName());
                formToPortletMap = formToPorletMapPersistence.create(formToPortletId);
            } else {
            	formToPortletMap = formToPorletMapPersistence.findByPrimaryKey(formToPortletId);
            }
            
            formToPortletMap.setActive(true);
            formToPortletMap.setCreationDate(serviceContext.getCreateDate(now));
            formToPortletMap.setModificationDate(serviceContext.getCreateDate(now));
            formToPortletMap.setModificationUser(user.getFullName());
            formToPortletMap.setGroupId(serviceContext.getScopeGroupId());
            formToPortletMap.setCompanyId(serviceContext.getCompanyId());
            formToPortletMap.setUserId(user.getUserId());
            formToPortletMap.setUserName(user.getEmailAddress());
            formToPortletMap.setFormId(formId);
            formToPortletMap.setPortletId(namespace);

            formToPorletMapPersistence.update(formToPortletMap);
        } catch (Exception e) {
            log.error("Exception while adding form to portlet map: ", e);
        }

        return formToPortletMap;
    }

}