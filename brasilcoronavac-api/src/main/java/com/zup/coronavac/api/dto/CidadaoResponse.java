package com.zup.coronavac.api.dto;

/**
 * 
 * @author Marcelo Gomes
 *
 */
public class CidadaoResponse {
	private Long id;
	private String nome;
	private String email;
	
	/**
	 * 
	 * @param id
	 * @param nome
	 * @param email
	 */
	public CidadaoResponse(Long id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	/**
	 * Exibir Cidadão
	 * @return CidadaoResponse Instância de Cidadao com os atributos de retorno
	 */
	public CidadaoResponse exibirCidadao() {
		return new CidadaoResponse(this.id, this.nome, this.email);
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


}
