package io.chugar.jpademo.composite.domain.dto.impl;


public class YoutuberDTO {
	
	/* FIELDS */
	
	private Long id;
	private String login;
	
	
	
	/* CONSTRUCTOR */
	
	public YoutuberDTO(Long id, String login) {
		super();
		this.id = id;
		this.login = login;
	}

	
	
	/* GETTERS & SETTERS */
	
	public YoutuberDTO() {
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
