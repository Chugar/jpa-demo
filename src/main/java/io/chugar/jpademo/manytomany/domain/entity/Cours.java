package io.chugar.jpademo.manytomany.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cours")
public class Cours {

	/* FIELDS */
	
	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cours_id")
	private Long id;
	
	@Column(name = "cours_name")
	private String name;
	
	@ManyToMany(mappedBy = "listeCours")
	private List<Etudiant> participants;
	
	
	

	/* CONSTRUCTOR */
	
	public Cours(Long id, String name, List<Etudiant> participants) {
		super();
		this.id = id;
		this.name = name;
		this.participants = participants;
	}

	public Cours() {
		super();
	}
	
	

	/* GETTERS & SETTERS */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Etudiant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Etudiant> participants) {
		this.participants = participants;
	}
	
}
