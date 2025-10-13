package com.gestione.Immobiliare.service;

import java.util.List;
import java.util.Optional;

import com.gestione.Immobiliare.dto.UtenteDTO;

public interface IUtenteService {

	UtenteDTO registraUtente(UtenteDTO utenteDto) throws Exception;

	Optional<UtenteDTO> trovaPerId(Long id);
	Optional<UtenteDTO> trovaLogin(String email, String password);

	//Optional<UtenteDTO> trovaPerUsername(String username);

	List<UtenteDTO> trovaTutti();

	boolean esisteUsername(String username);

	boolean esisteEmail(String email);

}
