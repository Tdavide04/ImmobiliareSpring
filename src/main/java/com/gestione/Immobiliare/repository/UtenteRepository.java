package com.gestione.Immobiliare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestione.Immobiliare.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);
	
	Optional<Utente> findByEmailAndPassword(String email, String password);

	Optional<Utente> findByEmail(String email);

}
