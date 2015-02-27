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
 * Provides a wrapper for {@link WebformTableLocalService}.
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformTableLocalService
 * @generated
 */
public class WebformTableLocalServiceWrapper implements WebformTableLocalService,
	ServiceWrapper<WebformTableLocalService> {
	public WebformTableLocalServiceWrapper(
		WebformTableLocalService webformTableLocalService) {
		_webformTableLocalService = webformTableLocalService;
	}

	/**
	* Adds the webform table to the database. Also notifies the appropriate model listeners.
	*
	* @param webformTable the webform table
	* @return the webform table that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.dbservice.model.WebformTable addWebformTable(
		com.rcs.dbservice.model.WebformTable webformTable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformTableLocalService.addWebformTable(webformTable);
	}

	/**
	* Creates a new webform table with the primary key. Does not add the webform table to the database.
	*
	* @param webformTableId the primary key for the new webform table
	* @return the new webform table
	*/
	@Override
	public com.rcs.dbservice.model.WebformTable createWebformTable(
		long webformTableId) {
		return _webformTableLocalService.createWebformTable(webformTableId);
	}

	/**
	* Deletes the webform table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param webformTableId the primary key of the webform table
	* @return the webform table that was removed
	* @throws PortalException if a webform table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.dbservice.model.WebformTable deleteWebformTable(
		long webformTableId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _webformTableLocalService.deleteWebformTable(webformTableId);
	}

	/**
	* Deletes the webform table from the database. Also notifies the appropriate model listeners.
	*
	* @param webformTable the webform table
	* @return the webform table that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.dbservice.model.WebformTable deleteWebformTable(
		com.rcs.dbservice.model.WebformTable webformTable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformTableLocalService.deleteWebformTable(webformTable);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _webformTableLocalService.dynamicQuery();
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
		return _webformTableLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _webformTableLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _webformTableLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _webformTableLocalService.dynamicQueryCount(dynamicQuery);
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
		return _webformTableLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rcs.dbservice.model.WebformTable fetchWebformTable(
		long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformTableLocalService.fetchWebformTable(webformTableId);
	}

	/**
	* Returns the webform table with the primary key.
	*
	* @param webformTableId the primary key of the webform table
	* @return the webform table
	* @throws PortalException if a webform table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.dbservice.model.WebformTable getWebformTable(
		long webformTableId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _webformTableLocalService.getWebformTable(webformTableId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _webformTableLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the webform tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of webform tables
	* @param end the upper bound of the range of webform tables (not inclusive)
	* @return the range of webform tables
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rcs.dbservice.model.WebformTable> getWebformTables(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformTableLocalService.getWebformTables(start, end);
	}

	/**
	* Returns the number of webform tables.
	*
	* @return the number of webform tables
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getWebformTablesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformTableLocalService.getWebformTablesCount();
	}

	/**
	* Updates the webform table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param webformTable the webform table
	* @return the webform table that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.dbservice.model.WebformTable updateWebformTable(
		com.rcs.dbservice.model.WebformTable webformTable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformTableLocalService.updateWebformTable(webformTable);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _webformTableLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_webformTableLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _webformTableLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public WebformTableLocalService getWrappedWebformTableLocalService() {
		return _webformTableLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedWebformTableLocalService(
		WebformTableLocalService webformTableLocalService) {
		_webformTableLocalService = webformTableLocalService;
	}

	@Override
	public WebformTableLocalService getWrappedService() {
		return _webformTableLocalService;
	}

	@Override
	public void setWrappedService(
		WebformTableLocalService webformTableLocalService) {
		_webformTableLocalService = webformTableLocalService;
	}

	private WebformTableLocalService _webformTableLocalService;
}