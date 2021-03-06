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

package com.rcs.webform.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.rcs.webform.model.FormItemOption;
import com.rcs.webform.service.FormItemOptionLocalService;
import com.rcs.webform.service.persistence.FormItemOptionPersistence;
import com.rcs.webform.service.persistence.FormItemPersistence;
import com.rcs.webform.service.persistence.FormPersistence;
import com.rcs.webform.service.persistence.FormToPorletMapPersistence;
import com.rcs.webform.service.persistence.SubmittedDataPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the form item option local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rcs.webform.service.impl.FormItemOptionLocalServiceImpl}.
 * </p>
 *
 * @author ryusuf
 * @see com.rcs.webform.service.impl.FormItemOptionLocalServiceImpl
 * @see com.rcs.webform.service.FormItemOptionLocalServiceUtil
 * @generated
 */
public abstract class FormItemOptionLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements FormItemOptionLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rcs.webform.service.FormItemOptionLocalServiceUtil} to access the form item option local service.
	 */

	/**
	 * Adds the form item option to the database. Also notifies the appropriate model listeners.
	 *
	 * @param formItemOption the form item option
	 * @return the form item option that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public FormItemOption addFormItemOption(FormItemOption formItemOption)
		throws SystemException {
		formItemOption.setNew(true);

		return formItemOptionPersistence.update(formItemOption);
	}

	/**
	 * Creates a new form item option with the primary key. Does not add the form item option to the database.
	 *
	 * @param formItemOptionId the primary key for the new form item option
	 * @return the new form item option
	 */
	@Override
	public FormItemOption createFormItemOption(long formItemOptionId) {
		return formItemOptionPersistence.create(formItemOptionId);
	}

	/**
	 * Deletes the form item option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formItemOptionId the primary key of the form item option
	 * @return the form item option that was removed
	 * @throws PortalException if a form item option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public FormItemOption deleteFormItemOption(long formItemOptionId)
		throws PortalException, SystemException {
		return formItemOptionPersistence.remove(formItemOptionId);
	}

	/**
	 * Deletes the form item option from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formItemOption the form item option
	 * @return the form item option that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public FormItemOption deleteFormItemOption(FormItemOption formItemOption)
		throws SystemException {
		return formItemOptionPersistence.remove(formItemOption);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(FormItemOption.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return formItemOptionPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return formItemOptionPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return formItemOptionPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return formItemOptionPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return formItemOptionPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public FormItemOption fetchFormItemOption(long formItemOptionId)
		throws SystemException {
		return formItemOptionPersistence.fetchByPrimaryKey(formItemOptionId);
	}

	/**
	 * Returns the form item option with the primary key.
	 *
	 * @param formItemOptionId the primary key of the form item option
	 * @return the form item option
	 * @throws PortalException if a form item option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormItemOption getFormItemOption(long formItemOptionId)
		throws PortalException, SystemException {
		return formItemOptionPersistence.findByPrimaryKey(formItemOptionId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return formItemOptionPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<FormItemOption> getFormItemOptions(int start, int end)
		throws SystemException {
		return formItemOptionPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of form item options.
	 *
	 * @return the number of form item options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getFormItemOptionsCount() throws SystemException {
		return formItemOptionPersistence.countAll();
	}

	/**
	 * Updates the form item option in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param formItemOption the form item option
	 * @return the form item option that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public FormItemOption updateFormItemOption(FormItemOption formItemOption)
		throws SystemException {
		return formItemOptionPersistence.update(formItemOption);
	}

	/**
	 * Returns the form local service.
	 *
	 * @return the form local service
	 */
	public com.rcs.webform.service.FormLocalService getFormLocalService() {
		return formLocalService;
	}

	/**
	 * Sets the form local service.
	 *
	 * @param formLocalService the form local service
	 */
	public void setFormLocalService(
		com.rcs.webform.service.FormLocalService formLocalService) {
		this.formLocalService = formLocalService;
	}

	/**
	 * Returns the form persistence.
	 *
	 * @return the form persistence
	 */
	public FormPersistence getFormPersistence() {
		return formPersistence;
	}

	/**
	 * Sets the form persistence.
	 *
	 * @param formPersistence the form persistence
	 */
	public void setFormPersistence(FormPersistence formPersistence) {
		this.formPersistence = formPersistence;
	}

	/**
	 * Returns the form item local service.
	 *
	 * @return the form item local service
	 */
	public com.rcs.webform.service.FormItemLocalService getFormItemLocalService() {
		return formItemLocalService;
	}

	/**
	 * Sets the form item local service.
	 *
	 * @param formItemLocalService the form item local service
	 */
	public void setFormItemLocalService(
		com.rcs.webform.service.FormItemLocalService formItemLocalService) {
		this.formItemLocalService = formItemLocalService;
	}

	/**
	 * Returns the form item persistence.
	 *
	 * @return the form item persistence
	 */
	public FormItemPersistence getFormItemPersistence() {
		return formItemPersistence;
	}

	/**
	 * Sets the form item persistence.
	 *
	 * @param formItemPersistence the form item persistence
	 */
	public void setFormItemPersistence(FormItemPersistence formItemPersistence) {
		this.formItemPersistence = formItemPersistence;
	}

	/**
	 * Returns the form item option local service.
	 *
	 * @return the form item option local service
	 */
	public com.rcs.webform.service.FormItemOptionLocalService getFormItemOptionLocalService() {
		return formItemOptionLocalService;
	}

	/**
	 * Sets the form item option local service.
	 *
	 * @param formItemOptionLocalService the form item option local service
	 */
	public void setFormItemOptionLocalService(
		com.rcs.webform.service.FormItemOptionLocalService formItemOptionLocalService) {
		this.formItemOptionLocalService = formItemOptionLocalService;
	}

	/**
	 * Returns the form item option persistence.
	 *
	 * @return the form item option persistence
	 */
	public FormItemOptionPersistence getFormItemOptionPersistence() {
		return formItemOptionPersistence;
	}

	/**
	 * Sets the form item option persistence.
	 *
	 * @param formItemOptionPersistence the form item option persistence
	 */
	public void setFormItemOptionPersistence(
		FormItemOptionPersistence formItemOptionPersistence) {
		this.formItemOptionPersistence = formItemOptionPersistence;
	}

	/**
	 * Returns the form to porlet map local service.
	 *
	 * @return the form to porlet map local service
	 */
	public com.rcs.webform.service.FormToPorletMapLocalService getFormToPorletMapLocalService() {
		return formToPorletMapLocalService;
	}

	/**
	 * Sets the form to porlet map local service.
	 *
	 * @param formToPorletMapLocalService the form to porlet map local service
	 */
	public void setFormToPorletMapLocalService(
		com.rcs.webform.service.FormToPorletMapLocalService formToPorletMapLocalService) {
		this.formToPorletMapLocalService = formToPorletMapLocalService;
	}

	/**
	 * Returns the form to porlet map persistence.
	 *
	 * @return the form to porlet map persistence
	 */
	public FormToPorletMapPersistence getFormToPorletMapPersistence() {
		return formToPorletMapPersistence;
	}

	/**
	 * Sets the form to porlet map persistence.
	 *
	 * @param formToPorletMapPersistence the form to porlet map persistence
	 */
	public void setFormToPorletMapPersistence(
		FormToPorletMapPersistence formToPorletMapPersistence) {
		this.formToPorletMapPersistence = formToPorletMapPersistence;
	}

	/**
	 * Returns the submitted data local service.
	 *
	 * @return the submitted data local service
	 */
	public com.rcs.webform.service.SubmittedDataLocalService getSubmittedDataLocalService() {
		return submittedDataLocalService;
	}

	/**
	 * Sets the submitted data local service.
	 *
	 * @param submittedDataLocalService the submitted data local service
	 */
	public void setSubmittedDataLocalService(
		com.rcs.webform.service.SubmittedDataLocalService submittedDataLocalService) {
		this.submittedDataLocalService = submittedDataLocalService;
	}

	/**
	 * Returns the submitted data persistence.
	 *
	 * @return the submitted data persistence
	 */
	public SubmittedDataPersistence getSubmittedDataPersistence() {
		return submittedDataPersistence;
	}

	/**
	 * Sets the submitted data persistence.
	 *
	 * @param submittedDataPersistence the submitted data persistence
	 */
	public void setSubmittedDataPersistence(
		SubmittedDataPersistence submittedDataPersistence) {
		this.submittedDataPersistence = submittedDataPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.rcs.webform.model.FormItemOption",
			formItemOptionLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.rcs.webform.model.FormItemOption");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return FormItemOption.class;
	}

	protected String getModelClassName() {
		return FormItemOption.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = formItemOptionPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rcs.webform.service.FormLocalService.class)
	protected com.rcs.webform.service.FormLocalService formLocalService;
	@BeanReference(type = FormPersistence.class)
	protected FormPersistence formPersistence;
	@BeanReference(type = com.rcs.webform.service.FormItemLocalService.class)
	protected com.rcs.webform.service.FormItemLocalService formItemLocalService;
	@BeanReference(type = FormItemPersistence.class)
	protected FormItemPersistence formItemPersistence;
	@BeanReference(type = com.rcs.webform.service.FormItemOptionLocalService.class)
	protected com.rcs.webform.service.FormItemOptionLocalService formItemOptionLocalService;
	@BeanReference(type = FormItemOptionPersistence.class)
	protected FormItemOptionPersistence formItemOptionPersistence;
	@BeanReference(type = com.rcs.webform.service.FormToPorletMapLocalService.class)
	protected com.rcs.webform.service.FormToPorletMapLocalService formToPorletMapLocalService;
	@BeanReference(type = FormToPorletMapPersistence.class)
	protected FormToPorletMapPersistence formToPorletMapPersistence;
	@BeanReference(type = com.rcs.webform.service.SubmittedDataLocalService.class)
	protected com.rcs.webform.service.SubmittedDataLocalService submittedDataLocalService;
	@BeanReference(type = SubmittedDataPersistence.class)
	protected SubmittedDataPersistence submittedDataPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private FormItemOptionLocalServiceClpInvoker _clpInvoker = new FormItemOptionLocalServiceClpInvoker();
}