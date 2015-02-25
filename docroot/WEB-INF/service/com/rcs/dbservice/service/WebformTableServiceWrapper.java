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

package com.rcs.dbService.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WebformTableService}.
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformTableService
 * @generated
 */
public class WebformTableServiceWrapper implements WebformTableService,
	ServiceWrapper<WebformTableService> {
	public WebformTableServiceWrapper(WebformTableService webformTableService) {
		_webformTableService = webformTableService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _webformTableService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_webformTableService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _webformTableService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public WebformTableService getWrappedWebformTableService() {
		return _webformTableService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedWebformTableService(
		WebformTableService webformTableService) {
		_webformTableService = webformTableService;
	}

	@Override
	public WebformTableService getWrappedService() {
		return _webformTableService;
	}

	@Override
	public void setWrappedService(WebformTableService webformTableService) {
		_webformTableService = webformTableService;
	}

	private WebformTableService _webformTableService;
}