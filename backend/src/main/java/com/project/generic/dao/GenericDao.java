
package com.project.generic.dao;

import java.util.List;

public interface GenericDao<E, K> {

	public E save(E entity);

	public List<E> getAll();

	public E get(K id);

	public void remove(K id);

	public List<E> getAllDistinct();
	
	public List<E> getPagingResults(Integer firstResult, Integer maxResults);
	
	public Long getRecordCount();
}
