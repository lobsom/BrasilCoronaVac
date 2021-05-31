package com.zup.coronavac.api.dto;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.zup.coronavac.domain.model.AplicacaoVacina;
import com.zup.coronavac.domain.model.Cidadao;

public class VacinaRequest {
	@NotBlank (message="Vacina em branco")
	private String vacina;
		
	@NotBlank(message = "E-mail em branco")
	@Email(message = "E-mail inválido!")
	private String email;
	private Date dataVacina;
	private Cidadao cidadao;
	
	/**
	 * Instância de AplicacaoVacina que será utilizada para criar o recurso
	 * @return AplicacaoVacina
	 */
	public AplicacaoVacina criarNovaVacina() {
		return new AplicacaoVacina(this.vacina, this.email, this.dataVacina, this.cidadao);
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
