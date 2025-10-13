package com.gestione.Immobiliare.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tipologia")
public class Tipologia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipologia")
	private Long idTipologia;

	@Column(name = "nome", nullable = false, unique = true)
	@Size(min = 3, message = "Il nome della categoria deve avere almeno 4 caratteri")
	private String nome;

	@Column(name = "descrizione", length = 255)
	private String descrizione;

	public Tipologia() {
	}

	public Tipologia(Long idTipologia, String nome, String descrizione) {
		this.idTipologia = idTipologia;
		this.nome = nome;
		this.descrizione = descrizione;
	}
	
	public Tipologia(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
	}

	public Long getIdTipologia() {
		return idTipologia;
	}

	public void setIdTipologia(Long idTipologia) {
		this.idTipologia = idTipologia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
