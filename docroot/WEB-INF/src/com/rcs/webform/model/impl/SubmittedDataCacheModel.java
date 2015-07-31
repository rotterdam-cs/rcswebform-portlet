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

import com.rcs.webform.model.SubmittedData;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SubmittedData in entity cache.
 *
 * @author ryusuf
 * @see SubmittedData
 * @generated
 */
public class SubmittedDataCacheModel implements CacheModel<SubmittedData>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{submittedDataId=");
		sb.append(submittedDataId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
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
		sb.append(", portletId=");
		sb.append(portletId);
		sb.append(", formItemId=");
		sb.append(formItemId);
		sb.append(", userInput=");
		sb.append(userInput);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SubmittedData toEntityModel() {
		SubmittedDataImpl submittedDataImpl = new SubmittedDataImpl();

		submittedDataImpl.setSubmittedDataId(submittedDataId);
		submittedDataImpl.setGroupId(groupId);
		submittedDataImpl.setCompanyId(companyId);
		submittedDataImpl.setActive(active);

		if (creationDate == Long.MIN_VALUE) {
			submittedDataImpl.setCreationDate(null);
		}
		else {
			submittedDataImpl.setCreationDate(new Date(creationDate));
		}

		if (modificationDate == Long.MIN_VALUE) {
			submittedDataImpl.setModificationDate(null);
		}
		else {
			submittedDataImpl.setModificationDate(new Date(modificationDate));
		}

		if (modificationUser == null) {
			submittedDataImpl.setModificationUser(StringPool.BLANK);
		}
		else {
			submittedDataImpl.setModificationUser(modificationUser);
		}

		submittedDataImpl.setFormId(formId);

		if (portletId == null) {
			submittedDataImpl.setPortletId(StringPool.BLANK);
		}
		else {
			submittedDataImpl.setPortletId(portletId);
		}

		submittedDataImpl.setFormItemId(formItemId);

		if (userInput == null) {
			submittedDataImpl.setUserInput(StringPool.BLANK);
		}
		else {
			submittedDataImpl.setUserInput(userInput);
		}

		submittedDataImpl.resetOriginalValues();

		return submittedDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		submittedDataId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		active = objectInput.readBoolean();
		creationDate = objectInput.readLong();
		modificationDate = objectInput.readLong();
		modificationUser = objectInput.readUTF();
		formId = objectInput.readLong();
		portletId = objectInput.readUTF();
		formItemId = objectInput.readLong();
		userInput = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(submittedDataId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
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

		if (portletId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(portletId);
		}

		objectOutput.writeLong(formItemId);

		if (userInput == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userInput);
		}
	}

	public long submittedDataId;
	public long groupId;
	public long companyId;
	public boolean active;
	public long creationDate;
	public long modificationDate;
	public String modificationUser;
	public long formId;
	public String portletId;
	public long formItemId;
	public String userInput;
}