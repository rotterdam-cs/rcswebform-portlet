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

package com.rcs.dbservice.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link WebformValue}.
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformValue
 * @generated
 */
public class WebformValueWrapper implements WebformValue,
	ModelWrapper<WebformValue> {
	public WebformValueWrapper(WebformValue webformValue) {
		_webformValue = webformValue;
	}

	@Override
	public Class<?> getModelClass() {
		return WebformValue.class;
	}

	@Override
	public String getModelClassName() {
		return WebformValue.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("webformValueId", getWebformValueId());
		attributes.put("webformTableId", getWebformTableId());
		attributes.put("webformColumnId", getWebformColumnId());
		attributes.put("webformRowId", getWebformRowId());
		attributes.put("data", getData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long webformValueId = (Long)attributes.get("webformValueId");

		if (webformValueId != null) {
			setWebformValueId(webformValueId);
		}

		Long webformTableId = (Long)attributes.get("webformTableId");

		if (webformTableId != null) {
			setWebformTableId(webformTableId);
		}

		Long webformColumnId = (Long)attributes.get("webformColumnId");

		if (webformColumnId != null) {
			setWebformColumnId(webformColumnId);
		}

		Long webformRowId = (Long)attributes.get("webformRowId");

		if (webformRowId != null) {
			setWebformRowId(webformRowId);
		}

		String data = (String)attributes.get("data");

		if (data != null) {
			setData(data);
		}
	}

	/**
	* Returns the primary key of this webform value.
	*
	* @return the primary key of this webform value
	*/
	@Override
	public long getPrimaryKey() {
		return _webformValue.getPrimaryKey();
	}

	/**
	* Sets the primary key of this webform value.
	*
	* @param primaryKey the primary key of this webform value
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_webformValue.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the webform value ID of this webform value.
	*
	* @return the webform value ID of this webform value
	*/
	@Override
	public long getWebformValueId() {
		return _webformValue.getWebformValueId();
	}

	/**
	* Sets the webform value ID of this webform value.
	*
	* @param webformValueId the webform value ID of this webform value
	*/
	@Override
	public void setWebformValueId(long webformValueId) {
		_webformValue.setWebformValueId(webformValueId);
	}

	/**
	* Returns the webform table ID of this webform value.
	*
	* @return the webform table ID of this webform value
	*/
	@Override
	public long getWebformTableId() {
		return _webformValue.getWebformTableId();
	}

	/**
	* Sets the webform table ID of this webform value.
	*
	* @param webformTableId the webform table ID of this webform value
	*/
	@Override
	public void setWebformTableId(long webformTableId) {
		_webformValue.setWebformTableId(webformTableId);
	}

	/**
	* Returns the webform column ID of this webform value.
	*
	* @return the webform column ID of this webform value
	*/
	@Override
	public long getWebformColumnId() {
		return _webformValue.getWebformColumnId();
	}

	/**
	* Sets the webform column ID of this webform value.
	*
	* @param webformColumnId the webform column ID of this webform value
	*/
	@Override
	public void setWebformColumnId(long webformColumnId) {
		_webformValue.setWebformColumnId(webformColumnId);
	}

	/**
	* Returns the webform row ID of this webform value.
	*
	* @return the webform row ID of this webform value
	*/
	@Override
	public long getWebformRowId() {
		return _webformValue.getWebformRowId();
	}

	/**
	* Sets the webform row ID of this webform value.
	*
	* @param webformRowId the webform row ID of this webform value
	*/
	@Override
	public void setWebformRowId(long webformRowId) {
		_webformValue.setWebformRowId(webformRowId);
	}

	/**
	* Returns the data of this webform value.
	*
	* @return the data of this webform value
	*/
	@Override
	public java.lang.String getData() {
		return _webformValue.getData();
	}

	/**
	* Sets the data of this webform value.
	*
	* @param data the data of this webform value
	*/
	@Override
	public void setData(java.lang.String data) {
		_webformValue.setData(data);
	}

	@Override
	public boolean isNew() {
		return _webformValue.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_webformValue.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _webformValue.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_webformValue.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _webformValue.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _webformValue.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_webformValue.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _webformValue.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_webformValue.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_webformValue.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_webformValue.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WebformValueWrapper((WebformValue)_webformValue.clone());
	}

	@Override
	public int compareTo(com.rcs.dbservice.model.WebformValue webformValue) {
		return _webformValue.compareTo(webformValue);
	}

	@Override
	public int hashCode() {
		return _webformValue.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rcs.dbservice.model.WebformValue> toCacheModel() {
		return _webformValue.toCacheModel();
	}

	@Override
	public com.rcs.dbservice.model.WebformValue toEscapedModel() {
		return new WebformValueWrapper(_webformValue.toEscapedModel());
	}

	@Override
	public com.rcs.dbservice.model.WebformValue toUnescapedModel() {
		return new WebformValueWrapper(_webformValue.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _webformValue.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _webformValue.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WebformValueWrapper)) {
			return false;
		}

		WebformValueWrapper webformValueWrapper = (WebformValueWrapper)obj;

		if (Validator.equals(_webformValue, webformValueWrapper._webformValue)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public WebformValue getWrappedWebformValue() {
		return _webformValue;
	}

	@Override
	public WebformValue getWrappedModel() {
		return _webformValue;
	}

	@Override
	public void resetOriginalValues() {
		_webformValue.resetOriginalValues();
	}

	private WebformValue _webformValue;
}