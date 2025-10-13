package com.gestione.Immobiliare.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestione.Immobiliare.dto.UtenteDTO;
import com.gestione.Immobiliare.service.IUtenteService;

@RestController
@RequestMapping("users")
public class UtenteController {

	@Autowired
	private IUtenteService utenteService;

	@PostMapping("/register")
	public ResponseEntity registraUtente(@RequestBody UtenteDTO utenteDto) throws Exception {
		try {
            UtenteDTO nuovoUtente = utenteService.registraUtente(utenteDto);
            return ResponseEntity.ok(nuovoUtente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Errore durante la registrazione: " + e.getMessage());
        }
	}
	
	@GetMapping("/login")
	public ResponseEntity loginUtente(@RequestParam String email, @RequestParam String password) {
		try {
			Optional<UtenteDTO> utenteDto = utenteService.trovaLogin(email, password);
			if (utenteDto.isPresent()) {
	            return ResponseEntity.ok(utenteDto.get()); 
	        } else {
	            return ResponseEntity.status(404).body("Utente non trovato o credenziali errate");
	        }
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Errore durante la login: " + e.getMessage());
		}
	}
}
