package com.gestione.Immobiliare.utility;

public class VenditaTemplate {
	private Long idImmobile;
	private Long idUtente;
	public VenditaTemplate(Long idImmobile, Long idUtente) {
		super();
		this.idImmobile = idImmobile;
		this.idUtente = idUtente;
	}
	public Long getIdImmobile() {
		return idImmobile;
	}
	public void setIdImmobile(Long idImmobile) {
		this.idImmobile = idImmobile;
	}
	public Long getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}
	
	
}
