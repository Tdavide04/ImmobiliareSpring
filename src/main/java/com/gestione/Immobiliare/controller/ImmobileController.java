package com.gestione.Immobiliare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestione.Immobiliare.dto.ImmobileDTO;
import com.gestione.Immobiliare.model.Immobile;
import com.gestione.Immobiliare.service.IImmobileService;

@RestController
@RequestMapping("property")
public class ImmobileController {

	@Autowired
	private IImmobileService immobileService;
	
	@GetMapping("/see_all")
	public ResponseEntity<?> getAllImmobili() {
	    try {
	        List<ImmobileDTO> immobili = immobileService.trovaTutti();
	        return ResponseEntity.ok(immobili);
	    } catch (Exception e) {
	        return ResponseEntity.badRequest()
	                .body("Errore durante il recupero degli immobili: " + e.getMessage());
	    }
	}
	
	@GetMapping("/see")
	public ResponseEntity getImmobile(@RequestParam Long id) {
	    try {
	        Immobile immobile = immobileService.trovaPerId(id).get();
	        return ResponseEntity.ok(immobile);
	    } catch (Exception e) {
	        return ResponseEntity.badRequest()
	                .body("Errore durante il recupero degli immobili: " + e.getMessage());
	    }
	}


	@PostMapping("/add")
	public ResponseEntity aggiungiImmobile(@RequestBody ImmobileDTO immobileDto) {
		try {
			ImmobileDTO immobile = immobileService.aggiungiImmobile(immobileDto);
			return ResponseEntity.ok(immobile);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Errore durante l'aggiunta dell'immobile: " + e.getMessage());
		}
	}

	@PutMapping("/edit")
	public ResponseEntity modificaImmobile(@RequestBody ImmobileDTO immobileDto) {
		try {

			Immobile immobile = immobileService.trovaPerId(immobileDto.getIdImmobile()).get();
			return ResponseEntity.ok(immobile);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Errore durante la modifica dell'immobile: " + e.getMessage());
		}
	}
	
	@DeleteMapping("/elimina")
	public ResponseEntity eliminaImmobile(@RequestParam Long idImmobile) {
		try {
			immobileService.rimuoviImmobile(idImmobile);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Errore durante la cancellazione dell'immobile: " + e.getMessage());
		}
	}
}
