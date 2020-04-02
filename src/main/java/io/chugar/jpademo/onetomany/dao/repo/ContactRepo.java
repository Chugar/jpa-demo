package io.chugar.jpademo.onetomany.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.chugar.jpademo.onetomany.domain.entity.Contact;


@Repository
public interface ContactRepo extends JpaRepository<Contact, String>{
	
	Contact findById(Long id);
	void deleteById(Long id);

}
