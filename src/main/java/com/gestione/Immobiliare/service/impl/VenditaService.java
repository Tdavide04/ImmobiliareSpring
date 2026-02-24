package com.gestione.Immobiliare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.gestione.Immobiliare.dto.VenditaDTO;
import com.gestione.Immobiliare.model.Immobile;
import com.gestione.Immobiliare.model.Utente;
import com.gestione.Immobiliare.model.Vendita;
import com.gestione.Immobiliare.repository.ImmobileRepository;
import com.gestione.Immobiliare.repository.UtenteRepository;
import com.gestione.Immobiliare.repository.VenditaRepository;
import com.gestione.Immobiliare.service.IVenditaService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VenditaService implements IVenditaService {

    @Autowired
    private VenditaRepository venditaRepository;
    @Autowired
    private ImmobileRepository immobileRepository;
    @Autowired
    private UtenteRepository utenteRepository;

    public VenditaDTO effettuaVendita(String nomeImmobile) throws Exception {

        Immobile immobile = immobileRepository.findByNome(nomeImmobile)
                .orElseThrow(() -> new Exception("Immobile non trovato"));

        if (!Boolean.TRUE.equals(immobile.getDisponibile())) {
            throw new Exception("Immobile non disponibile");
        }

        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new Exception("Utente non autenticato");
        }

        String email = auth.getName();
        Utente utente = utenteRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("Utente non trovato"));

        Vendita vendita = new Vendita();
        vendita.setImmobile(immobile);
        vendita.setUtente(utente);
        vendita.setPrezzo(immobile.getPrezzo());

        vendita = venditaRepository.save(vendita);

        // con @Transactional non serve immobileRepository.save(...)
        immobile.setDisponibile(false);

        return mapToDto(vendita);
    }

    public void cancellaVendita(Long idVendita) throws Exception {

        Vendita vendita = venditaRepository.findById(idVendita)
                .orElseThrow(() -> new Exception("Vendita non trovata"));

        vendita.getImmobile().setDisponibile(true);
        venditaRepository.delete(vendita);
        // con @Transactional non serve immobileRepository.save(...)
    }

    public VenditaDTO trovaPerId(Long idVendita) throws Exception {

        Vendita vendita = venditaRepository.findById(idVendita)
                .orElseThrow(() -> new Exception("Vendita non trovata"));

        return mapToDto(vendita);
    }

    private VenditaDTO mapToDto(Vendita vendita) {
        return new VenditaDTO.Builder()
                .idVendita(vendita.getIdVendita())
                .immobileId(vendita.getImmobile().getIdImmobile())
                .immobileNome(vendita.getImmobile().getNome())
                .utenteId(vendita.getUtente().getIdUtente())
                .utenteUsername(vendita.getUtente().getUsername())
                .utenteEmail(vendita.getUtente().getEmail())
                .prezzo(vendita.getPrezzo())
                .dataCreazione(vendita.getDataCreazione())
                .build();
    }
}