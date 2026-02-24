package com.gestione.Immobiliare.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestione.Immobiliare.dto.ImmobileDTO;
import com.gestione.Immobiliare.exception.ImmobileNotFoundException;
import com.gestione.Immobiliare.model.Immobile;
import com.gestione.Immobiliare.repository.ImmobileRepository;
import com.gestione.Immobiliare.service.IImmobileService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImmobileService implements IImmobileService {

	@Autowired
	private ImmobileRepository immobileRepository;

	@Override
	public ImmobileDTO aggiungiImmobile(ImmobileDTO immobileDto) throws Exception {
		if(immobileRepository.existsByNome(immobileDto.getNome())) {
			throw new Exception("Immobile già esistente");
		}
		Immobile immobile = new Immobile();
		immobile.setNome(immobileDto.getNome());
		immobile.setIndirizzo(immobileDto.getIndirizzo());
		immobile.setCitta(immobileDto.getCitta());
		immobile.setPrezzo(immobileDto.getPrezzo());
		immobile.setSuperficie(immobileDto.getSuperficie());
		immobile.setTipologie(immobileDto.getTipologie());
		immobile.setCategoriaCatastale(immobileDto.getCategoriaCatastale());
		immobile.setDisponibile(immobileDto.getDisponibilita());
		
		immobileRepository.save(immobile);
		
		ImmobileDTO responseDto = new ImmobileDTO.Builder()
				.idImmobile(immobile.getIdImmobile())
				.nome(immobile.getNome())
				.indirizzo(immobile.getIndirizzo())
				.citta(immobile.getCitta())
				.prezzo(immobile.getPrezzo())
				.superficie(immobile.getSuperficie())
				.disponibile(immobile.getDisponibile())
				.tipologie(immobile.getTipologie())
				.categoriaCatastale(immobile.getCategoriaCatastale())
				.build();
		return responseDto;
	}

	@Override
	public ImmobileDTO modificaImmobile(ImmobileDTO immobileDto) throws Exception {
	    Optional<Immobile> originalOpt = trovaPerId(immobileDto.getIdImmobile());

	    if (originalOpt.isPresent()) {
	        Immobile original = originalOpt.get();

	        original.setNome(immobileDto.getNome());
	        original.setIndirizzo(immobileDto.getIndirizzo());
	        original.setCitta(immobileDto.getCitta());
	        original.setPrezzo(immobileDto.getPrezzo());
	        original.setSuperficie(immobileDto.getSuperficie());
	        original.setTipologie(immobileDto.getTipologie());
	        original.setCategoriaCatastale(immobileDto.getCategoriaCatastale());
	        original.setDisponibile(immobileDto.getDisponibilita());

	        Immobile updated = immobileRepository.save(original);

	        return new ImmobileDTO.Builder()
	                .idImmobile(updated.getIdImmobile())
	                .nome(updated.getNome())
	                .indirizzo(updated.getIndirizzo())
	                .citta(updated.getCitta())
	                .prezzo(updated.getPrezzo())
	                .superficie(updated.getSuperficie())
	                .tipologie(updated.getTipologie())
	                .categoriaCatastale(updated.getCategoriaCatastale())
	                .disponibile(updated.getDisponibile())
	                .build();

	    } else {
	        throw new ImmobileNotFoundException("Immobile non presente");
	    }
	}



	@Override
	public void rimuoviImmobile(Long idImmobile) throws Exception {
		Optional<Immobile> immobile = trovaPerId(idImmobile);
		if (immobile.isPresent()) {
		    immobileRepository.deleteById(idImmobile);
		} else {
		    throw new Exception("Immobile non presente");
		}

		
	}

	@Override
	public List<ImmobileDTO> trovaTutti() {
		List<Immobile> list = immobileRepository.findAll();
		List<ImmobileDTO> listDto = new ArrayList<ImmobileDTO>();
		for (Immobile immobile : list) {
			ImmobileDTO immobileDto = new ImmobileDTO.Builder()
					.idImmobile(immobile.getIdImmobile())
					.nome(immobile.getNome())
					.indirizzo(immobile.getIndirizzo())
					.citta(immobile.getCitta())
					.prezzo(immobile.getPrezzo())
					.superficie(immobile.getSuperficie())
					.tipologie(immobile.getTipologie())
					.categoriaCatastale(immobile.getCategoriaCatastale())
					.disponibile(immobile.getDisponibile())
					.build();
			listDto.add(immobileDto);
		}
		return listDto;
	}

	@Override
	public Optional<Immobile> trovaPerId(Long idImmobile) {
		return immobileRepository.findById(idImmobile);
				
	}
	
	
}
