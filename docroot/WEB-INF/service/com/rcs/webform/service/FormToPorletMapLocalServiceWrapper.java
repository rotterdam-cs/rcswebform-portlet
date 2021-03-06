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
 * Provides a wrapper for {@link FormToPorletMapLocalService}.
 *
 * @author ryusuf
 * @see FormToPorletMapLocalService
 * @generated
 */
public class FormToPorletMapLocalServiceWrapper
	implements FormToPorletMapLocalService,
		ServiceWrapper<FormToPorletMapLocalService> {
	public FormToPorletMapLocalServiceWrapper(
		FormToPorletMapLocalService formToPorletMapLocalService) {
		_formToPorletMapLocalService = formToPorletMapLocalService;
	}

	/**
	* Adds the form to porlet map to the database. Also notifies the appropriate model listeners.
	*
	* @param formToPorletMap the form to porlet map
	* @return the form to porlet map that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.FormToPorletMap addFormToPorletMap(
		com.rcs.webform.model.FormToPorletMap formToPorletMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formToPorletMapLocalService.addFormToPorletMap(formToPorletMap);
	}

	/**
	* Creates a new form to porlet map with the primary key. Does not add the form to porlet map to the database.
	*
	* @param formToPorletMapId the primary key for the new form to porlet map
	* @return the new form to porlet map
	*/
	@Override
	public com.rcs.webform.model.FormToPorletMap createFormToPorletMap(
		long formToPorletMapId) {
		return _formToPorletMapLocalService.createFormToPorletMap(formToPorletMapId);
	}

	/**
	* Deletes the form to porlet map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param formToPorletMapId the primary key of the form to porlet map
	* @return the form to porlet map that was removed
	* @throws PortalException if a form to porlet map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.FormToPorletMap deleteFormToPorletMap(
		long formToPorletMapId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _formToPorletMapLocalService.deleteFormToPorletMap(formToPorletMapId);
	}

	/**
	* Deletes the form to porlet map from the database. Also notifies the appropriate model listeners.
	*
	* @param formToPorletMap the form to porlet map
	* @return the form to porlet map that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.FormToPorletMap deleteFormToPorletMap(
		com.rcs.webform.model.FormToPorletMap formToPorletMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formToPorletMapLocalService.deleteFormToPorletMap(formToPorletMap);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _formToPorletMapLocalService.dynamicQuery();
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
		return _formToPorletMapLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormToPorletMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _formToPorletMapLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormToPorletMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _formToPorletMapLocalService.dynamicQuery(dynamicQuery, start,
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
		return _formToPorletMapLocalService.dynamicQueryCount(dynamicQuery);
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
		return _formToPorletMapLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rcs.webform.model.FormToPorletMap fetchFormToPorletMap(
		long formToPorletMapId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formToPorletMapLocalService.fetchFormToPorletMap(formToPorletMapId);
	}

	/**
	* Returns the form to porlet map with the primary key.
	*
	* @param formToPorletMapId the primary key of the form to porlet map
	* @return the form to porlet map
	* @throws PortalException if a form to porlet map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.FormToPorletMap getFormToPorletMap(
		long formToPorletMapId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _formToPorletMapLocalService.getFormToPorletMap(formToPorletMapId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _formToPorletMapLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.rcs.webform.model.FormToPorletMap> getFormToPorletMaps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formToPorletMapLocalService.getFormToPorletMaps(start, end);
	}

	/**
	* Returns the number of form to porlet maps.
	*
	* @return the number of form to porlet maps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFormToPorletMapsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formToPorletMapLocalService.getFormToPorletMapsCount();
	}

	/**
	* Updates the form to porlet map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param formToPorletMap the form to porlet map
	* @return the form to porlet map that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.FormToPorletMap updateFormToPorletMap(
		com.rcs.webform.model.FormToPorletMap formToPorletMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formToPorletMapLocalService.updateFormToPorletMap(formToPorletMap);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _formToPorletMapLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_formToPorletMapLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _formToPorletMapLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.rcs.webform.model.FormToPorletMap getFormToPortletMapByPortletId(
		java.lang.String portletId) {
		return _formToPorletMapLocalService.getFormToPortletMapByPortletId(portletId);
	}

	@Override
	public com.rcs.webform.model.FormToPorletMap save(
		java.lang.Long formToPortletId, java.lang.String namespace,
		java.lang.Long formId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _formToPorletMapLocalService.save(formToPortletId, namespace,
			formId, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FormToPorletMapLocalService getWrappedFormToPorletMapLocalService() {
		return _formToPorletMapLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFormToPorletMapLocalService(
		FormToPorletMapLocalService formToPorletMapLocalService) {
		_formToPorletMapLocalService = formToPorletMapLocalService;
	}

	@Override
	public FormToPorletMapLocalService getWrappedService() {
		return _formToPorletMapLocalService;
	}

	@Override
	public void setWrappedService(
		FormToPorletMapLocalService formToPorletMapLocalService) {
		_formToPorletMapLocalService = formToPorletMapLocalService;
	}

	private FormToPorletMapLocalService _formToPorletMapLocalService;
}