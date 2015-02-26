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

package com.rcs.dbservice.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.rcs.dbservice.model.WebformRow;
import com.rcs.dbservice.service.WebformRowLocalServiceUtil;

/**
 * The extended model base implementation for the WebformRow service. Represents a row in the &quot;RcsWebform_WebformRow&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WebformRowImpl}.
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformRowImpl
 * @see com.rcs.dbservice.model.WebformRow
 * @generated
 */
public abstract class WebformRowBaseImpl extends WebformRowModelImpl
	implements WebformRow {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a webform row model instance should use the {@link WebformRow} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			WebformRowLocalServiceUtil.addWebformRow(this);
		}
		else {
			WebformRowLocalServiceUtil.updateWebformRow(this);
		}
	}
}