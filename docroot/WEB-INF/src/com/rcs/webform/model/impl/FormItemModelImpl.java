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

import com.rcs.webform.model.FormItem;
import com.rcs.webform.model.FormItemModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the FormItem service. Represents a row in the &quot;rcswebform_FormItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rcs.webform.model.FormItemModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FormItemImpl}.
 * </p>
 *
 * @author ryusuf
 * @see FormItemImpl
 * @see com.rcs.webform.model.FormItem
 * @see com.rcs.webform.model.FormItemModel
 * @generated
 */
public class FormItemModelImpl extends BaseModelImpl<FormItem>
	implements FormItemModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a form item model instance should use the {@link com.rcs.webform.model.FormItem} interface instead.
	 */
	public static final String TABLE_NAME = "rcswebform_FormItem";
	public static final Object[][] TABLE_COLUMNS = {
			{ "formItemId", Types.BIGINT },
			{ "active_", Types.BOOLEAN },
			{ "creationDate", Types.TIMESTAMP },
			{ "modificationDate", Types.TIMESTAMP },
			{ "modificationUser", Types.VARCHAR },
			{ "formId", Types.BIGINT },
			{ "formItemAttrId", Types.VARCHAR },
			{ "formItemAttrClass", Types.VARCHAR },
			{ "label", Types.VARCHAR },
			{ "labelAttrId", Types.VARCHAR },
			{ "labelAttrClass", Types.VARCHAR },
			{ "inputAttrId", Types.VARCHAR },
			{ "inputAttrClass", Types.VARCHAR },
			{ "type_", Types.VARCHAR },
			{ "options", Types.VARCHAR },
			{ "mandatory", Types.BOOLEAN },
			{ "defaultValue", Types.VARCHAR },
			{ "order_", Types.INTEGER },
			{ "validationType", Types.VARCHAR },
			{ "validationRegexValue", Types.VARCHAR },
			{ "errorValidationMessage", Types.VARCHAR },
			{ "errorMandatoryMessage", Types.VARCHAR },
			{ "hintMessage", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table rcswebform_FormItem (formItemId LONG not null primary key,active_ BOOLEAN,creationDate DATE null,modificationDate DATE null,modificationUser VARCHAR(75) null,formId LONG,formItemAttrId VARCHAR(75) null,formItemAttrClass VARCHAR(75) null,label VARCHAR(75) null,labelAttrId VARCHAR(75) null,labelAttrClass VARCHAR(75) null,inputAttrId VARCHAR(75) null,inputAttrClass VARCHAR(75) null,type_ VARCHAR(75) null,options VARCHAR(75) null,mandatory BOOLEAN,defaultValue VARCHAR(75) null,order_ INTEGER,validationType VARCHAR(75) null,validationRegexValue VARCHAR(75) null,errorValidationMessage VARCHAR(75) null,errorMandatoryMessage VARCHAR(75) null,hintMessage VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table rcswebform_FormItem";
	public static final String ORDER_BY_JPQL = " ORDER BY formItem.formItemId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY rcswebform_FormItem.formItemId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rcs.webform.model.FormItem"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rcs.webform.model.FormItem"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rcs.webform.model.FormItem"));

	public FormItemModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _formItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFormItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _formItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FormItem.class;
	}

	@Override
	public String getModelClassName() {
		return FormItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("formItemId", getFormItemId());
		attributes.put("active", getActive());
		attributes.put("creationDate", getCreationDate());
		attributes.put("modificationDate", getModificationDate());
		attributes.put("modificationUser", getModificationUser());
		attributes.put("formId", getFormId());
		attributes.put("formItemAttrId", getFormItemAttrId());
		attributes.put("formItemAttrClass", getFormItemAttrClass());
		attributes.put("label", getLabel());
		attributes.put("labelAttrId", getLabelAttrId());
		attributes.put("labelAttrClass", getLabelAttrClass());
		attributes.put("inputAttrId", getInputAttrId());
		attributes.put("inputAttrClass", getInputAttrClass());
		attributes.put("type", getType());
		attributes.put("options", getOptions());
		attributes.put("mandatory", getMandatory());
		attributes.put("defaultValue", getDefaultValue());
		attributes.put("order", getOrder());
		attributes.put("validationType", getValidationType());
		attributes.put("validationRegexValue", getValidationRegexValue());
		attributes.put("errorValidationMessage", getErrorValidationMessage());
		attributes.put("errorMandatoryMessage", getErrorMandatoryMessage());
		attributes.put("hintMessage", getHintMessage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long formItemId = (Long)attributes.get("formItemId");

		if (formItemId != null) {
			setFormItemId(formItemId);
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

		String formItemAttrId = (String)attributes.get("formItemAttrId");

		if (formItemAttrId != null) {
			setFormItemAttrId(formItemAttrId);
		}

		String formItemAttrClass = (String)attributes.get("formItemAttrClass");

		if (formItemAttrClass != null) {
			setFormItemAttrClass(formItemAttrClass);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}

		String labelAttrId = (String)attributes.get("labelAttrId");

		if (labelAttrId != null) {
			setLabelAttrId(labelAttrId);
		}

		String labelAttrClass = (String)attributes.get("labelAttrClass");

		if (labelAttrClass != null) {
			setLabelAttrClass(labelAttrClass);
		}

		String inputAttrId = (String)attributes.get("inputAttrId");

		if (inputAttrId != null) {
			setInputAttrId(inputAttrId);
		}

		String inputAttrClass = (String)attributes.get("inputAttrClass");

		if (inputAttrClass != null) {
			setInputAttrClass(inputAttrClass);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String options = (String)attributes.get("options");

		if (options != null) {
			setOptions(options);
		}

		Boolean mandatory = (Boolean)attributes.get("mandatory");

		if (mandatory != null) {
			setMandatory(mandatory);
		}

		String defaultValue = (String)attributes.get("defaultValue");

		if (defaultValue != null) {
			setDefaultValue(defaultValue);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		String validationType = (String)attributes.get("validationType");

		if (validationType != null) {
			setValidationType(validationType);
		}

		String validationRegexValue = (String)attributes.get(
				"validationRegexValue");

		if (validationRegexValue != null) {
			setValidationRegexValue(validationRegexValue);
		}

		String errorValidationMessage = (String)attributes.get(
				"errorValidationMessage");

		if (errorValidationMessage != null) {
			setErrorValidationMessage(errorValidationMessage);
		}

		String errorMandatoryMessage = (String)attributes.get(
				"errorMandatoryMessage");

		if (errorMandatoryMessage != null) {
			setErrorMandatoryMessage(errorMandatoryMessage);
		}

		String hintMessage = (String)attributes.get("hintMessage");

		if (hintMessage != null) {
			setHintMessage(hintMessage);
		}
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
	public String getFormItemAttrId() {
		if (_formItemAttrId == null) {
			return StringPool.BLANK;
		}
		else {
			return _formItemAttrId;
		}
	}

	@Override
	public void setFormItemAttrId(String formItemAttrId) {
		_formItemAttrId = formItemAttrId;
	}

	@Override
	public String getFormItemAttrClass() {
		if (_formItemAttrClass == null) {
			return StringPool.BLANK;
		}
		else {
			return _formItemAttrClass;
		}
	}

	@Override
	public void setFormItemAttrClass(String formItemAttrClass) {
		_formItemAttrClass = formItemAttrClass;
	}

	@Override
	public String getLabel() {
		if (_label == null) {
			return StringPool.BLANK;
		}
		else {
			return _label;
		}
	}

	@Override
	public void setLabel(String label) {
		_label = label;
	}

	@Override
	public String getLabelAttrId() {
		if (_labelAttrId == null) {
			return StringPool.BLANK;
		}
		else {
			return _labelAttrId;
		}
	}

	@Override
	public void setLabelAttrId(String labelAttrId) {
		_labelAttrId = labelAttrId;
	}

	@Override
	public String getLabelAttrClass() {
		if (_labelAttrClass == null) {
			return StringPool.BLANK;
		}
		else {
			return _labelAttrClass;
		}
	}

	@Override
	public void setLabelAttrClass(String labelAttrClass) {
		_labelAttrClass = labelAttrClass;
	}

	@Override
	public String getInputAttrId() {
		if (_inputAttrId == null) {
			return StringPool.BLANK;
		}
		else {
			return _inputAttrId;
		}
	}

	@Override
	public void setInputAttrId(String inputAttrId) {
		_inputAttrId = inputAttrId;
	}

	@Override
	public String getInputAttrClass() {
		if (_inputAttrClass == null) {
			return StringPool.BLANK;
		}
		else {
			return _inputAttrClass;
		}
	}

	@Override
	public void setInputAttrClass(String inputAttrClass) {
		_inputAttrClass = inputAttrClass;
	}

	@Override
	public String getType() {
		if (_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_type = type;
	}

	@Override
	public String getOptions() {
		if (_options == null) {
			return StringPool.BLANK;
		}
		else {
			return _options;
		}
	}

	@Override
	public void setOptions(String options) {
		_options = options;
	}

	@Override
	public boolean getMandatory() {
		return _mandatory;
	}

	@Override
	public boolean isMandatory() {
		return _mandatory;
	}

	@Override
	public void setMandatory(boolean mandatory) {
		_mandatory = mandatory;
	}

	@Override
	public String getDefaultValue() {
		if (_defaultValue == null) {
			return StringPool.BLANK;
		}
		else {
			return _defaultValue;
		}
	}

	@Override
	public void setDefaultValue(String defaultValue) {
		_defaultValue = defaultValue;
	}

	@Override
	public int getOrder() {
		return _order;
	}

	@Override
	public void setOrder(int order) {
		_order = order;
	}

	@Override
	public String getValidationType() {
		if (_validationType == null) {
			return StringPool.BLANK;
		}
		else {
			return _validationType;
		}
	}

	@Override
	public void setValidationType(String validationType) {
		_validationType = validationType;
	}

	@Override
	public String getValidationRegexValue() {
		if (_validationRegexValue == null) {
			return StringPool.BLANK;
		}
		else {
			return _validationRegexValue;
		}
	}

	@Override
	public void setValidationRegexValue(String validationRegexValue) {
		_validationRegexValue = validationRegexValue;
	}

	@Override
	public String getErrorValidationMessage() {
		if (_errorValidationMessage == null) {
			return StringPool.BLANK;
		}
		else {
			return _errorValidationMessage;
		}
	}

	@Override
	public void setErrorValidationMessage(String errorValidationMessage) {
		_errorValidationMessage = errorValidationMessage;
	}

	@Override
	public String getErrorMandatoryMessage() {
		if (_errorMandatoryMessage == null) {
			return StringPool.BLANK;
		}
		else {
			return _errorMandatoryMessage;
		}
	}

	@Override
	public void setErrorMandatoryMessage(String errorMandatoryMessage) {
		_errorMandatoryMessage = errorMandatoryMessage;
	}

	@Override
	public String getHintMessage() {
		if (_hintMessage == null) {
			return StringPool.BLANK;
		}
		else {
			return _hintMessage;
		}
	}

	@Override
	public void setHintMessage(String hintMessage) {
		_hintMessage = hintMessage;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			FormItem.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FormItem toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (FormItem)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FormItemImpl formItemImpl = new FormItemImpl();

		formItemImpl.setFormItemId(getFormItemId());
		formItemImpl.setActive(getActive());
		formItemImpl.setCreationDate(getCreationDate());
		formItemImpl.setModificationDate(getModificationDate());
		formItemImpl.setModificationUser(getModificationUser());
		formItemImpl.setFormId(getFormId());
		formItemImpl.setFormItemAttrId(getFormItemAttrId());
		formItemImpl.setFormItemAttrClass(getFormItemAttrClass());
		formItemImpl.setLabel(getLabel());
		formItemImpl.setLabelAttrId(getLabelAttrId());
		formItemImpl.setLabelAttrClass(getLabelAttrClass());
		formItemImpl.setInputAttrId(getInputAttrId());
		formItemImpl.setInputAttrClass(getInputAttrClass());
		formItemImpl.setType(getType());
		formItemImpl.setOptions(getOptions());
		formItemImpl.setMandatory(getMandatory());
		formItemImpl.setDefaultValue(getDefaultValue());
		formItemImpl.setOrder(getOrder());
		formItemImpl.setValidationType(getValidationType());
		formItemImpl.setValidationRegexValue(getValidationRegexValue());
		formItemImpl.setErrorValidationMessage(getErrorValidationMessage());
		formItemImpl.setErrorMandatoryMessage(getErrorMandatoryMessage());
		formItemImpl.setHintMessage(getHintMessage());

		formItemImpl.resetOriginalValues();

		return formItemImpl;
	}

	@Override
	public int compareTo(FormItem formItem) {
		long primaryKey = formItem.getPrimaryKey();

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

		if (!(obj instanceof FormItem)) {
			return false;
		}

		FormItem formItem = (FormItem)obj;

		long primaryKey = formItem.getPrimaryKey();

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
	public CacheModel<FormItem> toCacheModel() {
		FormItemCacheModel formItemCacheModel = new FormItemCacheModel();

		formItemCacheModel.formItemId = getFormItemId();

		formItemCacheModel.active = getActive();

		Date creationDate = getCreationDate();

		if (creationDate != null) {
			formItemCacheModel.creationDate = creationDate.getTime();
		}
		else {
			formItemCacheModel.creationDate = Long.MIN_VALUE;
		}

		Date modificationDate = getModificationDate();

		if (modificationDate != null) {
			formItemCacheModel.modificationDate = modificationDate.getTime();
		}
		else {
			formItemCacheModel.modificationDate = Long.MIN_VALUE;
		}

		formItemCacheModel.modificationUser = getModificationUser();

		String modificationUser = formItemCacheModel.modificationUser;

		if ((modificationUser != null) && (modificationUser.length() == 0)) {
			formItemCacheModel.modificationUser = null;
		}

		formItemCacheModel.formId = getFormId();

		formItemCacheModel.formItemAttrId = getFormItemAttrId();

		String formItemAttrId = formItemCacheModel.formItemAttrId;

		if ((formItemAttrId != null) && (formItemAttrId.length() == 0)) {
			formItemCacheModel.formItemAttrId = null;
		}

		formItemCacheModel.formItemAttrClass = getFormItemAttrClass();

		String formItemAttrClass = formItemCacheModel.formItemAttrClass;

		if ((formItemAttrClass != null) && (formItemAttrClass.length() == 0)) {
			formItemCacheModel.formItemAttrClass = null;
		}

		formItemCacheModel.label = getLabel();

		String label = formItemCacheModel.label;

		if ((label != null) && (label.length() == 0)) {
			formItemCacheModel.label = null;
		}

		formItemCacheModel.labelAttrId = getLabelAttrId();

		String labelAttrId = formItemCacheModel.labelAttrId;

		if ((labelAttrId != null) && (labelAttrId.length() == 0)) {
			formItemCacheModel.labelAttrId = null;
		}

		formItemCacheModel.labelAttrClass = getLabelAttrClass();

		String labelAttrClass = formItemCacheModel.labelAttrClass;

		if ((labelAttrClass != null) && (labelAttrClass.length() == 0)) {
			formItemCacheModel.labelAttrClass = null;
		}

		formItemCacheModel.inputAttrId = getInputAttrId();

		String inputAttrId = formItemCacheModel.inputAttrId;

		if ((inputAttrId != null) && (inputAttrId.length() == 0)) {
			formItemCacheModel.inputAttrId = null;
		}

		formItemCacheModel.inputAttrClass = getInputAttrClass();

		String inputAttrClass = formItemCacheModel.inputAttrClass;

		if ((inputAttrClass != null) && (inputAttrClass.length() == 0)) {
			formItemCacheModel.inputAttrClass = null;
		}

		formItemCacheModel.type = getType();

		String type = formItemCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			formItemCacheModel.type = null;
		}

		formItemCacheModel.options = getOptions();

		String options = formItemCacheModel.options;

		if ((options != null) && (options.length() == 0)) {
			formItemCacheModel.options = null;
		}

		formItemCacheModel.mandatory = getMandatory();

		formItemCacheModel.defaultValue = getDefaultValue();

		String defaultValue = formItemCacheModel.defaultValue;

		if ((defaultValue != null) && (defaultValue.length() == 0)) {
			formItemCacheModel.defaultValue = null;
		}

		formItemCacheModel.order = getOrder();

		formItemCacheModel.validationType = getValidationType();

		String validationType = formItemCacheModel.validationType;

		if ((validationType != null) && (validationType.length() == 0)) {
			formItemCacheModel.validationType = null;
		}

		formItemCacheModel.validationRegexValue = getValidationRegexValue();

		String validationRegexValue = formItemCacheModel.validationRegexValue;

		if ((validationRegexValue != null) &&
				(validationRegexValue.length() == 0)) {
			formItemCacheModel.validationRegexValue = null;
		}

		formItemCacheModel.errorValidationMessage = getErrorValidationMessage();

		String errorValidationMessage = formItemCacheModel.errorValidationMessage;

		if ((errorValidationMessage != null) &&
				(errorValidationMessage.length() == 0)) {
			formItemCacheModel.errorValidationMessage = null;
		}

		formItemCacheModel.errorMandatoryMessage = getErrorMandatoryMessage();

		String errorMandatoryMessage = formItemCacheModel.errorMandatoryMessage;

		if ((errorMandatoryMessage != null) &&
				(errorMandatoryMessage.length() == 0)) {
			formItemCacheModel.errorMandatoryMessage = null;
		}

		formItemCacheModel.hintMessage = getHintMessage();

		String hintMessage = formItemCacheModel.hintMessage;

		if ((hintMessage != null) && (hintMessage.length() == 0)) {
			formItemCacheModel.hintMessage = null;
		}

		return formItemCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{formItemId=");
		sb.append(getFormItemId());
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
		sb.append(", formItemAttrId=");
		sb.append(getFormItemAttrId());
		sb.append(", formItemAttrClass=");
		sb.append(getFormItemAttrClass());
		sb.append(", label=");
		sb.append(getLabel());
		sb.append(", labelAttrId=");
		sb.append(getLabelAttrId());
		sb.append(", labelAttrClass=");
		sb.append(getLabelAttrClass());
		sb.append(", inputAttrId=");
		sb.append(getInputAttrId());
		sb.append(", inputAttrClass=");
		sb.append(getInputAttrClass());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", options=");
		sb.append(getOptions());
		sb.append(", mandatory=");
		sb.append(getMandatory());
		sb.append(", defaultValue=");
		sb.append(getDefaultValue());
		sb.append(", order=");
		sb.append(getOrder());
		sb.append(", validationType=");
		sb.append(getValidationType());
		sb.append(", validationRegexValue=");
		sb.append(getValidationRegexValue());
		sb.append(", errorValidationMessage=");
		sb.append(getErrorValidationMessage());
		sb.append(", errorMandatoryMessage=");
		sb.append(getErrorMandatoryMessage());
		sb.append(", hintMessage=");
		sb.append(getHintMessage());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append("com.rcs.webform.model.FormItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>formItemId</column-name><column-value><![CDATA[");
		sb.append(getFormItemId());
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
			"<column><column-name>formItemAttrId</column-name><column-value><![CDATA[");
		sb.append(getFormItemAttrId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formItemAttrClass</column-name><column-value><![CDATA[");
		sb.append(getFormItemAttrClass());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>label</column-name><column-value><![CDATA[");
		sb.append(getLabel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>labelAttrId</column-name><column-value><![CDATA[");
		sb.append(getLabelAttrId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>labelAttrClass</column-name><column-value><![CDATA[");
		sb.append(getLabelAttrClass());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inputAttrId</column-name><column-value><![CDATA[");
		sb.append(getInputAttrId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inputAttrClass</column-name><column-value><![CDATA[");
		sb.append(getInputAttrClass());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>options</column-name><column-value><![CDATA[");
		sb.append(getOptions());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mandatory</column-name><column-value><![CDATA[");
		sb.append(getMandatory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>defaultValue</column-name><column-value><![CDATA[");
		sb.append(getDefaultValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>order</column-name><column-value><![CDATA[");
		sb.append(getOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>validationType</column-name><column-value><![CDATA[");
		sb.append(getValidationType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>validationRegexValue</column-name><column-value><![CDATA[");
		sb.append(getValidationRegexValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>errorValidationMessage</column-name><column-value><![CDATA[");
		sb.append(getErrorValidationMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>errorMandatoryMessage</column-name><column-value><![CDATA[");
		sb.append(getErrorMandatoryMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hintMessage</column-name><column-value><![CDATA[");
		sb.append(getHintMessage());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = FormItem.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			FormItem.class
		};
	private long _formItemId;
	private boolean _active;
	private Date _creationDate;
	private Date _modificationDate;
	private String _modificationUser;
	private long _formId;
	private String _formItemAttrId;
	private String _formItemAttrClass;
	private String _label;
	private String _labelAttrId;
	private String _labelAttrClass;
	private String _inputAttrId;
	private String _inputAttrClass;
	private String _type;
	private String _options;
	private boolean _mandatory;
	private String _defaultValue;
	private int _order;
	private String _validationType;
	private String _validationRegexValue;
	private String _errorValidationMessage;
	private String _errorMandatoryMessage;
	private String _hintMessage;
	private FormItem _escapedModel;
}