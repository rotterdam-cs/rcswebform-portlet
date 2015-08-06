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

import com.rcs.webform.model.SubmittedData;

/**
 * The persistence interface for the submitted data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ryusuf
 * @see SubmittedDataPersistenceImpl
 * @see SubmittedDataUtil
 * @generated
 */
public interface SubmittedDataPersistence extends BasePersistence<SubmittedData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubmittedDataUtil} to access the submitted data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the submitted data in the entity cache if it is enabled.
	*
	* @param submittedData the submitted data
	*/
	public void cacheResult(com.rcs.webform.model.SubmittedData submittedData);

	/**
	* Caches the submitted datas in the entity cache if it is enabled.
	*
	* @param submittedDatas the submitted datas
	*/
	public void cacheResult(
		java.util.List<com.rcs.webform.model.SubmittedData> submittedDatas);

	/**
	* Creates a new submitted data with the primary key. Does not add the submitted data to the database.
	*
	* @param submittedDataPK the primary key for the new submitted data
	* @return the new submitted data
	*/
	public com.rcs.webform.model.SubmittedData create(
		com.rcs.webform.service.persistence.SubmittedDataPK submittedDataPK);

	/**
	* Removes the submitted data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submittedDataPK the primary key of the submitted data
	* @return the submitted data that was removed
	* @throws com.rcs.webform.NoSuchSubmittedDataException if a submitted data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.webform.model.SubmittedData remove(
		com.rcs.webform.service.persistence.SubmittedDataPK submittedDataPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchSubmittedDataException;

	public com.rcs.webform.model.SubmittedData updateImpl(
		com.rcs.webform.model.SubmittedData submittedData)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the submitted data with the primary key or throws a {@link com.rcs.webform.NoSuchSubmittedDataException} if it could not be found.
	*
	* @param submittedDataPK the primary key of the submitted data
	* @return the submitted data
	* @throws com.rcs.webform.NoSuchSubmittedDataException if a submitted data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.webform.model.SubmittedData findByPrimaryKey(
		com.rcs.webform.service.persistence.SubmittedDataPK submittedDataPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchSubmittedDataException;

	/**
	* Returns the submitted data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param submittedDataPK the primary key of the submitted data
	* @return the submitted data, or <code>null</code> if a submitted data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.webform.model.SubmittedData fetchByPrimaryKey(
		com.rcs.webform.service.persistence.SubmittedDataPK submittedDataPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the submitted datas.
	*
	* @return the submitted datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.webform.model.SubmittedData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rcs.webform.model.SubmittedData> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rcs.webform.model.SubmittedData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the submitted datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of submitted datas.
	*
	* @return the number of submitted datas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}