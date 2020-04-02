package io.chugar.jpademo.manytomany.domain.dto.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.chugar.jpademo.manytomany.domain.dto.DTOMapper;
import io.chugar.jpademo.manytomany.domain.dto.impl.EtudiantDTO;
import io.chugar.jpademo.manytomany.domain.dto.impl.MatiereDTO;
import io.chugar.jpademo.manytomany.domain.entity.Etudiant;

@Component
public class EtudiantMapper implements DTOMapper<EtudiantDTO, Etudiant> {

	/* FIELDS */
	MatiereMapper matiereMapper;
	
	
	@Autowired
	public EtudiantMapper(MatiereMapper mM) {
		this.matiereMapper = mM;
	}
	
	
	@Override
	public EtudiantDTO entityToDto(Etudiant entity) {
		// DTO
		EtudiantDTO dto = new EtudiantDTO();
		
		// List
		List<MatiereDTO> matieresDtos = entity.getListeCours().stream()
			.map(cr -> matiereMapper.entityToDto(cr))
			.collect(Collectors.toList())
		;
		
		// Setting
		dto.setName(entity.getName());
		dto.setCoursSuivis(matieresDtos);
		
		return dto;
	}


}
