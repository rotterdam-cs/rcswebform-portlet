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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.rcs.webform.service.ClpSerializer;
import com.rcs.webform.service.FormItemLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

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
	public String getOptions() {
		return _options;
	}

	@Override
	public void setOptions(String options) {
		_options = options;

		if (_formItemRemoteModel != null) {
			try {
				Class<?> clazz = _formItemRemoteModel.getClass();

				Method method = clazz.getMethod("setOptions", String.class);

				method.invoke(_formItemRemoteModel, options);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
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
	public String getErrorValidationMessage() {
		return _errorValidationMessage;
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
	public String getErrorMandatoryMessage() {
		return _errorMandatoryMessage;
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
	public String getHintMessage() {
		return _hintMessage;
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
	public FormItem toEscapedModel() {
		return (FormItem)ProxyUtil.newProxyInstance(FormItem.class.getClassLoader(),
			new Class[] { FormItem.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FormItemClp clone = new FormItemClp();

		clone.setFormItemId(getFormItemId());
		clone.setFormId(getFormId());
		clone.setFormItemAttrId(getFormItemAttrId());
		clone.setFormItemAttrClass(getFormItemAttrClass());
		clone.setLabel(getLabel());
		clone.setLabelAttrId(getLabelAttrId());
		clone.setLabelAttrClass(getLabelAttrClass());
		clone.setInputAttrId(getInputAttrId());
		clone.setInputAttrClass(getInputAttrClass());
		clone.setType(getType());
		clone.setOptions(getOptions());
		clone.setMandatory(getMandatory());
		clone.setDefaultValue(getDefaultValue());
		clone.setOrder(getOrder());
		clone.setValidationType(getValidationType());
		clone.setValidationRegexValue(getValidationRegexValue());
		clone.setErrorValidationMessage(getErrorValidationMessage());
		clone.setErrorMandatoryMessage(getErrorMandatoryMessage());
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

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{formItemId=");
		sb.append(getFormItemId());
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
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.rcs.webform.model.FormItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>formItemId</column-name><column-value><![CDATA[");
		sb.append(getFormItemId());
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

	private long _formItemId;
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
	private BaseModel<?> _formItemRemoteModel;
	private Class<?> _clpSerializerClass = com.rcs.webform.service.ClpSerializer.class;
}