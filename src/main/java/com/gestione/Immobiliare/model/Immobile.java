package com.gestione.Immobiliare.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "immobile")
public class Immobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_immobile")
    private Long idImmobile;

    @Column(name = "nome", nullable = false, unique = true, length = 255)
    private String nome;

    @Column(name = "indirizzo", nullable = false, length = 255)
    private String indirizzo;

    @Column(name = "citta", nullable = false, length = 100)
    private String citta;

    @Column(name = "prezzo", nullable = false, precision = 10, scale = 2)
    private BigDecimal prezzo;

    @Column(name = "superficie", nullable = false)
    private Integer superficie;
    
    @Column(name = "disponibile", nullable = false)
    private Boolean disponibile = true;

    @ElementCollection(targetClass = Tipologia.class)
    @CollectionTable(
        name = "immobile_tipologie",
        joinColumns = @JoinColumn(name = "id_immobile")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "tipologia")
    private List<Tipologia> tipologie = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria_catastale", nullable = false, length = 10)
    private CategoriaCatastale categoriaCatastale;

    public Immobile() {
    }

    public Immobile(String nome, String indirizzo, String citta, BigDecimal prezzo, Integer superficie,
                    List<Tipologia> tipologie, CategoriaCatastale categoriaCatastale) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.prezzo = prezzo;
        this.superficie = superficie;
        this.tipologie = tipologie != null ? tipologie : new ArrayList<>();
        this.categoriaCatastale = categoriaCatastale;
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

    public List<Tipologia> getTipologie() {
        return tipologie;
    }

    public void setTipologie(List<Tipologia> tipologie) {
        this.tipologie = tipologie != null ? tipologie : new ArrayList<>();
    }

    public CategoriaCatastale getCategoriaCatastale() {
        return categoriaCatastale;
    }

    public void setCategoriaCatastale(CategoriaCatastale categoriaCatastale) {
        this.categoriaCatastale = categoriaCatastale;
    }

	public Boolean getDisponibile() {
		return disponibile;
	}

	public void setDisponibile(Boolean disponibile) {
		this.disponibile = disponibile;
	}
    
}
