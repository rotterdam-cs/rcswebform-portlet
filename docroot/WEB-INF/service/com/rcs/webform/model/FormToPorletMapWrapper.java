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

package com.rcs.webform.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FormToPorletMap}.
 * </p>
 *
 * @author ryusuf
 * @see FormToPorletMap
 * @generated
 */
public class FormToPorletMapWrapper implements FormToPorletMap,
	ModelWrapper<FormToPorletMap> {
	public FormToPorletMapWrapper(FormToPorletMap formToPorletMap) {
		_formToPorletMap = formToPorletMap;
	}

	@Override
	public Class<?> getModelClass() {
		return FormToPorletMap.class;
	}

	@Override
	public String getModelClassName() {
		return FormToPorletMap.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("formToPorletMapId", getFormToPorletMapId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("formId", getFormId());
		attributes.put("portletId", getPortletId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long formToPorletMapId = (Long)attributes.get("formToPorletMapId");

		if (formToPorletMapId != null) {
			setFormToPorletMapId(formToPorletMapId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long formId = (Long)attributes.get("formId");

		if (formId != null) {
			setFormId(formId);
		}

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}
	}

	/**
	* Returns the primary key of this form to porlet map.
	*
	* @return the primary key of this form to porlet map
	*/
	@Override
	public long getPrimaryKey() {
		return _formToPorletMap.getPrimaryKey();
	}

	/**
	* Sets the primary key of this form to porlet map.
	*
	* @param primaryKey the primary key of this form to porlet map
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_formToPorletMap.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the form to porlet map ID of this form to porlet map.
	*
	* @return the form to porlet map ID of this form to porlet map
	*/
	@Override
	public long getFormToPorletMapId() {
		return _formToPorletMap.getFormToPorletMapId();
	}

	/**
	* Sets the form to porlet map ID of this form to porlet map.
	*
	* @param formToPorletMapId the form to porlet map ID of this form to porlet map
	*/
	@Override
	public void setFormToPorletMapId(long formToPorletMapId) {
		_formToPorletMap.setFormToPorletMapId(formToPorletMapId);
	}

	/**
	* Returns the group ID of this form to porlet map.
	*
	* @return the group ID of this form to porlet map
	*/
	@Override
	public long getGroupId() {
		return _formToPorletMap.getGroupId();
	}

	/**
	* Sets the group ID of this form to porlet map.
	*
	* @param groupId the group ID of this form to porlet map
	*/
	@Override
	public void setGroupId(long groupId) {
		_formToPorletMap.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this form to porlet map.
	*
	* @return the company ID of this form to porlet map
	*/
	@Override
	public long getCompanyId() {
		return _formToPorletMap.getCompanyId();
	}

	/**
	* Sets the company ID of this form to porlet map.
	*
	* @param companyId the company ID of this form to porlet map
	*/
	@Override
	public void setCompanyId(long companyId) {
		_formToPorletMap.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this form to porlet map.
	*
	* @return the user ID of this form to porlet map
	*/
	@Override
	public long getUserId() {
		return _formToPorletMap.getUserId();
	}

	/**
	* Sets the user ID of this form to porlet map.
	*
	* @param userId the user ID of this form to porlet map
	*/
	@Override
	public void setUserId(long userId) {
		_formToPorletMap.setUserId(userId);
	}

	/**
	* Returns the user uuid of this form to porlet map.
	*
	* @return the user uuid of this form to porlet map
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formToPorletMap.getUserUuid();
	}

	/**
	* Sets the user uuid of this form to porlet map.
	*
	* @param userUuid the user uuid of this form to porlet map
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_formToPorletMap.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this form to porlet map.
	*
	* @return the user name of this form to porlet map
	*/
	@Override
	public java.lang.String getUserName() {
		return _formToPorletMap.getUserName();
	}

	/**
	* Sets the user name of this form to porlet map.
	*
	* @param userName the user name of this form to porlet map
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_formToPorletMap.setUserName(userName);
	}

	/**
	* Returns the create date of this form to porlet map.
	*
	* @return the create date of this form to porlet map
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _formToPorletMap.getCreateDate();
	}

	/**
	* Sets the create date of this form to porlet map.
	*
	* @param createDate the create date of this form to porlet map
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_formToPorletMap.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this form to porlet map.
	*
	* @return the modified date of this form to porlet map
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _formToPorletMap.getModifiedDate();
	}

	/**
	* Sets the modified date of this form to porlet map.
	*
	* @param modifiedDate the modified date of this form to porlet map
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_formToPorletMap.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the form ID of this form to porlet map.
	*
	* @return the form ID of this form to porlet map
	*/
	@Override
	public long getFormId() {
		return _formToPorletMap.getFormId();
	}

	/**
	* Sets the form ID of this form to porlet map.
	*
	* @param formId the form ID of this form to porlet map
	*/
	@Override
	public void setFormId(long formId) {
		_formToPorletMap.setFormId(formId);
	}

	/**
	* Returns the portlet ID of this form to porlet map.
	*
	* @return the portlet ID of this form to porlet map
	*/
	@Override
	public java.lang.String getPortletId() {
		return _formToPorletMap.getPortletId();
	}

	/**
	* Sets the portlet ID of this form to porlet map.
	*
	* @param portletId the portlet ID of this form to porlet map
	*/
	@Override
	public void setPortletId(java.lang.String portletId) {
		_formToPorletMap.setPortletId(portletId);
	}

	@Override
	public boolean isNew() {
		return _formToPorletMap.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_formToPorletMap.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _formToPorletMap.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_formToPorletMap.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _formToPorletMap.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _formToPorletMap.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_formToPorletMap.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _formToPorletMap.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_formToPorletMap.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_formToPorletMap.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_formToPorletMap.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FormToPorletMapWrapper((FormToPorletMap)_formToPorletMap.clone());
	}

	@Override
	public int compareTo(FormToPorletMap formToPorletMap) {
		return _formToPorletMap.compareTo(formToPorletMap);
	}

	@Override
	public int hashCode() {
		return _formToPorletMap.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<FormToPorletMap> toCacheModel() {
		return _formToPorletMap.toCacheModel();
	}

	@Override
	public FormToPorletMap toEscapedModel() {
		return new FormToPorletMapWrapper(_formToPorletMap.toEscapedModel());
	}

	@Override
	public FormToPorletMap toUnescapedModel() {
		return new FormToPorletMapWrapper(_formToPorletMap.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _formToPorletMap.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _formToPorletMap.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_formToPorletMap.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FormToPorletMapWrapper)) {
			return false;
		}

		FormToPorletMapWrapper formToPorletMapWrapper = (FormToPorletMapWrapper)obj;

		if (Validator.equals(_formToPorletMap,
					formToPorletMapWrapper._formToPorletMap)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FormToPorletMap getWrappedFormToPorletMap() {
		return _formToPorletMap;
	}

	@Override
	public FormToPorletMap getWrappedModel() {
		return _formToPorletMap;
	}

	@Override
	public void resetOriginalValues() {
		_formToPorletMap.resetOriginalValues();
	}

	private FormToPorletMap _formToPorletMap;
}