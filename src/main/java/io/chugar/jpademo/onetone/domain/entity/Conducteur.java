package io.chugar.jpademo.onetone.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "conducteur")
public class Conducteur {
	
	/* FIELDS */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "conducteur_id")
	private Long id;
	
	@Column(name = "conducteur_name")
	private String name;
	
	/**
	 * @JoinColumn key from owning side to target side
	 * cascade ALL saves the transient instance with its owning instance
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_permis", referencedColumnName = "permis_id")
	private Permis permis;


	
	/* CONSTRUCTOR */
	
	public Conducteur(Long id, String name, Permis permis) {
		super();
		this.id = id;
		this.name = name;
		this.permis = permis;
	}


	/* GETTERS & SETTERS */
	
	public Conducteur() {
		super();
	}


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


	public Permis getPermis() {
		return permis;
	}


	public void setPermis(Permis permis) {
		this.permis = permis;
	}
	

}
