package com.zup.coronavac.api.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.zup.coronavac.domain.model.Cidadao;

public class CidadaoRequest {
	
	@NotBlank (message="Nome em branco")
	private String nome;
	@NotBlank(message = "CPF em branco")
	@CPF(message = "CPF inválido!")
	private String cpf;
	@NotBlank(message = "E-mail em branco")
	@Email(message = "E-mail inválido!")
	private String email;
	@NotBlank(message = "Data inválida!")
	private String dataNascimento;
	
	public Cidadao criarNovoCidadao() {
		return new Cidadao(this.nome, this.cpf, this.email, this.dataNascimento);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
