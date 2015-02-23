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

package com.rcs.dbService.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rcs.dbService.NoSuchWebformValueException;
import com.rcs.dbService.model.WebformValue;
import com.rcs.dbService.model.impl.WebformValueImpl;
import com.rcs.dbService.model.impl.WebformValueModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the webform value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformValuePersistence
 * @see WebformValueUtil
 * @generated
 */
public class WebformValuePersistenceImpl extends BasePersistenceImpl<WebformValue>
	implements WebformValuePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WebformValueUtil} to access the webform value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WebformValueImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WebformValueModelImpl.ENTITY_CACHE_ENABLED,
			WebformValueModelImpl.FINDER_CACHE_ENABLED, WebformValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WebformValueModelImpl.ENTITY_CACHE_ENABLED,
			WebformValueModelImpl.FINDER_CACHE_ENABLED, WebformValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WebformValueModelImpl.ENTITY_CACHE_ENABLED,
			WebformValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WEBFORMTABLEID =
		new FinderPath(WebformValueModelImpl.ENTITY_CACHE_ENABLED,
			WebformValueModelImpl.FINDER_CACHE_ENABLED, WebformValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWebformTableId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WEBFORMTABLEID =
		new FinderPath(WebformValueModelImpl.ENTITY_CACHE_ENABLED,
			WebformValueModelImpl.FINDER_CACHE_ENABLED, WebformValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWebformTableId",
			new String[] { Long.class.getName() },
			WebformValueModelImpl.WEBFORMTABLEID_COLUMN_BITMASK |
			WebformValueModelImpl.WEBFORMROWID_COLUMN_BITMASK |
			WebformValueModelImpl.WEBFORMCOLUMNID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WEBFORMTABLEID = new FinderPath(WebformValueModelImpl.ENTITY_CACHE_ENABLED,
			WebformValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWebformTableId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the webform values where webformTableId = &#63;.
	 *
	 * @param webformTableId the webform table ID
	 * @return the matching webform values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebformValue> findByWebformTableId(long webformTableId)
		throws SystemException {
		return findByWebformTableId(webformTableId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the webform values where webformTableId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.WebformValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param webformTableId the webform table ID
	 * @param start the lower bound of the range of webform values
	 * @param end the upper bound of the range of webform values (not inclusive)
	 * @return the range of matching webform values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebformValue> findByWebformTableId(long webformTableId,
		int start, int end) throws SystemException {
		return findByWebformTableId(webformTableId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the webform values where webformTableId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.WebformValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param webformTableId the webform table ID
	 * @param start the lower bound of the range of webform values
	 * @param end the upper bound of the range of webform values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching webform values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebformValue> findByWebformTableId(long webformTableId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WEBFORMTABLEID;
			finderArgs = new Object[] { webformTableId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_WEBFORMTABLEID;
			finderArgs = new Object[] {
					webformTableId,
					
					start, end, orderByComparator
				};
		}

		List<WebformValue> list = (List<WebformValue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WebformValue webformValue : list) {
				if ((webformTableId != webformValue.getWebformTableId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_WEBFORMVALUE_WHERE);

			query.append(_FINDER_COLUMN_WEBFORMTABLEID_WEBFORMTABLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WebformValueModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(webformTableId);

				if (!pagination) {
					list = (List<WebformValue>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WebformValue>(list);
				}
				else {
					list = (List<WebformValue>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first webform value in the ordered set where webformTableId = &#63;.
	 *
	 * @param webformTableId the webform table ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching webform value
	 * @throws com.rcs.dbService.NoSuchWebformValueException if a matching webform value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformValue findByWebformTableId_First(long webformTableId,
		OrderByComparator orderByComparator)
		throws NoSuchWebformValueException, SystemException {
		WebformValue webformValue = fetchByWebformTableId_First(webformTableId,
				orderByComparator);

		if (webformValue != null) {
			return webformValue;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("webformTableId=");
		msg.append(webformTableId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWebformValueException(msg.toString());
	}

	/**
	 * Returns the first webform value in the ordered set where webformTableId = &#63;.
	 *
	 * @param webformTableId the webform table ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching webform value, or <code>null</code> if a matching webform value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformValue fetchByWebformTableId_First(long webformTableId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WebformValue> list = findByWebformTableId(webformTableId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last webform value in the ordered set where webformTableId = &#63;.
	 *
	 * @param webformTableId the webform table ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching webform value
	 * @throws com.rcs.dbService.NoSuchWebformValueException if a matching webform value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformValue findByWebformTableId_Last(long webformTableId,
		OrderByComparator orderByComparator)
		throws NoSuchWebformValueException, SystemException {
		WebformValue webformValue = fetchByWebformTableId_Last(webformTableId,
				orderByComparator);

		if (webformValue != null) {
			return webformValue;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("webformTableId=");
		msg.append(webformTableId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWebformValueException(msg.toString());
	}

	/**
	 * Returns the last webform value in the ordered set where webformTableId = &#63;.
	 *
	 * @param webformTableId the webform table ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching webform value, or <code>null</code> if a matching webform value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformValue fetchByWebformTableId_Last(long webformTableId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByWebformTableId(webformTableId);

		if (count == 0) {
			return null;
		}

		List<WebformValue> list = findByWebformTableId(webformTableId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the webform values before and after the current webform value in the ordered set where webformTableId = &#63;.
	 *
	 * @param webformValueId the primary key of the current webform value
	 * @param webformTableId the webform table ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next webform value
	 * @throws com.rcs.dbService.NoSuchWebformValueException if a webform value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformValue[] findByWebformTableId_PrevAndNext(
		long webformValueId, long webformTableId,
		OrderByComparator orderByComparator)
		throws NoSuchWebformValueException, SystemException {
		WebformValue webformValue = findByPrimaryKey(webformValueId);

		Session session = null;

		try {
			session = openSession();

			WebformValue[] array = new WebformValueImpl[3];

			array[0] = getByWebformTableId_PrevAndNext(session, webformValue,
					webformTableId, orderByComparator, true);

			array[1] = webformValue;

			array[2] = getByWebformTableId_PrevAndNext(session, webformValue,
					webformTableId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WebformValue getByWebformTableId_PrevAndNext(Session session,
		WebformValue webformValue, long webformTableId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WEBFORMVALUE_WHERE);

		query.append(_FINDER_COLUMN_WEBFORMTABLEID_WEBFORMTABLEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(WebformValueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(webformTableId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(webformValue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WebformValue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the webform values where webformTableId = &#63; from the database.
	 *
	 * @param webformTableId the webform table ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByWebformTableId(long webformTableId)
		throws SystemException {
		for (WebformValue webformValue : findByWebformTableId(webformTableId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(webformValue);
		}
	}

	/**
	 * Returns the number of webform values where webformTableId = &#63;.
	 *
	 * @param webformTableId the webform table ID
	 * @return the number of matching webform values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByWebformTableId(long webformTableId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WEBFORMTABLEID;

		Object[] finderArgs = new Object[] { webformTableId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WEBFORMVALUE_WHERE);

			query.append(_FINDER_COLUMN_WEBFORMTABLEID_WEBFORMTABLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(webformTableId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_WEBFORMTABLEID_WEBFORMTABLEID_2 = "webformValue.webformTableId = ?";

	public WebformValuePersistenceImpl() {
		setModelClass(WebformValue.class);
	}

	/**
	 * Caches the webform value in the entity cache if it is enabled.
	 *
	 * @param webformValue the webform value
	 */
	@Override
	public void cacheResult(WebformValue webformValue) {
		EntityCacheUtil.putResult(WebformValueModelImpl.ENTITY_CACHE_ENABLED,
			WebformValueImpl.class, webformValue.getPrimaryKey(), webformValue);

		webformValue.resetOriginalValues();
	}

	/**
	 * Caches the webform values in the entity cache if it is enabled.
	 *
	 * @param webformValues the webform values
	 */
	@Override
	public void cacheResult(List<WebformValue> webformValues) {
		for (WebformValue webformValue : webformValues) {
			if (EntityCacheUtil.getResult(
						WebformValueModelImpl.ENTITY_CACHE_ENABLED,
						WebformValueImpl.class, webformValue.getPrimaryKey()) == null) {
				cacheResult(webformValue);
			}
			else {
				webformValue.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all webform values.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WebformValueImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WebformValueImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the webform value.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WebformValue webformValue) {
		EntityCacheUtil.removeResult(WebformValueModelImpl.ENTITY_CACHE_ENABLED,
			WebformValueImpl.class, webformValue.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WebformValue> webformValues) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WebformValue webformValue : webformValues) {
			EntityCacheUtil.removeResult(WebformValueModelImpl.ENTITY_CACHE_ENABLED,
				WebformValueImpl.class, webformValue.getPrimaryKey());
		}
	}

	/**
	 * Creates a new webform value with the primary key. Does not add the webform value to the database.
	 *
	 * @param webformValueId the primary key for the new webform value
	 * @return the new webform value
	 */
	@Override
	public WebformValue create(long webformValueId) {
		WebformValue webformValue = new WebformValueImpl();

		webformValue.setNew(true);
		webformValue.setPrimaryKey(webformValueId);

		return webformValue;
	}

	/**
	 * Removes the webform value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param webformValueId the primary key of the webform value
	 * @return the webform value that was removed
	 * @throws com.rcs.dbService.NoSuchWebformValueException if a webform value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformValue remove(long webformValueId)
		throws NoSuchWebformValueException, SystemException {
		return remove((Serializable)webformValueId);
	}

	/**
	 * Removes the webform value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the webform value
	 * @return the webform value that was removed
	 * @throws com.rcs.dbService.NoSuchWebformValueException if a webform value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformValue remove(Serializable primaryKey)
		throws NoSuchWebformValueException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WebformValue webformValue = (WebformValue)session.get(WebformValueImpl.class,
					primaryKey);

			if (webformValue == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWebformValueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(webformValue);
		}
		catch (NoSuchWebformValueException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected WebformValue removeImpl(WebformValue webformValue)
		throws SystemException {
		webformValue = toUnwrappedModel(webformValue);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(webformValue)) {
				webformValue = (WebformValue)session.get(WebformValueImpl.class,
						webformValue.getPrimaryKeyObj());
			}

			if (webformValue != null) {
				session.delete(webformValue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (webformValue != null) {
			clearCache(webformValue);
		}

		return webformValue;
	}

	@Override
	public WebformValue updateImpl(
		com.rcs.dbService.model.WebformValue webformValue)
		throws SystemException {
		webformValue = toUnwrappedModel(webformValue);

		boolean isNew = webformValue.isNew();

		WebformValueModelImpl webformValueModelImpl = (WebformValueModelImpl)webformValue;

		Session session = null;

		try {
			session = openSession();

			if (webformValue.isNew()) {
				session.save(webformValue);

				webformValue.setNew(false);
			}
			else {
				session.merge(webformValue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WebformValueModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((webformValueModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WEBFORMTABLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						webformValueModelImpl.getOriginalWebformTableId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WEBFORMTABLEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WEBFORMTABLEID,
					args);

				args = new Object[] { webformValueModelImpl.getWebformTableId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WEBFORMTABLEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WEBFORMTABLEID,
					args);
			}
		}

		EntityCacheUtil.putResult(WebformValueModelImpl.ENTITY_CACHE_ENABLED,
			WebformValueImpl.class, webformValue.getPrimaryKey(), webformValue);

		return webformValue;
	}

	protected WebformValue toUnwrappedModel(WebformValue webformValue) {
		if (webformValue instanceof WebformValueImpl) {
			return webformValue;
		}

		WebformValueImpl webformValueImpl = new WebformValueImpl();

		webformValueImpl.setNew(webformValue.isNew());
		webformValueImpl.setPrimaryKey(webformValue.getPrimaryKey());

		webformValueImpl.setWebformValueId(webformValue.getWebformValueId());
		webformValueImpl.setWebformTableId(webformValue.getWebformTableId());
		webformValueImpl.setWebformColumnId(webformValue.getWebformColumnId());
		webformValueImpl.setWebformRowId(webformValue.getWebformRowId());
		webformValueImpl.setData(webformValue.getData());

		return webformValueImpl;
	}

	/**
	 * Returns the webform value with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the webform value
	 * @return the webform value
	 * @throws com.rcs.dbService.NoSuchWebformValueException if a webform value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformValue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWebformValueException, SystemException {
		WebformValue webformValue = fetchByPrimaryKey(primaryKey);

		if (webformValue == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWebformValueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return webformValue;
	}

	/**
	 * Returns the webform value with the primary key or throws a {@link com.rcs.dbService.NoSuchWebformValueException} if it could not be found.
	 *
	 * @param webformValueId the primary key of the webform value
	 * @return the webform value
	 * @throws com.rcs.dbService.NoSuchWebformValueException if a webform value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformValue findByPrimaryKey(long webformValueId)
		throws NoSuchWebformValueException, SystemException {
		return findByPrimaryKey((Serializable)webformValueId);
	}

	/**
	 * Returns the webform value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the webform value
	 * @return the webform value, or <code>null</code> if a webform value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformValue fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		WebformValue webformValue = (WebformValue)EntityCacheUtil.getResult(WebformValueModelImpl.ENTITY_CACHE_ENABLED,
				WebformValueImpl.class, primaryKey);

		if (webformValue == _nullWebformValue) {
			return null;
		}

		if (webformValue == null) {
			Session session = null;

			try {
				session = openSession();

				webformValue = (WebformValue)session.get(WebformValueImpl.class,
						primaryKey);

				if (webformValue != null) {
					cacheResult(webformValue);
				}
				else {
					EntityCacheUtil.putResult(WebformValueModelImpl.ENTITY_CACHE_ENABLED,
						WebformValueImpl.class, primaryKey, _nullWebformValue);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(WebformValueModelImpl.ENTITY_CACHE_ENABLED,
					WebformValueImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return webformValue;
	}

	/**
	 * Returns the webform value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param webformValueId the primary key of the webform value
	 * @return the webform value, or <code>null</code> if a webform value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformValue fetchByPrimaryKey(long webformValueId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)webformValueId);
	}

	/**
	 * Returns all the webform values.
	 *
	 * @return the webform values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebformValue> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the webform values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.WebformValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of webform values
	 * @param end the upper bound of the range of webform values (not inclusive)
	 * @return the range of webform values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebformValue> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the webform values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.WebformValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of webform values
	 * @param end the upper bound of the range of webform values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of webform values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebformValue> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<WebformValue> list = (List<WebformValue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WEBFORMVALUE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WEBFORMVALUE;

				if (pagination) {
					sql = sql.concat(WebformValueModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WebformValue>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WebformValue>(list);
				}
				else {
					list = (List<WebformValue>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the webform values from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (WebformValue webformValue : findAll()) {
			remove(webformValue);
		}
	}

	/**
	 * Returns the number of webform values.
	 *
	 * @return the number of webform values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WEBFORMVALUE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the webform value persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rcs.dbService.model.WebformValue")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WebformValue>> listenersList = new ArrayList<ModelListener<WebformValue>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WebformValue>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(WebformValueImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_WEBFORMVALUE = "SELECT webformValue FROM WebformValue webformValue";
	private static final String _SQL_SELECT_WEBFORMVALUE_WHERE = "SELECT webformValue FROM WebformValue webformValue WHERE ";
	private static final String _SQL_COUNT_WEBFORMVALUE = "SELECT COUNT(webformValue) FROM WebformValue webformValue";
	private static final String _SQL_COUNT_WEBFORMVALUE_WHERE = "SELECT COUNT(webformValue) FROM WebformValue webformValue WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "webformValue.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WebformValue exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WebformValue exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WebformValuePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"data"
			});
	private static WebformValue _nullWebformValue = new WebformValueImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WebformValue> toCacheModel() {
				return _nullWebformValueCacheModel;
			}
		};

	private static CacheModel<WebformValue> _nullWebformValueCacheModel = new CacheModel<WebformValue>() {
			@Override
			public WebformValue toEntityModel() {
				return _nullWebformValue;
			}
		};
}