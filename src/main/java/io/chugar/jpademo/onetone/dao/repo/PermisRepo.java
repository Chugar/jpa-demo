package io.chugar.jpademo.onetone.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.chugar.jpademo.onetone.domain.entity.Permis;

public interface PermisRepo extends JpaRepository<Permis, String> {

	void deleteById(Long id);
	
}
