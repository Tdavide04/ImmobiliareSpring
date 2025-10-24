package com.gestione.Immobiliare.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestione.Immobiliare.dto.UtenteDTO;
import com.gestione.Immobiliare.security.JwtUtil;
import com.gestione.Immobiliare.service.IUtenteService;
import com.gestione.Immobiliare.utility.LoginRequest;

@RestController
@RequestMapping("users")
public class UtenteController {

	@Autowired
	private IUtenteService utenteService;
	private final JwtUtil jwtUtil;
	
	public UtenteController(JwtUtil jwt) {
		this.jwtUtil = jwt;
	}

	@PostMapping("/register")
	public ResponseEntity registraUtente(@RequestBody UtenteDTO utenteDto) throws Exception {
		try {
            UtenteDTO nuovoUtente = utenteService.registraUtente(utenteDto);
            return ResponseEntity.ok(nuovoUtente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Errore durante la registrazione: " + e.getMessage());
        }
	}
	
	@PostMapping("/login")
	public ResponseEntity loginUtente(@RequestBody LoginRequest request) {
		try {
			Optional<UtenteDTO> utenteDto = utenteService.trovaLogin(request.getEmail(), request.getPassword());
			
			if (utenteDto.isPresent()) {
				String token = jwtUtil.generateToken(utenteDto.get().getEmail());
				Map<String, String> response = new HashMap<>();
	            response.put("token", token);
	            return ResponseEntity.ok(response); 
	        } else {
	        	 Map<String, String> response = new HashMap<>();
	             response.put("error", "Utente non trovato o credenziali errate");
	             return ResponseEntity.status(404).body(response);
	        }
		} catch (Exception e) {
			Map<String, String> response = new HashMap<>();
	        response.put("error", "Errore durante la login: " + e.getMessage());
	        return ResponseEntity.badRequest().body(response);
		}
	}
}
