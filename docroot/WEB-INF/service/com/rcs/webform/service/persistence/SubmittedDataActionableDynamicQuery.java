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

package com.rcs.webform.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.rcs.webform.model.SubmittedData;
import com.rcs.webform.service.SubmittedDataLocalServiceUtil;

/**
 * @author ryusuf
 * @generated
 */
public abstract class SubmittedDataActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public SubmittedDataActionableDynamicQuery() throws SystemException {
		setBaseLocalService(SubmittedDataLocalServiceUtil.getService());
		setClass(SubmittedData.class);

		setClassLoader(com.rcs.webform.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("submittedDataId");
	}
}