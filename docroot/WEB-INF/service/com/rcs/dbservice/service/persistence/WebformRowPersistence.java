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

package com.rcs.dbservice.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.rcs.dbservice.model.WebformRow;

/**
 * The persistence interface for the webform row service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformRowPersistenceImpl
 * @see WebformRowUtil
 * @generated
 */
public interface WebformRowPersistence extends BasePersistence<WebformRow> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WebformRowUtil} to access the webform row persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the webform rows where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @return the matching webform rows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbservice.model.WebformRow> findByWebformTableId(
		long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the webform rows where webformTableId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformRowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param webformTableId the webform table ID
	* @param start the lower bound of the range of webform rows
	* @param end the upper bound of the range of webform rows (not inclusive)
	* @return the range of matching webform rows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbservice.model.WebformRow> findByWebformTableId(
		long webformTableId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the webform rows where webformTableId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformRowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param webformTableId the webform table ID
	* @param start the lower bound of the range of webform rows
	* @param end the upper bound of the range of webform rows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching webform rows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbservice.model.WebformRow> findByWebformTableId(
		long webformTableId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first webform row in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching webform row
	* @throws com.rcs.dbservice.NoSuchWebformRowException if a matching webform row could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbservice.model.WebformRow findByWebformTableId_First(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbservice.NoSuchWebformRowException;

	/**
	* Returns the first webform row in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching webform row, or <code>null</code> if a matching webform row could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbservice.model.WebformRow fetchByWebformTableId_First(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last webform row in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching webform row
	* @throws com.rcs.dbservice.NoSuchWebformRowException if a matching webform row could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbservice.model.WebformRow findByWebformTableId_Last(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbservice.NoSuchWebformRowException;

	/**
	* Returns the last webform row in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching webform row, or <code>null</code> if a matching webform row could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbservice.model.WebformRow fetchByWebformTableId_Last(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the webform rows before and after the current webform row in the ordered set where webformTableId = &#63;.
	*
	* @param webformRowId the primary key of the current webform row
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next webform row
	* @throws com.rcs.dbservice.NoSuchWebformRowException if a webform row with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbservice.model.WebformRow[] findByWebformTableId_PrevAndNext(
		long webformRowId, long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbservice.NoSuchWebformRowException;

	/**
	* Removes all the webform rows where webformTableId = &#63; from the database.
	*
	* @param webformTableId the webform table ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByWebformTableId(long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of webform rows where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @return the number of matching webform rows
	* @throws SystemException if a system exception occurred
	*/
	public int countByWebformTableId(long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the webform row in the entity cache if it is enabled.
	*
	* @param webformRow the webform row
	*/
	public void cacheResult(com.rcs.dbservice.model.WebformRow webformRow);

	/**
	* Caches the webform rows in the entity cache if it is enabled.
	*
	* @param webformRows the webform rows
	*/
	public void cacheResult(
		java.util.List<com.rcs.dbservice.model.WebformRow> webformRows);

	/**
	* Creates a new webform row with the primary key. Does not add the webform row to the database.
	*
	* @param webformRowId the primary key for the new webform row
	* @return the new webform row
	*/
	public com.rcs.dbservice.model.WebformRow create(long webformRowId);

	/**
	* Removes the webform row with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param webformRowId the primary key of the webform row
	* @return the webform row that was removed
	* @throws com.rcs.dbservice.NoSuchWebformRowException if a webform row with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbservice.model.WebformRow remove(long webformRowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbservice.NoSuchWebformRowException;

	public com.rcs.dbservice.model.WebformRow updateImpl(
		com.rcs.dbservice.model.WebformRow webformRow)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the webform row with the primary key or throws a {@link com.rcs.dbservice.NoSuchWebformRowException} if it could not be found.
	*
	* @param webformRowId the primary key of the webform row
	* @return the webform row
	* @throws com.rcs.dbservice.NoSuchWebformRowException if a webform row with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbservice.model.WebformRow findByPrimaryKey(
		long webformRowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbservice.NoSuchWebformRowException;

	/**
	* Returns the webform row with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param webformRowId the primary key of the webform row
	* @return the webform row, or <code>null</code> if a webform row with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbservice.model.WebformRow fetchByPrimaryKey(
		long webformRowId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the webform rows.
	*
	* @return the webform rows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbservice.model.WebformRow> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the webform rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformRowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of webform rows
	* @param end the upper bound of the range of webform rows (not inclusive)
	* @return the range of webform rows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbservice.model.WebformRow> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the webform rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformRowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of webform rows
	* @param end the upper bound of the range of webform rows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of webform rows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbservice.model.WebformRow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the webform rows from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of webform rows.
	*
	* @return the number of webform rows
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}