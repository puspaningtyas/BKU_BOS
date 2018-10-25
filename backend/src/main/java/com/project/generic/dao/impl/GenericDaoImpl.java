/*
* ATI - CORE -TPE
* Transaction Processing Engine(TPE)
* @Author- V.N.V.L.PRASANNA 
*/

package com.project.generic.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.bku.exception.ResourceNotFoundException;
import com.project.generic.dao.GenericDao;
import com.project.generic.model.GenericUserDateAudit;

@Transactional
@Repository
public class GenericDaoImpl<E extends GenericUserDateAudit, K extends Serializable> implements GenericDao<E, K> {

	@PersistenceContext
	EntityManager entityManager;

	private Class<E> entityClass;

	public GenericDaoImpl() {
		super();
	}

	public static final Integer PAGING_MAX_RECORD = 20;

	public GenericDaoImpl(final Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	public GenericDaoImpl(final Class<E> entityClass, EntityManager entityManager) {
		this.entityClass = entityClass;
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	public Class<E> getEntityClass() {
		if (entityClass == null) {
			entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];
		}
		return entityClass;
	}

	public void setEntityClass(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	/* get by id method to be used in engines dao classes implementation */
	public E get(K id) {
		E entity = this.entityManager.find(getEntityClass(), id);
		if (entity == null) {
			throw new ResourceNotFoundException(getEntityClass().getSimpleName(), "id", id);
		}
		return entity;
	}

	/* remove method to be used in engines dao classes implementation */
	public void remove(K id) {
		E entity = get(id);
		if (entity != null) {
			this.entityManager.remove(entity);
		}
	}

	/* update method to be used in engines dao classes implementation */
	public E save(E entity) {
		return this.entityManager.merge(entity);
	}

	/* getAll method to be used in engines dao classes implementation */
	@SuppressWarnings("unchecked")
	public List<E> getAll() {
		return this.entityManager.createQuery("Select entity FROM " + getEntityClass().getSimpleName() + " entity")
				.getResultList();
	}

	public List<E> getAllDistinct() {
		Collection<E> result = new LinkedHashSet<>(getAll());
		return new ArrayList<>(result);
	}

	public List<E> getPagingResults(Integer firstResult, Integer maxResults) {

		CriteriaBuilder qb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<E> cq = qb.createQuery(this.entityClass);
		cq.select(cq.from(this.entityClass));

		return this.entityManager.createQuery(cq).setFirstResult(firstResult)
				.setMaxResults((String.valueOf(maxResults) == null ? PAGING_MAX_RECORD : maxResults)).getResultList();
	};

	@SuppressWarnings("rawtypes")
	public Long getRecordCount() {
		CriteriaBuilder qb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = qb.createQuery(Long.class);
		Root<E> cc = cq.from(this.entityClass);
		cq.select(qb.count(cc));
		List list = this.entityManager.createQuery(cq).getResultList();
		return list.isEmpty() ? null : (Long) list.get(0);
	}
}
