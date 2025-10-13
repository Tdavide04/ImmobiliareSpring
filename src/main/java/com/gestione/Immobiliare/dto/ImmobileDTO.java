package com.gestione.Immobiliare.dto;

import java.math.BigDecimal;
import java.util.List;

import com.gestione.Immobiliare.model.CategoriaCatastale;
import com.gestione.Immobiliare.model.Tipologia;

public class ImmobileDTO {

	private Long idImmobile;
	private String nome;
	private String indirizzo;
	private String citta;
	private BigDecimal prezzo;
	private Integer superficie;
	private Boolean disponibile;
	private List<Tipologia> tipologie;
	private CategoriaCatastale categoriaCatastale;
	
	public ImmobileDTO() {
		
	}
	private ImmobileDTO(Builder builder) {
		this.idImmobile = builder.idImmobile;
	    this.nome = builder.nome;
	    this.indirizzo = builder.indirizzo;
	    this.citta = builder.citta;
	    this.prezzo = builder.prezzo;
	    this.superficie = builder.superficie;
	    this.disponibile = builder.disponibile;
	    this.tipologie = builder.tipologie;
	    this.categoriaCatastale = builder.categoriaCatastale;
	}
	public static class Builder {
		private Long idImmobile;
		private String nome;
		private String indirizzo;
		private String citta;
		private BigDecimal prezzo;
		private Integer superficie;
		private Boolean disponibile;
		private List<Tipologia> tipologie;
		private CategoriaCatastale categoriaCatastale;
		public Builder idImmobile(Long idImmobile) {
            this.idImmobile = idImmobile;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder indirizzo(String indirizzo) {
            this.indirizzo = indirizzo;
            return this;
        }

        public Builder citta(String citta) {
            this.citta = citta;
            return this;
        }

        public Builder prezzo(BigDecimal prezzo) {
            this.prezzo = prezzo;
            return this;
        }

        public Builder superficie(Integer superficie) {
            this.superficie = superficie;
            return this;
        }
        
        public Builder disponibile(Boolean disponibile) {
        	this.disponibile = disponibile;
        	return this;
        }

        public Builder tipologie(List<Tipologia> tipologie) {
            this.tipologie = tipologie;
            return this;
        }

        public Builder categoriaCatastale(CategoriaCatastale categoriaCatastale) {
            this.categoriaCatastale = categoriaCatastale;
            return this;
        }

        public ImmobileDTO build() {
            return new ImmobileDTO(this);
        }
	}
	public Long getIdImmobile() {
		return idImmobile;
	}
	public void setIdImmobile(Long idImmobile) {
		this.idImmobile = idImmobile;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public BigDecimal getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	public Integer getSuperficie() {
		return superficie;
	}
	public void setSuperficie(Integer superficie) {
		this.superficie = superficie;
	}
	
	public Boolean getDisponibilita() {
		return disponibile;
	}
	public void setDisponibilita(Boolean disponibile) {
		this.disponibile = disponibile;
	}
	
	public List<Tipologia> getTipologie() {
		return tipologie;
	}
	public void setTipologie(List<Tipologia> tipologie) {
		this.tipologie = tipologie;
	}
	public CategoriaCatastale getCategoriaCatastale() {
		return categoriaCatastale;
	}
	public void setCategoriaCatastale(CategoriaCatastale categoriaCatastale) {
		this.categoriaCatastale = categoriaCatastale;
	}
	
}
