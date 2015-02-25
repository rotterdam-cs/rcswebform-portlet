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

import com.rcs.dbService.model.WebformRow;
import com.rcs.dbService.model.WebformRowModel;
import com.rcs.dbService.model.WebformRowSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the WebformRow service. Represents a row in the &quot;RcsWebform_WebformRow&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rcs.dbService.model.WebformRowModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WebformRowImpl}.
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformRowImpl
 * @see com.rcs.dbService.model.WebformRow
 * @see com.rcs.dbService.model.WebformRowModel
 * @generated
 */
@JSON(strict = true)
public class WebformRowModelImpl extends BaseModelImpl<WebformRow>
	implements WebformRowModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a webform row model instance should use the {@link com.rcs.dbService.model.WebformRow} interface instead.
	 */
	public static final String TABLE_NAME = "RcsWebform_WebformRow";
	public static final Object[][] TABLE_COLUMNS = {
			{ "webformRowId", Types.BIGINT },
			{ "webformTableId", Types.BIGINT },
			{ "updateDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table RcsWebform_WebformRow (webformRowId LONG not null primary key,webformTableId LONG,updateDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table RcsWebform_WebformRow";
	public static final String ORDER_BY_JPQL = " ORDER BY webformRow.webformRowId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY RcsWebform_WebformRow.webformRowId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rcs.dbService.model.WebformRow"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rcs.dbService.model.WebformRow"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rcs.dbService.model.WebformRow"),
			true);
	public static long WEBFORMTABLEID_COLUMN_BITMASK = 1L;
	public static long WEBFORMROWID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static WebformRow toModel(WebformRowSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		WebformRow model = new WebformRowImpl();

		model.setWebformRowId(soapModel.getWebformRowId());
		model.setWebformTableId(soapModel.getWebformTableId());
		model.setUpdateDate(soapModel.getUpdateDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<WebformRow> toModels(WebformRowSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<WebformRow> models = new ArrayList<WebformRow>(soapModels.length);

		for (WebformRowSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rcs.dbService.model.WebformRow"));

	public WebformRowModelImpl() {
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
	public Class<?> getModelClass() {
		return WebformRow.class;
	}

	@Override
	public String getModelClassName() {
		return WebformRow.class.getName();
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

	@JSON
	@Override
	public long getWebformRowId() {
		return _webformRowId;
	}

	@Override
	public void setWebformRowId(long webformRowId) {
		_webformRowId = webformRowId;
	}

	@JSON
	@Override
	public long getWebformTableId() {
		return _webformTableId;
	}

	@Override
	public void setWebformTableId(long webformTableId) {
		_columnBitmask |= WEBFORMTABLEID_COLUMN_BITMASK;

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
	public Date getUpdateDate() {
		return _updateDate;
	}

	@Override
	public void setUpdateDate(Date updateDate) {
		_updateDate = updateDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			WebformRow.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public WebformRow toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (WebformRow)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		WebformRowImpl webformRowImpl = new WebformRowImpl();

		webformRowImpl.setWebformRowId(getWebformRowId());
		webformRowImpl.setWebformTableId(getWebformTableId());
		webformRowImpl.setUpdateDate(getUpdateDate());

		webformRowImpl.resetOriginalValues();

		return webformRowImpl;
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

		if (!(obj instanceof WebformRow)) {
			return false;
		}

		WebformRow webformRow = (WebformRow)obj;

		long primaryKey = webformRow.getPrimaryKey();

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
		WebformRowModelImpl webformRowModelImpl = this;

		webformRowModelImpl._originalWebformTableId = webformRowModelImpl._webformTableId;

		webformRowModelImpl._setOriginalWebformTableId = false;

		webformRowModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<WebformRow> toCacheModel() {
		WebformRowCacheModel webformRowCacheModel = new WebformRowCacheModel();

		webformRowCacheModel.webformRowId = getWebformRowId();

		webformRowCacheModel.webformTableId = getWebformTableId();

		Date updateDate = getUpdateDate();

		if (updateDate != null) {
			webformRowCacheModel.updateDate = updateDate.getTime();
		}
		else {
			webformRowCacheModel.updateDate = Long.MIN_VALUE;
		}

		return webformRowCacheModel;
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

	private static ClassLoader _classLoader = WebformRow.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			WebformRow.class
		};
	private long _webformRowId;
	private long _webformTableId;
	private long _originalWebformTableId;
	private boolean _setOriginalWebformTableId;
	private Date _updateDate;
	private long _columnBitmask;
	private WebformRow _escapedModel;
}