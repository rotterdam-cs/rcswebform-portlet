/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import com.liferay.portal.service.persistence.BasePersistence;

import com.rcs.webform.model.FormToPorletMap;

/**
 * The persistence interface for the form to porlet map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ryusuf
 * @see FormToPorletMapPersistenceImpl
 * @see FormToPorletMapUtil
 * @generated
 */
public interface FormToPorletMapPersistence extends BasePersistence<FormToPorletMap> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FormToPorletMapUtil} to access the form to porlet map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the form to porlet map where portletId = &#63; or throws a {@link com.rcs.webform.NoSuchFormToPorletMapException} if it could not be found.
	*
	* @param portletId the portlet ID
	* @return the matching form to porlet map
	* @throws com.rcs.webform.NoSuchFormToPorletMapException if a matching form to porlet map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.webform.model.FormToPorletMap findByPortletId(
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchFormToPorletMapException;

	/**
	* Returns the form to porlet map where portletId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param portletId the portlet ID
	* @return the matching form to porlet map, or <code>null</code> if a matching form to porlet map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.webform.model.FormToPorletMap fetchByPortletId(
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the form to porlet map where portletId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param portletId the portlet ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching form to porlet map, or <code>null</code> if a matching form to porlet map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.webform.model.FormToPorletMap fetchByPortletId(
		java.lang.String portletId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the form to porlet map where portletId = &#63; from the database.
	*
	* @param portletId the portlet ID
	* @return the form to porlet map that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.webform.model.FormToPorletMap removeByPortletId(
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchFormToPorletMapException;

	/**
	* Returns the number of form to porlet maps where portletId = &#63;.
	*
	* @param portletId the portlet ID
	* @return the number of matching form to porlet maps
	* @throws SystemException if a system exception occurred
	*/
	public int countByPortletId(java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the form to porlet map in the entity cache if it is enabled.
	*
	* @param formToPorletMap the form to porlet map
	*/
	public void cacheResult(
		com.rcs.webform.model.FormToPorletMap formToPorletMap);

	/**
	* Caches the form to porlet maps in the entity cache if it is enabled.
	*
	* @param formToPorletMaps the form to porlet maps
	*/
	public void cacheResult(
		java.util.List<com.rcs.webform.model.FormToPorletMap> formToPorletMaps);

	/**
	* Creates a new form to porlet map with the primary key. Does not add the form to porlet map to the database.
	*
	* @param formToPorletMapId the primary key for the new form to porlet map
	* @return the new form to porlet map
	*/
	public com.rcs.webform.model.FormToPorletMap create(long formToPorletMapId);

	/**
	* Removes the form to porlet map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param formToPorletMapId the primary key of the form to porlet map
	* @return the form to porlet map that was removed
	* @throws com.rcs.webform.NoSuchFormToPorletMapException if a form to porlet map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.webform.model.FormToPorletMap remove(long formToPorletMapId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchFormToPorletMapException;

	public com.rcs.webform.model.FormToPorletMap updateImpl(
		com.rcs.webform.model.FormToPorletMap formToPorletMap)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the form to porlet map with the primary key or throws a {@link com.rcs.webform.NoSuchFormToPorletMapException} if it could not be found.
	*
	* @param formToPorletMapId the primary key of the form to porlet map
	* @return the form to porlet map
	* @throws com.rcs.webform.NoSuchFormToPorletMapException if a form to porlet map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.webform.model.FormToPorletMap findByPrimaryKey(
		long formToPorletMapId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchFormToPorletMapException;

	/**
	* Returns the form to porlet map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param formToPorletMapId the primary key of the form to porlet map
	* @return the form to porlet map, or <code>null</code> if a form to porlet map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.webform.model.FormToPorletMap fetchByPrimaryKey(
		long formToPorletMapId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the form to porlet maps.
	*
	* @return the form to porlet maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.webform.model.FormToPorletMap> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rcs.webform.model.FormToPorletMap> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rcs.webform.model.FormToPorletMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the form to porlet maps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of form to porlet maps.
	*
	* @return the number of form to porlet maps
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}