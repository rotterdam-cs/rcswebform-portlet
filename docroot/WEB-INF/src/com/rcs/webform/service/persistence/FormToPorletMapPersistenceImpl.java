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

package com.rcs.webform.service.persistence;

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

import com.rcs.webform.NoSuchFormToPorletMapException;
import com.rcs.webform.model.FormToPorletMap;
import com.rcs.webform.model.impl.FormToPorletMapImpl;
import com.rcs.webform.model.impl.FormToPorletMapModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the form to porlet map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ryusuf
 * @see FormToPorletMapPersistence
 * @see FormToPorletMapUtil
 * @generated
 */
public class FormToPorletMapPersistenceImpl extends BasePersistenceImpl<FormToPorletMap>
	implements FormToPorletMapPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FormToPorletMapUtil} to access the form to porlet map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FormToPorletMapImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FormToPorletMapModelImpl.ENTITY_CACHE_ENABLED,
			FormToPorletMapModelImpl.FINDER_CACHE_ENABLED,
			FormToPorletMapImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FormToPorletMapModelImpl.ENTITY_CACHE_ENABLED,
			FormToPorletMapModelImpl.FINDER_CACHE_ENABLED,
			FormToPorletMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FormToPorletMapModelImpl.ENTITY_CACHE_ENABLED,
			FormToPorletMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_GROUPCOLUMNPORTLETID = new FinderPath(FormToPorletMapModelImpl.ENTITY_CACHE_ENABLED,
			FormToPorletMapModelImpl.FINDER_CACHE_ENABLED,
			FormToPorletMapImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByGroupColumnPortletId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			FormToPorletMapModelImpl.GROUPID_COLUMN_BITMASK |
			FormToPorletMapModelImpl.COMPANYID_COLUMN_BITMASK |
			FormToPorletMapModelImpl.PORTLETID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPCOLUMNPORTLETID = new FinderPath(FormToPorletMapModelImpl.ENTITY_CACHE_ENABLED,
			FormToPorletMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupColumnPortletId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the form to porlet map where groupId = &#63; and companyId = &#63; and portletId = &#63; or throws a {@link com.rcs.webform.NoSuchFormToPorletMapException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @return the matching form to porlet map
	 * @throws com.rcs.webform.NoSuchFormToPorletMapException if a matching form to porlet map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormToPorletMap findByGroupColumnPortletId(long groupId,
		long companyId, String portletId)
		throws NoSuchFormToPorletMapException, SystemException {
		FormToPorletMap formToPorletMap = fetchByGroupColumnPortletId(groupId,
				companyId, portletId);

		if (formToPorletMap == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", companyId=");
			msg.append(companyId);

			msg.append(", portletId=");
			msg.append(portletId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFormToPorletMapException(msg.toString());
		}

		return formToPorletMap;
	}

	/**
	 * Returns the form to porlet map where groupId = &#63; and companyId = &#63; and portletId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @return the matching form to porlet map, or <code>null</code> if a matching form to porlet map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormToPorletMap fetchByGroupColumnPortletId(long groupId,
		long companyId, String portletId) throws SystemException {
		return fetchByGroupColumnPortletId(groupId, companyId, portletId, true);
	}

	/**
	 * Returns the form to porlet map where groupId = &#63; and companyId = &#63; and portletId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching form to porlet map, or <code>null</code> if a matching form to porlet map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormToPorletMap fetchByGroupColumnPortletId(long groupId,
		long companyId, String portletId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, companyId, portletId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GROUPCOLUMNPORTLETID,
					finderArgs, this);
		}

		if (result instanceof FormToPorletMap) {
			FormToPorletMap formToPorletMap = (FormToPorletMap)result;

			if ((groupId != formToPorletMap.getGroupId()) ||
					(companyId != formToPorletMap.getCompanyId()) ||
					!Validator.equals(portletId, formToPorletMap.getPortletId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_FORMTOPORLETMAP_WHERE);

			query.append(_FINDER_COLUMN_GROUPCOLUMNPORTLETID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPCOLUMNPORTLETID_COMPANYID_2);

			boolean bindPortletId = false;

			if (portletId == null) {
				query.append(_FINDER_COLUMN_GROUPCOLUMNPORTLETID_PORTLETID_1);
			}
			else if (portletId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPCOLUMNPORTLETID_PORTLETID_3);
			}
			else {
				bindPortletId = true;

				query.append(_FINDER_COLUMN_GROUPCOLUMNPORTLETID_PORTLETID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				if (bindPortletId) {
					qPos.add(portletId);
				}

				List<FormToPorletMap> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPCOLUMNPORTLETID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"FormToPorletMapPersistenceImpl.fetchByGroupColumnPortletId(long, long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					FormToPorletMap formToPorletMap = list.get(0);

					result = formToPorletMap;

					cacheResult(formToPorletMap);

					if ((formToPorletMap.getGroupId() != groupId) ||
							(formToPorletMap.getCompanyId() != companyId) ||
							(formToPorletMap.getPortletId() == null) ||
							!formToPorletMap.getPortletId().equals(portletId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPCOLUMNPORTLETID,
							finderArgs, formToPorletMap);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPCOLUMNPORTLETID,
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
			return (FormToPorletMap)result;
		}
	}

	/**
	 * Removes the form to porlet map where groupId = &#63; and companyId = &#63; and portletId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @return the form to porlet map that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormToPorletMap removeByGroupColumnPortletId(long groupId,
		long companyId, String portletId)
		throws NoSuchFormToPorletMapException, SystemException {
		FormToPorletMap formToPorletMap = findByGroupColumnPortletId(groupId,
				companyId, portletId);

		return remove(formToPorletMap);
	}

	/**
	 * Returns the number of form to porlet maps where groupId = &#63; and companyId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param portletId the portlet ID
	 * @return the number of matching form to porlet maps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupColumnPortletId(long groupId, long companyId,
		String portletId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPCOLUMNPORTLETID;

		Object[] finderArgs = new Object[] { groupId, companyId, portletId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_FORMTOPORLETMAP_WHERE);

			query.append(_FINDER_COLUMN_GROUPCOLUMNPORTLETID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPCOLUMNPORTLETID_COMPANYID_2);

			boolean bindPortletId = false;

			if (portletId == null) {
				query.append(_FINDER_COLUMN_GROUPCOLUMNPORTLETID_PORTLETID_1);
			}
			else if (portletId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPCOLUMNPORTLETID_PORTLETID_3);
			}
			else {
				bindPortletId = true;

				query.append(_FINDER_COLUMN_GROUPCOLUMNPORTLETID_PORTLETID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_GROUPCOLUMNPORTLETID_GROUPID_2 = "formToPorletMap.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPCOLUMNPORTLETID_COMPANYID_2 = "formToPorletMap.companyId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPCOLUMNPORTLETID_PORTLETID_1 = "formToPorletMap.portletId IS NULL";
	private static final String _FINDER_COLUMN_GROUPCOLUMNPORTLETID_PORTLETID_2 = "formToPorletMap.portletId = ?";
	private static final String _FINDER_COLUMN_GROUPCOLUMNPORTLETID_PORTLETID_3 = "(formToPorletMap.portletId IS NULL OR formToPorletMap.portletId = '')";

	public FormToPorletMapPersistenceImpl() {
		setModelClass(FormToPorletMap.class);
	}

	/**
	 * Caches the form to porlet map in the entity cache if it is enabled.
	 *
	 * @param formToPorletMap the form to porlet map
	 */
	@Override
	public void cacheResult(FormToPorletMap formToPorletMap) {
		EntityCacheUtil.putResult(FormToPorletMapModelImpl.ENTITY_CACHE_ENABLED,
			FormToPorletMapImpl.class, formToPorletMap.getPrimaryKey(),
			formToPorletMap);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPCOLUMNPORTLETID,
			new Object[] {
				formToPorletMap.getGroupId(), formToPorletMap.getCompanyId(),
				formToPorletMap.getPortletId()
			}, formToPorletMap);

		formToPorletMap.resetOriginalValues();
	}

	/**
	 * Caches the form to porlet maps in the entity cache if it is enabled.
	 *
	 * @param formToPorletMaps the form to porlet maps
	 */
	@Override
	public void cacheResult(List<FormToPorletMap> formToPorletMaps) {
		for (FormToPorletMap formToPorletMap : formToPorletMaps) {
			if (EntityCacheUtil.getResult(
						FormToPorletMapModelImpl.ENTITY_CACHE_ENABLED,
						FormToPorletMapImpl.class,
						formToPorletMap.getPrimaryKey()) == null) {
				cacheResult(formToPorletMap);
			}
			else {
				formToPorletMap.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all form to porlet maps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FormToPorletMapImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FormToPorletMapImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the form to porlet map.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FormToPorletMap formToPorletMap) {
		EntityCacheUtil.removeResult(FormToPorletMapModelImpl.ENTITY_CACHE_ENABLED,
			FormToPorletMapImpl.class, formToPorletMap.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(formToPorletMap);
	}

	@Override
	public void clearCache(List<FormToPorletMap> formToPorletMaps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FormToPorletMap formToPorletMap : formToPorletMaps) {
			EntityCacheUtil.removeResult(FormToPorletMapModelImpl.ENTITY_CACHE_ENABLED,
				FormToPorletMapImpl.class, formToPorletMap.getPrimaryKey());

			clearUniqueFindersCache(formToPorletMap);
		}
	}

	protected void cacheUniqueFindersCache(FormToPorletMap formToPorletMap) {
		if (formToPorletMap.isNew()) {
			Object[] args = new Object[] {
					formToPorletMap.getGroupId(), formToPorletMap.getCompanyId(),
					formToPorletMap.getPortletId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPCOLUMNPORTLETID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPCOLUMNPORTLETID,
				args, formToPorletMap);
		}
		else {
			FormToPorletMapModelImpl formToPorletMapModelImpl = (FormToPorletMapModelImpl)formToPorletMap;

			if ((formToPorletMapModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GROUPCOLUMNPORTLETID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						formToPorletMap.getGroupId(),
						formToPorletMap.getCompanyId(),
						formToPorletMap.getPortletId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPCOLUMNPORTLETID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPCOLUMNPORTLETID,
					args, formToPorletMap);
			}
		}
	}

	protected void clearUniqueFindersCache(FormToPorletMap formToPorletMap) {
		FormToPorletMapModelImpl formToPorletMapModelImpl = (FormToPorletMapModelImpl)formToPorletMap;

		Object[] args = new Object[] {
				formToPorletMap.getGroupId(), formToPorletMap.getCompanyId(),
				formToPorletMap.getPortletId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPCOLUMNPORTLETID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPCOLUMNPORTLETID,
			args);

		if ((formToPorletMapModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GROUPCOLUMNPORTLETID.getColumnBitmask()) != 0) {
			args = new Object[] {
					formToPorletMapModelImpl.getOriginalGroupId(),
					formToPorletMapModelImpl.getOriginalCompanyId(),
					formToPorletMapModelImpl.getOriginalPortletId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPCOLUMNPORTLETID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPCOLUMNPORTLETID,
				args);
		}
	}

	/**
	 * Creates a new form to porlet map with the primary key. Does not add the form to porlet map to the database.
	 *
	 * @param formToPorletMapId the primary key for the new form to porlet map
	 * @return the new form to porlet map
	 */
	@Override
	public FormToPorletMap create(long formToPorletMapId) {
		FormToPorletMap formToPorletMap = new FormToPorletMapImpl();

		formToPorletMap.setNew(true);
		formToPorletMap.setPrimaryKey(formToPorletMapId);

		return formToPorletMap;
	}

	/**
	 * Removes the form to porlet map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formToPorletMapId the primary key of the form to porlet map
	 * @return the form to porlet map that was removed
	 * @throws com.rcs.webform.NoSuchFormToPorletMapException if a form to porlet map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormToPorletMap remove(long formToPorletMapId)
		throws NoSuchFormToPorletMapException, SystemException {
		return remove((Serializable)formToPorletMapId);
	}

	/**
	 * Removes the form to porlet map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the form to porlet map
	 * @return the form to porlet map that was removed
	 * @throws com.rcs.webform.NoSuchFormToPorletMapException if a form to porlet map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormToPorletMap remove(Serializable primaryKey)
		throws NoSuchFormToPorletMapException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FormToPorletMap formToPorletMap = (FormToPorletMap)session.get(FormToPorletMapImpl.class,
					primaryKey);

			if (formToPorletMap == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFormToPorletMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(formToPorletMap);
		}
		catch (NoSuchFormToPorletMapException nsee) {
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
	protected FormToPorletMap removeImpl(FormToPorletMap formToPorletMap)
		throws SystemException {
		formToPorletMap = toUnwrappedModel(formToPorletMap);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(formToPorletMap)) {
				formToPorletMap = (FormToPorletMap)session.get(FormToPorletMapImpl.class,
						formToPorletMap.getPrimaryKeyObj());
			}

			if (formToPorletMap != null) {
				session.delete(formToPorletMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (formToPorletMap != null) {
			clearCache(formToPorletMap);
		}

		return formToPorletMap;
	}

	@Override
	public FormToPorletMap updateImpl(
		com.rcs.webform.model.FormToPorletMap formToPorletMap)
		throws SystemException {
		formToPorletMap = toUnwrappedModel(formToPorletMap);

		boolean isNew = formToPorletMap.isNew();

		Session session = null;

		try {
			session = openSession();

			if (formToPorletMap.isNew()) {
				session.save(formToPorletMap);

				formToPorletMap.setNew(false);
			}
			else {
				session.merge(formToPorletMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FormToPorletMapModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(FormToPorletMapModelImpl.ENTITY_CACHE_ENABLED,
			FormToPorletMapImpl.class, formToPorletMap.getPrimaryKey(),
			formToPorletMap);

		clearUniqueFindersCache(formToPorletMap);
		cacheUniqueFindersCache(formToPorletMap);

		return formToPorletMap;
	}

	protected FormToPorletMap toUnwrappedModel(FormToPorletMap formToPorletMap) {
		if (formToPorletMap instanceof FormToPorletMapImpl) {
			return formToPorletMap;
		}

		FormToPorletMapImpl formToPorletMapImpl = new FormToPorletMapImpl();

		formToPorletMapImpl.setNew(formToPorletMap.isNew());
		formToPorletMapImpl.setPrimaryKey(formToPorletMap.getPrimaryKey());

		formToPorletMapImpl.setFormToPorletMapId(formToPorletMap.getFormToPorletMapId());
		formToPorletMapImpl.setGroupId(formToPorletMap.getGroupId());
		formToPorletMapImpl.setCompanyId(formToPorletMap.getCompanyId());
		formToPorletMapImpl.setUserId(formToPorletMap.getUserId());
		formToPorletMapImpl.setUserName(formToPorletMap.getUserName());
		formToPorletMapImpl.setCreateDate(formToPorletMap.getCreateDate());
		formToPorletMapImpl.setModifiedDate(formToPorletMap.getModifiedDate());
		formToPorletMapImpl.setFormId(formToPorletMap.getFormId());
		formToPorletMapImpl.setPortletId(formToPorletMap.getPortletId());

		return formToPorletMapImpl;
	}

	/**
	 * Returns the form to porlet map with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the form to porlet map
	 * @return the form to porlet map
	 * @throws com.rcs.webform.NoSuchFormToPorletMapException if a form to porlet map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormToPorletMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFormToPorletMapException, SystemException {
		FormToPorletMap formToPorletMap = fetchByPrimaryKey(primaryKey);

		if (formToPorletMap == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFormToPorletMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return formToPorletMap;
	}

	/**
	 * Returns the form to porlet map with the primary key or throws a {@link com.rcs.webform.NoSuchFormToPorletMapException} if it could not be found.
	 *
	 * @param formToPorletMapId the primary key of the form to porlet map
	 * @return the form to porlet map
	 * @throws com.rcs.webform.NoSuchFormToPorletMapException if a form to porlet map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormToPorletMap findByPrimaryKey(long formToPorletMapId)
		throws NoSuchFormToPorletMapException, SystemException {
		return findByPrimaryKey((Serializable)formToPorletMapId);
	}

	/**
	 * Returns the form to porlet map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the form to porlet map
	 * @return the form to porlet map, or <code>null</code> if a form to porlet map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormToPorletMap fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FormToPorletMap formToPorletMap = (FormToPorletMap)EntityCacheUtil.getResult(FormToPorletMapModelImpl.ENTITY_CACHE_ENABLED,
				FormToPorletMapImpl.class, primaryKey);

		if (formToPorletMap == _nullFormToPorletMap) {
			return null;
		}

		if (formToPorletMap == null) {
			Session session = null;

			try {
				session = openSession();

				formToPorletMap = (FormToPorletMap)session.get(FormToPorletMapImpl.class,
						primaryKey);

				if (formToPorletMap != null) {
					cacheResult(formToPorletMap);
				}
				else {
					EntityCacheUtil.putResult(FormToPorletMapModelImpl.ENTITY_CACHE_ENABLED,
						FormToPorletMapImpl.class, primaryKey,
						_nullFormToPorletMap);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FormToPorletMapModelImpl.ENTITY_CACHE_ENABLED,
					FormToPorletMapImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return formToPorletMap;
	}

	/**
	 * Returns the form to porlet map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formToPorletMapId the primary key of the form to porlet map
	 * @return the form to porlet map, or <code>null</code> if a form to porlet map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormToPorletMap fetchByPrimaryKey(long formToPorletMapId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)formToPorletMapId);
	}

	/**
	 * Returns all the form to porlet maps.
	 *
	 * @return the form to porlet maps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FormToPorletMap> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form to porlet maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormToPorletMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of form to porlet maps
	 * @param end the upper bound of the range of form to porlet maps (not inclusive)
	 * @return the range of form to porlet maps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FormToPorletMap> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the form to porlet maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormToPorletMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of form to porlet maps
	 * @param end the upper bound of the range of form to porlet maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of form to porlet maps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FormToPorletMap> findAll(int start, int end,
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

		List<FormToPorletMap> list = (List<FormToPorletMap>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FORMTOPORLETMAP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FORMTOPORLETMAP;

				if (pagination) {
					sql = sql.concat(FormToPorletMapModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FormToPorletMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FormToPorletMap>(list);
				}
				else {
					list = (List<FormToPorletMap>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the form to porlet maps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FormToPorletMap formToPorletMap : findAll()) {
			remove(formToPorletMap);
		}
	}

	/**
	 * Returns the number of form to porlet maps.
	 *
	 * @return the number of form to porlet maps
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

				Query q = session.createQuery(_SQL_COUNT_FORMTOPORLETMAP);

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
	 * Initializes the form to porlet map persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rcs.webform.model.FormToPorletMap")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FormToPorletMap>> listenersList = new ArrayList<ModelListener<FormToPorletMap>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FormToPorletMap>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FormToPorletMapImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FORMTOPORLETMAP = "SELECT formToPorletMap FROM FormToPorletMap formToPorletMap";
	private static final String _SQL_SELECT_FORMTOPORLETMAP_WHERE = "SELECT formToPorletMap FROM FormToPorletMap formToPorletMap WHERE ";
	private static final String _SQL_COUNT_FORMTOPORLETMAP = "SELECT COUNT(formToPorletMap) FROM FormToPorletMap formToPorletMap";
	private static final String _SQL_COUNT_FORMTOPORLETMAP_WHERE = "SELECT COUNT(formToPorletMap) FROM FormToPorletMap formToPorletMap WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "formToPorletMap.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FormToPorletMap exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FormToPorletMap exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FormToPorletMapPersistenceImpl.class);
	private static FormToPorletMap _nullFormToPorletMap = new FormToPorletMapImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FormToPorletMap> toCacheModel() {
				return _nullFormToPorletMapCacheModel;
			}
		};

	private static CacheModel<FormToPorletMap> _nullFormToPorletMapCacheModel = new CacheModel<FormToPorletMap>() {
			@Override
			public FormToPorletMap toEntityModel() {
				return _nullFormToPorletMap;
			}
		};
}