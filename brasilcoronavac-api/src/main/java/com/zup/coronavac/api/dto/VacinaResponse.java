package com.zup.coronavac.api.dto;

import java.util.Date;

/**
 * 
 * @author Marcelo Gomes
 *
 */
public class VacinaResponse {
	private String nomeVacina;
	private String lote;
	private Date validade;
	private Integer proximaDose;

	/**
	 * @param nomeVacina String - Nome da vacina/fabricante
	 * @param lote String - Lote de produção da vacina
	 * @param validade Date - Data de validade da vacina
	 * @param proximaDose Integer - Número de dias entre a primeira e segunda dose das vacinas
	 */
	public VacinaResponse(String nomeVacina, String lote, Date validade, Integer proximaDose) {
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
