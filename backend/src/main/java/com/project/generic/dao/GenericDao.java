/**
* ATI - CORE -TPE
* Transaction Processing Engine(TPE)
* @Author- V.N.V.L.PRASANNA 
* @author taufik.muliahadi
* <p>
* 	
* </p>
*/

package com.project.generic.dao;

import java.util.List;

public interface GenericDao<E, K> {

	/**
	 * This method to be used for insert or update Entiry
	 * @param entity class with anotation  @Entity
	 * @return entity object
	 * @see {@link javax.persistence.Entity}
	 */
	public E save(E entity);

	public List<E> getAll();

	public E get(K id);

	public void remove(K id);

	public List<E> getAllDistinct();
	
	public List<E> getPagingResults(Integer firstResult, Integer maxResults);
	
	public Long getRecordCount();
}
