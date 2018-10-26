package com.project.generic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bku.exception.BadRequestException;
import com.project.generic.dao.GenericDao;
import com.project.generic.service.GenericService;

@Service
public class GenericServiceImpl<E, K> implements GenericService<E, K> {

	@Autowired
	private GenericDao<E, K> genericDaoImpl;

	public GenericServiceImpl() {
	}
	
	@Override
	public E save(E entity) {
		if (entity == null) {
			throw new BadRequestException("Entity tidak bisa kosong");
		}
		return genericDaoImpl.save(entity);
	}

	@Override
	public List<E> getAll() {
		return genericDaoImpl.getAll();
	}

	@Override
	public E get(K id) {
		return genericDaoImpl.get(id);
	}

	@Override
	public void remove(K id) {
		genericDaoImpl.remove(id);
	}

	@Override
	public List<E> getAllDistinct() {
		return genericDaoImpl.getAllDistinct();
	}

	@Override
	public List<E> getPagingResults(Integer firstResult, Integer maxResults) {
		return genericDaoImpl.getPagingResults(firstResult, maxResults);
	}

	@Override
	public Long getRecordCount() {
		return genericDaoImpl.getRecordCount();
	}

}
