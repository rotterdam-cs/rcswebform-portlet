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

package com.rcs.dbservice.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.rcs.dbservice.service.http.WebformColumnServiceSoap}.
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see com.rcs.dbservice.service.http.WebformColumnServiceSoap
 * @generated
 */
public class WebformColumnSoap implements Serializable {
	public static WebformColumnSoap toSoapModel(WebformColumn model) {
		WebformColumnSoap soapModel = new WebformColumnSoap();

		soapModel.setWebformColumnId(model.getWebformColumnId());
		soapModel.setWebformTableId(model.getWebformTableId());
		soapModel.setName(model.getName());
		soapModel.setType(model.getType());
		soapModel.setInputType(model.getInputType());
		soapModel.setIsRequired(model.getIsRequired());
		soapModel.setPlaceHolder(model.getPlaceHolder());
		soapModel.setValidation(model.getValidation());
		soapModel.setCustomValidation(model.getCustomValidation());
		soapModel.setLabelClass(model.getLabelClass());
		soapModel.setInputClass(model.getInputClass());
		soapModel.setMaxLength(model.getMaxLength());

		return soapModel;
	}

	public static WebformColumnSoap[] toSoapModels(WebformColumn[] models) {
		WebformColumnSoap[] soapModels = new WebformColumnSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WebformColumnSoap[][] toSoapModels(WebformColumn[][] models) {
		WebformColumnSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WebformColumnSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WebformColumnSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WebformColumnSoap[] toSoapModels(List<WebformColumn> models) {
		List<WebformColumnSoap> soapModels = new ArrayList<WebformColumnSoap>(models.size());

		for (WebformColumn model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WebformColumnSoap[soapModels.size()]);
	}

	public WebformColumnSoap() {
	}

	public long getPrimaryKey() {
		return _webformColumnId;
	}

	public void setPrimaryKey(long pk) {
		setWebformColumnId(pk);
	}

	public long getWebformColumnId() {
		return _webformColumnId;
	}

	public void setWebformColumnId(long webformColumnId) {
		_webformColumnId = webformColumnId;
	}

	public long getWebformTableId() {
		return _webformTableId;
	}

	public void setWebformTableId(long webformTableId) {
		_webformTableId = webformTableId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public int getInputType() {
		return _inputType;
	}

	public void setInputType(int inputType) {
		_inputType = inputType;
	}

	public boolean getIsRequired() {
		return _isRequired;
	}

	public boolean isIsRequired() {
		return _isRequired;
	}

	public void setIsRequired(boolean isRequired) {
		_isRequired = isRequired;
	}

	public String getPlaceHolder() {
		return _placeHolder;
	}

	public void setPlaceHolder(String placeHolder) {
		_placeHolder = placeHolder;
	}

	public String getValidation() {
		return _validation;
	}

	public void setValidation(String validation) {
		_validation = validation;
	}

	public String getCustomValidation() {
		return _customValidation;
	}

	public void setCustomValidation(String customValidation) {
		_customValidation = customValidation;
	}

	public String getLabelClass() {
		return _labelClass;
	}

	public void setLabelClass(String labelClass) {
		_labelClass = labelClass;
	}

	public String getInputClass() {
		return _inputClass;
	}

	public void setInputClass(String inputClass) {
		_inputClass = inputClass;
	}

	public String getMaxLength() {
		return _maxLength;
	}

	public void setMaxLength(String maxLength) {
		_maxLength = maxLength;
	}

	private long _webformColumnId;
	private long _webformTableId;
	private String _name;
	private int _type;
	private int _inputType;
	private boolean _isRequired;
	private String _placeHolder;
	private String _validation;
	private String _customValidation;
	private String _labelClass;
	private String _inputClass;
	private String _maxLength;
}