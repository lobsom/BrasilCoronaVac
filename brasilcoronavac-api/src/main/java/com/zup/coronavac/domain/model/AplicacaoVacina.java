package com.zup.coronavac.domain.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
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
	@JoinColumn(nullable = false, 
		name = "idCidadao", 
		updatable = false, 
		insertable = false,
		referencedColumnName = "id") //unique = false <- esse atributo não é necessário porque o default é falso
	private Cidadao cidadao;
	

	@Deprecated
	public AplicacaoVacina() {}

	
	/**
	 * @param vacina
	 * @param email
	 * @param dataVacina
	 * @param cidadao
	 */
	public AplicacaoVacina(@NotBlank(message = "Vacina em branco") String vacina,
			@NotBlank(message = "E-mail em branco") @Email(message = "E-mail inválido!") String email, Date dataVacina,
			Cidadao cidadao) {
		super();
		this.vacina = vacina;
		this.dataVacina = dataVacina;
		this.cidadao = cidadao;
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

	public Cidadao getCidadao() {
		return cidadao;
	}

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

