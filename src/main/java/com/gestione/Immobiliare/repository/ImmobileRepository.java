package com.gestione.Immobiliare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestione.Immobiliare.model.Immobile;

public interface ImmobileRepository extends JpaRepository<Immobile, Long> {
	boolean existByNome(String string);
}
