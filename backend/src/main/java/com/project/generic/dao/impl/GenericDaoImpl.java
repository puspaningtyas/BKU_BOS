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

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.bku.exception.ResourceNotFoundException;
import com.project.bku.exception.UnaouthorizedException;
import com.project.bku.model.*;
import com.project.bku.security.UserPrincipal;
import com.project.generic.dao.GenericDao;
import com.project.generic.model.GenericUserDateAudit;

@Transactional
@Repository
public class GenericDaoImpl<E extends GenericUserDateAudit, K extends Serializable> implements GenericDao<E, K> {

	@PersistenceContext
	EntityManager entityManager;

	private Class<E> entityClass;

	public static final Integer PAGING_MAX_RECORD = 20;

	public GenericDaoImpl() {
	}

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
		this.setEntity();
		E entity = this.entityManager.find(getEntityClass(), id);
		if (entity == null) {
			throw new ResourceNotFoundException("Bku", "id", id);
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
		this.setEntity();
		String query = "Insert into " + getEntityClass().getSimpleName() + "(no_kode) values(?)";
		this.entityManager.createQuery(query)
		.setParameter(1, "001")
		.executeUpdate();
		return null;
	}

	/* getAll method to be used in engines dao classes implementation */
	@SuppressWarnings("unchecked")
	public List<E> getAll() {
		this.setEntity();
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

	@SuppressWarnings("unchecked")
	public void setEntity() {
		UserPrincipal userprincipal;
		Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (user == "anonymousUser") {
			throw new UnaouthorizedException("Silahkan login terlebih dahulu");
		} else {
			userprincipal = (UserPrincipal) user;
		}
		if (userprincipal.getTahunAktif().equals("2018")) {
			this.entityClass = (Class<E>) Bku2018.class;
		} else if (userprincipal.getTahunAktif().equals("2019")) {
			this.entityClass = (Class<E>) Bku2019.class;
		} else if (userprincipal.getTahunAktif().equals("2020")) {
			this.entityClass = (Class<E>) Bku2020.class;
		} else if (userprincipal.getTahunAktif().equals("2021")) {
			this.entityClass = (Class<E>) Bku2021.class;
		} else if (userprincipal.getTahunAktif().equals("2022")) {
			this.entityClass = (Class<E>) Bku2022.class;
		} else if (userprincipal.getTahunAktif().equals("2023")) {
			this.entityClass = (Class<E>) Bku2023.class;
		} else if (userprincipal.getTahunAktif().equals("2024")) {
			this.entityClass = (Class<E>) Bku2024.class;
		} else if (userprincipal.getTahunAktif().equals("2025")) {
			this.entityClass = (Class<E>) Bku2025.class;
		} else if (userprincipal.getTahunAktif().equals("2026")) {
			this.entityClass = (Class<E>) Bku2026.class;
		} else if (userprincipal.getTahunAktif().equals("2027")) {
			this.entityClass = (Class<E>) Bku2027.class;
		} else if (userprincipal.getTahunAktif().equals("2028")) {
			this.entityClass = (Class<E>) Bku2028.class;
		} else {
			throw new ResourceNotFoundException("Bku", "tahun", userprincipal.getTahunAktif());
		}
	}
}
