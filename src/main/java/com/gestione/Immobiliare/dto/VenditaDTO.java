package com.gestione.Immobiliare.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.gestione.Immobiliare.model.Immobile;
import com.gestione.Immobiliare.model.Utente;

public class VenditaDTO {

    private Long idVendita;
    private Immobile immobile;
    private Utente utente;
    private BigDecimal prezzo;
    private LocalDateTime dataCreazione;

    public VenditaDTO() {
    }

    private VenditaDTO(Builder builder) {
        this.idVendita = builder.idVendita;
        this.immobile = builder.immobile;
        this.utente = builder.utente;
        this.prezzo = builder.prezzo;
        this.dataCreazione = builder.dataCreazione;
    }

    public Long getIdVendita() {
        return idVendita;
    }

    public Immobile getImmobile() {
        return immobile;
    }

    public Utente getUtente() {
        return utente;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public LocalDateTime getDataCreazione() {
        return dataCreazione;
    }

    public static class Builder {
        private Long idVendita;
        private Immobile immobile;
        private Utente utente;
        private BigDecimal prezzo;
        private LocalDateTime dataCreazione;

        public Builder idVendita(Long idVendita) {
            this.idVendita = idVendita;
            return this;
        }

        public Builder immobile(Immobile immobile) {
            this.immobile = immobile;
            return this;
        }

        public Builder utente(Utente utente) {
            this.utente = utente;
            return this;
        }

        public Builder prezzo(BigDecimal prezzo) {
            this.prezzo = prezzo;
            return this;
        }

        public Builder dataCreazione(LocalDateTime dataCreazione) {
            this.dataCreazione = dataCreazione;
            return this;
        }

        public VenditaDTO build() {
            return new VenditaDTO(this);
        }
    }
}
