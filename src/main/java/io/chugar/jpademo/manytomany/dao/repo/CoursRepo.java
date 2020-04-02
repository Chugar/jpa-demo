package io.chugar.jpademo.manytomany.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import io.chugar.jpademo.manytomany.dao.queries.CoursQuery;
import io.chugar.jpademo.manytomany.domain.entity.Cours;

public interface CoursRepo extends JpaRepository<Cours, String> {

	Cours findById(Long id);
	
	
	@Query(nativeQuery = true, value = CoursQuery.MSQL_ADD_STUDENT_TO_COURSE)
	@Modifying
	void addStudentToCourse(Long idEtudiant, Long idCours);


	@Query(nativeQuery = true, value = CoursQuery.MSQL_REMOVE_STUDENT_TO_COURSE)
	@Modifying
	void removeStudentFromCourse(Long idEtudiant, Long idCours);
	
	
	
	
}
