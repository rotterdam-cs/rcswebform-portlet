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

package com.rcs.dbService.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rcs.dbService.model.WebformTable;

import java.util.List;

/**
 * The persistence utility for the webform table service. This utility wraps {@link WebformTablePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformTablePersistence
 * @see WebformTablePersistenceImpl
 * @generated
 */
public class WebformTableUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(WebformTable webformTable) {
		getPersistence().clearCache(webformTable);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WebformTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WebformTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WebformTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static WebformTable update(WebformTable webformTable)
		throws SystemException {
		return getPersistence().update(webformTable);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static WebformTable update(WebformTable webformTable,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(webformTable, serviceContext);
	}

	/**
	* Returns the webform table where portletId = &#63; or throws a {@link com.rcs.dbService.NoSuchWebformTableException} if it could not be found.
	*
	* @param portletId the portlet ID
	* @return the matching webform table
	* @throws com.rcs.dbService.NoSuchWebformTableException if a matching webform table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformTable findByPortletId(
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformTableException {
		return getPersistence().findByPortletId(portletId);
	}

	/**
	* Returns the webform table where portletId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param portletId the portlet ID
	* @return the matching webform table, or <code>null</code> if a matching webform table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformTable fetchByPortletId(
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPortletId(portletId);
	}

	/**
	* Returns the webform table where portletId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param portletId the portlet ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching webform table, or <code>null</code> if a matching webform table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformTable fetchByPortletId(
		java.lang.String portletId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPortletId(portletId, retrieveFromCache);
	}

	/**
	* Removes the webform table where portletId = &#63; from the database.
	*
	* @param portletId the portlet ID
	* @return the webform table that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformTable removeByPortletId(
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformTableException {
		return getPersistence().removeByPortletId(portletId);
	}

	/**
	* Returns the number of webform tables where portletId = &#63;.
	*
	* @param portletId the portlet ID
	* @return the number of matching webform tables
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPortletId(java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPortletId(portletId);
	}

	/**
	* Returns the webform table where portletId = &#63; and webformCounter = &#63; or throws a {@link com.rcs.dbService.NoSuchWebformTableException} if it could not be found.
	*
	* @param portletId the portlet ID
	* @param webformCounter the webform counter
	* @return the matching webform table
	* @throws com.rcs.dbService.NoSuchWebformTableException if a matching webform table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformTable findByPortletIdAndCounter(
		java.lang.String portletId, java.lang.String webformCounter)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformTableException {
		return getPersistence()
				   .findByPortletIdAndCounter(portletId, webformCounter);
	}

	/**
	* Returns the webform table where portletId = &#63; and webformCounter = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param portletId the portlet ID
	* @param webformCounter the webform counter
	* @return the matching webform table, or <code>null</code> if a matching webform table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformTable fetchByPortletIdAndCounter(
		java.lang.String portletId, java.lang.String webformCounter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPortletIdAndCounter(portletId, webformCounter);
	}

	/**
	* Returns the webform table where portletId = &#63; and webformCounter = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param portletId the portlet ID
	* @param webformCounter the webform counter
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching webform table, or <code>null</code> if a matching webform table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformTable fetchByPortletIdAndCounter(
		java.lang.String portletId, java.lang.String webformCounter,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPortletIdAndCounter(portletId, webformCounter,
			retrieveFromCache);
	}

	/**
	* Removes the webform table where portletId = &#63; and webformCounter = &#63; from the database.
	*
	* @param portletId the portlet ID
	* @param webformCounter the webform counter
	* @return the webform table that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformTable removeByPortletIdAndCounter(
		java.lang.String portletId, java.lang.String webformCounter)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformTableException {
		return getPersistence()
				   .removeByPortletIdAndCounter(portletId, webformCounter);
	}

	/**
	* Returns the number of webform tables where portletId = &#63; and webformCounter = &#63;.
	*
	* @param portletId the portlet ID
	* @param webformCounter the webform counter
	* @return the number of matching webform tables
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPortletIdAndCounter(java.lang.String portletId,
		java.lang.String webformCounter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPortletIdAndCounter(portletId, webformCounter);
	}

	/**
	* Returns the webform table where name = &#63; or throws a {@link com.rcs.dbService.NoSuchWebformTableException} if it could not be found.
	*
	* @param name the name
	* @return the matching webform table
	* @throws com.rcs.dbService.NoSuchWebformTableException if a matching webform table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformTable findByname(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformTableException {
		return getPersistence().findByname(name);
	}

	/**
	* Returns the webform table where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching webform table, or <code>null</code> if a matching webform table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformTable fetchByname(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByname(name);
	}

	/**
	* Returns the webform table where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching webform table, or <code>null</code> if a matching webform table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformTable fetchByname(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByname(name, retrieveFromCache);
	}

	/**
	* Removes the webform table where name = &#63; from the database.
	*
	* @param name the name
	* @return the webform table that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformTable removeByname(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformTableException {
		return getPersistence().removeByname(name);
	}

	/**
	* Returns the number of webform tables where name = &#63;.
	*
	* @param name the name
	* @return the number of matching webform tables
	* @throws SystemException if a system exception occurred
	*/
	public static int countByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByname(name);
	}

