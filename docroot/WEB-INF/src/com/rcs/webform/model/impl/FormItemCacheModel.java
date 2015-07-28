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

package com.rcs.webform.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rcs.webform.model.FormItem;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FormItem in entity cache.
 *
 * @author ryusuf
 * @see FormItem
 * @generated
 */
public class FormItemCacheModel implements CacheModel<FormItem>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{formItemId=");
		sb.append(formItemId);
		sb.append(", active=");
		sb.append(active);
		sb.append(", creationDate=");
		sb.append(creationDate);
		sb.append(", modificationDate=");
		sb.append(modificationDate);
		sb.append(", modificationUser=");
		sb.append(modificationUser);
		sb.append(", formId=");
		sb.append(formId);
		sb.append(", formItemAttrId=");
		sb.append(formItemAttrId);
		sb.append(", formItemAttrClass=");
		sb.append(formItemAttrClass);
		sb.append(", label=");
		sb.append(label);
		sb.append(", labelAttrId=");
		sb.append(labelAttrId);
		sb.append(", labelAttrClass=");
		sb.append(labelAttrClass);
		sb.append(", inputAttrId=");
		sb.append(inputAttrId);
		sb.append(", inputAttrClass=");
		sb.append(inputAttrClass);
		sb.append(", type=");
		sb.append(type);
		sb.append(", options=");
		sb.append(options);
		sb.append(", mandatory=");
		sb.append(mandatory);
		sb.append(", defaultValue=");
		sb.append(defaultValue);
		sb.append(", order=");
		sb.append(order);
		sb.append(", validationType=");
		sb.append(validationType);
		sb.append(", validationRegexValue=");
		sb.append(validationRegexValue);
		sb.append(", errorValidationMessage=");
		sb.append(errorValidationMessage);
		sb.append(", errorMandatoryMessage=");
		sb.append(errorMandatoryMessage);
		sb.append(", hintMessage=");
		sb.append(hintMessage);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FormItem toEntityModel() {
		FormItemImpl formItemImpl = new FormItemImpl();

		formItemImpl.setFormItemId(formItemId);
		formItemImpl.setActive(active);

		if (creationDate == Long.MIN_VALUE) {
			formItemImpl.setCreationDate(null);
		}
		else {
			formItemImpl.setCreationDate(new Date(creationDate));
		}

		if (modificationDate == Long.MIN_VALUE) {
			formItemImpl.setModificationDate(null);
		}
		else {
			formItemImpl.setModificationDate(new Date(modificationDate));
		}

		if (modificationUser == null) {
			formItemImpl.setModificationUser(StringPool.BLANK);
		}
		else {
			formItemImpl.setModificationUser(modificationUser);
		}

		formItemImpl.setFormId(formId);

		if (formItemAttrId == null) {
			formItemImpl.setFormItemAttrId(StringPool.BLANK);
		}
		else {
			formItemImpl.setFormItemAttrId(formItemAttrId);
		}

		if (formItemAttrClass == null) {
			formItemImpl.setFormItemAttrClass(StringPool.BLANK);
		}
		else {
			formItemImpl.setFormItemAttrClass(formItemAttrClass);
		}

		if (label == null) {
			formItemImpl.setLabel(StringPool.BLANK);
		}
		else {
			formItemImpl.setLabel(label);
		}

		if (labelAttrId == null) {
			formItemImpl.setLabelAttrId(StringPool.BLANK);
		}
		else {
			formItemImpl.setLabelAttrId(labelAttrId);
		}

		if (labelAttrClass == null) {
			formItemImpl.setLabelAttrClass(StringPool.BLANK);
		}
		else {
			formItemImpl.setLabelAttrClass(labelAttrClass);
		}

		if (inputAttrId == null) {
			formItemImpl.setInputAttrId(StringPool.BLANK);
		}
		else {
			formItemImpl.setInputAttrId(inputAttrId);
		}

		if (inputAttrClass == null) {
			formItemImpl.setInputAttrClass(StringPool.BLANK);
		}
		else {
			formItemImpl.setInputAttrClass(inputAttrClass);
		}

		if (type == null) {
			formItemImpl.setType(StringPool.BLANK);
		}
		else {
			formItemImpl.setType(type);
		}

		if (options == null) {
			formItemImpl.setOptions(StringPool.BLANK);
		}
		else {
			formItemImpl.setOptions(options);
		}

		formItemImpl.setMandatory(mandatory);

		if (defaultValue == null) {
			formItemImpl.setDefaultValue(StringPool.BLANK);
		}
		else {
			formItemImpl.setDefaultValue(defaultValue);
		}

		formItemImpl.setOrder(order);

		if (validationType == null) {
			formItemImpl.setValidationType(StringPool.BLANK);
		}
		else {
			formItemImpl.setValidationType(validationType);
		}

		if (validationRegexValue == null) {
			formItemImpl.setValidationRegexValue(StringPool.BLANK);
		}
		else {
			formItemImpl.setValidationRegexValue(validationRegexValue);
		}

		if (errorValidationMessage == null) {
			formItemImpl.setErrorValidationMessage(StringPool.BLANK);
		}
		else {
			formItemImpl.setErrorValidationMessage(errorValidationMessage);
		}

		if (errorMandatoryMessage == null) {
			formItemImpl.setErrorMandatoryMessage(StringPool.BLANK);
		}
		else {
			formItemImpl.setErrorMandatoryMessage(errorMandatoryMessage);
		}

		if (hintMessage == null) {
			formItemImpl.setHintMessage(StringPool.BLANK);
		}
		else {
			formItemImpl.setHintMessage(hintMessage);
		}

		formItemImpl.resetOriginalValues();

		return formItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		formItemId = objectInput.readLong();
		active = objectInput.readBoolean();
		creationDate = objectInput.readLong();
		modificationDate = objectInput.readLong();
		modificationUser = objectInput.readUTF();
		formId = objectInput.readLong();
		formItemAttrId = objectInput.readUTF();
		formItemAttrClass = objectInput.readUTF();
		label = objectInput.readUTF();
		labelAttrId = objectInput.readUTF();
		labelAttrClass = objectInput.readUTF();
		inputAttrId = objectInput.readUTF();
		inputAttrClass = objectInput.readUTF();
		type = objectInput.readUTF();
		options = objectInput.readUTF();
		mandatory = objectInput.readBoolean();
		defaultValue = objectInput.readUTF();
		order = objectInput.readInt();
		validationType = objectInput.readUTF();
		validationRegexValue = objectInput.readUTF();
		errorValidationMessage = objectInput.readUTF();
		errorMandatoryMessage = objectInput.readUTF();
		hintMessage = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(formItemId);
		objectOutput.writeBoolean(active);
		objectOutput.writeLong(creationDate);
		objectOutput.writeLong(modificationDate);

		if (modificationUser == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(modificationUser);
		}

		objectOutput.writeLong(formId);

		if (formItemAttrId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(formItemAttrId);
		}

		if (formItemAttrClass == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(formItemAttrClass);
		}

		if (label == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(label);
		}

		if (labelAttrId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(labelAttrId);
		}

		if (labelAttrClass == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(labelAttrClass);
		}

		if (inputAttrId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(inputAttrId);
		}

		if (inputAttrClass == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(inputAttrClass);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (options == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(options);
		}

		objectOutput.writeBoolean(mandatory);

		if (defaultValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(defaultValue);
		}

		objectOutput.writeInt(order);

		if (validationType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(validationType);
		}

		if (validationRegexValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(validationRegexValue);
		}

		if (errorValidationMessage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(errorValidationMessage);
		}

		if (errorMandatoryMessage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(errorMandatoryMessage);
		}

		if (hintMessage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hintMessage);
		}
	}

	public long formItemId;
	public boolean active;
	public long creationDate;
	public long modificationDate;
	public String modificationUser;
	public long formId;
	public String formItemAttrId;
	public String formItemAttrClass;
	public String label;
	public String labelAttrId;
	public String labelAttrClass;
	public String inputAttrId;
	public String inputAttrClass;
	public String type;
	public String options;
	public boolean mandatory;
	public String defaultValue;
	public int order;
	public String validationType;
	public String validationRegexValue;
	public String errorValidationMessage;
	public String errorMandatoryMessage;
	public String hintMessage;
}