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
 * This class is used by SOAP remote services, specifically {@link com.rcs.dbservice.service.http.WebformTableServiceSoap}.
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see com.rcs.dbservice.service.http.WebformTableServiceSoap
 * @generated
 */
public class WebformTableSoap implements Serializable {
	public static WebformTableSoap toSoapModel(WebformTable model) {
		WebformTableSoap soapModel = new WebformTableSoap();

		soapModel.setWebformTableId(model.getWebformTableId());
		soapModel.setPortletId(model.getPortletId());
		soapModel.setWebformCounter(model.getWebformCounter());
		soapModel.setWebformName(model.getWebformName());

		return soapModel;
	}

	public static WebformTableSoap[] toSoapModels(WebformTable[] models) {
		WebformTableSoap[] soapModels = new WebformTableSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WebformTableSoap[][] toSoapModels(WebformTable[][] models) {
		WebformTableSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WebformTableSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WebformTableSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WebformTableSoap[] toSoapModels(List<WebformTable> models) {
		List<WebformTableSoap> soapModels = new ArrayList<WebformTableSoap>(models.size());

		for (WebformTable model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WebformTableSoap[soapModels.size()]);
	}

	public WebformTableSoap() {
	}

	public long getPrimaryKey() {
		return _webformTableId;
	}

	public void setPrimaryKey(long pk) {
		setWebformTableId(pk);
	}

	public long getWebformTableId() {
		return _webformTableId;
	}

	public void setWebformTableId(long webformTableId) {
		_webformTableId = webformTableId;
	}

	public String getPortletId() {
		return _portletId;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public String getWebformCounter() {
		return _webformCounter;
	}

	public void setWebformCounter(String webformCounter) {
		_webformCounter = webformCounter;
	}

	public String getWebformName() {
		return _webformName;
	}

	public void setWebformName(String webformName) {
		_webformName = webformName;
	}

	private long _webformTableId;
	private String _portletId;
	private String _webformCounter;
	private String _webformName;
}