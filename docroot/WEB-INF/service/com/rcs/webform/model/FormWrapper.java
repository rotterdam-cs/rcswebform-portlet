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
 * This class is a wrapper for {@link Form}.
 * </p>
 *
 * @author ryusuf
 * @see Form
 * @generated
 */
public class FormWrapper implements Form, ModelWrapper<Form> {
	public FormWrapper(Form form) {
		_form = form;
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

	/**
	* Returns the primary key of this form.
	*
	* @return the primary key of this form
	*/
	@Override
	public long getPrimaryKey() {
		return _form.getPrimaryKey();
	}

	/**
	* Sets the primary key of this form.
	*
	* @param primaryKey the primary key of this form
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_form.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the form ID of this form.
	*
	* @return the form ID of this form
	*/
	@Override
	public long getFormId() {
		return _form.getFormId();
	}

	/**
	* Sets the form ID of this form.
	*
	* @param formId the form ID of this form
	*/
	@Override
	public void setFormId(long formId) {
		_form.setFormId(formId);
	}

	/**
	* Returns the active of this form.
	*
	* @return the active of this form
	*/
	@Override
	public boolean getActive() {
		return _form.getActive();
	}

	/**
	* Returns <code>true</code> if this form is active.
	*
	* @return <code>true</code> if this form is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _form.isActive();
	}

	/**
	* Sets whether this form is active.
	*
	* @param active the active of this form
	*/
	@Override
	public void setActive(boolean active) {
		_form.setActive(active);
	}

	/**
	* Returns the creation date of this form.
	*
	* @return the creation date of this form
	*/
	@Override
	public java.util.Date getCreationDate() {
		return _form.getCreationDate();
	}

	/**
	* Sets the creation date of this form.
	*
	* @param creationDate the creation date of this form
	*/
	@Override
	public void setCreationDate(java.util.Date creationDate) {
		_form.setCreationDate(creationDate);
	}

	/**
	* Returns the modification date of this form.
	*
	* @return the modification date of this form
	*/
	@Override
	public java.util.Date getModificationDate() {
		return _form.getModificationDate();
	}

	/**
	* Sets the modification date of this form.
	*
	* @param modificationDate the modification date of this form
	*/
	@Override
	public void setModificationDate(java.util.Date modificationDate) {
		_form.setModificationDate(modificationDate);
	}

	/**
	* Returns the modification user of this form.
	*
	* @return the modification user of this form
	*/
	@Override
	public java.lang.String getModificationUser() {
		return _form.getModificationUser();
	}

	/**
	* Sets the modification user of this form.
	*
	* @param modificationUser the modification user of this form
	*/
	@Override
	public void setModificationUser(java.lang.String modificationUser) {
		_form.setModificationUser(modificationUser);
	}

	/**
	* Returns the group ID of this form.
	*
	* @return the group ID of this form
	*/
	@Override
	public long getGroupId() {
		return _form.getGroupId();
	}

	/**
	* Sets the group ID of this form.
	*
	* @param groupId the group ID of this form
	*/
	@Override
	public void setGroupId(long groupId) {
		_form.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this form.
	*
	* @return the company ID of this form
	*/
	@Override
	public long getCompanyId() {
		return _form.getCompanyId();
	}

	/**
	* Sets the company ID of this form.
	*
	* @param companyId the company ID of this form
	*/
	@Override
	public void setCompanyId(long companyId) {
		_form.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this form.
	*
	* @return the user ID of this form
	*/
	@Override
	public long getUserId() {
		return _form.getUserId();
	}

	/**
	* Sets the user ID of this form.
	*
	* @param userId the user ID of this form
	*/
	@Override
	public void setUserId(long userId) {
		_form.setUserId(userId);
	}

	/**
	* Returns the user uuid of this form.
	*
	* @return the user uuid of this form
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _form.getUserUuid();
	}

	/**
	* Sets the user uuid of this form.
	*
	* @param userUuid the user uuid of this form
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_form.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this form.
	*
	* @return the user name of this form
	*/
	@Override
	public java.lang.String getUserName() {
		return _form.getUserName();
	}

	/**
	* Sets the user name of this form.
	*
	* @param userName the user name of this form
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_form.setUserName(userName);
	}

	/**
	* Returns the form attr ID of this form.
	*
	* @return the form attr ID of this form
	*/
	@Override
	public java.lang.String getFormAttrId() {
		return _form.getFormAttrId();
	}

	/**
	* Sets the form attr ID of this form.
	*
	* @param formAttrId the form attr ID of this form
	*/
	@Override
	public void setFormAttrId(java.lang.String formAttrId) {
		_form.setFormAttrId(formAttrId);
	}

	/**
	* Returns the form attr class of this form.
	*
	* @return the form attr class of this form
	*/
	@Override
	public java.lang.String getFormAttrClass() {
		return _form.getFormAttrClass();
	}

	/**
	* Sets the form attr class of this form.
	*
	* @param formAttrClass the form attr class of this form
	*/
	@Override
	public void setFormAttrClass(java.lang.String formAttrClass) {
		_form.setFormAttrClass(formAttrClass);
	}

	/**
	* Returns the title of this form.
	*
	* @return the title of this form
	*/
	@Override
	public java.lang.String getTitle() {
		return _form.getTitle();
	}

	/**
	* Returns the localized title of this form in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized title of this form
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		return _form.getTitle(locale);
	}

	/**
	* Returns the localized title of this form in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this form. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
		return _form.getTitle(locale, useDefault);
	}

	/**
	* Returns the localized title of this form in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized title of this form
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId) {
		return _form.getTitle(languageId);
	}

	/**
	* Returns the localized title of this form in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this form
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault) {
		return _form.getTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getTitleCurrentLanguageId() {
		return _form.getTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getTitleCurrentValue() {
		return _form.getTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized titles of this form.
	*
	* @return the locales and localized titles of this form
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getTitleMap() {
		return _form.getTitleMap();
	}

	/**
	* Sets the title of this form.
	*
	* @param title the title of this form
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_form.setTitle(title);
	}

	/**
	* Sets the localized title of this form in the language.
	*
	* @param title the localized title of this form
	* @param locale the locale of the language
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale) {
		_form.setTitle(title, locale);
	}

	/**
	* Sets the localized title of this form in the language, and sets the default locale.
	*
	* @param title the localized title of this form
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_form.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(java.lang.String languageId) {
		_form.setTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized titles of this form from the map of locales and localized titles.
	*
	* @param titleMap the locales and localized titles of this form
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap) {
		_form.setTitleMap(titleMap);
	}

	/**
	* Sets the localized titles of this form from the map of locales and localized titles, and sets the default locale.
	*
	* @param titleMap the locales and localized titles of this form
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Locale defaultLocale) {
		_form.setTitleMap(titleMap, defaultLocale);
	}

	/**
	* Returns the desc of this form.
	*
	* @return the desc of this form
	*/
	@Override
	public java.lang.String getDesc() {
		return _form.getDesc();
	}

	/**
	* Returns the localized desc of this form in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized desc of this form
	*/
	@Override
	public java.lang.String getDesc(java.util.Locale locale) {
		return _form.getDesc(locale);
	}

	/**
	* Returns the localized desc of this form in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized desc of this form. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDesc(java.util.Locale locale, boolean useDefault) {
		return _form.getDesc(locale, useDefault);
	}

	/**
	* Returns the localized desc of this form in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized desc of this form
	*/
	@Override
	public java.lang.String getDesc(java.lang.String languageId) {
		return _form.getDesc(languageId);
	}

	/**
	* Returns the localized desc of this form in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized desc of this form
	*/
	@Override
	public java.lang.String getDesc(java.lang.String languageId,
		boolean useDefault) {
		return _form.getDesc(languageId, useDefault);
	}

	@Override
	public java.lang.String getDescCurrentLanguageId() {
		return _form.getDescCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescCurrentValue() {
		return _form.getDescCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descs of this form.
	*
	* @return the locales and localized descs of this form
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getDescMap() {
		return _form.getDescMap();
	}

	/**
	* Sets the desc of this form.
	*
	* @param desc the desc of this form
	*/
	@Override
	public void setDesc(java.lang.String desc) {
		_form.setDesc(desc);
	}

	/**
	* Sets the localized desc of this form in the language.
	*
	* @param desc the localized desc of this form
	* @param locale the locale of the language
	*/
	@Override
	public void setDesc(java.lang.String desc, java.util.Locale locale) {
		_form.setDesc(desc, locale);
	}

	/**
	* Sets the localized desc of this form in the language, and sets the default locale.
	*
	* @param desc the localized desc of this form
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDesc(java.lang.String desc, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_form.setDesc(desc, locale, defaultLocale);
	}

	@Override
	public void setDescCurrentLanguageId(java.lang.String languageId) {
		_form.setDescCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descs of this form from the map of locales and localized descs.
	*
	* @param descMap the locales and localized descs of this form
	*/
	@Override
	public void setDescMap(
		java.util.Map<java.util.Locale, java.lang.String> descMap) {
		_form.setDescMap(descMap);
	}

	/**
	* Sets the localized descs of this form from the map of locales and localized descs, and sets the default locale.
	*
	* @param descMap the locales and localized descs of this form
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescMap(
		java.util.Map<java.util.Locale, java.lang.String> descMap,
		java.util.Locale defaultLocale) {
		_form.setDescMap(descMap, defaultLocale);
	}

	/**
	* Returns the use captcha of this form.
	*
	* @return the use captcha of this form
	*/
	@Override
	public boolean getUseCaptcha() {
		return _form.getUseCaptcha();
	}

	/**
	* Returns <code>true</code> if this form is use captcha.
	*
	* @return <code>true</code> if this form is use captcha; <code>false</code> otherwise
	*/
	@Override
	public boolean isUseCaptcha() {
		return _form.isUseCaptcha();
	}

	/**
	* Sets whether this form is use captcha.
	*
	* @param useCaptcha the use captcha of this form
	*/
	@Override
	public void setUseCaptcha(boolean useCaptcha) {
		_form.setUseCaptcha(useCaptcha);
	}

	/**
	* Returns the success message of this form.
	*
	* @return the success message of this form
	*/
	@Override
	public java.lang.String getSuccessMessage() {
		return _form.getSuccessMessage();
	}

	/**
	* Returns the localized success message of this form in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized success message of this form
	*/
	@Override
	public java.lang.String getSuccessMessage(java.util.Locale locale) {
		return _form.getSuccessMessage(locale);
	}

	/**
	* Returns the localized success message of this form in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized success message of this form. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getSuccessMessage(java.util.Locale locale,
		boolean useDefault) {
		return _form.getSuccessMessage(locale, useDefault);
	}

	/**
	* Returns the localized success message of this form in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized success message of this form
	*/
	@Override
	public java.lang.String getSuccessMessage(java.lang.String languageId) {
		return _form.getSuccessMessage(languageId);
	}

	/**
	* Returns the localized success message of this form in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized success message of this form
	*/
	@Override
	public java.lang.String getSuccessMessage(java.lang.String languageId,
		boolean useDefault) {
		return _form.getSuccessMessage(languageId, useDefault);
	}

	@Override
	public java.lang.String getSuccessMessageCurrentLanguageId() {
		return _form.getSuccessMessageCurrentLanguageId();
	}

	@Override
	public java.lang.String getSuccessMessageCurrentValue() {
		return _form.getSuccessMessageCurrentValue();
	}

	/**
	* Returns a map of the locales and localized success messages of this form.
	*
	* @return the locales and localized success messages of this form
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getSuccessMessageMap() {
		return _form.getSuccessMessageMap();
	}

	/**
	* Sets the success message of this form.
	*
	* @param successMessage the success message of this form
	*/
	@Override
	public void setSuccessMessage(java.lang.String successMessage) {
		_form.setSuccessMessage(successMessage);
	}

	/**
	* Sets the localized success message of this form in the language.
	*
	* @param successMessage the localized success message of this form
	* @param locale the locale of the language
	*/
	@Override
	public void setSuccessMessage(java.lang.String successMessage,
		java.util.Locale locale) {
		_form.setSuccessMessage(successMessage, locale);
	}

	/**
	* Sets the localized success message of this form in the language, and sets the default locale.
	*
	* @param successMessage the localized success message of this form
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSuccessMessage(java.lang.String successMessage,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_form.setSuccessMessage(successMessage, locale, defaultLocale);
	}

	@Override
	public void setSuccessMessageCurrentLanguageId(java.lang.String languageId) {
		_form.setSuccessMessageCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized success messages of this form from the map of locales and localized success messages.
	*
	* @param successMessageMap the locales and localized success messages of this form
	*/
	@Override
	public void setSuccessMessageMap(
		java.util.Map<java.util.Locale, java.lang.String> successMessageMap) {
		_form.setSuccessMessageMap(successMessageMap);
	}

	/**
	* Sets the localized success messages of this form from the map of locales and localized success messages, and sets the default locale.
	*
	* @param successMessageMap the locales and localized success messages of this form
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSuccessMessageMap(
		java.util.Map<java.util.Locale, java.lang.String> successMessageMap,
		java.util.Locale defaultLocale) {
		_form.setSuccessMessageMap(successMessageMap, defaultLocale);
	}

	/**
	* Returns the success u r l of this form.
	*
	* @return the success u r l of this form
	*/
	@Override
	public java.lang.String getSuccessURL() {
		return _form.getSuccessURL();
	}

	/**
	* Sets the success u r l of this form.
	*
	* @param successURL the success u r l of this form
	*/
	@Override
	public void setSuccessURL(java.lang.String successURL) {
		_form.setSuccessURL(successURL);
	}

	/**
	* Returns the submit label of this form.
	*
	* @return the submit label of this form
	*/
	@Override
	public java.lang.String getSubmitLabel() {
		return _form.getSubmitLabel();
	}

	/**
	* Returns the localized submit label of this form in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized submit label of this form
	*/
	@Override
	public java.lang.String getSubmitLabel(java.util.Locale locale) {
		return _form.getSubmitLabel(locale);
	}

	/**
	* Returns the localized submit label of this form in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized submit label of this form. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getSubmitLabel(java.util.Locale locale,
		boolean useDefault) {
		return _form.getSubmitLabel(locale, useDefault);
	}

	/**
	* Returns the localized submit label of this form in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized submit label of this form
	*/
	@Override
	public java.lang.String getSubmitLabel(java.lang.String languageId) {
		return _form.getSubmitLabel(languageId);
	}

	/**
	* Returns the localized submit label of this form in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized submit label of this form
	*/
	@Override
	public java.lang.String getSubmitLabel(java.lang.String languageId,
		boolean useDefault) {
		return _form.getSubmitLabel(languageId, useDefault);
	}

	@Override
	public java.lang.String getSubmitLabelCurrentLanguageId() {
		return _form.getSubmitLabelCurrentLanguageId();
	}

	@Override
	public java.lang.String getSubmitLabelCurrentValue() {
		return _form.getSubmitLabelCurrentValue();
	}

	/**
	* Returns a map of the locales and localized submit labels of this form.
	*
	* @return the locales and localized submit labels of this form
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getSubmitLabelMap() {
		return _form.getSubmitLabelMap();
	}

	/**
	* Sets the submit label of this form.
	*
	* @param submitLabel the submit label of this form
	*/
	@Override
	public void setSubmitLabel(java.lang.String submitLabel) {
		_form.setSubmitLabel(submitLabel);
	}

	/**
	* Sets the localized submit label of this form in the language.
	*
	* @param submitLabel the localized submit label of this form
	* @param locale the locale of the language
	*/
	@Override
	public void setSubmitLabel(java.lang.String submitLabel,
		java.util.Locale locale) {
		_form.setSubmitLabel(submitLabel, locale);
	}

	/**
	* Sets the localized submit label of this form in the language, and sets the default locale.
	*
	* @param submitLabel the localized submit label of this form
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSubmitLabel(java.lang.String submitLabel,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_form.setSubmitLabel(submitLabel, locale, defaultLocale);
	}

	@Override
	public void setSubmitLabelCurrentLanguageId(java.lang.String languageId) {
		_form.setSubmitLabelCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized submit labels of this form from the map of locales and localized submit labels.
	*
	* @param submitLabelMap the locales and localized submit labels of this form
	*/
	@Override
	public void setSubmitLabelMap(
		java.util.Map<java.util.Locale, java.lang.String> submitLabelMap) {
		_form.setSubmitLabelMap(submitLabelMap);
	}

	/**
	* Sets the localized submit labels of this form from the map of locales and localized submit labels, and sets the default locale.
	*
	* @param submitLabelMap the locales and localized submit labels of this form
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSubmitLabelMap(
		java.util.Map<java.util.Locale, java.lang.String> submitLabelMap,
		java.util.Locale defaultLocale) {
		_form.setSubmitLabelMap(submitLabelMap, defaultLocale);
	}

	/**
	* Returns the submit attr ID of this form.
	*
	* @return the submit attr ID of this form
	*/
	@Override
	public java.lang.String getSubmitAttrId() {
		return _form.getSubmitAttrId();
	}

	/**
	* Sets the submit attr ID of this form.
	*
	* @param submitAttrId the submit attr ID of this form
	*/
	@Override
	public void setSubmitAttrId(java.lang.String submitAttrId) {
		_form.setSubmitAttrId(submitAttrId);
	}

	/**
	* Returns the submit attr class of this form.
	*
	* @return the submit attr class of this form
	*/
	@Override
	public java.lang.String getSubmitAttrClass() {
		return _form.getSubmitAttrClass();
	}

	/**
	* Sets the submit attr class of this form.
	*
	* @param submitAttrClass the submit attr class of this form
	*/
	@Override
	public void setSubmitAttrClass(java.lang.String submitAttrClass) {
		_form.setSubmitAttrClass(submitAttrClass);
	}

	@Override
	public boolean isNew() {
		return _form.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_form.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _form.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_form.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _form.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _form.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_form.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _form.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_form.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_form.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_form.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _form.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _form.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_form.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_form.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new FormWrapper((Form)_form.clone());
	}

	@Override
	public int compareTo(Form form) {
		return _form.compareTo(form);
	}

	@Override
	public int hashCode() {
		return _form.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<Form> toCacheModel() {
		return _form.toCacheModel();
	}

	@Override
	public Form toEscapedModel() {
		return new FormWrapper(_form.toEscapedModel());
	}

	@Override
	public Form toUnescapedModel() {
		return new FormWrapper(_form.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _form.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _form.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_form.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FormWrapper)) {
			return false;
		}

		FormWrapper formWrapper = (FormWrapper)obj;

		if (Validator.equals(_form, formWrapper._form)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Form getWrappedForm() {
		return _form;
	}

	@Override
	public Form getWrappedModel() {
		return _form;
	}

	@Override
	public void resetOriginalValues() {
		_form.resetOriginalValues();
	}

	private Form _form;
}