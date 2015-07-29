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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.rcs.webform.model.Form;
import com.rcs.webform.model.FormModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Form service. Represents a row in the &quot;rcswebform_Form&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rcs.webform.model.FormModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FormImpl}.
 * </p>
 *
 * @author ryusuf
 * @see FormImpl
 * @see com.rcs.webform.model.Form
 * @see com.rcs.webform.model.FormModel
 * @generated
 */
public class FormModelImpl extends BaseModelImpl<Form> implements FormModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a form model instance should use the {@link com.rcs.webform.model.Form} interface instead.
	 */
	public static final String TABLE_NAME = "rcswebform_Form";
	public static final Object[][] TABLE_COLUMNS = {
			{ "formId", Types.BIGINT },
			{ "active_", Types.BOOLEAN },
			{ "creationDate", Types.TIMESTAMP },
			{ "modificationDate", Types.TIMESTAMP },
			{ "modificationUser", Types.VARCHAR },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "formAttrId", Types.VARCHAR },
			{ "formAttrClass", Types.VARCHAR },
			{ "title", Types.VARCHAR },
			{ "desc_", Types.VARCHAR },
			{ "useCaptcha", Types.BOOLEAN },
			{ "successMessage", Types.VARCHAR },
			{ "successURL", Types.VARCHAR },
			{ "submitLabel", Types.VARCHAR },
			{ "submitAttrId", Types.VARCHAR },
			{ "submitAttrClass", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table rcswebform_Form (formId LONG not null primary key,active_ BOOLEAN,creationDate DATE null,modificationDate DATE null,modificationUser VARCHAR(75) null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,formAttrId VARCHAR(75) null,formAttrClass VARCHAR(75) null,title VARCHAR(75) null,desc_ VARCHAR(75) null,useCaptcha BOOLEAN,successMessage VARCHAR(75) null,successURL VARCHAR(75) null,submitLabel VARCHAR(75) null,submitAttrId VARCHAR(75) null,submitAttrClass VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table rcswebform_Form";
	public static final String ORDER_BY_JPQL = " ORDER BY form.formId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY rcswebform_Form.formId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rcs.webform.model.Form"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rcs.webform.model.Form"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rcs.webform.model.Form"));

	public FormModelImpl() {
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
	public Class<?> getModelClass() {
		return Form.class;
	}

	@Override
	public String getModelClassName() {
		return Form.class.getName();
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
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
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
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public String getFormAttrId() {
		if (_formAttrId == null) {
			return StringPool.BLANK;
		}
		else {
			return _formAttrId;
		}
	}

	@Override
	public void setFormAttrId(String formAttrId) {
		_formAttrId = formAttrId;
	}

	@Override
	public String getFormAttrClass() {
		if (_formAttrClass == null) {
			return StringPool.BLANK;
		}
		else {
			return _formAttrClass;
		}
	}

	@Override
	public void setFormAttrClass(String formAttrClass) {
		_formAttrClass = formAttrClass;
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@Override
	public String getDesc() {
		if (_desc == null) {
			return StringPool.BLANK;
		}
		else {
			return _desc;
		}
	}

	@Override
	public void setDesc(String desc) {
		_desc = desc;
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
	}

	@Override
	public String getSuccessMessage() {
		if (_successMessage == null) {
			return StringPool.BLANK;
		}
		else {
			return _successMessage;
		}
	}

	@Override
	public void setSuccessMessage(String successMessage) {
		_successMessage = successMessage;
	}

	@Override
	public String getSuccessURL() {
		if (_successURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _successURL;
		}
	}

	@Override
	public void setSuccessURL(String successURL) {
		_successURL = successURL;
	}

	@Override
	public String getSubmitLabel() {
		if (_submitLabel == null) {
			return StringPool.BLANK;
		}
		else {
			return _submitLabel;
		}
	}

	@Override
	public void setSubmitLabel(String submitLabel) {
		_submitLabel = submitLabel;
	}

	@Override
	public String getSubmitAttrId() {
		if (_submitAttrId == null) {
			return StringPool.BLANK;
		}
		else {
			return _submitAttrId;
		}
	}

	@Override
	public void setSubmitAttrId(String submitAttrId) {
		_submitAttrId = submitAttrId;
	}

	@Override
	public String getSubmitAttrClass() {
		if (_submitAttrClass == null) {
			return StringPool.BLANK;
		}
		else {
			return _submitAttrClass;
		}
	}

	@Override
	public void setSubmitAttrClass(String submitAttrClass) {
		_submitAttrClass = submitAttrClass;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Form.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Form toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Form)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FormImpl formImpl = new FormImpl();

		formImpl.setFormId(getFormId());
		formImpl.setActive(getActive());
		formImpl.setCreationDate(getCreationDate());
		formImpl.setModificationDate(getModificationDate());
		formImpl.setModificationUser(getModificationUser());
		formImpl.setGroupId(getGroupId());
		formImpl.setCompanyId(getCompanyId());
		formImpl.setUserId(getUserId());
		formImpl.setUserName(getUserName());
		formImpl.setFormAttrId(getFormAttrId());
		formImpl.setFormAttrClass(getFormAttrClass());
		formImpl.setTitle(getTitle());
		formImpl.setDesc(getDesc());
		formImpl.setUseCaptcha(getUseCaptcha());
		formImpl.setSuccessMessage(getSuccessMessage());
		formImpl.setSuccessURL(getSuccessURL());
		formImpl.setSubmitLabel(getSubmitLabel());
		formImpl.setSubmitAttrId(getSubmitAttrId());
		formImpl.setSubmitAttrClass(getSubmitAttrClass());

		formImpl.resetOriginalValues();

		return formImpl;
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

		if (!(obj instanceof Form)) {
			return false;
		}

		Form form = (Form)obj;

		long primaryKey = form.getPrimaryKey();

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
	public CacheModel<Form> toCacheModel() {
		FormCacheModel formCacheModel = new FormCacheModel();

		formCacheModel.formId = getFormId();

		formCacheModel.active = getActive();

		Date creationDate = getCreationDate();

		if (creationDate != null) {
			formCacheModel.creationDate = creationDate.getTime();
		}
		else {
			formCacheModel.creationDate = Long.MIN_VALUE;
		}

		Date modificationDate = getModificationDate();

		if (modificationDate != null) {
			formCacheModel.modificationDate = modificationDate.getTime();
		}
		else {
			formCacheModel.modificationDate = Long.MIN_VALUE;
		}

		formCacheModel.modificationUser = getModificationUser();

		String modificationUser = formCacheModel.modificationUser;

		if ((modificationUser != null) && (modificationUser.length() == 0)) {
			formCacheModel.modificationUser = null;
		}

		formCacheModel.groupId = getGroupId();

		formCacheModel.companyId = getCompanyId();

		formCacheModel.userId = getUserId();

		formCacheModel.userName = getUserName();

		String userName = formCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			formCacheModel.userName = null;
		}

		formCacheModel.formAttrId = getFormAttrId();

		String formAttrId = formCacheModel.formAttrId;

		if ((formAttrId != null) && (formAttrId.length() == 0)) {
			formCacheModel.formAttrId = null;
		}

		formCacheModel.formAttrClass = getFormAttrClass();

		String formAttrClass = formCacheModel.formAttrClass;

		if ((formAttrClass != null) && (formAttrClass.length() == 0)) {
			formCacheModel.formAttrClass = null;
		}

		formCacheModel.title = getTitle();

		String title = formCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			formCacheModel.title = null;
		}

		formCacheModel.desc = getDesc();

		String desc = formCacheModel.desc;

		if ((desc != null) && (desc.length() == 0)) {
			formCacheModel.desc = null;
		}

		formCacheModel.useCaptcha = getUseCaptcha();

		formCacheModel.successMessage = getSuccessMessage();

		String successMessage = formCacheModel.successMessage;

		if ((successMessage != null) && (successMessage.length() == 0)) {
			formCacheModel.successMessage = null;
		}

		formCacheModel.successURL = getSuccessURL();

		String successURL = formCacheModel.successURL;

		if ((successURL != null) && (successURL.length() == 0)) {
			formCacheModel.successURL = null;
		}

		formCacheModel.submitLabel = getSubmitLabel();

		String submitLabel = formCacheModel.submitLabel;

		if ((submitLabel != null) && (submitLabel.length() == 0)) {
			formCacheModel.submitLabel = null;
		}

		formCacheModel.submitAttrId = getSubmitAttrId();

		String submitAttrId = formCacheModel.submitAttrId;

		if ((submitAttrId != null) && (submitAttrId.length() == 0)) {
			formCacheModel.submitAttrId = null;
		}

		formCacheModel.submitAttrClass = getSubmitAttrClass();

		String submitAttrClass = formCacheModel.submitAttrClass;

		if ((submitAttrClass != null) && (submitAttrClass.length() == 0)) {
			formCacheModel.submitAttrClass = null;
		}

		return formCacheModel;
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

	private static ClassLoader _classLoader = Form.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Form.class };
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
	private Form _escapedModel;
}