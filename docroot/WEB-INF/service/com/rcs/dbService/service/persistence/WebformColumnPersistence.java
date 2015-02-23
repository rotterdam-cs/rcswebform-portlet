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

import com.rcs.dbService.model.WebformColumn;

/**
 * The persistence interface for the webform column service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformColumnPersistenceImpl
 * @see WebformColumnUtil
 * @generated
 */
public interface WebformColumnPersistence extends BasePersistence<WebformColumn> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WebformColumnUtil} to access the webform column persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the webform columns where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @return the matching webform columns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.WebformColumn> findByWebformTableId(
		long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the webform columns where webformTableId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.WebformColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param webformTableId the webform table ID
	* @param start the lower bound of the range of webform columns
	* @param end the upper bound of the range of webform columns (not inclusive)
	* @return the range of matching webform columns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.WebformColumn> findByWebformTableId(
		long webformTableId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the webform columns where webformTableId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.WebformColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param webformTableId the webform table ID
	* @param start the lower bound of the range of webform columns
	* @param end the upper bound of the range of webform columns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching webform columns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.WebformColumn> findByWebformTableId(
		long webformTableId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first webform column in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching webform column
	* @throws com.rcs.dbService.NoSuchWebformColumnException if a matching webform column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformColumn findByWebformTableId_First(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformColumnException;

	/**
	* Returns the first webform column in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching webform column, or <code>null</code> if a matching webform column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformColumn fetchByWebformTableId_First(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last webform column in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching webform column
	* @throws com.rcs.dbService.NoSuchWebformColumnException if a matching webform column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformColumn findByWebformTableId_Last(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformColumnException;

	/**
	* Returns the last webform column in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching webform column, or <code>null</code> if a matching webform column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformColumn fetchByWebformTableId_Last(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the webform columns before and after the current webform column in the ordered set where webformTableId = &#63;.
	*
	* @param webformColumnId the primary key of the current webform column
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next webform column
	* @throws com.rcs.dbService.NoSuchWebformColumnException if a webform column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformColumn[] findByWebformTableId_PrevAndNext(
		long webformColumnId, long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformColumnException;

	/**
	* Removes all the webform columns where webformTableId = &#63; from the database.
	*
	* @param webformTableId the webform table ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByWebformTableId(long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of webform columns where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @return the number of matching webform columns
	* @throws SystemException if a system exception occurred
	*/
	public int countByWebformTableId(long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the webform column in the entity cache if it is enabled.
	*
	* @param webformColumn the webform column
	*/
	public void cacheResult(com.rcs.dbService.model.WebformColumn webformColumn);

	/**
	* Caches the webform columns in the entity cache if it is enabled.
	*
	* @param webformColumns the webform columns
	*/
	public void cacheResult(
		java.util.List<com.rcs.dbService.model.WebformColumn> webformColumns);

	/**
	* Creates a new webform column with the primary key. Does not add the webform column to the database.
	*
	* @param webformColumnId the primary key for the new webform column
	* @return the new webform column
	*/
	public com.rcs.dbService.model.WebformColumn create(long webformColumnId);

	/**
	* Removes the webform column with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param webformColumnId the primary key of the webform column
	* @return the webform column that was removed
	* @throws com.rcs.dbService.NoSuchWebformColumnException if a webform column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformColumn remove(long webformColumnId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformColumnException;

	public com.rcs.dbService.model.WebformColumn updateImpl(
		com.rcs.dbService.model.WebformColumn webformColumn)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the webform column with the primary key or throws a {@link com.rcs.dbService.NoSuchWebformColumnException} if it could not be found.
	*
	* @param webformColumnId the primary key of the webform column
	* @return the webform column
	* @throws com.rcs.dbService.NoSuchWebformColumnException if a webform column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformColumn findByPrimaryKey(
		long webformColumnId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformColumnException;

	/**
	* Returns the webform column with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param webformColumnId the primary key of the webform column
	* @return the webform column, or <code>null</code> if a webform column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformColumn fetchByPrimaryKey(
		long webformColumnId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the webform columns.
	*
	* @return the webform columns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.WebformColumn> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the webform columns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.WebformColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of webform columns
	* @param end the upper bound of the range of webform columns (not inclusive)
	* @return the range of webform columns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.WebformColumn> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the webform columns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.WebformColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of webform columns
	* @param end the upper bound of the range of webform columns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of webform columns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.WebformColumn> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the webform columns from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of webform columns.
	*
	* @return the number of webform columns
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}