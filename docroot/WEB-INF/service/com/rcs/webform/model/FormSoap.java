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
public class FormSoap implements Serializable {
	public static FormSoap toSoapModel(Form model) {
		FormSoap soapModel = new FormSoap();

		soapModel.setFormId(model.getFormId());
		soapModel.setActive(model.getActive());
		soapModel.setCreationDate(model.getCreationDate());
		soapModel.setModificationDate(model.getModificationDate());
		soapModel.setModificationUser(model.getModificationUser());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setFormAttrId(model.getFormAttrId());
		soapModel.setFormAttrClass(model.getFormAttrClass());
		soapModel.setTitle(model.getTitle());
		soapModel.setDesc(model.getDesc());
		soapModel.setUseCaptcha(model.getUseCaptcha());
		soapModel.setSuccessMessage(model.getSuccessMessage());
		soapModel.setSuccessURL(model.getSuccessURL());
		soapModel.setSubmitLabel(model.getSubmitLabel());
		soapModel.setSubmitAttrId(model.getSubmitAttrId());
		soapModel.setSubmitAttrClass(model.getSubmitAttrClass());

		return soapModel;
	}

	public static FormSoap[] toSoapModels(Form[] models) {
		FormSoap[] soapModels = new FormSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FormSoap[][] toSoapModels(Form[][] models) {
		FormSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FormSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FormSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FormSoap[] toSoapModels(List<Form> models) {
		List<FormSoap> soapModels = new ArrayList<FormSoap>(models.size());

		for (Form model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FormSoap[soapModels.size()]);
	}

	public FormSoap() {
	}

	public long getPrimaryKey() {
		return _formId;
	}

	public void setPrimaryKey(long pk) {
		setFormId(pk);
	}

	public long getFormId() {
		return _formId;
	}

	public void setFormId(long formId) {
		_formId = formId;
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

	public String getFormAttrId() {
		return _formAttrId;
	}

	public void setFormAttrId(String formAttrId) {
		_formAttrId = formAttrId;
	}

	public String getFormAttrClass() {
		return _formAttrClass;
	}

	public void setFormAttrClass(String formAttrClass) {
		_formAttrClass = formAttrClass;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDesc() {
		return _desc;
	}

	public void setDesc(String desc) {
		_desc = desc;
	}

	public boolean getUseCaptcha() {
		return _useCaptcha;
	}

	public boolean isUseCaptcha() {
		return _useCaptcha;
	}

	public void setUseCaptcha(boolean useCaptcha) {
		_useCaptcha = useCaptcha;
	}

	public String getSuccessMessage() {
		return _successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		_successMessage = successMessage;
	}

	public String getSuccessURL() {
		return _successURL;
	}

	public void setSuccessURL(String successURL) {
		_successURL = successURL;
	}

	public String getSubmitLabel() {
		return _submitLabel;
	}

	public void setSubmitLabel(String submitLabel) {
		_submitLabel = submitLabel;
	}

	public String getSubmitAttrId() {
		return _submitAttrId;
	}

	public void setSubmitAttrId(String submitAttrId) {
		_submitAttrId = submitAttrId;
	}

	public String getSubmitAttrClass() {
		return _submitAttrClass;
	}

	public void setSubmitAttrClass(String submitAttrClass) {
		_submitAttrClass = submitAttrClass;
	}

	private long _formId;
	private boolean _active;
	private Date _creationDate;
	private Date _modificationDate;
	private String _modificationUser;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private String _formAttrId;
	private String _formAttrClass;
	private String _title;
	private String _desc;
	private boolean _useCaptcha;
	private String _successMessage;
	private String _successURL;
	private String _submitLabel;
	private String _submitAttrId;
	private String _submitAttrClass;
}