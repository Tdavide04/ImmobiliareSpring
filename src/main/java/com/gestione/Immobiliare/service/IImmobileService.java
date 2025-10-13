package com.gestione.Immobiliare.service;

import java.util.List;
import java.util.Optional;

import com.gestione.Immobiliare.dto.ImmobileDTO;
import com.gestione.Immobiliare.model.Immobile;

public interface IImmobileService {

	ImmobileDTO aggiungiImmobile(ImmobileDTO immobileDto) throws Exception;
	ImmobileDTO modificaImmobile(ImmobileDTO immobileDto) throws Exception;
	void rimuoviImmobile(Long idImmobile) throws Exception;
	List<ImmobileDTO> trovaTutti();
	Optional<Immobile> trovaPerId(Long idImmobile);
}
