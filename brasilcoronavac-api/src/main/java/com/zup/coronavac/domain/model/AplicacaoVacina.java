package com.zup.coronavac.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class AplicacaoVacina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@NotBlank (message="Vacina em branco")
	private String vacina;
		
	@NotBlank(message = "E-mail em branco")
	@Email(message = "E-mail inválido!")
	private String email;
	
	@NotBlank(message = "Data inválida!")
	private String dataVacina;


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

	public String getDataVacina() {
		return dataVacina;
	}

	public void setDataVacina(String dataVacina) {
		this.dataVacina = dataVacina;
	}
	
}

