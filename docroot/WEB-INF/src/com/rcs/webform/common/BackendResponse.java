package com.rcs.webform.common;

import java.io.Serializable;

import com.rcs.webform.common.util.JsonConverter;

/**
 * 
 * @author rodrigo.perez@rotterdam-cs.com
 *
 */
public abstract class BackendResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private JsonConverter converter = new JsonConverter();

	public String toString() {
		return converter.toJson(this);
	}
}
