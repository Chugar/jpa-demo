package io.chugar.jpademo.composite.domain.dto.mappers;

import org.springframework.stereotype.Component;

import io.chugar.jpademo.composite.domain.dto.impl.YoutuberDTO;
import io.chugar.jpademo.composite.domain.entity.Youtuber;
import io.chugar.jpademo.manytomany.domain.dto.DTOMapper;

@Component
public class YoutuberMapper implements DTOMapper<YoutuberDTO, Youtuber> {

	@Override
	public YoutuberDTO entityToDto(Youtuber youtuber) {
		YoutuberDTO dto = new YoutuberDTO();
		dto.setId(youtuber.getId());
		dto.setLogin(youtuber.getLogin());
		return dto;
	}

	
	
}
