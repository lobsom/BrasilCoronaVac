package com.zup.coronavac.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.coronavac.api.dto.VacinacaoResponse;

/**
 * Entidade Vacinacao
 * @author Marcelo Gomes
 *
 */
@Entity
public class Vacinacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "idCidadaoVacinado")
	private Cidadao cidadao;
	
	@ManyToOne
	@JoinColumn(name = "idVacina")
	private Vacina vacina;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataVacinacao;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date proximaDose;
	
	@Deprecated
	public Vacinacao() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cidadao
	 * @param vacina
	 * @param dataVacinacao
	 * @param proximaDose
	 */
	public Vacinacao(Cidadao cidadao, Vacina vacina, Date dataVacinacao, Date proximaDose) {
		this.cidadao = cidadao;
		this.vacina = vacina;
		this.dataVacinacao = dataVacinacao;
		this.proximaDose = proximaDose;
	}
	
	/**
	 * Construtor utilizado no processo de criação do recurso Vacinacao
	 * @param dataVacinacao - Dia da vacinação
	 */
	public Vacinacao(Date dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
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
	 * @return the vacina
	 */
	public Vacina getVacina() {
		return vacina;
	}

	/**
	 * @param vacina the vacina to set
	 */
	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
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

	/**
	 * Instancia o objeto contendo somente os membros de classe que devem ser exibidos após a criação do recurso Vacinacao no sistema
	 * @return VacinacaoResponse
	 */
	public VacinacaoResponse resposta() {		
		return new VacinacaoResponse(this.id, this.cidadao, this.vacina, this.dataVacinacao, this.proximaDose);
	} 
	
	

	
}
