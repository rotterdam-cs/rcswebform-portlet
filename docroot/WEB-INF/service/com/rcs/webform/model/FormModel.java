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
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the Form service. Represents a row in the &quot;rcswebform_Form&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rcs.webform.model.impl.FormModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rcs.webform.model.impl.FormImpl}.
 * </p>
 *
 * @author ryusuf
 * @see Form
 * @see com.rcs.webform.model.impl.FormImpl
 * @see com.rcs.webform.model.impl.FormModelImpl
 * @generated
 */
public interface FormModel extends BaseModel<Form> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a form model instance should use the {@link Form} interface instead.
	 */

	/**
	 * Returns the primary key of this form.
	 *
	 * @return the primary key of this form
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this form.
	 *
	 * @param primaryKey the primary key of this form
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the form ID of this form.
	 *
	 * @return the form ID of this form
	 */
	public long getFormId();

	/**
	 * Sets the form ID of this form.
	 *
	 * @param formId the form ID of this form
	 */
	public void setFormId(long formId);

	/**
	 * Returns the active of this form.
	 *
	 * @return the active of this form
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this form is active.
	 *
	 * @return <code>true</code> if this form is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this form is active.
	 *
	 * @param active the active of this form
	 */
	public void setActive(boolean active);

	/**
	 * Returns the creation date of this form.
	 *
	 * @return the creation date of this form
	 */
	public Date getCreationDate();

	/**
	 * Sets the creation date of this form.
	 *
	 * @param creationDate the creation date of this form
	 */
	public void setCreationDate(Date creationDate);

	/**
	 * Returns the modification date of this form.
	 *
	 * @return the modification date of this form
	 */
	public Date getModificationDate();

	/**
	 * Sets the modification date of this form.
	 *
	 * @param modificationDate the modification date of this form
	 */
	public void setModificationDate(Date modificationDate);

	/**
	 * Returns the modification user of this form.
	 *
	 * @return the modification user of this form
	 */
	@AutoEscape
	public String getModificationUser();

	/**
	 * Sets the modification user of this form.
	 *
	 * @param modificationUser the modification user of this form
	 */
	public void setModificationUser(String modificationUser);

	/**
	 * Returns the group ID of this form.
	 *
	 * @return the group ID of this form
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this form.
	 *
	 * @param groupId the group ID of this form
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this form.
	 *
	 * @return the company ID of this form
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this form.
	 *
	 * @param companyId the company ID of this form
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this form.
	 *
	 * @return the user ID of this form
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this form.
	 *
	 * @param userId the user ID of this form
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this form.
	 *
	 * @return the user uuid of this form
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this form.
	 *
	 * @param userUuid the user uuid of this form
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this form.
	 *
	 * @return the user name of this form
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this form.
	 *
	 * @param userName the user name of this form
	 */
	public void setUserName(String userName);

	/**
	 * Returns the form attr ID of this form.
	 *
	 * @return the form attr ID of this form
	 */
	@AutoEscape
	public String getFormAttrId();

	/**
	 * Sets the form attr ID of this form.
	 *
	 * @param formAttrId the form attr ID of this form
	 */
	public void setFormAttrId(String formAttrId);

	/**
	 * Returns the form attr class of this form.
	 *
	 * @return the form attr class of this form
	 */
	@AutoEscape
	public String getFormAttrClass();

	/**
	 * Sets the form attr class of this form.
	 *
	 * @param formAttrClass the form attr class of this form
	 */
	public void setFormAttrClass(String formAttrClass);

	/**
	 * Returns the title of this form.
	 *
	 * @return the title of this form
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this form in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this form
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this form in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this form. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this form in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this form
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this form in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this form
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this form.
	 *
	 * @return the locales and localized titles of this form
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this form.
	 *
	 * @param title the title of this form
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this form in the language.
	 *
	 * @param title the localized title of this form
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this form in the language, and sets the default locale.
	 *
	 * @param title the localized title of this form
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this form from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this form
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this form from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this form
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the desc of this form.
	 *
	 * @return the desc of this form
	 */
	public String getDesc();

	/**
	 * Returns the localized desc of this form in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized desc of this form
	 */
	@AutoEscape
	public String getDesc(Locale locale);

	/**
	 * Returns the localized desc of this form in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized desc of this form. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDesc(Locale locale, boolean useDefault);

	/**
	 * Returns the localized desc of this form in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized desc of this form
	 */
	@AutoEscape
	public String getDesc(String languageId);

	/**
	 * Returns the localized desc of this form in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized desc of this form
	 */
	@AutoEscape
	public String getDesc(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescCurrentLanguageId();

	@AutoEscape
	public String getDescCurrentValue();

	/**
	 * Returns a map of the locales and localized descs of this form.
	 *
	 * @return the locales and localized descs of this form
	 */
	public Map<Locale, String> getDescMap();

	/**
	 * Sets the desc of this form.
	 *
	 * @param desc the desc of this form
	 */
	public void setDesc(String desc);

	/**
	 * Sets the localized desc of this form in the language.
	 *
	 * @param desc the localized desc of this form
	 * @param locale the locale of the language
	 */
	public void setDesc(String desc, Locale locale);

	/**
	 * Sets the localized desc of this form in the language, and sets the default locale.
	 *
	 * @param desc the localized desc of this form
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDesc(String desc, Locale locale, Locale defaultLocale);

	public void setDescCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descs of this form from the map of locales and localized descs.
	 *
	 * @param descMap the locales and localized descs of this form
	 */
	public void setDescMap(Map<Locale, String> descMap);

	/**
	 * Sets the localized descs of this form from the map of locales and localized descs, and sets the default locale.
	 *
	 * @param descMap the locales and localized descs of this form
	 * @param defaultLocale the default locale
	 */
	public void setDescMap(Map<Locale, String> descMap, Locale defaultLocale);

	/**
	 * Returns the use captcha of this form.
	 *
	 * @return the use captcha of this form
	 */
	public boolean getUseCaptcha();

	/**
	 * Returns <code>true</code> if this form is use captcha.
	 *
	 * @return <code>true</code> if this form is use captcha; <code>false</code> otherwise
	 */
	public boolean isUseCaptcha();

	/**
	 * Sets whether this form is use captcha.
	 *
	 * @param useCaptcha the use captcha of this form
	 */
	public void setUseCaptcha(boolean useCaptcha);

	/**
	 * Returns the success message of this form.
	 *
	 * @return the success message of this form
	 */
	public String getSuccessMessage();

	/**
	 * Returns the localized success message of this form in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized success message of this form
	 */
	@AutoEscape
	public String getSuccessMessage(Locale locale);

	/**
	 * Returns the localized success message of this form in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized success message of this form. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getSuccessMessage(Locale locale, boolean useDefault);

	/**
	 * Returns the localized success message of this form in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized success message of this form
	 */
	@AutoEscape
	public String getSuccessMessage(String languageId);

	/**
	 * Returns the localized success message of this form in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized success message of this form
	 */
	@AutoEscape
	public String getSuccessMessage(String languageId, boolean useDefault);

	@AutoEscape
	public String getSuccessMessageCurrentLanguageId();

	@AutoEscape
	public String getSuccessMessageCurrentValue();

	/**
	 * Returns a map of the locales and localized success messages of this form.
	 *
	 * @return the locales and localized success messages of this form
	 */
	public Map<Locale, String> getSuccessMessageMap();

	/**
	 * Sets the success message of this form.
	 *
	 * @param successMessage the success message of this form
	 */
	public void setSuccessMessage(String successMessage);

	/**
	 * Sets the localized success message of this form in the language.
	 *
	 * @param successMessage the localized success message of this form
	 * @param locale the locale of the language
	 */
	public void setSuccessMessage(String successMessage, Locale locale);

	/**
	 * Sets the localized success message of this form in the language, and sets the default locale.
	 *
	 * @param successMessage the localized success message of this form
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setSuccessMessage(String successMessage, Locale locale,
		Locale defaultLocale);

	public void setSuccessMessageCurrentLanguageId(String languageId);

	/**
	 * Sets the localized success messages of this form from the map of locales and localized success messages.
	 *
	 * @param successMessageMap the locales and localized success messages of this form
	 */
	public void setSuccessMessageMap(Map<Locale, String> successMessageMap);

	/**
	 * Sets the localized success messages of this form from the map of locales and localized success messages, and sets the default locale.
	 *
	 * @param successMessageMap the locales and localized success messages of this form
	 * @param defaultLocale the default locale
	 */
	public void setSuccessMessageMap(Map<Locale, String> successMessageMap,
		Locale defaultLocale);

	/**
	 * Returns the success u r l of this form.
	 *
	 * @return the success u r l of this form
	 */
	@AutoEscape
	public String getSuccessURL();

	/**
	 * Sets the success u r l of this form.
	 *
	 * @param successURL the success u r l of this form
	 */
	public void setSuccessURL(String successURL);

	/**
	 * Returns the submit label of this form.
	 *
	 * @return the submit label of this form
	 */
	public String getSubmitLabel();

	/**
	 * Returns the localized submit label of this form in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized submit label of this form
	 */
	@AutoEscape
	public String getSubmitLabel(Locale locale);

	/**
	 * Returns the localized submit label of this form in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized submit label of this form. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getSubmitLabel(Locale locale, boolean useDefault);

	/**
	 * Returns the localized submit label of this form in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized submit label of this form
	 */
	@AutoEscape
	public String getSubmitLabel(String languageId);

	/**
	 * Returns the localized submit label of this form in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized submit label of this form
	 */
	@AutoEscape
	public String getSubmitLabel(String languageId, boolean useDefault);

	@AutoEscape
	public String getSubmitLabelCurrentLanguageId();

	@AutoEscape
	public String getSubmitLabelCurrentValue();

	/**
	 * Returns a map of the locales and localized submit labels of this form.
	 *
	 * @return the locales and localized submit labels of this form
	 */
	public Map<Locale, String> getSubmitLabelMap();

	/**
	 * Sets the submit label of this form.
	 *
	 * @param submitLabel the submit label of this form
	 */
	public void setSubmitLabel(String submitLabel);

	/**
	 * Sets the localized submit label of this form in the language.
	 *
	 * @param submitLabel the localized submit label of this form
	 * @param locale the locale of the language
	 */
	public void setSubmitLabel(String submitLabel, Locale locale);

	/**
	 * Sets the localized submit label of this form in the language, and sets the default locale.
	 *
	 * @param submitLabel the localized submit label of this form
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setSubmitLabel(String submitLabel, Locale locale,
		Locale defaultLocale);

	public void setSubmitLabelCurrentLanguageId(String languageId);

	/**
	 * Sets the localized submit labels of this form from the map of locales and localized submit labels.
	 *
	 * @param submitLabelMap the locales and localized submit labels of this form
	 */
	public void setSubmitLabelMap(Map<Locale, String> submitLabelMap);

	/**
	 * Sets the localized submit labels of this form from the map of locales and localized submit labels, and sets the default locale.
	 *
	 * @param submitLabelMap the locales and localized submit labels of this form
	 * @param defaultLocale the default locale
	 */
	public void setSubmitLabelMap(Map<Locale, String> submitLabelMap,
		Locale defaultLocale);

	/**
	 * Returns the submit attr ID of this form.
	 *
	 * @return the submit attr ID of this form
	 */
	@AutoEscape
	public String getSubmitAttrId();

	/**
	 * Sets the submit attr ID of this form.
	 *
	 * @param submitAttrId the submit attr ID of this form
	 */
	public void setSubmitAttrId(String submitAttrId);

	/**
	 * Returns the submit attr class of this form.
	 *
	 * @return the submit attr class of this form
	 */
	@AutoEscape
	public String getSubmitAttrClass();

	/**
	 * Sets the submit attr class of this form.
	 *
	 * @param submitAttrClass the submit attr class of this form
	 */
	public void setSubmitAttrClass(String submitAttrClass);

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
	public int compareTo(Form form);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Form> toCacheModel();

	@Override
	public Form toEscapedModel();

	@Override
	public Form toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}