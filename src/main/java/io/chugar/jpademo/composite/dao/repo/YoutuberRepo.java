package io.chugar.jpademo.composite.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.chugar.jpademo.composite.domain.entity.Youtuber;

public interface YoutuberRepo extends JpaRepository<Youtuber, String> {

	boolean existsById(Long id);

	Youtuber findById(Long id);

}
