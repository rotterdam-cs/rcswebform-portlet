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
import com.rcs.webform.service.FormItemOptionLocalServiceUtil;

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
public class FormItemOptionClp extends BaseModelImpl<FormItemOption>
	implements FormItemOption {
	public FormItemOptionClp() {
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
	public long getPrimaryKey() {
		return _formitemoptionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFormitemoptionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _formitemoptionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getFormitemoptionId() {
		return _formitemoptionId;
	}

	@Override
	public void setFormitemoptionId(long formitemoptionId) {
		_formitemoptionId = formitemoptionId;

		if (_formItemOptionRemoteModel != null) {
			try {
				Class<?> clazz = _formItemOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setFormitemoptionId",
						long.class);

				method.invoke(_formItemOptionRemoteModel, formitemoptionId);
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

		if (_formItemOptionRemoteModel != null) {
			try {
				Class<?> clazz = _formItemOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreationDate", Date.class);

				method.invoke(_formItemOptionRemoteModel, creationDate);
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

		if (_formItemOptionRemoteModel != null) {
			try {
				Class<?> clazz = _formItemOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setModificationDate",
						Date.class);

				method.invoke(_formItemOptionRemoteModel, modificationDate);
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

		if (_formItemOptionRemoteModel != null) {
			try {
				Class<?> clazz = _formItemOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setModificationUser",
						String.class);

				method.invoke(_formItemOptionRemoteModel, modificationUser);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFormItemId() {
		return _formItemId;
	}

	@Override
	public void setFormItemId(long formItemId) {
		_formItemId = formItemId;

		if (_formItemOptionRemoteModel != null) {
			try {
				Class<?> clazz = _formItemOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setFormItemId", long.class);

				method.invoke(_formItemOptionRemoteModel, formItemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOptionKey() {
		return _optionKey;
	}

	@Override
	public String getOptionKey(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getOptionKey(languageId);
	}

	@Override
	public String getOptionKey(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getOptionKey(languageId, useDefault);
	}

	@Override
	public String getOptionKey(String languageId) {
		return LocalizationUtil.getLocalization(getOptionKey(), languageId);
	}

	@Override
	public String getOptionKey(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getOptionKey(), languageId,
			useDefault);
	}

	@Override
	public String getOptionKeyCurrentLanguageId() {
		return _optionKeyCurrentLanguageId;
	}

	@Override
	public String getOptionKeyCurrentValue() {
		Locale locale = getLocale(_optionKeyCurrentLanguageId);

		return getOptionKey(locale);
	}

	@Override
	public Map<Locale, String> getOptionKeyMap() {
		return LocalizationUtil.getLocalizationMap(getOptionKey());
	}

	@Override
	public void setOptionKey(String optionKey) {
		_optionKey = optionKey;

		if (_formItemOptionRemoteModel != null) {
			try {
				Class<?> clazz = _formItemOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setOptionKey", String.class);

				method.invoke(_formItemOptionRemoteModel, optionKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setOptionKey(String optionKey, Locale locale) {
		setOptionKey(optionKey, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setOptionKey(String optionKey, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(optionKey)) {
			setOptionKey(LocalizationUtil.updateLocalization(getOptionKey(),
					"OptionKey", optionKey, languageId, defaultLanguageId));
		}
		else {
			setOptionKey(LocalizationUtil.removeLocalization(getOptionKey(),
					"OptionKey", languageId));
		}
	}

	@Override
	public void setOptionKeyCurrentLanguageId(String languageId) {
		_optionKeyCurrentLanguageId = languageId;
	}

	@Override
	public void setOptionKeyMap(Map<Locale, String> optionKeyMap) {
		setOptionKeyMap(optionKeyMap, LocaleUtil.getDefault());
	}

	@Override
	public void setOptionKeyMap(Map<Locale, String> optionKeyMap,
		Locale defaultLocale) {
		if (optionKeyMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setOptionKey(LocalizationUtil.updateLocalization(optionKeyMap,
					getOptionKey(), "OptionKey",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getOptionValue() {
		return _optionValue;
	}

	@Override
	public String getOptionValue(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getOptionValue(languageId);
	}

	@Override
	public String getOptionValue(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getOptionValue(languageId, useDefault);
	}

	@Override
	public String getOptionValue(String languageId) {
		return LocalizationUtil.getLocalization(getOptionValue(), languageId);
	}

	@Override
	public String getOptionValue(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getOptionValue(), languageId,
			useDefault);
	}

	@Override
	public String getOptionValueCurrentLanguageId() {
		return _optionValueCurrentLanguageId;
	}

	@Override
	public String getOptionValueCurrentValue() {
		Locale locale = getLocale(_optionValueCurrentLanguageId);

		return getOptionValue(locale);
	}

	@Override
	public Map<Locale, String> getOptionValueMap() {
		return LocalizationUtil.getLocalizationMap(getOptionValue());
	}

	@Override
	public void setOptionValue(String optionValue) {
		_optionValue = optionValue;

		if (_formItemOptionRemoteModel != null) {
			try {
				Class<?> clazz = _formItemOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setOptionValue", String.class);

				method.invoke(_formItemOptionRemoteModel, optionValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setOptionValue(String optionValue, Locale locale) {
		setOptionValue(optionValue, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setOptionValue(String optionValue, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(optionValue)) {
			setOptionValue(LocalizationUtil.updateLocalization(
					getOptionValue(), "OptionValue", optionValue, languageId,
					defaultLanguageId));
		}
		else {
			setOptionValue(LocalizationUtil.removeLocalization(
					getOptionValue(), "OptionValue", languageId));
		}
	}

	@Override
	public void setOptionValueCurrentLanguageId(String languageId) {
		_optionValueCurrentLanguageId = languageId;
	}

	@Override
	public void setOptionValueMap(Map<Locale, String> optionValueMap) {
		setOptionValueMap(optionValueMap, LocaleUtil.getDefault());
	}

	@Override
	public void setOptionValueMap(Map<Locale, String> optionValueMap,
		Locale defaultLocale) {
		if (optionValueMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setOptionValue(LocalizationUtil.updateLocalization(optionValueMap,
					getOptionValue(), "OptionValue",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	public BaseModel<?> getFormItemOptionRemoteModel() {
		return _formItemOptionRemoteModel;
	}

	public void setFormItemOptionRemoteModel(
		BaseModel<?> formItemOptionRemoteModel) {
		_formItemOptionRemoteModel = formItemOptionRemoteModel;
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

		Class<?> remoteModelClass = _formItemOptionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_formItemOptionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FormItemOptionLocalServiceUtil.addFormItemOption(this);
		}
		else {
			FormItemOptionLocalServiceUtil.updateFormItemOption(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> optionKeyMap = getOptionKeyMap();

		for (Map.Entry<Locale, String> entry : optionKeyMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> optionValueMap = getOptionValueMap();

		for (Map.Entry<Locale, String> entry : optionValueMap.entrySet()) {
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
		String xml = getOptionKey();

		if (xml == null) {
			return StringPool.BLANK;
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
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

		String optionKey = getOptionKey(defaultLocale);

		if (Validator.isNull(optionKey)) {
			setOptionKey(getOptionKey(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setOptionKey(getOptionKey(defaultLocale), defaultLocale,
				defaultLocale);
		}

		String optionValue = getOptionValue(defaultLocale);

		if (Validator.isNull(optionValue)) {
			setOptionValue(getOptionValue(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setOptionValue(getOptionValue(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public FormItemOption toEscapedModel() {
		return (FormItemOption)ProxyUtil.newProxyInstance(FormItemOption.class.getClassLoader(),
			new Class[] { FormItemOption.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FormItemOptionClp clone = new FormItemOptionClp();

		clone.setFormitemoptionId(getFormitemoptionId());
		clone.setCreationDate(getCreationDate());
		clone.setModificationDate(getModificationDate());
		clone.setModificationUser(getModificationUser());
		clone.setFormItemId(getFormItemId());
		clone.setOptionKey(getOptionKey());
		clone.setOptionValue(getOptionValue());

		return clone;
	}

	@Override
	public int compareTo(FormItemOption formItemOption) {
		long primaryKey = formItemOption.getPrimaryKey();

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

		if (!(obj instanceof FormItemOptionClp)) {
			return false;
		}

		FormItemOptionClp formItemOption = (FormItemOptionClp)obj;

		long primaryKey = formItemOption.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{formitemoptionId=");
		sb.append(getFormitemoptionId());
		sb.append(", creationDate=");
		sb.append(getCreationDate());
		sb.append(", modificationDate=");
		sb.append(getModificationDate());
		sb.append(", modificationUser=");
		sb.append(getModificationUser());
		sb.append(", formItemId=");
		sb.append(getFormItemId());
		sb.append(", optionKey=");
		sb.append(getOptionKey());
		sb.append(", optionValue=");
		sb.append(getOptionValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.rcs.webform.model.FormItemOption");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>formitemoptionId</column-name><column-value><![CDATA[");
		sb.append(getFormitemoptionId());
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
			"<column><column-name>formItemId</column-name><column-value><![CDATA[");
		sb.append(getFormItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>optionKey</column-name><column-value><![CDATA[");
		sb.append(getOptionKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>optionValue</column-name><column-value><![CDATA[");
		sb.append(getOptionValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _formitemoptionId;
	private Date _creationDate;
	private Date _modificationDate;
	private String _modificationUser;
	private long _formItemId;
	private String _optionKey;
	private String _optionKeyCurrentLanguageId;
	private String _optionValue;
	private String _optionValueCurrentLanguageId;
	private BaseModel<?> _formItemOptionRemoteModel;
	private Class<?> _clpSerializerClass = com.rcs.webform.service.ClpSerializer.class;
}