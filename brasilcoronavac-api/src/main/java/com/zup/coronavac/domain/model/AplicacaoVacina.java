package com.zup.coronavac.domain.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.zup.coronavac.api.dto.VacinaResponse;

/**
 * 
 * @author Marcelo Gomes
 *
 */
@Entity
public class AplicacaoVacina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@NotBlank (message="Vacina em branco")
	private String vacina;
	
	//@NotBlank(message = "Data inválida!")
	private Date dataVacina;

	@ManyToOne
	@JoinColumn(name = "idCidadao") 
	private Cidadao cidadao;
	

	@Deprecated
	public AplicacaoVacina() {}

	
	/**
	 * @param vacina
	 * @param dataVacina
	 */
	public AplicacaoVacina(
			String vacina,
			Date dataVacina) {
		this.vacina = vacina;
		this.dataVacina = dataVacina;
	}


	/**
	 * 
	 * @return
	 */
	public String getVacina() {
		return vacina;
	}

	/**
	 * 
	 * @param vacina
	 */
	public void setVacina(String vacina) {
		this.vacina = vacina;
	}

	/**
	 * 
	 * @return
	 */
	public Date getDataVacina() {
		return dataVacina;
	}

	/**
	 * 
	 * @param dataVacina
	 */
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


	/**
	 * Instância de VacinaResponse com os membros que devem ser exibidos na resposta
	 * @return VacinaResponse
	 */
	public VacinaResponse resposta() {
		
		return new VacinaResponse(this.vacina, this.dataVacina, this.cidadao);
	}

	
}

