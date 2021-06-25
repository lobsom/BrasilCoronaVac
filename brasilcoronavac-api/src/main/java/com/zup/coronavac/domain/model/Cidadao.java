package com.zup.coronavac.domain.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@JsonIgnore
	private String cpf;
	
	@NotBlank(message = "E-mail em branco")
	@Email(message = "E-mail inválido!")
	private String email;
	
	//@NotNull(message = "Data inválida!")
	private Date dataNascimento;
	
	@OneToMany
	@JoinColumn(name = "idCidadao")
	@JsonIgnore
	private List<AplicacaoVacina> vacinas;

	/**
	 * Construtor não mais utilizado por conta de alguma coisa que ainda não sei... <br>
	 * Perguntar ao Luís
	 * */
	@Deprecated 
	public Cidadao() {}
	
	/**
	 * 
	 * @param nome Nome do cidadão
	 * @param cpf Documento de identificação do cidadão
	 * @param email Email do cidadão
	 * @param dataNascimento Data de nascimento do cidadão
	 */
	public Cidadao(String nome,
			String cpf,
			String email,
			Date dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}
	
	public Cidadao(Long id) {
		this.id = id;
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
	 * @return Date Data de nascimento do cidadão.
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * 
	 * @param dataNascimento Date. Setter da data de nascimento do cidadão.
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	/**
	 * Retorno do objeto contendo id, nome e email do cidadao consultado
	 * @return CidadadoResponse 
	 */
	public CidadaoResponse resposta() {
		return new CidadaoResponse(this.id, this.nome, this.email);
	}
	
}
