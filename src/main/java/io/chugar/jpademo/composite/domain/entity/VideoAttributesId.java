package io.chugar.jpademo.composite.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VideoAttributesId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name = "id_youtuber")
	private Long youtuberId;
	
	
	@Column(name = "id_video")
	private Long videoId;


	public VideoAttributesId(Long youtuberId, Long videoId) {
		super();
		this.youtuberId = youtuberId;
		this.videoId = videoId;
	}


	public VideoAttributesId() {
		super();
	}


	public Long getYoutuberId() {
		return youtuberId;
	}


	public void setYoutuberId(Long youtuberId) {
		this.youtuberId = youtuberId;
	}


	public Long getVideoId() {
		return videoId;
	}


	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}	
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
}
