package io.chugar.jpademo.manytomany.domain.dto.impl;

import java.util.List;

public class EtudiantDTO {
	
	
	/* FIELDS */
	
	private String name;
	private List<MatiereDTO> coursSuivis;
	
	
	
	
	/* CONSTRUCTOR */
	
	public EtudiantDTO(String name, List<MatiereDTO> coursSuivis) {
		super();
		this.name = name;
		this.coursSuivis = coursSuivis;
	}


	public EtudiantDTO() {
	}

	
	
	/* GETTERS & SETTERS */
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<MatiereDTO> getCoursSuivis() {
		return coursSuivis;
	}


	public void setCoursSuivis(List<MatiereDTO> coursSuivis) {
		this.coursSuivis = coursSuivis;
	}
	

}
