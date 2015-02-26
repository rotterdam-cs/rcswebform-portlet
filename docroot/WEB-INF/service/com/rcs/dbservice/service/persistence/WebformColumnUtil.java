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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rcs.dbservice.model.WebformColumn;

import java.util.List;

/**
 * The persistence utility for the webform column service. This utility wraps {@link WebformColumnPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformColumnPersistence
 * @see WebformColumnPersistenceImpl
 * @generated
 */
public class WebformColumnUtil {
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
	public static void clearCache(WebformColumn webformColumn) {
		getPersistence().clearCache(webformColumn);
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
	public static List<WebformColumn> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WebformColumn> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WebformColumn> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static WebformColumn update(WebformColumn webformColumn)
		throws SystemException {
		return getPersistence().update(webformColumn);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static WebformColumn update(WebformColumn webformColumn,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(webformColumn, serviceContext);
	}

	/**
	* Returns all the webform columns where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @return the matching webform columns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.dbservice.model.WebformColumn> findByWebformTableId(
		long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByWebformTableId(webformTableId);
	}

	/**
	* Returns a range of all the webform columns where webformTableId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param webformTableId the webform table ID
	* @param start the lower bound of the range of webform columns
	* @param end the upper bound of the range of webform columns (not inclusive)
	* @return the range of matching webform columns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.dbservice.model.WebformColumn> findByWebformTableId(
		long webformTableId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByWebformTableId(webformTableId, start, end);
	}

	/**
	* Returns an ordered range of all the webform columns where webformTableId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param webformTableId the webform table ID
	* @param start the lower bound of the range of webform columns
	* @param end the upper bound of the range of webform columns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching webform columns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.dbservice.model.WebformColumn> findByWebformTableId(
		long webformTableId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByWebformTableId(webformTableId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first webform column in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching webform column
	* @throws com.rcs.dbservice.NoSuchWebformColumnException if a matching webform column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbservice.model.WebformColumn findByWebformTableId_First(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbservice.NoSuchWebformColumnException {
		return getPersistence()
				   .findByWebformTableId_First(webformTableId, orderByComparator);
	}

	/**
	* Returns the first webform column in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching webform column, or <code>null</code> if a matching webform column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbservice.model.WebformColumn fetchByWebformTableId_First(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByWebformTableId_First(webformTableId,
			orderByComparator);
	}

	/**
	* Returns the last webform column in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching webform column
	* @throws com.rcs.dbservice.NoSuchWebformColumnException if a matching webform column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbservice.model.WebformColumn findByWebformTableId_Last(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbservice.NoSuchWebformColumnException {
		return getPersistence()
				   .findByWebformTableId_Last(webformTableId, orderByComparator);
	}

	/**
	* Returns the last webform column in the ordered set where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching webform column, or <code>null</code> if a matching webform column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbservice.model.WebformColumn fetchByWebformTableId_Last(
		long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByWebformTableId_Last(webformTableId, orderByComparator);
	}

	/**
	* Returns the webform columns before and after the current webform column in the ordered set where webformTableId = &#63;.
	*
	* @param webformColumnId the primary key of the current webform column
	* @param webformTableId the webform table ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next webform column
	* @throws com.rcs.dbservice.NoSuchWebformColumnException if a webform column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbservice.model.WebformColumn[] findByWebformTableId_PrevAndNext(
		long webformColumnId, long webformTableId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbservice.NoSuchWebformColumnException {
		return getPersistence()
				   .findByWebformTableId_PrevAndNext(webformColumnId,
			webformTableId, orderByComparator);
	}

	/**
	* Removes all the webform columns where webformTableId = &#63; from the database.
	*
	* @param webformTableId the webform table ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByWebformTableId(long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByWebformTableId(webformTableId);
	}

	/**
	* Returns the number of webform columns where webformTableId = &#63;.
	*
	* @param webformTableId the webform table ID
	* @return the number of matching webform columns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByWebformTableId(long webformTableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByWebformTableId(webformTableId);
	}

	/**
	* Caches the webform column in the entity cache if it is enabled.
	*
	* @param webformColumn the webform column
	*/
	public static void cacheResult(
		com.rcs.dbservice.model.WebformColumn webformColumn) {
		getPersistence().cacheResult(webformColumn);
	}

	/**
	* Caches the webform columns in the entity cache if it is enabled.
	*
	* @param webformColumns the webform columns
	*/
	public static void cacheResult(
		java.util.List<com.rcs.dbservice.model.WebformColumn> webformColumns) {
		getPersistence().cacheResult(webformColumns);
	}

	/**
	* Creates a new webform column with the primary key. Does not add the webform column to the database.
	*
	* @param webformColumnId the primary key for the new webform column
	* @return the new webform column
	*/
	public static com.rcs.dbservice.model.WebformColumn create(
		long webformColumnId) {
		return getPersistence().create(webformColumnId);
	}

	/**
	* Removes the webform column with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param webformColumnId the primary key of the webform column
	* @return the webform column that was removed
	* @throws com.rcs.dbservice.NoSuchWebformColumnException if a webform column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbservice.model.WebformColumn remove(
		long webformColumnId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbservice.NoSuchWebformColumnException {
		return getPersistence().remove(webformColumnId);
	}

	public static com.rcs.dbservice.model.WebformColumn updateImpl(
		com.rcs.dbservice.model.WebformColumn webformColumn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(webformColumn);
	}

	/**
	* Returns the webform column with the primary key or throws a {@link com.rcs.dbservice.NoSuchWebformColumnException} if it could not be found.
	*
	* @param webformColumnId the primary key of the webform column
	* @return the webform column
	* @throws com.rcs.dbservice.NoSuchWebformColumnException if a webform column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbservice.model.WebformColumn findByPrimaryKey(
		long webformColumnId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbservice.NoSuchWebformColumnException {
		return getPersistence().findByPrimaryKey(webformColumnId);
	}

	/**
	* Returns the webform column with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param webformColumnId the primary key of the webform column
	* @return the webform column, or <code>null</code> if a webform column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbservice.model.WebformColumn fetchByPrimaryKey(
		long webformColumnId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(webformColumnId);
	}

	/**
	* Returns all the webform columns.
	*
	* @return the webform columns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.dbservice.model.WebformColumn> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.rcs.dbservice.model.WebformColumn> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the webform columns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of webform columns
	* @param end the upper bound of the range of webform columns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of webform columns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.dbservice.model.WebformColumn> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the webform columns from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of webform columns.
	*
	* @return the number of webform columns
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WebformColumnPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WebformColumnPersistence)PortletBeanLocatorUtil.locate(com.rcs.dbservice.service.ClpSerializer.getServletContextName(),
					WebformColumnPersistence.class.getName());

			ReferenceRegistry.registerReference(WebformColumnUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(WebformColumnPersistence persistence) {
	}

	private static WebformColumnPersistence _persistence;
}