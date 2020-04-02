package io.chugar.jpademo.manytomany.domain.dto.mappers;

import org.springframework.stereotype.Component;

import io.chugar.jpademo.manytomany.domain.dto.DTOMapper;
import io.chugar.jpademo.manytomany.domain.dto.impl.ParticipantDTO;
import io.chugar.jpademo.manytomany.domain.entity.Etudiant;


@Component
public class ParticipantMapper implements DTOMapper<ParticipantDTO, Etudiant>{

	@Override
	public ParticipantDTO entityToDto(Etudiant entity) {
		
		ParticipantDTO dto = new ParticipantDTO();
		dto.setName(entity.getName());	
		return dto;
		
	}

}
