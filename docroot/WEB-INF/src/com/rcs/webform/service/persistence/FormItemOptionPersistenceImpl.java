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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rcs.webform.NoSuchFormItemOptionException;
import com.rcs.webform.model.FormItemOption;
import com.rcs.webform.model.impl.FormItemOptionImpl;
import com.rcs.webform.model.impl.FormItemOptionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the form item option service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ryusuf
 * @see FormItemOptionPersistence
 * @see FormItemOptionUtil
 * @generated
 */
public class FormItemOptionPersistenceImpl extends BasePersistenceImpl<FormItemOption>
	implements FormItemOptionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FormItemOptionUtil} to access the form item option persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FormItemOptionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FormItemOptionModelImpl.ENTITY_CACHE_ENABLED,
			FormItemOptionModelImpl.FINDER_CACHE_ENABLED,
			FormItemOptionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FormItemOptionModelImpl.ENTITY_CACHE_ENABLED,
			FormItemOptionModelImpl.FINDER_CACHE_ENABLED,
			FormItemOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FormItemOptionModelImpl.ENTITY_CACHE_ENABLED,
			FormItemOptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FormItemOptionPersistenceImpl() {
		setModelClass(FormItemOption.class);
	}

	/**
	 * Caches the form item option in the entity cache if it is enabled.
	 *
	 * @param formItemOption the form item option
	 */
	@Override
	public void cacheResult(FormItemOption formItemOption) {
		EntityCacheUtil.putResult(FormItemOptionModelImpl.ENTITY_CACHE_ENABLED,
			FormItemOptionImpl.class, formItemOption.getPrimaryKey(),
			formItemOption);

		formItemOption.resetOriginalValues();
	}

	/**
	 * Caches the form item options in the entity cache if it is enabled.
	 *
	 * @param formItemOptions the form item options
	 */
	@Override
	public void cacheResult(List<FormItemOption> formItemOptions) {
		for (FormItemOption formItemOption : formItemOptions) {
			if (EntityCacheUtil.getResult(
						FormItemOptionModelImpl.ENTITY_CACHE_ENABLED,
						FormItemOptionImpl.class, formItemOption.getPrimaryKey()) == null) {
				cacheResult(formItemOption);
			}
			else {
				formItemOption.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all form item options.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FormItemOptionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FormItemOptionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the form item option.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FormItemOption formItemOption) {
		EntityCacheUtil.removeResult(FormItemOptionModelImpl.ENTITY_CACHE_ENABLED,
			FormItemOptionImpl.class, formItemOption.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FormItemOption> formItemOptions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FormItemOption formItemOption : formItemOptions) {
			EntityCacheUtil.removeResult(FormItemOptionModelImpl.ENTITY_CACHE_ENABLED,
				FormItemOptionImpl.class, formItemOption.getPrimaryKey());
		}
	}

	/**
	 * Creates a new form item option with the primary key. Does not add the form item option to the database.
	 *
	 * @param formItemOptionId the primary key for the new form item option
	 * @return the new form item option
	 */
	@Override
	public FormItemOption create(long formItemOptionId) {
		FormItemOption formItemOption = new FormItemOptionImpl();

		formItemOption.setNew(true);
		formItemOption.setPrimaryKey(formItemOptionId);

		return formItemOption;
	}

	/**
	 * Removes the form item option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formItemOptionId the primary key of the form item option
	 * @return the form item option that was removed
	 * @throws com.rcs.webform.NoSuchFormItemOptionException if a form item option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormItemOption remove(long formItemOptionId)
		throws NoSuchFormItemOptionException, SystemException {
		return remove((Serializable)formItemOptionId);
	}

	/**
	 * Removes the form item option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the form item option
	 * @return the form item option that was removed
	 * @throws com.rcs.webform.NoSuchFormItemOptionException if a form item option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormItemOption remove(Serializable primaryKey)
		throws NoSuchFormItemOptionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FormItemOption formItemOption = (FormItemOption)session.get(FormItemOptionImpl.class,
					primaryKey);

			if (formItemOption == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFormItemOptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(formItemOption);
		}
		catch (NoSuchFormItemOptionException nsee) {
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
	protected FormItemOption removeImpl(FormItemOption formItemOption)
		throws SystemException {
		formItemOption = toUnwrappedModel(formItemOption);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(formItemOption)) {
				formItemOption = (FormItemOption)session.get(FormItemOptionImpl.class,
						formItemOption.getPrimaryKeyObj());
			}

			if (formItemOption != null) {
				session.delete(formItemOption);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (formItemOption != null) {
			clearCache(formItemOption);
		}

		return formItemOption;
	}

	@Override
	public FormItemOption updateImpl(
		com.rcs.webform.model.FormItemOption formItemOption)
		throws SystemException {
		formItemOption = toUnwrappedModel(formItemOption);

		boolean isNew = formItemOption.isNew();

		Session session = null;

		try {
			session = openSession();

			if (formItemOption.isNew()) {
				session.save(formItemOption);

				formItemOption.setNew(false);
			}
			else {
				session.merge(formItemOption);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(FormItemOptionModelImpl.ENTITY_CACHE_ENABLED,
			FormItemOptionImpl.class, formItemOption.getPrimaryKey(),
			formItemOption);

		return formItemOption;
	}

	protected FormItemOption toUnwrappedModel(FormItemOption formItemOption) {
		if (formItemOption instanceof FormItemOptionImpl) {
			return formItemOption;
		}

		FormItemOptionImpl formItemOptionImpl = new FormItemOptionImpl();

		formItemOptionImpl.setNew(formItemOption.isNew());
		formItemOptionImpl.setPrimaryKey(formItemOption.getPrimaryKey());

		formItemOptionImpl.setFormItemOptionId(formItemOption.getFormItemOptionId());
		formItemOptionImpl.setCreationDate(formItemOption.getCreationDate());
		formItemOptionImpl.setModificationDate(formItemOption.getModificationDate());
		formItemOptionImpl.setModificationUser(formItemOption.getModificationUser());
		formItemOptionImpl.setFormItemId(formItemOption.getFormItemId());
		formItemOptionImpl.setOptionKey(formItemOption.getOptionKey());
		formItemOptionImpl.setOptionValue(formItemOption.getOptionValue());

		return formItemOptionImpl;
	}

	/**
	 * Returns the form item option with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the form item option
	 * @return the form item option
	 * @throws com.rcs.webform.NoSuchFormItemOptionException if a form item option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormItemOption findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFormItemOptionException, SystemException {
		FormItemOption formItemOption = fetchByPrimaryKey(primaryKey);

		if (formItemOption == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFormItemOptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return formItemOption;
	}

	/**
	 * Returns the form item option with the primary key or throws a {@link com.rcs.webform.NoSuchFormItemOptionException} if it could not be found.
	 *
	 * @param formItemOptionId the primary key of the form item option
	 * @return the form item option
	 * @throws com.rcs.webform.NoSuchFormItemOptionException if a form item option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormItemOption findByPrimaryKey(long formItemOptionId)
		throws NoSuchFormItemOptionException, SystemException {
		return findByPrimaryKey((Serializable)formItemOptionId);
	}

	/**
	 * Returns the form item option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the form item option
	 * @return the form item option, or <code>null</code> if a form item option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormItemOption fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FormItemOption formItemOption = (FormItemOption)EntityCacheUtil.getResult(FormItemOptionModelImpl.ENTITY_CACHE_ENABLED,
				FormItemOptionImpl.class, primaryKey);

		if (formItemOption == _nullFormItemOption) {
			return null;
		}

		if (formItemOption == null) {
			Session session = null;

			try {
				session = openSession();

				formItemOption = (FormItemOption)session.get(FormItemOptionImpl.class,
						primaryKey);

				if (formItemOption != null) {
					cacheResult(formItemOption);
				}
				else {
					EntityCacheUtil.putResult(FormItemOptionModelImpl.ENTITY_CACHE_ENABLED,
						FormItemOptionImpl.class, primaryKey,
						_nullFormItemOption);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FormItemOptionModelImpl.ENTITY_CACHE_ENABLED,
					FormItemOptionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return formItemOption;
	}

	/**
	 * Returns the form item option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formItemOptionId the primary key of the form item option
	 * @return the form item option, or <code>null</code> if a form item option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormItemOption fetchByPrimaryKey(long formItemOptionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)formItemOptionId);
	}

	/**
	 * Returns all the form item options.
	 *
	 * @return the form item options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FormItemOption> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<FormItemOption> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the form item options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.webform.model.impl.FormItemOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of form item options
	 * @param end the upper bound of the range of form item options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of form item options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FormItemOption> findAll(int start, int end,
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

		List<FormItemOption> list = (List<FormItemOption>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FORMITEMOPTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FORMITEMOPTION;

				if (pagination) {
					sql = sql.concat(FormItemOptionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FormItemOption>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FormItemOption>(list);
				}
				else {
					list = (List<FormItemOption>)QueryUtil.list(q,
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
	 * Removes all the form item options from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FormItemOption formItemOption : findAll()) {
			remove(formItemOption);
		}
	}

	/**
	 * Returns the number of form item options.
	 *
	 * @return the number of form item options
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

				Query q = session.createQuery(_SQL_COUNT_FORMITEMOPTION);

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
	 * Initializes the form item option persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rcs.webform.model.FormItemOption")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FormItemOption>> listenersList = new ArrayList<ModelListener<FormItemOption>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FormItemOption>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FormItemOptionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FORMITEMOPTION = "SELECT formItemOption FROM FormItemOption formItemOption";
	private static final String _SQL_COUNT_FORMITEMOPTION = "SELECT COUNT(formItemOption) FROM FormItemOption formItemOption";
	private static final String _ORDER_BY_ENTITY_ALIAS = "formItemOption.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FormItemOption exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FormItemOptionPersistenceImpl.class);
	private static FormItemOption _nullFormItemOption = new FormItemOptionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FormItemOption> toCacheModel() {
				return _nullFormItemOptionCacheModel;
			}
		};

	private static CacheModel<FormItemOption> _nullFormItemOptionCacheModel = new CacheModel<FormItemOption>() {
			@Override
			public FormItemOption toEntityModel() {
				return _nullFormItemOption;
			}
		};
}