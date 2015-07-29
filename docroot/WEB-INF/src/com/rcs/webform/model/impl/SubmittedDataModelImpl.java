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

package com.rcs.webform.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.rcs.webform.model.SubmittedData;
import com.rcs.webform.model.SubmittedDataModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SubmittedData service. Represents a row in the &quot;rcswebform_SubmittedData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rcs.webform.model.SubmittedDataModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SubmittedDataImpl}.
 * </p>
 *
 * @author ryusuf
 * @see SubmittedDataImpl
 * @see com.rcs.webform.model.SubmittedData
 * @see com.rcs.webform.model.SubmittedDataModel
 * @generated
 */
public class SubmittedDataModelImpl extends BaseModelImpl<SubmittedData>
	implements SubmittedDataModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a submitted data model instance should use the {@link com.rcs.webform.model.SubmittedData} interface instead.
	 */
	public static final String TABLE_NAME = "rcswebform_SubmittedData";
	public static final Object[][] TABLE_COLUMNS = {
			{ "submittedDataId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "active_", Types.BOOLEAN },
			{ "creationDate", Types.TIMESTAMP },
			{ "modificationDate", Types.TIMESTAMP },
			{ "modificationUser", Types.VARCHAR },
			{ "formId", Types.BIGINT },
			{ "portletId", Types.VARCHAR },
			{ "formItemId", Types.BIGINT },
			{ "userInput", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table rcswebform_SubmittedData (submittedDataId LONG not null primary key,groupId LONG,companyId LONG,active_ BOOLEAN,creationDate DATE null,modificationDate DATE null,modificationUser VARCHAR(75) null,formId LONG,portletId VARCHAR(75) null,formItemId LONG,userInput STRING null)";
	public static final String TABLE_SQL_DROP = "drop table rcswebform_SubmittedData";
	public static final String ORDER_BY_JPQL = " ORDER BY submittedData.submittedDataId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY rcswebform_SubmittedData.submittedDataId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rcs.webform.model.SubmittedData"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rcs.webform.model.SubmittedData"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rcs.webform.model.SubmittedData"));

	public SubmittedDataModelImpl() {
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

	@Override
	public long getSubmittedDataId() {
		return _submittedDataId;
	}

	@Override
	public void setSubmittedDataId(long submittedDataId) {
		_submittedDataId = submittedDataId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
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
	}

	@Override
	public Date getCreationDate() {
		return _creationDate;
	}

	@Override
	public void setCreationDate(Date creationDate) {
		_creationDate = creationDate;
	}

	@Override
	public Date getModificationDate() {
		return _modificationDate;
	}

	@Override
	public void setModificationDate(Date modificationDate) {
		_modificationDate = modificationDate;
	}

	@Override
	public String getModificationUser() {
		if (_modificationUser == null) {
			return StringPool.BLANK;
		}
		else {
			return _modificationUser;
		}
	}

	@Override
	public void setModificationUser(String modificationUser) {
		_modificationUser = modificationUser;
	}

	@Override
	public long getFormId() {
		return _formId;
	}

	@Override
	public void setFormId(long formId) {
		_formId = formId;
	}

	@Override
	public String getPortletId() {
		if (_portletId == null) {
			return StringPool.BLANK;
		}
		else {
			return _portletId;
		}
	}

	@Override
	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	@Override
	public long getFormItemId() {
		return _formItemId;
	}

	@Override
	public void setFormItemId(long formItemId) {
		_formItemId = formItemId;
	}

	@Override
	public String getUserInput() {
		if (_userInput == null) {
			return StringPool.BLANK;
		}
		else {
			return _userInput;
		}
	}

	@Override
	public void setUserInput(String userInput) {
		_userInput = userInput;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			SubmittedData.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SubmittedData toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SubmittedData)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SubmittedDataImpl submittedDataImpl = new SubmittedDataImpl();

		submittedDataImpl.setSubmittedDataId(getSubmittedDataId());
		submittedDataImpl.setGroupId(getGroupId());
		submittedDataImpl.setCompanyId(getCompanyId());
		submittedDataImpl.setActive(getActive());
		submittedDataImpl.setCreationDate(getCreationDate());
		submittedDataImpl.setModificationDate(getModificationDate());
		submittedDataImpl.setModificationUser(getModificationUser());
		submittedDataImpl.setFormId(getFormId());
		submittedDataImpl.setPortletId(getPortletId());
		submittedDataImpl.setFormItemId(getFormItemId());
		submittedDataImpl.setUserInput(getUserInput());

		submittedDataImpl.resetOriginalValues();

		return submittedDataImpl;
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

		if (!(obj instanceof SubmittedData)) {
			return false;
		}

		SubmittedData submittedData = (SubmittedData)obj;

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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<SubmittedData> toCacheModel() {
		SubmittedDataCacheModel submittedDataCacheModel = new SubmittedDataCacheModel();

		submittedDataCacheModel.submittedDataId = getSubmittedDataId();

		submittedDataCacheModel.groupId = getGroupId();

		submittedDataCacheModel.companyId = getCompanyId();

		submittedDataCacheModel.active = getActive();

		Date creationDate = getCreationDate();

		if (creationDate != null) {
			submittedDataCacheModel.creationDate = creationDate.getTime();
		}
		else {
			submittedDataCacheModel.creationDate = Long.MIN_VALUE;
		}

		Date modificationDate = getModificationDate();

		if (modificationDate != null) {
			submittedDataCacheModel.modificationDate = modificationDate.getTime();
		}
		else {
			submittedDataCacheModel.modificationDate = Long.MIN_VALUE;
		}

		submittedDataCacheModel.modificationUser = getModificationUser();

		String modificationUser = submittedDataCacheModel.modificationUser;

		if ((modificationUser != null) && (modificationUser.length() == 0)) {
			submittedDataCacheModel.modificationUser = null;
		}

		submittedDataCacheModel.formId = getFormId();

		submittedDataCacheModel.portletId = getPortletId();

		String portletId = submittedDataCacheModel.portletId;

		if ((portletId != null) && (portletId.length() == 0)) {
			submittedDataCacheModel.portletId = null;
		}

		submittedDataCacheModel.formItemId = getFormItemId();

		submittedDataCacheModel.userInput = getUserInput();

		String userInput = submittedDataCacheModel.userInput;

		if ((userInput != null) && (userInput.length() == 0)) {
			submittedDataCacheModel.userInput = null;
		}

		return submittedDataCacheModel;
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

	private static ClassLoader _classLoader = SubmittedData.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SubmittedData.class
		};
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
	private SubmittedData _escapedModel;
}