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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link WebformRow}.
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformRow
 * @generated
 */
public class WebformRowWrapper implements WebformRow, ModelWrapper<WebformRow> {
	public WebformRowWrapper(WebformRow webformRow) {
		_webformRow = webformRow;
	}

	@Override
	public Class<?> getModelClass() {
		return WebformRow.class;
	}

	@Override
	public String getModelClassName() {
		return WebformRow.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("webformRowId", getWebformRowId());
		attributes.put("webformTableId", getWebformTableId());
		attributes.put("updateDate", getUpdateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long webformRowId = (Long)attributes.get("webformRowId");

		if (webformRowId != null) {
			setWebformRowId(webformRowId);
		}

		Long webformTableId = (Long)attributes.get("webformTableId");

		if (webformTableId != null) {
			setWebformTableId(webformTableId);
		}

		Date updateDate = (Date)attributes.get("updateDate");

		if (updateDate != null) {
			setUpdateDate(updateDate);
		}
	}

	/**
	* Returns the primary key of this webform row.
	*
	* @return the primary key of this webform row
	*/
	@Override
	public long getPrimaryKey() {
		return _webformRow.getPrimaryKey();
	}

	/**
	* Sets the primary key of this webform row.
	*
	* @param primaryKey the primary key of this webform row
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_webformRow.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the webform row ID of this webform row.
	*
	* @return the webform row ID of this webform row
	*/
	@Override
	public long getWebformRowId() {
		return _webformRow.getWebformRowId();
	}

	/**
	* Sets the webform row ID of this webform row.
	*
	* @param webformRowId the webform row ID of this webform row
	*/
	@Override
	public void setWebformRowId(long webformRowId) {
		_webformRow.setWebformRowId(webformRowId);
	}

	/**
	* Returns the webform table ID of this webform row.
	*
	* @return the webform table ID of this webform row
	*/
	@Override
	public long getWebformTableId() {
		return _webformRow.getWebformTableId();
	}

	/**
	* Sets the webform table ID of this webform row.
	*
	* @param webformTableId the webform table ID of this webform row
	*/
	@Override
	public void setWebformTableId(long webformTableId) {
		_webformRow.setWebformTableId(webformTableId);
	}

	/**
	* Returns the update date of this webform row.
	*
	* @return the update date of this webform row
	*/
	@Override
	public java.util.Date getUpdateDate() {
		return _webformRow.getUpdateDate();
	}

	/**
	* Sets the update date of this webform row.
	*
	* @param updateDate the update date of this webform row
	*/
	@Override
	public void setUpdateDate(java.util.Date updateDate) {
		_webformRow.setUpdateDate(updateDate);
	}

	@Override
	public boolean isNew() {
		return _webformRow.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_webformRow.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _webformRow.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_webformRow.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _webformRow.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _webformRow.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_webformRow.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _webformRow.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_webformRow.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_webformRow.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_webformRow.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WebformRowWrapper((WebformRow)_webformRow.clone());
	}

	@Override
	public int compareTo(com.rcs.dbservice.model.WebformRow webformRow) {
		return _webformRow.compareTo(webformRow);
	}

	@Override
	public int hashCode() {
		return _webformRow.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rcs.dbservice.model.WebformRow> toCacheModel() {
		return _webformRow.toCacheModel();
	}

	@Override
	public com.rcs.dbservice.model.WebformRow toEscapedModel() {
		return new WebformRowWrapper(_webformRow.toEscapedModel());
	}

	@Override
	public com.rcs.dbservice.model.WebformRow toUnescapedModel() {
		return new WebformRowWrapper(_webformRow.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _webformRow.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _webformRow.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_webformRow.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WebformRowWrapper)) {
			return false;
		}

		WebformRowWrapper webformRowWrapper = (WebformRowWrapper)obj;

		if (Validator.equals(_webformRow, webformRowWrapper._webformRow)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public WebformRow getWrappedWebformRow() {
		return _webformRow;
	}

	@Override
	public WebformRow getWrappedModel() {
		return _webformRow;
	}

	@Override
	public void resetOriginalValues() {
		_webformRow.resetOriginalValues();
	}

	private WebformRow _webformRow;
}