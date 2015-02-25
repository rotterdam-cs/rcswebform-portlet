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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.rcs.dbService.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rikad.ramadhan@rotterdam-cs.com
 */
public class WebformValueClp extends BaseModelImpl<WebformValue>
	implements WebformValue {
	public WebformValueClp() {
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
	public long getPrimaryKey() {
		return _webformValueId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWebformValueId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _webformValueId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getWebformValueId() {
		return _webformValueId;
	}

	@Override
	public void setWebformValueId(long webformValueId) {
		_webformValueId = webformValueId;

		if (_webformValueRemoteModel != null) {
			try {
				Class<?> clazz = _webformValueRemoteModel.getClass();

				Method method = clazz.getMethod("setWebformValueId", long.class);

				method.invoke(_webformValueRemoteModel, webformValueId);
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

		if (_webformValueRemoteModel != null) {
			try {
				Class<?> clazz = _webformValueRemoteModel.getClass();

				Method method = clazz.getMethod("setWebformTableId", long.class);

				method.invoke(_webformValueRemoteModel, webformTableId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getWebformColumnId() {
		return _webformColumnId;
	}

	@Override
	public void setWebformColumnId(long webformColumnId) {
		_webformColumnId = webformColumnId;

		if (_webformValueRemoteModel != null) {
			try {
				Class<?> clazz = _webformValueRemoteModel.getClass();

				Method method = clazz.getMethod("setWebformColumnId", long.class);

				method.invoke(_webformValueRemoteModel, webformColumnId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getWebformRowId() {
		return _webformRowId;
	}

	@Override
	public void setWebformRowId(long webformRowId) {
		_webformRowId = webformRowId;

		if (_webformValueRemoteModel != null) {
			try {
				Class<?> clazz = _webformValueRemoteModel.getClass();

				Method method = clazz.getMethod("setWebformRowId", long.class);

				method.invoke(_webformValueRemoteModel, webformRowId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getData() {
		return _data;
	}

	@Override
	public void setData(String data) {
		_data = data;

		if (_webformValueRemoteModel != null) {
			try {
				Class<?> clazz = _webformValueRemoteModel.getClass();

				Method method = clazz.getMethod("setData", String.class);

				method.invoke(_webformValueRemoteModel, data);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getWebformValueRemoteModel() {
		return _webformValueRemoteModel;
	}

	public void setWebformValueRemoteModel(BaseModel<?> webformValueRemoteModel) {
		_webformValueRemoteModel = webformValueRemoteModel;
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

		Class<?> remoteModelClass = _webformValueRemoteModel.getClass();

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

		Object returnValue = method.invoke(_webformValueRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public WebformValue toEscapedModel() {
		return (WebformValue)ProxyUtil.newProxyInstance(WebformValue.class.getClassLoader(),
			new Class[] { WebformValue.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WebformValueClp clone = new WebformValueClp();

		clone.setWebformValueId(getWebformValueId());
		clone.setWebformTableId(getWebformTableId());
		clone.setWebformColumnId(getWebformColumnId());
		clone.setWebformRowId(getWebformRowId());
		clone.setData(getData());

		return clone;
	}

	@Override
	public int compareTo(WebformValue webformValue) {
		int value = 0;

		if (getWebformTableId() < webformValue.getWebformTableId()) {
			value = -1;
		}
		else if (getWebformTableId() > webformValue.getWebformTableId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getWebformRowId() < webformValue.getWebformRowId()) {
			value = -1;
		}
		else if (getWebformRowId() > webformValue.getWebformRowId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getWebformColumnId() < webformValue.getWebformColumnId()) {
			value = -1;
		}
		else if (getWebformColumnId() > webformValue.getWebformColumnId()) {
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

		if (!(obj instanceof WebformValueClp)) {
			return false;
		}

		WebformValueClp webformValue = (WebformValueClp)obj;

		long primaryKey = webformValue.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{webformValueId=");
		sb.append(getWebformValueId());
		sb.append(", webformTableId=");
		sb.append(getWebformTableId());
		sb.append(", webformColumnId=");
		sb.append(getWebformColumnId());
		sb.append(", webformRowId=");
		sb.append(getWebformRowId());
		sb.append(", data=");
		sb.append(getData());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.rcs.dbService.model.WebformValue");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>webformValueId</column-name><column-value><![CDATA[");
		sb.append(getWebformValueId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>webformTableId</column-name><column-value><![CDATA[");
		sb.append(getWebformTableId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>webformColumnId</column-name><column-value><![CDATA[");
		sb.append(getWebformColumnId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>webformRowId</column-name><column-value><![CDATA[");
		sb.append(getWebformRowId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>data</column-name><column-value><![CDATA[");
		sb.append(getData());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _webformValueId;
	private long _webformTableId;
	private long _webformColumnId;
	private long _webformRowId;
	private String _data;
	private BaseModel<?> _webformValueRemoteModel;
	private Class<?> _clpSerializerClass = com.rcs.dbService.service.ClpSerializer.class;
}