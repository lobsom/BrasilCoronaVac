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

/**
 * Classe Domain/Model (Negócio e Entidade). Retorna uma lista de Cidadãos <p>
 * More description if needed.  <p>
 * Possible use of HTML paragraph breaks. <p>
 * Possible use on in-line tags  <p>
 * First block tag ends description section.
 *
 * @author Marcelo Gomes
 * @version 1.0
 * @see <a href="http://docs.oracle.com/javase/7/docs/technotes/tools/windows/javadoc.html">javadocs documentation</a>
 * @see <a href="https://en.wikipedia.org/wiki/Javadoc">javadocs at Wikipedia</a>
 * @see <a href="http://docs.oracle.com/javase/tutorial/java/package/index.html">package documentation</a>
 */

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

	/**
	 * Construtor não mais utilizado por conta de alguma coisa que ainda não sei... <br>
	 * Perguntar ao Luís
	 * */
	@Deprecated 
	public Cidadao() {
		
	}
	
	/**
	 * 
	 * @param nome Nome do cidadão
	 * @param cpf Documento de identificação do cidadão
	 * @param email Email do cidadão
	 * @param dataNascimento Data de nascimento do cidadão
	 */
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
	/**
	 * Método para obter o id. Identificador único do cidadão.
	 * @return Long - Identificador único do registro no BD
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Método void para settar id. Não deve ser utilizado pois o valor é gerado automaticamente na criação do recurso.
	 * @param id - Long. Criado automaticamente
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return String Nome do cidaão. 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @param nome String. Setter nome do cidadão.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @return String CPF do cidadão.
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * 
	 * @param cpf String. Setter do CPF do cidadão.
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * 
	 * @return String email do cidadão
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email String. Setter do email do cidadão.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return String Data de nascimento do cidadão.
	 */
	public String getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * 
	 * @param dataNascimento String. Setter da data de nascimento do cidadão.
	 */
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	/**
	 * Retorno do objeto contendo id, nome e email do cidadao consultado
	 * @return CidadadoResponse 
	 */
	public CidadaoResponse resposta() {
		return new CidadaoResponse(this.id, this.nome, this.email);
	}
	
}
