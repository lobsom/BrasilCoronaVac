package com.zup.coronavac.api.dto;

import java.sql.Date;

import com.zup.coronavac.domain.model.AplicacaoVacina;

/**
 * 
 * @author Marcelo Gomes
 *
 */
public class VacinaRequest {
	private String vacina;	
	private String email;
	private Date dataVacina;
	
	/**
	 * Instância de AplicacaoVacina que será utilizada para criar o recurso
	 * @return AplicacaoVacina
	 */
	public AplicacaoVacina criarNovaVacina() {
		return new AplicacaoVacina(this.vacina, this.email, this.dataVacina);
	}
		
	public String getVacina() {
		return vacina;
	}

	public void setVacina(String vacina) {
		this.vacina = vacina;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataVacina() {
		return dataVacina;
	}

	public void setDataVacina(Date dataVacina) {
		this.dataVacina = dataVacina;
	}
	
	
}
