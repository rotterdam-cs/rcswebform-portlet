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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rcs.webform.NoSuchSubmittedDataException;
import com.rcs.webform.model.SubmittedData;
import com.rcs.webform.model.impl.SubmittedDataImpl;
import com.rcs.webform.model.impl.SubmittedDataModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the submitted data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ryusuf
 * @see SubmittedDataPersistence
 * @see SubmittedDataUtil
 * @generated
 */
public class SubmittedDataPersistenceImpl extends BasePersistenceImpl<SubmittedData>
	implements SubmittedDataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SubmittedDataUtil} to access the submitted data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SubmittedDataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubmittedDataModelImpl.ENTITY_CACHE_ENABLED,
			SubmittedDataModelImpl.FINDER_CACHE_ENABLED,
			SubmittedDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubmittedDataModelImpl.ENTITY_CACHE_ENABLED,
			SubmittedDataModelImpl.FINDER_CACHE_ENABLED,
			SubmittedDataImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubmittedDataModelImpl.ENTITY_CACHE_ENABLED,
			SubmittedDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FORMIDSUBMITTEDIDANDACTIVE =
		new FinderPath(SubmittedDataModelImpl.ENTITY_CACHE_ENABLED,
			SubmittedDataModelImpl.FINDER_CACHE_ENABLED,
			SubmittedDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByFormIdSubmittedIdAndActive",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FORMIDSUBMITTEDIDANDACTIVE =
		new FinderPath(SubmittedDataModelImpl.ENTITY_CACHE_ENABLED,
			SubmittedDataModelImpl.FINDER_CACHE_ENABLED,
			SubmittedDataImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFormIdSubmittedIdAndActive",
			new String[] { Long.class.getName(), Long.class.getName() },
			SubmittedDataModelImpl.FORMID_COLUMN_BITMASK |
			SubmittedDataModelImpl.SUBMITTEDDATAID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FORMIDSUBMITTEDIDANDACTIVE =
		new FinderPath(SubmittedDataModelImpl.ENTITY_CACHE_ENABLED,
			SubmittedDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFormIdSubmittedIdAndActive",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the submitted datas where formId = &#63; and submittedDataId = &#63;.
	 *
	 * @param formId the form ID
	 * @param submittedDataId the submitted data ID
	 * @return the matching submitted datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmittedData> findByFormIdSubmittedIdAndActive(long formId,
		long submittedDataId) throws SystemException {
		return findByFormIdSubmittedIdAndActive(formId, submittedDataId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submitted datas where formId = &#63; and submittedDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.SubmittedDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param submittedDataId the submitted data ID
	 * @param start the lower bound of the range of submitted datas
	 * @param end the upper bound of the range of submitted datas (not inclusive)
	 * @return the range of matching submitted datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmittedData> findByFormIdSubmittedIdAndActive(long formId,
		long submittedDataId, int start, int end) throws SystemException {
		return findByFormIdSubmittedIdAndActive(formId, submittedDataId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the submitted datas where formId = &#63; and submittedDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.SubmittedDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param submittedDataId the submitted data ID
	 * @param start the lower bound of the range of submitted datas
	 * @param end the upper bound of the range of submitted datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching submitted datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmittedData> findByFormIdSubmittedIdAndActive(long formId,
		long submittedDataId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FORMIDSUBMITTEDIDANDACTIVE;
			finderArgs = new Object[] { formId, submittedDataId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FORMIDSUBMITTEDIDANDACTIVE;
			finderArgs = new Object[] {
					formId, submittedDataId,
					
					start, end, orderByComparator
				};
		}

		List<SubmittedData> list = (List<SubmittedData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SubmittedData submittedData : list) {
				if ((formId != submittedData.getFormId()) ||
						(submittedDataId != submittedData.getSubmittedDataId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SUBMITTEDDATA_WHERE);

			query.append(_FINDER_COLUMN_FORMIDSUBMITTEDIDANDACTIVE_FORMID_2);

			query.append(_FINDER_COLUMN_FORMIDSUBMITTEDIDANDACTIVE_SUBMITTEDDATAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubmittedDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(formId);

				qPos.add(submittedDataId);

				if (!pagination) {
					list = (List<SubmittedData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SubmittedData>(list);
				}
				else {
					list = (List<SubmittedData>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first submitted data in the ordered set where formId = &#63; and submittedDataId = &#63;.
	 *
	 * @param formId the form ID
	 * @param submittedDataId the submitted data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submitted data
	 * @throws com.rcs.webform.NoSuchSubmittedDataException if a matching submitted data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmittedData findByFormIdSubmittedIdAndActive_First(long formId,
		long submittedDataId, OrderByComparator orderByComparator)
		throws NoSuchSubmittedDataException, SystemException {
		SubmittedData submittedData = fetchByFormIdSubmittedIdAndActive_First(formId,
				submittedDataId, orderByComparator);

		if (submittedData != null) {
			return submittedData;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("formId=");
		msg.append(formId);

		msg.append(", submittedDataId=");
		msg.append(submittedDataId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmittedDataException(msg.toString());
	}

	/**
	 * Returns the first submitted data in the ordered set where formId = &#63; and submittedDataId = &#63;.
	 *
	 * @param formId the form ID
	 * @param submittedDataId the submitted data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submitted data, or <code>null</code> if a matching submitted data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmittedData fetchByFormIdSubmittedIdAndActive_First(long formId,
		long submittedDataId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SubmittedData> list = findByFormIdSubmittedIdAndActive(formId,
				submittedDataId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submitted data in the ordered set where formId = &#63; and submittedDataId = &#63;.
	 *
	 * @param formId the form ID
	 * @param submittedDataId the submitted data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submitted data
	 * @throws com.rcs.webform.NoSuchSubmittedDataException if a matching submitted data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmittedData findByFormIdSubmittedIdAndActive_Last(long formId,
		long submittedDataId, OrderByComparator orderByComparator)
		throws NoSuchSubmittedDataException, SystemException {
		SubmittedData submittedData = fetchByFormIdSubmittedIdAndActive_Last(formId,
				submittedDataId, orderByComparator);

		if (submittedData != null) {
			return submittedData;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("formId=");
		msg.append(formId);

		msg.append(", submittedDataId=");
		msg.append(submittedDataId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmittedDataException(msg.toString());
	}

	/**
	 * Returns the last submitted data in the ordered set where formId = &#63; and submittedDataId = &#63;.
	 *
	 * @param formId the form ID
	 * @param submittedDataId the submitted data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submitted data, or <code>null</code> if a matching submitted data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmittedData fetchByFormIdSubmittedIdAndActive_Last(long formId,
		long submittedDataId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByFormIdSubmittedIdAndActive(formId, submittedDataId);

		if (count == 0) {
			return null;
		}

		List<SubmittedData> list = findByFormIdSubmittedIdAndActive(formId,
				submittedDataId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submitted datas before and after the current submitted data in the ordered set where formId = &#63; and submittedDataId = &#63;.
	 *
	 * @param submittedDataPK the primary key of the current submitted data
	 * @param formId the form ID
	 * @param submittedDataId the submitted data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submitted data
	 * @throws com.rcs.webform.NoSuchSubmittedDataException if a submitted data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmittedData[] findByFormIdSubmittedIdAndActive_PrevAndNext(
		SubmittedDataPK submittedDataPK, long formId, long submittedDataId,
		OrderByComparator orderByComparator)
		throws NoSuchSubmittedDataException, SystemException {
		SubmittedData submittedData = findByPrimaryKey(submittedDataPK);

		Session session = null;

		try {
			session = openSession();

			SubmittedData[] array = new SubmittedDataImpl[3];

			array[0] = getByFormIdSubmittedIdAndActive_PrevAndNext(session,
					submittedData, formId, submittedDataId, orderByComparator,
					true);

			array[1] = submittedData;

			array[2] = getByFormIdSubmittedIdAndActive_PrevAndNext(session,
					submittedData, formId, submittedDataId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SubmittedData getByFormIdSubmittedIdAndActive_PrevAndNext(
		Session session, SubmittedData submittedData, long formId,
		long submittedDataId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMITTEDDATA_WHERE);

		query.append(_FINDER_COLUMN_FORMIDSUBMITTEDIDANDACTIVE_FORMID_2);

		query.append(_FINDER_COLUMN_FORMIDSUBMITTEDIDANDACTIVE_SUBMITTEDDATAID_2);

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
			query.append(SubmittedDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(formId);

		qPos.add(submittedDataId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(submittedData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SubmittedData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submitted datas where formId = &#63; and submittedDataId = &#63; from the database.
	 *
	 * @param formId the form ID
	 * @param submittedDataId the submitted data ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFormIdSubmittedIdAndActive(long formId,
		long submittedDataId) throws SystemException {
		for (SubmittedData submittedData : findByFormIdSubmittedIdAndActive(
				formId, submittedDataId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(submittedData);
		}
	}

	/**
	 * Returns the number of submitted datas where formId = &#63; and submittedDataId = &#63;.
	 *
	 * @param formId the form ID
	 * @param submittedDataId the submitted data ID
	 * @return the number of matching submitted datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFormIdSubmittedIdAndActive(long formId,
		long submittedDataId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FORMIDSUBMITTEDIDANDACTIVE;

		Object[] finderArgs = new Object[] { formId, submittedDataId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SUBMITTEDDATA_WHERE);

			query.append(_FINDER_COLUMN_FORMIDSUBMITTEDIDANDACTIVE_FORMID_2);

			query.append(_FINDER_COLUMN_FORMIDSUBMITTEDIDANDACTIVE_SUBMITTEDDATAID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(formId);

				qPos.add(submittedDataId);

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

	private static final String _FINDER_COLUMN_FORMIDSUBMITTEDIDANDACTIVE_FORMID_2 =
		"submittedData.id.formId = ? AND ";
	private static final String _FINDER_COLUMN_FORMIDSUBMITTEDIDANDACTIVE_SUBMITTEDDATAID_2 =
		"submittedData.id.submittedDataId = ? AND submittedData.active=true";

	public SubmittedDataPersistenceImpl() {
		setModelClass(SubmittedData.class);
	}

	/**
	 * Caches the submitted data in the entity cache if it is enabled.
	 *
	 * @param submittedData the submitted data
	 */
	@Override
	public void cacheResult(SubmittedData submittedData) {
		EntityCacheUtil.putResult(SubmittedDataModelImpl.ENTITY_CACHE_ENABLED,
			SubmittedDataImpl.class, submittedData.getPrimaryKey(),
			submittedData);

		submittedData.resetOriginalValues();
	}

	/**
	 * Caches the submitted datas in the entity cache if it is enabled.
	 *
	 * @param submittedDatas the submitted datas
	 */
	@Override
	public void cacheResult(List<SubmittedData> submittedDatas) {
		for (SubmittedData submittedData : submittedDatas) {
			if (EntityCacheUtil.getResult(
						SubmittedDataModelImpl.ENTITY_CACHE_ENABLED,
						SubmittedDataImpl.class, submittedData.getPrimaryKey()) == null) {
				cacheResult(submittedData);
			}
			else {
				submittedData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all submitted datas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SubmittedDataImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SubmittedDataImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the submitted data.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SubmittedData submittedData) {
		EntityCacheUtil.removeResult(SubmittedDataModelImpl.ENTITY_CACHE_ENABLED,
			SubmittedDataImpl.class, submittedData.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SubmittedData> submittedDatas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SubmittedData submittedData : submittedDatas) {
			EntityCacheUtil.removeResult(SubmittedDataModelImpl.ENTITY_CACHE_ENABLED,
				SubmittedDataImpl.class, submittedData.getPrimaryKey());
		}
	}

	/**
	 * Creates a new submitted data with the primary key. Does not add the submitted data to the database.
	 *
	 * @param submittedDataPK the primary key for the new submitted data
	 * @return the new submitted data
	 */
	@Override
	public SubmittedData create(SubmittedDataPK submittedDataPK) {
		SubmittedData submittedData = new SubmittedDataImpl();

		submittedData.setNew(true);
		submittedData.setPrimaryKey(submittedDataPK);

		return submittedData;
	}

	/**
	 * Removes the submitted data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param submittedDataPK the primary key of the submitted data
	 * @return the submitted data that was removed
	 * @throws com.rcs.webform.NoSuchSubmittedDataException if a submitted data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmittedData remove(SubmittedDataPK submittedDataPK)
		throws NoSuchSubmittedDataException, SystemException {
		return remove((Serializable)submittedDataPK);
	}

	/**
	 * Removes the submitted data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the submitted data
	 * @return the submitted data that was removed
	 * @throws com.rcs.webform.NoSuchSubmittedDataException if a submitted data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmittedData remove(Serializable primaryKey)
		throws NoSuchSubmittedDataException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SubmittedData submittedData = (SubmittedData)session.get(SubmittedDataImpl.class,
					primaryKey);

			if (submittedData == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubmittedDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(submittedData);
		}
		catch (NoSuchSubmittedDataException nsee) {
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
	protected SubmittedData removeImpl(SubmittedData submittedData)
		throws SystemException {
		submittedData = toUnwrappedModel(submittedData);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(submittedData)) {
				submittedData = (SubmittedData)session.get(SubmittedDataImpl.class,
						submittedData.getPrimaryKeyObj());
			}

			if (submittedData != null) {
				session.delete(submittedData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (submittedData != null) {
			clearCache(submittedData);
		}

		return submittedData;
	}

	@Override
	public SubmittedData updateImpl(
		com.rcs.webform.model.SubmittedData submittedData)
		throws SystemException {
		submittedData = toUnwrappedModel(submittedData);

		boolean isNew = submittedData.isNew();

		SubmittedDataModelImpl submittedDataModelImpl = (SubmittedDataModelImpl)submittedData;

		Session session = null;

		try {
			session = openSession();

			if (submittedData.isNew()) {
				session.save(submittedData);

				submittedData.setNew(false);
			}
			else {
				session.merge(submittedData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SubmittedDataModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((submittedDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FORMIDSUBMITTEDIDANDACTIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submittedDataModelImpl.getOriginalFormId(),
						submittedDataModelImpl.getOriginalSubmittedDataId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FORMIDSUBMITTEDIDANDACTIVE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FORMIDSUBMITTEDIDANDACTIVE,
					args);

				args = new Object[] {
						submittedDataModelImpl.getFormId(),
						submittedDataModelImpl.getSubmittedDataId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FORMIDSUBMITTEDIDANDACTIVE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FORMIDSUBMITTEDIDANDACTIVE,
					args);
			}
		}

		EntityCacheUtil.putResult(SubmittedDataModelImpl.ENTITY_CACHE_ENABLED,
			SubmittedDataImpl.class, submittedData.getPrimaryKey(),
			submittedData);

		return submittedData;
	}

	protected SubmittedData toUnwrappedModel(SubmittedData submittedData) {
		if (submittedData instanceof SubmittedDataImpl) {
			return submittedData;
		}

		SubmittedDataImpl submittedDataImpl = new SubmittedDataImpl();

		submittedDataImpl.setNew(submittedData.isNew());
		submittedDataImpl.setPrimaryKey(submittedData.getPrimaryKey());

		submittedDataImpl.setSubmittedDataId(submittedData.getSubmittedDataId());
		submittedDataImpl.setGroupId(submittedData.getGroupId());
		submittedDataImpl.setCompanyId(submittedData.getCompanyId());
		submittedDataImpl.setActive(submittedData.isActive());
		submittedDataImpl.setCreationDate(submittedData.getCreationDate());
		submittedDataImpl.setModificationDate(submittedData.getModificationDate());
		submittedDataImpl.setModificationUser(submittedData.getModificationUser());
		submittedDataImpl.setFormId(submittedData.getFormId());
		submittedDataImpl.setPortletId(submittedData.getPortletId());
		submittedDataImpl.setFormItemId(submittedData.getFormItemId());
		submittedDataImpl.setUserInput(submittedData.getUserInput());

		return submittedDataImpl;
	}

	/**
	 * Returns the submitted data with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the submitted data
	 * @return the submitted data
	 * @throws com.rcs.webform.NoSuchSubmittedDataException if a submitted data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmittedData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubmittedDataException, SystemException {
		SubmittedData submittedData = fetchByPrimaryKey(primaryKey);

		if (submittedData == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubmittedDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return submittedData;
	}

	/**
	 * Returns the submitted data with the primary key or throws a {@link com.rcs.webform.NoSuchSubmittedDataException} if it could not be found.
	 *
	 * @param submittedDataPK the primary key of the submitted data
	 * @return the submitted data
	 * @throws com.rcs.webform.NoSuchSubmittedDataException if a submitted data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmittedData findByPrimaryKey(SubmittedDataPK submittedDataPK)
		throws NoSuchSubmittedDataException, SystemException {
		return findByPrimaryKey((Serializable)submittedDataPK);
	}

	/**
	 * Returns the submitted data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the submitted data
	 * @return the submitted data, or <code>null</code> if a submitted data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmittedData fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SubmittedData submittedData = (SubmittedData)EntityCacheUtil.getResult(SubmittedDataModelImpl.ENTITY_CACHE_ENABLED,
				SubmittedDataImpl.class, primaryKey);

		if (submittedData == _nullSubmittedData) {
			return null;
		}

		if (submittedData == null) {
			Session session = null;

			try {
				session = openSession();

				submittedData = (SubmittedData)session.get(SubmittedDataImpl.class,
						primaryKey);

				if (submittedData != null) {
					cacheResult(submittedData);
				}
				else {
					EntityCacheUtil.putResult(SubmittedDataModelImpl.ENTITY_CACHE_ENABLED,
						SubmittedDataImpl.class, primaryKey, _nullSubmittedData);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SubmittedDataModelImpl.ENTITY_CACHE_ENABLED,
					SubmittedDataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return submittedData;
	}

	/**
	 * Returns the submitted data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param submittedDataPK the primary key of the submitted data
	 * @return the submitted data, or <code>null</code> if a submitted data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmittedData fetchByPrimaryKey(SubmittedDataPK submittedDataPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)submittedDataPK);
	}

	/**
	 * Returns all the submitted datas.
	 *
	 * @return the submitted datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmittedData> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submitted datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.SubmittedDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of submitted datas
	 * @param end the upper bound of the range of submitted datas (not inclusive)
	 * @return the range of submitted datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmittedData> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the submitted datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.SubmittedDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of submitted datas
	 * @param end the upper bound of the range of submitted datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of submitted datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmittedData> findAll(int start, int end,
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

		List<SubmittedData> list = (List<SubmittedData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUBMITTEDDATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBMITTEDDATA;

				if (pagination) {
					sql = sql.concat(SubmittedDataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SubmittedData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SubmittedData>(list);
				}
				else {
					list = (List<SubmittedData>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the submitted datas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SubmittedData submittedData : findAll()) {
			remove(submittedData);
		}
	}

	/**
	 * Returns the number of submitted datas.
	 *
	 * @return the number of submitted datas
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

				Query q = session.createQuery(_SQL_COUNT_SUBMITTEDDATA);

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
	 * Initializes the submitted data persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rcs.webform.model.SubmittedData")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SubmittedData>> listenersList = new ArrayList<ModelListener<SubmittedData>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SubmittedData>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SubmittedDataImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SUBMITTEDDATA = "SELECT submittedData FROM SubmittedData submittedData";
	private static final String _SQL_SELECT_SUBMITTEDDATA_WHERE = "SELECT submittedData FROM SubmittedData submittedData WHERE ";
	private static final String _SQL_COUNT_SUBMITTEDDATA = "SELECT COUNT(submittedData) FROM SubmittedData submittedData";
	private static final String _SQL_COUNT_SUBMITTEDDATA_WHERE = "SELECT COUNT(submittedData) FROM SubmittedData submittedData WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "submittedData.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SubmittedData exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SubmittedData exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SubmittedDataPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static SubmittedData _nullSubmittedData = new SubmittedDataImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SubmittedData> toCacheModel() {
				return _nullSubmittedDataCacheModel;
			}
		};

	private static CacheModel<SubmittedData> _nullSubmittedDataCacheModel = new CacheModel<SubmittedData>() {
			@Override
			public SubmittedData toEntityModel() {
				return _nullSubmittedData;
			}
		};
}