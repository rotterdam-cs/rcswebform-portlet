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

package com.rcs.dbservice.service.persistence;

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

import com.rcs.dbservice.NoSuchWebformColumnException;
import com.rcs.dbservice.model.WebformColumn;
import com.rcs.dbservice.model.impl.WebformColumnImpl;
import com.rcs.dbservice.model.impl.WebformColumnModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the webform column service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformColumnPersistence
 * @see WebformColumnUtil
 * @generated
 */
public class WebformColumnPersistenceImpl extends BasePersistenceImpl<WebformColumn>
	implements WebformColumnPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WebformColumnUtil} to access the webform column persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WebformColumnImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WebformColumnModelImpl.ENTITY_CACHE_ENABLED,
			WebformColumnModelImpl.FINDER_CACHE_ENABLED,
			WebformColumnImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WebformColumnModelImpl.ENTITY_CACHE_ENABLED,
			WebformColumnModelImpl.FINDER_CACHE_ENABLED,
			WebformColumnImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WebformColumnModelImpl.ENTITY_CACHE_ENABLED,
			WebformColumnModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WEBFORMTABLEID =
		new FinderPath(WebformColumnModelImpl.ENTITY_CACHE_ENABLED,
			WebformColumnModelImpl.FINDER_CACHE_ENABLED,
			WebformColumnImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByWebformTableId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WEBFORMTABLEID =
		new FinderPath(WebformColumnModelImpl.ENTITY_CACHE_ENABLED,
			WebformColumnModelImpl.FINDER_CACHE_ENABLED,
			WebformColumnImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByWebformTableId", new String[] { Long.class.getName() },
			WebformColumnModelImpl.WEBFORMTABLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WEBFORMTABLEID = new FinderPath(WebformColumnModelImpl.ENTITY_CACHE_ENABLED,
			WebformColumnModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWebformTableId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the webform columns where webformTableId = &#63;.
	 *
	 * @param webformTableId the webform table ID
	 * @return the matching webform columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebformColumn> findByWebformTableId(long webformTableId)
		throws SystemException {
		return findByWebformTableId(webformTableId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the webform columns where webformTableId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param webformTableId the webform table ID
	 * @param start the lower bound of the range of webform columns
	 * @param end the upper bound of the range of webform columns (not inclusive)
	 * @return the range of matching webform columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebformColumn> findByWebformTableId(long webformTableId,
		int start, int end) throws SystemException {
		return findByWebformTableId(webformTableId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the webform columns where webformTableId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param webformTableId the webform table ID
	 * @param start the lower bound of the range of webform columns
	 * @param end the upper bound of the range of webform columns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching webform columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebformColumn> findByWebformTableId(long webformTableId,
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

		List<WebformColumn> list = (List<WebformColumn>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WebformColumn webformColumn : list) {
				if ((webformTableId != webformColumn.getWebformTableId())) {
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

			query.append(_SQL_SELECT_WEBFORMCOLUMN_WHERE);

			query.append(_FINDER_COLUMN_WEBFORMTABLEID_WEBFORMTABLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WebformColumnModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(webformTableId);

				if (!pagination) {
					list = (List<WebformColumn>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WebformColumn>(list);
				}
				else {
					list = (List<WebformColumn>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first webform column in the ordered set where webformTableId = &#63;.
	 *
	 * @param webformTableId the webform table ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching webform column
	 * @throws com.rcs.dbservice.NoSuchWebformColumnException if a matching webform column could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformColumn findByWebformTableId_First(long webformTableId,
		OrderByComparator orderByComparator)
		throws NoSuchWebformColumnException, SystemException {
		WebformColumn webformColumn = fetchByWebformTableId_First(webformTableId,
				orderByComparator);

		if (webformColumn != null) {
			return webformColumn;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("webformTableId=");
		msg.append(webformTableId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWebformColumnException(msg.toString());
	}

	/**
	 * Returns the first webform column in the ordered set where webformTableId = &#63;.
	 *
	 * @param webformTableId the webform table ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching webform column, or <code>null</code> if a matching webform column could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformColumn fetchByWebformTableId_First(long webformTableId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WebformColumn> list = findByWebformTableId(webformTableId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last webform column in the ordered set where webformTableId = &#63;.
	 *
	 * @param webformTableId the webform table ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching webform column
	 * @throws com.rcs.dbservice.NoSuchWebformColumnException if a matching webform column could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformColumn findByWebformTableId_Last(long webformTableId,
		OrderByComparator orderByComparator)
		throws NoSuchWebformColumnException, SystemException {
		WebformColumn webformColumn = fetchByWebformTableId_Last(webformTableId,
				orderByComparator);

		if (webformColumn != null) {
			return webformColumn;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("webformTableId=");
		msg.append(webformTableId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWebformColumnException(msg.toString());
	}

	/**
	 * Returns the last webform column in the ordered set where webformTableId = &#63;.
	 *
	 * @param webformTableId the webform table ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching webform column, or <code>null</code> if a matching webform column could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformColumn fetchByWebformTableId_Last(long webformTableId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByWebformTableId(webformTableId);

		if (count == 0) {
			return null;
		}

		List<WebformColumn> list = findByWebformTableId(webformTableId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the webform columns before and after the current webform column in the ordered set where webformTableId = &#63;.
	 *
	 * @param webformColumnId the primary key of the current webform column
	 * @param webformTableId the webform table ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next webform column
	 * @throws com.rcs.dbservice.NoSuchWebformColumnException if a webform column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformColumn[] findByWebformTableId_PrevAndNext(
		long webformColumnId, long webformTableId,
		OrderByComparator orderByComparator)
		throws NoSuchWebformColumnException, SystemException {
		WebformColumn webformColumn = findByPrimaryKey(webformColumnId);

		Session session = null;

		try {
			session = openSession();

			WebformColumn[] array = new WebformColumnImpl[3];

			array[0] = getByWebformTableId_PrevAndNext(session, webformColumn,
					webformTableId, orderByComparator, true);

			array[1] = webformColumn;

			array[2] = getByWebformTableId_PrevAndNext(session, webformColumn,
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

	protected WebformColumn getByWebformTableId_PrevAndNext(Session session,
		WebformColumn webformColumn, long webformTableId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WEBFORMCOLUMN_WHERE);

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
			query.append(WebformColumnModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(webformTableId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(webformColumn);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WebformColumn> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the webform columns where webformTableId = &#63; from the database.
	 *
	 * @param webformTableId the webform table ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByWebformTableId(long webformTableId)
		throws SystemException {
		for (WebformColumn webformColumn : findByWebformTableId(
				webformTableId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(webformColumn);
		}
	}

	/**
	 * Returns the number of webform columns where webformTableId = &#63;.
	 *
	 * @param webformTableId the webform table ID
	 * @return the number of matching webform columns
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

			query.append(_SQL_COUNT_WEBFORMCOLUMN_WHERE);

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

	private static final String _FINDER_COLUMN_WEBFORMTABLEID_WEBFORMTABLEID_2 = "webformColumn.webformTableId = ?";

	public WebformColumnPersistenceImpl() {
		setModelClass(WebformColumn.class);
	}

	/**
	 * Caches the webform column in the entity cache if it is enabled.
	 *
	 * @param webformColumn the webform column
	 */
	@Override
	public void cacheResult(WebformColumn webformColumn) {
		EntityCacheUtil.putResult(WebformColumnModelImpl.ENTITY_CACHE_ENABLED,
			WebformColumnImpl.class, webformColumn.getPrimaryKey(),
			webformColumn);

		webformColumn.resetOriginalValues();
	}

	/**
	 * Caches the webform columns in the entity cache if it is enabled.
	 *
	 * @param webformColumns the webform columns
	 */
	@Override
	public void cacheResult(List<WebformColumn> webformColumns) {
		for (WebformColumn webformColumn : webformColumns) {
			if (EntityCacheUtil.getResult(
						WebformColumnModelImpl.ENTITY_CACHE_ENABLED,
						WebformColumnImpl.class, webformColumn.getPrimaryKey()) == null) {
				cacheResult(webformColumn);
			}
			else {
				webformColumn.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all webform columns.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WebformColumnImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WebformColumnImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the webform column.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WebformColumn webformColumn) {
		EntityCacheUtil.removeResult(WebformColumnModelImpl.ENTITY_CACHE_ENABLED,
			WebformColumnImpl.class, webformColumn.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WebformColumn> webformColumns) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WebformColumn webformColumn : webformColumns) {
			EntityCacheUtil.removeResult(WebformColumnModelImpl.ENTITY_CACHE_ENABLED,
				WebformColumnImpl.class, webformColumn.getPrimaryKey());
		}
	}

	/**
	 * Creates a new webform column with the primary key. Does not add the webform column to the database.
	 *
	 * @param webformColumnId the primary key for the new webform column
	 * @return the new webform column
	 */
	@Override
	public WebformColumn create(long webformColumnId) {
		WebformColumn webformColumn = new WebformColumnImpl();

		webformColumn.setNew(true);
		webformColumn.setPrimaryKey(webformColumnId);

		return webformColumn;
	}

	/**
	 * Removes the webform column with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param webformColumnId the primary key of the webform column
	 * @return the webform column that was removed
	 * @throws com.rcs.dbservice.NoSuchWebformColumnException if a webform column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformColumn remove(long webformColumnId)
		throws NoSuchWebformColumnException, SystemException {
		return remove((Serializable)webformColumnId);
	}

	/**
	 * Removes the webform column with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the webform column
	 * @return the webform column that was removed
	 * @throws com.rcs.dbservice.NoSuchWebformColumnException if a webform column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformColumn remove(Serializable primaryKey)
		throws NoSuchWebformColumnException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WebformColumn webformColumn = (WebformColumn)session.get(WebformColumnImpl.class,
					primaryKey);

			if (webformColumn == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWebformColumnException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(webformColumn);
		}
		catch (NoSuchWebformColumnException nsee) {
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
	protected WebformColumn removeImpl(WebformColumn webformColumn)
		throws SystemException {
		webformColumn = toUnwrappedModel(webformColumn);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(webformColumn)) {
				webformColumn = (WebformColumn)session.get(WebformColumnImpl.class,
						webformColumn.getPrimaryKeyObj());
			}

			if (webformColumn != null) {
				session.delete(webformColumn);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (webformColumn != null) {
			clearCache(webformColumn);
		}

		return webformColumn;
	}

	@Override
	public WebformColumn updateImpl(
		com.rcs.dbservice.model.WebformColumn webformColumn)
		throws SystemException {
		webformColumn = toUnwrappedModel(webformColumn);

		boolean isNew = webformColumn.isNew();

		WebformColumnModelImpl webformColumnModelImpl = (WebformColumnModelImpl)webformColumn;

		Session session = null;

		try {
			session = openSession();

			if (webformColumn.isNew()) {
				session.save(webformColumn);

				webformColumn.setNew(false);
			}
			else {
				session.merge(webformColumn);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WebformColumnModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((webformColumnModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WEBFORMTABLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						webformColumnModelImpl.getOriginalWebformTableId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WEBFORMTABLEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WEBFORMTABLEID,
					args);

				args = new Object[] { webformColumnModelImpl.getWebformTableId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WEBFORMTABLEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WEBFORMTABLEID,
					args);
			}
		}

		EntityCacheUtil.putResult(WebformColumnModelImpl.ENTITY_CACHE_ENABLED,
			WebformColumnImpl.class, webformColumn.getPrimaryKey(),
			webformColumn);

		return webformColumn;
	}

	protected WebformColumn toUnwrappedModel(WebformColumn webformColumn) {
		if (webformColumn instanceof WebformColumnImpl) {
			return webformColumn;
		}

		WebformColumnImpl webformColumnImpl = new WebformColumnImpl();

		webformColumnImpl.setNew(webformColumn.isNew());
		webformColumnImpl.setPrimaryKey(webformColumn.getPrimaryKey());

		webformColumnImpl.setWebformColumnId(webformColumn.getWebformColumnId());
		webformColumnImpl.setWebformTableId(webformColumn.getWebformTableId());
		webformColumnImpl.setName(webformColumn.getName());
		webformColumnImpl.setType(webformColumn.getType());
		webformColumnImpl.setInputType(webformColumn.getInputType());
		webformColumnImpl.setIsRequired(webformColumn.isIsRequired());
		webformColumnImpl.setPlaceHolder(webformColumn.getPlaceHolder());
		webformColumnImpl.setValidation(webformColumn.getValidation());
		webformColumnImpl.setCustomValidation(webformColumn.getCustomValidation());
		webformColumnImpl.setLabelClass(webformColumn.getLabelClass());
		webformColumnImpl.setInputClass(webformColumn.getInputClass());
		webformColumnImpl.setMaxLength(webformColumn.getMaxLength());

		return webformColumnImpl;
	}

	/**
	 * Returns the webform column with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the webform column
	 * @return the webform column
	 * @throws com.rcs.dbservice.NoSuchWebformColumnException if a webform column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformColumn findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWebformColumnException, SystemException {
		WebformColumn webformColumn = fetchByPrimaryKey(primaryKey);

		if (webformColumn == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWebformColumnException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return webformColumn;
	}

	/**
	 * Returns the webform column with the primary key or throws a {@link com.rcs.dbservice.NoSuchWebformColumnException} if it could not be found.
	 *
	 * @param webformColumnId the primary key of the webform column
	 * @return the webform column
	 * @throws com.rcs.dbservice.NoSuchWebformColumnException if a webform column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformColumn findByPrimaryKey(long webformColumnId)
		throws NoSuchWebformColumnException, SystemException {
		return findByPrimaryKey((Serializable)webformColumnId);
	}

	/**
	 * Returns the webform column with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the webform column
	 * @return the webform column, or <code>null</code> if a webform column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformColumn fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		WebformColumn webformColumn = (WebformColumn)EntityCacheUtil.getResult(WebformColumnModelImpl.ENTITY_CACHE_ENABLED,
				WebformColumnImpl.class, primaryKey);

		if (webformColumn == _nullWebformColumn) {
			return null;
		}

		if (webformColumn == null) {
			Session session = null;

			try {
				session = openSession();

				webformColumn = (WebformColumn)session.get(WebformColumnImpl.class,
						primaryKey);

				if (webformColumn != null) {
					cacheResult(webformColumn);
				}
				else {
					EntityCacheUtil.putResult(WebformColumnModelImpl.ENTITY_CACHE_ENABLED,
						WebformColumnImpl.class, primaryKey, _nullWebformColumn);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(WebformColumnModelImpl.ENTITY_CACHE_ENABLED,
					WebformColumnImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return webformColumn;
	}

	/**
	 * Returns the webform column with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param webformColumnId the primary key of the webform column
	 * @return the webform column, or <code>null</code> if a webform column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformColumn fetchByPrimaryKey(long webformColumnId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)webformColumnId);
	}

	/**
	 * Returns all the webform columns.
	 *
	 * @return the webform columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebformColumn> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the webform columns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of webform columns
	 * @param end the upper bound of the range of webform columns (not inclusive)
	 * @return the range of webform columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebformColumn> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the webform columns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.WebformColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of webform columns
	 * @param end the upper bound of the range of webform columns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of webform columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebformColumn> findAll(int start, int end,
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

		List<WebformColumn> list = (List<WebformColumn>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WEBFORMCOLUMN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WEBFORMCOLUMN;

				if (pagination) {
					sql = sql.concat(WebformColumnModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WebformColumn>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WebformColumn>(list);
				}
				else {
					list = (List<WebformColumn>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the webform columns from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (WebformColumn webformColumn : findAll()) {
			remove(webformColumn);
		}
	}

	/**
	 * Returns the number of webform columns.
	 *
	 * @return the number of webform columns
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

				Query q = session.createQuery(_SQL_COUNT_WEBFORMCOLUMN);

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
	 * Initializes the webform column persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rcs.dbservice.model.WebformColumn")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WebformColumn>> listenersList = new ArrayList<ModelListener<WebformColumn>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WebformColumn>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WebformColumnImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_WEBFORMCOLUMN = "SELECT webformColumn FROM WebformColumn webformColumn";
	private static final String _SQL_SELECT_WEBFORMCOLUMN_WHERE = "SELECT webformColumn FROM WebformColumn webformColumn WHERE ";
	private static final String _SQL_COUNT_WEBFORMCOLUMN = "SELECT COUNT(webformColumn) FROM WebformColumn webformColumn";
	private static final String _SQL_COUNT_WEBFORMCOLUMN_WHERE = "SELECT COUNT(webformColumn) FROM WebformColumn webformColumn WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "webformColumn.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WebformColumn exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WebformColumn exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WebformColumnPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static WebformColumn _nullWebformColumn = new WebformColumnImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WebformColumn> toCacheModel() {
				return _nullWebformColumnCacheModel;
			}
		};

	private static CacheModel<WebformColumn> _nullWebformColumnCacheModel = new CacheModel<WebformColumn>() {
			@Override
			public WebformColumn toEntityModel() {
				return _nullWebformColumn;
			}
		};
}