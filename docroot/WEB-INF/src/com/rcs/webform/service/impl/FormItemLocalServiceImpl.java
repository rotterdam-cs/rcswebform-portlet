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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.rcs.webform.model.FormItem;
import com.rcs.webform.service.base.FormItemLocalServiceBaseImpl;
import com.rcs.webform.service.persistence.FormItemUtil;

/**
 * The implementation of the form item local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.rcs.webform.service.FormItemLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 * </p>
 * 
 * @author ryusuf
 * @author mfauzan_abdi
 * @see com.rcs.webform.service.base.FormItemLocalServiceBaseImpl
 * @see com.rcs.webform.service.FormItemLocalServiceUtil
 */
public class FormItemLocalServiceImpl extends FormItemLocalServiceBaseImpl {

    private static Log log = LogFactoryUtil.getLog(FormItemLocalServiceImpl.class);

    /**
     * Add Form Item
     * 
     * @param formItemId
     * @param formId
     * @param label
     * @param type
     * @param options
     * @param mandatory
     * @param validationRegexValue
     * @param validationType
     * @param errorValidationMessage
     * @param serviceContext
     * @return
     */
    public FormItem add(Long formItemId, Long formId, String label, String type, String options, boolean mandatory, String validationRegexValue,
            String validationType, String errorValidationMessage, ServiceContext serviceContext) {

        User user = null;
        FormItem formItem = null;
        Date now = new Date();
        try {
            user = userLocalService.getUserById(serviceContext.getUserId());
            if (formItemId == null) {
                formItemId = counterLocalService.increment(FormItem.class.getName());
            }
            formItem = formItemPersistence.create(formItemId);
            formItem.setFormItemId(formItemId);
            formItem.setActive(true);
            formItem.setCreationDate(serviceContext.getCreateDate(now));
            formItem.setModificationDate(serviceContext.getModifiedDate(now));
            formItem.setModificationUser(user.getFullName());
            formItem.setFormId(formId);
            formItem.setFormItemAttrId("");
            formItem.setFormItemAttrClass("");
            formItem.setLabel(label);
            formItem.setLabelAttrId("");
            formItem.setLabelAttrClass("");
            formItem.setInputAttrId("");
            formItem.setInputAttrClass("");
            formItem.setType(type);
            formItem.setOptions(options);
            formItem.setMandatory(mandatory);
            formItem.setDefaultValue("");
            formItem.setOrder(0);
            formItem.setValidationType(validationType);
            formItem.setValidationRegexValue(validationRegexValue);
            formItem.setErrorMandatoryMessage("");
            formItem.setErrorValidationMessage(errorValidationMessage);

            formItemPersistence.update(formItem);
        } catch (Exception e) {
            log.error("Exception while adding form item: " + e.getMessage(), e);
        }

        return formItem;
    }

    public List<FormItem> getFormItemByFormId(long formId) {
        try {
            return FormItemUtil.findByFormId(formId);
        } catch (Exception e) {
            log.error("Exception while getting form item by id [" + formId + "] : " + e.getMessage(), e);
            return new ArrayList<FormItem>();
        }
    }
}