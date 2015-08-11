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

import com.rcs.webform.model.FormItemOption;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FormItemOption in entity cache.
 *
 * @author ryusuf
 * @see FormItemOption
 * @generated
 */
public class FormItemOptionCacheModel implements CacheModel<FormItemOption>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{formitemoptionId=");
		sb.append(formitemoptionId);
		sb.append(", creationDate=");
		sb.append(creationDate);
		sb.append(", modificationDate=");
		sb.append(modificationDate);
		sb.append(", modificationUser=");
		sb.append(modificationUser);
		sb.append(", formItemId=");
		sb.append(formItemId);
		sb.append(", optionKey=");
		sb.append(optionKey);
		sb.append(", optionValue=");
		sb.append(optionValue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FormItemOption toEntityModel() {
		FormItemOptionImpl formItemOptionImpl = new FormItemOptionImpl();

		formItemOptionImpl.setFormitemoptionId(formitemoptionId);

		if (creationDate == Long.MIN_VALUE) {
			formItemOptionImpl.setCreationDate(null);
		}
		else {
			formItemOptionImpl.setCreationDate(new Date(creationDate));
		}

		if (modificationDate == Long.MIN_VALUE) {
			formItemOptionImpl.setModificationDate(null);
		}
		else {
			formItemOptionImpl.setModificationDate(new Date(modificationDate));
		}

		if (modificationUser == null) {
			formItemOptionImpl.setModificationUser(StringPool.BLANK);
		}
		else {
			formItemOptionImpl.setModificationUser(modificationUser);
		}

		formItemOptionImpl.setFormItemId(formItemId);

		if (optionKey == null) {
			formItemOptionImpl.setOptionKey(StringPool.BLANK);
		}
		else {
			formItemOptionImpl.setOptionKey(optionKey);
		}

		if (optionValue == null) {
			formItemOptionImpl.setOptionValue(StringPool.BLANK);
		}
		else {
			formItemOptionImpl.setOptionValue(optionValue);
		}

		formItemOptionImpl.resetOriginalValues();

		return formItemOptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		formitemoptionId = objectInput.readLong();
		creationDate = objectInput.readLong();
		modificationDate = objectInput.readLong();
		modificationUser = objectInput.readUTF();
		formItemId = objectInput.readLong();
		optionKey = objectInput.readUTF();
		optionValue = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(formitemoptionId);
		objectOutput.writeLong(creationDate);
		objectOutput.writeLong(modificationDate);

		if (modificationUser == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(modificationUser);
		}

		objectOutput.writeLong(formItemId);

		if (optionKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(optionKey);
		}

		if (optionValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(optionValue);
		}
	}

	public long formitemoptionId;
	public long creationDate;
	public long modificationDate;
	public String modificationUser;
	public long formItemId;
	public String optionKey;
	public String optionValue;
}