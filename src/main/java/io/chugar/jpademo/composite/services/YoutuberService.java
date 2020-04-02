package io.chugar.jpademo.composite.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.chugar.jpademo.composite.dao.repo.VideoRepo;
import io.chugar.jpademo.composite.dao.repo.YoutuberRepo;
import io.chugar.jpademo.composite.domain.dto.impl.YoutuberDTO;
import io.chugar.jpademo.composite.domain.dto.mappers.YoutuberMapper;

@Service
public class YoutuberService {
	
	VideoRepo videoRepo;
	YoutuberRepo youtuberRepo;
	YoutuberMapper youtuberMappr;
	
	
	@Autowired
	public YoutuberService(VideoRepo videoRepo, YoutuberRepo youtuberRepo, YoutuberMapper youtuberMapper ) {
		super();
		this.videoRepo = videoRepo;
		this.youtuberRepo = youtuberRepo;
		this.youtuberMappr = youtuberMapper;
	}

	
	
	public List<YoutuberDTO> getAllUsers() {
		
		return youtuberRepo.findAll().stream()
			.map(yt ->  youtuberMappr.entityToDto(yt))
			.collect(Collectors.toList());
		// ;
		
	}

}
