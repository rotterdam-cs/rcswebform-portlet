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
import com.liferay.portal.util.PortalUtil;

import com.rcs.webform.service.ClpSerializer;
import com.rcs.webform.service.FormToPorletMapLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ryusuf
 */
public class FormToPorletMapClp extends BaseModelImpl<FormToPorletMap>
	implements FormToPorletMap {
	public FormToPorletMapClp() {
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
	public long getPrimaryKey() {
		return _formToPorletMapId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFormToPorletMapId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _formToPorletMapId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("formToPorletMapId", getFormToPorletMapId());
		attributes.put("active", getActive());
		attributes.put("creationDate", getCreationDate());
		attributes.put("modificationDate", getModificationDate());
		attributes.put("modificationUser", getModificationUser());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
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

		Long formId = (Long)attributes.get("formId");

		if (formId != null) {
			setFormId(formId);
		}

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}
	}

	@Override
	public long getFormToPorletMapId() {
		return _formToPorletMapId;
	}

	@Override
	public void setFormToPorletMapId(long formToPorletMapId) {
		_formToPorletMapId = formToPorletMapId;

		if (_formToPorletMapRemoteModel != null) {
			try {
				Class<?> clazz = _formToPorletMapRemoteModel.getClass();

				Method method = clazz.getMethod("setFormToPorletMapId",
						long.class);

				method.invoke(_formToPorletMapRemoteModel, formToPorletMapId);
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

		if (_formToPorletMapRemoteModel != null) {
			try {
				Class<?> clazz = _formToPorletMapRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_formToPorletMapRemoteModel, active);
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

		if (_formToPorletMapRemoteModel != null) {
			try {
				Class<?> clazz = _formToPorletMapRemoteModel.getClass();

				Method method = clazz.getMethod("setCreationDate", Date.class);

				method.invoke(_formToPorletMapRemoteModel, creationDate);
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

		if (_formToPorletMapRemoteModel != null) {
			try {
				Class<?> clazz = _formToPorletMapRemoteModel.getClass();

				Method method = clazz.getMethod("setModificationDate",
						Date.class);

				method.invoke(_formToPorletMapRemoteModel, modificationDate);
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

		if (_formToPorletMapRemoteModel != null) {
			try {
				Class<?> clazz = _formToPorletMapRemoteModel.getClass();

				Method method = clazz.getMethod("setModificationUser",
						String.class);

				method.invoke(_formToPorletMapRemoteModel, modificationUser);
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

		if (_formToPorletMapRemoteModel != null) {
			try {
				Class<?> clazz = _formToPorletMapRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_formToPorletMapRemoteModel, groupId);
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

		if (_formToPorletMapRemoteModel != null) {
			try {
				Class<?> clazz = _formToPorletMapRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_formToPorletMapRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_formToPorletMapRemoteModel != null) {
			try {
				Class<?> clazz = _formToPorletMapRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_formToPorletMapRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_formToPorletMapRemoteModel != null) {
			try {
				Class<?> clazz = _formToPorletMapRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_formToPorletMapRemoteModel, userName);
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

		if (_formToPorletMapRemoteModel != null) {
			try {
				Class<?> clazz = _formToPorletMapRemoteModel.getClass();

				Method method = clazz.getMethod("setFormId", long.class);

				method.invoke(_formToPorletMapRemoteModel, formId);
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

		if (_formToPorletMapRemoteModel != null) {
			try {
				Class<?> clazz = _formToPorletMapRemoteModel.getClass();

				Method method = clazz.getMethod("setPortletId", String.class);

				method.invoke(_formToPorletMapRemoteModel, portletId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFormToPorletMapRemoteModel() {
		return _formToPorletMapRemoteModel;
	}

	public void setFormToPorletMapRemoteModel(
		BaseModel<?> formToPorletMapRemoteModel) {
		_formToPorletMapRemoteModel = formToPorletMapRemoteModel;
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

		Class<?> remoteModelClass = _formToPorletMapRemoteModel.getClass();

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

		Object returnValue = method.invoke(_formToPorletMapRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FormToPorletMapLocalServiceUtil.addFormToPorletMap(this);
		}
		else {
			FormToPorletMapLocalServiceUtil.updateFormToPorletMap(this);
		}
	}

	@Override
	public FormToPorletMap toEscapedModel() {
		return (FormToPorletMap)ProxyUtil.newProxyInstance(FormToPorletMap.class.getClassLoader(),
			new Class[] { FormToPorletMap.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FormToPorletMapClp clone = new FormToPorletMapClp();

		clone.setFormToPorletMapId(getFormToPorletMapId());
		clone.setActive(getActive());
		clone.setCreationDate(getCreationDate());
		clone.setModificationDate(getModificationDate());
		clone.setModificationUser(getModificationUser());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setFormId(getFormId());
		clone.setPortletId(getPortletId());

		return clone;
	}

	@Override
	public int compareTo(FormToPorletMap formToPorletMap) {
		long primaryKey = formToPorletMap.getPrimaryKey();

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

		if (!(obj instanceof FormToPorletMapClp)) {
			return false;
		}

		FormToPorletMapClp formToPorletMap = (FormToPorletMapClp)obj;

		long primaryKey = formToPorletMap.getPrimaryKey();

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

		sb.append("{formToPorletMapId=");
		sb.append(getFormToPorletMapId());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", creationDate=");
		sb.append(getCreationDate());
		sb.append(", modificationDate=");
		sb.append(getModificationDate());
		sb.append(", modificationUser=");
		sb.append(getModificationUser());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", formId=");
		sb.append(getFormId());
		sb.append(", portletId=");
		sb.append(getPortletId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.rcs.webform.model.FormToPorletMap");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>formToPorletMapId</column-name><column-value><![CDATA[");
		sb.append(getFormToPorletMapId());
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
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formId</column-name><column-value><![CDATA[");
		sb.append(getFormId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletId</column-name><column-value><![CDATA[");
		sb.append(getPortletId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _formToPorletMapId;
	private boolean _active;
	private Date _creationDate;
	private Date _modificationDate;
	private String _modificationUser;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private long _formId;
	private String _portletId;
	private BaseModel<?> _formToPorletMapRemoteModel;
}