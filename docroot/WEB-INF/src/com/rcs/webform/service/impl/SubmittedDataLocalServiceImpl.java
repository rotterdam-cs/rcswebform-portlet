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
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.rcs.webform.model.SubmittedData;
import com.rcs.webform.service.base.SubmittedDataLocalServiceBaseImpl;

/**
 * The implementation of the submitted data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rcs.webform.service.SubmittedDataLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ryusuf
 * @see com.rcs.webform.service.base.SubmittedDataLocalServiceBaseImpl
 * @see com.rcs.webform.service.SubmittedDataLocalServiceUtil
 */
public class SubmittedDataLocalServiceImpl
	extends SubmittedDataLocalServiceBaseImpl {
	
	private static Log log = LogFactoryUtil.getLog(SubmittedDataLocalServiceImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<SubmittedData> getSubmittedDataByForm(Long formId) {
		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(SubmittedData.class)
					.add(PropertyFactoryUtil.forName("primaryKey.formId").eq(formId))
					.add(PropertyFactoryUtil.forName("active").eq(true));
			
			List<SubmittedData> results = submittedDataPersistence.findWithDynamicQuery(query);
			return results;
		} catch (Exception e) {
			log.error("Exception while getting form items by id [" + formId + "] : " + e.getMessage(), e);
            return new ArrayList<SubmittedData>();
		}
	}
	
}