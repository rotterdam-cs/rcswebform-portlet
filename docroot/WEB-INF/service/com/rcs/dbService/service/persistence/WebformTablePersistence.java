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

import com.liferay.portal.service.persistence.BasePersistence;

import com.rcs.dbService.model.WebformTable;

/**
 * The persistence interface for the webform table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformTablePersistenceImpl
 * @see WebformTableUtil
 * @generated
 */
public interface WebformTablePersistence extends BasePersistence<WebformTable> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WebformTableUtil} to access the webform table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the webform table where portletId = &#63; or throws a {@link com.rcs.dbService.NoSuchWebformTableException} if it could not be found.
	*
	* @param portletId the portlet ID
	* @return the matching webform table
	* @throws com.rcs.dbService.NoSuchWebformTableException if a matching webform table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformTable findByPortletId(
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformTableException;

	/**
	* Returns the webform table where portletId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param portletId the portlet ID
	* @return the matching webform table, or <code>null</code> if a matching webform table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformTable fetchByPortletId(
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the webform table where portletId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param portletId the portlet ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching webform table, or <code>null</code> if a matching webform table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformTable fetchByPortletId(
		java.lang.String portletId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the webform table where portletId = &#63; from the database.
	*
	* @param portletId the portlet ID
	* @return the webform table that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformTable removeByPortletId(
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformTableException;

	/**
	* Returns the number of webform tables where portletId = &#63;.
	*
	* @param portletId the portlet ID
	* @return the number of matching webform tables
	* @throws SystemException if a system exception occurred
	*/
	public int countByPortletId(java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the webform table where portletId = &#63; and webformCounter = &#63; or throws a {@link com.rcs.dbService.NoSuchWebformTableException} if it could not be found.
	*
	* @param portletId the portlet ID
	* @param webformCounter the webform counter
	* @return the matching webform table
	* @throws com.rcs.dbService.NoSuchWebformTableException if a matching webform table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformTable findByPortletIdAndCounter(
		java.lang.String portletId, java.lang.String webformCounter)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformTableException;

	/**
	* Returns the webform table where portletId = &#63; and webformCounter = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param portletId the portlet ID
	* @param webformCounter the webform counter
	* @return the matching webform table, or <code>null</code> if a matching webform table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformTable fetchByPortletIdAndCounter(
		java.lang.String portletId, java.lang.String webformCounter)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the webform table where portletId = &#63; and webformCounter = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param portletId the portlet ID
	* @param webformCounter the webform counter
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching webform table, or <code>null</code> if a matching webform table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformTable fetchByPortletIdAndCounter(
		java.lang.String portletId, java.lang.String webformCounter,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the webform table where portletId = &#63; and webformCounter = &#63; from the database.
	*
	* @param portletId the portlet ID
	* @param webformCounter the webform counter
	* @return the webform table that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformTable removeByPortletIdAndCounter(
		java.lang.String portletId, java.lang.String webformCounter)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformTableException;

	/**
	* Returns the number of webform tables where portletId = &#63; and webformCounter = &#63;.
	*
	* @param portletId the portlet ID
	* @param webformCounter the webform counter
	* @return the number of matching webform tables
	* @throws SystemException if a system exception occurred
	*/
	public int countByPortletIdAndCounter(java.lang.String portletId,
		java.lang.String webformCounter)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the webform table where webformName = &#63; or throws a {@link com.rcs.dbService.NoSuchWebformTableException} if it could not be found.
	*
	* @param webformName the webform name
	* @return the matching webform table
	* @throws com.rcs.dbService.NoSuchWebformTableException if a matching webform table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformTable findByWebformName(
		java.lang.String webformName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformTableException;

	/**
	* Returns the webform table where webformName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param webformName the webform name
	* @return the matching webform table, or <code>null</code> if a matching webform table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformTable fetchByWebformName(
		java.lang.String webformName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the webform table where webformName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param webformName the webform name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching webform table, or <code>null</code> if a matching webform table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformTable fetchByWebformName(
		java.lang.String webformName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the webform table where webformName = &#63; from the database.
	*
	* @param webformName the webform name
	* @return the webform table that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformTable removeByWebformName(
		java.lang.String webformName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformTableException;

	/**
	* Returns the number of webform tables where webformName = &#63;.
	*
	* @param webformName the webform name
	* @return the number of matching webform tables
	* @throws SystemException if a system exception occurred
	*/
	public int countByWebformName(java.lang.String webformName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the webform table in the entity cache if it is enabled.
	*
	* @param webformTable the webform table
	*/
	public void cacheResult(com.rcs.dbService.model.WebformTable webformTable);

	/**
	* Caches the webform tables in the entity cache if it is enabled.
	*
	* @param webformTables the webform tables
	*/
	public void cacheResult(
		java.util.List<com.rcs.dbService.model.WebformTable> webformTables);

	/**
	* Creates a new webform table with the primary key. Does not add the webform table to the database.
	*
	* @param webformTableId the primary key for the new webform table
	* @return the new webform table
	*/
	public com.rcs.dbService.model.WebformTable create(long webformTableId);

	/**
	* Removes the webform table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param webformTableId the primary key of the webform table
	* @return the webform table that was removed
	* @throws com.rcs.dbService.NoSuchWebformTableException if a webform table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformTable remove(long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformTableException;

	public com.rcs.dbService.model.WebformTable updateImpl(
		com.rcs.dbService.model.WebformTable webformTable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the webform table with the primary key or throws a {@link com.rcs.dbService.NoSuchWebformTableException} if it could not be found.
	*
	* @param webformTableId the primary key of the webform table
	* @return the webform table
	* @throws com.rcs.dbService.NoSuchWebformTableException if a webform table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformTable findByPrimaryKey(
		long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformTableException;

	/**
	* Returns the webform table with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param webformTableId the primary key of the webform table
	* @return the webform table, or <code>null</code> if a webform table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformTable fetchByPrimaryKey(
		long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the webform tables.
	*
	* @return the webform tables
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.WebformTable> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rcs.dbService.model.WebformTable> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rcs.dbService.model.WebformTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the webform tables from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of webform tables.
	*
	* @return the number of webform tables
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}