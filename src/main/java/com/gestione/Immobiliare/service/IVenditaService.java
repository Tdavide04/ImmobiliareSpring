package com.gestione.Immobiliare.service;

import java.util.Optional;

import com.gestione.Immobiliare.dto.VenditaDTO;
import com.gestione.Immobiliare.utility.VenditaTemplate;

public interface IVenditaService {

	public VenditaDTO effettuaVendita(String nomeimmobile) throws Exception;
	public void cancellaVendita(Long idVendita) throws Exception;
	public VenditaDTO trovaPerId(Long idVendita) throws Exception;
}
