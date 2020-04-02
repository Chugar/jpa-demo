package io.chugar.jpademo.manytomany.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.chugar.jpademo.manytomany.dao.repo.CoursRepo;
import io.chugar.jpademo.manytomany.dao.repo.EtudiantRepo;
import io.chugar.jpademo.manytomany.domain.dto.impl.CoursDTO;
import io.chugar.jpademo.manytomany.domain.dto.mappers.CoursMapper;
import io.chugar.jpademo.manytomany.domain.entity.Cours;
import io.chugar.jpademo.manytomany.domain.entity.Etudiant;
import io.chugar.jpademo.manytomany.services.type.EtudiantType;

@Service
public class CoursService {
	
	/* FIELDS */
	
	CoursRepo coursRepo;
	EtudiantRepo etudiantRepo;
	CoursMapper coursMapper;
	
	
	/* CONSTRUCTOR */
	
	@Autowired
	public CoursService(CoursRepo cr, EtudiantRepo er, CoursMapper cm) {
		super();
		this.coursRepo = cr;
		this.etudiantRepo = er;
		this.coursMapper = cm;
	}
	
	
	/* METHODS */
	
	public List<CoursDTO> getAll() {
		List<Cours> cours = coursRepo.findAll();
		
		List<CoursDTO> courDtos = cours.stream()
			.map(m -> coursMapper.entityToDto(m))
			.collect(Collectors.toList());
		
		return courDtos;
	}
	
	
	public Cours getOne(Long id) {
		return coursRepo.findById(id);
	}
	
	
	public Cours createOne(Cours cours) {
		return coursRepo.save(cours);
	}
	

	@Transactional
	public ResponseEntity<String> addStudentToCourse(Long id, Etudiant etudiant) {
		coursRepo.addStudentToCourse(etudiant.getId(), id);
		return new ResponseEntity<>(EtudiantType.ADDED_TO_COURSE, HttpStatus.OK);
	}

	@Transactional
	public ResponseEntity<String> removeStudentFromCourse(Long id, Etudiant student) {
		coursRepo.removeStudentFromCourse(student.getId(), id);		
		return new ResponseEntity<>(EtudiantType.REMOVED_FROM_COURSE, HttpStatus.OK);
	}
	
}
