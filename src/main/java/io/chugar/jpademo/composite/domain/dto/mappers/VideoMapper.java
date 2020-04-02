package io.chugar.jpademo.composite.domain.dto.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.chugar.jpademo.composite.domain.dto.impl.VideoDTO;
import io.chugar.jpademo.composite.domain.dto.impl.VideoDataDTO;
import io.chugar.jpademo.composite.domain.entity.Video;
import io.chugar.jpademo.manytomany.domain.dto.DTOMapper;


@Component
public class VideoMapper implements DTOMapper<VideoDTO, Video>{
	
	
	VideoDataMapper videoDataMapper;
	
	
	
	@Autowired
	public VideoMapper(VideoDataMapper videoDataMapper) {
		super();
		this.videoDataMapper = videoDataMapper;
	}




	@Override
	public VideoDTO entityToDto(Video video) {
		
		VideoDTO dto = new VideoDTO();
		
		List<VideoDataDTO> videoDataDto = video.getVideoData().stream()
			.map(vd -> videoDataMapper.entityToDto(vd) )
			.collect(Collectors.toList());
		// ./
		
		dto.setId(video.getId());
		dto.setTitle(video.getTitle());
		dto.setData(videoDataDto);
		
		return dto;
	}
	

}
