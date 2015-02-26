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

package com.rcs.dbservice.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.rcs.dbservice.model.WebformColumn;
import com.rcs.dbservice.service.WebformColumnService;
import com.rcs.dbservice.service.persistence.WebformColumnPersistence;
import com.rcs.dbservice.service.persistence.WebformRowPersistence;
import com.rcs.dbservice.service.persistence.WebformTablePersistence;
import com.rcs.dbservice.service.persistence.WebformValuePersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the webform column remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rcs.dbservice.service.impl.WebformColumnServiceImpl}.
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see com.rcs.dbservice.service.impl.WebformColumnServiceImpl
 * @see com.rcs.dbservice.service.WebformColumnServiceUtil
 * @generated
 */
public abstract class WebformColumnServiceBaseImpl extends BaseServiceImpl
	implements WebformColumnService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rcs.dbservice.service.WebformColumnServiceUtil} to access the webform column remote service.
	 */

	/**
	 * Returns the webform column local service.
	 *
	 * @return the webform column local service
	 */
	public com.rcs.dbservice.service.WebformColumnLocalService getWebformColumnLocalService() {
		return webformColumnLocalService;
	}

	/**
	 * Sets the webform column local service.
	 *
	 * @param webformColumnLocalService the webform column local service
	 */
	public void setWebformColumnLocalService(
		com.rcs.dbservice.service.WebformColumnLocalService webformColumnLocalService) {
		this.webformColumnLocalService = webformColumnLocalService;
	}

	/**
	 * Returns the webform column remote service.
	 *
	 * @return the webform column remote service
	 */
	public com.rcs.dbservice.service.WebformColumnService getWebformColumnService() {
		return webformColumnService;
	}

	/**
	 * Sets the webform column remote service.
	 *
	 * @param webformColumnService the webform column remote service
	 */
	public void setWebformColumnService(
		com.rcs.dbservice.service.WebformColumnService webformColumnService) {
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
	public com.rcs.dbservice.service.WebformRowLocalService getWebformRowLocalService() {
		return webformRowLocalService;
	}

	/**
	 * Sets the webform row local service.
	 *
	 * @param webformRowLocalService the webform row local service
	 */
	public void setWebformRowLocalService(
		com.rcs.dbservice.service.WebformRowLocalService webformRowLocalService) {
		this.webformRowLocalService = webformRowLocalService;
	}

	/**
	 * Returns the webform row remote service.
	 *
	 * @return the webform row remote service
	 */
	public com.rcs.dbservice.service.WebformRowService getWebformRowService() {
		return webformRowService;
	}

	/**
	 * Sets the webform row remote service.
	 *
	 * @param webformRowService the webform row remote service
	 */
	public void setWebformRowService(
		com.rcs.dbservice.service.WebformRowService webformRowService) {
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
	public com.rcs.dbservice.service.WebformTableLocalService getWebformTableLocalService() {
		return webformTableLocalService;
	}

	/**
	 * Sets the webform table local service.
	 *
	 * @param webformTableLocalService the webform table local service
	 */
	public void setWebformTableLocalService(
		com.rcs.dbservice.service.WebformTableLocalService webformTableLocalService) {
		this.webformTableLocalService = webformTableLocalService;
	}

	/**
	 * Returns the webform table remote service.
	 *
	 * @return the webform table remote service
	 */
	public com.rcs.dbservice.service.WebformTableService getWebformTableService() {
		return webformTableService;
	}

	/**
	 * Sets the webform table remote service.
	 *
	 * @param webformTableService the webform table remote service
	 */
	public void setWebformTableService(
		com.rcs.dbservice.service.WebformTableService webformTableService) {
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
	public com.rcs.dbservice.service.WebformValueService getWebformValueService() {
		return webformValueService;
	}

	/**
	 * Sets the webform value remote service.
	 *
	 * @param webformValueService the webform value remote service
	 */
	public void setWebformValueService(
		com.rcs.dbservice.service.WebformValueService webformValueService) {
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
	}

	public void destroy() {
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
		return WebformColumn.class;
	}

	protected String getModelClassName() {
		return WebformColumn.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = webformColumnPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rcs.dbservice.service.WebformColumnLocalService.class)
	protected com.rcs.dbservice.service.WebformColumnLocalService webformColumnLocalService;
	@BeanReference(type = com.rcs.dbservice.service.WebformColumnService.class)
	protected com.rcs.dbservice.service.WebformColumnService webformColumnService;
	@BeanReference(type = WebformColumnPersistence.class)
	protected WebformColumnPersistence webformColumnPersistence;
	@BeanReference(type = com.rcs.dbservice.service.WebformRowLocalService.class)
	protected com.rcs.dbservice.service.WebformRowLocalService webformRowLocalService;
	@BeanReference(type = com.rcs.dbservice.service.WebformRowService.class)
	protected com.rcs.dbservice.service.WebformRowService webformRowService;
	@BeanReference(type = WebformRowPersistence.class)
	protected WebformRowPersistence webformRowPersistence;
	@BeanReference(type = com.rcs.dbservice.service.WebformTableLocalService.class)
	protected com.rcs.dbservice.service.WebformTableLocalService webformTableLocalService;
	@BeanReference(type = com.rcs.dbservice.service.WebformTableService.class)
	protected com.rcs.dbservice.service.WebformTableService webformTableService;
	@BeanReference(type = WebformTablePersistence.class)
	protected WebformTablePersistence webformTablePersistence;
	@BeanReference(type = com.rcs.dbservice.service.WebformValueService.class)
	protected com.rcs.dbservice.service.WebformValueService webformValueService;
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
	private WebformColumnServiceClpInvoker _clpInvoker = new WebformColumnServiceClpInvoker();
}