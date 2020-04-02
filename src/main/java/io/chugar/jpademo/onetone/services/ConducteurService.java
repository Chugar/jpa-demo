package io.chugar.jpademo.onetone.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.chugar.jpademo.onetone.dao.repo.ConducteurRepo;
import io.chugar.jpademo.onetone.dao.repo.PermisRepo;
import io.chugar.jpademo.onetone.domain.entity.Conducteur;
import io.chugar.jpademo.onetone.domain.entity.Permis;
import io.chugar.jpademo.onetone.services.type.CondcuteurType;
import io.chugar.jpademo.onetone.services.type.PermisType;

@Service
public class ConducteurService {

	
	/* FIELDS */

	ConducteurRepo conducteurRepo;
	PermisRepo permisRepo;

	
	
	/* CONSTRUCTOR */

	@Autowired
	public ConducteurService(ConducteurRepo conducteurRepo, PermisRepo permisRepo) {
		super();
		this.conducteurRepo = conducteurRepo;
		this.permisRepo = permisRepo;
	}

	
	
	/* METHODS */
	
	public List<Conducteur> getCondcuteurs() {
		return conducteurRepo.findAll();
	}
	

	public ResponseEntity<String> addOneConducteur(Conducteur conducteur) {
		
		if ( conducteurAlreadyExists(conducteur) ) {
			return new ResponseEntity<>(CondcuteurType.EXISTS, HttpStatus.CONFLICT);
		}
		
		if( permisIsNotValid(conducteur.getPermis()) ) {
			conducteur.setPermis(null);
		}

		conducteurRepo.save(conducteur);
		return new ResponseEntity<>(CondcuteurType.ADDED, HttpStatus.CREATED);
	}
	
	
	
	@Transactional
	public ResponseEntity<String> updateConducteur(Long id, Conducteur newConducteur) {
		
		Conducteur currentConducteur = conducteurRepo.findById(id);
		
		// Permis update
		if (newConducteur.getPermis() != null ) {
			
			if ( permisIsNotValid(newConducteur.getPermis()) ) {
				return new ResponseEntity<>(PermisType.NOT_VALID, HttpStatus.BAD_REQUEST);
			}
			
			currentConducteur.setName(newConducteur.getName());
			currentConducteur.setPermis(newConducteur.getPermis());
			return new ResponseEntity<>(CondcuteurType.UPDATED, HttpStatus.OK);
		}
		
		// No permis update
		currentConducteur.setName(newConducteur.getName());
		return new ResponseEntity<>(CondcuteurType.UPDATED, HttpStatus.OK);
	}
	
	
	
	@Transactional
	public ResponseEntity<String> deleteOneCondcuteur(Long id) {
		conducteurRepo.deleteById(id);
		return new ResponseEntity<>(CondcuteurType.REMOVED, HttpStatus.OK);
	}
	

	@Transactional
	public ResponseEntity<String> addPermisToConducteur(Long id, Permis permis) {

		Conducteur currentConducteur = conducteurRepo.findById(id);

		if (currentConducteur.getPermis() != null) {
			return new ResponseEntity<>(PermisType.NOT_VALID, HttpStatus.BAD_REQUEST);
		}

		Permis savedPermis = permisRepo.save(permis);
		currentConducteur.setPermis(savedPermis);
		conducteurRepo.save(currentConducteur);

		return new ResponseEntity<>(PermisType.ADDED, HttpStatus.OK);
	}
	
	
	
	@Transactional
	public ResponseEntity<String> deleteConducteurPermis(Long id) {

		Conducteur currConducteur = conducteurRepo.findById(id);
		Permis currPermis = currConducteur.getPermis();

		permisRepo.delete(currPermis);
		currConducteur.setPermis(null);
		
		return new ResponseEntity<>(PermisType.REMOVED, HttpStatus.OK);

	}

	
	

	
	@Transactional
	public ResponseEntity<String> updatePermisOf(Long id, Permis newPermis) {
		
		// TODO: tester un update sur un permis null
		
		if( permisIsNotValid(newPermis) ) {
			return new ResponseEntity<>(PermisType.NOT_VALID, HttpStatus.BAD_REQUEST);
		}

		Conducteur currentConducteur = conducteurRepo.findById(id);
		Permis oldPermis = currentConducteur.getPermis();
		currentConducteur.setPermis(newPermis);
		conducteurRepo.save(currentConducteur);

		if (oldPermis != null )
			permisRepo.delete(oldPermis);

		
		return new ResponseEntity<>(PermisType.UPDATED, HttpStatus.OK);
	}
	

	
	/* INTERNAL METHODS */
	
	private boolean conducteurAlreadyExists(Conducteur newConducteur) {

		return conducteurRepo.findAll().stream()
				.anyMatch(elt -> elt.getName() == newConducteur.getName());
	}
	

	private boolean permisIsNotValid(Permis permis) {
		return permis.getReference().isBlank() |  permis.getReference() == null; 
	}

	

}
