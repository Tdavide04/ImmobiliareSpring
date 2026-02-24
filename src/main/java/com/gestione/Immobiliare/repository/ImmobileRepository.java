package com.gestione.Immobiliare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestione.Immobiliare.model.Immobile;
import com.gestione.Immobiliare.model.Utente;

public interface ImmobileRepository extends JpaRepository<Immobile, Long> {
	boolean existsByNome(String string);

	Optional<Immobile> findByNome(String nomeImmobile);
}
