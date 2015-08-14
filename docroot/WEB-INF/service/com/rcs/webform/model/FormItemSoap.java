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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author ryusuf
 * @generated
 */
public class FormItemSoap implements Serializable {
	public static FormItemSoap toSoapModel(FormItem model) {
		FormItemSoap soapModel = new FormItemSoap();

		soapModel.setFormItemId(model.getFormItemId());
		soapModel.setActive(model.getActive());
		soapModel.setCreationDate(model.getCreationDate());
		soapModel.setModificationDate(model.getModificationDate());
		soapModel.setModificationUser(model.getModificationUser());
		soapModel.setFormId(model.getFormId());
		soapModel.setFormItemAttrId(model.getFormItemAttrId());
		soapModel.setFormItemAttrClass(model.getFormItemAttrClass());
		soapModel.setLabel(model.getLabel());
		soapModel.setLabelAttrId(model.getLabelAttrId());
		soapModel.setLabelAttrClass(model.getLabelAttrClass());
		soapModel.setInputAttrId(model.getInputAttrId());
		soapModel.setInputAttrClass(model.getInputAttrClass());
		soapModel.setType(model.getType());
		soapModel.setMandatory(model.getMandatory());
		soapModel.setDefaultValue(model.getDefaultValue());
		soapModel.setOrder(model.getOrder());
		soapModel.setValidationType(model.getValidationType());
		soapModel.setValidationRegexValue(model.getValidationRegexValue());
		soapModel.setMinLength(model.getMinLength());
		soapModel.setMaxLength(model.getMaxLength());
		soapModel.setErrorValidationMessage(model.getErrorValidationMessage());
		soapModel.setErrorMandatoryMessage(model.getErrorMandatoryMessage());
		soapModel.setErrorLengthMessage(model.getErrorLengthMessage());
		soapModel.setHintMessage(model.getHintMessage());

		return soapModel;
	}

	public static FormItemSoap[] toSoapModels(FormItem[] models) {
		FormItemSoap[] soapModels = new FormItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FormItemSoap[][] toSoapModels(FormItem[][] models) {
		FormItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FormItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FormItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FormItemSoap[] toSoapModels(List<FormItem> models) {
		List<FormItemSoap> soapModels = new ArrayList<FormItemSoap>(models.size());

		for (FormItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FormItemSoap[soapModels.size()]);
	}

	public FormItemSoap() {
	}

	public long getPrimaryKey() {
		return _formItemId;
	}

	public void setPrimaryKey(long pk) {
		setFormItemId(pk);
	}

	public long getFormItemId() {
		return _formItemId;
	}

	public void setFormItemId(long formItemId) {
		_formItemId = formItemId;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public Date getCreationDate() {
		return _creationDate;
	}

	public void setCreationDate(Date creationDate) {
		_creationDate = creationDate;
	}

	public Date getModificationDate() {
		return _modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		_modificationDate = modificationDate;
	}

	public String getModificationUser() {
		return _modificationUser;
	}

	public void setModificationUser(String modificationUser) {
		_modificationUser = modificationUser;
	}

	public long getFormId() {
		return _formId;
	}

	public void setFormId(long formId) {
		_formId = formId;
	}

	public String getFormItemAttrId() {
		return _formItemAttrId;
	}

	public void setFormItemAttrId(String formItemAttrId) {
		_formItemAttrId = formItemAttrId;
	}

	public String getFormItemAttrClass() {
		return _formItemAttrClass;
	}

	public void setFormItemAttrClass(String formItemAttrClass) {
		_formItemAttrClass = formItemAttrClass;
	}

	public String getLabel() {
		return _label;
	}

	public void setLabel(String label) {
		_label = label;
	}

	public String getLabelAttrId() {
		return _labelAttrId;
	}

	public void setLabelAttrId(String labelAttrId) {
		_labelAttrId = labelAttrId;
	}

	public String getLabelAttrClass() {
		return _labelAttrClass;
	}

	public void setLabelAttrClass(String labelAttrClass) {
		_labelAttrClass = labelAttrClass;
	}

	public String getInputAttrId() {
		return _inputAttrId;
	}

	public void setInputAttrId(String inputAttrId) {
		_inputAttrId = inputAttrId;
	}

	public String getInputAttrClass() {
		return _inputAttrClass;
	}

	public void setInputAttrClass(String inputAttrClass) {
		_inputAttrClass = inputAttrClass;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public boolean getMandatory() {
		return _mandatory;
	}

	public boolean isMandatory() {
		return _mandatory;
	}

	public void setMandatory(boolean mandatory) {
		_mandatory = mandatory;
	}

	public String getDefaultValue() {
		return _defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		_defaultValue = defaultValue;
	}

	public int getOrder() {
		return _order;
	}

	public void setOrder(int order) {
		_order = order;
	}

	public String getValidationType() {
		return _validationType;
	}

	public void setValidationType(String validationType) {
		_validationType = validationType;
	}

	public String getValidationRegexValue() {
		return _validationRegexValue;
	}

	public void setValidationRegexValue(String validationRegexValue) {
		_validationRegexValue = validationRegexValue;
	}

	public int getMinLength() {
		return _minLength;
	}

	public void setMinLength(int minLength) {
		_minLength = minLength;
	}

	public int getMaxLength() {
		return _maxLength;
	}

	public void setMaxLength(int maxLength) {
		_maxLength = maxLength;
	}

	public String getErrorValidationMessage() {
		return _errorValidationMessage;
	}

	public void setErrorValidationMessage(String errorValidationMessage) {
		_errorValidationMessage = errorValidationMessage;
	}

	public String getErrorMandatoryMessage() {
		return _errorMandatoryMessage;
	}

	public void setErrorMandatoryMessage(String errorMandatoryMessage) {
		_errorMandatoryMessage = errorMandatoryMessage;
	}

	public String getErrorLengthMessage() {
		return _errorLengthMessage;
	}

	public void setErrorLengthMessage(String errorLengthMessage) {
		_errorLengthMessage = errorLengthMessage;
	}

	public String getHintMessage() {
		return _hintMessage;
	}

	public void setHintMessage(String hintMessage) {
		_hintMessage = hintMessage;
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
	private String _labelAttrId;
	private String _labelAttrClass;
	private String _inputAttrId;
	private String _inputAttrClass;
	private String _type;
	private boolean _mandatory;
	private String _defaultValue;
	private int _order;
	private String _validationType;
	private String _validationRegexValue;
	private int _minLength;
	private int _maxLength;
	private String _errorValidationMessage;
	private String _errorMandatoryMessage;
	private String _errorLengthMessage;
	private String _hintMessage;
}