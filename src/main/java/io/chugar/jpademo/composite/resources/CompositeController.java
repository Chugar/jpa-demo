package io.chugar.jpademo.composite.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.chugar.jpademo.composite.domain.dto.impl.VideoDTO;
import io.chugar.jpademo.composite.domain.dto.impl.YoutuberDTO;
import io.chugar.jpademo.composite.domain.entity.VideoAttributes;
import io.chugar.jpademo.composite.services.VideoService;
import io.chugar.jpademo.composite.services.YoutuberService;

@RestController
public class CompositeController {
	
	// TODO: Un utilisateur peut liker une vidéo
	// TODO: Un utilisateur peut supprimmer son commentaire

	VideoService videoService;
	YoutuberService ytberService;
	
	
	@Autowired
	public CompositeController(VideoService videoService, YoutuberService ytberService) {
		this.videoService = videoService;
		this.ytberService = ytberService;
	}
	
	
	@GetMapping("/videos")
	public List<VideoDTO> getVideos() {
		return videoService.getAllVideos();
	}
	
	@GetMapping("/videos/{id}")
	public VideoDTO getOneVideo(@PathVariable Long id) {
		return videoService.getOneVideo(id);
	}
	
	
	@PostMapping("/videos/{id}/comment")
	public ResponseEntity<String> addCommentToVideo(@PathVariable Long id, @RequestBody VideoAttributes videoAttributes ) {
		return videoService.addCommentToVideo(id, videoAttributes);
	}
	
	@PutMapping("/videos/{id}/comment")
	public ResponseEntity<String> updateComment(@PathVariable Long id, @RequestBody VideoAttributes videoAttributes) {
		return videoService.updateComment(id, videoAttributes);
	}
	
	@DeleteMapping("/video/{id}/comment")
	public ResponseEntity<String> deleteComment(@PathVariable Long id, @RequestBody VideoAttributes videoAttributes) {
		
		videoService.deleteComment(id, videoAttributes);
		return null;
	}
	
	@GetMapping("/users")
	public List<YoutuberDTO> getUsers() {
		return ytberService.getAllUsers();
	}
	
	
}
