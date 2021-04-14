package com.zup.coronavac.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.zup.coronavac.api.dto.CidadaoResponse;

@Entity
public class Cidadao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
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
	
	@Deprecated
	public Cidadao() {
		
	}
	
	public Cidadao(@NotBlank(message = "Nome em branco") String nome,
			@NotBlank(message = "CPF em branco") @CPF(message = "CPF inválido!") String cpf,
			@NotBlank(message = "E-mail em branco") @Email(message = "E-mail inválido!") String email,
			@NotBlank(message = "Data inválida!") String dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}



	// Gttrs'n'Sttrs
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
	
	public CidadaoResponse resposta() {
		return new CidadaoResponse(this.id, this.nome, this.email);
	}
	
}
