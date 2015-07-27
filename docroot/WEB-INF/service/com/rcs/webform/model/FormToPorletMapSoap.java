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
public class FormToPorletMapSoap implements Serializable {
	public static FormToPorletMapSoap toSoapModel(FormToPorletMap model) {
		FormToPorletMapSoap soapModel = new FormToPorletMapSoap();

		soapModel.setFormToPorletMapId(model.getFormToPorletMapId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFormId(model.getFormId());
		soapModel.setPortletId(model.getPortletId());

		return soapModel;
	}

	public static FormToPorletMapSoap[] toSoapModels(FormToPorletMap[] models) {
		FormToPorletMapSoap[] soapModels = new FormToPorletMapSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FormToPorletMapSoap[][] toSoapModels(
		FormToPorletMap[][] models) {
		FormToPorletMapSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FormToPorletMapSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FormToPorletMapSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FormToPorletMapSoap[] toSoapModels(
		List<FormToPorletMap> models) {
		List<FormToPorletMapSoap> soapModels = new ArrayList<FormToPorletMapSoap>(models.size());

		for (FormToPorletMap model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FormToPorletMapSoap[soapModels.size()]);
	}

	public FormToPorletMapSoap() {
	}

	public long getPrimaryKey() {
		return _formToPorletMapId;
	}

	public void setPrimaryKey(long pk) {
		setFormToPorletMapId(pk);
	}

	public long getFormToPorletMapId() {
		return _formToPorletMapId;
	}

	public void setFormToPorletMapId(long formToPorletMapId) {
		_formToPorletMapId = formToPorletMapId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getFormId() {
		return _formId;
	}

	public void setFormId(long formId) {
		_formId = formId;
	}

	public String getPortletId() {
		return _portletId;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	private long _formToPorletMapId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _formId;
	private String _portletId;
}