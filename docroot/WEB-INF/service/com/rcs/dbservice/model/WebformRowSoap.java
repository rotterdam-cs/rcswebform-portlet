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

package com.rcs.dbService.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.rcs.dbService.service.http.WebformRowServiceSoap}.
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see com.rcs.dbService.service.http.WebformRowServiceSoap
 * @generated
 */
public class WebformRowSoap implements Serializable {
	public static WebformRowSoap toSoapModel(WebformRow model) {
		WebformRowSoap soapModel = new WebformRowSoap();

		soapModel.setWebformRowId(model.getWebformRowId());
		soapModel.setWebformTableId(model.getWebformTableId());
		soapModel.setUpdateDate(model.getUpdateDate());

		return soapModel;
	}

	public static WebformRowSoap[] toSoapModels(WebformRow[] models) {
		WebformRowSoap[] soapModels = new WebformRowSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WebformRowSoap[][] toSoapModels(WebformRow[][] models) {
		WebformRowSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WebformRowSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WebformRowSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WebformRowSoap[] toSoapModels(List<WebformRow> models) {
		List<WebformRowSoap> soapModels = new ArrayList<WebformRowSoap>(models.size());

		for (WebformRow model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WebformRowSoap[soapModels.size()]);
	}

	public WebformRowSoap() {
	}

	public long getPrimaryKey() {
		return _webformRowId;
	}

	public void setPrimaryKey(long pk) {
		setWebformRowId(pk);
	}

	public long getWebformRowId() {
		return _webformRowId;
	}

	public void setWebformRowId(long webformRowId) {
		_webformRowId = webformRowId;
	}

	public long getWebformTableId() {
		return _webformTableId;
	}

	public void setWebformTableId(long webformTableId) {
		_webformTableId = webformTableId;
	}

	public Date getUpdateDate() {
		return _updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		_updateDate = updateDate;
	}

	private long _webformRowId;
	private long _webformTableId;
	private Date _updateDate;
}