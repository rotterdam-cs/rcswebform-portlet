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
 * This class is a wrapper for {@link SubmittedData}.
 * </p>
 *
 * @author ryusuf
 * @see SubmittedData
 * @generated
 */
public class SubmittedDataWrapper implements SubmittedData,
	ModelWrapper<SubmittedData> {
	public SubmittedDataWrapper(SubmittedData submittedData) {
		_submittedData = submittedData;
	}

	@Override
	public Class<?> getModelClass() {
		return SubmittedData.class;
	}

	@Override
	public String getModelClassName() {
		return SubmittedData.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("submittedDataId", getSubmittedDataId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("active", getActive());
		attributes.put("creationDate", getCreationDate());
		attributes.put("modificationDate", getModificationDate());
		attributes.put("modificationUser", getModificationUser());
		attributes.put("formId", getFormId());
		attributes.put("portletId", getPortletId());
		attributes.put("formItemId", getFormItemId());
		attributes.put("userInput", getUserInput());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long submittedDataId = (Long)attributes.get("submittedDataId");

		if (submittedDataId != null) {
			setSubmittedDataId(submittedDataId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Date creationDate = (Date)attributes.get("creationDate");

		if (creationDate != null) {
			setCreationDate(creationDate);
		}

		Date modificationDate = (Date)attributes.get("modificationDate");

		if (modificationDate != null) {
			setModificationDate(modificationDate);
		}

		String modificationUser = (String)attributes.get("modificationUser");

		if (modificationUser != null) {
			setModificationUser(modificationUser);
		}

		Long formId = (Long)attributes.get("formId");

		if (formId != null) {
			setFormId(formId);
		}

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		Long formItemId = (Long)attributes.get("formItemId");

		if (formItemId != null) {
			setFormItemId(formItemId);
		}

		String userInput = (String)attributes.get("userInput");

		if (userInput != null) {
			setUserInput(userInput);
		}
	}

	/**
	* Returns the primary key of this submitted data.
	*
	* @return the primary key of this submitted data
	*/
	@Override
	public long getPrimaryKey() {
		return _submittedData.getPrimaryKey();
	}

	/**
	* Sets the primary key of this submitted data.
	*
	* @param primaryKey the primary key of this submitted data
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_submittedData.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the submitted data ID of this submitted data.
	*
	* @return the submitted data ID of this submitted data
	*/
	@Override
	public long getSubmittedDataId() {
		return _submittedData.getSubmittedDataId();
	}

	/**
	* Sets the submitted data ID of this submitted data.
	*
	* @param submittedDataId the submitted data ID of this submitted data
	*/
	@Override
	public void setSubmittedDataId(long submittedDataId) {
		_submittedData.setSubmittedDataId(submittedDataId);
	}

	/**
	* Returns the group ID of this submitted data.
	*
	* @return the group ID of this submitted data
	*/
	@Override
	public long getGroupId() {
		return _submittedData.getGroupId();
	}

	/**
	* Sets the group ID of this submitted data.
	*
	* @param groupId the group ID of this submitted data
	*/
	@Override
	public void setGroupId(long groupId) {
		_submittedData.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this submitted data.
	*
	* @return the company ID of this submitted data
	*/
	@Override
	public long getCompanyId() {
		return _submittedData.getCompanyId();
	}

	/**
	* Sets the company ID of this submitted data.
	*
	* @param companyId the company ID of this submitted data
	*/
	@Override
	public void setCompanyId(long companyId) {
		_submittedData.setCompanyId(companyId);
	}

	/**
	* Returns the active of this submitted data.
	*
	* @return the active of this submitted data
	*/
	@Override
	public boolean getActive() {
		return _submittedData.getActive();
	}

	/**
	* Returns <code>true</code> if this submitted data is active.
	*
	* @return <code>true</code> if this submitted data is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _submittedData.isActive();
	}

	/**
	* Sets whether this submitted data is active.
	*
	* @param active the active of this submitted data
	*/
	@Override
	public void setActive(boolean active) {
		_submittedData.setActive(active);
	}

	/**
	* Returns the creation date of this submitted data.
	*
	* @return the creation date of this submitted data
	*/
	@Override
	public java.util.Date getCreationDate() {
		return _submittedData.getCreationDate();
	}

	/**
	* Sets the creation date of this submitted data.
	*
	* @param creationDate the creation date of this submitted data
	*/
	@Override
	public void setCreationDate(java.util.Date creationDate) {
		_submittedData.setCreationDate(creationDate);
	}

	/**
	* Returns the modification date of this submitted data.
	*
	* @return the modification date of this submitted data
	*/
	@Override
	public java.util.Date getModificationDate() {
		return _submittedData.getModificationDate();
	}

	/**
	* Sets the modification date of this submitted data.
	*
	* @param modificationDate the modification date of this submitted data
	*/
	@Override
	public void setModificationDate(java.util.Date modificationDate) {
		_submittedData.setModificationDate(modificationDate);
	}

	/**
	* Returns the modification user of this submitted data.
	*
	* @return the modification user of this submitted data
	*/
	@Override
	public java.lang.String getModificationUser() {
		return _submittedData.getModificationUser();
	}

	/**
	* Sets the modification user of this submitted data.
	*
	* @param modificationUser the modification user of this submitted data
	*/
	@Override
	public void setModificationUser(java.lang.String modificationUser) {
		_submittedData.setModificationUser(modificationUser);
	}

	/**
	* Returns the form ID of this submitted data.
	*
	* @return the form ID of this submitted data
	*/
	@Override
	public long getFormId() {
		return _submittedData.getFormId();
	}

	/**
	* Sets the form ID of this submitted data.
	*
	* @param formId the form ID of this submitted data
	*/
	@Override
	public void setFormId(long formId) {
		_submittedData.setFormId(formId);
	}

	/**
	* Returns the portlet ID of this submitted data.
	*
	* @return the portlet ID of this submitted data
	*/
	@Override
	public java.lang.String getPortletId() {
		return _submittedData.getPortletId();
	}

	/**
	* Sets the portlet ID of this submitted data.
	*
	* @param portletId the portlet ID of this submitted data
	*/
	@Override
	public void setPortletId(java.lang.String portletId) {
		_submittedData.setPortletId(portletId);
	}

	/**
	* Returns the form item ID of this submitted data.
	*
	* @return the form item ID of this submitted data
	*/
	@Override
	public long getFormItemId() {
		return _submittedData.getFormItemId();
	}

	/**
	* Sets the form item ID of this submitted data.
	*
	* @param formItemId the form item ID of this submitted data
	*/
	@Override
	public void setFormItemId(long formItemId) {
		_submittedData.setFormItemId(formItemId);
	}

	/**
	* Returns the user input of this submitted data.
	*
	* @return the user input of this submitted data
	*/
	@Override
	public java.lang.String getUserInput() {
		return _submittedData.getUserInput();
	}

	/**
	* Sets the user input of this submitted data.
	*
	* @param userInput the user input of this submitted data
	*/
	@Override
	public void setUserInput(java.lang.String userInput) {
		_submittedData.setUserInput(userInput);
	}

	@Override
	public boolean isNew() {
		return _submittedData.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_submittedData.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _submittedData.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_submittedData.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _submittedData.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _submittedData.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_submittedData.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _submittedData.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_submittedData.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_submittedData.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_submittedData.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SubmittedDataWrapper((SubmittedData)_submittedData.clone());
	}

	@Override
	public int compareTo(SubmittedData submittedData) {
		return _submittedData.compareTo(submittedData);
	}

	@Override
	public int hashCode() {
		return _submittedData.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<SubmittedData> toCacheModel() {
		return _submittedData.toCacheModel();
	}

	@Override
	public SubmittedData toEscapedModel() {
		return new SubmittedDataWrapper(_submittedData.toEscapedModel());
	}

	@Override
	public SubmittedData toUnescapedModel() {
		return new SubmittedDataWrapper(_submittedData.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _submittedData.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _submittedData.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_submittedData.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubmittedDataWrapper)) {
			return false;
		}

		SubmittedDataWrapper submittedDataWrapper = (SubmittedDataWrapper)obj;

		if (Validator.equals(_submittedData, submittedDataWrapper._submittedData)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SubmittedData getWrappedSubmittedData() {
		return _submittedData;
	}

	@Override
	public SubmittedData getWrappedModel() {
		return _submittedData;
	}

	@Override
	public void resetOriginalValues() {
		_submittedData.resetOriginalValues();
	}

	private SubmittedData _submittedData;
}