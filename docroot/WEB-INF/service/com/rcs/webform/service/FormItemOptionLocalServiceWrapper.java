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

package com.rcs.webform.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FormItemOptionLocalService}.
 *
 * @author ryusuf
 * @see FormItemOptionLocalService
 * @generated
 */
public class FormItemOptionLocalServiceWrapper
	implements FormItemOptionLocalService,
		ServiceWrapper<FormItemOptionLocalService> {
	public FormItemOptionLocalServiceWrapper(
		FormItemOptionLocalService formItemOptionLocalService) {
		_formItemOptionLocalService = formItemOptionLocalService;
	}

	/**
	* Adds the form item option to the database. Also notifies the appropriate model listeners.
	*
	* @param formItemOption the form item option
	* @return the form item option that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.FormItemOption addFormItemOption(
		com.rcs.webform.model.FormItemOption formItemOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formItemOptionLocalService.addFormItemOption(formItemOption);
	}

	/**
	* Creates a new form item option with the primary key. Does not add the form item option to the database.
	*
	* @param formitemoptionId the primary key for the new form item option
	* @return the new form item option
	*/
	@Override
	public com.rcs.webform.model.FormItemOption createFormItemOption(
		long formitemoptionId) {
		return _formItemOptionLocalService.createFormItemOption(formitemoptionId);
	}

	/**
	* Deletes the form item option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param formitemoptionId the primary key of the form item option
	* @return the form item option that was removed
	* @throws PortalException if a form item option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.FormItemOption deleteFormItemOption(
		long formitemoptionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _formItemOptionLocalService.deleteFormItemOption(formitemoptionId);
	}

	/**
	* Deletes the form item option from the database. Also notifies the appropriate model listeners.
	*
	* @param formItemOption the form item option
	* @return the form item option that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.FormItemOption deleteFormItemOption(
		com.rcs.webform.model.FormItemOption formItemOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formItemOptionLocalService.deleteFormItemOption(formItemOption);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _formItemOptionLocalService.dynamicQuery();
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
		return _formItemOptionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormItemOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _formItemOptionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormItemOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _formItemOptionLocalService.dynamicQuery(dynamicQuery, start,
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
		return _formItemOptionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _formItemOptionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rcs.webform.model.FormItemOption fetchFormItemOption(
		long formitemoptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formItemOptionLocalService.fetchFormItemOption(formitemoptionId);
	}

	/**
	* Returns the form item option with the primary key.
	*
	* @param formitemoptionId the primary key of the form item option
	* @return the form item option
	* @throws PortalException if a form item option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.FormItemOption getFormItemOption(
		long formitemoptionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _formItemOptionLocalService.getFormItemOption(formitemoptionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _formItemOptionLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.rcs.webform.model.FormItemOption> getFormItemOptions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formItemOptionLocalService.getFormItemOptions(start, end);
	}

	/**
	* Returns the number of form item options.
	*
	* @return the number of form item options
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFormItemOptionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formItemOptionLocalService.getFormItemOptionsCount();
	}

	/**
	* Updates the form item option in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param formItemOption the form item option
	* @return the form item option that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.FormItemOption updateFormItemOption(
		com.rcs.webform.model.FormItemOption formItemOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formItemOptionLocalService.updateFormItemOption(formItemOption);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _formItemOptionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_formItemOptionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _formItemOptionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Save Form Item Option
	*
	* @param formItemOptionId
	* @param formItemId
	* @param optionLabel
	* @param optionValue
	* @param serviceContext
	* @return
	*/
	@Override
	public com.rcs.webform.model.FormItemOption save(
		java.lang.Long formItemOptionId, java.lang.Long formItemId,
		java.util.Map<java.util.Locale, java.lang.String> optionLabel,
		java.util.Map<java.util.Locale, java.lang.String> optionValue,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _formItemOptionLocalService.save(formItemOptionId, formItemId,
			optionLabel, optionValue, serviceContext);
	}

	/**
	* get Form Item Options
	*
	* @param formItemId
	* @return
	*/
	@Override
	public java.util.List<com.rcs.webform.model.FormItemOption> getFormItemOptionsByFormItemId(
		java.lang.Long formItemId) {
		return _formItemOptionLocalService.getFormItemOptionsByFormItemId(formItemId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FormItemOptionLocalService getWrappedFormItemOptionLocalService() {
		return _formItemOptionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFormItemOptionLocalService(
		FormItemOptionLocalService formItemOptionLocalService) {
		_formItemOptionLocalService = formItemOptionLocalService;
	}

	@Override
	public FormItemOptionLocalService getWrappedService() {
		return _formItemOptionLocalService;
	}

	@Override
	public void setWrappedService(
		FormItemOptionLocalService formItemOptionLocalService) {
		_formItemOptionLocalService = formItemOptionLocalService;
	}

	private FormItemOptionLocalService _formItemOptionLocalService;
}