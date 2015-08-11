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
 */
public class SubmittedDataPK implements Comparable<SubmittedDataPK>,
	Serializable {
	public long submittedDataId;
	public long formId;
	public String portletId;
	public long formItemId;

	public SubmittedDataPK() {
	}

	public SubmittedDataPK(long submittedDataId, long formId, String portletId,
		long formItemId) {
		this.submittedDataId = submittedDataId;
		this.formId = formId;
		this.portletId = portletId;
		this.formItemId = formItemId;
	}

	public long getSubmittedDataId() {
		return submittedDataId;
	}

	public void setSubmittedDataId(long submittedDataId) {
		this.submittedDataId = submittedDataId;
	}

	public long getFormId() {
		return formId;
	}

	public void setFormId(long formId) {
		this.formId = formId;
	}

	public String getPortletId() {
		return portletId;
	}

	public void setPortletId(String portletId) {
		this.portletId = portletId;
	}

	public long getFormItemId() {
		return formItemId;
	}

	public void setFormItemId(long formItemId) {
		this.formItemId = formItemId;
	}

	@Override
	public int compareTo(SubmittedDataPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (submittedDataId < pk.submittedDataId) {
			value = -1;
		}
		else if (submittedDataId > pk.submittedDataId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (formId < pk.formId) {
			value = -1;
		}
		else if (formId > pk.formId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = portletId.compareTo(pk.portletId);

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

		if (!(obj instanceof SubmittedDataPK)) {
			return false;
		}

		SubmittedDataPK pk = (SubmittedDataPK)obj;

		if ((submittedDataId == pk.submittedDataId) && (formId == pk.formId) &&
				(portletId.equals(pk.portletId)) &&
				(formItemId == pk.formItemId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(submittedDataId) + String.valueOf(formId) +
		String.valueOf(portletId) + String.valueOf(formItemId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(20);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("submittedDataId");
		sb.append(StringPool.EQUAL);
		sb.append(submittedDataId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("formId");
		sb.append(StringPool.EQUAL);
		sb.append(formId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("portletId");
		sb.append(StringPool.EQUAL);
		sb.append(portletId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("formItemId");
		sb.append(StringPool.EQUAL);
		sb.append(formItemId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}