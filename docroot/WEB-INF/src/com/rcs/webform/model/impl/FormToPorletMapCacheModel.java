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

import com.rcs.webform.model.FormToPorletMap;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FormToPorletMap in entity cache.
 *
 * @author ryusuf
 * @see FormToPorletMap
 * @generated
 */
public class FormToPorletMapCacheModel implements CacheModel<FormToPorletMap>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{formToPorletMapId=");
		sb.append(formToPorletMapId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", formId=");
		sb.append(formId);
		sb.append(", portletId=");
		sb.append(portletId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FormToPorletMap toEntityModel() {
		FormToPorletMapImpl formToPorletMapImpl = new FormToPorletMapImpl();

		formToPorletMapImpl.setFormToPorletMapId(formToPorletMapId);
		formToPorletMapImpl.setGroupId(groupId);
		formToPorletMapImpl.setCompanyId(companyId);
		formToPorletMapImpl.setUserId(userId);

		if (userName == null) {
			formToPorletMapImpl.setUserName(StringPool.BLANK);
		}
		else {
			formToPorletMapImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			formToPorletMapImpl.setCreateDate(null);
		}
		else {
			formToPorletMapImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			formToPorletMapImpl.setModifiedDate(null);
		}
		else {
			formToPorletMapImpl.setModifiedDate(new Date(modifiedDate));
		}

		formToPorletMapImpl.setFormId(formId);

		if (portletId == null) {
			formToPorletMapImpl.setPortletId(StringPool.BLANK);
		}
		else {
			formToPorletMapImpl.setPortletId(portletId);
		}

		formToPorletMapImpl.resetOriginalValues();

		return formToPorletMapImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		formToPorletMapId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		formId = objectInput.readLong();
		portletId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(formToPorletMapId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(formId);

		if (portletId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(portletId);
		}
	}

	public long formToPorletMapId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long formId;
	public String portletId;
}