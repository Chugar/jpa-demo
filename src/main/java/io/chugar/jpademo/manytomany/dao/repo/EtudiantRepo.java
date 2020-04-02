package io.chugar.jpademo.manytomany.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.chugar.jpademo.manytomany.domain.entity.Etudiant;

public interface EtudiantRepo extends JpaRepository<Etudiant, String> {
	
	
	
	Etudiant findById(Long id);
	
	boolean existsById(Long id);
	
}
