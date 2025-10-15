package com.gestione.Immobiliare.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestione.Immobiliare.dto.VenditaDTO;
import com.gestione.Immobiliare.model.Immobile;
import com.gestione.Immobiliare.model.Utente;
import com.gestione.Immobiliare.model.Vendita;
import com.gestione.Immobiliare.repository.ImmobileRepository;
import com.gestione.Immobiliare.repository.UtenteRepository;
import com.gestione.Immobiliare.repository.VenditaRepository;
import com.gestione.Immobiliare.service.IVenditaService;
import com.gestione.Immobiliare.utility.VenditaTemplate;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VenditaService implements IVenditaService{

	@Autowired
	private VenditaRepository venditaRepository;
	@Autowired
	private ImmobileRepository immobileRepository;
	@Autowired
	private UtenteRepository utenteRepository;
	
	public VenditaDTO effettuaVendita(VenditaTemplate template) throws Exception {
		Optional<Immobile> immobileOpt = immobileRepository.findById(template.getIdImmobile());
		Immobile immobile = immobileOpt.get();
		
		if(!immobileOpt.isPresent()) {
			throw new Exception("Immobile non trovato");
		}
		if(immobile.getDisponibile() == false) {
			throw new Exception("Immobile non disponibile");
		}
		
		Optional<Utente> utenteOpt = utenteRepository.findById(template.getIdUtente());
		Utente utente = utenteOpt.get();
		if(!utenteOpt.isPresent()) {
			throw new Exception("Utente non trovato");
		}
		Vendita vendita = new Vendita();
		vendita.setImmobile(immobile);
		vendita.setUtente(utente);
		vendita.setPrezzo(immobile.getPrezzo());
		
		venditaRepository.save(vendita);
		immobile.setDisponibile(false);
		immobileRepository.save(immobile);
		
		VenditaDTO responseDto = new VenditaDTO.Builder()
				.idVendita(vendita.getIdVendita())
				.immobile(vendita.getImmobile())
				.utente(vendita.getUtente())
				.prezzo(vendita.getPrezzo())
				.dataCreazione(vendita.getDataCreazione())
				.build();
		return responseDto;
	}
	
	public void cancellaVendita(Long idVendita) throws Exception {
		Optional<Vendita> vendita = venditaRepository.findById(idVendita);
		if(vendita.isPresent()) {
			Immobile immobile = venditaRepository.findById(idVendita).get().getImmobile();
			immobile.setDisponibile(true);
			immobileRepository.save(immobile);
			venditaRepository.deleteById(idVendita);
		} else {
			throw new Exception("Vendita non trovata");
		}
	}
	
	public Optional<VenditaDTO> trovaPerId(Long idVendita) throws Exception {
		Optional<Vendita> venditaOpt = venditaRepository.findById(idVendita);
		if(venditaOpt.isPresent()) {
			Vendita vendita = venditaOpt.get();
			VenditaDTO respondeDto = new VenditaDTO.Builder()
					.idVendita(idVendita)
					.immobile(vendita.getImmobile())
					.utente(vendita.getUtente())
					.prezzo(vendita.getPrezzo())
					.dataCreazione(vendita.getDataCreazione())
					.build();
			return Optional.of(respondeDto);
		}
		else {
			throw new Exception("Vendita non trovata");
		}
	}
}
