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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.rcs.webform.service.ClpSerializer;
import com.rcs.webform.service.SubmittedDataLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ryusuf
 */
public class SubmittedDataClp extends BaseModelImpl<SubmittedData>
	implements SubmittedData {
	public SubmittedDataClp() {
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
	public long getPrimaryKey() {
		return _submittedDataId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSubmittedDataId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _submittedDataId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSubmittedDataId() {
		return _submittedDataId;
	}

	@Override
	public void setSubmittedDataId(long submittedDataId) {
		_submittedDataId = submittedDataId;

		if (_submittedDataRemoteModel != null) {
			try {
				Class<?> clazz = _submittedDataRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmittedDataId", long.class);

				method.invoke(_submittedDataRemoteModel, submittedDataId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_submittedDataRemoteModel != null) {
			try {
				Class<?> clazz = _submittedDataRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_submittedDataRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_submittedDataRemoteModel != null) {
			try {
				Class<?> clazz = _submittedDataRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_submittedDataRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_submittedDataRemoteModel != null) {
			try {
				Class<?> clazz = _submittedDataRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_submittedDataRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreationDate() {
		return _creationDate;
	}

	@Override
	public void setCreationDate(Date creationDate) {
		_creationDate = creationDate;

		if (_submittedDataRemoteModel != null) {
			try {
				Class<?> clazz = _submittedDataRemoteModel.getClass();

				Method method = clazz.getMethod("setCreationDate", Date.class);

				method.invoke(_submittedDataRemoteModel, creationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModificationDate() {
		return _modificationDate;
	}

	@Override
	public void setModificationDate(Date modificationDate) {
		_modificationDate = modificationDate;

		if (_submittedDataRemoteModel != null) {
			try {
				Class<?> clazz = _submittedDataRemoteModel.getClass();

				Method method = clazz.getMethod("setModificationDate",
						Date.class);

				method.invoke(_submittedDataRemoteModel, modificationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModificationUser() {
		return _modificationUser;
	}

	@Override
	public void setModificationUser(String modificationUser) {
		_modificationUser = modificationUser;

		if (_submittedDataRemoteModel != null) {
			try {
				Class<?> clazz = _submittedDataRemoteModel.getClass();

				Method method = clazz.getMethod("setModificationUser",
						String.class);

				method.invoke(_submittedDataRemoteModel, modificationUser);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFormId() {
		return _formId;
	}

	@Override
	public void setFormId(long formId) {
		_formId = formId;

		if (_submittedDataRemoteModel != null) {
			try {
				Class<?> clazz = _submittedDataRemoteModel.getClass();

				Method method = clazz.getMethod("setFormId", long.class);

				method.invoke(_submittedDataRemoteModel, formId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPortletId() {
		return _portletId;
	}

	@Override
	public void setPortletId(String portletId) {
		_portletId = portletId;

		if (_submittedDataRemoteModel != null) {
			try {
				Class<?> clazz = _submittedDataRemoteModel.getClass();

				Method method = clazz.getMethod("setPortletId", String.class);

				method.invoke(_submittedDataRemoteModel, portletId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFormItemId() {
		return _formItemId;
	}

	@Override
	public void setFormItemId(long formItemId) {
		_formItemId = formItemId;

		if (_submittedDataRemoteModel != null) {
			try {
				Class<?> clazz = _submittedDataRemoteModel.getClass();

				Method method = clazz.getMethod("setFormItemId", long.class);

				method.invoke(_submittedDataRemoteModel, formItemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserInput() {
		return _userInput;
	}

	@Override
	public void setUserInput(String userInput) {
		_userInput = userInput;

		if (_submittedDataRemoteModel != null) {
			try {
				Class<?> clazz = _submittedDataRemoteModel.getClass();

				Method method = clazz.getMethod("setUserInput", String.class);

				method.invoke(_submittedDataRemoteModel, userInput);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSubmittedDataRemoteModel() {
		return _submittedDataRemoteModel;
	}

	public void setSubmittedDataRemoteModel(
		BaseModel<?> submittedDataRemoteModel) {
		_submittedDataRemoteModel = submittedDataRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _submittedDataRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_submittedDataRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SubmittedDataLocalServiceUtil.addSubmittedData(this);
		}
		else {
			SubmittedDataLocalServiceUtil.updateSubmittedData(this);
		}
	}

	@Override
	public SubmittedData toEscapedModel() {
		return (SubmittedData)ProxyUtil.newProxyInstance(SubmittedData.class.getClassLoader(),
			new Class[] { SubmittedData.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SubmittedDataClp clone = new SubmittedDataClp();

		clone.setSubmittedDataId(getSubmittedDataId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setActive(getActive());
		clone.setCreationDate(getCreationDate());
		clone.setModificationDate(getModificationDate());
		clone.setModificationUser(getModificationUser());
		clone.setFormId(getFormId());
		clone.setPortletId(getPortletId());
		clone.setFormItemId(getFormItemId());
		clone.setUserInput(getUserInput());

		return clone;
	}

	@Override
	public int compareTo(SubmittedData submittedData) {
		long primaryKey = submittedData.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubmittedDataClp)) {
			return false;
		}

		SubmittedDataClp submittedData = (SubmittedDataClp)obj;

		long primaryKey = submittedData.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{submittedDataId=");
		sb.append(getSubmittedDataId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", creationDate=");
		sb.append(getCreationDate());
		sb.append(", modificationDate=");
		sb.append(getModificationDate());
		sb.append(", modificationUser=");
		sb.append(getModificationUser());
		sb.append(", formId=");
		sb.append(getFormId());
		sb.append(", portletId=");
		sb.append(getPortletId());
		sb.append(", formItemId=");
		sb.append(getFormItemId());
		sb.append(", userInput=");
		sb.append(getUserInput());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.rcs.webform.model.SubmittedData");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>submittedDataId</column-name><column-value><![CDATA[");
		sb.append(getSubmittedDataId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creationDate</column-name><column-value><![CDATA[");
		sb.append(getCreationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modificationDate</column-name><column-value><![CDATA[");
		sb.append(getModificationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modificationUser</column-name><column-value><![CDATA[");
		sb.append(getModificationUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formId</column-name><column-value><![CDATA[");
		sb.append(getFormId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletId</column-name><column-value><![CDATA[");
		sb.append(getPortletId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formItemId</column-name><column-value><![CDATA[");
		sb.append(getFormItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userInput</column-name><column-value><![CDATA[");
		sb.append(getUserInput());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _submittedDataId;
	private long _groupId;
	private long _companyId;
	private boolean _active;
	private Date _creationDate;
	private Date _modificationDate;
	private String _modificationUser;
	private long _formId;
	private String _portletId;
	private long _formItemId;
	private String _userInput;
	private BaseModel<?> _submittedDataRemoteModel;
}