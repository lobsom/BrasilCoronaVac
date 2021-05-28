package com.zup.coronavac.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zup.coronavac.domain.model.Cidadao;

/**
 * Estrutura utilizada para realizar a busca pelas variáveis de instância da classe Cidadao.java
 * @author Marcelo Gomes
 *
 */
@Repository
public interface CidadaoRepository extends JpaRepository <Cidadao, Long> {

	/**
	 * 
	 * @param nome String - Nome do cidadão.
	 * @return List - Cidadão
	 */
	List<Cidadao> findByNome(String nome);
	
	/**
	 * 
	 * @param email String - email do cidadão.
	 * @return List - Cidadão
	 */
	List<Cidadao> findByEmail(String email);
	
	/**
	 * 
	 * @param cpf String - CPF do cidadão.
	 * @return List - Cidadão
	 */
	List<Cidadao> findByCpf(String cpf);
}