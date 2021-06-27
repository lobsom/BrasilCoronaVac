package com.zup.coronavac.api.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.zup.coronavac.domain.model.Vacinacao;

public class VacinaResponse {
	private String nomeVacina;
	private String lote;
	private Date validade;
	/**
	 * @param nomeVacina
	 * @param lote
	 * @param validade
	 */
	public VacinaResponse(String nomeVacina, String lote, Date validade) {
		this.nomeVacina = nomeVacina;
		this.lote = lote;
		this.validade = validade;
	}
	/**
	 * @return the nomeVacina
	 */
	public String getNomeVacina() {
		return nomeVacina;
	}
	/**
	 * @param nomeVacina the nomeVacina to set
	 */
	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}
	/**
	 * @return the lote
	 */
	public String getLote() {
		return lote;
	}
	/**
	 * @param lote the lote to set
	 */
	public void setLote(String lote) {
		this.lote = lote;
	}
	/**
	 * @return the validade
	 */
	public Date getValidade() {
		return validade;
	}
	/**
	 * @param validade the validade to set
	 */
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	
	

}
