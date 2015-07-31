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
 * Provides the local service utility for Form. This utility wraps
 * {@link com.rcs.webform.service.impl.FormLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author ryusuf
 * @see FormLocalService
 * @see com.rcs.webform.service.base.FormLocalServiceBaseImpl
 * @see com.rcs.webform.service.impl.FormLocalServiceImpl
 * @generated
 */
public class FormLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rcs.webform.service.impl.FormLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the form to the database. Also notifies the appropriate model listeners.
	*
	* @param form the form
	* @return the form that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.Form addForm(
		com.rcs.webform.model.Form form)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addForm(form);
	}

	/**
	* Creates a new form with the primary key. Does not add the form to the database.
	*
	* @param formId the primary key for the new form
	* @return the new form
	*/
	public static com.rcs.webform.model.Form createForm(long formId) {
		return getService().createForm(formId);
	}

	/**
	* Deletes the form with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param formId the primary key of the form
	* @return the form that was removed
	* @throws PortalException if a form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.Form deleteForm(long formId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteForm(formId);
	}

	/**
	* Deletes the form from the database. Also notifies the appropriate model listeners.
	*
	* @param form the form
	* @return the form that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.Form deleteForm(
		com.rcs.webform.model.Form form)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteForm(form);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.rcs.webform.model.Form fetchForm(long formId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchForm(formId);
	}

	/**
	* Returns the form with the primary key.
	*
	* @param formId the primary key of the form
	* @return the form
	* @throws PortalException if a form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.Form getForm(long formId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getForm(formId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the forms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of forms
	* @param end the upper bound of the range of forms (not inclusive)
	* @return the range of forms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.webform.model.Form> getForms(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getForms(start, end);
	}

	/**
	* Returns the number of forms.
	*
	* @return the number of forms
	* @throws SystemException if a system exception occurred
	*/
	public static int getFormsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFormsCount();
	}

	/**
	* Updates the form in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param form the form
	* @return the form that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.Form updateForm(
		com.rcs.webform.model.Form form)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateForm(form);
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

	public static com.rcs.webform.model.Form add(java.lang.Long formId,
		com.liferay.portal.service.ServiceContext serviceContext,
		java.lang.String title, java.lang.String description,
		boolean useCaptcha, java.lang.String successMessage,
		java.lang.String successUrl, java.lang.String submitLabel) {
		return getService()
				   .add(formId, serviceContext, title, description, useCaptcha,
			successMessage, successUrl, submitLabel);
	}

	public static com.rcs.webform.model.Form save(java.lang.Long formId,
		com.liferay.portal.service.ServiceContext serviceContext,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		boolean useCaptcha,
		java.util.Map<java.util.Locale, java.lang.String> successMessageMap,
		java.lang.String successUrl,
		java.util.Map<java.util.Locale, java.lang.String> submitLabelMap) {
		return getService()
				   .save(formId, serviceContext, titleMap, descriptionMap,
			useCaptcha, successMessageMap, successUrl, submitLabelMap);
	}

	public static com.rcs.webform.model.Form getFormByFormId(long formId) {
		return getService().getFormByFormId(formId);
	}

	public static void clearService() {
		_service = null;
	}

	public static FormLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FormLocalService.class.getName());

			if (invokableLocalService instanceof FormLocalService) {
				_service = (FormLocalService)invokableLocalService;
			}
			else {
				_service = new FormLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(FormLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FormLocalService service) {
	}

	private static FormLocalService _service;
}