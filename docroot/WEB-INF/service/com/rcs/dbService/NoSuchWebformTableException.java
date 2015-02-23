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

package com.rcs.dbService;

import com.liferay.portal.NoSuchModelException;

/**
 * @author rikad.ramadhan@rotterdam-cs.com
 */
public class NoSuchWebformTableException extends NoSuchModelException {

	public NoSuchWebformTableException() {
		super();
	}

	public NoSuchWebformTableException(String msg) {
		super(msg);
	}

	public NoSuchWebformTableException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchWebformTableException(Throwable cause) {
		super(cause);
	}

}