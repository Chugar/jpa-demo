package io.chugar.jpademo.manytomany.domain.dto.mappers;

import org.springframework.stereotype.Component;

import io.chugar.jpademo.manytomany.domain.dto.DTOMapper;
import io.chugar.jpademo.manytomany.domain.dto.impl.MatiereDTO;
import io.chugar.jpademo.manytomany.domain.entity.Cours;


@Component
public class MatiereMapper implements DTOMapper<MatiereDTO, Cours>{

	@Override
	public MatiereDTO entityToDto(Cours entity) {
		MatiereDTO dto = new MatiereDTO();
		dto.setTitle(entity.getName());
		return dto;
	}

}
