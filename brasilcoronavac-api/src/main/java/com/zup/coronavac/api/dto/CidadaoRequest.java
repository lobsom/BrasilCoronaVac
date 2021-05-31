package com.zup.coronavac.api.dto;


import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.coronavac.domain.model.Cidadao;

/**
 * 
 * @author Marcelo Gomes
 *
 */
public class CidadaoRequest {
	@NotBlank (message="Nome em branco")
	private String nome;
	@NotBlank(message = "CPF em branco")
	@CPF(message = "CPF inválido!")
	private String cpf;
	@NotBlank(message = "E-mail em branco")
	@Email(message = "E-mail inválido!")
	private String email;
	@NotNull(message = "Data inválida!")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataNascimento;
	
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
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
