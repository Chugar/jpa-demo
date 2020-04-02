package io.chugar.jpademo.onetone.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.chugar.jpademo.onetone.domain.entity.Conducteur;


@Repository
public interface ConducteurRepo extends JpaRepository<Conducteur, String> {

	public Conducteur findById(Long id);
	public void deleteById(Long id);
}
