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
 * Provides a wrapper for {@link WebformColumnLocalService}.
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformColumnLocalService
 * @generated
 */
public class WebformColumnLocalServiceWrapper
	implements WebformColumnLocalService,
		ServiceWrapper<WebformColumnLocalService> {
	public WebformColumnLocalServiceWrapper(
		WebformColumnLocalService webformColumnLocalService) {
		_webformColumnLocalService = webformColumnLocalService;
	}

	/**
	* Adds the webform column to the database. Also notifies the appropriate model listeners.
	*
	* @param webformColumn the webform column
	* @return the webform column that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.dbservice.model.WebformColumn addWebformColumn(
		com.rcs.dbservice.model.WebformColumn webformColumn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformColumnLocalService.addWebformColumn(webformColumn);
	}

	/**
	* Creates a new webform column with the primary key. Does not add the webform column to the database.
	*
	* @param webformColumnId the primary key for the new webform column
	* @return the new webform column
	*/
	@Override
	public com.rcs.dbservice.model.WebformColumn createWebformColumn(
		long webformColumnId) {
		return _webformColumnLocalService.createWebformColumn(webformColumnId);
	}

	/**
	* Deletes the webform column with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param webformColumnId the primary key of the webform column
	* @return the webform column that was removed
	* @throws PortalException if a webform column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.dbservice.model.WebformColumn deleteWebformColumn(
		long webformColumnId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _webformColumnLocalService.deleteWebformColumn(webformColumnId);
	}

	/**
	* Deletes the webform column from the database. Also notifies the appropriate model listeners.
	*
	* @param webformColumn the webform column
	* @return the webform column that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.dbservice.model.WebformColumn deleteWebformColumn(
		com.rcs.dbservice.model.WebformColumn webformColumn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformColumnLocalService.deleteWebformColumn(webformColumn);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _webformColumnLocalService.dynamicQuery();
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
		return _webformColumnLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _webformColumnLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _webformColumnLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _webformColumnLocalService.dynamicQueryCount(dynamicQuery);
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
		return _webformColumnLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rcs.dbservice.model.WebformColumn fetchWebformColumn(
		long webformColumnId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformColumnLocalService.fetchWebformColumn(webformColumnId);
	}

	/**
	* Returns the webform column with the primary key.
	*
	* @param webformColumnId the primary key of the webform column
	* @return the webform column
	* @throws PortalException if a webform column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.dbservice.model.WebformColumn getWebformColumn(
		long webformColumnId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _webformColumnLocalService.getWebformColumn(webformColumnId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _webformColumnLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the webform columns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of webform columns
	* @param end the upper bound of the range of webform columns (not inclusive)
	* @return the range of webform columns
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rcs.dbservice.model.WebformColumn> getWebformColumns(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformColumnLocalService.getWebformColumns(start, end);
	}

	/**
	* Returns the number of webform columns.
	*
	* @return the number of webform columns
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getWebformColumnsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformColumnLocalService.getWebformColumnsCount();
	}

	/**
	* Updates the webform column in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param webformColumn the webform column
	* @return the webform column that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.dbservice.model.WebformColumn updateWebformColumn(
		com.rcs.dbservice.model.WebformColumn webformColumn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webformColumnLocalService.updateWebformColumn(webformColumn);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _webformColumnLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_webformColumnLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _webformColumnLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public WebformColumnLocalService getWrappedWebformColumnLocalService() {
		return _webformColumnLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedWebformColumnLocalService(
		WebformColumnLocalService webformColumnLocalService) {
		_webformColumnLocalService = webformColumnLocalService;
	}

	@Override
	public WebformColumnLocalService getWrappedService() {
		return _webformColumnLocalService;
	}

	@Override
	public void setWrappedService(
		WebformColumnLocalService webformColumnLocalService) {
		_webformColumnLocalService = webformColumnLocalService;
	}

	private WebformColumnLocalService _webformColumnLocalService;
}