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
 * Provides a wrapper for {@link WebformValueLocalService}.
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformValueLocalService
 * @generated
 */
public class WebformValueLocalServiceWrapper implements WebformValueLocalService,
	ServiceWrapper<WebformValueLocalService> {
	public WebformValueLocalServiceWrapper(
		WebformValueLocalService webformValueLocalService) {
		_webformValueLocalService = webformValueLocalService;
	}

	/**
	* Adds the webform value to the database. Also notifies the appropriate model listeners.
	*
	* @param webformValue the webform value
	* @return the webform value that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.dbservice.model.WebformValue addWebformValue(
		com.rcs.dbservice.model.WebformValue webformValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformValueLocalService.addWebformValue(webformValue);
	}

	/**
	* Creates a new webform value with the primary key. Does not add the webform value to the database.
	*
	* @param webformValueId the primary key for the new webform value
	* @return the new webform value
	*/
	@Override
	public com.rcs.dbservice.model.WebformValue createWebformValue(
		long webformValueId) {
		return _webformValueLocalService.createWebformValue(webformValueId);
	}

	/**
	* Deletes the webform value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param webformValueId the primary key of the webform value
	* @return the webform value that was removed
	* @throws PortalException if a webform value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.dbservice.model.WebformValue deleteWebformValue(
		long webformValueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _webformValueLocalService.deleteWebformValue(webformValueId);
	}

	/**
	* Deletes the webform value from the database. Also notifies the appropriate model listeners.
	*
	* @param webformValue the webform value
	* @return the webform value that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.dbservice.model.WebformValue deleteWebformValue(
		com.rcs.dbservice.model.WebformValue webformValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformValueLocalService.deleteWebformValue(webformValue);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _webformValueLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformValueLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _webformValueLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformValueLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformValueLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformValueLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rcs.dbservice.model.WebformValue fetchWebformValue(
		long webformValueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformValueLocalService.fetchWebformValue(webformValueId);
	}

	/**
	* Returns the webform value with the primary key.
	*
	* @param webformValueId the primary key of the webform value
	* @return the webform value
	* @throws PortalException if a webform value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.dbservice.model.WebformValue getWebformValue(
		long webformValueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _webformValueLocalService.getWebformValue(webformValueId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _webformValueLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the webform values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of webform values
	* @param end the upper bound of the range of webform values (not inclusive)
	* @return the range of webform values
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rcs.dbservice.model.WebformValue> getWebformValues(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformValueLocalService.getWebformValues(start, end);
	}

	/**
	* Returns the number of webform values.
	*
	* @return the number of webform values
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getWebformValuesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformValueLocalService.getWebformValuesCount();
	}

	/**
	* Updates the webform value in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param webformValue the webform value
	* @return the webform value that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.dbservice.model.WebformValue updateWebformValue(
		com.rcs.dbservice.model.WebformValue webformValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformValueLocalService.updateWebformValue(webformValue);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _webformValueLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_webformValueLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _webformValueLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public WebformValueLocalService getWrappedWebformValueLocalService() {
		return _webformValueLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedWebformValueLocalService(
		WebformValueLocalService webformValueLocalService) {
		_webformValueLocalService = webformValueLocalService;
	}

	@Override
	public WebformValueLocalService getWrappedService() {
		return _webformValueLocalService;
	}

	@Override
	public void setWrappedService(
		WebformValueLocalService webformValueLocalService) {
		_webformValueLocalService = webformValueLocalService;
	}

	private WebformValueLocalService _webformValueLocalService;
}