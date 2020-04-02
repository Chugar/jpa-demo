package io.chugar.jpademo.manytomany.domain.dto.impl;

public class ParticipantDTO  {

	/* FIELDS */
	private String name;

	
	/* CONSTRUCTOR */
	public ParticipantDTO(String name) {
		this.name = name;
	}
 
	/* GETTERS & SETTERS */
	public ParticipantDTO() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
