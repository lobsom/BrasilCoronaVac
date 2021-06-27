package com.zup.coronavac.api.dto;

import java.sql.Date;

import com.zup.coronavac.domain.model.AplicacaoVacina;

/**
 * 
 * @author Marcelo Gomes
 *
 */
public class AplicacaoVacinaRequest {
	private String vacina;	
	private Date dataVacina;
	
	/**
	 * Instância de AplicacaoVacina que será utilizada para criar o recurso
	 * @return AplicacaoVacina
	 */
	public AplicacaoVacina criarNovaVacina() {
		return new AplicacaoVacina(this.vacina, this.dataVacina);
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
	
	
}
