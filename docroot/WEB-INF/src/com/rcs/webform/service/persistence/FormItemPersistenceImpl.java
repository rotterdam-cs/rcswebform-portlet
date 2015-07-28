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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rcs.webform.NoSuchFormItemException;
import com.rcs.webform.model.FormItem;
import com.rcs.webform.model.impl.FormItemImpl;
import com.rcs.webform.model.impl.FormItemModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the form item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ryusuf
 * @see FormItemPersistence
 * @see FormItemUtil
 * @generated
 */
public class FormItemPersistenceImpl extends BasePersistenceImpl<FormItem>
	implements FormItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FormItemUtil} to access the form item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FormItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FormItemModelImpl.ENTITY_CACHE_ENABLED,
			FormItemModelImpl.FINDER_CACHE_ENABLED, FormItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FormItemModelImpl.ENTITY_CACHE_ENABLED,
			FormItemModelImpl.FINDER_CACHE_ENABLED, FormItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FormItemModelImpl.ENTITY_CACHE_ENABLED,
			FormItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FormItemPersistenceImpl() {
		setModelClass(FormItem.class);
	}

	/**
	 * Caches the form item in the entity cache if it is enabled.
	 *
	 * @param formItem the form item
	 */
	@Override
	public void cacheResult(FormItem formItem) {
		EntityCacheUtil.putResult(FormItemModelImpl.ENTITY_CACHE_ENABLED,
			FormItemImpl.class, formItem.getPrimaryKey(), formItem);

		formItem.resetOriginalValues();
	}

	/**
	 * Caches the form items in the entity cache if it is enabled.
	 *
	 * @param formItems the form items
	 */
	@Override
	public void cacheResult(List<FormItem> formItems) {
		for (FormItem formItem : formItems) {
			if (EntityCacheUtil.getResult(
						FormItemModelImpl.ENTITY_CACHE_ENABLED,
						FormItemImpl.class, formItem.getPrimaryKey()) == null) {
				cacheResult(formItem);
			}
			else {
				formItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all form items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FormItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FormItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the form item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FormItem formItem) {
		EntityCacheUtil.removeResult(FormItemModelImpl.ENTITY_CACHE_ENABLED,
			FormItemImpl.class, formItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FormItem> formItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FormItem formItem : formItems) {
			EntityCacheUtil.removeResult(FormItemModelImpl.ENTITY_CACHE_ENABLED,
				FormItemImpl.class, formItem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new form item with the primary key. Does not add the form item to the database.
	 *
	 * @param formItemId the primary key for the new form item
	 * @return the new form item
	 */
	@Override
	public FormItem create(long formItemId) {
		FormItem formItem = new FormItemImpl();

		formItem.setNew(true);
		formItem.setPrimaryKey(formItemId);

		return formItem;
	}

	/**
	 * Removes the form item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formItemId the primary key of the form item
	 * @return the form item that was removed
	 * @throws com.rcs.webform.NoSuchFormItemException if a form item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormItem remove(long formItemId)
		throws NoSuchFormItemException, SystemException {
		return remove((Serializable)formItemId);
	}

	/**
	 * Removes the form item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the form item
	 * @return the form item that was removed
	 * @throws com.rcs.webform.NoSuchFormItemException if a form item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormItem remove(Serializable primaryKey)
		throws NoSuchFormItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FormItem formItem = (FormItem)session.get(FormItemImpl.class,
					primaryKey);

			if (formItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFormItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(formItem);
		}
		catch (NoSuchFormItemException nsee) {
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
	protected FormItem removeImpl(FormItem formItem) throws SystemException {
		formItem = toUnwrappedModel(formItem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(formItem)) {
				formItem = (FormItem)session.get(FormItemImpl.class,
						formItem.getPrimaryKeyObj());
			}

			if (formItem != null) {
				session.delete(formItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (formItem != null) {
			clearCache(formItem);
		}

		return formItem;
	}

	@Override
	public FormItem updateImpl(com.rcs.webform.model.FormItem formItem)
		throws SystemException {
		formItem = toUnwrappedModel(formItem);

		boolean isNew = formItem.isNew();

		Session session = null;

		try {
			session = openSession();

			if (formItem.isNew()) {
				session.save(formItem);

				formItem.setNew(false);
			}
			else {
				session.merge(formItem);
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

		EntityCacheUtil.putResult(FormItemModelImpl.ENTITY_CACHE_ENABLED,
			FormItemImpl.class, formItem.getPrimaryKey(), formItem);

		return formItem;
	}

	protected FormItem toUnwrappedModel(FormItem formItem) {
		if (formItem instanceof FormItemImpl) {
			return formItem;
		}

		FormItemImpl formItemImpl = new FormItemImpl();

		formItemImpl.setNew(formItem.isNew());
		formItemImpl.setPrimaryKey(formItem.getPrimaryKey());

		formItemImpl.setFormItemId(formItem.getFormItemId());
		formItemImpl.setActive(formItem.isActive());
		formItemImpl.setCreationDate(formItem.getCreationDate());
		formItemImpl.setModificationDate(formItem.getModificationDate());
		formItemImpl.setModificationUser(formItem.getModificationUser());
		formItemImpl.setFormId(formItem.getFormId());
		formItemImpl.setFormItemAttrId(formItem.getFormItemAttrId());
		formItemImpl.setFormItemAttrClass(formItem.getFormItemAttrClass());
		formItemImpl.setLabel(formItem.getLabel());
		formItemImpl.setLabelAttrId(formItem.getLabelAttrId());
		formItemImpl.setLabelAttrClass(formItem.getLabelAttrClass());
		formItemImpl.setInputAttrId(formItem.getInputAttrId());
		formItemImpl.setInputAttrClass(formItem.getInputAttrClass());
		formItemImpl.setType(formItem.getType());
		formItemImpl.setOptions(formItem.getOptions());
		formItemImpl.setMandatory(formItem.isMandatory());
		formItemImpl.setDefaultValue(formItem.getDefaultValue());
		formItemImpl.setOrder(formItem.getOrder());
		formItemImpl.setValidationType(formItem.getValidationType());
		formItemImpl.setValidationRegexValue(formItem.getValidationRegexValue());
		formItemImpl.setErrorValidationMessage(formItem.getErrorValidationMessage());
		formItemImpl.setErrorMandatoryMessage(formItem.getErrorMandatoryMessage());
		formItemImpl.setHintMessage(formItem.getHintMessage());

		return formItemImpl;
	}

	/**
	 * Returns the form item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the form item
	 * @return the form item
	 * @throws com.rcs.webform.NoSuchFormItemException if a form item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFormItemException, SystemException {
		FormItem formItem = fetchByPrimaryKey(primaryKey);

		if (formItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFormItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return formItem;
	}

	/**
	 * Returns the form item with the primary key or throws a {@link com.rcs.webform.NoSuchFormItemException} if it could not be found.
	 *
	 * @param formItemId the primary key of the form item
	 * @return the form item
	 * @throws com.rcs.webform.NoSuchFormItemException if a form item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormItem findByPrimaryKey(long formItemId)
		throws NoSuchFormItemException, SystemException {
		return findByPrimaryKey((Serializable)formItemId);
	}

	/**
	 * Returns the form item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the form item
	 * @return the form item, or <code>null</code> if a form item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FormItem formItem = (FormItem)EntityCacheUtil.getResult(FormItemModelImpl.ENTITY_CACHE_ENABLED,
				FormItemImpl.class, primaryKey);

		if (formItem == _nullFormItem) {
			return null;
		}

		if (formItem == null) {
			Session session = null;

			try {
				session = openSession();

				formItem = (FormItem)session.get(FormItemImpl.class, primaryKey);

				if (formItem != null) {
					cacheResult(formItem);
				}
				else {
					EntityCacheUtil.putResult(FormItemModelImpl.ENTITY_CACHE_ENABLED,
						FormItemImpl.class, primaryKey, _nullFormItem);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FormItemModelImpl.ENTITY_CACHE_ENABLED,
					FormItemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return formItem;
	}

	/**
	 * Returns the form item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formItemId the primary key of the form item
	 * @return the form item, or <code>null</code> if a form item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FormItem fetchByPrimaryKey(long formItemId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)formItemId);
	}

	/**
	 * Returns all the form items.
	 *
	 * @return the form items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FormItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<FormItem> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<FormItem> findAll(int start, int end,
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

		List<FormItem> list = (List<FormItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FORMITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FORMITEM;

				if (pagination) {
					sql = sql.concat(FormItemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FormItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FormItem>(list);
				}
				else {
					list = (List<FormItem>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the form items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FormItem formItem : findAll()) {
			remove(formItem);
		}
	}

	/**
	 * Returns the number of form items.
	 *
	 * @return the number of form items
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

				Query q = session.createQuery(_SQL_COUNT_FORMITEM);

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
	 * Initializes the form item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rcs.webform.model.FormItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FormItem>> listenersList = new ArrayList<ModelListener<FormItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FormItem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FormItemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FORMITEM = "SELECT formItem FROM FormItem formItem";
	private static final String _SQL_COUNT_FORMITEM = "SELECT COUNT(formItem) FROM FormItem formItem";
	private static final String _ORDER_BY_ENTITY_ALIAS = "formItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FormItem exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FormItemPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active", "type", "order"
			});
	private static FormItem _nullFormItem = new FormItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FormItem> toCacheModel() {
				return _nullFormItemCacheModel;
			}
		};

	private static CacheModel<FormItem> _nullFormItemCacheModel = new CacheModel<FormItem>() {
			@Override
			public FormItem toEntityModel() {
				return _nullFormItem;
			}
		};
}