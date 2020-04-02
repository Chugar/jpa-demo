package io.chugar.jpademo.composite.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.chugar.jpademo.composite.dao.repo.VideoAttrRepo;
import io.chugar.jpademo.composite.dao.repo.VideoRepo;
import io.chugar.jpademo.composite.dao.repo.YoutuberRepo;
import io.chugar.jpademo.composite.domain.dto.impl.VideoDTO;
import io.chugar.jpademo.composite.domain.dto.mappers.VideoDataMapper;
import io.chugar.jpademo.composite.domain.dto.mappers.VideoMapper;
import io.chugar.jpademo.composite.domain.entity.Video;
import io.chugar.jpademo.composite.domain.entity.VideoAttributes;
import io.chugar.jpademo.composite.domain.entity.VideoAttributesId;
import io.chugar.jpademo.composite.domain.entity.Youtuber;
import io.chugar.jpademo.composite.services.type.YoutuberType;


@Service
public class VideoService {
	
	
	/* FIELDS */
	
	VideoRepo videoRepo;
	YoutuberRepo youtuberRepo;
	VideoAttrRepo videoAttrRepo;
	VideoMapper videoMapper;
	VideoDataMapper videoDataMapper;
	
	
	
	/* CONSTRUCTOR */
	@Autowired
	public VideoService(VideoRepo videoRepo, YoutuberRepo youtuberRepo, VideoAttrRepo videoAttrRepo,
			VideoMapper videoMapper, VideoDataMapper videoDataMapper) {
		super();
		this.videoRepo = videoRepo;
		this.youtuberRepo = youtuberRepo;
		this.videoAttrRepo = videoAttrRepo;
		this.videoMapper = videoMapper;
		this.videoDataMapper = videoDataMapper;
	}
	



	public List<VideoDTO> getAllVideos() {
		
		List<Video> videos = videoRepo.findAll();
		
		List<VideoDTO> videoDtos = videos.stream()
			.map(v -> videoMapper.entityToDto(v))
			.collect(Collectors.toList());
		// ./
		 
		return  videoDtos;
	}

	
	


	public VideoDTO getOneVideo(Long id) {
		Video videoEntity = videoRepo.findById(id);
		return videoMapper.entityToDto(videoEntity);
	}



	public ResponseEntity<String> addCommentToVideo(Long videoId, VideoAttributes videoAttributes) {
		
		if ( notValid(videoAttributes.getComment())) {
			return new ResponseEntity<>(YoutuberType.INVALID_COMMENT, HttpStatus.BAD_REQUEST);
		}
		
		
		Video video = videoRepo.findById(videoId);
		Long youtuberId = videoAttributes.getYoutuber().getId();
		Youtuber youtuber = youtuberRepo.findById(youtuberId);
		
		
		if (!youtuberExists(youtuber)) {
			return new ResponseEntity<>(YoutuberType.NON_EXISTENT, HttpStatus.BAD_REQUEST);
		}
		
		
		videoAttributes.setId(new VideoAttributesId(youtuberId, videoId));
		videoAttributes.setVideo(video);
		videoAttributes.setYoutuber(youtuber);
		
		videoAttrRepo.save(videoAttributes);
		
		return new ResponseEntity<>(YoutuberType.ADDED_COMMENT, HttpStatus.OK);
	}
	
	
	public ResponseEntity<String> updateComment(Long videoId, VideoAttributes videoAttributes ) {
		
		// Check comment validity
		if ( notValid(videoAttributes.getComment())) {
			return new ResponseEntity<>(YoutuberType.INVALID_COMMENT, HttpStatus.BAD_REQUEST);
		}
		
		
		Long youtuberId = videoAttributes.getYoutuber().getId();
		VideoAttributes currentVideoAttr = videoAttrRepo.findById(new VideoAttributesId(youtuberId, videoId));
		currentVideoAttr.setComment(videoAttributes.getComment());
		videoAttrRepo.save(currentVideoAttr);
		
		
		return new ResponseEntity<>(YoutuberType.UPDATED_COMMENT, HttpStatus.OK);
	}
	
	

	public ResponseEntity<String> deleteComment(Long videoId, VideoAttributes videoAttributes) {
		
		Long youtuberId = videoAttributes.getYoutuber().getId();
		VideoAttributes currentVideoAttr = videoAttrRepo.findById(new VideoAttributesId(youtuberId, videoId));
		
		currentVideoAttr.setComment(null);
		videoAttrRepo.save(currentVideoAttr);
				
		return new ResponseEntity<>(YoutuberType.REMOVED_COMMENT, HttpStatus.OK);
	}
	
	
	
	public ResponseEntity<String> likeVideo(Long videoId, VideoAttributes videoAttributes ) {
		
		Long youtuberId = videoAttributes.getYoutuber().getId();
		VideoAttributes currentVideoAttr = videoAttrRepo.findById(new VideoAttributesId(youtuberId, videoId));
		currentVideoAttr.setLiked(true);
		
		videoAttrRepo.save(currentVideoAttr);
		
		return new ResponseEntity<>(YoutuberType.VIDEO_LIKED, HttpStatus.OK);


	}
	
	public ResponseEntity<String> dislikeVideo(Long videoId, VideoAttributes videoAttributes ) {
		return null;
	}
	
	
	
	
	
	/* INTERNAL METHODS */
	
	private boolean youtuberExists(Youtuber youtuber) {
		return youtuberRepo.existsById(youtuber.getId());
	}

	private boolean notValid(String comment) {
		return comment.isBlank() | comment == null;
	}








}
