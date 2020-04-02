package io.chugar.jpademo.manytomany.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.chugar.jpademo.manytomany.dao.repo.CoursRepo;
import io.chugar.jpademo.manytomany.dao.repo.EtudiantRepo;
import io.chugar.jpademo.manytomany.domain.dto.impl.EtudiantDTO;
import io.chugar.jpademo.manytomany.domain.dto.mappers.EtudiantMapper;
import io.chugar.jpademo.manytomany.domain.dto.mappers.MatiereMapper;
import io.chugar.jpademo.manytomany.domain.entity.Etudiant;

@Service
public class EtudiantService {
	
	/* FIELDS */
	
	EtudiantRepo etudiantRepo;
	CoursRepo coursRepo;
	EtudiantMapper etudiantMapper;
	MatiereMapper matiereMapper;
	

	
	/* CONSTRUCTOR */
	
	@Autowired
	public EtudiantService(EtudiantRepo eR, CoursRepo cR, MatiereMapper mt, EtudiantMapper et) {
		super();
		this.etudiantRepo = eR;
		this.coursRepo = cR;
		this.matiereMapper = mt;
		this.etudiantMapper = et;
	}
	
	
	
	/* METHODS */
	
	public List<EtudiantDTO> getAll() {
		
		List<Etudiant> etudiants = etudiantRepo.findAll();
		
		
		// 
		return etudiants.stream()
			.map(e -> etudiantMapper.entityToDto(e))
			.collect(Collectors.toList())
		;
	}
	

	public Etudiant getOne(Long id) {
		return etudiantRepo.findById(id);
	}



	public Etudiant createOne(Etudiant etudiant) {
		return etudiantRepo.save(etudiant);		
	}
	
	
	
	
	
}
