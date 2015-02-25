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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link WebformTable}.
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformTable
 * @generated
 */
public class WebformTableWrapper implements WebformTable,
	ModelWrapper<WebformTable> {
	public WebformTableWrapper(WebformTable webformTable) {
		_webformTable = webformTable;
	}

	@Override
	public Class<?> getModelClass() {
		return WebformTable.class;
	}

	@Override
	public String getModelClassName() {
		return WebformTable.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("webformTableId", getWebformTableId());
		attributes.put("portletId", getPortletId());
		attributes.put("webformCounter", getWebformCounter());
		attributes.put("webformName", getWebformName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long webformTableId = (Long)attributes.get("webformTableId");

		if (webformTableId != null) {
			setWebformTableId(webformTableId);
		}

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		String webformCounter = (String)attributes.get("webformCounter");

		if (webformCounter != null) {
			setWebformCounter(webformCounter);
		}

		String webformName = (String)attributes.get("webformName");

		if (webformName != null) {
			setWebformName(webformName);
		}
	}

	/**
	* Returns the primary key of this webform table.
	*
	* @return the primary key of this webform table
	*/
	@Override
	public long getPrimaryKey() {
		return _webformTable.getPrimaryKey();
	}

	/**
	* Sets the primary key of this webform table.
	*
	* @param primaryKey the primary key of this webform table
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_webformTable.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the webform table ID of this webform table.
	*
	* @return the webform table ID of this webform table
	*/
	@Override
	public long getWebformTableId() {
		return _webformTable.getWebformTableId();
	}

	/**
	* Sets the webform table ID of this webform table.
	*
	* @param webformTableId the webform table ID of this webform table
	*/
	@Override
	public void setWebformTableId(long webformTableId) {
		_webformTable.setWebformTableId(webformTableId);
	}

	/**
	* Returns the portlet ID of this webform table.
	*
	* @return the portlet ID of this webform table
	*/
	@Override
	public java.lang.String getPortletId() {
		return _webformTable.getPortletId();
	}

	/**
	* Sets the portlet ID of this webform table.
	*
	* @param portletId the portlet ID of this webform table
	*/
	@Override
	public void setPortletId(java.lang.String portletId) {
		_webformTable.setPortletId(portletId);
	}

	/**
	* Returns the webform counter of this webform table.
	*
	* @return the webform counter of this webform table
	*/
	@Override
	public java.lang.String getWebformCounter() {
		return _webformTable.getWebformCounter();
	}

	/**
	* Sets the webform counter of this webform table.
	*
	* @param webformCounter the webform counter of this webform table
	*/
	@Override
	public void setWebformCounter(java.lang.String webformCounter) {
		_webformTable.setWebformCounter(webformCounter);
	}

	/**
	* Returns the webform name of this webform table.
	*
	* @return the webform name of this webform table
	*/
	@Override
	public java.lang.String getWebformName() {
		return _webformTable.getWebformName();
	}

	/**
	* Sets the webform name of this webform table.
	*
	* @param webformName the webform name of this webform table
	*/
	@Override
	public void setWebformName(java.lang.String webformName) {
		_webformTable.setWebformName(webformName);
	}

	@Override
	public boolean isNew() {
		return _webformTable.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_webformTable.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _webformTable.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_webformTable.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _webformTable.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _webformTable.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_webformTable.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _webformTable.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_webformTable.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_webformTable.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_webformTable.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WebformTableWrapper((WebformTable)_webformTable.clone());
	}

	@Override
	public int compareTo(com.rcs.dbService.model.WebformTable webformTable) {
		return _webformTable.compareTo(webformTable);
	}

	@Override
	public int hashCode() {
		return _webformTable.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rcs.dbService.model.WebformTable> toCacheModel() {
		return _webformTable.toCacheModel();
	}

	@Override
	public com.rcs.dbService.model.WebformTable toEscapedModel() {
		return new WebformTableWrapper(_webformTable.toEscapedModel());
	}

	@Override
	public com.rcs.dbService.model.WebformTable toUnescapedModel() {
		return new WebformTableWrapper(_webformTable.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _webformTable.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _webformTable.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_webformTable.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WebformTableWrapper)) {
			return false;
		}

		WebformTableWrapper webformTableWrapper = (WebformTableWrapper)obj;

		if (Validator.equals(_webformTable, webformTableWrapper._webformTable)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public WebformTable getWrappedWebformTable() {
		return _webformTable;
	}

	@Override
	public WebformTable getWrappedModel() {
		return _webformTable;
	}

	@Override
	public void resetOriginalValues() {
		_webformTable.resetOriginalValues();
	}

	private WebformTable _webformTable;
}