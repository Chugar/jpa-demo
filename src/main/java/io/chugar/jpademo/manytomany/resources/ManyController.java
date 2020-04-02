package io.chugar.jpademo.manytomany.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.chugar.jpademo.manytomany.domain.dto.impl.CoursDTO;
import io.chugar.jpademo.manytomany.domain.dto.impl.EtudiantDTO;
import io.chugar.jpademo.manytomany.domain.entity.Cours;
import io.chugar.jpademo.manytomany.domain.entity.Etudiant;
import io.chugar.jpademo.manytomany.services.CoursService;
import io.chugar.jpademo.manytomany.services.EtudiantService;

@RestController
public class ManyController {
	
	// TODO: Replace native queries with code
	
	/* FIELDS */

	EtudiantService etudiantService;
	CoursService coursService;

	/* CONSTRUCTOR */

	public ManyController(EtudiantService etudiantService, CoursService coursService) {
		super();
		this.etudiantService = etudiantService;
		this.coursService = coursService;
	}

	/* METHODS */

	@GetMapping("/etudiant")
	public List<EtudiantDTO> getAllStudents() {
		return etudiantService.getAll();
	}

	@GetMapping("/cours")
	public List<CoursDTO> getAllCourses() {
		return coursService.getAll();
	}
	
	
	@PostMapping("/etudiant")
	public Etudiant addStudent(@RequestBody Etudiant etudiant) {
		return etudiantService.createOne(etudiant);
	}

	@PostMapping("/cours")
	public Cours addCourse(@RequestBody Cours cours) {
		return coursService.createOne(cours);
		
	}

	@GetMapping("/etudiant/{id}")
	public Etudiant getOneStudent(@PathVariable Long id) {
		return etudiantService.getOne(id);
	}

	@GetMapping("/cours/{id}")
	public Cours getOneCourse(@PathVariable Long id) {
		return coursService.getOne(id);
	}
	
	@PostMapping("/cours/{id}/etudiant")
	public ResponseEntity<String> addStudentToCourse(@PathVariable Long id, @RequestBody Etudiant student) {
		return coursService.addStudentToCourse(id, student);	
	}
	
	@DeleteMapping("/cours/{id}/etudiant")
	public ResponseEntity<String> removeStudentFromCourse(@PathVariable Long id, @RequestBody Etudiant student) {
		return coursService.removeStudentFromCourse(id, student);
	}
}
