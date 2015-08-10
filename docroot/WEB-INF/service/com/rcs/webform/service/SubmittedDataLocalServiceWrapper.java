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

package com.rcs.webform.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SubmittedDataLocalService}.
 *
 * @author ryusuf
 * @see SubmittedDataLocalService
 * @generated
 */
public class SubmittedDataLocalServiceWrapper
	implements SubmittedDataLocalService,
		ServiceWrapper<SubmittedDataLocalService> {
	public SubmittedDataLocalServiceWrapper(
		SubmittedDataLocalService submittedDataLocalService) {
		_submittedDataLocalService = submittedDataLocalService;
	}

	/**
	* Adds the submitted data to the database. Also notifies the appropriate model listeners.
	*
	* @param submittedData the submitted data
	* @return the submitted data that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.SubmittedData addSubmittedData(
		com.rcs.webform.model.SubmittedData submittedData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submittedDataLocalService.addSubmittedData(submittedData);
	}

	/**
	* Creates a new submitted data with the primary key. Does not add the submitted data to the database.
	*
	* @param submittedDataPK the primary key for the new submitted data
	* @return the new submitted data
	*/
	@Override
	public com.rcs.webform.model.SubmittedData createSubmittedData(
		com.rcs.webform.service.persistence.SubmittedDataPK submittedDataPK) {
		return _submittedDataLocalService.createSubmittedData(submittedDataPK);
	}

	/**
	* Deletes the submitted data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submittedDataPK the primary key of the submitted data
	* @return the submitted data that was removed
	* @throws PortalException if a submitted data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.SubmittedData deleteSubmittedData(
		com.rcs.webform.service.persistence.SubmittedDataPK submittedDataPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _submittedDataLocalService.deleteSubmittedData(submittedDataPK);
	}

	/**
	* Deletes the submitted data from the database. Also notifies the appropriate model listeners.
	*
	* @param submittedData the submitted data
	* @return the submitted data that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.SubmittedData deleteSubmittedData(
		com.rcs.webform.model.SubmittedData submittedData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submittedDataLocalService.deleteSubmittedData(submittedData);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _submittedDataLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submittedDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.SubmittedDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _submittedDataLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.SubmittedDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submittedDataLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submittedDataLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submittedDataLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rcs.webform.model.SubmittedData fetchSubmittedData(
		com.rcs.webform.service.persistence.SubmittedDataPK submittedDataPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submittedDataLocalService.fetchSubmittedData(submittedDataPK);
	}

	/**
	* Returns the submitted data with the primary key.
	*
	* @param submittedDataPK the primary key of the submitted data
	* @return the submitted data
	* @throws PortalException if a submitted data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.SubmittedData getSubmittedData(
		com.rcs.webform.service.persistence.SubmittedDataPK submittedDataPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _submittedDataLocalService.getSubmittedData(submittedDataPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _submittedDataLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.rcs.webform.model.SubmittedData> getSubmittedDatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submittedDataLocalService.getSubmittedDatas(start, end);
	}

	/**
	* Returns the number of submitted datas.
	*
	* @return the number of submitted datas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSubmittedDatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submittedDataLocalService.getSubmittedDatasCount();
	}

	/**
	* Updates the submitted data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param submittedData the submitted data
	* @return the submitted data that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.SubmittedData updateSubmittedData(
		com.rcs.webform.model.SubmittedData submittedData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submittedDataLocalService.updateSubmittedData(submittedData);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _submittedDataLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_submittedDataLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _submittedDataLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.rcs.webform.model.SubmittedData> getSubmittedDataByForm(
		java.lang.Long formId) {
		return _submittedDataLocalService.getSubmittedDataByForm(formId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SubmittedDataLocalService getWrappedSubmittedDataLocalService() {
		return _submittedDataLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSubmittedDataLocalService(
		SubmittedDataLocalService submittedDataLocalService) {
		_submittedDataLocalService = submittedDataLocalService;
	}

	@Override
	public SubmittedDataLocalService getWrappedService() {
		return _submittedDataLocalService;
	}

	@Override
	public void setWrappedService(
		SubmittedDataLocalService submittedDataLocalService) {
		_submittedDataLocalService = submittedDataLocalService;
	}

	private SubmittedDataLocalService _submittedDataLocalService;
}