package com.gestione.Immobiliare.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestione.Immobiliare.dto.UtenteDTO;
import com.gestione.Immobiliare.model.Ruolo;
import com.gestione.Immobiliare.model.Utente;
import com.gestione.Immobiliare.repository.UtenteRepository;
import com.gestione.Immobiliare.service.IUtenteService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UtenteService implements IUtenteService{
	
	@Autowired
	private UtenteRepository utenteRepository;
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public UtenteDTO registraUtente(UtenteDTO utenteDto) throws Exception {
		if (utenteRepository.existsByUsername(utenteDto.getUsername())) {
			throw new Exception("Username già in uso");
		}
		if (utenteRepository.existsByEmail(utenteDto.getEmail())) {
			throw new Exception("Email già in uso");
		}
		Utente utente = new Utente();
		utente.setUsername(utenteDto.getUsername());
        utente.setEmail(utenteDto.getEmail());
        utente.setPassword(passwordEncoder.encode(utenteDto.getPassword()));
        utente.setRuolo(utenteDto.getRuolo() != null ? utenteDto.getRuolo() : Ruolo.CLIENT);
        
		utenteRepository.save(utente);
		
		UtenteDTO responseDTO = new UtenteDTO.Builder()
                .idUtente(utente.getIdUtente())
                .username(utente.getUsername())
                .email(utente.getEmail())
                .ruolo(utente.getRuolo())
                .build();
		return responseDTO;
	}

	/**
	 * Finds a user by ID in the database and, if present, converts it to a UtenteDTO.
	 *
	 * This method leverages the functional behavior of Optional:
	 * - utenteRepository.findById(id) returns an Optional<Utente>
	 * - if the user exists, the map() function is executed to build a UtenteDTO
	 * - if the user does not exist, map() is skipped and Optional.empty() is returned
	 *
	 * This approach avoids manual null checks and clearly communicates
	 * the possible absence of a user through the Optional type.
	 */
	@Override
	public Optional<UtenteDTO> trovaPerId(Long id) {
	    return utenteRepository.findById(id)
	        .map(utente -> new UtenteDTO.Builder() 
	                .idUtente(utente.getIdUtente())
	                .username(utente.getUsername())
	                .email(utente.getEmail())
	                .ruolo(utente.getRuolo())
	                .build()
	        );
	}
	
	@Override
	/**
	 * Finds a user by email and password and, if present, converts it to a UtenteDTO.
	 *
	 * This method relies on an Optional returned by utenteRepository.findLogin():
	 * - If the user exists, map() converts the Utente entity to a UtenteDTO.
	 * - If the user does not exist, map() is skipped and Optional.empty() is returned.
	 *
	 */
	public Optional<UtenteDTO> trovaLogin(String email, String password) {
	    Optional<Utente> utenteOpt = utenteRepository.findByEmail(email);
	    if(utenteOpt.isPresent()) {
	    	Utente utente = utenteOpt.get();
	    	if(passwordEncoder.matches(password, utente.getPassword())) {
	    		 UtenteDTO utenteDto = new UtenteDTO.Builder()
	    				 .idUtente(utente.getIdUtente())
	                     .username(utente.getUsername())
	                     .email(utente.getEmail())
	                     .ruolo(utente.getRuolo())
	                     .build();
	             return Optional.of(utenteDto);
	    	}
	    }
	    return Optional.empty();
	}


	/*
	 * @Override public Optional<UtenteDTO> trovaPerUsername(String username) { //
	 * TODO Auto-generated method stub return Optional.empty(); }
	 */

	@Override
	public List<UtenteDTO> trovaTutti() {
		List<Utente> list = utenteRepository.findAll();
		List<UtenteDTO> listDto = new ArrayList<UtenteDTO>();
		for (Utente utente : list) {
			UtenteDTO responseDTO = new UtenteDTO.Builder()
	                .idUtente(utente.getIdUtente())
	                .username(utente.getUsername())
	                .email(utente.getEmail())
	                .ruolo(utente.getRuolo())
	                .build();
			listDto.add(responseDTO);
		}
		return listDto;
	}

	@Override
	public boolean esisteUsername(String username) {
		return utenteRepository.existsByUsername(username);
	}

	@Override
	public boolean esisteEmail(String email) {
		return utenteRepository.existsByEmail(email);
	}

}
