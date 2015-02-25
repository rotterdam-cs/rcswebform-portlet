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

package com.rcs.dbService.model;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the WebformRow service. Represents a row in the &quot;RcsWebform_WebformRow&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rcs.dbService.model.impl.WebformRowModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rcs.dbService.model.impl.WebformRowImpl}.
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformRow
 * @see com.rcs.dbService.model.impl.WebformRowImpl
 * @see com.rcs.dbService.model.impl.WebformRowModelImpl
 * @generated
 */
public interface WebformRowModel extends BaseModel<WebformRow> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a webform row model instance should use the {@link WebformRow} interface instead.
	 */

	/**
	 * Returns the primary key of this webform row.
	 *
	 * @return the primary key of this webform row
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this webform row.
	 *
	 * @param primaryKey the primary key of this webform row
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the webform row ID of this webform row.
	 *
	 * @return the webform row ID of this webform row
	 */
	public long getWebformRowId();

	/**
	 * Sets the webform row ID of this webform row.
	 *
	 * @param webformRowId the webform row ID of this webform row
	 */
	public void setWebformRowId(long webformRowId);

	/**
	 * Returns the webform table ID of this webform row.
	 *
	 * @return the webform table ID of this webform row
	 */
	public long getWebformTableId();

	/**
	 * Sets the webform table ID of this webform row.
	 *
	 * @param webformTableId the webform table ID of this webform row
	 */
	public void setWebformTableId(long webformTableId);

	/**
	 * Returns the update date of this webform row.
	 *
	 * @return the update date of this webform row
	 */
	public Date getUpdateDate();

	/**
	 * Sets the update date of this webform row.
	 *
	 * @param updateDate the update date of this webform row
	 */
	public void setUpdateDate(Date updateDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(WebformRow webformRow);

	@Override
	public int hashCode();

	@Override
	public CacheModel<WebformRow> toCacheModel();

	@Override
	public WebformRow toEscapedModel();

	@Override
	public WebformRow toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}