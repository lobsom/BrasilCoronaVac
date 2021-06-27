package com.zup.coronavac.api.dto;

import java.util.Date;

import com.zup.coronavac.domain.model.Cidadao;
import com.zup.coronavac.domain.model.Vacina;

public class VacinacaoRequest {
	private Date dataVacinacao;
	private Date proximaDose;
	/**
	 * @param dataVacinacao
	 * @param proximaDose
	 */
	public VacinacaoRequest(Date dataVacinacao, Date proximaDose) {
		super();
		this.dataVacinacao = dataVacinacao;
		this.proximaDose = proximaDose;
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
