package com.zup.coronavac.api.dto;

import java.util.List;

import com.zup.coronavac.domain.model.Vacinacao;

/**
 * 
 * @author Marcelo Gomes
 *
 */
public class CidadaoResponse {
	private Long id;
	private String nome;
	private String email;
	private List<Vacinacao> vacinasRecebidas;
	
	/**
	 * 
	 * @param id
	 * @param nome
	 * @param email
	 */
	public CidadaoResponse(Long id, String nome, String email, List<Vacinacao> vacinasRecebidas) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.vacinasRecebidas = vacinasRecebidas;
	}
	
	/**
	 * Exibir Cidadão
	 * @return CidadaoResponse Instância de Cidadao com os atributos de retorno
	 */
	public CidadaoResponse exibirCidadao() {
		return new CidadaoResponse(this.id, this.nome, this.email, this.vacinasRecebidas);
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the vacinasRecebidas
	 */
	public List<Vacinacao> getVacinasRecebidas() {
		return vacinasRecebidas;
	}

	/**
	 * @param vacinasRecebidas the vacinasRecebidas to set
	 */
	public void setVacinasRecebidas(List<Vacinacao> vacinasRecebidas) {
		this.vacinasRecebidas = vacinasRecebidas;
	}
	



}
