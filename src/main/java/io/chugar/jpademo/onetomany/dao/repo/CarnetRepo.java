package io.chugar.jpademo.onetomany.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.chugar.jpademo.onetomany.domain.entity.Carnet;

 @Repository
public interface CarnetRepo extends JpaRepository<Carnet, String>{
	
	Carnet findById(Long id);
	

}
