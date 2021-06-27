package com.zup.coronavac.api.dto;

import java.util.Date;
import java.util.List;

import com.zup.coronavac.domain.model.Vacina;
import com.zup.coronavac.domain.model.Vacinacao;

public class VacinaRequest {
	private String nomeVacina;
	private String lote;
	private Date validade;
	private Integer proximaDose;
	
	public Vacina criarVacina() {
		return new Vacina(this.nomeVacina, this.lote, this.validade, this.proximaDose);
	}
	
	
	
	/**
	 * @param nomeVacina
	 * @param lote
	 * @param validade
	 * @param proximaDose
	 */
	public VacinaRequest(String nomeVacina, String lote, Date validade, Integer proximaDose) {
		super();
		this.nomeVacina = nomeVacina;
		this.lote = lote;
		this.validade = validade;
		this.proximaDose = proximaDose;
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
	/**
	 * @return the proximaDose
	 */
	public Integer getProximaDose() {
		return proximaDose;
	}
	/**
	 * @param proximaDose the proximaDose to set
	 */
	public void setProximaDose(Integer proximaDose) {
		this.proximaDose = proximaDose;
	}
	
}
