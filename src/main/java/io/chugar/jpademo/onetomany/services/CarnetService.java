package io.chugar.jpademo.onetomany.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.chugar.jpademo.onetomany.dao.repo.CarnetRepo;
import io.chugar.jpademo.onetomany.dao.repo.ContactRepo;
import io.chugar.jpademo.onetomany.domain.entity.Carnet;
import io.chugar.jpademo.onetomany.domain.entity.Contact;
import io.chugar.jpademo.onetomany.services.type.ContactType;

@Service
public class CarnetService {
	
	/* FIELDS */
	
	CarnetRepo carnetRepo;
	ContactRepo contactRepo;
	
	// TODO: (bonus) supprimer de multiples contacts en même temps

	
	
	/* CONSTRUCTOR */
	
	@Autowired
	public CarnetService(CarnetRepo carnetRepo, ContactRepo contactRepo) {
		super();
		this.carnetRepo = carnetRepo;
		this.contactRepo = contactRepo;
	}
	
	public CarnetService() {
		super();
	}
	
	
	
	/* METHODS */
	
	public List<Carnet> getAll() {
		return carnetRepo.findAll();
	}
	
	
	
	public ResponseEntity<String> addContactToCarnet(Long id, Contact contact) {
		
		if(isNotValid(contact))
			return new ResponseEntity<>(ContactType.NOT_VALID, HttpStatus.BAD_REQUEST);
					
		Carnet currentCarnet = carnetRepo.findById(id);
		List<Contact> itsContacts = currentCarnet.getContacts();
		
		if(alreadyExists(itsContacts, contact))
			return new ResponseEntity<>(ContactType.ALREADY_EXISTS, HttpStatus.BAD_REQUEST);
		
		itsContacts.add(contact);
		currentCarnet.setContacts(itsContacts);
		
		carnetRepo.save(currentCarnet);
		return new ResponseEntity<>(ContactType.ADDED, HttpStatus.OK);
	}
	
	
	
	@Transactional
	public ResponseEntity<String> updateContactOfCarnet(Long id, Contact newContact) {
		
		Contact currentContact = contactRepo.findById(newContact.getId());
		currentContact.setName(newContact.getName());
		contactRepo.save(currentContact);
		
		return new ResponseEntity<>(ContactType.UPDATED, HttpStatus.OK);
		
	}

	
	@Transactional
	public ResponseEntity<String> deleteContactFromCarnet(Long carnetId, Contact contact) {
				
		Carnet currentCarnet = carnetRepo.findById(carnetId);
		List<Contact> itsContacts = currentCarnet.getContacts();
		
		List<Contact> refreshedContacts = itsContacts.stream()
			.filter(c -> c.getId() != contact.getId() )
			.collect(Collectors.toList());		
		// ./
		
		currentCarnet.setContacts(refreshedContacts);
		carnetRepo.save(currentCarnet);	
		contactRepo.deleteById(contact.getId());
		
		return new ResponseEntity<>(ContactType.REMOVED, HttpStatus.OK);
		
	}
	
	
	/* INTERNAL METHODS */
	
	private boolean alreadyExists(List<Contact> existing, Contact contact) {
		return existing.stream()
			.anyMatch(c -> c.getName() == contact.getName());
	}
	
	
	private boolean isNotValid(Contact contact) {
		String name = contact.getName();
		return name.isBlank() | name.isEmpty() | name == null;
	}

	

	
}
	
	
