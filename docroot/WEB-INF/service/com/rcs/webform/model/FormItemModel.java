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

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the FormItem service. Represents a row in the &quot;rcswebform_FormItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rcs.webform.model.impl.FormItemModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rcs.webform.model.impl.FormItemImpl}.
 * </p>
 *
 * @author ryusuf
 * @see FormItem
 * @see com.rcs.webform.model.impl.FormItemImpl
 * @see com.rcs.webform.model.impl.FormItemModelImpl
 * @generated
 */
public interface FormItemModel extends BaseModel<FormItem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a form item model instance should use the {@link FormItem} interface instead.
	 */

	/**
	 * Returns the primary key of this form item.
	 *
	 * @return the primary key of this form item
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this form item.
	 *
	 * @param primaryKey the primary key of this form item
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the form item ID of this form item.
	 *
	 * @return the form item ID of this form item
	 */
	public long getFormItemId();

	/**
	 * Sets the form item ID of this form item.
	 *
	 * @param formItemId the form item ID of this form item
	 */
	public void setFormItemId(long formItemId);

	/**
	 * Returns the active of this form item.
	 *
	 * @return the active of this form item
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this form item is active.
	 *
	 * @return <code>true</code> if this form item is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this form item is active.
	 *
	 * @param active the active of this form item
	 */
	public void setActive(boolean active);

	/**
	 * Returns the creation date of this form item.
	 *
	 * @return the creation date of this form item
	 */
	public Date getCreationDate();

	/**
	 * Sets the creation date of this form item.
	 *
	 * @param creationDate the creation date of this form item
	 */
	public void setCreationDate(Date creationDate);

	/**
	 * Returns the modification date of this form item.
	 *
	 * @return the modification date of this form item
	 */
	public Date getModificationDate();

	/**
	 * Sets the modification date of this form item.
	 *
	 * @param modificationDate the modification date of this form item
	 */
	public void setModificationDate(Date modificationDate);

	/**
	 * Returns the modification user of this form item.
	 *
	 * @return the modification user of this form item
	 */
	@AutoEscape
	public String getModificationUser();

	/**
	 * Sets the modification user of this form item.
	 *
	 * @param modificationUser the modification user of this form item
	 */
	public void setModificationUser(String modificationUser);

	/**
	 * Returns the form ID of this form item.
	 *
	 * @return the form ID of this form item
	 */
	public long getFormId();

	/**
	 * Sets the form ID of this form item.
	 *
	 * @param formId the form ID of this form item
	 */
	public void setFormId(long formId);

	/**
	 * Returns the form item attr ID of this form item.
	 *
	 * @return the form item attr ID of this form item
	 */
	@AutoEscape
	public String getFormItemAttrId();

	/**
	 * Sets the form item attr ID of this form item.
	 *
	 * @param formItemAttrId the form item attr ID of this form item
	 */
	public void setFormItemAttrId(String formItemAttrId);

	/**
	 * Returns the form item attr class of this form item.
	 *
	 * @return the form item attr class of this form item
	 */
	@AutoEscape
	public String getFormItemAttrClass();

	/**
	 * Sets the form item attr class of this form item.
	 *
	 * @param formItemAttrClass the form item attr class of this form item
	 */
	public void setFormItemAttrClass(String formItemAttrClass);

	/**
	 * Returns the label of this form item.
	 *
	 * @return the label of this form item
	 */
	public String getLabel();

	/**
	 * Returns the localized label of this form item in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized label of this form item
	 */
	@AutoEscape
	public String getLabel(Locale locale);

	/**
	 * Returns the localized label of this form item in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized label of this form item. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getLabel(Locale locale, boolean useDefault);

	/**
	 * Returns the localized label of this form item in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized label of this form item
	 */
	@AutoEscape
	public String getLabel(String languageId);

	/**
	 * Returns the localized label of this form item in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized label of this form item
	 */
	@AutoEscape
	public String getLabel(String languageId, boolean useDefault);

	@AutoEscape
	public String getLabelCurrentLanguageId();

	@AutoEscape
	public String getLabelCurrentValue();

	/**
	 * Returns a map of the locales and localized labels of this form item.
	 *
	 * @return the locales and localized labels of this form item
	 */
	public Map<Locale, String> getLabelMap();

	/**
	 * Sets the label of this form item.
	 *
	 * @param label the label of this form item
	 */
	public void setLabel(String label);

	/**
	 * Sets the localized label of this form item in the language.
	 *
	 * @param label the localized label of this form item
	 * @param locale the locale of the language
	 */
	public void setLabel(String label, Locale locale);

	/**
	 * Sets the localized label of this form item in the language, and sets the default locale.
	 *
	 * @param label the localized label of this form item
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setLabel(String label, Locale locale, Locale defaultLocale);

	public void setLabelCurrentLanguageId(String languageId);

	/**
	 * Sets the localized labels of this form item from the map of locales and localized labels.
	 *
	 * @param labelMap the locales and localized labels of this form item
	 */
	public void setLabelMap(Map<Locale, String> labelMap);

	/**
	 * Sets the localized labels of this form item from the map of locales and localized labels, and sets the default locale.
	 *
	 * @param labelMap the locales and localized labels of this form item
	 * @param defaultLocale the default locale
	 */
	public void setLabelMap(Map<Locale, String> labelMap, Locale defaultLocale);

	/**
	 * Returns the label attr ID of this form item.
	 *
	 * @return the label attr ID of this form item
	 */
	@AutoEscape
	public String getLabelAttrId();

	/**
	 * Sets the label attr ID of this form item.
	 *
	 * @param labelAttrId the label attr ID of this form item
	 */
	public void setLabelAttrId(String labelAttrId);

	/**
	 * Returns the label attr class of this form item.
	 *
	 * @return the label attr class of this form item
	 */
	@AutoEscape
	public String getLabelAttrClass();

	/**
	 * Sets the label attr class of this form item.
	 *
	 * @param labelAttrClass the label attr class of this form item
	 */
	public void setLabelAttrClass(String labelAttrClass);

	/**
	 * Returns the input attr ID of this form item.
	 *
	 * @return the input attr ID of this form item
	 */
	@AutoEscape
	public String getInputAttrId();

	/**
	 * Sets the input attr ID of this form item.
	 *
	 * @param inputAttrId the input attr ID of this form item
	 */
	public void setInputAttrId(String inputAttrId);

	/**
	 * Returns the input attr class of this form item.
	 *
	 * @return the input attr class of this form item
	 */
	@AutoEscape
	public String getInputAttrClass();

	/**
	 * Sets the input attr class of this form item.
	 *
	 * @param inputAttrClass the input attr class of this form item
	 */
	public void setInputAttrClass(String inputAttrClass);

	/**
	 * Returns the type of this form item.
	 *
	 * @return the type of this form item
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this form item.
	 *
	 * @param type the type of this form item
	 */
	public void setType(String type);

	/**
	 * Returns the options of this form item.
	 *
	 * @return the options of this form item
	 */
	public String getOptions();

	/**
	 * Returns the localized options of this form item in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized options of this form item
	 */
	@AutoEscape
	public String getOptions(Locale locale);

	/**
	 * Returns the localized options of this form item in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized options of this form item. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getOptions(Locale locale, boolean useDefault);

	/**
	 * Returns the localized options of this form item in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized options of this form item
	 */
	@AutoEscape
	public String getOptions(String languageId);

	/**
	 * Returns the localized options of this form item in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized options of this form item
	 */
	@AutoEscape
	public String getOptions(String languageId, boolean useDefault);

	@AutoEscape
	public String getOptionsCurrentLanguageId();

	@AutoEscape
	public String getOptionsCurrentValue();

	/**
	 * Returns a map of the locales and localized optionses of this form item.
	 *
	 * @return the locales and localized optionses of this form item
	 */
	public Map<Locale, String> getOptionsMap();

	/**
	 * Sets the options of this form item.
	 *
	 * @param options the options of this form item
	 */
	public void setOptions(String options);

	/**
	 * Sets the localized options of this form item in the language.
	 *
	 * @param options the localized options of this form item
	 * @param locale the locale of the language
	 */
	public void setOptions(String options, Locale locale);

	/**
	 * Sets the localized options of this form item in the language, and sets the default locale.
	 *
	 * @param options the localized options of this form item
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setOptions(String options, Locale locale, Locale defaultLocale);

	public void setOptionsCurrentLanguageId(String languageId);

	/**
	 * Sets the localized optionses of this form item from the map of locales and localized optionses.
	 *
	 * @param optionsMap the locales and localized optionses of this form item
	 */
	public void setOptionsMap(Map<Locale, String> optionsMap);

	/**
	 * Sets the localized optionses of this form item from the map of locales and localized optionses, and sets the default locale.
	 *
	 * @param optionsMap the locales and localized optionses of this form item
	 * @param defaultLocale the default locale
	 */
	public void setOptionsMap(Map<Locale, String> optionsMap,
		Locale defaultLocale);

	/**
	 * Returns the mandatory of this form item.
	 *
	 * @return the mandatory of this form item
	 */
	public boolean getMandatory();

	/**
	 * Returns <code>true</code> if this form item is mandatory.
	 *
	 * @return <code>true</code> if this form item is mandatory; <code>false</code> otherwise
	 */
	public boolean isMandatory();

	/**
	 * Sets whether this form item is mandatory.
	 *
	 * @param mandatory the mandatory of this form item
	 */
	public void setMandatory(boolean mandatory);

	/**
	 * Returns the default value of this form item.
	 *
	 * @return the default value of this form item
	 */
	public String getDefaultValue();

	/**
	 * Returns the localized default value of this form item in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized default value of this form item
	 */
	@AutoEscape
	public String getDefaultValue(Locale locale);

	/**
	 * Returns the localized default value of this form item in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized default value of this form item. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDefaultValue(Locale locale, boolean useDefault);

	/**
	 * Returns the localized default value of this form item in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized default value of this form item
	 */
	@AutoEscape
	public String getDefaultValue(String languageId);

	/**
	 * Returns the localized default value of this form item in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized default value of this form item
	 */
	@AutoEscape
	public String getDefaultValue(String languageId, boolean useDefault);

	@AutoEscape
	public String getDefaultValueCurrentLanguageId();

	@AutoEscape
	public String getDefaultValueCurrentValue();

	/**
	 * Returns a map of the locales and localized default values of this form item.
	 *
	 * @return the locales and localized default values of this form item
	 */
	public Map<Locale, String> getDefaultValueMap();

	/**
	 * Sets the default value of this form item.
	 *
	 * @param defaultValue the default value of this form item
	 */
	public void setDefaultValue(String defaultValue);

	/**
	 * Sets the localized default value of this form item in the language.
	 *
	 * @param defaultValue the localized default value of this form item
	 * @param locale the locale of the language
	 */
	public void setDefaultValue(String defaultValue, Locale locale);

	/**
	 * Sets the localized default value of this form item in the language, and sets the default locale.
	 *
	 * @param defaultValue the localized default value of this form item
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDefaultValue(String defaultValue, Locale locale,
		Locale defaultLocale);

	public void setDefaultValueCurrentLanguageId(String languageId);

	/**
	 * Sets the localized default values of this form item from the map of locales and localized default values.
	 *
	 * @param defaultValueMap the locales and localized default values of this form item
	 */
	public void setDefaultValueMap(Map<Locale, String> defaultValueMap);

	/**
	 * Sets the localized default values of this form item from the map of locales and localized default values, and sets the default locale.
	 *
	 * @param defaultValueMap the locales and localized default values of this form item
	 * @param defaultLocale the default locale
	 */
	public void setDefaultValueMap(Map<Locale, String> defaultValueMap,
		Locale defaultLocale);

	/**
	 * Returns the order of this form item.
	 *
	 * @return the order of this form item
	 */
	public int getOrder();

	/**
	 * Sets the order of this form item.
	 *
	 * @param order the order of this form item
	 */
	public void setOrder(int order);

	/**
	 * Returns the validation type of this form item.
	 *
	 * @return the validation type of this form item
	 */
	@AutoEscape
	public String getValidationType();

	/**
	 * Sets the validation type of this form item.
	 *
	 * @param validationType the validation type of this form item
	 */
	public void setValidationType(String validationType);

	/**
	 * Returns the validation regex value of this form item.
	 *
	 * @return the validation regex value of this form item
	 */
	@AutoEscape
	public String getValidationRegexValue();

	/**
	 * Sets the validation regex value of this form item.
	 *
	 * @param validationRegexValue the validation regex value of this form item
	 */
	public void setValidationRegexValue(String validationRegexValue);

	/**
	 * Returns the min length of this form item.
	 *
	 * @return the min length of this form item
	 */
	public int getMinLength();

	/**
	 * Sets the min length of this form item.
	 *
	 * @param minLength the min length of this form item
	 */
	public void setMinLength(int minLength);

	/**
	 * Returns the max length of this form item.
	 *
	 * @return the max length of this form item
	 */
	public int getMaxLength();

	/**
	 * Sets the max length of this form item.
	 *
	 * @param maxLength the max length of this form item
	 */
	public void setMaxLength(int maxLength);

	/**
	 * Returns the error validation message of this form item.
	 *
	 * @return the error validation message of this form item
	 */
	public String getErrorValidationMessage();

	/**
	 * Returns the localized error validation message of this form item in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized error validation message of this form item
	 */
	@AutoEscape
	public String getErrorValidationMessage(Locale locale);

	/**
	 * Returns the localized error validation message of this form item in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized error validation message of this form item. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getErrorValidationMessage(Locale locale, boolean useDefault);

	/**
	 * Returns the localized error validation message of this form item in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized error validation message of this form item
	 */
	@AutoEscape
	public String getErrorValidationMessage(String languageId);

	/**
	 * Returns the localized error validation message of this form item in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized error validation message of this form item
	 */
	@AutoEscape
	public String getErrorValidationMessage(String languageId,
		boolean useDefault);

	@AutoEscape
	public String getErrorValidationMessageCurrentLanguageId();

	@AutoEscape
	public String getErrorValidationMessageCurrentValue();

	/**
	 * Returns a map of the locales and localized error validation messages of this form item.
	 *
	 * @return the locales and localized error validation messages of this form item
	 */
	public Map<Locale, String> getErrorValidationMessageMap();

	/**
	 * Sets the error validation message of this form item.
	 *
	 * @param errorValidationMessage the error validation message of this form item
	 */
	public void setErrorValidationMessage(String errorValidationMessage);

	/**
	 * Sets the localized error validation message of this form item in the language.
	 *
	 * @param errorValidationMessage the localized error validation message of this form item
	 * @param locale the locale of the language
	 */
	public void setErrorValidationMessage(String errorValidationMessage,
		Locale locale);

	/**
	 * Sets the localized error validation message of this form item in the language, and sets the default locale.
	 *
	 * @param errorValidationMessage the localized error validation message of this form item
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setErrorValidationMessage(String errorValidationMessage,
		Locale locale, Locale defaultLocale);

	public void setErrorValidationMessageCurrentLanguageId(String languageId);

	/**
	 * Sets the localized error validation messages of this form item from the map of locales and localized error validation messages.
	 *
	 * @param errorValidationMessageMap the locales and localized error validation messages of this form item
	 */
	public void setErrorValidationMessageMap(
		Map<Locale, String> errorValidationMessageMap);

	/**
	 * Sets the localized error validation messages of this form item from the map of locales and localized error validation messages, and sets the default locale.
	 *
	 * @param errorValidationMessageMap the locales and localized error validation messages of this form item
	 * @param defaultLocale the default locale
	 */
	public void setErrorValidationMessageMap(
		Map<Locale, String> errorValidationMessageMap, Locale defaultLocale);

	/**
	 * Returns the error mandatory message of this form item.
	 *
	 * @return the error mandatory message of this form item
	 */
	public String getErrorMandatoryMessage();

	/**
	 * Returns the localized error mandatory message of this form item in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized error mandatory message of this form item
	 */
	@AutoEscape
	public String getErrorMandatoryMessage(Locale locale);

	/**
	 * Returns the localized error mandatory message of this form item in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized error mandatory message of this form item. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getErrorMandatoryMessage(Locale locale, boolean useDefault);

	/**
	 * Returns the localized error mandatory message of this form item in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized error mandatory message of this form item
	 */
	@AutoEscape
	public String getErrorMandatoryMessage(String languageId);

	/**
	 * Returns the localized error mandatory message of this form item in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized error mandatory message of this form item
	 */
	@AutoEscape
	public String getErrorMandatoryMessage(String languageId, boolean useDefault);

	@AutoEscape
	public String getErrorMandatoryMessageCurrentLanguageId();

	@AutoEscape
	public String getErrorMandatoryMessageCurrentValue();

	/**
	 * Returns a map of the locales and localized error mandatory messages of this form item.
	 *
	 * @return the locales and localized error mandatory messages of this form item
	 */
	public Map<Locale, String> getErrorMandatoryMessageMap();

	/**
	 * Sets the error mandatory message of this form item.
	 *
	 * @param errorMandatoryMessage the error mandatory message of this form item
	 */
	public void setErrorMandatoryMessage(String errorMandatoryMessage);

	/**
	 * Sets the localized error mandatory message of this form item in the language.
	 *
	 * @param errorMandatoryMessage the localized error mandatory message of this form item
	 * @param locale the locale of the language
	 */
	public void setErrorMandatoryMessage(String errorMandatoryMessage,
		Locale locale);

	/**
	 * Sets the localized error mandatory message of this form item in the language, and sets the default locale.
	 *
	 * @param errorMandatoryMessage the localized error mandatory message of this form item
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setErrorMandatoryMessage(String errorMandatoryMessage,
		Locale locale, Locale defaultLocale);

	public void setErrorMandatoryMessageCurrentLanguageId(String languageId);

	/**
	 * Sets the localized error mandatory messages of this form item from the map of locales and localized error mandatory messages.
	 *
	 * @param errorMandatoryMessageMap the locales and localized error mandatory messages of this form item
	 */
	public void setErrorMandatoryMessageMap(
		Map<Locale, String> errorMandatoryMessageMap);

	/**
	 * Sets the localized error mandatory messages of this form item from the map of locales and localized error mandatory messages, and sets the default locale.
	 *
	 * @param errorMandatoryMessageMap the locales and localized error mandatory messages of this form item
	 * @param defaultLocale the default locale
	 */
	public void setErrorMandatoryMessageMap(
		Map<Locale, String> errorMandatoryMessageMap, Locale defaultLocale);

	/**
	 * Returns the error length message of this form item.
	 *
	 * @return the error length message of this form item
	 */
	public String getErrorLengthMessage();

	/**
	 * Returns the localized error length message of this form item in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized error length message of this form item
	 */
	@AutoEscape
	public String getErrorLengthMessage(Locale locale);

	/**
	 * Returns the localized error length message of this form item in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized error length message of this form item. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getErrorLengthMessage(Locale locale, boolean useDefault);

	/**
	 * Returns the localized error length message of this form item in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized error length message of this form item
	 */
	@AutoEscape
	public String getErrorLengthMessage(String languageId);

	/**
	 * Returns the localized error length message of this form item in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized error length message of this form item
	 */
	@AutoEscape
	public String getErrorLengthMessage(String languageId, boolean useDefault);

	@AutoEscape
	public String getErrorLengthMessageCurrentLanguageId();

	@AutoEscape
	public String getErrorLengthMessageCurrentValue();

	/**
	 * Returns a map of the locales and localized error length messages of this form item.
	 *
	 * @return the locales and localized error length messages of this form item
	 */
	public Map<Locale, String> getErrorLengthMessageMap();

	/**
	 * Sets the error length message of this form item.
	 *
	 * @param errorLengthMessage the error length message of this form item
	 */
	public void setErrorLengthMessage(String errorLengthMessage);

	/**
	 * Sets the localized error length message of this form item in the language.
	 *
	 * @param errorLengthMessage the localized error length message of this form item
	 * @param locale the locale of the language
	 */
	public void setErrorLengthMessage(String errorLengthMessage, Locale locale);

	/**
	 * Sets the localized error length message of this form item in the language, and sets the default locale.
	 *
	 * @param errorLengthMessage the localized error length message of this form item
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setErrorLengthMessage(String errorLengthMessage, Locale locale,
		Locale defaultLocale);

	public void setErrorLengthMessageCurrentLanguageId(String languageId);

	/**
	 * Sets the localized error length messages of this form item from the map of locales and localized error length messages.
	 *
	 * @param errorLengthMessageMap the locales and localized error length messages of this form item
	 */
	public void setErrorLengthMessageMap(
		Map<Locale, String> errorLengthMessageMap);

	/**
	 * Sets the localized error length messages of this form item from the map of locales and localized error length messages, and sets the default locale.
	 *
	 * @param errorLengthMessageMap the locales and localized error length messages of this form item
	 * @param defaultLocale the default locale
	 */
	public void setErrorLengthMessageMap(
		Map<Locale, String> errorLengthMessageMap, Locale defaultLocale);

	/**
	 * Returns the hint message of this form item.
	 *
	 * @return the hint message of this form item
	 */
	public String getHintMessage();

	/**
	 * Returns the localized hint message of this form item in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized hint message of this form item
	 */
	@AutoEscape
	public String getHintMessage(Locale locale);

	/**
	 * Returns the localized hint message of this form item in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized hint message of this form item. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getHintMessage(Locale locale, boolean useDefault);

	/**
	 * Returns the localized hint message of this form item in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized hint message of this form item
	 */
	@AutoEscape
	public String getHintMessage(String languageId);

	/**
	 * Returns the localized hint message of this form item in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized hint message of this form item
	 */
	@AutoEscape
	public String getHintMessage(String languageId, boolean useDefault);

	@AutoEscape
	public String getHintMessageCurrentLanguageId();

	@AutoEscape
	public String getHintMessageCurrentValue();

	/**
	 * Returns a map of the locales and localized hint messages of this form item.
	 *
	 * @return the locales and localized hint messages of this form item
	 */
	public Map<Locale, String> getHintMessageMap();

	/**
	 * Sets the hint message of this form item.
	 *
	 * @param hintMessage the hint message of this form item
	 */
	public void setHintMessage(String hintMessage);

	/**
	 * Sets the localized hint message of this form item in the language.
	 *
	 * @param hintMessage the localized hint message of this form item
	 * @param locale the locale of the language
	 */
	public void setHintMessage(String hintMessage, Locale locale);

	/**
	 * Sets the localized hint message of this form item in the language, and sets the default locale.
	 *
	 * @param hintMessage the localized hint message of this form item
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setHintMessage(String hintMessage, Locale locale,
		Locale defaultLocale);

	public void setHintMessageCurrentLanguageId(String languageId);

	/**
	 * Sets the localized hint messages of this form item from the map of locales and localized hint messages.
	 *
	 * @param hintMessageMap the locales and localized hint messages of this form item
	 */
	public void setHintMessageMap(Map<Locale, String> hintMessageMap);

	/**
	 * Sets the localized hint messages of this form item from the map of locales and localized hint messages, and sets the default locale.
	 *
	 * @param hintMessageMap the locales and localized hint messages of this form item
	 * @param defaultLocale the default locale
	 */
	public void setHintMessageMap(Map<Locale, String> hintMessageMap,
		Locale defaultLocale);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public String[] getAvailableLanguageIds();

	public String getDefaultLanguageId();

	public void prepareLocalizedFieldsForImport() throws LocaleException;

	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public Object clone();

	@Override
	public int compareTo(FormItem formItem);

	@Override
	public int hashCode();

	@Override
	public CacheModel<FormItem> toCacheModel();

	@Override
	public FormItem toEscapedModel();

	@Override
	public FormItem toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}