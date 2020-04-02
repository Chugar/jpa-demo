package io.chugar.jpademo.onetomany.services;

import org.springframework.beans.factory.annotation.Autowired;

import io.chugar.jpademo.onetomany.dao.repo.ContactRepo;

public class ContactService {
	
	/* FIELDS */
	ContactRepo contactRepo;

	
	
	
	
	/* CONSTRUCTOR */
	@Autowired
	public ContactService(ContactRepo contactRepo) {
		super();
		this.contactRepo = contactRepo;
	}
	
	
	
	
	
	
	/* METHODS */
	
	
	
	

}
