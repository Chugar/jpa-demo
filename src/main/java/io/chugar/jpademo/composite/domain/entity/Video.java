package io.chugar.jpademo.composite.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "video")
public class Video {
	
	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "video_id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@OneToMany(mappedBy = "video")
	List<VideoAttributes> videoData;
	


	public Video(Long id, String title, List<VideoAttributes> videoData) {
		super();
		this.id = id;
		this.title = title;
		this.videoData = videoData;
	}



	public Video() {
		super();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public List<VideoAttributes> getVideoData() {
		return videoData;
	}


	public void setVideoData(List<VideoAttributes> videoData) {
		this.videoData = videoData;
	}
	

	
}
