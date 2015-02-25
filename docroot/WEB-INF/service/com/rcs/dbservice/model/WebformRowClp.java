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
import com.rcs.dbService.service.WebformRowLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rikad.ramadhan@rotterdam-cs.com
 */
public class WebformRowClp extends BaseModelImpl<WebformRow>
	implements WebformRow {
	public WebformRowClp() {
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
	public long getPrimaryKey() {
		return _webformRowId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWebformRowId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _webformRowId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getWebformRowId() {
		return _webformRowId;
	}

	@Override
	public void setWebformRowId(long webformRowId) {
		_webformRowId = webformRowId;

		if (_webformRowRemoteModel != null) {
			try {
				Class<?> clazz = _webformRowRemoteModel.getClass();

				Method method = clazz.getMethod("setWebformRowId", long.class);

				method.invoke(_webformRowRemoteModel, webformRowId);
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

		if (_webformRowRemoteModel != null) {
			try {
				Class<?> clazz = _webformRowRemoteModel.getClass();

				Method method = clazz.getMethod("setWebformTableId", long.class);

				method.invoke(_webformRowRemoteModel, webformTableId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getUpdateDate() {
		return _updateDate;
	}

	@Override
	public void setUpdateDate(Date updateDate) {
		_updateDate = updateDate;

		if (_webformRowRemoteModel != null) {
			try {
				Class<?> clazz = _webformRowRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateDate", Date.class);

				method.invoke(_webformRowRemoteModel, updateDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getWebformRowRemoteModel() {
		return _webformRowRemoteModel;
	}

	public void setWebformRowRemoteModel(BaseModel<?> webformRowRemoteModel) {
		_webformRowRemoteModel = webformRowRemoteModel;
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

		Class<?> remoteModelClass = _webformRowRemoteModel.getClass();

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

		Object returnValue = method.invoke(_webformRowRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			WebformRowLocalServiceUtil.addWebformRow(this);
		}
		else {
			WebformRowLocalServiceUtil.updateWebformRow(this);
		}
	}

	@Override
	public WebformRow toEscapedModel() {
		return (WebformRow)ProxyUtil.newProxyInstance(WebformRow.class.getClassLoader(),
			new Class[] { WebformRow.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WebformRowClp clone = new WebformRowClp();

		clone.setWebformRowId(getWebformRowId());
		clone.setWebformTableId(getWebformTableId());
		clone.setUpdateDate(getUpdateDate());

		return clone;
	}

	@Override
	public int compareTo(WebformRow webformRow) {
		long primaryKey = webformRow.getPrimaryKey();

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

		if (!(obj instanceof WebformRowClp)) {
			return false;
		}

		WebformRowClp webformRow = (WebformRowClp)obj;

		long primaryKey = webformRow.getPrimaryKey();

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

		sb.append("{webformRowId=");
		sb.append(getWebformRowId());
		sb.append(", webformTableId=");
		sb.append(getWebformTableId());
		sb.append(", updateDate=");
		sb.append(getUpdateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.rcs.dbService.model.WebformRow");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>webformRowId</column-name><column-value><![CDATA[");
		sb.append(getWebformRowId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>webformTableId</column-name><column-value><![CDATA[");
		sb.append(getWebformTableId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateDate</column-name><column-value><![CDATA[");
		sb.append(getUpdateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _webformRowId;
	private long _webformTableId;
	private Date _updateDate;
	private BaseModel<?> _webformRowRemoteModel;
	private Class<?> _clpSerializerClass = com.rcs.dbService.service.ClpSerializer.class;
}