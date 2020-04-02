package io.chugar.jpademo.composite.domain.dto.mappers;

import org.springframework.stereotype.Component;

import io.chugar.jpademo.composite.domain.dto.impl.VideoDataDTO;
import io.chugar.jpademo.composite.domain.entity.VideoAttributes;
import io.chugar.jpademo.manytomany.domain.dto.DTOMapper;

@Component
public class VideoDataMapper implements DTOMapper<VideoDataDTO, VideoAttributes> {

	@Override
	public VideoDataDTO entityToDto(VideoAttributes videoData) {
		VideoDataDTO dto = new VideoDataDTO();
		dto.setAuthor(videoData.getYoutuber().getLogin());
		dto.setComment(videoData.getComment());
		dto.setLiked(videoData.isLiked());
		return dto;
	}

	
}
