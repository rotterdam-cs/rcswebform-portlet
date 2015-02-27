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
 * This class is used by SOAP remote services, specifically {@link com.rcs.dbservice.service.http.WebformValueServiceSoap}.
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see com.rcs.dbservice.service.http.WebformValueServiceSoap
 * @generated
 */
public class WebformValueSoap implements Serializable {
	public static WebformValueSoap toSoapModel(WebformValue model) {
		WebformValueSoap soapModel = new WebformValueSoap();

		soapModel.setWebformValueId(model.getWebformValueId());
		soapModel.setWebformTableId(model.getWebformTableId());
		soapModel.setWebformColumnId(model.getWebformColumnId());
		soapModel.setWebformRowId(model.getWebformRowId());
		soapModel.setData(model.getData());

		return soapModel;
	}

	public static WebformValueSoap[] toSoapModels(WebformValue[] models) {
		WebformValueSoap[] soapModels = new WebformValueSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WebformValueSoap[][] toSoapModels(WebformValue[][] models) {
		WebformValueSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WebformValueSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WebformValueSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WebformValueSoap[] toSoapModels(List<WebformValue> models) {
		List<WebformValueSoap> soapModels = new ArrayList<WebformValueSoap>(models.size());

		for (WebformValue model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WebformValueSoap[soapModels.size()]);
	}

	public WebformValueSoap() {
	}

	public long getPrimaryKey() {
		return _webformValueId;
	}

	public void setPrimaryKey(long pk) {
		setWebformValueId(pk);
	}

	public long getWebformValueId() {
		return _webformValueId;
	}

	public void setWebformValueId(long webformValueId) {
		_webformValueId = webformValueId;
	}

	public long getWebformTableId() {
		return _webformTableId;
	}

	public void setWebformTableId(long webformTableId) {
		_webformTableId = webformTableId;
	}

	public long getWebformColumnId() {
		return _webformColumnId;
	}

	public void setWebformColumnId(long webformColumnId) {
		_webformColumnId = webformColumnId;
	}

	public long getWebformRowId() {
		return _webformRowId;
	}

	public void setWebformRowId(long webformRowId) {
		_webformRowId = webformRowId;
	}

	public String getData() {
		return _data;
	}

	public void setData(String data) {
		_data = data;
	}

	private long _webformValueId;
	private long _webformTableId;
	private long _webformColumnId;
	private long _webformRowId;
	private String _data;
}