package io.chugar.jpademo.onetone.resources;

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

import io.chugar.jpademo.onetone.domain.entity.Conducteur;
import io.chugar.jpademo.onetone.domain.entity.Permis;
import io.chugar.jpademo.onetone.services.ConducteurService;

@RestController
public class ConducteurController {
	
	/* FIELDS */
	
	ConducteurService conducteurService;

	
	
	/* CONSTRUCTOR */
	
	@Autowired
	public ConducteurController(ConducteurService service) {
		super();
		this.conducteurService = service;
	}


	public ConducteurController() {
		super();
	}
	
	
	/* METHODS */
	
	@GetMapping("/conducteur")
	public List<Conducteur> getAllConducteurs() {
		return conducteurService.getCondcuteurs();
	}
		
	
	@PostMapping("/conducteur")
	public ResponseEntity<String> addConducteur(@RequestBody Conducteur conducteur) {
		return conducteurService.addOneConducteur(conducteur);
	}
	
	
	@PutMapping("/conducteur/{id}")
	public ResponseEntity<String> updateConducteur(@PathVariable Long id, @RequestBody Conducteur newCo) {
		return conducteurService.updateConducteur(id, newCo);
	}
	
	
	@DeleteMapping("/conducteur/{id}")
	public ResponseEntity<String> deleteCondcuteur(@PathVariable Long id) {
		return conducteurService.deleteOneCondcuteur(id);
	}
	

	@PostMapping("/conducteur/{id}/permis")
	public ResponseEntity<String> addPermisOfConducteur(@PathVariable Long id, @RequestBody Permis permis) {
		return conducteurService.addPermisToConducteur(id, permis);
	}
	
	
	@PutMapping("/conducteur/{id}/permis")
	public ResponseEntity<String> updatePermisOfCondcuteur(@PathVariable Long id, @RequestBody Permis miper){
		return conducteurService.updatePermisOf(id, miper);
	}
	

	@DeleteMapping("/conducteur/{id}/permis")
	public ResponseEntity<String> deletePermisOfConducteur(@PathVariable Long id) {
		return conducteurService.deleteConducteurPermis(id);
	}
	
	
	

}
