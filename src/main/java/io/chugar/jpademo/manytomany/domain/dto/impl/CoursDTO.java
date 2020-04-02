package io.chugar.jpademo.manytomany.domain.dto.impl;

import java.util.List;

public class CoursDTO {

	/* FIELDS */
	private String title;
	private int headcount;
	private List<ParticipantDTO> participants;
	
	
	
	/* CONSTRUCTOR */
	public CoursDTO(String title, int nb, List<ParticipantDTO> p) {
		this.title = title;
		this.headcount = nb;
		this.participants = p;
	}
	
	
	public CoursDTO() {
		super();
	}
	


	/* GETTERS & SETTERS */
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public List<ParticipantDTO> getParticipants() {
		return participants;
	}


	public void setParticipants(List<ParticipantDTO> participants) {
		this.participants = participants;
	}


	public int getHeadcount() {
		return headcount;
	}


	public void setHeadcount(int headcount) {
		this.headcount = headcount;
	}
	
}
