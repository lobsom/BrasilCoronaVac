package com.zup.coronavac.api.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.zup.coronavac.domain.model.Vacinacao;

public class VacinaResponseAllData {
	private Long id;
	private String nomeVacina;
	private String lote;
	private Date validade;
	private Integer proximaDose;
	/**
	 * @param id
	 * @param nomeVacina
	 * @param lote
	 * @param validade
	 * @param proximaDose
	 */
	public VacinaResponseAllData(Long id, String nomeVacina, String lote, Date validade, Integer proximaDose) {
		super();
		this.id = id;
		this.nomeVacina = nomeVacina;
		this.lote = lote;
		this.validade = validade;
		this.proximaDose = proximaDose;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
