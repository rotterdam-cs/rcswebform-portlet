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

package com.rcs.webform.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rcs.webform.service.ClpSerializer;
import com.rcs.webform.service.FormLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ryusuf
 */
public class FormClp extends BaseModelImpl<Form> implements Form {
	public FormClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Form.class;
	}

	@Override
	public String getModelClassName() {
		return Form.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _formId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFormId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _formId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("formId", getFormId());
		attributes.put("active", getActive());
		attributes.put("creationDate", getCreationDate());
		attributes.put("modificationDate", getModificationDate());
		attributes.put("modificationUser", getModificationUser());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("formAttrId", getFormAttrId());
		attributes.put("formAttrClass", getFormAttrClass());
		attributes.put("title", getTitle());
		attributes.put("desc", getDesc());
		attributes.put("useCaptcha", getUseCaptcha());
		attributes.put("successMessage", getSuccessMessage());
		attributes.put("successURL", getSuccessURL());
		attributes.put("submitLabel", getSubmitLabel());
		attributes.put("submitAttrId", getSubmitAttrId());
		attributes.put("submitAttrClass", getSubmitAttrClass());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long formId = (Long)attributes.get("formId");

		if (formId != null) {
			setFormId(formId);
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

		String formAttrId = (String)attributes.get("formAttrId");

		if (formAttrId != null) {
			setFormAttrId(formAttrId);
		}

		String formAttrClass = (String)attributes.get("formAttrClass");

		if (formAttrClass != null) {
			setFormAttrClass(formAttrClass);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String desc = (String)attributes.get("desc");

		if (desc != null) {
			setDesc(desc);
		}

		Boolean useCaptcha = (Boolean)attributes.get("useCaptcha");

		if (useCaptcha != null) {
			setUseCaptcha(useCaptcha);
		}

		String successMessage = (String)attributes.get("successMessage");

		if (successMessage != null) {
			setSuccessMessage(successMessage);
		}

		String successURL = (String)attributes.get("successURL");

		if (successURL != null) {
			setSuccessURL(successURL);
		}

		String submitLabel = (String)attributes.get("submitLabel");

		if (submitLabel != null) {
			setSubmitLabel(submitLabel);
		}

		String submitAttrId = (String)attributes.get("submitAttrId");

		if (submitAttrId != null) {
			setSubmitAttrId(submitAttrId);
		}

		String submitAttrClass = (String)attributes.get("submitAttrClass");

		if (submitAttrClass != null) {
			setSubmitAttrClass(submitAttrClass);
		}
	}

	@Override
	public long getFormId() {
		return _formId;
	}

	@Override
	public void setFormId(long formId) {
		_formId = formId;

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setFormId", long.class);

				method.invoke(_formRemoteModel, formId);
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

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_formRemoteModel, active);
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

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setCreationDate", Date.class);

				method.invoke(_formRemoteModel, creationDate);
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

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setModificationDate",
						Date.class);

				method.invoke(_formRemoteModel, modificationDate);
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

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setModificationUser",
						String.class);

				method.invoke(_formRemoteModel, modificationUser);
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

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_formRemoteModel, groupId);
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

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_formRemoteModel, companyId);
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

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_formRemoteModel, userId);
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

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_formRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFormAttrId() {
		return _formAttrId;
	}

	@Override
	public void setFormAttrId(String formAttrId) {
		_formAttrId = formAttrId;

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setFormAttrId", String.class);

				method.invoke(_formRemoteModel, formAttrId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFormAttrClass() {
		return _formAttrClass;
	}

	@Override
	public void setFormAttrClass(String formAttrClass) {
		_formAttrClass = formAttrClass;

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setFormAttrClass", String.class);

				method.invoke(_formRemoteModel, formAttrClass);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_formRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDesc() {
		return _desc;
	}

	@Override
	public void setDesc(String desc) {
		_desc = desc;

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setDesc", String.class);

				method.invoke(_formRemoteModel, desc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getUseCaptcha() {
		return _useCaptcha;
	}

	@Override
	public boolean isUseCaptcha() {
		return _useCaptcha;
	}

	@Override
	public void setUseCaptcha(boolean useCaptcha) {
		_useCaptcha = useCaptcha;

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setUseCaptcha", boolean.class);

				method.invoke(_formRemoteModel, useCaptcha);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSuccessMessage() {
		return _successMessage;
	}

	@Override
	public void setSuccessMessage(String successMessage) {
		_successMessage = successMessage;

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setSuccessMessage",
						String.class);

				method.invoke(_formRemoteModel, successMessage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSuccessURL() {
		return _successURL;
	}

	@Override
	public void setSuccessURL(String successURL) {
		_successURL = successURL;

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setSuccessURL", String.class);

				method.invoke(_formRemoteModel, successURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubmitLabel() {
		return _submitLabel;
	}

	@Override
	public void setSubmitLabel(String submitLabel) {
		_submitLabel = submitLabel;

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmitLabel", String.class);

				method.invoke(_formRemoteModel, submitLabel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubmitAttrId() {
		return _submitAttrId;
	}

	@Override
	public void setSubmitAttrId(String submitAttrId) {
		_submitAttrId = submitAttrId;

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmitAttrId", String.class);

				method.invoke(_formRemoteModel, submitAttrId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubmitAttrClass() {
		return _submitAttrClass;
	}

	@Override
	public void setSubmitAttrClass(String submitAttrClass) {
		_submitAttrClass = submitAttrClass;

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmitAttrClass",
						String.class);

				method.invoke(_formRemoteModel, submitAttrClass);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFormRemoteModel() {
		return _formRemoteModel;
	}

	public void setFormRemoteModel(BaseModel<?> formRemoteModel) {
		_formRemoteModel = formRemoteModel;
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

		Class<?> remoteModelClass = _formRemoteModel.getClass();

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

		Object returnValue = method.invoke(_formRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FormLocalServiceUtil.addForm(this);
		}
		else {
			FormLocalServiceUtil.updateForm(this);
		}
	}

	@Override
	public Form toEscapedModel() {
		return (Form)ProxyUtil.newProxyInstance(Form.class.getClassLoader(),
			new Class[] { Form.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FormClp clone = new FormClp();

		clone.setFormId(getFormId());
		clone.setActive(getActive());
		clone.setCreationDate(getCreationDate());
		clone.setModificationDate(getModificationDate());
		clone.setModificationUser(getModificationUser());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setFormAttrId(getFormAttrId());
		clone.setFormAttrClass(getFormAttrClass());
		clone.setTitle(getTitle());
		clone.setDesc(getDesc());
		clone.setUseCaptcha(getUseCaptcha());
		clone.setSuccessMessage(getSuccessMessage());
		clone.setSuccessURL(getSuccessURL());
		clone.setSubmitLabel(getSubmitLabel());
		clone.setSubmitAttrId(getSubmitAttrId());
		clone.setSubmitAttrClass(getSubmitAttrClass());

		return clone;
	}

	@Override
	public int compareTo(Form form) {
		int value = 0;

		if (getFormId() < form.getFormId()) {
			value = -1;
		}
		else if (getFormId() > form.getFormId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FormClp)) {
			return false;
		}

		FormClp form = (FormClp)obj;

		long primaryKey = form.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{formId=");
		sb.append(getFormId());
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
		sb.append(", formAttrId=");
		sb.append(getFormAttrId());
		sb.append(", formAttrClass=");
		sb.append(getFormAttrClass());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", desc=");
		sb.append(getDesc());
		sb.append(", useCaptcha=");
		sb.append(getUseCaptcha());
		sb.append(", successMessage=");
		sb.append(getSuccessMessage());
		sb.append(", successURL=");
		sb.append(getSuccessURL());
		sb.append(", submitLabel=");
		sb.append(getSubmitLabel());
		sb.append(", submitAttrId=");
		sb.append(getSubmitAttrId());
		sb.append(", submitAttrClass=");
		sb.append(getSubmitAttrClass());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.rcs.webform.model.Form");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>formId</column-name><column-value><![CDATA[");
		sb.append(getFormId());
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
			"<column><column-name>formAttrId</column-name><column-value><![CDATA[");
		sb.append(getFormAttrId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formAttrClass</column-name><column-value><![CDATA[");
		sb.append(getFormAttrClass());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>desc</column-name><column-value><![CDATA[");
		sb.append(getDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>useCaptcha</column-name><column-value><![CDATA[");
		sb.append(getUseCaptcha());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>successMessage</column-name><column-value><![CDATA[");
		sb.append(getSuccessMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>successURL</column-name><column-value><![CDATA[");
		sb.append(getSuccessURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>submitLabel</column-name><column-value><![CDATA[");
		sb.append(getSubmitLabel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>submitAttrId</column-name><column-value><![CDATA[");
		sb.append(getSubmitAttrId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>submitAttrClass</column-name><column-value><![CDATA[");
		sb.append(getSubmitAttrClass());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _formId;
	private boolean _active;
	private Date _creationDate;
	private Date _modificationDate;
	private String _modificationUser;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private String _formAttrId;
	private String _formAttrClass;
	private String _title;
	private String _desc;
	private boolean _useCaptcha;
	private String _successMessage;
	private String _successURL;
	private String _submitLabel;
	private String _submitAttrId;
	private String _submitAttrClass;
	private BaseModel<?> _formRemoteModel;
	private Class<?> _clpSerializerClass = com.rcs.webform.service.ClpSerializer.class;
}