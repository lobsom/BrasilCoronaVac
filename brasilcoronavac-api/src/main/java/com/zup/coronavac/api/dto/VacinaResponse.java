package com.zup.coronavac.api.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

import com.zup.coronavac.domain.model.Cidadao;

public class VacinaResponse {
	@NotBlank (message="Vacina em branco")
	private String vacina;
	private Date dataVacina;
	private Cidadao cidadao;
	/**
	 * @param vacina
	 * @param dataVacina
	 */
	public VacinaResponse(String vacina, Date dataVacina, Cidadao cidadao) {
		this.vacina = vacina;
		this.dataVacina = dataVacina;
		this.cidadao = cidadao;
	}
	
	/**
	 * Exibir Vacina
	 * @return VacinaResponse Instância de AplicacaoVacina com os atributos de retorno
	 */
	public VacinaResponse exibirVacina() {
		return new VacinaResponse(this.vacina, this.dataVacina, this.cidadao);
	}
	
	
	public String getVacina() {
		return vacina;
	}
	public void setVacina(String vacina) {
		this.vacina = vacina;
	}
	public Date getDataVacina() {
		return dataVacina;
	}
	public void setDataVacina(Date dataVacina) {
		this.dataVacina = dataVacina;
	}

	/**
	 * @return the cidadao
	 */
	public Cidadao getCidadao() {
		return cidadao;
	}

	/**
	 * @param cidadao the cidadao to set
	 */
	public void setCidadao(Cidadao cidadao) {
		this.cidadao = cidadao;
	}

}

