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
 * Provides a wrapper for {@link FormItemLocalService}.
 *
 * @author ryusuf
 * @see FormItemLocalService
 * @generated
 */
public class FormItemLocalServiceWrapper implements FormItemLocalService,
	ServiceWrapper<FormItemLocalService> {
	public FormItemLocalServiceWrapper(
		FormItemLocalService formItemLocalService) {
		_formItemLocalService = formItemLocalService;
	}

	/**
	* Adds the form item to the database. Also notifies the appropriate model listeners.
	*
	* @param formItem the form item
	* @return the form item that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.FormItem addFormItem(
		com.rcs.webform.model.FormItem formItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formItemLocalService.addFormItem(formItem);
	}

	/**
	* Creates a new form item with the primary key. Does not add the form item to the database.
	*
	* @param formItemId the primary key for the new form item
	* @return the new form item
	*/
	@Override
	public com.rcs.webform.model.FormItem createFormItem(long formItemId) {
		return _formItemLocalService.createFormItem(formItemId);
	}

	/**
	* Deletes the form item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param formItemId the primary key of the form item
	* @return the form item that was removed
	* @throws PortalException if a form item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.FormItem deleteFormItem(long formItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _formItemLocalService.deleteFormItem(formItemId);
	}

	/**
	* Deletes the form item from the database. Also notifies the appropriate model listeners.
	*
	* @param formItem the form item
	* @return the form item that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.FormItem deleteFormItem(
		com.rcs.webform.model.FormItem formItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formItemLocalService.deleteFormItem(formItem);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _formItemLocalService.dynamicQuery();
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
		return _formItemLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _formItemLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _formItemLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _formItemLocalService.dynamicQueryCount(dynamicQuery);
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
		return _formItemLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.rcs.webform.model.FormItem fetchFormItem(long formItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formItemLocalService.fetchFormItem(formItemId);
	}

	/**
	* Returns the form item with the primary key.
	*
	* @param formItemId the primary key of the form item
	* @return the form item
	* @throws PortalException if a form item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.FormItem getFormItem(long formItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _formItemLocalService.getFormItem(formItemId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _formItemLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the form items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form items
	* @param end the upper bound of the range of form items (not inclusive)
	* @return the range of form items
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rcs.webform.model.FormItem> getFormItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formItemLocalService.getFormItems(start, end);
	}

	/**
	* Returns the number of form items.
	*
	* @return the number of form items
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFormItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formItemLocalService.getFormItemsCount();
	}

	/**
	* Updates the form item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param formItem the form item
	* @return the form item that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.webform.model.FormItem updateFormItem(
		com.rcs.webform.model.FormItem formItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _formItemLocalService.updateFormItem(formItem);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _formItemLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_formItemLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _formItemLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Save Form Item
	*
	* @param formItemId
	* @param formId
	* @param label
	* @param type
	* @param options
	* @param mandatory
	* @param validationRegexValue
	* @param validationType
	* @param errorValidationMessage
	* @param serviceContext
	* @return
	*/
	@Override
	public com.rcs.webform.model.FormItem save(java.lang.Long formItemId,
		java.lang.Long formId,
		java.util.Map<java.util.Locale, java.lang.String> label,
		java.lang.String type,
		java.util.Map<java.util.Locale, java.lang.String> options,
		boolean mandatory, java.lang.String validationRegexValue,
		java.lang.String validationType,
		java.lang.String errorValidationMessage, int order,
		java.util.Map<java.util.Locale, java.lang.String> hintMessage,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _formItemLocalService.save(formItemId, formId, label, type,
			options, mandatory, validationRegexValue, validationType,
			errorValidationMessage, order, hintMessage, serviceContext);
	}

	@Override
	public java.util.List<com.rcs.webform.model.FormItem> getFormItemByFormId(
		long formId) {
		return _formItemLocalService.getFormItemByFormId(formId);
	}

	/**
	* get Form Items
	*
	* @param formId
	* @return
	*/
	@Override
	public java.util.List<com.rcs.webform.model.FormItem> getFormItemsByFormId(
		java.lang.Long formId) {
		return _formItemLocalService.getFormItemsByFormId(formId);
	}

	/**
	* Soft Delete Form Item
	*
	* @param formItemId
	* @param serviceContext
	* @return
	*/
	@Override
	public com.rcs.webform.model.FormItem delete(java.lang.Long formItemId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _formItemLocalService.delete(formItemId, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FormItemLocalService getWrappedFormItemLocalService() {
		return _formItemLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFormItemLocalService(
		FormItemLocalService formItemLocalService) {
		_formItemLocalService = formItemLocalService;
	}

	@Override
	public FormItemLocalService getWrappedService() {
		return _formItemLocalService;
	}

	@Override
	public void setWrappedService(FormItemLocalService formItemLocalService) {
		_formItemLocalService = formItemLocalService;
	}

	private FormItemLocalService _formItemLocalService;
}