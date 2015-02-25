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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rcs.dbService.NoSuchWebformTableException;
import com.rcs.dbService.model.WebformTable;
import com.rcs.dbService.model.impl.WebformTableImpl;
import com.rcs.dbService.model.impl.WebformTableModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the webform table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see WebformTablePersistence
 * @see WebformTableUtil
 * @generated
 */
public class WebformTablePersistenceImpl extends BasePersistenceImpl<WebformTable>
	implements WebformTablePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WebformTableUtil} to access the webform table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WebformTableImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WebformTableModelImpl.ENTITY_CACHE_ENABLED,
			WebformTableModelImpl.FINDER_CACHE_ENABLED, WebformTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WebformTableModelImpl.ENTITY_CACHE_ENABLED,
			WebformTableModelImpl.FINDER_CACHE_ENABLED, WebformTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WebformTableModelImpl.ENTITY_CACHE_ENABLED,
			WebformTableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_PORTLETID = new FinderPath(WebformTableModelImpl.ENTITY_CACHE_ENABLED,
			WebformTableModelImpl.FINDER_CACHE_ENABLED, WebformTableImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPortletId",
			new String[] { String.class.getName() },
			WebformTableModelImpl.PORTLETID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PORTLETID = new FinderPath(WebformTableModelImpl.ENTITY_CACHE_ENABLED,
			WebformTableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPortletId",
			new String[] { String.class.getName() });

	/**
	 * Returns the webform table where portletId = &#63; or throws a {@link com.rcs.dbService.NoSuchWebformTableException} if it could not be found.
	 *
	 * @param portletId the portlet ID
	 * @return the matching webform table
	 * @throws com.rcs.dbService.NoSuchWebformTableException if a matching webform table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformTable findByPortletId(String portletId)
		throws NoSuchWebformTableException, SystemException {
		WebformTable webformTable = fetchByPortletId(portletId);

		if (webformTable == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("portletId=");
			msg.append(portletId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchWebformTableException(msg.toString());
		}

		return webformTable;
	}

	/**
	 * Returns the webform table where portletId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param portletId the portlet ID
	 * @return the matching webform table, or <code>null</code> if a matching webform table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformTable fetchByPortletId(String portletId)
		throws SystemException {
		return fetchByPortletId(portletId, true);
	}

	/**
	 * Returns the webform table where portletId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param portletId the portlet ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching webform table, or <code>null</code> if a matching webform table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformTable fetchByPortletId(String portletId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { portletId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PORTLETID,
					finderArgs, this);
		}

		if (result instanceof WebformTable) {
			WebformTable webformTable = (WebformTable)result;

			if (!Validator.equals(portletId, webformTable.getPortletId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WEBFORMTABLE_WHERE);

			boolean bindPortletId = false;

			if (portletId == null) {
				query.append(_FINDER_COLUMN_PORTLETID_PORTLETID_1);
			}
			else if (portletId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PORTLETID_PORTLETID_3);
			}
			else {
				bindPortletId = true;

				query.append(_FINDER_COLUMN_PORTLETID_PORTLETID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPortletId) {
					qPos.add(portletId);
				}

				List<WebformTable> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORTLETID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"WebformTablePersistenceImpl.fetchByPortletId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					WebformTable webformTable = list.get(0);

					result = webformTable;

					cacheResult(webformTable);

					if ((webformTable.getPortletId() == null) ||
							!webformTable.getPortletId().equals(portletId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORTLETID,
							finderArgs, webformTable);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORTLETID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (WebformTable)result;
		}
	}

	/**
	 * Removes the webform table where portletId = &#63; from the database.
	 *
	 * @param portletId the portlet ID
	 * @return the webform table that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformTable removeByPortletId(String portletId)
		throws NoSuchWebformTableException, SystemException {
		WebformTable webformTable = findByPortletId(portletId);

		return remove(webformTable);
	}

	/**
	 * Returns the number of webform tables where portletId = &#63;.
	 *
	 * @param portletId the portlet ID
	 * @return the number of matching webform tables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPortletId(String portletId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PORTLETID;

		Object[] finderArgs = new Object[] { portletId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WEBFORMTABLE_WHERE);

			boolean bindPortletId = false;

			if (portletId == null) {
				query.append(_FINDER_COLUMN_PORTLETID_PORTLETID_1);
			}
			else if (portletId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PORTLETID_PORTLETID_3);
			}
			else {
				bindPortletId = true;

				query.append(_FINDER_COLUMN_PORTLETID_PORTLETID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPortletId) {
					qPos.add(portletId);
				}

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

	private static final String _FINDER_COLUMN_PORTLETID_PORTLETID_1 = "webformTable.portletId IS NULL";
	private static final String _FINDER_COLUMN_PORTLETID_PORTLETID_2 = "webformTable.portletId = ?";
	private static final String _FINDER_COLUMN_PORTLETID_PORTLETID_3 = "(webformTable.portletId IS NULL OR webformTable.portletId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PORTLETIDANDCOUNTER = new FinderPath(WebformTableModelImpl.ENTITY_CACHE_ENABLED,
			WebformTableModelImpl.FINDER_CACHE_ENABLED, WebformTableImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPortletIdAndCounter",
			new String[] { String.class.getName(), String.class.getName() },
			WebformTableModelImpl.PORTLETID_COLUMN_BITMASK |
			WebformTableModelImpl.WEBFORMCOUNTER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PORTLETIDANDCOUNTER = new FinderPath(WebformTableModelImpl.ENTITY_CACHE_ENABLED,
			WebformTableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPortletIdAndCounter",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the webform table where portletId = &#63; and webformCounter = &#63; or throws a {@link com.rcs.dbService.NoSuchWebformTableException} if it could not be found.
	 *
	 * @param portletId the portlet ID
	 * @param webformCounter the webform counter
	 * @return the matching webform table
	 * @throws com.rcs.dbService.NoSuchWebformTableException if a matching webform table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformTable findByPortletIdAndCounter(String portletId,
		String webformCounter)
		throws NoSuchWebformTableException, SystemException {
		WebformTable webformTable = fetchByPortletIdAndCounter(portletId,
				webformCounter);

		if (webformTable == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("portletId=");
			msg.append(portletId);

			msg.append(", webformCounter=");
			msg.append(webformCounter);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchWebformTableException(msg.toString());
		}

		return webformTable;
	}

	/**
	 * Returns the webform table where portletId = &#63; and webformCounter = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param portletId the portlet ID
	 * @param webformCounter the webform counter
	 * @return the matching webform table, or <code>null</code> if a matching webform table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformTable fetchByPortletIdAndCounter(String portletId,
		String webformCounter) throws SystemException {
		return fetchByPortletIdAndCounter(portletId, webformCounter, true);
	}

	/**
	 * Returns the webform table where portletId = &#63; and webformCounter = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param portletId the portlet ID
	 * @param webformCounter the webform counter
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching webform table, or <code>null</code> if a matching webform table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformTable fetchByPortletIdAndCounter(String portletId,
		String webformCounter, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { portletId, webformCounter };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PORTLETIDANDCOUNTER,
					finderArgs, this);
		}

		if (result instanceof WebformTable) {
			WebformTable webformTable = (WebformTable)result;

			if (!Validator.equals(portletId, webformTable.getPortletId()) ||
					!Validator.equals(webformCounter,
						webformTable.getWebformCounter())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_WEBFORMTABLE_WHERE);

			boolean bindPortletId = false;

			if (portletId == null) {
				query.append(_FINDER_COLUMN_PORTLETIDANDCOUNTER_PORTLETID_1);
			}
			else if (portletId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PORTLETIDANDCOUNTER_PORTLETID_3);
			}
			else {
				bindPortletId = true;

				query.append(_FINDER_COLUMN_PORTLETIDANDCOUNTER_PORTLETID_2);
			}

			boolean bindWebformCounter = false;

			if (webformCounter == null) {
				query.append(_FINDER_COLUMN_PORTLETIDANDCOUNTER_WEBFORMCOUNTER_1);
			}
			else if (webformCounter.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PORTLETIDANDCOUNTER_WEBFORMCOUNTER_3);
			}
			else {
				bindWebformCounter = true;

				query.append(_FINDER_COLUMN_PORTLETIDANDCOUNTER_WEBFORMCOUNTER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPortletId) {
					qPos.add(portletId);
				}

				if (bindWebformCounter) {
					qPos.add(webformCounter);
				}

				List<WebformTable> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORTLETIDANDCOUNTER,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"WebformTablePersistenceImpl.fetchByPortletIdAndCounter(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					WebformTable webformTable = list.get(0);

					result = webformTable;

					cacheResult(webformTable);

					if ((webformTable.getPortletId() == null) ||
							!webformTable.getPortletId().equals(portletId) ||
							(webformTable.getWebformCounter() == null) ||
							!webformTable.getWebformCounter()
											 .equals(webformCounter)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORTLETIDANDCOUNTER,
							finderArgs, webformTable);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORTLETIDANDCOUNTER,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (WebformTable)result;
		}
	}

	/**
	 * Removes the webform table where portletId = &#63; and webformCounter = &#63; from the database.
	 *
	 * @param portletId the portlet ID
	 * @param webformCounter the webform counter
	 * @return the webform table that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformTable removeByPortletIdAndCounter(String portletId,
		String webformCounter)
		throws NoSuchWebformTableException, SystemException {
		WebformTable webformTable = findByPortletIdAndCounter(portletId,
				webformCounter);

		return remove(webformTable);
	}

	/**
	 * Returns the number of webform tables where portletId = &#63; and webformCounter = &#63;.
	 *
	 * @param portletId the portlet ID
	 * @param webformCounter the webform counter
	 * @return the number of matching webform tables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPortletIdAndCounter(String portletId,
		String webformCounter) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PORTLETIDANDCOUNTER;

		Object[] finderArgs = new Object[] { portletId, webformCounter };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WEBFORMTABLE_WHERE);

			boolean bindPortletId = false;

			if (portletId == null) {
				query.append(_FINDER_COLUMN_PORTLETIDANDCOUNTER_PORTLETID_1);
			}
			else if (portletId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PORTLETIDANDCOUNTER_PORTLETID_3);
			}
			else {
				bindPortletId = true;

				query.append(_FINDER_COLUMN_PORTLETIDANDCOUNTER_PORTLETID_2);
			}

			boolean bindWebformCounter = false;

			if (webformCounter == null) {
				query.append(_FINDER_COLUMN_PORTLETIDANDCOUNTER_WEBFORMCOUNTER_1);
			}
			else if (webformCounter.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PORTLETIDANDCOUNTER_WEBFORMCOUNTER_3);
			}
			else {
				bindWebformCounter = true;

				query.append(_FINDER_COLUMN_PORTLETIDANDCOUNTER_WEBFORMCOUNTER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPortletId) {
					qPos.add(portletId);
				}

				if (bindWebformCounter) {
					qPos.add(webformCounter);
				}

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

	private static final String _FINDER_COLUMN_PORTLETIDANDCOUNTER_PORTLETID_1 = "webformTable.portletId IS NULL AND ";
	private static final String _FINDER_COLUMN_PORTLETIDANDCOUNTER_PORTLETID_2 = "webformTable.portletId = ? AND ";
	private static final String _FINDER_COLUMN_PORTLETIDANDCOUNTER_PORTLETID_3 = "(webformTable.portletId IS NULL OR webformTable.portletId = '') AND ";
	private static final String _FINDER_COLUMN_PORTLETIDANDCOUNTER_WEBFORMCOUNTER_1 =
		"webformTable.webformCounter IS NULL";
	private static final String _FINDER_COLUMN_PORTLETIDANDCOUNTER_WEBFORMCOUNTER_2 =
		"webformTable.webformCounter = ?";
	private static final String _FINDER_COLUMN_PORTLETIDANDCOUNTER_WEBFORMCOUNTER_3 =
		"(webformTable.webformCounter IS NULL OR webformTable.webformCounter = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_WEBFORMNAME = new FinderPath(WebformTableModelImpl.ENTITY_CACHE_ENABLED,
			WebformTableModelImpl.FINDER_CACHE_ENABLED, WebformTableImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByWebformName",
			new String[] { String.class.getName() },
			WebformTableModelImpl.WEBFORMNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WEBFORMNAME = new FinderPath(WebformTableModelImpl.ENTITY_CACHE_ENABLED,
			WebformTableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWebformName",
			new String[] { String.class.getName() });

	/**
	 * Returns the webform table where webformName = &#63; or throws a {@link com.rcs.dbService.NoSuchWebformTableException} if it could not be found.
	 *
	 * @param webformName the webform name
	 * @return the matching webform table
	 * @throws com.rcs.dbService.NoSuchWebformTableException if a matching webform table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformTable findByWebformName(String webformName)
		throws NoSuchWebformTableException, SystemException {
		WebformTable webformTable = fetchByWebformName(webformName);

		if (webformTable == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("webformName=");
			msg.append(webformName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchWebformTableException(msg.toString());
		}

		return webformTable;
	}

	/**
	 * Returns the webform table where webformName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param webformName the webform name
	 * @return the matching webform table, or <code>null</code> if a matching webform table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformTable fetchByWebformName(String webformName)
		throws SystemException {
		return fetchByWebformName(webformName, true);
	}

	/**
	 * Returns the webform table where webformName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param webformName the webform name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching webform table, or <code>null</code> if a matching webform table could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformTable fetchByWebformName(String webformName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { webformName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_WEBFORMNAME,
					finderArgs, this);
		}

		if (result instanceof WebformTable) {
			WebformTable webformTable = (WebformTable)result;

			if (!Validator.equals(webformName, webformTable.getWebformName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WEBFORMTABLE_WHERE);

			boolean bindWebformName = false;

			if (webformName == null) {
				query.append(_FINDER_COLUMN_WEBFORMNAME_WEBFORMNAME_1);
			}
			else if (webformName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_WEBFORMNAME_WEBFORMNAME_3);
			}
			else {
				bindWebformName = true;

				query.append(_FINDER_COLUMN_WEBFORMNAME_WEBFORMNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindWebformName) {
					qPos.add(webformName);
				}

				List<WebformTable> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WEBFORMNAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"WebformTablePersistenceImpl.fetchByWebformName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					WebformTable webformTable = list.get(0);

					result = webformTable;

					cacheResult(webformTable);

					if ((webformTable.getWebformName() == null) ||
							!webformTable.getWebformName().equals(webformName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WEBFORMNAME,
							finderArgs, webformTable);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WEBFORMNAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (WebformTable)result;
		}
	}

	/**
	 * Removes the webform table where webformName = &#63; from the database.
	 *
	 * @param webformName the webform name
	 * @return the webform table that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformTable removeByWebformName(String webformName)
		throws NoSuchWebformTableException, SystemException {
		WebformTable webformTable = findByWebformName(webformName);

		return remove(webformTable);
	}

	/**
	 * Returns the number of webform tables where webformName = &#63;.
	 *
	 * @param webformName the webform name
	 * @return the number of matching webform tables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByWebformName(String webformName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WEBFORMNAME;

		Object[] finderArgs = new Object[] { webformName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WEBFORMTABLE_WHERE);

			boolean bindWebformName = false;

			if (webformName == null) {
				query.append(_FINDER_COLUMN_WEBFORMNAME_WEBFORMNAME_1);
			}
			else if (webformName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_WEBFORMNAME_WEBFORMNAME_3);
			}
			else {
				bindWebformName = true;

				query.append(_FINDER_COLUMN_WEBFORMNAME_WEBFORMNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindWebformName) {
					qPos.add(webformName);
				}

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

	private static final String _FINDER_COLUMN_WEBFORMNAME_WEBFORMNAME_1 = "webformTable.webformName IS NULL";
	private static final String _FINDER_COLUMN_WEBFORMNAME_WEBFORMNAME_2 = "webformTable.webformName = ?";
	private static final String _FINDER_COLUMN_WEBFORMNAME_WEBFORMNAME_3 = "(webformTable.webformName IS NULL OR webformTable.webformName = '')";

	public WebformTablePersistenceImpl() {
		setModelClass(WebformTable.class);
	}

	/**
	 * Caches the webform table in the entity cache if it is enabled.
	 *
	 * @param webformTable the webform table
	 */
	@Override
	public void cacheResult(WebformTable webformTable) {
		EntityCacheUtil.putResult(WebformTableModelImpl.ENTITY_CACHE_ENABLED,
			WebformTableImpl.class, webformTable.getPrimaryKey(), webformTable);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORTLETID,
			new Object[] { webformTable.getPortletId() }, webformTable);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORTLETIDANDCOUNTER,
			new Object[] {
				webformTable.getPortletId(), webformTable.getWebformCounter()
			}, webformTable);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WEBFORMNAME,
			new Object[] { webformTable.getWebformName() }, webformTable);

		webformTable.resetOriginalValues();
	}

	/**
	 * Caches the webform tables in the entity cache if it is enabled.
	 *
	 * @param webformTables the webform tables
	 */
	@Override
	public void cacheResult(List<WebformTable> webformTables) {
		for (WebformTable webformTable : webformTables) {
			if (EntityCacheUtil.getResult(
						WebformTableModelImpl.ENTITY_CACHE_ENABLED,
						WebformTableImpl.class, webformTable.getPrimaryKey()) == null) {
				cacheResult(webformTable);
			}
			else {
				webformTable.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all webform tables.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WebformTableImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WebformTableImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the webform table.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WebformTable webformTable) {
		EntityCacheUtil.removeResult(WebformTableModelImpl.ENTITY_CACHE_ENABLED,
			WebformTableImpl.class, webformTable.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(webformTable);
	}

	@Override
	public void clearCache(List<WebformTable> webformTables) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WebformTable webformTable : webformTables) {
			EntityCacheUtil.removeResult(WebformTableModelImpl.ENTITY_CACHE_ENABLED,
				WebformTableImpl.class, webformTable.getPrimaryKey());

			clearUniqueFindersCache(webformTable);
		}
	}

	protected void cacheUniqueFindersCache(WebformTable webformTable) {
		if (webformTable.isNew()) {
			Object[] args = new Object[] { webformTable.getPortletId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PORTLETID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORTLETID, args,
				webformTable);

			args = new Object[] {
					webformTable.getPortletId(),
					webformTable.getWebformCounter()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PORTLETIDANDCOUNTER,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORTLETIDANDCOUNTER,
				args, webformTable);

			args = new Object[] { webformTable.getWebformName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_WEBFORMNAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WEBFORMNAME, args,
				webformTable);
		}
		else {
			WebformTableModelImpl webformTableModelImpl = (WebformTableModelImpl)webformTable;

			if ((webformTableModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PORTLETID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { webformTable.getPortletId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PORTLETID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORTLETID, args,
					webformTable);
			}

			if ((webformTableModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PORTLETIDANDCOUNTER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						webformTable.getPortletId(),
						webformTable.getWebformCounter()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PORTLETIDANDCOUNTER,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORTLETIDANDCOUNTER,
					args, webformTable);
			}

			if ((webformTableModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_WEBFORMNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { webformTable.getWebformName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_WEBFORMNAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WEBFORMNAME,
					args, webformTable);
			}
		}
	}

	protected void clearUniqueFindersCache(WebformTable webformTable) {
		WebformTableModelImpl webformTableModelImpl = (WebformTableModelImpl)webformTable;

		Object[] args = new Object[] { webformTable.getPortletId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTLETID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORTLETID, args);

		if ((webformTableModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PORTLETID.getColumnBitmask()) != 0) {
			args = new Object[] { webformTableModelImpl.getOriginalPortletId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTLETID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORTLETID, args);
		}

		args = new Object[] {
				webformTable.getPortletId(), webformTable.getWebformCounter()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTLETIDANDCOUNTER,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORTLETIDANDCOUNTER,
			args);

		if ((webformTableModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PORTLETIDANDCOUNTER.getColumnBitmask()) != 0) {
			args = new Object[] {
					webformTableModelImpl.getOriginalPortletId(),
					webformTableModelImpl.getOriginalWebformCounter()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTLETIDANDCOUNTER,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORTLETIDANDCOUNTER,
				args);
		}

		args = new Object[] { webformTable.getWebformName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WEBFORMNAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WEBFORMNAME, args);

		if ((webformTableModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_WEBFORMNAME.getColumnBitmask()) != 0) {
			args = new Object[] { webformTableModelImpl.getOriginalWebformName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WEBFORMNAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WEBFORMNAME, args);
		}
	}

	/**
	 * Creates a new webform table with the primary key. Does not add the webform table to the database.
	 *
	 * @param webformTableId the primary key for the new webform table
	 * @return the new webform table
	 */
	@Override
	public WebformTable create(long webformTableId) {
		WebformTable webformTable = new WebformTableImpl();

		webformTable.setNew(true);
		webformTable.setPrimaryKey(webformTableId);

		return webformTable;
	}

	/**
	 * Removes the webform table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param webformTableId the primary key of the webform table
	 * @return the webform table that was removed
	 * @throws com.rcs.dbService.NoSuchWebformTableException if a webform table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformTable remove(long webformTableId)
		throws NoSuchWebformTableException, SystemException {
		return remove((Serializable)webformTableId);
	}

	/**
	 * Removes the webform table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the webform table
	 * @return the webform table that was removed
	 * @throws com.rcs.dbService.NoSuchWebformTableException if a webform table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformTable remove(Serializable primaryKey)
		throws NoSuchWebformTableException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WebformTable webformTable = (WebformTable)session.get(WebformTableImpl.class,
					primaryKey);

			if (webformTable == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWebformTableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(webformTable);
		}
		catch (NoSuchWebformTableException nsee) {
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
	protected WebformTable removeImpl(WebformTable webformTable)
		throws SystemException {
		webformTable = toUnwrappedModel(webformTable);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(webformTable)) {
				webformTable = (WebformTable)session.get(WebformTableImpl.class,
						webformTable.getPrimaryKeyObj());
			}

			if (webformTable != null) {
				session.delete(webformTable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (webformTable != null) {
			clearCache(webformTable);
		}

		return webformTable;
	}

	@Override
	public WebformTable updateImpl(
		com.rcs.dbService.model.WebformTable webformTable)
		throws SystemException {
		webformTable = toUnwrappedModel(webformTable);

		boolean isNew = webformTable.isNew();

		Session session = null;

		try {
			session = openSession();

			if (webformTable.isNew()) {
				session.save(webformTable);

				webformTable.setNew(false);
			}
			else {
				session.merge(webformTable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WebformTableModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(WebformTableModelImpl.ENTITY_CACHE_ENABLED,
			WebformTableImpl.class, webformTable.getPrimaryKey(), webformTable);

		clearUniqueFindersCache(webformTable);
		cacheUniqueFindersCache(webformTable);

		return webformTable;
	}

	protected WebformTable toUnwrappedModel(WebformTable webformTable) {
		if (webformTable instanceof WebformTableImpl) {
			return webformTable;
		}

		WebformTableImpl webformTableImpl = new WebformTableImpl();

		webformTableImpl.setNew(webformTable.isNew());
		webformTableImpl.setPrimaryKey(webformTable.getPrimaryKey());

		webformTableImpl.setWebformTableId(webformTable.getWebformTableId());
		webformTableImpl.setPortletId(webformTable.getPortletId());
		webformTableImpl.setWebformCounter(webformTable.getWebformCounter());
		webformTableImpl.setWebformName(webformTable.getWebformName());

		return webformTableImpl;
	}

	/**
	 * Returns the webform table with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the webform table
	 * @return the webform table
	 * @throws com.rcs.dbService.NoSuchWebformTableException if a webform table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformTable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWebformTableException, SystemException {
		WebformTable webformTable = fetchByPrimaryKey(primaryKey);

		if (webformTable == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWebformTableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return webformTable;
	}

	/**
	 * Returns the webform table with the primary key or throws a {@link com.rcs.dbService.NoSuchWebformTableException} if it could not be found.
	 *
	 * @param webformTableId the primary key of the webform table
	 * @return the webform table
	 * @throws com.rcs.dbService.NoSuchWebformTableException if a webform table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformTable findByPrimaryKey(long webformTableId)
		throws NoSuchWebformTableException, SystemException {
		return findByPrimaryKey((Serializable)webformTableId);
	}

	/**
	 * Returns the webform table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the webform table
	 * @return the webform table, or <code>null</code> if a webform table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformTable fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		WebformTable webformTable = (WebformTable)EntityCacheUtil.getResult(WebformTableModelImpl.ENTITY_CACHE_ENABLED,
				WebformTableImpl.class, primaryKey);

		if (webformTable == _nullWebformTable) {
			return null;
		}

		if (webformTable == null) {
			Session session = null;

			try {
				session = openSession();

				webformTable = (WebformTable)session.get(WebformTableImpl.class,
						primaryKey);

				if (webformTable != null) {
					cacheResult(webformTable);
				}
				else {
					EntityCacheUtil.putResult(WebformTableModelImpl.ENTITY_CACHE_ENABLED,
						WebformTableImpl.class, primaryKey, _nullWebformTable);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(WebformTableModelImpl.ENTITY_CACHE_ENABLED,
					WebformTableImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return webformTable;
	}

	/**
	 * Returns the webform table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param webformTableId the primary key of the webform table
	 * @return the webform table, or <code>null</code> if a webform table with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebformTable fetchByPrimaryKey(long webformTableId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)webformTableId);
	}

	/**
	 * Returns all the webform tables.
	 *
	 * @return the webform tables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebformTable> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the webform tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.WebformTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of webform tables
	 * @param end the upper bound of the range of webform tables (not inclusive)
	 * @return the range of webform tables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebformTable> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the webform tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.WebformTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of webform tables
	 * @param end the upper bound of the range of webform tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of webform tables
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebformTable> findAll(int start, int end,
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

		List<WebformTable> list = (List<WebformTable>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WEBFORMTABLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WEBFORMTABLE;

				if (pagination) {
					sql = sql.concat(WebformTableModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WebformTable>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WebformTable>(list);
				}
				else {
					list = (List<WebformTable>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the webform tables from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (WebformTable webformTable : findAll()) {
			remove(webformTable);
		}
	}

	/**
	 * Returns the number of webform tables.
	 *
	 * @return the number of webform tables
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

				Query q = session.createQuery(_SQL_COUNT_WEBFORMTABLE);

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

	/**
	 * Initializes the webform table persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rcs.dbService.model.WebformTable")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WebformTable>> listenersList = new ArrayList<ModelListener<WebformTable>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WebformTable>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WebformTableImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_WEBFORMTABLE = "SELECT webformTable FROM WebformTable webformTable";
	private static final String _SQL_SELECT_WEBFORMTABLE_WHERE = "SELECT webformTable FROM WebformTable webformTable WHERE ";
	private static final String _SQL_COUNT_WEBFORMTABLE = "SELECT COUNT(webformTable) FROM WebformTable webformTable";
	private static final String _SQL_COUNT_WEBFORMTABLE_WHERE = "SELECT COUNT(webformTable) FROM WebformTable webformTable WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "webformTable.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WebformTable exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WebformTable exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WebformTablePersistenceImpl.class);
	private static WebformTable _nullWebformTable = new WebformTableImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WebformTable> toCacheModel() {
				return _nullWebformTableCacheModel;
			}
		};

	private static CacheModel<WebformTable> _nullWebformTableCacheModel = new CacheModel<WebformTable>() {
			@Override
			public WebformTable toEntityModel() {
				return _nullWebformTable;
			}
		};
}