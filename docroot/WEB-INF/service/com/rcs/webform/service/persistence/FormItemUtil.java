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

package com.rcs.webform.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rcs.webform.model.FormItem;

import java.util.List;

/**
 * The persistence utility for the form item service. This utility wraps {@link FormItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ryusuf
 * @see FormItemPersistence
 * @see FormItemPersistenceImpl
 * @generated
 */
public class FormItemUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(FormItem formItem) {
		getPersistence().clearCache(formItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FormItem> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FormItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FormItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FormItem update(FormItem formItem) throws SystemException {
		return getPersistence().update(formItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FormItem update(FormItem formItem,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(formItem, serviceContext);
	}

	/**
	* Returns all the form items where formId = &#63;.
	*
	* @param formId the form ID
	* @return the matching form items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.webform.model.FormItem> findByFormIdAndActive(
		long formId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFormIdAndActive(formId);
	}

	/**
	* Returns a range of all the form items where formId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param formId the form ID
	* @param start the lower bound of the range of form items
	* @param end the upper bound of the range of form items (not inclusive)
	* @return the range of matching form items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.webform.model.FormItem> findByFormIdAndActive(
		long formId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFormIdAndActive(formId, start, end);
	}

	/**
	* Returns an ordered range of all the form items where formId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param formId the form ID
	* @param start the lower bound of the range of form items
	* @param end the upper bound of the range of form items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching form items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.webform.model.FormItem> findByFormIdAndActive(
		long formId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFormIdAndActive(formId, start, end, orderByComparator);
	}

	/**
	* Returns the first form item in the ordered set where formId = &#63;.
	*
	* @param formId the form ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form item
	* @throws com.rcs.webform.NoSuchFormItemException if a matching form item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormItem findByFormIdAndActive_First(
		long formId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchFormItemException {
		return getPersistence()
				   .findByFormIdAndActive_First(formId, orderByComparator);
	}

	/**
	* Returns the first form item in the ordered set where formId = &#63;.
	*
	* @param formId the form ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form item, or <code>null</code> if a matching form item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormItem fetchByFormIdAndActive_First(
		long formId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFormIdAndActive_First(formId, orderByComparator);
	}

	/**
	* Returns the last form item in the ordered set where formId = &#63;.
	*
	* @param formId the form ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form item
	* @throws com.rcs.webform.NoSuchFormItemException if a matching form item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormItem findByFormIdAndActive_Last(
		long formId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchFormItemException {
		return getPersistence()
				   .findByFormIdAndActive_Last(formId, orderByComparator);
	}

	/**
	* Returns the last form item in the ordered set where formId = &#63;.
	*
	* @param formId the form ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form item, or <code>null</code> if a matching form item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormItem fetchByFormIdAndActive_Last(
		long formId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFormIdAndActive_Last(formId, orderByComparator);
	}

	/**
	* Returns the form items before and after the current form item in the ordered set where formId = &#63;.
	*
	* @param formItemId the primary key of the current form item
	* @param formId the form ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next form item
	* @throws com.rcs.webform.NoSuchFormItemException if a form item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormItem[] findByFormIdAndActive_PrevAndNext(
		long formItemId, long formId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchFormItemException {
		return getPersistence()
				   .findByFormIdAndActive_PrevAndNext(formItemId, formId,
			orderByComparator);
	}

	/**
	* Removes all the form items where formId = &#63; from the database.
	*
	* @param formId the form ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFormIdAndActive(long formId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFormIdAndActive(formId);
	}

	/**
	* Returns the number of form items where formId = &#63;.
	*
	* @param formId the form ID
	* @return the number of matching form items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFormIdAndActive(long formId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFormIdAndActive(formId);
	}

	/**
	* Caches the form item in the entity cache if it is enabled.
	*
	* @param formItem the form item
	*/
	public static void cacheResult(com.rcs.webform.model.FormItem formItem) {
		getPersistence().cacheResult(formItem);
	}

	/**
	* Caches the form items in the entity cache if it is enabled.
	*
	* @param formItems the form items
	*/
	public static void cacheResult(
		java.util.List<com.rcs.webform.model.FormItem> formItems) {
		getPersistence().cacheResult(formItems);
	}

	/**
	* Creates a new form item with the primary key. Does not add the form item to the database.
	*
	* @param formItemId the primary key for the new form item
	* @return the new form item
	*/
	public static com.rcs.webform.model.FormItem create(long formItemId) {
		return getPersistence().create(formItemId);
	}

	/**
	* Removes the form item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param formItemId the primary key of the form item
	* @return the form item that was removed
	* @throws com.rcs.webform.NoSuchFormItemException if a form item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormItem remove(long formItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchFormItemException {
		return getPersistence().remove(formItemId);
	}

	public static com.rcs.webform.model.FormItem updateImpl(
		com.rcs.webform.model.FormItem formItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(formItem);
	}

	/**
	* Returns the form item with the primary key or throws a {@link com.rcs.webform.NoSuchFormItemException} if it could not be found.
	*
	* @param formItemId the primary key of the form item
	* @return the form item
	* @throws com.rcs.webform.NoSuchFormItemException if a form item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormItem findByPrimaryKey(
		long formItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.webform.NoSuchFormItemException {
		return getPersistence().findByPrimaryKey(formItemId);
	}

	/**
	* Returns the form item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param formItemId the primary key of the form item
	* @return the form item, or <code>null</code> if a form item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.webform.model.FormItem fetchByPrimaryKey(
		long formItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(formItemId);
	}

	/**
	* Returns all the form items.
	*
	* @return the form items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.webform.model.FormItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.rcs.webform.model.FormItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the form items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form items
	* @param end the upper bound of the range of form items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of form items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.webform.model.FormItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the form items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of form items.
	*
	* @return the number of form items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FormItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FormItemPersistence)PortletBeanLocatorUtil.locate(com.rcs.webform.service.ClpSerializer.getServletContextName(),
					FormItemPersistence.class.getName());

			ReferenceRegistry.registerReference(FormItemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FormItemPersistence persistence) {
	}

	private static FormItemPersistence _persistence;
}