package com.project.bku.controller;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.bku.exception.ResourceNotFoundException;

/**
 * 
 * @author Yosafat
 *
 * @param <T>
 * @param <K>
 */
public class GenericController<T, K> implements Serializable{
	
	private static final long serialVersionUID = -6968219590249530675L;

	@Autowired
	JpaRepository<T, K> jpaRepository;
	
	Class<T> entityClass;
	
	public GenericController(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@GetMapping
	public ResponseEntity<List<T>> getAll(){
		List<T> list = jpaRepository.findAll();
		return new ResponseEntity<List<T>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<T> getById(@PathVariable(value = "id") K id){
		T result = jpaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(getEntityClass().getSimpleName(), "ID", id));
		return new ResponseEntity<T>(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<T> save(@RequestBody T entity){
		T result = jpaRepository.save(entity);
		return new ResponseEntity<T>(result, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<T> update(@RequestBody T entity, @PathVariable(value = "id") K id){
		jpaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(getEntityClass().getSimpleName(), "ID", id));
		T result = jpaRepository.save(entity);
		return new ResponseEntity<T>(result, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") K id){
		T result = jpaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(getEntityClass().getSimpleName(), "ID", id));
		jpaRepository.delete(result);
		return new ResponseEntity<T>(HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	public Class<T> getEntityClass() {
		if (entityClass == null) {
			entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];
		}
		return entityClass;
	}
}
