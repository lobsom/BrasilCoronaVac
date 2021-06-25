package com.zup.coronavac.api.dto;

import java.util.List;

import com.zup.coronavac.domain.model.AplicacaoVacina;

/**
 * 
 * @author Marcelo Gomes
 *
 */
public class CidadaoResponse {
	private Long id;
	private String nome;
	private String email;
	private List<AplicacaoVacina> vacinas;
	
	/**
	 * 
	 * @param id
	 * @param nome
	 * @param email
	 */
	public CidadaoResponse(Long id, String nome, String email, List<AplicacaoVacina> vacinas) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.vacinas= vacinas;
	}
	
	/**
	 * Exibir Cidadão
	 * @return CidadaoResponse Instância de Cidadao com os atributos de retorno
	 */
	public CidadaoResponse exibirCidadao() {
		return new CidadaoResponse(this.id, this.nome, this.email, this.vacinas);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the vacinas
	 */
	public List<AplicacaoVacina> getVacinas() {
		return vacinas;
	}

	/**
	 * @param vacinas the vacinas to set
	 */
	public void setVacinas(List<AplicacaoVacina> vacinas) {
		this.vacinas = vacinas;
	}


}
