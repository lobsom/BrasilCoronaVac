package com.zup.coronavac.api.dto;

import java.util.Date;

import com.zup.coronavac.domain.model.Vacinacao;

public class VacinacaoRequest {
	private Long id;
	private Date dataVacinacao;
	private Date proximaDose;
	/**
	 * @param dataVacinacao
	 * @param proximaDose
	 */
	public VacinacaoRequest(Long id, Date dataVacinacao, Date proximaDose) {
		this.id = id;
		this.dataVacinacao = dataVacinacao;
		this.proximaDose = proximaDose;
	}
	
	/**
	 * Instancia um objeto do tipo Vacinacao para ser utilizado no processo de criação do recurso
	 * @return Vacinacao
	 */
	public Vacinacao criarVacinacao() {
		return new Vacinacao(this.dataVacinacao);
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
	 * @return the dataVacinacao
	 */
	public Date getDataVacinacao() {
		return dataVacinacao;
	}
	/**
	 * @param dataVacinacao the dataVacinacao to set
	 */
	public void setDataVacinacao(Date dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}
	/**
	 * @return the proximaDose
	 */
	public Date getProximaDose() {
		return proximaDose;
	}
	/**
	 * @param proximaDose the proximaDose to set
	 */
	public void setProximaDose(Date proximaDose) {
		this.proximaDose = proximaDose;
	}

	
	
}
