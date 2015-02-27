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

package com.rcs.dbservice.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rcs.dbservice.model.WebformValue;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing WebformValue in entity cache.
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformValue
 * @generated
 */
public class WebformValueCacheModel implements CacheModel<WebformValue>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{webformValueId=");
		sb.append(webformValueId);
		sb.append(", webformTableId=");
		sb.append(webformTableId);
		sb.append(", webformColumnId=");
		sb.append(webformColumnId);
		sb.append(", webformRowId=");
		sb.append(webformRowId);
		sb.append(", data=");
		sb.append(data);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WebformValue toEntityModel() {
		WebformValueImpl webformValueImpl = new WebformValueImpl();

		webformValueImpl.setWebformValueId(webformValueId);
		webformValueImpl.setWebformTableId(webformTableId);
		webformValueImpl.setWebformColumnId(webformColumnId);
		webformValueImpl.setWebformRowId(webformRowId);

		if (data == null) {
			webformValueImpl.setData(StringPool.BLANK);
		}
		else {
			webformValueImpl.setData(data);
		}

		webformValueImpl.resetOriginalValues();

		return webformValueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		webformValueId = objectInput.readLong();
		webformTableId = objectInput.readLong();
		webformColumnId = objectInput.readLong();
		webformRowId = objectInput.readLong();
		data = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(webformValueId);
		objectOutput.writeLong(webformTableId);
		objectOutput.writeLong(webformColumnId);
		objectOutput.writeLong(webformRowId);

		if (data == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(data);
		}
	}

	public long webformValueId;
	public long webformTableId;
	public long webformColumnId;
	public long webformRowId;
	public String data;
}