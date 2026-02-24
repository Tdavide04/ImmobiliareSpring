package com.gestione.Immobiliare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestione.Immobiliare.dto.BuyRequest;
import com.gestione.Immobiliare.dto.VenditaDTO;
import com.gestione.Immobiliare.service.IVenditaService;
import com.gestione.Immobiliare.utility.VenditaTemplate;

@RestController
@RequestMapping("sale")
public class VenditaController {

	@Autowired
	private IVenditaService venditaService;
	
	@PostMapping("/buy")
	public ResponseEntity effettuaVendita(@RequestBody BuyRequest req) {
		try {
			VenditaDTO vendita = venditaService.effettuaVendita(req.getNomeImmobile().trim());
			return ResponseEntity.ok(vendita);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Errore durante la vendita: " + e.getMessage());
		}
	}
	
	@DeleteMapping("/cancel")
	public ResponseEntity cancellaVendita(@RequestParam Long idVendita) throws Exception {
		try {
			venditaService.cancellaVendita(idVendita);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Errore durante la cancellazione della vendita: " + e.getMessage());
		}
	}
}
