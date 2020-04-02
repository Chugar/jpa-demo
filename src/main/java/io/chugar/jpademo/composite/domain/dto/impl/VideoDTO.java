package io.chugar.jpademo.composite.domain.dto.impl;

import java.util.List;

public class VideoDTO {

	/* FIELDS */
	
	private Long id;
	private String title;
	private List<VideoDataDTO> data;
	
	
	
	
	/* CONSTRUCTOR */ 
	
	public VideoDTO(Long id, String title, List<VideoDataDTO> data) {
		super();
		this.id = id;
		this.title = title;
		this.data = data;
	}


	public VideoDTO() {
		
	}

	

	/* GETTERS & SETTERS */
	
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


	public List<VideoDataDTO> getData() {
		return data;
	}


	public void setData(List<VideoDataDTO> data) {
		this.data = data;
	}

	
}
