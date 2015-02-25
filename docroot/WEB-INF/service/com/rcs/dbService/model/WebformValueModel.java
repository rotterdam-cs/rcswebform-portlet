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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the WebformValue service. Represents a row in the &quot;RcsWebform_WebformValue&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rcs.dbService.model.impl.WebformValueModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rcs.dbService.model.impl.WebformValueImpl}.
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformValue
 * @see com.rcs.dbService.model.impl.WebformValueImpl
 * @see com.rcs.dbService.model.impl.WebformValueModelImpl
 * @generated
 */
public interface WebformValueModel extends BaseModel<WebformValue> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a webform value model instance should use the {@link WebformValue} interface instead.
	 */

	/**
	 * Returns the primary key of this webform value.
	 *
	 * @return the primary key of this webform value
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this webform value.
	 *
	 * @param primaryKey the primary key of this webform value
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the webform value ID of this webform value.
	 *
	 * @return the webform value ID of this webform value
	 */
	public long getWebformValueId();

	/**
	 * Sets the webform value ID of this webform value.
	 *
	 * @param webformValueId the webform value ID of this webform value
	 */
	public void setWebformValueId(long webformValueId);

	/**
	 * Returns the webform table ID of this webform value.
	 *
	 * @return the webform table ID of this webform value
	 */
	public long getWebformTableId();

	/**
	 * Sets the webform table ID of this webform value.
	 *
	 * @param webformTableId the webform table ID of this webform value
	 */
	public void setWebformTableId(long webformTableId);

	/**
	 * Returns the webform column ID of this webform value.
	 *
	 * @return the webform column ID of this webform value
	 */
	public long getWebformColumnId();

	/**
	 * Sets the webform column ID of this webform value.
	 *
	 * @param webformColumnId the webform column ID of this webform value
	 */
	public void setWebformColumnId(long webformColumnId);

	/**
	 * Returns the webform row ID of this webform value.
	 *
	 * @return the webform row ID of this webform value
	 */
	public long getWebformRowId();

	/**
	 * Sets the webform row ID of this webform value.
	 *
	 * @param webformRowId the webform row ID of this webform value
	 */
	public void setWebformRowId(long webformRowId);

	/**
	 * Returns the data of this webform value.
	 *
	 * @return the data of this webform value
	 */
	@AutoEscape
	public String getData();

	/**
	 * Sets the data of this webform value.
	 *
	 * @param data the data of this webform value
	 */
	public void setData(String data);

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
	public int compareTo(WebformValue webformValue);

	@Override
	public int hashCode();

	@Override
	public CacheModel<WebformValue> toCacheModel();

	@Override
	public WebformValue toEscapedModel();

	@Override
	public WebformValue toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}