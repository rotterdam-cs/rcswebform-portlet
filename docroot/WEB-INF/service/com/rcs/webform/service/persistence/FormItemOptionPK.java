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

package com.rcs.webform.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author ryusuf
 * @generated
 */
public class FormItemOptionPK implements Comparable<FormItemOptionPK>,
	Serializable {
	public long formitemoptionId;
	public long formItemId;

	public FormItemOptionPK() {
	}

	public FormItemOptionPK(long formitemoptionId, long formItemId) {
		this.formitemoptionId = formitemoptionId;
		this.formItemId = formItemId;
	}

	public long getFormitemoptionId() {
		return formitemoptionId;
	}

	public void setFormitemoptionId(long formitemoptionId) {
		this.formitemoptionId = formitemoptionId;
	}

	public long getFormItemId() {
		return formItemId;
	}

	public void setFormItemId(long formItemId) {
		this.formItemId = formItemId;
	}

	@Override
	public int compareTo(FormItemOptionPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (formitemoptionId < pk.formitemoptionId) {
			value = -1;
		}
		else if (formitemoptionId > pk.formitemoptionId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (formItemId < pk.formItemId) {
			value = -1;
		}
		else if (formItemId > pk.formItemId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FormItemOptionPK)) {
			return false;
		}

		FormItemOptionPK pk = (FormItemOptionPK)obj;

		if ((formitemoptionId == pk.formitemoptionId) &&
				(formItemId == pk.formItemId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(formitemoptionId) + String.valueOf(formItemId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("formitemoptionId");
		sb.append(StringPool.EQUAL);
		sb.append(formitemoptionId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("formItemId");
		sb.append(StringPool.EQUAL);
		sb.append(formItemId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}