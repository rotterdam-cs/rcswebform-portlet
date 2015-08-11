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

package com.rcs.webform.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FormItemOption}.
 * </p>
 *
 * @author ryusuf
 * @see FormItemOption
 * @generated
 */
public class FormItemOptionWrapper implements FormItemOption,
	ModelWrapper<FormItemOption> {
	public FormItemOptionWrapper(FormItemOption formItemOption) {
		_formItemOption = formItemOption;
	}

	@Override
	public Class<?> getModelClass() {
		return FormItemOption.class;
	}

	@Override
	public String getModelClassName() {
		return FormItemOption.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("formitemoptionId", getFormitemoptionId());
		attributes.put("creationDate", getCreationDate());
		attributes.put("modificationDate", getModificationDate());
		attributes.put("modificationUser", getModificationUser());
		attributes.put("formItemId", getFormItemId());
		attributes.put("optionKey", getOptionKey());
		attributes.put("optionValue", getOptionValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long formitemoptionId = (Long)attributes.get("formitemoptionId");

		if (formitemoptionId != null) {
			setFormitemoptionId(formitemoptionId);
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

		Long formItemId = (Long)attributes.get("formItemId");

		if (formItemId != null) {
			setFormItemId(formItemId);
		}

		String optionKey = (String)attributes.get("optionKey");

		if (optionKey != null) {
			setOptionKey(optionKey);
		}

		String optionValue = (String)attributes.get("optionValue");

		if (optionValue != null) {
			setOptionValue(optionValue);
		}
	}

	/**
	* Returns the primary key of this form item option.
	*
	* @return the primary key of this form item option
	*/
	@Override
	public long getPrimaryKey() {
		return _formItemOption.getPrimaryKey();
	}

	/**
	* Sets the primary key of this form item option.
	*
	* @param primaryKey the primary key of this form item option
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_formItemOption.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the formitemoption ID of this form item option.
	*
	* @return the formitemoption ID of this form item option
	*/
	@Override
	public long getFormitemoptionId() {
		return _formItemOption.getFormitemoptionId();
	}

	/**
	* Sets the formitemoption ID of this form item option.
	*
	* @param formitemoptionId the formitemoption ID of this form item option
	*/
	@Override
	public void setFormitemoptionId(long formitemoptionId) {
		_formItemOption.setFormitemoptionId(formitemoptionId);
	}

	/**
	* Returns the creation date of this form item option.
	*
	* @return the creation date of this form item option
	*/
	@Override
	public java.util.Date getCreationDate() {
		return _formItemOption.getCreationDate();
	}

	/**
	* Sets the creation date of this form item option.
	*
	* @param creationDate the creation date of this form item option
	*/
	@Override
	public void setCreationDate(java.util.Date creationDate) {
		_formItemOption.setCreationDate(creationDate);
	}

	/**
	* Returns the modification date of this form item option.
	*
	* @return the modification date of this form item option
	*/
	@Override
	public java.util.Date getModificationDate() {
		return _formItemOption.getModificationDate();
	}

	/**
	* Sets the modification date of this form item option.
	*
	* @param modificationDate the modification date of this form item option
	*/
	@Override
	public void setModificationDate(java.util.Date modificationDate) {
		_formItemOption.setModificationDate(modificationDate);
	}

	/**
	* Returns the modification user of this form item option.
	*
	* @return the modification user of this form item option
	*/
	@Override
	public java.lang.String getModificationUser() {
		return _formItemOption.getModificationUser();
	}

	/**
	* Sets the modification user of this form item option.
	*
	* @param modificationUser the modification user of this form item option
	*/
	@Override
	public void setModificationUser(java.lang.String modificationUser) {
		_formItemOption.setModificationUser(modificationUser);
	}

	/**
	* Returns the form item ID of this form item option.
	*
	* @return the form item ID of this form item option
	*/
	@Override
	public long getFormItemId() {
		return _formItemOption.getFormItemId();
	}

	/**
	* Sets the form item ID of this form item option.
	*
	* @param formItemId the form item ID of this form item option
	*/
	@Override
	public void setFormItemId(long formItemId) {
		_formItemOption.setFormItemId(formItemId);
	}

	/**
	* Returns the option key of this form item option.
	*
	* @return the option key of this form item option
	*/
	@Override
	public java.lang.String getOptionKey() {
		return _formItemOption.getOptionKey();
	}

	/**
	* Returns the localized option key of this form item option in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized option key of this form item option
	*/
	@Override
	public java.lang.String getOptionKey(java.util.Locale locale) {
		return _formItemOption.getOptionKey(locale);
	}

	/**
	* Returns the localized option key of this form item option in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized option key of this form item option. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getOptionKey(java.util.Locale locale,
		boolean useDefault) {
		return _formItemOption.getOptionKey(locale, useDefault);
	}

	/**
	* Returns the localized option key of this form item option in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized option key of this form item option
	*/
	@Override
	public java.lang.String getOptionKey(java.lang.String languageId) {
		return _formItemOption.getOptionKey(languageId);
	}

	/**
	* Returns the localized option key of this form item option in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized option key of this form item option
	*/
	@Override
	public java.lang.String getOptionKey(java.lang.String languageId,
		boolean useDefault) {
		return _formItemOption.getOptionKey(languageId, useDefault);
	}

	@Override
	public java.lang.String getOptionKeyCurrentLanguageId() {
		return _formItemOption.getOptionKeyCurrentLanguageId();
	}

	@Override
	public java.lang.String getOptionKeyCurrentValue() {
		return _formItemOption.getOptionKeyCurrentValue();
	}

	/**
	* Returns a map of the locales and localized option keies of this form item option.
	*
	* @return the locales and localized option keies of this form item option
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getOptionKeyMap() {
		return _formItemOption.getOptionKeyMap();
	}

	/**
	* Sets the option key of this form item option.
	*
	* @param optionKey the option key of this form item option
	*/
	@Override
	public void setOptionKey(java.lang.String optionKey) {
		_formItemOption.setOptionKey(optionKey);
	}

	/**
	* Sets the localized option key of this form item option in the language.
	*
	* @param optionKey the localized option key of this form item option
	* @param locale the locale of the language
	*/
	@Override
	public void setOptionKey(java.lang.String optionKey, java.util.Locale locale) {
		_formItemOption.setOptionKey(optionKey, locale);
	}

	/**
	* Sets the localized option key of this form item option in the language, and sets the default locale.
	*
	* @param optionKey the localized option key of this form item option
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setOptionKey(java.lang.String optionKey,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_formItemOption.setOptionKey(optionKey, locale, defaultLocale);
	}

	@Override
	public void setOptionKeyCurrentLanguageId(java.lang.String languageId) {
		_formItemOption.setOptionKeyCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized option keies of this form item option from the map of locales and localized option keies.
	*
	* @param optionKeyMap the locales and localized option keies of this form item option
	*/
	@Override
	public void setOptionKeyMap(
		java.util.Map<java.util.Locale, java.lang.String> optionKeyMap) {
		_formItemOption.setOptionKeyMap(optionKeyMap);
	}

	/**
	* Sets the localized option keies of this form item option from the map of locales and localized option keies, and sets the default locale.
	*
	* @param optionKeyMap the locales and localized option keies of this form item option
	* @param defaultLocale the default locale
	*/
	@Override
	public void setOptionKeyMap(
		java.util.Map<java.util.Locale, java.lang.String> optionKeyMap,
		java.util.Locale defaultLocale) {
		_formItemOption.setOptionKeyMap(optionKeyMap, defaultLocale);
	}

	/**
	* Returns the option value of this form item option.
	*
	* @return the option value of this form item option
	*/
	@Override
	public java.lang.String getOptionValue() {
		return _formItemOption.getOptionValue();
	}

	/**
	* Returns the localized option value of this form item option in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized option value of this form item option
	*/
	@Override
	public java.lang.String getOptionValue(java.util.Locale locale) {
		return _formItemOption.getOptionValue(locale);
	}

	/**
	* Returns the localized option value of this form item option in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized option value of this form item option. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getOptionValue(java.util.Locale locale,
		boolean useDefault) {
		return _formItemOption.getOptionValue(locale, useDefault);
	}

	/**
	* Returns the localized option value of this form item option in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized option value of this form item option
	*/
	@Override
	public java.lang.String getOptionValue(java.lang.String languageId) {
		return _formItemOption.getOptionValue(languageId);
	}

	/**
	* Returns the localized option value of this form item option in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized option value of this form item option
	*/
	@Override
	public java.lang.String getOptionValue(java.lang.String languageId,
		boolean useDefault) {
		return _formItemOption.getOptionValue(languageId, useDefault);
	}

	@Override
	public java.lang.String getOptionValueCurrentLanguageId() {
		return _formItemOption.getOptionValueCurrentLanguageId();
	}

	@Override
	public java.lang.String getOptionValueCurrentValue() {
		return _formItemOption.getOptionValueCurrentValue();
	}

	/**
	* Returns a map of the locales and localized option values of this form item option.
	*
	* @return the locales and localized option values of this form item option
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getOptionValueMap() {
		return _formItemOption.getOptionValueMap();
	}

	/**
	* Sets the option value of this form item option.
	*
	* @param optionValue the option value of this form item option
	*/
	@Override
	public void setOptionValue(java.lang.String optionValue) {
		_formItemOption.setOptionValue(optionValue);
	}

	/**
	* Sets the localized option value of this form item option in the language.
	*
	* @param optionValue the localized option value of this form item option
	* @param locale the locale of the language
	*/
	@Override
	public void setOptionValue(java.lang.String optionValue,
		java.util.Locale locale) {
		_formItemOption.setOptionValue(optionValue, locale);
	}

	/**
	* Sets the localized option value of this form item option in the language, and sets the default locale.
	*
	* @param optionValue the localized option value of this form item option
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setOptionValue(java.lang.String optionValue,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_formItemOption.setOptionValue(optionValue, locale, defaultLocale);
	}

	@Override
	public void setOptionValueCurrentLanguageId(java.lang.String languageId) {
		_formItemOption.setOptionValueCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized option values of this form item option from the map of locales and localized option values.
	*
	* @param optionValueMap the locales and localized option values of this form item option
	*/
	@Override
	public void setOptionValueMap(
		java.util.Map<java.util.Locale, java.lang.String> optionValueMap) {
		_formItemOption.setOptionValueMap(optionValueMap);
	}

	/**
	* Sets the localized option values of this form item option from the map of locales and localized option values, and sets the default locale.
	*
	* @param optionValueMap the locales and localized option values of this form item option
	* @param defaultLocale the default locale
	*/
	@Override
	public void setOptionValueMap(
		java.util.Map<java.util.Locale, java.lang.String> optionValueMap,
		java.util.Locale defaultLocale) {
		_formItemOption.setOptionValueMap(optionValueMap, defaultLocale);
	}

	@Override
	public boolean isNew() {
		return _formItemOption.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_formItemOption.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _formItemOption.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_formItemOption.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _formItemOption.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _formItemOption.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_formItemOption.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _formItemOption.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_formItemOption.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_formItemOption.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_formItemOption.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _formItemOption.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _formItemOption.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_formItemOption.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_formItemOption.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new FormItemOptionWrapper((FormItemOption)_formItemOption.clone());
	}

	@Override
	public int compareTo(com.rcs.webform.model.FormItemOption formItemOption) {
		return _formItemOption.compareTo(formItemOption);
	}

	@Override
	public int hashCode() {
		return _formItemOption.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rcs.webform.model.FormItemOption> toCacheModel() {
		return _formItemOption.toCacheModel();
	}

	@Override
	public com.rcs.webform.model.FormItemOption toEscapedModel() {
		return new FormItemOptionWrapper(_formItemOption.toEscapedModel());
	}

	@Override
	public com.rcs.webform.model.FormItemOption toUnescapedModel() {
		return new FormItemOptionWrapper(_formItemOption.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _formItemOption.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _formItemOption.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_formItemOption.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FormItemOptionWrapper)) {
			return false;
		}

		FormItemOptionWrapper formItemOptionWrapper = (FormItemOptionWrapper)obj;

		if (Validator.equals(_formItemOption,
					formItemOptionWrapper._formItemOption)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FormItemOption getWrappedFormItemOption() {
		return _formItemOption;
	}

	@Override
	public FormItemOption getWrappedModel() {
		return _formItemOption;
	}

	@Override
	public void resetOriginalValues() {
		_formItemOption.resetOriginalValues();
	}

	private FormItemOption _formItemOption;
}