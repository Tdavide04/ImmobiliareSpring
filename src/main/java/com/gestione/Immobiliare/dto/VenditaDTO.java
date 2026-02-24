package com.gestione.Immobiliare.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VenditaDTO {

    private Long idVendita;

    private Long immobileId;
    private String immobileNome;

    private Long utenteId;
    private String utenteUsername;
    private String utenteEmail;

    private BigDecimal prezzo;
    private LocalDateTime dataCreazione;

    public VenditaDTO() {}

    private VenditaDTO(Builder builder) {
        this.idVendita = builder.idVendita;

        this.immobileId = builder.immobileId;
        this.immobileNome = builder.immobileNome;

        this.utenteId = builder.utenteId;
        this.utenteUsername = builder.utenteUsername;
        this.utenteEmail = builder.utenteEmail;
        
        this.prezzo = builder.prezzo;
        this.dataCreazione = builder.dataCreazione;
    }

    public Long getIdVendita() { return idVendita; }
    public Long getImmobileId() { return immobileId; }
    public String getImmobileNome() { return immobileNome; }

    public Long getUtenteId() { return utenteId; }
    public String getUtenteUsername() { return utenteUsername; }
    public String getUtenteEmail() { return utenteEmail; }

    public BigDecimal getPrezzo() { return prezzo; }
    public LocalDateTime getDataCreazione() { return dataCreazione; }

    public static class Builder {
        private Long idVendita;

        private Long immobileId;
        private String immobileNome;

        private Long utenteId;
        private String utenteUsername;
        private String utenteEmail;

        private BigDecimal prezzo;
        private LocalDateTime dataCreazione;

        public Builder idVendita(Long idVendita) {
            this.idVendita = idVendita;
            return this;
        }

        public Builder immobileId(Long immobileId) {
            this.immobileId = immobileId;
            return this;
        }

        public Builder immobileNome(String immobileNome) {
            this.immobileNome = immobileNome;
            return this;
        }

        public Builder utenteId(Long utenteId) {
            this.utenteId = utenteId;
            return this;
        }

        public Builder utenteUsername(String utenteUsername) {
            this.utenteUsername = utenteUsername;
            return this;
        }

        public Builder utenteEmail(String utenteEmail) {
            this.utenteEmail = utenteEmail;
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