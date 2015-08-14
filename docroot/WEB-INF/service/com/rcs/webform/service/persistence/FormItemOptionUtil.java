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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rcs.webform.model.FormItemOption;

import java.util.List;

/**
 * The persistence utility for the form item option service. This utility wraps {@link FormItemOptionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ryusuf
 * @see FormItemOptionPersistence
 * @see FormItemOptionPersistenceImpl
 * @generated
 */
public class FormItemOptionUtil {
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
	public static void clearCache(FormItemOption formItemOption) {
		getPersistence().clearCache(formItemOption);
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
	public static List<FormItemOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FormItemOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FormItemOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FormItemOption update(FormItemOption formItemOption)
		throws SystemException {
		return getPersistence().update(formItemOption);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FormItemOption update(FormItemOption formItemOption,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(formItemOption, serviceContext);
	}

	/**
	* Caches the form item option in the entity cache if it is enabled.
	*
	* @param formItemOption the form item option
	*/
	public static void cacheResult(
		com.rcs.webform.model.FormItemOption formItemOption) {
		getPersistence().cacheResult(formItemOption);
	}

	/**
	* Caches the form item options in the entity cache if it is enabled.
	*
	* @param formItemOptions the form item options
	*/
	public static void cacheResult(
		java.util.List<com.rcs.webform.model.FormItemOption> formItemOptions) {
		getPersistence().cacheResult(formItemOptions);
	}

	/**
	* Creates a new form item option with the primary key. Does not add the form item option to the database.
	*
	* @param formItemOptionId the primary key for the new form item option
	* @return the new form item option
	*/
	public static com.rcs.webform.model.FormItemOption create(
		long formItemOptionId) {
		return getPersistence().create(formItemOptionId);
	}

	/**
	* Removes the form item option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param formItemOptionId the primary key of the form item option
	* @return the form item option that was removed
	* @throws com.rcs.webform.NoSuchFormItemOptionException if a form item option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormItemOption remove(
		long formItemOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchFormItemOptionException {
		return getPersistence().remove(formItemOptionId);
	}

	public static com.rcs.webform.model.FormItemOption updateImpl(
		com.rcs.webform.model.FormItemOption formItemOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(formItemOption);
	}

	/**
	* Returns the form item option with the primary key or throws a {@link com.rcs.webform.NoSuchFormItemOptionException} if it could not be found.
	*
	* @param formItemOptionId the primary key of the form item option
	* @return the form item option
	* @throws com.rcs.webform.NoSuchFormItemOptionException if a form item option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormItemOption findByPrimaryKey(
		long formItemOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchFormItemOptionException {
		return getPersistence().findByPrimaryKey(formItemOptionId);
	}

	/**
	* Returns the form item option with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param formItemOptionId the primary key of the form item option
	* @return the form item option, or <code>null</code> if a form item option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormItemOption fetchByPrimaryKey(
		long formItemOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(formItemOptionId);
	}

	/**
	* Returns all the form item options.
	*
	* @return the form item options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.webform.model.FormItemOption> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the form item options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormItemOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form item options
	* @param end the upper bound of the range of form item options (not inclusive)
	* @return the range of form item options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.webform.model.FormItemOption> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the form item options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormItemOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form item options
	* @param end the upper bound of the range of form item options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of form item options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.webform.model.FormItemOption> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the form item options from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of form item options.
	*
	* @return the number of form item options
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FormItemOptionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FormItemOptionPersistence)PortletBeanLocatorUtil.locate(com.rcs.webform.service.ClpSerializer.getServletContextName(),
					FormItemOptionPersistence.class.getName());

			ReferenceRegistry.registerReference(FormItemOptionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FormItemOptionPersistence persistence) {
	}

	private static FormItemOptionPersistence _persistence;
}