package com.project.bku.converter;

public interface Converter<T, M> {
	
	/**
	 * toModel is a method to convert Dto to Entity
	 * @param param, Dto class
	 * @return M, Entity class
	 */
	public M toModel(T param);
	
	/**
	 * toDto is a method to convert Entity to Dto
	 * @param param, Entity class
	 * @return T, Dto class
	 */
	public T toDto(M param);
}
