package io.chugar.jpademo.manytomany.domain.dto.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.chugar.jpademo.manytomany.domain.dto.DTOMapper;
import io.chugar.jpademo.manytomany.domain.dto.impl.CoursDTO;
import io.chugar.jpademo.manytomany.domain.dto.impl.ParticipantDTO;
import io.chugar.jpademo.manytomany.domain.entity.Cours;

@Component
public class CoursMapper implements DTOMapper<CoursDTO, Cours> {
	
	/* FIELDS */
	ParticipantMapper participantMapper;
	
	
	/* CONSTRUCTOR */
	public CoursMapper(ParticipantMapper participantMapper) {
		super();
		this.participantMapper = participantMapper;
	}
	

	@Override
	public CoursDTO entityToDto(Cours entity) {
		
		// DTO
		CoursDTO dto = new CoursDTO();
		
		// Lists
		List<ParticipantDTO> participantDTOs = entity.getParticipants().stream()
			.map(p -> participantMapper.entityToDto(p) )
			.collect(Collectors.toList());
		
		// Setting
		dto.setTitle(entity.getName());
		dto.setHeadcount(participantDTOs.size());
		dto.setParticipants(participantDTOs);
		
		return dto;
	}


	

	
}
