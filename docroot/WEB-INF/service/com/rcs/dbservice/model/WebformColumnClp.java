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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.rcs.dbService.service.ClpSerializer;
import com.rcs.dbService.service.WebformColumnLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rikad.ramadhan@rotterdam-cs.com
 */
public class WebformColumnClp extends BaseModelImpl<WebformColumn>
	implements WebformColumn {
	public WebformColumnClp() {
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
	public long getPrimaryKey() {
		return _webformColumnId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWebformColumnId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _webformColumnId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getWebformColumnId() {
		return _webformColumnId;
	}

	@Override
	public void setWebformColumnId(long webformColumnId) {
		_webformColumnId = webformColumnId;

		if (_webformColumnRemoteModel != null) {
			try {
				Class<?> clazz = _webformColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setWebformColumnId", long.class);

				method.invoke(_webformColumnRemoteModel, webformColumnId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getWebformTableId() {
		return _webformTableId;
	}

	@Override
	public void setWebformTableId(long webformTableId) {
		_webformTableId = webformTableId;

		if (_webformColumnRemoteModel != null) {
			try {
				Class<?> clazz = _webformColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setWebformTableId", long.class);

				method.invoke(_webformColumnRemoteModel, webformTableId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_webformColumnRemoteModel != null) {
			try {
				Class<?> clazz = _webformColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_webformColumnRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_type = type;

		if (_webformColumnRemoteModel != null) {
			try {
				Class<?> clazz = _webformColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setType", int.class);

				method.invoke(_webformColumnRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getInputType() {
		return _inputType;
	}

	@Override
	public void setInputType(int inputType) {
		_inputType = inputType;

		if (_webformColumnRemoteModel != null) {
			try {
				Class<?> clazz = _webformColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setInputType", int.class);

				method.invoke(_webformColumnRemoteModel, inputType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsRequired() {
		return _isRequired;
	}

	@Override
	public boolean isIsRequired() {
		return _isRequired;
	}

	@Override
	public void setIsRequired(boolean isRequired) {
		_isRequired = isRequired;

		if (_webformColumnRemoteModel != null) {
			try {
				Class<?> clazz = _webformColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setIsRequired", boolean.class);

				method.invoke(_webformColumnRemoteModel, isRequired);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPlaceHolder() {
		return _placeHolder;
	}

	@Override
	public void setPlaceHolder(String placeHolder) {
		_placeHolder = placeHolder;

		if (_webformColumnRemoteModel != null) {
			try {
				Class<?> clazz = _webformColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setPlaceHolder", String.class);

				method.invoke(_webformColumnRemoteModel, placeHolder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getValidation() {
		return _validation;
	}

	@Override
	public void setValidation(String validation) {
		_validation = validation;

		if (_webformColumnRemoteModel != null) {
			try {
				Class<?> clazz = _webformColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setValidation", String.class);

				method.invoke(_webformColumnRemoteModel, validation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomValidation() {
		return _customValidation;
	}

	@Override
	public void setCustomValidation(String customValidation) {
		_customValidation = customValidation;

		if (_webformColumnRemoteModel != null) {
			try {
				Class<?> clazz = _webformColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomValidation",
						String.class);

				method.invoke(_webformColumnRemoteModel, customValidation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLabelClass() {
		return _labelClass;
	}

	@Override
	public void setLabelClass(String labelClass) {
		_labelClass = labelClass;

		if (_webformColumnRemoteModel != null) {
			try {
				Class<?> clazz = _webformColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setLabelClass", String.class);

				method.invoke(_webformColumnRemoteModel, labelClass);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInputClass() {
		return _inputClass;
	}

	@Override
	public void setInputClass(String inputClass) {
		_inputClass = inputClass;

		if (_webformColumnRemoteModel != null) {
			try {
				Class<?> clazz = _webformColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setInputClass", String.class);

				method.invoke(_webformColumnRemoteModel, inputClass);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaxLength() {
		return _maxLength;
	}

	@Override
	public void setMaxLength(String maxLength) {
		_maxLength = maxLength;

		if (_webformColumnRemoteModel != null) {
			try {
				Class<?> clazz = _webformColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setMaxLength", String.class);

				method.invoke(_webformColumnRemoteModel, maxLength);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getWebformColumnRemoteModel() {
		return _webformColumnRemoteModel;
	}

	public void setWebformColumnRemoteModel(
		BaseModel<?> webformColumnRemoteModel) {
		_webformColumnRemoteModel = webformColumnRemoteModel;
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

		Class<?> remoteModelClass = _webformColumnRemoteModel.getClass();

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

		Object returnValue = method.invoke(_webformColumnRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			WebformColumnLocalServiceUtil.addWebformColumn(this);
		}
		else {
			WebformColumnLocalServiceUtil.updateWebformColumn(this);
		}
	}

	@Override
	public WebformColumn toEscapedModel() {
		return (WebformColumn)ProxyUtil.newProxyInstance(WebformColumn.class.getClassLoader(),
			new Class[] { WebformColumn.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WebformColumnClp clone = new WebformColumnClp();

		clone.setWebformColumnId(getWebformColumnId());
		clone.setWebformTableId(getWebformTableId());
		clone.setName(getName());
		clone.setType(getType());
		clone.setInputType(getInputType());
		clone.setIsRequired(getIsRequired());
		clone.setPlaceHolder(getPlaceHolder());
		clone.setValidation(getValidation());
		clone.setCustomValidation(getCustomValidation());
		clone.setLabelClass(getLabelClass());
		clone.setInputClass(getInputClass());
		clone.setMaxLength(getMaxLength());

		return clone;
	}

	@Override
	public int compareTo(WebformColumn webformColumn) {
		long primaryKey = webformColumn.getPrimaryKey();

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

		if (!(obj instanceof WebformColumnClp)) {
			return false;
		}

		WebformColumnClp webformColumn = (WebformColumnClp)obj;

		long primaryKey = webformColumn.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{webformColumnId=");
		sb.append(getWebformColumnId());
		sb.append(", webformTableId=");
		sb.append(getWebformTableId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", inputType=");
		sb.append(getInputType());
		sb.append(", isRequired=");
		sb.append(getIsRequired());
		sb.append(", placeHolder=");
		sb.append(getPlaceHolder());
		sb.append(", validation=");
		sb.append(getValidation());
		sb.append(", customValidation=");
		sb.append(getCustomValidation());
		sb.append(", labelClass=");
		sb.append(getLabelClass());
		sb.append(", inputClass=");
		sb.append(getInputClass());
		sb.append(", maxLength=");
		sb.append(getMaxLength());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.rcs.dbService.model.WebformColumn");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>webformColumnId</column-name><column-value><![CDATA[");
		sb.append(getWebformColumnId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>webformTableId</column-name><column-value><![CDATA[");
		sb.append(getWebformTableId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inputType</column-name><column-value><![CDATA[");
		sb.append(getInputType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isRequired</column-name><column-value><![CDATA[");
		sb.append(getIsRequired());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>placeHolder</column-name><column-value><![CDATA[");
		sb.append(getPlaceHolder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>validation</column-name><column-value><![CDATA[");
		sb.append(getValidation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customValidation</column-name><column-value><![CDATA[");
		sb.append(getCustomValidation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>labelClass</column-name><column-value><![CDATA[");
		sb.append(getLabelClass());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inputClass</column-name><column-value><![CDATA[");
		sb.append(getInputClass());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxLength</column-name><column-value><![CDATA[");
		sb.append(getMaxLength());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _webformColumnId;
	private long _webformTableId;
	private String _name;
	private int _type;
	private int _inputType;
	private boolean _isRequired;
	private String _placeHolder;
	private String _validation;
	private String _customValidation;
	private String _labelClass;
	private String _inputClass;
	private String _maxLength;
	private BaseModel<?> _webformColumnRemoteModel;
	private Class<?> _clpSerializerClass = com.rcs.dbService.service.ClpSerializer.class;
}