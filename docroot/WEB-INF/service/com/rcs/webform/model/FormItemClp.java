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

package com.rcs.webform.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.rcs.webform.service.ClpSerializer;
import com.rcs.webform.service.FormItemLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author ryusuf
 */
public class FormItemClp extends BaseModelImpl<FormItem> implements FormItem {
	public FormItemClp() {
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
		attributes.put("optionKeys", getOptionKeys());
		attributes.put("optionValues", getOptionValues());
		attributes.put("mandatory", getMandatory());
		attributes.put("defaultValue", getDefaultValue());
		attributes.put("order", getOrder());
		attributes.put("validationType", getValidationType());
		attributes.put("validationRegexValue", getValidationRegexValue());
		attributes.put("minLength", getMinLength());
		attributes.put("maxLength", getMaxLength());
		attributes.put("errorValidationMessage", getErrorValidationMessage());
		attributes.put("errorMandatoryMessage", getErrorMandatoryMessage());
		attributes.put("errorLengthMessage", getErrorLengthMessage());
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

		String optionKeys = (String)attributes.get("optionKeys");

		if (optionKeys != null) {
			setOptionKeys(optionKeys);
		}

		String optionValues = (String)attributes.get("optionValues");

		if (optionValues != null) {
			setOptionValues(optionValues);
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

		Integer minLength = (Integer)attributes.get("minLength");

		if (minLength != null) {
			setMinLength(minLength);
		}

		Integer maxLength = (Integer)attributes.get("maxLength");

		if (maxLength != null) {
			setMaxLength(maxLength);
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

		String errorLengthMessage = (String)attributes.get("errorLengthMessage");

		if (errorLengthMessage != null) {
			setErrorLengthMessage(errorLengthMessage);
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

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setFormItemId", long.class);

				method.invoke(_formItemRemoteModel, formItemId);
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

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_formItemRemoteModel, active);
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

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCreationDate", Date.class);

				method.invoke(_formItemRemoteModel, creationDate);
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

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setModificationDate",
						Date.class);

				method.invoke(_formItemRemoteModel, modificationDate);
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

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setModificationUser",
						String.class);

				method.invoke(_formItemRemoteModel, modificationUser);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFormId() {
		return _formId;
	}

	@Override
	public void setFormId(long formId) {
		_formId = formId;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setFormId", long.class);

				method.invoke(_formItemRemoteModel, formId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFormItemAttrId() {
		return _formItemAttrId;
	}

	@Override
	public void setFormItemAttrId(String formItemAttrId) {
		_formItemAttrId = formItemAttrId;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setFormItemAttrId",
						String.class);

				method.invoke(_formItemRemoteModel, formItemAttrId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFormItemAttrClass() {
		return _formItemAttrClass;
	}

	@Override
	public void setFormItemAttrClass(String formItemAttrClass) {
		_formItemAttrClass = formItemAttrClass;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setFormItemAttrClass",
						String.class);

				method.invoke(_formItemRemoteModel, formItemAttrClass);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLabel() {
		return _label;
	}

	@Override
	public String getLabel(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getLabel(languageId);
	}

	@Override
	public String getLabel(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getLabel(languageId, useDefault);
	}

	@Override
	public String getLabel(String languageId) {
		return LocalizationUtil.getLocalization(getLabel(), languageId);
	}

	@Override
	public String getLabel(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getLabel(), languageId,
			useDefault);
	}

	@Override
	public String getLabelCurrentLanguageId() {
		return _labelCurrentLanguageId;
	}

	@Override
	public String getLabelCurrentValue() {
		Locale locale = getLocale(_labelCurrentLanguageId);

		return getLabel(locale);
	}

	@Override
	public Map<Locale, String> getLabelMap() {
		return LocalizationUtil.getLocalizationMap(getLabel());
	}

	@Override
	public void setLabel(String label) {
		_label = label;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setLabel", String.class);

				method.invoke(_formItemRemoteModel, label);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setLabel(String label, Locale locale) {
		setLabel(label, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setLabel(String label, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(label)) {
			setLabel(LocalizationUtil.updateLocalization(getLabel(), "Label",
					label, languageId, defaultLanguageId));
		}
		else {
			setLabel(LocalizationUtil.removeLocalization(getLabel(), "Label",
					languageId));
		}
	}

	@Override
	public void setLabelCurrentLanguageId(String languageId) {
		_labelCurrentLanguageId = languageId;
	}

	@Override
	public void setLabelMap(Map<Locale, String> labelMap) {
		setLabelMap(labelMap, LocaleUtil.getDefault());
	}

	@Override
	public void setLabelMap(Map<Locale, String> labelMap, Locale defaultLocale) {
		if (labelMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setLabel(LocalizationUtil.updateLocalization(labelMap, getLabel(),
					"Label", LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getLabelAttrId() {
		return _labelAttrId;
	}

	@Override
	public void setLabelAttrId(String labelAttrId) {
		_labelAttrId = labelAttrId;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setLabelAttrId", String.class);

				method.invoke(_formItemRemoteModel, labelAttrId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLabelAttrClass() {
		return _labelAttrClass;
	}

	@Override
	public void setLabelAttrClass(String labelAttrClass) {
		_labelAttrClass = labelAttrClass;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setLabelAttrClass",
						String.class);

				method.invoke(_formItemRemoteModel, labelAttrClass);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInputAttrId() {
		return _inputAttrId;
	}

	@Override
	public void setInputAttrId(String inputAttrId) {
		_inputAttrId = inputAttrId;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setInputAttrId", String.class);

				method.invoke(_formItemRemoteModel, inputAttrId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInputAttrClass() {
		return _inputAttrClass;
	}

	@Override
	public void setInputAttrClass(String inputAttrClass) {
		_inputAttrClass = inputAttrClass;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setInputAttrClass",
						String.class);

				method.invoke(_formItemRemoteModel, inputAttrClass);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_formItemRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOptionKeys() {
		return _optionKeys;
	}

	@Override
	public void setOptionKeys(String optionKeys) {
		_optionKeys = optionKeys;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setOptionKeys", String.class);

				method.invoke(_formItemRemoteModel, optionKeys);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOptionValues() {
		return _optionValues;
	}

	@Override
	public String getOptionValues(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getOptionValues(languageId);
	}

	@Override
	public String getOptionValues(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getOptionValues(languageId, useDefault);
	}

	@Override
	public String getOptionValues(String languageId) {
		return LocalizationUtil.getLocalization(getOptionValues(), languageId);
	}

	@Override
	public String getOptionValues(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getOptionValues(), languageId,
			useDefault);
	}

	@Override
	public String getOptionValuesCurrentLanguageId() {
		return _optionValuesCurrentLanguageId;
	}

	@Override
	public String getOptionValuesCurrentValue() {
		Locale locale = getLocale(_optionValuesCurrentLanguageId);

		return getOptionValues(locale);
	}

	@Override
	public Map<Locale, String> getOptionValuesMap() {
		return LocalizationUtil.getLocalizationMap(getOptionValues());
	}

	@Override
	public void setOptionValues(String optionValues) {
		_optionValues = optionValues;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setOptionValues", String.class);

				method.invoke(_formItemRemoteModel, optionValues);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setOptionValues(String optionValues, Locale locale) {
		setOptionValues(optionValues, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setOptionValues(String optionValues, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(optionValues)) {
			setOptionValues(LocalizationUtil.updateLocalization(
					getOptionValues(), "OptionValues", optionValues,
					languageId, defaultLanguageId));
		}
		else {
			setOptionValues(LocalizationUtil.removeLocalization(
					getOptionValues(), "OptionValues", languageId));
		}
	}

	@Override
	public void setOptionValuesCurrentLanguageId(String languageId) {
		_optionValuesCurrentLanguageId = languageId;
	}

	@Override
	public void setOptionValuesMap(Map<Locale, String> optionValuesMap) {
		setOptionValuesMap(optionValuesMap, LocaleUtil.getDefault());
	}

	@Override
	public void setOptionValuesMap(Map<Locale, String> optionValuesMap,
		Locale defaultLocale) {
		if (optionValuesMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setOptionValues(LocalizationUtil.updateLocalization(
					optionValuesMap, getOptionValues(), "OptionValues",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
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

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setMandatory", boolean.class);

				method.invoke(_formItemRemoteModel, mandatory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDefaultValue() {
		return _defaultValue;
	}

	@Override
	public String getDefaultValue(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDefaultValue(languageId);
	}

	@Override
	public String getDefaultValue(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDefaultValue(languageId, useDefault);
	}

	@Override
	public String getDefaultValue(String languageId) {
		return LocalizationUtil.getLocalization(getDefaultValue(), languageId);
	}

	@Override
	public String getDefaultValue(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getDefaultValue(), languageId,
			useDefault);
	}

	@Override
	public String getDefaultValueCurrentLanguageId() {
		return _defaultValueCurrentLanguageId;
	}

	@Override
	public String getDefaultValueCurrentValue() {
		Locale locale = getLocale(_defaultValueCurrentLanguageId);

		return getDefaultValue(locale);
	}

	@Override
	public Map<Locale, String> getDefaultValueMap() {
		return LocalizationUtil.getLocalizationMap(getDefaultValue());
	}

	@Override
	public void setDefaultValue(String defaultValue) {
		_defaultValue = defaultValue;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setDefaultValue", String.class);

				method.invoke(_formItemRemoteModel, defaultValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setDefaultValue(String defaultValue, Locale locale) {
		setDefaultValue(defaultValue, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setDefaultValue(String defaultValue, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(defaultValue)) {
			setDefaultValue(LocalizationUtil.updateLocalization(
					getDefaultValue(), "DefaultValue", defaultValue,
					languageId, defaultLanguageId));
		}
		else {
			setDefaultValue(LocalizationUtil.removeLocalization(
					getDefaultValue(), "DefaultValue", languageId));
		}
	}

	@Override
	public void setDefaultValueCurrentLanguageId(String languageId) {
		_defaultValueCurrentLanguageId = languageId;
	}

	@Override
	public void setDefaultValueMap(Map<Locale, String> defaultValueMap) {
		setDefaultValueMap(defaultValueMap, LocaleUtil.getDefault());
	}

	@Override
	public void setDefaultValueMap(Map<Locale, String> defaultValueMap,
		Locale defaultLocale) {
		if (defaultValueMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setDefaultValue(LocalizationUtil.updateLocalization(
					defaultValueMap, getDefaultValue(), "DefaultValue",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public int getOrder() {
		return _order;
	}

	@Override
	public void setOrder(int order) {
		_order = order;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setOrder", int.class);

				method.invoke(_formItemRemoteModel, order);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getValidationType() {
		return _validationType;
	}

	@Override
	public void setValidationType(String validationType) {
		_validationType = validationType;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setValidationType",
						String.class);

				method.invoke(_formItemRemoteModel, validationType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getValidationRegexValue() {
		return _validationRegexValue;
	}

	@Override
	public void setValidationRegexValue(String validationRegexValue) {
		_validationRegexValue = validationRegexValue;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setValidationRegexValue",
						String.class);

				method.invoke(_formItemRemoteModel, validationRegexValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMinLength() {
		return _minLength;
	}

	@Override
	public void setMinLength(int minLength) {
		_minLength = minLength;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setMinLength", int.class);

				method.invoke(_formItemRemoteModel, minLength);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMaxLength() {
		return _maxLength;
	}

	@Override
	public void setMaxLength(int maxLength) {
		_maxLength = maxLength;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setMaxLength", int.class);

				method.invoke(_formItemRemoteModel, maxLength);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getErrorValidationMessage() {
		return _errorValidationMessage;
	}

	@Override
	public String getErrorValidationMessage(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getErrorValidationMessage(languageId);
	}

	@Override
	public String getErrorValidationMessage(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getErrorValidationMessage(languageId, useDefault);
	}

	@Override
	public String getErrorValidationMessage(String languageId) {
		return LocalizationUtil.getLocalization(getErrorValidationMessage(),
			languageId);
	}

	@Override
	public String getErrorValidationMessage(String languageId,
		boolean useDefault) {
		return LocalizationUtil.getLocalization(getErrorValidationMessage(),
			languageId, useDefault);
	}

	@Override
	public String getErrorValidationMessageCurrentLanguageId() {
		return _errorValidationMessageCurrentLanguageId;
	}

	@Override
	public String getErrorValidationMessageCurrentValue() {
		Locale locale = getLocale(_errorValidationMessageCurrentLanguageId);

		return getErrorValidationMessage(locale);
	}

	@Override
	public Map<Locale, String> getErrorValidationMessageMap() {
		return LocalizationUtil.getLocalizationMap(getErrorValidationMessage());
	}

	@Override
	public void setErrorValidationMessage(String errorValidationMessage) {
		_errorValidationMessage = errorValidationMessage;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setErrorValidationMessage",
						String.class);

				method.invoke(_formItemRemoteModel, errorValidationMessage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setErrorValidationMessage(String errorValidationMessage,
		Locale locale) {
		setErrorValidationMessage(errorValidationMessage, locale,
			LocaleUtil.getDefault());
	}

	@Override
	public void setErrorValidationMessage(String errorValidationMessage,
		Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(errorValidationMessage)) {
			setErrorValidationMessage(LocalizationUtil.updateLocalization(
					getErrorValidationMessage(), "ErrorValidationMessage",
					errorValidationMessage, languageId, defaultLanguageId));
		}
		else {
			setErrorValidationMessage(LocalizationUtil.removeLocalization(
					getErrorValidationMessage(), "ErrorValidationMessage",
					languageId));
		}
	}

	@Override
	public void setErrorValidationMessageCurrentLanguageId(String languageId) {
		_errorValidationMessageCurrentLanguageId = languageId;
	}

	@Override
	public void setErrorValidationMessageMap(
		Map<Locale, String> errorValidationMessageMap) {
		setErrorValidationMessageMap(errorValidationMessageMap,
			LocaleUtil.getDefault());
	}

	@Override
	public void setErrorValidationMessageMap(
		Map<Locale, String> errorValidationMessageMap, Locale defaultLocale) {
		if (errorValidationMessageMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setErrorValidationMessage(LocalizationUtil.updateLocalization(
					errorValidationMessageMap, getErrorValidationMessage(),
					"ErrorValidationMessage",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getErrorMandatoryMessage() {
		return _errorMandatoryMessage;
	}

	@Override
	public String getErrorMandatoryMessage(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getErrorMandatoryMessage(languageId);
	}

	@Override
	public String getErrorMandatoryMessage(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getErrorMandatoryMessage(languageId, useDefault);
	}

	@Override
	public String getErrorMandatoryMessage(String languageId) {
		return LocalizationUtil.getLocalization(getErrorMandatoryMessage(),
			languageId);
	}

	@Override
	public String getErrorMandatoryMessage(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getErrorMandatoryMessage(),
			languageId, useDefault);
	}

	@Override
	public String getErrorMandatoryMessageCurrentLanguageId() {
		return _errorMandatoryMessageCurrentLanguageId;
	}

	@Override
	public String getErrorMandatoryMessageCurrentValue() {
		Locale locale = getLocale(_errorMandatoryMessageCurrentLanguageId);

		return getErrorMandatoryMessage(locale);
	}

	@Override
	public Map<Locale, String> getErrorMandatoryMessageMap() {
		return LocalizationUtil.getLocalizationMap(getErrorMandatoryMessage());
	}

	@Override
	public void setErrorMandatoryMessage(String errorMandatoryMessage) {
		_errorMandatoryMessage = errorMandatoryMessage;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setErrorMandatoryMessage",
						String.class);

				method.invoke(_formItemRemoteModel, errorMandatoryMessage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setErrorMandatoryMessage(String errorMandatoryMessage,
		Locale locale) {
		setErrorMandatoryMessage(errorMandatoryMessage, locale,
			LocaleUtil.getDefault());
	}

	@Override
	public void setErrorMandatoryMessage(String errorMandatoryMessage,
		Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(errorMandatoryMessage)) {
			setErrorMandatoryMessage(LocalizationUtil.updateLocalization(
					getErrorMandatoryMessage(), "ErrorMandatoryMessage",
					errorMandatoryMessage, languageId, defaultLanguageId));
		}
		else {
			setErrorMandatoryMessage(LocalizationUtil.removeLocalization(
					getErrorMandatoryMessage(), "ErrorMandatoryMessage",
					languageId));
		}
	}

	@Override
	public void setErrorMandatoryMessageCurrentLanguageId(String languageId) {
		_errorMandatoryMessageCurrentLanguageId = languageId;
	}

	@Override
	public void setErrorMandatoryMessageMap(
		Map<Locale, String> errorMandatoryMessageMap) {
		setErrorMandatoryMessageMap(errorMandatoryMessageMap,
			LocaleUtil.getDefault());
	}

	@Override
	public void setErrorMandatoryMessageMap(
		Map<Locale, String> errorMandatoryMessageMap, Locale defaultLocale) {
		if (errorMandatoryMessageMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setErrorMandatoryMessage(LocalizationUtil.updateLocalization(
					errorMandatoryMessageMap, getErrorMandatoryMessage(),
					"ErrorMandatoryMessage",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getErrorLengthMessage() {
		return _errorLengthMessage;
	}

	@Override
	public String getErrorLengthMessage(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getErrorLengthMessage(languageId);
	}

	@Override
	public String getErrorLengthMessage(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getErrorLengthMessage(languageId, useDefault);
	}

	@Override
	public String getErrorLengthMessage(String languageId) {
		return LocalizationUtil.getLocalization(getErrorLengthMessage(),
			languageId);
	}

	@Override
	public String getErrorLengthMessage(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getErrorLengthMessage(),
			languageId, useDefault);
	}

	@Override
	public String getErrorLengthMessageCurrentLanguageId() {
		return _errorLengthMessageCurrentLanguageId;
	}

	@Override
	public String getErrorLengthMessageCurrentValue() {
		Locale locale = getLocale(_errorLengthMessageCurrentLanguageId);

		return getErrorLengthMessage(locale);
	}

	@Override
	public Map<Locale, String> getErrorLengthMessageMap() {
		return LocalizationUtil.getLocalizationMap(getErrorLengthMessage());
	}

	@Override
	public void setErrorLengthMessage(String errorLengthMessage) {
		_errorLengthMessage = errorLengthMessage;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setErrorLengthMessage",
						String.class);

				method.invoke(_formItemRemoteModel, errorLengthMessage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setErrorLengthMessage(String errorLengthMessage, Locale locale) {
		setErrorLengthMessage(errorLengthMessage, locale,
			LocaleUtil.getDefault());
	}

	@Override
	public void setErrorLengthMessage(String errorLengthMessage, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(errorLengthMessage)) {
			setErrorLengthMessage(LocalizationUtil.updateLocalization(
					getErrorLengthMessage(), "ErrorLengthMessage",
					errorLengthMessage, languageId, defaultLanguageId));
		}
		else {
			setErrorLengthMessage(LocalizationUtil.removeLocalization(
					getErrorLengthMessage(), "ErrorLengthMessage", languageId));
		}
	}

	@Override
	public void setErrorLengthMessageCurrentLanguageId(String languageId) {
		_errorLengthMessageCurrentLanguageId = languageId;
	}

	@Override
	public void setErrorLengthMessageMap(
		Map<Locale, String> errorLengthMessageMap) {
		setErrorLengthMessageMap(errorLengthMessageMap, LocaleUtil.getDefault());
	}

	@Override
	public void setErrorLengthMessageMap(
		Map<Locale, String> errorLengthMessageMap, Locale defaultLocale) {
		if (errorLengthMessageMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setErrorLengthMessage(LocalizationUtil.updateLocalization(
					errorLengthMessageMap, getErrorLengthMessage(),
					"ErrorLengthMessage", LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getHintMessage() {
		return _hintMessage;
	}

	@Override
	public String getHintMessage(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getHintMessage(languageId);
	}

	@Override
	public String getHintMessage(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getHintMessage(languageId, useDefault);
	}

	@Override
	public String getHintMessage(String languageId) {
		return LocalizationUtil.getLocalization(getHintMessage(), languageId);
	}

	@Override
	public String getHintMessage(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getHintMessage(), languageId,
			useDefault);
	}

	@Override
	public String getHintMessageCurrentLanguageId() {
		return _hintMessageCurrentLanguageId;
	}

	@Override
	public String getHintMessageCurrentValue() {
		Locale locale = getLocale(_hintMessageCurrentLanguageId);

		return getHintMessage(locale);
	}

	@Override
	public Map<Locale, String> getHintMessageMap() {
		return LocalizationUtil.getLocalizationMap(getHintMessage());
	}

	@Override
	public void setHintMessage(String hintMessage) {
		_hintMessage = hintMessage;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setHintMessage", String.class);

				method.invoke(_formItemRemoteModel, hintMessage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setHintMessage(String hintMessage, Locale locale) {
		setHintMessage(hintMessage, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setHintMessage(String hintMessage, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(hintMessage)) {
			setHintMessage(LocalizationUtil.updateLocalization(
					getHintMessage(), "HintMessage", hintMessage, languageId,
					defaultLanguageId));
		}
		else {
			setHintMessage(LocalizationUtil.removeLocalization(
					getHintMessage(), "HintMessage", languageId));
		}
	}

	@Override
	public void setHintMessageCurrentLanguageId(String languageId) {
		_hintMessageCurrentLanguageId = languageId;
	}

	@Override
	public void setHintMessageMap(Map<Locale, String> hintMessageMap) {
		setHintMessageMap(hintMessageMap, LocaleUtil.getDefault());
	}

	@Override
	public void setHintMessageMap(Map<Locale, String> hintMessageMap,
		Locale defaultLocale) {
		if (hintMessageMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setHintMessage(LocalizationUtil.updateLocalization(hintMessageMap,
					getHintMessage(), "HintMessage",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	public BaseModel<?> getFormItemRemoteModel() {
		return _formItemRemoteModel;
	}

	public void setFormItemRemoteModel(BaseModel<?> formItemRemoteModel) {
		_formItemRemoteModel = formItemRemoteModel;
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

		Class<?> remoteModelClass = _formItemRemoteModel.getClass();

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

		Object returnValue = method.invoke(_formItemRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FormItemLocalServiceUtil.addFormItem(this);
		}
		else {
			FormItemLocalServiceUtil.updateFormItem(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> labelMap = getLabelMap();

		for (Map.Entry<Locale, String> entry : labelMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> optionValuesMap = getOptionValuesMap();

		for (Map.Entry<Locale, String> entry : optionValuesMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> defaultValueMap = getDefaultValueMap();

		for (Map.Entry<Locale, String> entry : defaultValueMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> errorValidationMessageMap = getErrorValidationMessageMap();

		for (Map.Entry<Locale, String> entry : errorValidationMessageMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> errorMandatoryMessageMap = getErrorMandatoryMessageMap();

		for (Map.Entry<Locale, String> entry : errorMandatoryMessageMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> errorLengthMessageMap = getErrorLengthMessageMap();

		for (Map.Entry<Locale, String> entry : errorLengthMessageMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> hintMessageMap = getHintMessageMap();

		for (Map.Entry<Locale, String> entry : hintMessageMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getLabel();

		if (xml == null) {
			return StringPool.BLANK;
		}

		return LocalizationUtil.getDefaultLanguageId(xml);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		prepareLocalizedFieldsForImport(null);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String label = getLabel(defaultLocale);

		if (Validator.isNull(label)) {
			setLabel(getLabel(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setLabel(getLabel(defaultLocale), defaultLocale, defaultLocale);
		}

		String optionValues = getOptionValues(defaultLocale);

		if (Validator.isNull(optionValues)) {
			setOptionValues(getOptionValues(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setOptionValues(getOptionValues(defaultLocale), defaultLocale,
				defaultLocale);
		}

		String defaultValue = getDefaultValue(defaultLocale);

		if (Validator.isNull(defaultValue)) {
			setDefaultValue(getDefaultValue(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setDefaultValue(getDefaultValue(defaultLocale), defaultLocale,
				defaultLocale);
		}

		String errorValidationMessage = getErrorValidationMessage(defaultLocale);

		if (Validator.isNull(errorValidationMessage)) {
			setErrorValidationMessage(getErrorValidationMessage(
					modelDefaultLanguageId), defaultLocale);
		}
		else {
			setErrorValidationMessage(getErrorValidationMessage(defaultLocale),
				defaultLocale, defaultLocale);
		}

		String errorMandatoryMessage = getErrorMandatoryMessage(defaultLocale);

		if (Validator.isNull(errorMandatoryMessage)) {
			setErrorMandatoryMessage(getErrorMandatoryMessage(
					modelDefaultLanguageId), defaultLocale);
		}
		else {
			setErrorMandatoryMessage(getErrorMandatoryMessage(defaultLocale),
				defaultLocale, defaultLocale);
		}

		String errorLengthMessage = getErrorLengthMessage(defaultLocale);

		if (Validator.isNull(errorLengthMessage)) {
			setErrorLengthMessage(getErrorLengthMessage(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setErrorLengthMessage(getErrorLengthMessage(defaultLocale),
				defaultLocale, defaultLocale);
		}

		String hintMessage = getHintMessage(defaultLocale);

		if (Validator.isNull(hintMessage)) {
			setHintMessage(getHintMessage(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setHintMessage(getHintMessage(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public FormItem toEscapedModel() {
		return (FormItem)ProxyUtil.newProxyInstance(FormItem.class.getClassLoader(),
			new Class[] { FormItem.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FormItemClp clone = new FormItemClp();

		clone.setFormItemId(getFormItemId());
		clone.setActive(getActive());
		clone.setCreationDate(getCreationDate());
		clone.setModificationDate(getModificationDate());
		clone.setModificationUser(getModificationUser());
		clone.setFormId(getFormId());
		clone.setFormItemAttrId(getFormItemAttrId());
		clone.setFormItemAttrClass(getFormItemAttrClass());
		clone.setLabel(getLabel());
		clone.setLabelAttrId(getLabelAttrId());
		clone.setLabelAttrClass(getLabelAttrClass());
		clone.setInputAttrId(getInputAttrId());
		clone.setInputAttrClass(getInputAttrClass());
		clone.setType(getType());
		clone.setOptionKeys(getOptionKeys());
		clone.setOptionValues(getOptionValues());
		clone.setMandatory(getMandatory());
		clone.setDefaultValue(getDefaultValue());
		clone.setOrder(getOrder());
		clone.setValidationType(getValidationType());
		clone.setValidationRegexValue(getValidationRegexValue());
		clone.setMinLength(getMinLength());
		clone.setMaxLength(getMaxLength());
		clone.setErrorValidationMessage(getErrorValidationMessage());
		clone.setErrorMandatoryMessage(getErrorMandatoryMessage());
		clone.setErrorLengthMessage(getErrorLengthMessage());
		clone.setHintMessage(getHintMessage());

		return clone;
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

		if (!(obj instanceof FormItemClp)) {
			return false;
		}

		FormItemClp formItem = (FormItemClp)obj;

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
	public String toString() {
		StringBundler sb = new StringBundler(55);

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
		sb.append(", optionKeys=");
		sb.append(getOptionKeys());
		sb.append(", optionValues=");
		sb.append(getOptionValues());
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
		sb.append(", minLength=");
		sb.append(getMinLength());
		sb.append(", maxLength=");
		sb.append(getMaxLength());
		sb.append(", errorValidationMessage=");
		sb.append(getErrorValidationMessage());
		sb.append(", errorMandatoryMessage=");
		sb.append(getErrorMandatoryMessage());
		sb.append(", errorLengthMessage=");
		sb.append(getErrorLengthMessage());
		sb.append(", hintMessage=");
		sb.append(getHintMessage());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(85);

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
			"<column><column-name>optionKeys</column-name><column-value><![CDATA[");
		sb.append(getOptionKeys());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>optionValues</column-name><column-value><![CDATA[");
		sb.append(getOptionValues());
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
			"<column><column-name>minLength</column-name><column-value><![CDATA[");
		sb.append(getMinLength());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxLength</column-name><column-value><![CDATA[");
		sb.append(getMaxLength());
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
			"<column><column-name>errorLengthMessage</column-name><column-value><![CDATA[");
		sb.append(getErrorLengthMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hintMessage</column-name><column-value><![CDATA[");
		sb.append(getHintMessage());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _formItemId;
	private boolean _active;
	private Date _creationDate;
	private Date _modificationDate;
	private String _modificationUser;
	private long _formId;
	private String _formItemAttrId;
	private String _formItemAttrClass;
	private String _label;
	private String _labelCurrentLanguageId;
	private String _labelAttrId;
	private String _labelAttrClass;
	private String _inputAttrId;
	private String _inputAttrClass;
	private String _type;
	private String _optionKeys;
	private String _optionValues;
	private String _optionValuesCurrentLanguageId;
	private boolean _mandatory;
	private String _defaultValue;
	private String _defaultValueCurrentLanguageId;
	private int _order;
	private String _validationType;
	private String _validationRegexValue;
	private int _minLength;
	private int _maxLength;
	private String _errorValidationMessage;
	private String _errorValidationMessageCurrentLanguageId;
	private String _errorMandatoryMessage;
	private String _errorMandatoryMessageCurrentLanguageId;
	private String _errorLengthMessage;
	private String _errorLengthMessageCurrentLanguageId;
	private String _hintMessage;
	private String _hintMessageCurrentLanguageId;
	private BaseModel<?> _formItemRemoteModel;
}