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
 * This class is a wrapper for {@link WebformColumn}.
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformColumn
 * @generated
 */
public class WebformColumnWrapper implements WebformColumn,
	ModelWrapper<WebformColumn> {
	public WebformColumnWrapper(WebformColumn webformColumn) {
		_webformColumn = webformColumn;
	}

	@Override
	public Class<?> getModelClass() {
		return WebformColumn.class;
	}

	@Override
	public String getModelClassName() {
		return WebformColumn.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("webformColumnId", getWebformColumnId());
		attributes.put("webformTableId", getWebformTableId());
		attributes.put("name", getName());
		attributes.put("type", getType());
		attributes.put("inputType", getInputType());
		attributes.put("isRequired", getIsRequired());
		attributes.put("placeHolder", getPlaceHolder());
		attributes.put("validation", getValidation());
		attributes.put("customValidation", getCustomValidation());
		attributes.put("labelClass", getLabelClass());
		attributes.put("inputClass", getInputClass());
		attributes.put("maxLength", getMaxLength());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long webformColumnId = (Long)attributes.get("webformColumnId");

		if (webformColumnId != null) {
			setWebformColumnId(webformColumnId);
		}

		Long webformTableId = (Long)attributes.get("webformTableId");

		if (webformTableId != null) {
			setWebformTableId(webformTableId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Integer inputType = (Integer)attributes.get("inputType");

		if (inputType != null) {
			setInputType(inputType);
		}

		Boolean isRequired = (Boolean)attributes.get("isRequired");

		if (isRequired != null) {
			setIsRequired(isRequired);
		}

		String placeHolder = (String)attributes.get("placeHolder");

		if (placeHolder != null) {
			setPlaceHolder(placeHolder);
		}

		String validation = (String)attributes.get("validation");

		if (validation != null) {
			setValidation(validation);
		}

		String customValidation = (String)attributes.get("customValidation");

		if (customValidation != null) {
			setCustomValidation(customValidation);
		}

		String labelClass = (String)attributes.get("labelClass");

		if (labelClass != null) {
			setLabelClass(labelClass);
		}

		String inputClass = (String)attributes.get("inputClass");

		if (inputClass != null) {
			setInputClass(inputClass);
		}

		String maxLength = (String)attributes.get("maxLength");

		if (maxLength != null) {
			setMaxLength(maxLength);
		}
	}

	/**
	* Returns the primary key of this webform column.
	*
	* @return the primary key of this webform column
	*/
	@Override
	public long getPrimaryKey() {
		return _webformColumn.getPrimaryKey();
	}

	/**
	* Sets the primary key of this webform column.
	*
	* @param primaryKey the primary key of this webform column
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_webformColumn.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the webform column ID of this webform column.
	*
	* @return the webform column ID of this webform column
	*/
	@Override
	public long getWebformColumnId() {
		return _webformColumn.getWebformColumnId();
	}

	/**
	* Sets the webform column ID of this webform column.
	*
	* @param webformColumnId the webform column ID of this webform column
	*/
	@Override
	public void setWebformColumnId(long webformColumnId) {
		_webformColumn.setWebformColumnId(webformColumnId);
	}

	/**
	* Returns the webform table ID of this webform column.
	*
	* @return the webform table ID of this webform column
	*/
	@Override
	public long getWebformTableId() {
		return _webformColumn.getWebformTableId();
	}

	/**
	* Sets the webform table ID of this webform column.
	*
	* @param webformTableId the webform table ID of this webform column
	*/
	@Override
	public void setWebformTableId(long webformTableId) {
		_webformColumn.setWebformTableId(webformTableId);
	}

	/**
	* Returns the name of this webform column.
	*
	* @return the name of this webform column
	*/
	@Override
	public java.lang.String getName() {
		return _webformColumn.getName();
	}

	/**
	* Sets the name of this webform column.
	*
	* @param name the name of this webform column
	*/
	@Override
	public void setName(java.lang.String name) {
		_webformColumn.setName(name);
	}

	/**
	* Returns the type of this webform column.
	*
	* @return the type of this webform column
	*/
	@Override
	public int getType() {
		return _webformColumn.getType();
	}

	/**
	* Sets the type of this webform column.
	*
	* @param type the type of this webform column
	*/
	@Override
	public void setType(int type) {
		_webformColumn.setType(type);
	}

	/**
	* Returns the input type of this webform column.
	*
	* @return the input type of this webform column
	*/
	@Override
	public int getInputType() {
		return _webformColumn.getInputType();
	}

	/**
	* Sets the input type of this webform column.
	*
	* @param inputType the input type of this webform column
	*/
	@Override
	public void setInputType(int inputType) {
		_webformColumn.setInputType(inputType);
	}

	/**
	* Returns the is required of this webform column.
	*
	* @return the is required of this webform column
	*/
	@Override
	public boolean getIsRequired() {
		return _webformColumn.getIsRequired();
	}

	/**
	* Returns <code>true</code> if this webform column is is required.
	*
	* @return <code>true</code> if this webform column is is required; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsRequired() {
		return _webformColumn.isIsRequired();
	}

	/**
	* Sets whether this webform column is is required.
	*
	* @param isRequired the is required of this webform column
	*/
	@Override
	public void setIsRequired(boolean isRequired) {
		_webformColumn.setIsRequired(isRequired);
	}

	/**
	* Returns the place holder of this webform column.
	*
	* @return the place holder of this webform column
	*/
	@Override
	public java.lang.String getPlaceHolder() {
		return _webformColumn.getPlaceHolder();
	}

	/**
	* Sets the place holder of this webform column.
	*
	* @param placeHolder the place holder of this webform column
	*/
	@Override
	public void setPlaceHolder(java.lang.String placeHolder) {
		_webformColumn.setPlaceHolder(placeHolder);
	}

	/**
	* Returns the validation of this webform column.
	*
	* @return the validation of this webform column
	*/
	@Override
	public java.lang.String getValidation() {
		return _webformColumn.getValidation();
	}

	/**
	* Sets the validation of this webform column.
	*
	* @param validation the validation of this webform column
	*/
	@Override
	public void setValidation(java.lang.String validation) {
		_webformColumn.setValidation(validation);
	}

	/**
	* Returns the custom validation of this webform column.
	*
	* @return the custom validation of this webform column
	*/
	@Override
	public java.lang.String getCustomValidation() {
		return _webformColumn.getCustomValidation();
	}

	/**
	* Sets the custom validation of this webform column.
	*
	* @param customValidation the custom validation of this webform column
	*/
	@Override
	public void setCustomValidation(java.lang.String customValidation) {
		_webformColumn.setCustomValidation(customValidation);
	}

	/**
	* Returns the label class of this webform column.
	*
	* @return the label class of this webform column
	*/
	@Override
	public java.lang.String getLabelClass() {
		return _webformColumn.getLabelClass();
	}

	/**
	* Sets the label class of this webform column.
	*
	* @param labelClass the label class of this webform column
	*/
	@Override
	public void setLabelClass(java.lang.String labelClass) {
		_webformColumn.setLabelClass(labelClass);
	}

	/**
	* Returns the input class of this webform column.
	*
	* @return the input class of this webform column
	*/
	@Override
	public java.lang.String getInputClass() {
		return _webformColumn.getInputClass();
	}

	/**
	* Sets the input class of this webform column.
	*
	* @param inputClass the input class of this webform column
	*/
	@Override
	public void setInputClass(java.lang.String inputClass) {
		_webformColumn.setInputClass(inputClass);
	}

	/**
	* Returns the max length of this webform column.
	*
	* @return the max length of this webform column
	*/
	@Override
	public java.lang.String getMaxLength() {
		return _webformColumn.getMaxLength();
	}

	/**
	* Sets the max length of this webform column.
	*
	* @param maxLength the max length of this webform column
	*/
	@Override
	public void setMaxLength(java.lang.String maxLength) {
		_webformColumn.setMaxLength(maxLength);
	}

	@Override
	public boolean isNew() {
		return _webformColumn.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_webformColumn.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _webformColumn.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_webformColumn.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _webformColumn.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _webformColumn.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_webformColumn.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _webformColumn.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_webformColumn.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_webformColumn.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_webformColumn.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WebformColumnWrapper((WebformColumn)_webformColumn.clone());
	}

	@Override
	public int compareTo(WebformColumn webformColumn) {
		return _webformColumn.compareTo(webformColumn);
	}

	@Override
	public int hashCode() {
		return _webformColumn.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<WebformColumn> toCacheModel() {
		return _webformColumn.toCacheModel();
	}

	@Override
	public WebformColumn toEscapedModel() {
		return new WebformColumnWrapper(_webformColumn.toEscapedModel());
	}

	@Override
	public WebformColumn toUnescapedModel() {
		return new WebformColumnWrapper(_webformColumn.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _webformColumn.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _webformColumn.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_webformColumn.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WebformColumnWrapper)) {
			return false;
		}

		WebformColumnWrapper webformColumnWrapper = (WebformColumnWrapper)obj;

		if (Validator.equals(_webformColumn, webformColumnWrapper._webformColumn)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public WebformColumn getWrappedWebformColumn() {
		return _webformColumn;
	}

	@Override
	public WebformColumn getWrappedModel() {
		return _webformColumn;
	}

	@Override
	public void resetOriginalValues() {
		_webformColumn.resetOriginalValues();
	}

	private WebformColumn _webformColumn;
}