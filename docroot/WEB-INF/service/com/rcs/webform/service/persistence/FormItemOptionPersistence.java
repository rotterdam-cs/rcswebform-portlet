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

import com.liferay.portal.service.persistence.BasePersistence;

import com.rcs.webform.model.FormItemOption;

/**
 * The persistence interface for the form item option service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ryusuf
 * @see FormItemOptionPersistenceImpl
 * @see FormItemOptionUtil
 * @generated
 */
public interface FormItemOptionPersistence extends BasePersistence<FormItemOption> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FormItemOptionUtil} to access the form item option persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the form item option in the entity cache if it is enabled.
	*
	* @param formItemOption the form item option
	*/
	public void cacheResult(com.rcs.webform.model.FormItemOption formItemOption);

	/**
	* Caches the form item options in the entity cache if it is enabled.
	*
	* @param formItemOptions the form item options
	*/
	public void cacheResult(
		java.util.List<com.rcs.webform.model.FormItemOption> formItemOptions);

	/**
	* Creates a new form item option with the primary key. Does not add the form item option to the database.
	*
	* @param formitemoptionId the primary key for the new form item option
	* @return the new form item option
	*/
	public com.rcs.webform.model.FormItemOption create(long formitemoptionId);

	/**
	* Removes the form item option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param formitemoptionId the primary key of the form item option
	* @return the form item option that was removed
	* @throws com.rcs.webform.NoSuchFormItemOptionException if a form item option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.webform.model.FormItemOption remove(long formitemoptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchFormItemOptionException;

	public com.rcs.webform.model.FormItemOption updateImpl(
		com.rcs.webform.model.FormItemOption formItemOption)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the form item option with the primary key or throws a {@link com.rcs.webform.NoSuchFormItemOptionException} if it could not be found.
	*
	* @param formitemoptionId the primary key of the form item option
	* @return the form item option
	* @throws com.rcs.webform.NoSuchFormItemOptionException if a form item option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.webform.model.FormItemOption findByPrimaryKey(
		long formitemoptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchFormItemOptionException;

	/**
	* Returns the form item option with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param formitemoptionId the primary key of the form item option
	* @return the form item option, or <code>null</code> if a form item option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.webform.model.FormItemOption fetchByPrimaryKey(
		long formitemoptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the form item options.
	*
	* @return the form item options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.webform.model.FormItemOption> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rcs.webform.model.FormItemOption> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rcs.webform.model.FormItemOption> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the form item options from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of form item options.
	*
	* @return the number of form item options
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}