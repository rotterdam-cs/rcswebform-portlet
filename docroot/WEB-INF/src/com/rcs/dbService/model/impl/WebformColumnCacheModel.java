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

import com.rcs.dbService.model.WebformColumn;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing WebformColumn in entity cache.
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformColumn
 * @generated
 */
public class WebformColumnCacheModel implements CacheModel<WebformColumn>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{webformColumnId=");
		sb.append(webformColumnId);
		sb.append(", webformTableId=");
		sb.append(webformTableId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", type=");
		sb.append(type);
		sb.append(", inputType=");
		sb.append(inputType);
		sb.append(", isRequired=");
		sb.append(isRequired);
		sb.append(", placeHolder=");
		sb.append(placeHolder);
		sb.append(", validation=");
		sb.append(validation);
		sb.append(", customValidation=");
		sb.append(customValidation);
		sb.append(", labelClass=");
		sb.append(labelClass);
		sb.append(", inputClass=");
		sb.append(inputClass);
		sb.append(", maxLength=");
		sb.append(maxLength);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WebformColumn toEntityModel() {
		WebformColumnImpl webformColumnImpl = new WebformColumnImpl();

		webformColumnImpl.setWebformColumnId(webformColumnId);
		webformColumnImpl.setWebformTableId(webformTableId);

		if (name == null) {
			webformColumnImpl.setName(StringPool.BLANK);
		}
		else {
			webformColumnImpl.setName(name);
		}

		webformColumnImpl.setType(type);
		webformColumnImpl.setInputType(inputType);
		webformColumnImpl.setIsRequired(isRequired);

		if (placeHolder == null) {
			webformColumnImpl.setPlaceHolder(StringPool.BLANK);
		}
		else {
			webformColumnImpl.setPlaceHolder(placeHolder);
		}

		if (validation == null) {
			webformColumnImpl.setValidation(StringPool.BLANK);
		}
		else {
			webformColumnImpl.setValidation(validation);
		}

		if (customValidation == null) {
			webformColumnImpl.setCustomValidation(StringPool.BLANK);
		}
		else {
			webformColumnImpl.setCustomValidation(customValidation);
		}

		if (labelClass == null) {
			webformColumnImpl.setLabelClass(StringPool.BLANK);
		}
		else {
			webformColumnImpl.setLabelClass(labelClass);
		}

		if (inputClass == null) {
			webformColumnImpl.setInputClass(StringPool.BLANK);
		}
		else {
			webformColumnImpl.setInputClass(inputClass);
		}

		if (maxLength == null) {
			webformColumnImpl.setMaxLength(StringPool.BLANK);
		}
		else {
			webformColumnImpl.setMaxLength(maxLength);
		}

		webformColumnImpl.resetOriginalValues();

		return webformColumnImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		webformColumnId = objectInput.readLong();
		webformTableId = objectInput.readLong();
		name = objectInput.readUTF();
		type = objectInput.readInt();
		inputType = objectInput.readInt();
		isRequired = objectInput.readBoolean();
		placeHolder = objectInput.readUTF();
		validation = objectInput.readUTF();
		customValidation = objectInput.readUTF();
		labelClass = objectInput.readUTF();
		inputClass = objectInput.readUTF();
		maxLength = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(webformColumnId);
		objectOutput.writeLong(webformTableId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(type);
		objectOutput.writeInt(inputType);
		objectOutput.writeBoolean(isRequired);

		if (placeHolder == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(placeHolder);
		}

		if (validation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(validation);
		}

		if (customValidation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customValidation);
		}

		if (labelClass == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(labelClass);
		}

		if (inputClass == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(inputClass);
		}

		if (maxLength == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maxLength);
		}
	}

	public long webformColumnId;
	public long webformTableId;
	public String name;
	public int type;
	public int inputType;
	public boolean isRequired;
	public String placeHolder;
	public String validation;
	public String customValidation;
	public String labelClass;
	public String inputClass;
	public String maxLength;
}