	/**
	* Caches the webform table in the entity cache if it is enabled.
	*
	* @param webformTable the webform table
	*/
	public static void cacheResult(
		com.rcs.dbService.model.WebformTable webformTable) {
		getPersistence().cacheResult(webformTable);
	}

	/**
	* Caches the webform tables in the entity cache if it is enabled.
	*
	* @param webformTables the webform tables
	*/
	public static void cacheResult(
		java.util.List<com.rcs.dbService.model.WebformTable> webformTables) {
		getPersistence().cacheResult(webformTables);
	}

	/**
	* Creates a new webform table with the primary key. Does not add the webform table to the database.
	*
	* @param webformTableId the primary key for the new webform table
	* @return the new webform table
	*/
	public static com.rcs.dbService.model.WebformTable create(
		long webformTableId) {
		return getPersistence().create(webformTableId);
	}

	/**
	* Removes the webform table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param webformTableId the primary key of the webform table
	* @return the webform table that was removed
	* @throws com.rcs.dbService.NoSuchWebformTableException if a webform table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformTable remove(
		long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformTableException {
		return getPersistence().remove(webformTableId);
	}

	public static com.rcs.dbService.model.WebformTable updateImpl(
		com.rcs.dbService.model.WebformTable webformTable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(webformTable);
	}

	/**
	* Returns the webform table with the primary key or throws a {@link com.rcs.dbService.NoSuchWebformTableException} if it could not be found.
	*
	* @param webformTableId the primary key of the webform table
	* @return the webform table
	* @throws com.rcs.dbService.NoSuchWebformTableException if a webform table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformTable findByPrimaryKey(
		long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformTableException {
		return getPersistence().findByPrimaryKey(webformTableId);
	}

	/**
	* Returns the webform table with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param webformTableId the primary key of the webform table
	* @return the webform table, or <code>null</code> if a webform table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformTable fetchByPrimaryKey(
		long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(webformTableId);
	}

	/**
	* Returns all the webform tables.
	*
	* @return the webform tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.dbService.model.WebformTable> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the webform tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.WebformTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of webform tables
	* @param end the upper bound of the range of webform tables (not inclusive)
	* @return the range of webform tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.dbService.model.WebformTable> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the webform tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.WebformTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of webform tables
	* @param end the upper bound of the range of webform tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of webform tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.dbService.model.WebformTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the webform tables from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of webform tables.
	*
	* @return the number of webform tables
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WebformTablePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WebformTablePersistence)PortletBeanLocatorUtil.locate(com.rcs.dbService.service.ClpSerializer.getServletContextName(),
					WebformTablePersistence.class.getName());

			ReferenceRegistry.registerReference(WebformTableUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(WebformTablePersistence persistence) {
	}

	private static WebformTablePersistence _persistence;
}