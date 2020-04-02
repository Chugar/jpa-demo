package io.chugar.jpademo.onetomany.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.chugar.jpademo.onetomany.domain.entity.Carnet;
import io.chugar.jpademo.onetomany.domain.entity.Contact;
import io.chugar.jpademo.onetomany.services.CarnetService;

@RestController
public class CarnetController {

	/* FIELDS */
	
	CarnetService carnetService;

	
	
	/* CONSTRUCTOR */
	
	@Autowired
	public CarnetController(CarnetService carnetService) {
		super();
		this.carnetService = carnetService;
	}


	
	
	
	/* GETTERS & SETTERS */
	
	@GetMapping("/carnets")
	public List<Carnet> getAll() {
		return carnetService.getAll();
	}
	

	@PostMapping("/carnet/{id}/contact")
	public ResponseEntity<String> addContact(@PathVariable Long id, @RequestBody Contact newContact) {
		return carnetService.addContactToCarnet(id, newContact);
	}
	
	
	@PutMapping("/carnet/{id}/contact")
	public ResponseEntity<String> updateContact(@PathVariable Long id, @RequestBody Contact contact ) {
		return carnetService.updateContactOfCarnet(id, contact);
	}
	
	
	@DeleteMapping("/carnet/{id}/contact")
	public ResponseEntity<String> deleteContact(@PathVariable(name = "id") Long carnetId, @RequestBody Contact contact) {
		return carnetService.deleteContactFromCarnet(carnetId, contact);
	}	
	
}
