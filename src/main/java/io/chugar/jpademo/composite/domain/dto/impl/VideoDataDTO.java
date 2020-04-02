package io.chugar.jpademo.composite.domain.dto.impl;

public class VideoDataDTO {
	
	/* FIELDS */
	
	private String author;
	private String comment;
	private boolean liked;
	
	
	
	/* CONSTRUCTOR */
	
	public VideoDataDTO(String author, String comment, boolean liked) {
		super();
		this.author = author;
		this.comment = comment;
		this.liked = liked;
	}
	
	
	
	/* GETTERS & SETTERS */
	
	public VideoDataDTO() {
		super();
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public boolean isLiked() {
		return liked;
	}


	public void setLiked(boolean liked) {
		this.liked = liked;
	}
	

}
