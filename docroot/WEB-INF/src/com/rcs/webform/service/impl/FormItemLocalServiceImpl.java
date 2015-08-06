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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
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
     * Save Form Item
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
    public FormItem save(Long formItemId, Long formId, Map<Locale, String> label, String type, Map<Locale, String> options, boolean mandatory, String validationRegexValue,
            String validationType, String errorValidationMessage, int order, int maxLength, Map<Locale, String> hintMessage, ServiceContext serviceContext,
            String formItemAttrClass, String labelAttrClass, String inputAttrClass) {

        User user = null;
        FormItem formItem = null;
        Date now = new Date();
        try {
            user = userLocalService.getUserById(serviceContext.getUserId());
            if (formItemId == 0) {
                formItemId = counterLocalService.increment(FormItem.class.getName());
                formItem = formItemPersistence.create(formItemId);
            } else {
            	formItem = formItemPersistence.fetchByPrimaryKey(formItemId);
            }
            formItem.setActive(true);
            formItem.setCreationDate(serviceContext.getCreateDate(now));
            formItem.setModificationDate(serviceContext.getModifiedDate(now));
            formItem.setModificationUser(user.getFullName());
            formItem.setFormId(formId);
            formItem.setFormItemAttrId("");
            formItem.setFormItemAttrClass(formItemAttrClass);
            formItem.setLabelMap(label);
            formItem.setLabelAttrId("");
            formItem.setLabelAttrClass(labelAttrClass);
            formItem.setInputAttrId("");
            formItem.setInputAttrClass(inputAttrClass);
            formItem.setType(type);
            formItem.setOptionsMap(options);
            formItem.setMandatory(mandatory);
            formItem.setDefaultValue("");
            formItem.setOrder(order);
            formItem.setHintMessageMap(hintMessage);
            formItem.setValidationType(validationType);
            formItem.setValidationRegexValue(validationRegexValue);
            formItem.setErrorMandatoryMessage("");
            formItem.setErrorValidationMessage(errorValidationMessage);
            formItem.setMaxLength(maxLength);

            formItemPersistence.update(formItem);
        } catch (Exception e) {
            log.error("Exception while adding form item: " + e.getMessage(), e);
        }

        return formItem;
    }

    public List<FormItem> getFormItemByFormId(long formId) {
        try {
            return FormItemUtil.findByFormIdAndActive(formId);
        } catch (Exception e) {
            log.error("Exception while getting form item by id [" + formId + "] : " + e.getMessage(), e);
            return new ArrayList<FormItem>();
        }
    }
    
    /**
     * get Form Items
     * 
     * @param formId
     * @return
     */
    public List<FormItem> getFormItemsByFormId(Long formId) {
        try {
        	DynamicQuery query = DynamicQueryFactoryUtil.forClass(FormItem.class)
        			.add(PropertyFactoryUtil.forName("formId").eq(formId))
        			.add(PropertyFactoryUtil.forName("active").eq(true))
        			.addOrder(OrderFactoryUtil.asc("order"));
        	
        	List<FormItem> results = (List<FormItem>) formItemPersistence.findWithDynamicQuery(query);
            return results;
        } catch (Exception e) {
            log.error("Exception while getting form items by id [" + formId + "] : " + e.getMessage(), e);
            return new ArrayList<FormItem>();
        }
    }
    
    /**
     * Soft Delete Form Item
     * 
     * @param formItemId
     * @param serviceContext
     * @return
     */
    public FormItem delete(Long formItemId, ServiceContext serviceContext){
    	User user = null;
        FormItem formItem = null;
        Date now = new Date();
        try {
            user = userLocalService.getUserById(serviceContext.getUserId());
            formItem = formItemPersistence.fetchByPrimaryKey(formItemId);
            formItem.setActive(false);
            formItem.setCreationDate(serviceContext.getCreateDate(now));
            formItem.setModificationDate(serviceContext.getModifiedDate(now));
            formItem.setModificationUser(user.getFullName());
            
            formItemPersistence.update(formItem);
        } catch (Exception e) {
            log.error("Exception while deleting form item: " + e.getMessage(), e);
        }

        return formItem;
    }
}