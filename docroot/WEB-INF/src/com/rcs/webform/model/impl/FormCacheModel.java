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

package com.rcs.webform.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rcs.webform.model.Form;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Form in entity cache.
 *
 * @author ryusuf
 * @see Form
 * @generated
 */
public class FormCacheModel implements CacheModel<Form>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{formId=");
		sb.append(formId);
		sb.append(", active=");
		sb.append(active);
		sb.append(", creationDate=");
		sb.append(creationDate);
		sb.append(", modificationDate=");
		sb.append(modificationDate);
		sb.append(", modificationUser=");
		sb.append(modificationUser);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", formAttrId=");
		sb.append(formAttrId);
		sb.append(", formAttrClass=");
		sb.append(formAttrClass);
		sb.append(", title=");
		sb.append(title);
		sb.append(", desc=");
		sb.append(desc);
		sb.append(", useCaptcha=");
		sb.append(useCaptcha);
		sb.append(", successMessage=");
		sb.append(successMessage);
		sb.append(", successURL=");
		sb.append(successURL);
		sb.append(", submitLabel=");
		sb.append(submitLabel);
		sb.append(", submitAttrId=");
		sb.append(submitAttrId);
		sb.append(", submitAttrClass=");
		sb.append(submitAttrClass);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Form toEntityModel() {
		FormImpl formImpl = new FormImpl();

		formImpl.setFormId(formId);
		formImpl.setActive(active);

		if (creationDate == Long.MIN_VALUE) {
			formImpl.setCreationDate(null);
		}
		else {
			formImpl.setCreationDate(new Date(creationDate));
		}

		if (modificationDate == Long.MIN_VALUE) {
			formImpl.setModificationDate(null);
		}
		else {
			formImpl.setModificationDate(new Date(modificationDate));
		}

		if (modificationUser == null) {
			formImpl.setModificationUser(StringPool.BLANK);
		}
		else {
			formImpl.setModificationUser(modificationUser);
		}

		formImpl.setGroupId(groupId);
		formImpl.setCompanyId(companyId);
		formImpl.setUserId(userId);

		if (userName == null) {
			formImpl.setUserName(StringPool.BLANK);
		}
		else {
			formImpl.setUserName(userName);
		}

		if (formAttrId == null) {
			formImpl.setFormAttrId(StringPool.BLANK);
		}
		else {
			formImpl.setFormAttrId(formAttrId);
		}

		if (formAttrClass == null) {
			formImpl.setFormAttrClass(StringPool.BLANK);
		}
		else {
			formImpl.setFormAttrClass(formAttrClass);
		}

		if (title == null) {
			formImpl.setTitle(StringPool.BLANK);
		}
		else {
			formImpl.setTitle(title);
		}

		if (desc == null) {
			formImpl.setDesc(StringPool.BLANK);
		}
		else {
			formImpl.setDesc(desc);
		}

		formImpl.setUseCaptcha(useCaptcha);

		if (successMessage == null) {
			formImpl.setSuccessMessage(StringPool.BLANK);
		}
		else {
			formImpl.setSuccessMessage(successMessage);
		}

		if (successURL == null) {
			formImpl.setSuccessURL(StringPool.BLANK);
		}
		else {
			formImpl.setSuccessURL(successURL);
		}

		if (submitLabel == null) {
			formImpl.setSubmitLabel(StringPool.BLANK);
		}
		else {
			formImpl.setSubmitLabel(submitLabel);
		}

		if (submitAttrId == null) {
			formImpl.setSubmitAttrId(StringPool.BLANK);
		}
		else {
			formImpl.setSubmitAttrId(submitAttrId);
		}

		if (submitAttrClass == null) {
			formImpl.setSubmitAttrClass(StringPool.BLANK);
		}
		else {
			formImpl.setSubmitAttrClass(submitAttrClass);
		}

		formImpl.resetOriginalValues();

		return formImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		formId = objectInput.readLong();
		active = objectInput.readBoolean();
		creationDate = objectInput.readLong();
		modificationDate = objectInput.readLong();
		modificationUser = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		formAttrId = objectInput.readUTF();
		formAttrClass = objectInput.readUTF();
		title = objectInput.readUTF();
		desc = objectInput.readUTF();
		useCaptcha = objectInput.readBoolean();
		successMessage = objectInput.readUTF();
		successURL = objectInput.readUTF();
		submitLabel = objectInput.readUTF();
		submitAttrId = objectInput.readUTF();
		submitAttrClass = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(formId);
		objectOutput.writeBoolean(active);
		objectOutput.writeLong(creationDate);
		objectOutput.writeLong(modificationDate);

		if (modificationUser == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(modificationUser);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (formAttrId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(formAttrId);
		}

		if (formAttrClass == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(formAttrClass);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (desc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(desc);
		}

		objectOutput.writeBoolean(useCaptcha);

		if (successMessage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(successMessage);
		}

		if (successURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(successURL);
		}

		if (submitLabel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(submitLabel);
		}

		if (submitAttrId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(submitAttrId);
		}

		if (submitAttrClass == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(submitAttrClass);
		}
	}

	public long formId;
	public boolean active;
	public long creationDate;
	public long modificationDate;
	public String modificationUser;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public String formAttrId;
	public String formAttrClass;
	public String title;
	public String desc;
	public boolean useCaptcha;
	public String successMessage;
	public String successURL;
	public String submitLabel;
	public String submitAttrId;
	public String submitAttrClass;
}