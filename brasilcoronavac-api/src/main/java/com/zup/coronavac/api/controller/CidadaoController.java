package com.zup.coronavac.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.zup.coronavac.api.dto.CidadaoRequest;
import com.zup.coronavac.api.dto.CidadaoResponse;
import com.zup.coronavac.domain.model.Cidadao;
import com.zup.coronavac.domain.service.CidadaoService;

/**
 * Recebe as requisições HTTP e envia a resposta.
 * 
 * @author Marcelo Gomes
 *
 */
@RestController
@RequestMapping("/cidadao")
public class CidadaoController {
	private final CidadaoService cidadaoService;
	/**
	 * Implementação de Injeção de dependência por Construtor
	 * 
	 * @param cadastroCidadaoService
	 * 
	 */
	@Autowired
	CidadaoController(CidadaoService cidadaoService) {
		this.cidadaoService = cidadaoService;
	}

	/**
	 * Método para executar a criação de um novo recurso no sistema
	 * 
	 * @param cidadaoRequest
	 * @return 201 se o recurso foi criado com sucesso
	 * @throws Exception Caso ocorra algum erro, o método chamado irá devolver a
	 *                   exceção
	 */
	@PostMapping
	private ResponseEntity<CidadaoResponse> criarCidadao(@Validated @RequestBody CidadaoRequest cidadaoRequest)
			throws Exception {

		Cidadao novoCidadao = cidadaoRequest.criarNovoCidadao();
		cidadaoService.salvar(novoCidadao);

		CidadaoResponse cidadaoRetorno = novoCidadao.resposta();
		return ResponseEntity.status(HttpStatus.CREATED).body(cidadaoRetorno);
	}

	/**
	 * Lista todos os cidadãos criados no sistema.<br>
	 * Utiliza função Lambda para serializar os objetos retornados.
	 * 
	 * @return CidadaoResponse
	 */
	@GetMapping
	private List<CidadaoResponse> listar() {
		return cidadaoService.listarCidadao();
	}

	/**
	 * 
	 * @param parametro Id do cidadão a ser recuperado
	 * @return List<CidadaoResponse> Lista composta por um elemento com todas as
	 *         informações do cidadão.
	 * @throws Exception Caso o registro não conste na base, retorna 404 - "Cidadão
	 *                   não encontrado"
	 */
	@GetMapping("/{parametro}")
	private List<CidadaoResponse> buscaPorId(@PathVariable Long parametro) throws Exception {
		List<CidadaoResponse> result = cidadaoService.listarCidadao(parametro);
		if (!result.isEmpty()) {
			return result;
		}

		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidadao não encontrado");
	}

	/**
	 * 
	 * @param email
	 * @return
	 * @throws Exception Caso ocorra algum erro, o método chamado irá devolver a
	 *                   exceção
	 */
	@GetMapping("/email/{email}")
	private ResponseEntity<List<Cidadao>> buscaPorEmail(@PathVariable String email) 
			throws Exception {

		List<Cidadao> cidadaoRetorno = cidadaoService.buscaEmail(email);
		return ResponseEntity.status(HttpStatus.OK).body(cidadaoRetorno);
	}

	/**
	 * 
	 * @param cpf
	 * @return
	 * @throws Exception Caso ocorra algum erro, o método chamado irá devolver a
	 *                   exceção
	 */
	@GetMapping("/cpf/{cpf}")
	private ResponseEntity<List<Cidadao>> buscaPorCpf(@PathVariable String cpf) 
			throws Exception {

		List<Cidadao> cidadaoRetorno = cidadaoService.buscaCpf(cpf);
		return ResponseEntity.status(HttpStatus.OK).body(cidadaoRetorno);
	}

}