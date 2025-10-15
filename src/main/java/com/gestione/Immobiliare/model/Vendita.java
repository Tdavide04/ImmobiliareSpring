package com.gestione.Immobiliare.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendita")
public class Vendita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVendita;

    @ManyToOne
    @JoinColumn(name = "id_immobile", nullable = false)
    private Immobile immobile;

    @ManyToOne
    @JoinColumn(name = "id_utente", nullable = false)
    private Utente utente;

    @Column(name = "prezzo", nullable = false)
    private BigDecimal prezzo;
    
    @Column(name = "data_creazione", nullable = false)
    private LocalDateTime dataCreazione = LocalDateTime.now();

    public Vendita() {
    }

    public Vendita(Immobile immobile, Utente utente, BigDecimal prezzo) {
        this.immobile = immobile;
        this.utente = utente;
        this.prezzo = prezzo;
    }

    public Long getIdVendita() {
        return idVendita;
    }

    public void setIdVendita(Long idVendita) {
        this.idVendita = idVendita;
    }

    public Immobile getImmobile() {
        return immobile;
    }

    public void setImmobile(Immobile immobile) {
        this.immobile = immobile;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public LocalDateTime getDataCreazione() {
        return dataCreazione;
    }

}
