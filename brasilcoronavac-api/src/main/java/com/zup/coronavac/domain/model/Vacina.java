package com.zup.coronavac.domain.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zup.coronavac.api.dto.VacinaResponse;
import com.zup.coronavac.api.dto.VacinaResponseAllData;

/**
 * Entidade Vacina
 * @author Marcelo Gomes
 *
 */
@Entity
public class Vacina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVacina", updatable = false, nullable = false)
	private Long id;
	
	private String nomeVacina;
	private String lote;
	private Date validade;
	private Integer proximaDose;
	
	@OneToMany
	@JoinColumn(name = "idVacina")
	@JsonIgnore
	List<Vacinacao> vacinasAplicadas;

	/**
	 * 
	 */
	@Deprecated
	public Vacina() {
	}

	/**
	 * @param nomeVacina
	 * @param lote
	 * @param validade
	 * @param proximaDose
	 * @param vacinasAplicadas
	 */
	public Vacina(String nomeVacina, String lote, Date validade, Integer proximaDose) {
		super();
		this.nomeVacina = nomeVacina;
		this.lote = lote;
		this.validade = validade;
		this.proximaDose = proximaDose;
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
	private void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nomeVacina
	 */
	public String getNomeVacina() {
		return nomeVacina;
	}

	/**
	 * @param nomeVacina the nomeVacina to set
	 */
	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	/**
	 * @return the lote
	 */
	public String getLote() {
		return lote;
	}

	/**
	 * @param lote the lote to set
	 */
	public void setLote(String lote) {
		this.lote = lote;
	}

	/**
	 * @return the validade
	 */
	public Date getValidade() {
		return validade;
	}

	/**
	 * @param validade the validade to set
	 */
	public void setValidade(Date validade) {
		this.validade = validade;
	}

	/**
	 * @return the proximaDose
	 */
	public Integer getProximaDose() {
		return proximaDose;
	}

	/**
	 * @param proximaDose the proximaDose to set
	 */
	public void setProximaDose(Integer proximaDose) {
		this.proximaDose = proximaDose;
	}

	/**
	 * @return the vacinasAplicadas
	 */
	public List<Vacinacao> getVacinasAplicadas() {
		return vacinasAplicadas;
	}

	/**
	 * @param vacinasAplicadas the vacinasAplicadas to set
	 */
	public void setVacinasAplicadas(List<Vacinacao> vacinasAplicadas) {
		this.vacinasAplicadas = vacinasAplicadas;
	}

	public VacinaResponse resposta() {
		return new VacinaResponse(this.nomeVacina, this.lote, this.validade, this.proximaDose);
	}

	public VacinaResponseAllData respostaAllData() {
		return new VacinaResponseAllData(this.id, this.nomeVacina, this.lote, this.validade, this.proximaDose);
	}

	
	
}
