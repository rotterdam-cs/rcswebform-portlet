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

package com.rcs.dbService.service.base;

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

import com.rcs.dbService.model.WebformRow;
import com.rcs.dbService.service.WebformRowLocalService;
import com.rcs.dbService.service.persistence.WebformColumnPersistence;
import com.rcs.dbService.service.persistence.WebformRowPersistence;
import com.rcs.dbService.service.persistence.WebformTablePersistence;
import com.rcs.dbService.service.persistence.WebformValuePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the webform row local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rcs.dbService.service.impl.WebformRowLocalServiceImpl}.
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see com.rcs.dbService.service.impl.WebformRowLocalServiceImpl
 * @see com.rcs.dbService.service.WebformRowLocalServiceUtil
 * @generated
 */
public abstract class WebformRowLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements WebformRowLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rcs.dbService.service.WebformRowLocalServiceUtil} to access the webform row local service.
	 */

	/**
	 * Adds the webform row to the database. Also notifies the appropriate model listeners.
	 *
	 * @param webformRow the webform row
	 * @return the webform row that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public WebformRow addWebformRow(WebformRow webformRow)
		throws SystemException {
		webformRow.setNew(true);

		return webformRowPersistence.update(webformRow);
	}

	/**
	 * Creates a new webform row with the primary key. Does not add the webform row to the database.
	 *
	 * @param webformRowId the primary key for the new webform row
	 * @return the new webform row
	 */
	@Override
	public WebformRow createWebformRow(long webformRowId) {
		return webformRowPersistence.create(webformRowId);
	}

	/**
	 * Deletes the webform row with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param webformRowId the primary key of the webform row
	 * @return the webform row that was removed
	 * @throws PortalException if a webform row with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public WebformRow deleteWebformRow(long webformRowId)
		throws PortalException, SystemException {
		return webformRowPersistence.remove(webformRowId);
	}

	/**
	 * Deletes the webform row from the database. Also notifies the appropriate model listeners.
	 *
	 * @param webformRow the webform row
	 * @return the webform row that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public WebformRow deleteWebformRow(WebformRow webformRow)
		throws SystemException {
		return webformRowPersistence.remove(webformRow);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(WebformRow.class,
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
		return webformRowPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.WebformRowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return webformRowPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.WebformRowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return webformRowPersistence.findWithDynamicQuery(dynamicQuery, start,
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return webformRowPersistence.countWithDynamicQuery(dynamicQuery);
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
		return webformRowPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public WebformRow fetchWebformRow(long webformRowId)
		throws SystemException {
		return webformRowPersistence.fetchByPrimaryKey(webformRowId);
	}

	/**
	 * Returns the webform row with the primary key.
	 *
	 * @param webformRowId the primary key of the webform row
	 * @return the webform row
	 * @throws PortalException if a webform row with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformRow getWebformRow(long webformRowId)
		throws PortalException, SystemException {
		return webformRowPersistence.findByPrimaryKey(webformRowId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return webformRowPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the webform rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.WebformRowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of webform rows
	 * @param end the upper bound of the range of webform rows (not inclusive)
	 * @return the range of webform rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebformRow> getWebformRows(int start, int end)
		throws SystemException {
		return webformRowPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of webform rows.
	 *
	 * @return the number of webform rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getWebformRowsCount() throws SystemException {
		return webformRowPersistence.countAll();
	}

	/**
	 * Updates the webform row in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param webformRow the webform row
	 * @return the webform row that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public WebformRow updateWebformRow(WebformRow webformRow)
		throws SystemException {
		return webformRowPersistence.update(webformRow);
	}

	/**
	 * Returns the webform column local service.
	 *
	 * @return the webform column local service
	 */
	public com.rcs.dbService.service.WebformColumnLocalService getWebformColumnLocalService() {
		return webformColumnLocalService;
	}

	/**
	 * Sets the webform column local service.
	 *
	 * @param webformColumnLocalService the webform column local service
	 */
	public void setWebformColumnLocalService(
		com.rcs.dbService.service.WebformColumnLocalService webformColumnLocalService) {
		this.webformColumnLocalService = webformColumnLocalService;
	}

	/**
	 * Returns the webform column remote service.
	 *
	 * @return the webform column remote service
	 */
	public com.rcs.dbService.service.WebformColumnService getWebformColumnService() {
		return webformColumnService;
	}

	/**
	 * Sets the webform column remote service.
	 *
	 * @param webformColumnService the webform column remote service
	 */
	public void setWebformColumnService(
		com.rcs.dbService.service.WebformColumnService webformColumnService) {
		this.webformColumnService = webformColumnService;
	}

	/**
	 * Returns the webform column persistence.
	 *
	 * @return the webform column persistence
	 */
	public WebformColumnPersistence getWebformColumnPersistence() {
		return webformColumnPersistence;
	}

	/**
	 * Sets the webform column persistence.
	 *
	 * @param webformColumnPersistence the webform column persistence
	 */
	public void setWebformColumnPersistence(
		WebformColumnPersistence webformColumnPersistence) {
		this.webformColumnPersistence = webformColumnPersistence;
	}

	/**
	 * Returns the webform row local service.
	 *
	 * @return the webform row local service
	 */
	public com.rcs.dbService.service.WebformRowLocalService getWebformRowLocalService() {
		return webformRowLocalService;
	}

	/**
	 * Sets the webform row local service.
	 *
	 * @param webformRowLocalService the webform row local service
	 */
	public void setWebformRowLocalService(
		com.rcs.dbService.service.WebformRowLocalService webformRowLocalService) {
		this.webformRowLocalService = webformRowLocalService;
	}

	/**
	 * Returns the webform row remote service.
	 *
	 * @return the webform row remote service
	 */
	public com.rcs.dbService.service.WebformRowService getWebformRowService() {
		return webformRowService;
	}

	/**
	 * Sets the webform row remote service.
	 *
	 * @param webformRowService the webform row remote service
	 */
	public void setWebformRowService(
		com.rcs.dbService.service.WebformRowService webformRowService) {
		this.webformRowService = webformRowService;
	}

	/**
	 * Returns the webform row persistence.
	 *
	 * @return the webform row persistence
	 */
	public WebformRowPersistence getWebformRowPersistence() {
		return webformRowPersistence;
	}

	/**
	 * Sets the webform row persistence.
	 *
	 * @param webformRowPersistence the webform row persistence
	 */
	public void setWebformRowPersistence(
		WebformRowPersistence webformRowPersistence) {
		this.webformRowPersistence = webformRowPersistence;
	}

	/**
	 * Returns the webform table local service.
	 *
	 * @return the webform table local service
	 */
	public com.rcs.dbService.service.WebformTableLocalService getWebformTableLocalService() {
		return webformTableLocalService;
	}

	/**
	 * Sets the webform table local service.
	 *
	 * @param webformTableLocalService the webform table local service
	 */
	public void setWebformTableLocalService(
		com.rcs.dbService.service.WebformTableLocalService webformTableLocalService) {
		this.webformTableLocalService = webformTableLocalService;
	}

	/**
	 * Returns the webform table remote service.
	 *
	 * @return the webform table remote service
	 */
	public com.rcs.dbService.service.WebformTableService getWebformTableService() {
		return webformTableService;
	}

	/**
	 * Sets the webform table remote service.
	 *
	 * @param webformTableService the webform table remote service
	 */
	public void setWebformTableService(
		com.rcs.dbService.service.WebformTableService webformTableService) {
		this.webformTableService = webformTableService;
	}

	/**
	 * Returns the webform table persistence.
	 *
	 * @return the webform table persistence
	 */
	public WebformTablePersistence getWebformTablePersistence() {
		return webformTablePersistence;
	}

	/**
	 * Sets the webform table persistence.
	 *
	 * @param webformTablePersistence the webform table persistence
	 */
	public void setWebformTablePersistence(
		WebformTablePersistence webformTablePersistence) {
		this.webformTablePersistence = webformTablePersistence;
	}

	/**
	 * Returns the webform value remote service.
	 *
	 * @return the webform value remote service
	 */
	public com.rcs.dbService.service.WebformValueService getWebformValueService() {
		return webformValueService;
	}

	/**
	 * Sets the webform value remote service.
	 *
	 * @param webformValueService the webform value remote service
	 */
	public void setWebformValueService(
		com.rcs.dbService.service.WebformValueService webformValueService) {
		this.webformValueService = webformValueService;
	}

	/**
	 * Returns the webform value persistence.
	 *
	 * @return the webform value persistence
	 */
	public WebformValuePersistence getWebformValuePersistence() {
		return webformValuePersistence;
	}

	/**
	 * Sets the webform value persistence.
	 *
	 * @param webformValuePersistence the webform value persistence
	 */
	public void setWebformValuePersistence(
		WebformValuePersistence webformValuePersistence) {
		this.webformValuePersistence = webformValuePersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("com.rcs.dbService.model.WebformRow",
			webformRowLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.rcs.dbService.model.WebformRow");
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
		return WebformRow.class;
	}

	protected String getModelClassName() {
		return WebformRow.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = webformRowPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rcs.dbService.service.WebformColumnLocalService.class)
	protected com.rcs.dbService.service.WebformColumnLocalService webformColumnLocalService;
	@BeanReference(type = com.rcs.dbService.service.WebformColumnService.class)
	protected com.rcs.dbService.service.WebformColumnService webformColumnService;
	@BeanReference(type = WebformColumnPersistence.class)
	protected WebformColumnPersistence webformColumnPersistence;
	@BeanReference(type = com.rcs.dbService.service.WebformRowLocalService.class)
	protected com.rcs.dbService.service.WebformRowLocalService webformRowLocalService;
	@BeanReference(type = com.rcs.dbService.service.WebformRowService.class)
	protected com.rcs.dbService.service.WebformRowService webformRowService;
	@BeanReference(type = WebformRowPersistence.class)
	protected WebformRowPersistence webformRowPersistence;
	@BeanReference(type = com.rcs.dbService.service.WebformTableLocalService.class)
	protected com.rcs.dbService.service.WebformTableLocalService webformTableLocalService;
	@BeanReference(type = com.rcs.dbService.service.WebformTableService.class)
	protected com.rcs.dbService.service.WebformTableService webformTableService;
	@BeanReference(type = WebformTablePersistence.class)
	protected WebformTablePersistence webformTablePersistence;
	@BeanReference(type = com.rcs.dbService.service.WebformValueService.class)
	protected com.rcs.dbService.service.WebformValueService webformValueService;
	@BeanReference(type = WebformValuePersistence.class)
	protected WebformValuePersistence webformValuePersistence;
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
	private WebformRowLocalServiceClpInvoker _clpInvoker = new WebformRowLocalServiceClpInvoker();
}