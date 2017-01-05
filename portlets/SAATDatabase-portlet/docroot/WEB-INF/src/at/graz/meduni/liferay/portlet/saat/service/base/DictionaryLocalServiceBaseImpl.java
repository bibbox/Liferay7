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

package at.graz.meduni.liferay.portlet.saat.service.base;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.liferay.portlet.saat.model.Dictionary;
import at.graz.meduni.liferay.portlet.saat.service.DictionaryLocalService;
import at.graz.meduni.liferay.portlet.saat.service.persistence.DictionaryDictionaryLinkPersistence;
import at.graz.meduni.liferay.portlet.saat.service.persistence.DictionaryPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the dictionary local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link at.graz.meduni.liferay.portlet.saat.service.impl.DictionaryLocalServiceImpl}.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.saat.service.impl.DictionaryLocalServiceImpl
 * @see at.graz.meduni.liferay.portlet.saat.service.DictionaryLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class DictionaryLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements DictionaryLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link at.graz.meduni.liferay.portlet.saat.service.DictionaryLocalServiceUtil} to access the dictionary local service.
	 */

	/**
	 * Adds the dictionary to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dictionary the dictionary
	 * @return the dictionary that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Dictionary addDictionary(Dictionary dictionary) {
		dictionary.setNew(true);

		return dictionaryPersistence.update(dictionary);
	}

	/**
	 * Creates a new dictionary with the primary key. Does not add the dictionary to the database.
	 *
	 * @param dictionaryId the primary key for the new dictionary
	 * @return the new dictionary
	 */
	@Override
	public Dictionary createDictionary(long dictionaryId) {
		return dictionaryPersistence.create(dictionaryId);
	}

	/**
	 * Deletes the dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dictionaryId the primary key of the dictionary
	 * @return the dictionary that was removed
	 * @throws PortalException if a dictionary with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Dictionary deleteDictionary(long dictionaryId)
		throws PortalException {
		return dictionaryPersistence.remove(dictionaryId);
	}

	/**
	 * Deletes the dictionary from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dictionary the dictionary
	 * @return the dictionary that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Dictionary deleteDictionary(Dictionary dictionary) {
		return dictionaryPersistence.remove(dictionary);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Dictionary.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return dictionaryPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return dictionaryPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return dictionaryPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return dictionaryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return dictionaryPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Dictionary fetchDictionary(long dictionaryId) {
		return dictionaryPersistence.fetchByPrimaryKey(dictionaryId);
	}

	/**
	 * Returns the dictionary with the primary key.
	 *
	 * @param dictionaryId the primary key of the dictionary
	 * @return the dictionary
	 * @throws PortalException if a dictionary with the primary key could not be found
	 */
	@Override
	public Dictionary getDictionary(long dictionaryId)
		throws PortalException {
		return dictionaryPersistence.findByPrimaryKey(dictionaryId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(dictionaryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Dictionary.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("dictionaryId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(dictionaryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Dictionary.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"dictionaryId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(dictionaryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Dictionary.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("dictionaryId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return dictionaryLocalService.deleteDictionary((Dictionary)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return dictionaryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the dictionaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @return the range of dictionaries
	 */
	@Override
	public List<Dictionary> getDictionaries(int start, int end) {
		return dictionaryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of dictionaries.
	 *
	 * @return the number of dictionaries
	 */
	@Override
	public int getDictionariesCount() {
		return dictionaryPersistence.countAll();
	}

	/**
	 * Updates the dictionary in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dictionary the dictionary
	 * @return the dictionary that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Dictionary updateDictionary(Dictionary dictionary) {
		return dictionaryPersistence.update(dictionary);
	}

	/**
	 * Returns the dictionary local service.
	 *
	 * @return the dictionary local service
	 */
	public DictionaryLocalService getDictionaryLocalService() {
		return dictionaryLocalService;
	}

	/**
	 * Sets the dictionary local service.
	 *
	 * @param dictionaryLocalService the dictionary local service
	 */
	public void setDictionaryLocalService(
		DictionaryLocalService dictionaryLocalService) {
		this.dictionaryLocalService = dictionaryLocalService;
	}

	/**
	 * Returns the dictionary persistence.
	 *
	 * @return the dictionary persistence
	 */
	public DictionaryPersistence getDictionaryPersistence() {
		return dictionaryPersistence;
	}

	/**
	 * Sets the dictionary persistence.
	 *
	 * @param dictionaryPersistence the dictionary persistence
	 */
	public void setDictionaryPersistence(
		DictionaryPersistence dictionaryPersistence) {
		this.dictionaryPersistence = dictionaryPersistence;
	}

	/**
	 * Returns the dictionary dictionary link local service.
	 *
	 * @return the dictionary dictionary link local service
	 */
	public at.graz.meduni.liferay.portlet.saat.service.DictionaryDictionaryLinkLocalService getDictionaryDictionaryLinkLocalService() {
		return dictionaryDictionaryLinkLocalService;
	}

	/**
	 * Sets the dictionary dictionary link local service.
	 *
	 * @param dictionaryDictionaryLinkLocalService the dictionary dictionary link local service
	 */
	public void setDictionaryDictionaryLinkLocalService(
		at.graz.meduni.liferay.portlet.saat.service.DictionaryDictionaryLinkLocalService dictionaryDictionaryLinkLocalService) {
		this.dictionaryDictionaryLinkLocalService = dictionaryDictionaryLinkLocalService;
	}

	/**
	 * Returns the dictionary dictionary link persistence.
	 *
	 * @return the dictionary dictionary link persistence
	 */
	public DictionaryDictionaryLinkPersistence getDictionaryDictionaryLinkPersistence() {
		return dictionaryDictionaryLinkPersistence;
	}

	/**
	 * Sets the dictionary dictionary link persistence.
	 *
	 * @param dictionaryDictionaryLinkPersistence the dictionary dictionary link persistence
	 */
	public void setDictionaryDictionaryLinkPersistence(
		DictionaryDictionaryLinkPersistence dictionaryDictionaryLinkPersistence) {
		this.dictionaryDictionaryLinkPersistence = dictionaryDictionaryLinkPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
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

		PersistedModelLocalServiceRegistryUtil.register("at.graz.meduni.liferay.portlet.saat.model.Dictionary",
			dictionaryLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"at.graz.meduni.liferay.portlet.saat.model.Dictionary");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DictionaryLocalService.class.getName();
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
		return Dictionary.class;
	}

	protected String getModelClassName() {
		return Dictionary.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = dictionaryPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = DictionaryLocalService.class)
	protected DictionaryLocalService dictionaryLocalService;
	@BeanReference(type = DictionaryPersistence.class)
	protected DictionaryPersistence dictionaryPersistence;
	@BeanReference(type = at.graz.meduni.liferay.portlet.saat.service.DictionaryDictionaryLinkLocalService.class)
	protected at.graz.meduni.liferay.portlet.saat.service.DictionaryDictionaryLinkLocalService dictionaryDictionaryLinkLocalService;
	@BeanReference(type = DictionaryDictionaryLinkPersistence.class)
	protected DictionaryDictionaryLinkPersistence dictionaryDictionaryLinkPersistence;
	@BeanReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@BeanReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private ClassLoader _classLoader;
	private DictionaryLocalServiceClpInvoker _clpInvoker = new DictionaryLocalServiceClpInvoker();
}