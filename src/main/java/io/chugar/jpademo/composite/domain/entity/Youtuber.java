package io.chugar.jpademo.composite.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "youtuber")
public class Youtuber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "youtuber_id")
	private Long id;
	
	@Column(name = "login")
	private String login;
	
	

	public Youtuber(Long id, String login) {
		super();
		this.id = id;
		this.login = login;
	}



	public Youtuber() {
		super();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}
	

}
