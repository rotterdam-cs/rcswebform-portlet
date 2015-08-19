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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FormItem}.
 * </p>
 *
 * @author ryusuf
 * @see FormItem
 * @generated
 */
public class FormItemWrapper implements FormItem, ModelWrapper<FormItem> {
	public FormItemWrapper(FormItem formItem) {
		_formItem = formItem;
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
		attributes.put("formLayout", getFormLayout());

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

		String formLayout = (String)attributes.get("formLayout");

		if (formLayout != null) {
			setFormLayout(formLayout);
		}
	}

	/**
	* Returns the primary key of this form item.
	*
	* @return the primary key of this form item
	*/
	@Override
	public long getPrimaryKey() {
		return _formItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this form item.
	*
	* @param primaryKey the primary key of this form item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_formItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the form item ID of this form item.
	*
	* @return the form item ID of this form item
	*/
	@Override
	public long getFormItemId() {
		return _formItem.getFormItemId();
	}

	/**
	* Sets the form item ID of this form item.
	*
	* @param formItemId the form item ID of this form item
	*/
	@Override
	public void setFormItemId(long formItemId) {
		_formItem.setFormItemId(formItemId);
	}

	/**
	* Returns the active of this form item.
	*
	* @return the active of this form item
	*/
	@Override
	public boolean getActive() {
		return _formItem.getActive();
	}

	/**
	* Returns <code>true</code> if this form item is active.
	*
	* @return <code>true</code> if this form item is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _formItem.isActive();
	}

	/**
	* Sets whether this form item is active.
	*
	* @param active the active of this form item
	*/
	@Override
	public void setActive(boolean active) {
		_formItem.setActive(active);
	}

	/**
	* Returns the creation date of this form item.
	*
	* @return the creation date of this form item
	*/
	@Override
	public java.util.Date getCreationDate() {
		return _formItem.getCreationDate();
	}

	/**
	* Sets the creation date of this form item.
	*
	* @param creationDate the creation date of this form item
	*/
	@Override
	public void setCreationDate(java.util.Date creationDate) {
		_formItem.setCreationDate(creationDate);
	}

	/**
	* Returns the modification date of this form item.
	*
	* @return the modification date of this form item
	*/
	@Override
	public java.util.Date getModificationDate() {
		return _formItem.getModificationDate();
	}

	/**
	* Sets the modification date of this form item.
	*
	* @param modificationDate the modification date of this form item
	*/
	@Override
	public void setModificationDate(java.util.Date modificationDate) {
		_formItem.setModificationDate(modificationDate);
	}

	/**
	* Returns the modification user of this form item.
	*
	* @return the modification user of this form item
	*/
	@Override
	public java.lang.String getModificationUser() {
		return _formItem.getModificationUser();
	}

	/**
	* Sets the modification user of this form item.
	*
	* @param modificationUser the modification user of this form item
	*/
	@Override
	public void setModificationUser(java.lang.String modificationUser) {
		_formItem.setModificationUser(modificationUser);
	}

	/**
	* Returns the form ID of this form item.
	*
	* @return the form ID of this form item
	*/
	@Override
	public long getFormId() {
		return _formItem.getFormId();
	}

	/**
	* Sets the form ID of this form item.
	*
	* @param formId the form ID of this form item
	*/
	@Override
	public void setFormId(long formId) {
		_formItem.setFormId(formId);
	}

	/**
	* Returns the form item attr ID of this form item.
	*
	* @return the form item attr ID of this form item
	*/
	@Override
	public java.lang.String getFormItemAttrId() {
		return _formItem.getFormItemAttrId();
	}

	/**
	* Sets the form item attr ID of this form item.
	*
	* @param formItemAttrId the form item attr ID of this form item
	*/
	@Override
	public void setFormItemAttrId(java.lang.String formItemAttrId) {
		_formItem.setFormItemAttrId(formItemAttrId);
	}

	/**
	* Returns the form item attr class of this form item.
	*
	* @return the form item attr class of this form item
	*/
	@Override
	public java.lang.String getFormItemAttrClass() {
		return _formItem.getFormItemAttrClass();
	}

	/**
	* Sets the form item attr class of this form item.
	*
	* @param formItemAttrClass the form item attr class of this form item
	*/
	@Override
	public void setFormItemAttrClass(java.lang.String formItemAttrClass) {
		_formItem.setFormItemAttrClass(formItemAttrClass);
	}

	/**
	* Returns the label of this form item.
	*
	* @return the label of this form item
	*/
	@Override
	public java.lang.String getLabel() {
		return _formItem.getLabel();
	}

	/**
	* Returns the localized label of this form item in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized label of this form item
	*/
	@Override
	public java.lang.String getLabel(java.util.Locale locale) {
		return _formItem.getLabel(locale);
	}

	/**
	* Returns the localized label of this form item in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized label of this form item. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getLabel(java.util.Locale locale, boolean useDefault) {
		return _formItem.getLabel(locale, useDefault);
	}

	/**
	* Returns the localized label of this form item in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized label of this form item
	*/
	@Override
	public java.lang.String getLabel(java.lang.String languageId) {
		return _formItem.getLabel(languageId);
	}

	/**
	* Returns the localized label of this form item in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized label of this form item
	*/
	@Override
	public java.lang.String getLabel(java.lang.String languageId,
		boolean useDefault) {
		return _formItem.getLabel(languageId, useDefault);
	}

	@Override
	public java.lang.String getLabelCurrentLanguageId() {
		return _formItem.getLabelCurrentLanguageId();
	}

	@Override
	public java.lang.String getLabelCurrentValue() {
		return _formItem.getLabelCurrentValue();
	}

	/**
	* Returns a map of the locales and localized labels of this form item.
	*
	* @return the locales and localized labels of this form item
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getLabelMap() {
		return _formItem.getLabelMap();
	}

	/**
	* Sets the label of this form item.
	*
	* @param label the label of this form item
	*/
	@Override
	public void setLabel(java.lang.String label) {
		_formItem.setLabel(label);
	}

	/**
	* Sets the localized label of this form item in the language.
	*
	* @param label the localized label of this form item
	* @param locale the locale of the language
	*/
	@Override
	public void setLabel(java.lang.String label, java.util.Locale locale) {
		_formItem.setLabel(label, locale);
	}

	/**
	* Sets the localized label of this form item in the language, and sets the default locale.
	*
	* @param label the localized label of this form item
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setLabel(java.lang.String label, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_formItem.setLabel(label, locale, defaultLocale);
	}

	@Override
	public void setLabelCurrentLanguageId(java.lang.String languageId) {
		_formItem.setLabelCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized labels of this form item from the map of locales and localized labels.
	*
	* @param labelMap the locales and localized labels of this form item
	*/
	@Override
	public void setLabelMap(
		java.util.Map<java.util.Locale, java.lang.String> labelMap) {
		_formItem.setLabelMap(labelMap);
	}

	/**
	* Sets the localized labels of this form item from the map of locales and localized labels, and sets the default locale.
	*
	* @param labelMap the locales and localized labels of this form item
	* @param defaultLocale the default locale
	*/
	@Override
	public void setLabelMap(
		java.util.Map<java.util.Locale, java.lang.String> labelMap,
		java.util.Locale defaultLocale) {
		_formItem.setLabelMap(labelMap, defaultLocale);
	}

	/**
	* Returns the label attr ID of this form item.
	*
	* @return the label attr ID of this form item
	*/
	@Override
	public java.lang.String getLabelAttrId() {
		return _formItem.getLabelAttrId();
	}

	/**
	* Sets the label attr ID of this form item.
	*
	* @param labelAttrId the label attr ID of this form item
	*/
	@Override
	public void setLabelAttrId(java.lang.String labelAttrId) {
		_formItem.setLabelAttrId(labelAttrId);
	}

	/**
	* Returns the label attr class of this form item.
	*
	* @return the label attr class of this form item
	*/
	@Override
	public java.lang.String getLabelAttrClass() {
		return _formItem.getLabelAttrClass();
	}

	/**
	* Sets the label attr class of this form item.
	*
	* @param labelAttrClass the label attr class of this form item
	*/
	@Override
	public void setLabelAttrClass(java.lang.String labelAttrClass) {
		_formItem.setLabelAttrClass(labelAttrClass);
	}

	/**
	* Returns the input attr ID of this form item.
	*
	* @return the input attr ID of this form item
	*/
	@Override
	public java.lang.String getInputAttrId() {
		return _formItem.getInputAttrId();
	}

	/**
	* Sets the input attr ID of this form item.
	*
	* @param inputAttrId the input attr ID of this form item
	*/
	@Override
	public void setInputAttrId(java.lang.String inputAttrId) {
		_formItem.setInputAttrId(inputAttrId);
	}

	/**
	* Returns the input attr class of this form item.
	*
	* @return the input attr class of this form item
	*/
	@Override
	public java.lang.String getInputAttrClass() {
		return _formItem.getInputAttrClass();
	}

	/**
	* Sets the input attr class of this form item.
	*
	* @param inputAttrClass the input attr class of this form item
	*/
	@Override
	public void setInputAttrClass(java.lang.String inputAttrClass) {
		_formItem.setInputAttrClass(inputAttrClass);
	}

	/**
	* Returns the type of this form item.
	*
	* @return the type of this form item
	*/
	@Override
	public java.lang.String getType() {
		return _formItem.getType();
	}

	/**
	* Sets the type of this form item.
	*
	* @param type the type of this form item
	*/
	@Override
	public void setType(java.lang.String type) {
		_formItem.setType(type);
	}

	/**
	* Returns the mandatory of this form item.
	*
	* @return the mandatory of this form item
	*/
	@Override
	public boolean getMandatory() {
		return _formItem.getMandatory();
	}

	/**
	* Returns <code>true</code> if this form item is mandatory.
	*
	* @return <code>true</code> if this form item is mandatory; <code>false</code> otherwise
	*/
	@Override
	public boolean isMandatory() {
		return _formItem.isMandatory();
	}

	/**
	* Sets whether this form item is mandatory.
	*
	* @param mandatory the mandatory of this form item
	*/
	@Override
	public void setMandatory(boolean mandatory) {
		_formItem.setMandatory(mandatory);
	}

	/**
	* Returns the default value of this form item.
	*
	* @return the default value of this form item
	*/
	@Override
	public java.lang.String getDefaultValue() {
		return _formItem.getDefaultValue();
	}

	/**
	* Returns the localized default value of this form item in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized default value of this form item
	*/
	@Override
	public java.lang.String getDefaultValue(java.util.Locale locale) {
		return _formItem.getDefaultValue(locale);
	}

	/**
	* Returns the localized default value of this form item in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized default value of this form item. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDefaultValue(java.util.Locale locale,
		boolean useDefault) {
		return _formItem.getDefaultValue(locale, useDefault);
	}

	/**
	* Returns the localized default value of this form item in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized default value of this form item
	*/
	@Override
	public java.lang.String getDefaultValue(java.lang.String languageId) {
		return _formItem.getDefaultValue(languageId);
	}

	/**
	* Returns the localized default value of this form item in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized default value of this form item
	*/
	@Override
	public java.lang.String getDefaultValue(java.lang.String languageId,
		boolean useDefault) {
		return _formItem.getDefaultValue(languageId, useDefault);
	}

	@Override
	public java.lang.String getDefaultValueCurrentLanguageId() {
		return _formItem.getDefaultValueCurrentLanguageId();
	}

	@Override
	public java.lang.String getDefaultValueCurrentValue() {
		return _formItem.getDefaultValueCurrentValue();
	}

	/**
	* Returns a map of the locales and localized default values of this form item.
	*
	* @return the locales and localized default values of this form item
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getDefaultValueMap() {
		return _formItem.getDefaultValueMap();
	}

	/**
	* Sets the default value of this form item.
	*
	* @param defaultValue the default value of this form item
	*/
	@Override
	public void setDefaultValue(java.lang.String defaultValue) {
		_formItem.setDefaultValue(defaultValue);
	}

	/**
	* Sets the localized default value of this form item in the language.
	*
	* @param defaultValue the localized default value of this form item
	* @param locale the locale of the language
	*/
	@Override
	public void setDefaultValue(java.lang.String defaultValue,
		java.util.Locale locale) {
		_formItem.setDefaultValue(defaultValue, locale);
	}

	/**
	* Sets the localized default value of this form item in the language, and sets the default locale.
	*
	* @param defaultValue the localized default value of this form item
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDefaultValue(java.lang.String defaultValue,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_formItem.setDefaultValue(defaultValue, locale, defaultLocale);
	}

	@Override
	public void setDefaultValueCurrentLanguageId(java.lang.String languageId) {
		_formItem.setDefaultValueCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized default values of this form item from the map of locales and localized default values.
	*
	* @param defaultValueMap the locales and localized default values of this form item
	*/
	@Override
	public void setDefaultValueMap(
		java.util.Map<java.util.Locale, java.lang.String> defaultValueMap) {
		_formItem.setDefaultValueMap(defaultValueMap);
	}

	/**
	* Sets the localized default values of this form item from the map of locales and localized default values, and sets the default locale.
	*
	* @param defaultValueMap the locales and localized default values of this form item
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDefaultValueMap(
		java.util.Map<java.util.Locale, java.lang.String> defaultValueMap,
		java.util.Locale defaultLocale) {
		_formItem.setDefaultValueMap(defaultValueMap, defaultLocale);
	}

	/**
	* Returns the order of this form item.
	*
	* @return the order of this form item
	*/
	@Override
	public int getOrder() {
		return _formItem.getOrder();
	}

	/**
	* Sets the order of this form item.
	*
	* @param order the order of this form item
	*/
	@Override
	public void setOrder(int order) {
		_formItem.setOrder(order);
	}

	/**
	* Returns the validation type of this form item.
	*
	* @return the validation type of this form item
	*/
	@Override
	public java.lang.String getValidationType() {
		return _formItem.getValidationType();
	}

	/**
	* Sets the validation type of this form item.
	*
	* @param validationType the validation type of this form item
	*/
	@Override
	public void setValidationType(java.lang.String validationType) {
		_formItem.setValidationType(validationType);
	}

	/**
	* Returns the validation regex value of this form item.
	*
	* @return the validation regex value of this form item
	*/
	@Override
	public java.lang.String getValidationRegexValue() {
		return _formItem.getValidationRegexValue();
	}

	/**
	* Sets the validation regex value of this form item.
	*
	* @param validationRegexValue the validation regex value of this form item
	*/
	@Override
	public void setValidationRegexValue(java.lang.String validationRegexValue) {
		_formItem.setValidationRegexValue(validationRegexValue);
	}

	/**
	* Returns the min length of this form item.
	*
	* @return the min length of this form item
	*/
	@Override
	public int getMinLength() {
		return _formItem.getMinLength();
	}

	/**
	* Sets the min length of this form item.
	*
	* @param minLength the min length of this form item
	*/
	@Override
	public void setMinLength(int minLength) {
		_formItem.setMinLength(minLength);
	}

	/**
	* Returns the max length of this form item.
	*
	* @return the max length of this form item
	*/
	@Override
	public int getMaxLength() {
		return _formItem.getMaxLength();
	}

	/**
	* Sets the max length of this form item.
	*
	* @param maxLength the max length of this form item
	*/
	@Override
	public void setMaxLength(int maxLength) {
		_formItem.setMaxLength(maxLength);
	}

	/**
	* Returns the error validation message of this form item.
	*
	* @return the error validation message of this form item
	*/
	@Override
	public java.lang.String getErrorValidationMessage() {
		return _formItem.getErrorValidationMessage();
	}

	/**
	* Returns the localized error validation message of this form item in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized error validation message of this form item
	*/
	@Override
	public java.lang.String getErrorValidationMessage(java.util.Locale locale) {
		return _formItem.getErrorValidationMessage(locale);
	}

	/**
	* Returns the localized error validation message of this form item in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized error validation message of this form item. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getErrorValidationMessage(java.util.Locale locale,
		boolean useDefault) {
		return _formItem.getErrorValidationMessage(locale, useDefault);
	}

	/**
	* Returns the localized error validation message of this form item in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized error validation message of this form item
	*/
	@Override
	public java.lang.String getErrorValidationMessage(
		java.lang.String languageId) {
		return _formItem.getErrorValidationMessage(languageId);
	}

	/**
	* Returns the localized error validation message of this form item in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized error validation message of this form item
	*/
	@Override
	public java.lang.String getErrorValidationMessage(
		java.lang.String languageId, boolean useDefault) {
		return _formItem.getErrorValidationMessage(languageId, useDefault);
	}

	@Override
	public java.lang.String getErrorValidationMessageCurrentLanguageId() {
		return _formItem.getErrorValidationMessageCurrentLanguageId();
	}

	@Override
	public java.lang.String getErrorValidationMessageCurrentValue() {
		return _formItem.getErrorValidationMessageCurrentValue();
	}

	/**
	* Returns a map of the locales and localized error validation messages of this form item.
	*
	* @return the locales and localized error validation messages of this form item
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getErrorValidationMessageMap() {
		return _formItem.getErrorValidationMessageMap();
	}

	/**
	* Sets the error validation message of this form item.
	*
	* @param errorValidationMessage the error validation message of this form item
	*/
	@Override
	public void setErrorValidationMessage(
		java.lang.String errorValidationMessage) {
		_formItem.setErrorValidationMessage(errorValidationMessage);
	}

	/**
	* Sets the localized error validation message of this form item in the language.
	*
	* @param errorValidationMessage the localized error validation message of this form item
	* @param locale the locale of the language
	*/
	@Override
	public void setErrorValidationMessage(
		java.lang.String errorValidationMessage, java.util.Locale locale) {
		_formItem.setErrorValidationMessage(errorValidationMessage, locale);
	}

	/**
	* Sets the localized error validation message of this form item in the language, and sets the default locale.
	*
	* @param errorValidationMessage the localized error validation message of this form item
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setErrorValidationMessage(
		java.lang.String errorValidationMessage, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_formItem.setErrorValidationMessage(errorValidationMessage, locale,
			defaultLocale);
	}

	@Override
	public void setErrorValidationMessageCurrentLanguageId(
		java.lang.String languageId) {
		_formItem.setErrorValidationMessageCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized error validation messages of this form item from the map of locales and localized error validation messages.
	*
	* @param errorValidationMessageMap the locales and localized error validation messages of this form item
	*/
	@Override
	public void setErrorValidationMessageMap(
		java.util.Map<java.util.Locale, java.lang.String> errorValidationMessageMap) {
		_formItem.setErrorValidationMessageMap(errorValidationMessageMap);
	}

	/**
	* Sets the localized error validation messages of this form item from the map of locales and localized error validation messages, and sets the default locale.
	*
	* @param errorValidationMessageMap the locales and localized error validation messages of this form item
	* @param defaultLocale the default locale
	*/
	@Override
	public void setErrorValidationMessageMap(
		java.util.Map<java.util.Locale, java.lang.String> errorValidationMessageMap,
		java.util.Locale defaultLocale) {
		_formItem.setErrorValidationMessageMap(errorValidationMessageMap,
			defaultLocale);
	}

	/**
	* Returns the error mandatory message of this form item.
	*
	* @return the error mandatory message of this form item
	*/
	@Override
	public java.lang.String getErrorMandatoryMessage() {
		return _formItem.getErrorMandatoryMessage();
	}

	/**
	* Returns the localized error mandatory message of this form item in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized error mandatory message of this form item
	*/
	@Override
	public java.lang.String getErrorMandatoryMessage(java.util.Locale locale) {
		return _formItem.getErrorMandatoryMessage(locale);
	}

	/**
	* Returns the localized error mandatory message of this form item in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized error mandatory message of this form item. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getErrorMandatoryMessage(java.util.Locale locale,
		boolean useDefault) {
		return _formItem.getErrorMandatoryMessage(locale, useDefault);
	}

	/**
	* Returns the localized error mandatory message of this form item in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized error mandatory message of this form item
	*/
	@Override
	public java.lang.String getErrorMandatoryMessage(
		java.lang.String languageId) {
		return _formItem.getErrorMandatoryMessage(languageId);
	}

	/**
	* Returns the localized error mandatory message of this form item in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized error mandatory message of this form item
	*/
	@Override
	public java.lang.String getErrorMandatoryMessage(
		java.lang.String languageId, boolean useDefault) {
		return _formItem.getErrorMandatoryMessage(languageId, useDefault);
	}

	@Override
	public java.lang.String getErrorMandatoryMessageCurrentLanguageId() {
		return _formItem.getErrorMandatoryMessageCurrentLanguageId();
	}

	@Override
	public java.lang.String getErrorMandatoryMessageCurrentValue() {
		return _formItem.getErrorMandatoryMessageCurrentValue();
	}

	/**
	* Returns a map of the locales and localized error mandatory messages of this form item.
	*
	* @return the locales and localized error mandatory messages of this form item
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getErrorMandatoryMessageMap() {
		return _formItem.getErrorMandatoryMessageMap();
	}

	/**
	* Sets the error mandatory message of this form item.
	*
	* @param errorMandatoryMessage the error mandatory message of this form item
	*/
	@Override
	public void setErrorMandatoryMessage(java.lang.String errorMandatoryMessage) {
		_formItem.setErrorMandatoryMessage(errorMandatoryMessage);
	}

	/**
	* Sets the localized error mandatory message of this form item in the language.
	*
	* @param errorMandatoryMessage the localized error mandatory message of this form item
	* @param locale the locale of the language
	*/
	@Override
	public void setErrorMandatoryMessage(
		java.lang.String errorMandatoryMessage, java.util.Locale locale) {
		_formItem.setErrorMandatoryMessage(errorMandatoryMessage, locale);
	}

	/**
	* Sets the localized error mandatory message of this form item in the language, and sets the default locale.
	*
	* @param errorMandatoryMessage the localized error mandatory message of this form item
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setErrorMandatoryMessage(
		java.lang.String errorMandatoryMessage, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_formItem.setErrorMandatoryMessage(errorMandatoryMessage, locale,
			defaultLocale);
	}

	@Override
	public void setErrorMandatoryMessageCurrentLanguageId(
		java.lang.String languageId) {
		_formItem.setErrorMandatoryMessageCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized error mandatory messages of this form item from the map of locales and localized error mandatory messages.
	*
	* @param errorMandatoryMessageMap the locales and localized error mandatory messages of this form item
	*/
	@Override
	public void setErrorMandatoryMessageMap(
		java.util.Map<java.util.Locale, java.lang.String> errorMandatoryMessageMap) {
		_formItem.setErrorMandatoryMessageMap(errorMandatoryMessageMap);
	}

	/**
	* Sets the localized error mandatory messages of this form item from the map of locales and localized error mandatory messages, and sets the default locale.
	*
	* @param errorMandatoryMessageMap the locales and localized error mandatory messages of this form item
	* @param defaultLocale the default locale
	*/
	@Override
	public void setErrorMandatoryMessageMap(
		java.util.Map<java.util.Locale, java.lang.String> errorMandatoryMessageMap,
		java.util.Locale defaultLocale) {
		_formItem.setErrorMandatoryMessageMap(errorMandatoryMessageMap,
			defaultLocale);
	}

	/**
	* Returns the error length message of this form item.
	*
	* @return the error length message of this form item
	*/
	@Override
	public java.lang.String getErrorLengthMessage() {
		return _formItem.getErrorLengthMessage();
	}

	/**
	* Returns the localized error length message of this form item in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized error length message of this form item
	*/
	@Override
	public java.lang.String getErrorLengthMessage(java.util.Locale locale) {
		return _formItem.getErrorLengthMessage(locale);
	}

	/**
	* Returns the localized error length message of this form item in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized error length message of this form item. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getErrorLengthMessage(java.util.Locale locale,
		boolean useDefault) {
		return _formItem.getErrorLengthMessage(locale, useDefault);
	}

	/**
	* Returns the localized error length message of this form item in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized error length message of this form item
	*/
	@Override
	public java.lang.String getErrorLengthMessage(java.lang.String languageId) {
		return _formItem.getErrorLengthMessage(languageId);
	}

	/**
	* Returns the localized error length message of this form item in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized error length message of this form item
	*/
	@Override
	public java.lang.String getErrorLengthMessage(java.lang.String languageId,
		boolean useDefault) {
		return _formItem.getErrorLengthMessage(languageId, useDefault);
	}

	@Override
	public java.lang.String getErrorLengthMessageCurrentLanguageId() {
		return _formItem.getErrorLengthMessageCurrentLanguageId();
	}

	@Override
	public java.lang.String getErrorLengthMessageCurrentValue() {
		return _formItem.getErrorLengthMessageCurrentValue();
	}

	/**
	* Returns a map of the locales and localized error length messages of this form item.
	*
	* @return the locales and localized error length messages of this form item
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getErrorLengthMessageMap() {
		return _formItem.getErrorLengthMessageMap();
	}

	/**
	* Sets the error length message of this form item.
	*
	* @param errorLengthMessage the error length message of this form item
	*/
	@Override
	public void setErrorLengthMessage(java.lang.String errorLengthMessage) {
		_formItem.setErrorLengthMessage(errorLengthMessage);
	}

	/**
	* Sets the localized error length message of this form item in the language.
	*
	* @param errorLengthMessage the localized error length message of this form item
	* @param locale the locale of the language
	*/
	@Override
	public void setErrorLengthMessage(java.lang.String errorLengthMessage,
		java.util.Locale locale) {
		_formItem.setErrorLengthMessage(errorLengthMessage, locale);
	}

	/**
	* Sets the localized error length message of this form item in the language, and sets the default locale.
	*
	* @param errorLengthMessage the localized error length message of this form item
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setErrorLengthMessage(java.lang.String errorLengthMessage,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_formItem.setErrorLengthMessage(errorLengthMessage, locale,
			defaultLocale);
	}

	@Override
	public void setErrorLengthMessageCurrentLanguageId(
		java.lang.String languageId) {
		_formItem.setErrorLengthMessageCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized error length messages of this form item from the map of locales and localized error length messages.
	*
	* @param errorLengthMessageMap the locales and localized error length messages of this form item
	*/
	@Override
	public void setErrorLengthMessageMap(
		java.util.Map<java.util.Locale, java.lang.String> errorLengthMessageMap) {
		_formItem.setErrorLengthMessageMap(errorLengthMessageMap);
	}

	/**
	* Sets the localized error length messages of this form item from the map of locales and localized error length messages, and sets the default locale.
	*
	* @param errorLengthMessageMap the locales and localized error length messages of this form item
	* @param defaultLocale the default locale
	*/
	@Override
	public void setErrorLengthMessageMap(
		java.util.Map<java.util.Locale, java.lang.String> errorLengthMessageMap,
		java.util.Locale defaultLocale) {
		_formItem.setErrorLengthMessageMap(errorLengthMessageMap, defaultLocale);
	}

	/**
	* Returns the hint message of this form item.
	*
	* @return the hint message of this form item
	*/
	@Override
	public java.lang.String getHintMessage() {
		return _formItem.getHintMessage();
	}

	/**
	* Returns the localized hint message of this form item in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized hint message of this form item
	*/
	@Override
	public java.lang.String getHintMessage(java.util.Locale locale) {
		return _formItem.getHintMessage(locale);
	}

	/**
	* Returns the localized hint message of this form item in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized hint message of this form item. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getHintMessage(java.util.Locale locale,
		boolean useDefault) {
		return _formItem.getHintMessage(locale, useDefault);
	}

	/**
	* Returns the localized hint message of this form item in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized hint message of this form item
	*/
	@Override
	public java.lang.String getHintMessage(java.lang.String languageId) {
		return _formItem.getHintMessage(languageId);
	}

	/**
	* Returns the localized hint message of this form item in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized hint message of this form item
	*/
	@Override
	public java.lang.String getHintMessage(java.lang.String languageId,
		boolean useDefault) {
		return _formItem.getHintMessage(languageId, useDefault);
	}

	@Override
	public java.lang.String getHintMessageCurrentLanguageId() {
		return _formItem.getHintMessageCurrentLanguageId();
	}

	@Override
	public java.lang.String getHintMessageCurrentValue() {
		return _formItem.getHintMessageCurrentValue();
	}

	/**
	* Returns a map of the locales and localized hint messages of this form item.
	*
	* @return the locales and localized hint messages of this form item
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getHintMessageMap() {
		return _formItem.getHintMessageMap();
	}

	/**
	* Sets the hint message of this form item.
	*
	* @param hintMessage the hint message of this form item
	*/
	@Override
	public void setHintMessage(java.lang.String hintMessage) {
		_formItem.setHintMessage(hintMessage);
	}

	/**
	* Sets the localized hint message of this form item in the language.
	*
	* @param hintMessage the localized hint message of this form item
	* @param locale the locale of the language
	*/
	@Override
	public void setHintMessage(java.lang.String hintMessage,
		java.util.Locale locale) {
		_formItem.setHintMessage(hintMessage, locale);
	}

	/**
	* Sets the localized hint message of this form item in the language, and sets the default locale.
	*
	* @param hintMessage the localized hint message of this form item
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setHintMessage(java.lang.String hintMessage,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_formItem.setHintMessage(hintMessage, locale, defaultLocale);
	}

	@Override
	public void setHintMessageCurrentLanguageId(java.lang.String languageId) {
		_formItem.setHintMessageCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized hint messages of this form item from the map of locales and localized hint messages.
	*
	* @param hintMessageMap the locales and localized hint messages of this form item
	*/
	@Override
	public void setHintMessageMap(
		java.util.Map<java.util.Locale, java.lang.String> hintMessageMap) {
		_formItem.setHintMessageMap(hintMessageMap);
	}

	/**
	* Sets the localized hint messages of this form item from the map of locales and localized hint messages, and sets the default locale.
	*
	* @param hintMessageMap the locales and localized hint messages of this form item
	* @param defaultLocale the default locale
	*/
	@Override
	public void setHintMessageMap(
		java.util.Map<java.util.Locale, java.lang.String> hintMessageMap,
		java.util.Locale defaultLocale) {
		_formItem.setHintMessageMap(hintMessageMap, defaultLocale);
	}

	/**
	* Returns the form layout of this form item.
	*
	* @return the form layout of this form item
	*/
	@Override
	public java.lang.String getFormLayout() {
		return _formItem.getFormLayout();
	}

	/**
	* Sets the form layout of this form item.
	*
	* @param formLayout the form layout of this form item
	*/
	@Override
	public void setFormLayout(java.lang.String formLayout) {
		_formItem.setFormLayout(formLayout);
	}

	@Override
	public boolean isNew() {
		return _formItem.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_formItem.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _formItem.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_formItem.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _formItem.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _formItem.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_formItem.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _formItem.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_formItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_formItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_formItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _formItem.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _formItem.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_formItem.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_formItem.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new FormItemWrapper((FormItem)_formItem.clone());
	}

	@Override
	public int compareTo(com.rcs.webform.model.FormItem formItem) {
		return _formItem.compareTo(formItem);
	}

	@Override
	public int hashCode() {
		return _formItem.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rcs.webform.model.FormItem> toCacheModel() {
		return _formItem.toCacheModel();
	}

	@Override
	public com.rcs.webform.model.FormItem toEscapedModel() {
		return new FormItemWrapper(_formItem.toEscapedModel());
	}

	@Override
	public com.rcs.webform.model.FormItem toUnescapedModel() {
		return new FormItemWrapper(_formItem.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _formItem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _formItem.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_formItem.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FormItemWrapper)) {
			return false;
		}

		FormItemWrapper formItemWrapper = (FormItemWrapper)obj;

		if (Validator.equals(_formItem, formItemWrapper._formItem)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FormItem getWrappedFormItem() {
		return _formItem;
	}

	@Override
	public FormItem getWrappedModel() {
		return _formItem;
	}

	@Override
	public void resetOriginalValues() {
		_formItem.resetOriginalValues();
	}

	private FormItem _formItem;
}