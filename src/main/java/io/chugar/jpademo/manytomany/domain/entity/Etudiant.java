package io.chugar.jpademo.manytomany.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "etudiant")
public class Etudiant {
	
	/* FIELDS */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "etudiant_id")
	private Long id;
	
	
	@Column(name = "etudiant_name")
	private String name;
	
	
	/**
	 * @JoinTable 
	 * key from join table => owning side 
	 * key from join table => target side
	 */
	@ManyToMany
	@JoinTable(
		name = "etudiant_cours",
		joinColumns = @JoinColumn(name="id_etudiant"),
		inverseJoinColumns = @JoinColumn(name="id_cours")
	)
	private List<Cours> listeCours;
	
	
	
	
	/* CONSTRUCTOR */

	public Etudiant(Long id, String name, List<Cours> listeCours) {
		super();
		this.id = id;
		this.name = name;
		this.listeCours = listeCours;
	}
	
	public Etudiant() {
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

	public List<Cours> getListeCours() {
		return listeCours;
	}

	public void setListeCours(List<Cours> listeCours) {
		this.listeCours = listeCours;
	}
	
	

}

