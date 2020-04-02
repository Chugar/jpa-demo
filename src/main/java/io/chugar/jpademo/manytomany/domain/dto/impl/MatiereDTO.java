package io.chugar.jpademo.manytomany.domain.dto.impl;

public class MatiereDTO {
	
	private String title;

	
	public MatiereDTO(String title) {
		super();
		this.title = title;
	}


	public MatiereDTO() {
		super();
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	

}
