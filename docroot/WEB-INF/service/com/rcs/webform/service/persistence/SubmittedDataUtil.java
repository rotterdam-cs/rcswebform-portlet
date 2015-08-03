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

import com.rcs.webform.model.SubmittedData;

import java.util.List;

/**
 * The persistence utility for the submitted data service. This utility wraps {@link SubmittedDataPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ryusuf
 * @see SubmittedDataPersistence
 * @see SubmittedDataPersistenceImpl
 * @generated
 */
public class SubmittedDataUtil {
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
	public static void clearCache(SubmittedData submittedData) {
		getPersistence().clearCache(submittedData);
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
	public static List<SubmittedData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SubmittedData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SubmittedData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SubmittedData update(SubmittedData submittedData)
		throws SystemException {
		return getPersistence().update(submittedData);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SubmittedData update(SubmittedData submittedData,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(submittedData, serviceContext);
	}

	/**
	* Caches the submitted data in the entity cache if it is enabled.
	*
	* @param submittedData the submitted data
	*/
	public static void cacheResult(
		com.rcs.webform.model.SubmittedData submittedData) {
		getPersistence().cacheResult(submittedData);
	}

	/**
	* Caches the submitted datas in the entity cache if it is enabled.
	*
	* @param submittedDatas the submitted datas
	*/
	public static void cacheResult(
		java.util.List<com.rcs.webform.model.SubmittedData> submittedDatas) {
		getPersistence().cacheResult(submittedDatas);
	}

	/**
	* Creates a new submitted data with the primary key. Does not add the submitted data to the database.
	*
	* @param submittedDataPK the primary key for the new submitted data
	* @return the new submitted data
	*/
	public static com.rcs.webform.model.SubmittedData create(
		com.rcs.webform.service.persistence.SubmittedDataPK submittedDataPK) {
		return getPersistence().create(submittedDataPK);
	}

	/**
	* Removes the submitted data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submittedDataPK the primary key of the submitted data
	* @return the submitted data that was removed
	* @throws com.rcs.webform.NoSuchSubmittedDataException if a submitted data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.SubmittedData remove(
		com.rcs.webform.service.persistence.SubmittedDataPK submittedDataPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchSubmittedDataException {
		return getPersistence().remove(submittedDataPK);
	}

	public static com.rcs.webform.model.SubmittedData updateImpl(
		com.rcs.webform.model.SubmittedData submittedData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(submittedData);
	}

	/**
	* Returns the submitted data with the primary key or throws a {@link com.rcs.webform.NoSuchSubmittedDataException} if it could not be found.
	*
	* @param submittedDataPK the primary key of the submitted data
	* @return the submitted data
	* @throws com.rcs.webform.NoSuchSubmittedDataException if a submitted data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.SubmittedData findByPrimaryKey(
		com.rcs.webform.service.persistence.SubmittedDataPK submittedDataPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchSubmittedDataException {
		return getPersistence().findByPrimaryKey(submittedDataPK);
	}

	/**
	* Returns the submitted data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param submittedDataPK the primary key of the submitted data
	* @return the submitted data, or <code>null</code> if a submitted data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.SubmittedData fetchByPrimaryKey(
		com.rcs.webform.service.persistence.SubmittedDataPK submittedDataPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(submittedDataPK);
	}

	/**
	* Returns all the submitted datas.
	*
	* @return the submitted datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.webform.model.SubmittedData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the submitted datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.SubmittedDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of submitted datas
	* @param end the upper bound of the range of submitted datas (not inclusive)
	* @return the range of submitted datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.webform.model.SubmittedData> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the submitted datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.SubmittedDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of submitted datas
	* @param end the upper bound of the range of submitted datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of submitted datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.webform.model.SubmittedData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the submitted datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of submitted datas.
	*
	* @return the number of submitted datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SubmittedDataPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SubmittedDataPersistence)PortletBeanLocatorUtil.locate(com.rcs.webform.service.ClpSerializer.getServletContextName(),
					SubmittedDataPersistence.class.getName());

			ReferenceRegistry.registerReference(SubmittedDataUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SubmittedDataPersistence persistence) {
	}

	private static SubmittedDataPersistence _persistence;
}