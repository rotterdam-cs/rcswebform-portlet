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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for FormItem. This utility wraps
 * {@link com.rcs.webform.service.impl.FormItemLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author ryusuf
 * @see FormItemLocalService
 * @see com.rcs.webform.service.base.FormItemLocalServiceBaseImpl
 * @see com.rcs.webform.service.impl.FormItemLocalServiceImpl
 * @generated
 */
public class FormItemLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rcs.webform.service.impl.FormItemLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the form item to the database. Also notifies the appropriate model listeners.
	*
	* @param formItem the form item
	* @return the form item that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormItem addFormItem(
		com.rcs.webform.model.FormItem formItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFormItem(formItem);
	}

	/**
	* Creates a new form item with the primary key. Does not add the form item to the database.
	*
	* @param formItemId the primary key for the new form item
	* @return the new form item
	*/
	public static com.rcs.webform.model.FormItem createFormItem(long formItemId) {
		return getService().createFormItem(formItemId);
	}

	/**
	* Deletes the form item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param formItemId the primary key of the form item
	* @return the form item that was removed
	* @throws PortalException if a form item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormItem deleteFormItem(long formItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFormItem(formItemId);
	}

	/**
	* Deletes the form item from the database. Also notifies the appropriate model listeners.
	*
	* @param formItem the form item
	* @return the form item that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormItem deleteFormItem(
		com.rcs.webform.model.FormItem formItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFormItem(formItem);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.rcs.webform.model.FormItem fetchFormItem(long formItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFormItem(formItemId);
	}

	/**
	* Returns the form item with the primary key.
	*
	* @param formItemId the primary key of the form item
	* @return the form item
	* @throws PortalException if a form item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormItem getFormItem(long formItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFormItem(formItemId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.rcs.webform.model.FormItem> getFormItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFormItems(start, end);
	}

	/**
	* Returns the number of form items.
	*
	* @return the number of form items
	* @throws SystemException if a system exception occurred
	*/
	public static int getFormItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFormItemsCount();
	}

	/**
	* Updates the form item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param formItem the form item
	* @return the form item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormItem updateFormItem(
		com.rcs.webform.model.FormItem formItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFormItem(formItem);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
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
	public static com.rcs.webform.model.FormItem save(
		java.lang.Long formItemId, java.lang.Long formId,
		java.util.Map<java.util.Locale, java.lang.String> label,
		java.lang.String type, java.lang.String optionKeys,
		java.util.Map<java.util.Locale, java.lang.String> optionValues,
		boolean mandatory, java.lang.String validationRegexValue,
		java.lang.String validationType,
		java.lang.String errorValidationMessage, int order, int maxLength,
		java.util.Map<java.util.Locale, java.lang.String> hintMessage,
		com.liferay.portal.service.ServiceContext serviceContext,
		java.lang.String formItemAttrClass, java.lang.String labelAttrClass,
		java.lang.String inputAttrClass) {
		return getService()
				   .save(formItemId, formId, label, type, optionKeys,
			optionValues, mandatory, validationRegexValue, validationType,
			errorValidationMessage, order, maxLength, hintMessage,
			serviceContext, formItemAttrClass, labelAttrClass, inputAttrClass);
	}

	public static java.util.List<com.rcs.webform.model.FormItem> getFormItemByFormId(
		long formId) {
		return getService().getFormItemByFormId(formId);
	}

	/**
	* get Form Items
	*
	* @param formId
	* @return
	*/
	public static java.util.List<com.rcs.webform.model.FormItem> getFormItemsByFormId(
		java.lang.Long formId) {
		return getService().getFormItemsByFormId(formId);
	}

	/**
	* Soft Delete Form Item
	*
	* @param formItemId
	* @param serviceContext
	* @return
	*/
	public static com.rcs.webform.model.FormItem delete(
		java.lang.Long formItemId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().delete(formItemId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static FormItemLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FormItemLocalService.class.getName());

			if (invokableLocalService instanceof FormItemLocalService) {
				_service = (FormItemLocalService)invokableLocalService;
			}
			else {
				_service = new FormItemLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(FormItemLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FormItemLocalService service) {
	}

	private static FormItemLocalService _service;
}