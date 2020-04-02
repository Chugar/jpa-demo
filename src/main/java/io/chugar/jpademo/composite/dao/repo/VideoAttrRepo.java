package io.chugar.jpademo.composite.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.chugar.jpademo.composite.domain.entity.VideoAttributes;
import io.chugar.jpademo.composite.domain.entity.VideoAttributesId;

public interface VideoAttrRepo extends JpaRepository<VideoAttributes, String> {

	VideoAttributes findById(VideoAttributesId videoAttributesId);

}
