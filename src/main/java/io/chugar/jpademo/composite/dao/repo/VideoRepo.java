package io.chugar.jpademo.composite.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.chugar.jpademo.composite.domain.entity.Video;

public interface VideoRepo extends JpaRepository<Video, String> {

	Video findById(Long id);

}
