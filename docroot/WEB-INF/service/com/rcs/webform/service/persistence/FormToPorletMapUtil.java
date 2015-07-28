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

package com.rcs.webform.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rcs.webform.model.FormToPorletMap;

import java.util.List;

/**
 * The persistence utility for the form to porlet map service. This utility wraps {@link FormToPorletMapPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ryusuf
 * @see FormToPorletMapPersistence
 * @see FormToPorletMapPersistenceImpl
 * @generated
 */
public class FormToPorletMapUtil {
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
	public static void clearCache(FormToPorletMap formToPorletMap) {
		getPersistence().clearCache(formToPorletMap);
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
	public static List<FormToPorletMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FormToPorletMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FormToPorletMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FormToPorletMap update(FormToPorletMap formToPorletMap)
		throws SystemException {
		return getPersistence().update(formToPorletMap);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FormToPorletMap update(FormToPorletMap formToPorletMap,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(formToPorletMap, serviceContext);
	}

	/**
	* Returns the form to porlet map where groupId = &#63; and companyId = &#63; and portletId = &#63; or throws a {@link com.rcs.webform.NoSuchFormToPorletMapException} if it could not be found.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @return the matching form to porlet map
	* @throws com.rcs.webform.NoSuchFormToPorletMapException if a matching form to porlet map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormToPorletMap findByGroupColumnPortletId(
		long groupId, long companyId, java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchFormToPorletMapException {
		return getPersistence()
				   .findByGroupColumnPortletId(groupId, companyId, portletId);
	}

	/**
	* Returns the form to porlet map where groupId = &#63; and companyId = &#63; and portletId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @return the matching form to porlet map, or <code>null</code> if a matching form to porlet map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormToPorletMap fetchByGroupColumnPortletId(
		long groupId, long companyId, java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupColumnPortletId(groupId, companyId, portletId);
	}

	/**
	* Returns the form to porlet map where groupId = &#63; and companyId = &#63; and portletId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching form to porlet map, or <code>null</code> if a matching form to porlet map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormToPorletMap fetchByGroupColumnPortletId(
		long groupId, long companyId, java.lang.String portletId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupColumnPortletId(groupId, companyId, portletId,
			retrieveFromCache);
	}

	/**
	* Removes the form to porlet map where groupId = &#63; and companyId = &#63; and portletId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @return the form to porlet map that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormToPorletMap removeByGroupColumnPortletId(
		long groupId, long companyId, java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchFormToPorletMapException {
		return getPersistence()
				   .removeByGroupColumnPortletId(groupId, companyId, portletId);
	}

	/**
	* Returns the number of form to porlet maps where groupId = &#63; and companyId = &#63; and portletId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param portletId the portlet ID
	* @return the number of matching form to porlet maps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupColumnPortletId(long groupId, long companyId,
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByGroupColumnPortletId(groupId, companyId, portletId);
	}

	/**
	* Caches the form to porlet map in the entity cache if it is enabled.
	*
	* @param formToPorletMap the form to porlet map
	*/
	public static void cacheResult(
		com.rcs.webform.model.FormToPorletMap formToPorletMap) {
		getPersistence().cacheResult(formToPorletMap);
	}

	/**
	* Caches the form to porlet maps in the entity cache if it is enabled.
	*
	* @param formToPorletMaps the form to porlet maps
	*/
	public static void cacheResult(
		java.util.List<com.rcs.webform.model.FormToPorletMap> formToPorletMaps) {
		getPersistence().cacheResult(formToPorletMaps);
	}

	/**
	* Creates a new form to porlet map with the primary key. Does not add the form to porlet map to the database.
	*
	* @param formToPorletMapId the primary key for the new form to porlet map
	* @return the new form to porlet map
	*/
	public static com.rcs.webform.model.FormToPorletMap create(
		long formToPorletMapId) {
		return getPersistence().create(formToPorletMapId);
	}

	/**
	* Removes the form to porlet map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param formToPorletMapId the primary key of the form to porlet map
	* @return the form to porlet map that was removed
	* @throws com.rcs.webform.NoSuchFormToPorletMapException if a form to porlet map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormToPorletMap remove(
		long formToPorletMapId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchFormToPorletMapException {
		return getPersistence().remove(formToPorletMapId);
	}

	public static com.rcs.webform.model.FormToPorletMap updateImpl(
		com.rcs.webform.model.FormToPorletMap formToPorletMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(formToPorletMap);
	}

	/**
	* Returns the form to porlet map with the primary key or throws a {@link com.rcs.webform.NoSuchFormToPorletMapException} if it could not be found.
	*
	* @param formToPorletMapId the primary key of the form to porlet map
	* @return the form to porlet map
	* @throws com.rcs.webform.NoSuchFormToPorletMapException if a form to porlet map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormToPorletMap findByPrimaryKey(
		long formToPorletMapId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchFormToPorletMapException {
		return getPersistence().findByPrimaryKey(formToPorletMapId);
	}

	/**
	* Returns the form to porlet map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param formToPorletMapId the primary key of the form to porlet map
	* @return the form to porlet map, or <code>null</code> if a form to porlet map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormToPorletMap fetchByPrimaryKey(
		long formToPorletMapId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(formToPorletMapId);
	}

	/**
	* Returns all the form to porlet maps.
	*
	* @return the form to porlet maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.webform.model.FormToPorletMap> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the form to porlet maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormToPorletMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form to porlet maps
	* @param end the upper bound of the range of form to porlet maps (not inclusive)
	* @return the range of form to porlet maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.webform.model.FormToPorletMap> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the form to porlet maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormToPorletMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form to porlet maps
	* @param end the upper bound of the range of form to porlet maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of form to porlet maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.webform.model.FormToPorletMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the form to porlet maps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of form to porlet maps.
	*
	* @return the number of form to porlet maps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FormToPorletMapPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FormToPorletMapPersistence)PortletBeanLocatorUtil.locate(com.rcs.webform.service.ClpSerializer.getServletContextName(),
					FormToPorletMapPersistence.class.getName());

			ReferenceRegistry.registerReference(FormToPorletMapUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FormToPorletMapPersistence persistence) {
	}

	private static FormToPorletMapPersistence _persistence;
}