/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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
import com.rcs.webform.model.FormItemOption;
import com.rcs.webform.service.base.FormItemOptionLocalServiceBaseImpl;

/**
 * The implementation of the form item option local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.rcs.webform.service.FormItemOptionLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 * </p>
 * 
 * @author ryusuf
 * @author mfauzan_abdi
 * @see com.rcs.webform.service.base.FormItemOptionLocalServiceBaseImpl
 * @see com.rcs.webform.service.FormItemOptionLocalServiceUtil
 */
public class FormItemOptionLocalServiceImpl extends FormItemOptionLocalServiceBaseImpl {

	private static Log log = LogFactoryUtil.getLog(FormItemLocalServiceImpl.class);

	/**
	 * Save Form Item Option
	 * 
	 * @param formItemOptionId
	 * @param formItemId
	 * @param optionLabel
	 * @param optionValue
	 * @param serviceContext
	 * @return
	 */
	public FormItemOption save(Long formItemOptionId, Long formItemId, String optionLabel, Map<Locale, String> optionValue,
			ServiceContext serviceContext) {
		User user = null;
		FormItemOption formItemOption = null;
		Date now = new Date();
		try {
			user = userLocalService.getUserById(serviceContext.getUserId());
			if (formItemOptionId == 0) {
				formItemOptionId = counterLocalService.increment(FormItemOption.class.getName());
				formItemOption = formItemOptionPersistence.create(formItemOptionId);
			} else {
				formItemOption = formItemOptionPersistence.fetchByPrimaryKey(formItemOptionId);
			}

			formItemOption.setCreationDate(serviceContext.getCreateDate(now));
			formItemOption.setModificationDate(serviceContext.getModifiedDate(now));
			formItemOption.setModificationUser(user.getFullName());
			formItemOption.setFormItemId(formItemId);
			formItemOption.setOptionKey(optionLabel);
			formItemOption.setOptionValueMap(optionValue);

			formItemOptionPersistence.update(formItemOption);

		} catch (Exception e) {
			log.error("Exception while adding form item option: " + e.getMessage(), e);
		}

		return formItemOption;
	}
	
	/**
	 * get Form Item Options
	 * 
	 * @param formItemId
	 * @return
	 */
	public List<FormItemOption> getFormItemOptionsByFormItemId(Long formItemId) {
        try {
        	DynamicQuery query = DynamicQueryFactoryUtil.forClass(FormItemOption.class)
        			.add(PropertyFactoryUtil.forName("formItemId").eq(formItemId));
        	
        	List<FormItemOption> results = (List<FormItemOption>) formItemOptionPersistence.findWithDynamicQuery(query);
            return results;
        } catch (Exception e) {
            log.error("Exception while getting form item options by form item id [" + formItemId + "] : " + e.getMessage(), e);
            return new ArrayList<FormItemOption>();
        }
    }
	
	/**
     * Hard Delete Form Item Option By Form Item Id
     * 
     * @param formItemId
     * @return
     */
    public List<FormItemOption> deleteFormItemOptionByFormItem(Long formItemId){
    	List<FormItemOption> formItemOptions = null;
        try {
        	formItemOptions = getFormItemOptionsByFormItemId(formItemId);
        	if(formItemOptions != null && !formItemOptions.isEmpty()){
        		for(FormItemOption formItemOption : formItemOptions){
        			formItemOptionPersistence.remove(formItemOption);
        		}
        	}
        } catch (Exception e) {
            log.error("Exception while deleting form item option: " + e.getMessage(), e);
        }

        return formItemOptions;
    }
}