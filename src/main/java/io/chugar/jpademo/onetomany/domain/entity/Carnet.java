package io.chugar.jpademo.onetomany.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "carnet")
public class Carnet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carnet_id")
	private Long id;

	@Column(name = "carnet_name")
	private String name;

	/**
	 * @JoinColumn
	 * key from target side => owning side
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_carnet", referencedColumnName = "carnet_id")
	private List<Contact> contacts = new ArrayList<>();

	public Carnet() {
		super();
	}


	public Carnet(Long id, String name, List<Contact> contacts) {
		super();
		this.id = id;
		this.name = name;
		this.contacts = contacts;
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

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}
