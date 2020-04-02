package io.chugar.jpademo.manytomany.domain.dto;

public interface DTOMapper<T,E> {

	public T entityToDto(E entity);
}
