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
import com.rcs.dbService.service.WebformTableLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rikad.ramadhan@rotterdam-cs.com
 */
public class WebformTableClp extends BaseModelImpl<WebformTable>
	implements WebformTable {
	public WebformTableClp() {
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
	public long getPrimaryKey() {
		return _webformTableId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWebformTableId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _webformTableId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("webformTableId", getWebformTableId());
		attributes.put("portletId", getPortletId());
		attributes.put("webformCounter", getWebformCounter());

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
	}

	@Override
	public long getWebformTableId() {
		return _webformTableId;
	}

	@Override
	public void setWebformTableId(long webformTableId) {
		_webformTableId = webformTableId;

		if (_webformTableRemoteModel != null) {
			try {
				Class<?> clazz = _webformTableRemoteModel.getClass();

				Method method = clazz.getMethod("setWebformTableId", long.class);

				method.invoke(_webformTableRemoteModel, webformTableId);
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

		if (_webformTableRemoteModel != null) {
			try {
				Class<?> clazz = _webformTableRemoteModel.getClass();

				Method method = clazz.getMethod("setPortletId", String.class);

				method.invoke(_webformTableRemoteModel, portletId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWebformCounter() {
		return _webformCounter;
	}

	@Override
	public void setWebformCounter(String webformCounter) {
		_webformCounter = webformCounter;

		if (_webformTableRemoteModel != null) {
			try {
				Class<?> clazz = _webformTableRemoteModel.getClass();

				Method method = clazz.getMethod("setWebformCounter",
						String.class);

				method.invoke(_webformTableRemoteModel, webformCounter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getWebformTableRemoteModel() {
		return _webformTableRemoteModel;
	}

	public void setWebformTableRemoteModel(BaseModel<?> webformTableRemoteModel) {
		_webformTableRemoteModel = webformTableRemoteModel;
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

		Class<?> remoteModelClass = _webformTableRemoteModel.getClass();

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

		Object returnValue = method.invoke(_webformTableRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			WebformTableLocalServiceUtil.addWebformTable(this);
		}
		else {
			WebformTableLocalServiceUtil.updateWebformTable(this);
		}
	}

	@Override
	public WebformTable toEscapedModel() {
		return (WebformTable)ProxyUtil.newProxyInstance(WebformTable.class.getClassLoader(),
			new Class[] { WebformTable.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WebformTableClp clone = new WebformTableClp();

		clone.setWebformTableId(getWebformTableId());
		clone.setPortletId(getPortletId());
		clone.setWebformCounter(getWebformCounter());

		return clone;
	}

	@Override
	public int compareTo(WebformTable webformTable) {
		long primaryKey = webformTable.getPrimaryKey();

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

		if (!(obj instanceof WebformTableClp)) {
			return false;
		}

		WebformTableClp webformTable = (WebformTableClp)obj;

		long primaryKey = webformTable.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{webformTableId=");
		sb.append(getWebformTableId());
		sb.append(", portletId=");
		sb.append(getPortletId());
		sb.append(", webformCounter=");
		sb.append(getWebformCounter());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.rcs.dbService.model.WebformTable");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>webformTableId</column-name><column-value><![CDATA[");
		sb.append(getWebformTableId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletId</column-name><column-value><![CDATA[");
		sb.append(getPortletId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>webformCounter</column-name><column-value><![CDATA[");
		sb.append(getWebformCounter());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _webformTableId;
	private String _portletId;
	private String _webformCounter;
	private BaseModel<?> _webformTableRemoteModel;
	private Class<?> _clpSerializerClass = com.rcs.dbService.service.ClpSerializer.class;
}