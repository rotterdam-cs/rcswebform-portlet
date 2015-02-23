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

import com.rcs.dbService.model.WebformValue;

/**
 * The persistence interface for the webform value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformValuePersistenceImpl
 * @see WebformValueUtil
 * @generated
 */
public interface WebformValuePersistence extends BasePersistence<WebformValue> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WebformValueUtil} to access the webform value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the webform values where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @return the matching webform values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.WebformValue> findByWebformTableId(
		long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the webform values where webformTableId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.WebformValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param webformTableId the webform table ID
	* @param start the lower bound of the range of webform values
	* @param end the upper bound of the range of webform values (not inclusive)
	* @return the range of matching webform values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.WebformValue> findByWebformTableId(
		long webformTableId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the webform values where webformTableId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.WebformValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param webformTableId the webform table ID
	* @param start the lower bound of the range of webform values
	* @param end the upper bound of the range of webform values (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching webform values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.WebformValue> findByWebformTableId(
		long webformTableId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first webform value in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching webform value
	* @throws com.rcs.dbService.NoSuchWebformValueException if a matching webform value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformValue findByWebformTableId_First(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformValueException;

	/**
	* Returns the first webform value in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching webform value, or <code>null</code> if a matching webform value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformValue fetchByWebformTableId_First(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last webform value in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching webform value
	* @throws com.rcs.dbService.NoSuchWebformValueException if a matching webform value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformValue findByWebformTableId_Last(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformValueException;

	/**
	* Returns the last webform value in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching webform value, or <code>null</code> if a matching webform value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformValue fetchByWebformTableId_Last(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the webform values before and after the current webform value in the ordered set where webformTableId = &#63;.
	*
	* @param webformValueId the primary key of the current webform value
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next webform value
	* @throws com.rcs.dbService.NoSuchWebformValueException if a webform value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformValue[] findByWebformTableId_PrevAndNext(
		long webformValueId, long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformValueException;

	/**
	* Removes all the webform values where webformTableId = &#63; from the database.
	*
	* @param webformTableId the webform table ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByWebformTableId(long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of webform values where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @return the number of matching webform values
	* @throws SystemException if a system exception occurred
	*/
	public int countByWebformTableId(long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the webform value in the entity cache if it is enabled.
	*
	* @param webformValue the webform value
	*/
	public void cacheResult(com.rcs.dbService.model.WebformValue webformValue);

	/**
	* Caches the webform values in the entity cache if it is enabled.
	*
	* @param webformValues the webform values
	*/
	public void cacheResult(
		java.util.List<com.rcs.dbService.model.WebformValue> webformValues);

	/**
	* Creates a new webform value with the primary key. Does not add the webform value to the database.
	*
	* @param webformValueId the primary key for the new webform value
	* @return the new webform value
	*/
	public com.rcs.dbService.model.WebformValue create(long webformValueId);

	/**
	* Removes the webform value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param webformValueId the primary key of the webform value
	* @return the webform value that was removed
	* @throws com.rcs.dbService.NoSuchWebformValueException if a webform value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformValue remove(long webformValueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformValueException;

	public com.rcs.dbService.model.WebformValue updateImpl(
		com.rcs.dbService.model.WebformValue webformValue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the webform value with the primary key or throws a {@link com.rcs.dbService.NoSuchWebformValueException} if it could not be found.
	*
	* @param webformValueId the primary key of the webform value
	* @return the webform value
	* @throws com.rcs.dbService.NoSuchWebformValueException if a webform value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformValue findByPrimaryKey(
		long webformValueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformValueException;

	/**
	* Returns the webform value with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param webformValueId the primary key of the webform value
	* @return the webform value, or <code>null</code> if a webform value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.WebformValue fetchByPrimaryKey(
		long webformValueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the webform values.
	*
	* @return the webform values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.WebformValue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the webform values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.WebformValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of webform values
	* @param end the upper bound of the range of webform values (not inclusive)
	* @return the range of webform values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.WebformValue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the webform values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.WebformValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of webform values
	* @param end the upper bound of the range of webform values (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of webform values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.WebformValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the webform values from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of webform values.
	*
	* @return the number of webform values
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}