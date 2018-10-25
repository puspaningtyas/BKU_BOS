/*
* ATI - CORE -TPE
* Transaction Processing Engine(TPE)
* @Author- V.N.V.L.PRASANNA 
*/
package com.project.generic.service;

import java.util.List;

public interface GenericService<E, K> {

	public E save(E entity);

	public List<E> getAll();

	public E get(K id);

	public void remove(K id);

	public List<E> getAllDistinct();

	public List<E> getPagingResults(Integer firstResult, Integer maxResults);

	public Long getRecordCount();
}
