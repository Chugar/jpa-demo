package io.chugar.jpademo.composite.domain.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "youtuber_video")
public class VideoAttributes {
	
	@JsonIgnore
	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.AUTO)
	VideoAttributesId id;
	
	@ManyToOne
	@JoinColumn(name = "id_youtuber")
	@MapsId("youtuber_id")
	private Youtuber youtuber;
	
	
	@ManyToOne 
	@JoinColumn(name = "id_video")
	@MapsId("video_id")
	private Video video;
	
	@Column(name = "liked")
	private boolean liked;
	
	@Column(name = "comment")
	private String comment;

	
	public VideoAttributes(VideoAttributesId id, Youtuber youtuber, Video video, boolean liked, String comment) {
		super();
		this.id = id;
		this.youtuber = youtuber;
		this.video = video;
		this.liked = liked;
		this.comment = comment;
	}


	public VideoAttributes() {
		super();
	}


	public VideoAttributesId getId() {
		return id;
	}


	public void setId(VideoAttributesId id) {
		this.id = id;
	}


	public Youtuber getYoutuber() {
		return youtuber;
	}


	public void setYoutuber(Youtuber youtuber) {
		this.youtuber = youtuber;
	}


	public Video getVideo() {
		return video;
	}


	public void setVideo(Video video) {
		this.video = video;
	}


	public boolean isLiked() {
		return liked;
	}


	public void setLiked(boolean liked) {
		this.liked = liked;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}	
	

}
