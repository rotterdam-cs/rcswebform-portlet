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
public class FormItemOptionSoap implements Serializable {
	public static FormItemOptionSoap toSoapModel(FormItemOption model) {
		FormItemOptionSoap soapModel = new FormItemOptionSoap();

		soapModel.setFormItemOptionId(model.getFormItemOptionId());
		soapModel.setCreationDate(model.getCreationDate());
		soapModel.setModificationDate(model.getModificationDate());
		soapModel.setModificationUser(model.getModificationUser());
		soapModel.setFormItemId(model.getFormItemId());
		soapModel.setOptionKey(model.getOptionKey());
		soapModel.setOptionValue(model.getOptionValue());

		return soapModel;
	}

	public static FormItemOptionSoap[] toSoapModels(FormItemOption[] models) {
		FormItemOptionSoap[] soapModels = new FormItemOptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FormItemOptionSoap[][] toSoapModels(FormItemOption[][] models) {
		FormItemOptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FormItemOptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FormItemOptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FormItemOptionSoap[] toSoapModels(List<FormItemOption> models) {
		List<FormItemOptionSoap> soapModels = new ArrayList<FormItemOptionSoap>(models.size());

		for (FormItemOption model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FormItemOptionSoap[soapModels.size()]);
	}

	public FormItemOptionSoap() {
	}

	public long getPrimaryKey() {
		return _formItemOptionId;
	}

	public void setPrimaryKey(long pk) {
		setFormItemOptionId(pk);
	}

	public long getFormItemOptionId() {
		return _formItemOptionId;
	}

	public void setFormItemOptionId(long formItemOptionId) {
		_formItemOptionId = formItemOptionId;
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

	public long getFormItemId() {
		return _formItemId;
	}

	public void setFormItemId(long formItemId) {
		_formItemId = formItemId;
	}

	public String getOptionKey() {
		return _optionKey;
	}

	public void setOptionKey(String optionKey) {
		_optionKey = optionKey;
	}

	public String getOptionValue() {
		return _optionValue;
	}

	public void setOptionValue(String optionValue) {
		_optionValue = optionValue;
	}

	private long _formItemOptionId;
	private Date _creationDate;
	private Date _modificationDate;
	private String _modificationUser;
	private long _formItemId;
	private String _optionKey;
	private String _optionValue;
}