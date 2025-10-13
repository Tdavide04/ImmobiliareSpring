package com.gestione.Immobiliare.dto;

import com.gestione.Immobiliare.model.Ruolo;

public class UtenteDTO {

	private Long idUtente;
	private String username;
	private String email;
	private String password;
	private Ruolo ruolo;

	public UtenteDTO() {

	}
	private UtenteDTO(Builder builder) {
		this.idUtente = builder.idUtente;
		this.username = builder.username;
		this.email = builder.email;
		this.password = builder.password;
		this.ruolo = builder.ruolo;
	}

	public static class Builder {
		private Long idUtente;
		private String username;
		private String email;
		private String password;
		private Ruolo ruolo;

		public Builder idUtente(Long idUtente) {
			this.idUtente = idUtente;
			return this;
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder ruolo(Ruolo ruolo) {
			this.ruolo = ruolo;
			return this;
		}

		public UtenteDTO build() {
			return new UtenteDTO(this);
		}
	}

	public Long getIdUtente() {
		return idUtente;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

}
