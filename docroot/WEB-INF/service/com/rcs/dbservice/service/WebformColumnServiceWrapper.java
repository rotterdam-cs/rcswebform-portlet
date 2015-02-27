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

package com.rcs.dbservice.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WebformColumnService}.
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformColumnService
 * @generated
 */
public class WebformColumnServiceWrapper implements WebformColumnService,
	ServiceWrapper<WebformColumnService> {
	public WebformColumnServiceWrapper(
		WebformColumnService webformColumnService) {
		_webformColumnService = webformColumnService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _webformColumnService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_webformColumnService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _webformColumnService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public WebformColumnService getWrappedWebformColumnService() {
		return _webformColumnService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedWebformColumnService(
		WebformColumnService webformColumnService) {
		_webformColumnService = webformColumnService;
	}

	@Override
	public WebformColumnService getWrappedService() {
		return _webformColumnService;
	}

	@Override
	public void setWrappedService(WebformColumnService webformColumnService) {
		_webformColumnService = webformColumnService;
	}

	private WebformColumnService _webformColumnService;
}