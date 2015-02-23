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

package com.rcs.dbService.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.rcs.dbService.model.WebformValue;
import com.rcs.dbService.model.WebformValueModel;
import com.rcs.dbService.model.WebformValueSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the WebformValue service. Represents a row in the &quot;RcsWebform_WebformValue&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rcs.dbService.model.WebformValueModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WebformValueImpl}.
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformValueImpl
 * @see com.rcs.dbService.model.WebformValue
 * @see com.rcs.dbService.model.WebformValueModel
 * @generated
 */
@JSON(strict = true)
public class WebformValueModelImpl extends BaseModelImpl<WebformValue>
	implements WebformValueModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a webform value model instance should use the {@link com.rcs.dbService.model.WebformValue} interface instead.
	 */
	public static final String TABLE_NAME = "RcsWebform_WebformValue";
	public static final Object[][] TABLE_COLUMNS = {
			{ "webformValueId", Types.BIGINT },
			{ "webformTableId", Types.BIGINT },
			{ "webformColumnId", Types.BIGINT },
			{ "webformRowId", Types.BIGINT },
			{ "data_", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table RcsWebform_WebformValue (webformValueId LONG not null primary key,webformTableId LONG,webformColumnId LONG,webformRowId LONG,data_ LONG)";
	public static final String TABLE_SQL_DROP = "drop table RcsWebform_WebformValue";
	public static final String ORDER_BY_JPQL = " ORDER BY webformValue.webformTableId ASC, webformValue.webformRowId ASC, webformValue.webformColumnId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY RcsWebform_WebformValue.webformTableId ASC, RcsWebform_WebformValue.webformRowId ASC, RcsWebform_WebformValue.webformColumnId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rcs.dbService.model.WebformValue"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rcs.dbService.model.WebformValue"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rcs.dbService.model.WebformValue"),
			true);
	public static long WEBFORMTABLEID_COLUMN_BITMASK = 1L;
	public static long WEBFORMROWID_COLUMN_BITMASK = 2L;
	public static long WEBFORMCOLUMNID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static WebformValue toModel(WebformValueSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		WebformValue model = new WebformValueImpl();

		model.setWebformValueId(soapModel.getWebformValueId());
		model.setWebformTableId(soapModel.getWebformTableId());
		model.setWebformColumnId(soapModel.getWebformColumnId());
		model.setWebformRowId(soapModel.getWebformRowId());
		model.setData(soapModel.getData());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<WebformValue> toModels(WebformValueSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<WebformValue> models = new ArrayList<WebformValue>(soapModels.length);

		for (WebformValueSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rcs.dbService.model.WebformValue"));

	public WebformValueModelImpl() {
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
	public Class<?> getModelClass() {
		return WebformValue.class;
	}

	@Override
	public String getModelClassName() {
		return WebformValue.class.getName();
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

		Long data = (Long)attributes.get("data");

		if (data != null) {
			setData(data);
		}
	}

	@JSON
	@Override
	public long getWebformValueId() {
		return _webformValueId;
	}

	@Override
	public void setWebformValueId(long webformValueId) {
		_webformValueId = webformValueId;
	}

	@JSON
	@Override
	public long getWebformTableId() {
		return _webformTableId;
	}

	@Override
	public void setWebformTableId(long webformTableId) {
		_columnBitmask = -1L;

		if (!_setOriginalWebformTableId) {
			_setOriginalWebformTableId = true;

			_originalWebformTableId = _webformTableId;
		}

		_webformTableId = webformTableId;
	}

	public long getOriginalWebformTableId() {
		return _originalWebformTableId;
	}

	@JSON
	@Override
	public long getWebformColumnId() {
		return _webformColumnId;
	}

	@Override
	public void setWebformColumnId(long webformColumnId) {
		_columnBitmask = -1L;

		_webformColumnId = webformColumnId;
	}

	@JSON
	@Override
	public long getWebformRowId() {
		return _webformRowId;
	}

	@Override
	public void setWebformRowId(long webformRowId) {
		_columnBitmask = -1L;

		_webformRowId = webformRowId;
	}

	@JSON
	@Override
	public long getData() {
		return _data;
	}

	@Override
	public void setData(long data) {
		_data = data;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			WebformValue.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public WebformValue toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (WebformValue)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		WebformValueImpl webformValueImpl = new WebformValueImpl();

		webformValueImpl.setWebformValueId(getWebformValueId());
		webformValueImpl.setWebformTableId(getWebformTableId());
		webformValueImpl.setWebformColumnId(getWebformColumnId());
		webformValueImpl.setWebformRowId(getWebformRowId());
		webformValueImpl.setData(getData());

		webformValueImpl.resetOriginalValues();

		return webformValueImpl;
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

		if (!(obj instanceof WebformValue)) {
			return false;
		}

		WebformValue webformValue = (WebformValue)obj;

		long primaryKey = webformValue.getPrimaryKey();

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
	public void resetOriginalValues() {
		WebformValueModelImpl webformValueModelImpl = this;

		webformValueModelImpl._originalWebformTableId = webformValueModelImpl._webformTableId;

		webformValueModelImpl._setOriginalWebformTableId = false;

		webformValueModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<WebformValue> toCacheModel() {
		WebformValueCacheModel webformValueCacheModel = new WebformValueCacheModel();

		webformValueCacheModel.webformValueId = getWebformValueId();

		webformValueCacheModel.webformTableId = getWebformTableId();

		webformValueCacheModel.webformColumnId = getWebformColumnId();

		webformValueCacheModel.webformRowId = getWebformRowId();

		webformValueCacheModel.data = getData();

		return webformValueCacheModel;
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

	private static ClassLoader _classLoader = WebformValue.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			WebformValue.class
		};
	private long _webformValueId;
	private long _webformTableId;
	private long _originalWebformTableId;
	private boolean _setOriginalWebformTableId;
	private long _webformColumnId;
	private long _webformRowId;
	private long _data;
	private long _columnBitmask;
	private WebformValue _escapedModel;
}