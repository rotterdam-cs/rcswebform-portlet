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

import com.rcs.dbService.model.WebformValue;

import java.util.List;

/**
 * The persistence utility for the webform value service. This utility wraps {@link WebformValuePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformValuePersistence
 * @see WebformValuePersistenceImpl
 * @generated
 */
public class WebformValueUtil {
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
	public static void clearCache(WebformValue webformValue) {
		getPersistence().clearCache(webformValue);
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
	public static List<WebformValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WebformValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WebformValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static WebformValue update(WebformValue webformValue)
		throws SystemException {
		return getPersistence().update(webformValue);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static WebformValue update(WebformValue webformValue,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(webformValue, serviceContext);
	}

	/**
	* Returns all the webform values where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @return the matching webform values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.dbService.model.WebformValue> findByWebformTableId(
		long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByWebformTableId(webformTableId);
	}

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
	public static java.util.List<com.rcs.dbService.model.WebformValue> findByWebformTableId(
		long webformTableId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByWebformTableId(webformTableId, start, end);
	}

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
	public static java.util.List<com.rcs.dbService.model.WebformValue> findByWebformTableId(
		long webformTableId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByWebformTableId(webformTableId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first webform value in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching webform value
	* @throws com.rcs.dbService.NoSuchWebformValueException if a matching webform value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformValue findByWebformTableId_First(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformValueException {
		return getPersistence()
				   .findByWebformTableId_First(webformTableId, orderByComparator);
	}

	/**
	* Returns the first webform value in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching webform value, or <code>null</code> if a matching webform value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformValue fetchByWebformTableId_First(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByWebformTableId_First(webformTableId,
			orderByComparator);
	}

	/**
	* Returns the last webform value in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching webform value
	* @throws com.rcs.dbService.NoSuchWebformValueException if a matching webform value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformValue findByWebformTableId_Last(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformValueException {
		return getPersistence()
				   .findByWebformTableId_Last(webformTableId, orderByComparator);
	}

	/**
	* Returns the last webform value in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching webform value, or <code>null</code> if a matching webform value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformValue fetchByWebformTableId_Last(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByWebformTableId_Last(webformTableId, orderByComparator);
	}

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
	public static com.rcs.dbService.model.WebformValue[] findByWebformTableId_PrevAndNext(
		long webformValueId, long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformValueException {
		return getPersistence()
				   .findByWebformTableId_PrevAndNext(webformValueId,
			webformTableId, orderByComparator);
	}

	/**
	* Removes all the webform values where webformTableId = &#63; from the database.
	*
	* @param webformTableId the webform table ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByWebformTableId(long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByWebformTableId(webformTableId);
	}

	/**
	* Returns the number of webform values where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @return the number of matching webform values
	* @throws SystemException if a system exception occurred
	*/
	public static int countByWebformTableId(long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByWebformTableId(webformTableId);
	}

	/**
	* Caches the webform value in the entity cache if it is enabled.
	*
	* @param webformValue the webform value
	*/
	public static void cacheResult(
		com.rcs.dbService.model.WebformValue webformValue) {
		getPersistence().cacheResult(webformValue);
	}

	/**
	* Caches the webform values in the entity cache if it is enabled.
	*
	* @param webformValues the webform values
	*/
	public static void cacheResult(
		java.util.List<com.rcs.dbService.model.WebformValue> webformValues) {
		getPersistence().cacheResult(webformValues);
	}

	/**
	* Creates a new webform value with the primary key. Does not add the webform value to the database.
	*
	* @param webformValueId the primary key for the new webform value
	* @return the new webform value
	*/
	public static com.rcs.dbService.model.WebformValue create(
		long webformValueId) {
		return getPersistence().create(webformValueId);
	}

	/**
	* Removes the webform value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param webformValueId the primary key of the webform value
	* @return the webform value that was removed
	* @throws com.rcs.dbService.NoSuchWebformValueException if a webform value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformValue remove(
		long webformValueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformValueException {
		return getPersistence().remove(webformValueId);
	}

	public static com.rcs.dbService.model.WebformValue updateImpl(
		com.rcs.dbService.model.WebformValue webformValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(webformValue);
	}

	/**
	* Returns the webform value with the primary key or throws a {@link com.rcs.dbService.NoSuchWebformValueException} if it could not be found.
	*
	* @param webformValueId the primary key of the webform value
	* @return the webform value
	* @throws com.rcs.dbService.NoSuchWebformValueException if a webform value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformValue findByPrimaryKey(
		long webformValueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchWebformValueException {
		return getPersistence().findByPrimaryKey(webformValueId);
	}

	/**
	* Returns the webform value with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param webformValueId the primary key of the webform value
	* @return the webform value, or <code>null</code> if a webform value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.WebformValue fetchByPrimaryKey(
		long webformValueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(webformValueId);
	}

	/**
	* Returns all the webform values.
	*
	* @return the webform values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.dbService.model.WebformValue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.rcs.dbService.model.WebformValue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.rcs.dbService.model.WebformValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the webform values from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of webform values.
	*
	* @return the number of webform values
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WebformValuePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WebformValuePersistence)PortletBeanLocatorUtil.locate(com.rcs.dbService.service.ClpSerializer.getServletContextName(),
					WebformValuePersistence.class.getName());

			ReferenceRegistry.registerReference(WebformValueUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(WebformValuePersistence persistence) {
	}

	private static WebformValuePersistence _persistence;
}