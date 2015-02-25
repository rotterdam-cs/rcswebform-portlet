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

package com.rcs.dbService.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rcs.dbService.model.WebformTable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing WebformTable in entity cache.
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformTable
 * @generated
 */
public class WebformTableCacheModel implements CacheModel<WebformTable>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{webformTableId=");
		sb.append(webformTableId);
		sb.append(", portletId=");
		sb.append(portletId);
		sb.append(", webformCounter=");
		sb.append(webformCounter);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WebformTable toEntityModel() {
		WebformTableImpl webformTableImpl = new WebformTableImpl();

		webformTableImpl.setWebformTableId(webformTableId);

		if (portletId == null) {
			webformTableImpl.setPortletId(StringPool.BLANK);
		}
		else {
			webformTableImpl.setPortletId(portletId);
		}

		if (webformCounter == null) {
			webformTableImpl.setWebformCounter(StringPool.BLANK);
		}
		else {
			webformTableImpl.setWebformCounter(webformCounter);
		}

		if (name == null) {
			webformTableImpl.setName(StringPool.BLANK);
		}
		else {
			webformTableImpl.setName(name);
		}

		webformTableImpl.resetOriginalValues();

		return webformTableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		webformTableId = objectInput.readLong();
		portletId = objectInput.readUTF();
		webformCounter = objectInput.readUTF();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(webformTableId);

		if (portletId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(portletId);
		}

		if (webformCounter == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(webformCounter);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long webformTableId;
	public String portletId;
	public String webformCounter;
	public String name;
}