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

import com.rcs.webform.service.persistence.SubmittedDataPK;

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
public class SubmittedDataSoap implements Serializable {
	public static SubmittedDataSoap toSoapModel(SubmittedData model) {
		SubmittedDataSoap soapModel = new SubmittedDataSoap();

		soapModel.setSubmittedDataId(model.getSubmittedDataId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setActive(model.getActive());
		soapModel.setCreationDate(model.getCreationDate());
		soapModel.setModificationDate(model.getModificationDate());
		soapModel.setModificationUser(model.getModificationUser());
		soapModel.setFormId(model.getFormId());
		soapModel.setPortletId(model.getPortletId());
		soapModel.setFormItemId(model.getFormItemId());
		soapModel.setUserInput(model.getUserInput());

		return soapModel;
	}

	public static SubmittedDataSoap[] toSoapModels(SubmittedData[] models) {
		SubmittedDataSoap[] soapModels = new SubmittedDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubmittedDataSoap[][] toSoapModels(SubmittedData[][] models) {
		SubmittedDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SubmittedDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubmittedDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubmittedDataSoap[] toSoapModels(List<SubmittedData> models) {
		List<SubmittedDataSoap> soapModels = new ArrayList<SubmittedDataSoap>(models.size());

		for (SubmittedData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubmittedDataSoap[soapModels.size()]);
	}

	public SubmittedDataSoap() {
	}

	public SubmittedDataPK getPrimaryKey() {
		return new SubmittedDataPK(_submittedDataId, _formId, _portletId,
			_formItemId);
	}

	public void setPrimaryKey(SubmittedDataPK pk) {
		setSubmittedDataId(pk.submittedDataId);
		setFormId(pk.formId);
		setPortletId(pk.portletId);
		setFormItemId(pk.formItemId);
	}

	public long getSubmittedDataId() {
		return _submittedDataId;
	}

	public void setSubmittedDataId(long submittedDataId) {
		_submittedDataId = submittedDataId;
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

	public String getPortletId() {
		return _portletId;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public long getFormItemId() {
		return _formItemId;
	}

	public void setFormItemId(long formItemId) {
		_formItemId = formItemId;
	}

	public String getUserInput() {
		return _userInput;
	}

	public void setUserInput(String userInput) {
		_userInput = userInput;
	}

	private long _submittedDataId;
	private long _groupId;
	private long _companyId;
	private boolean _active;
	private Date _creationDate;
	private Date _modificationDate;
	private String _modificationUser;
	private long _formId;
	private String _portletId;
	private long _formItemId;
	private String _userInput;
}