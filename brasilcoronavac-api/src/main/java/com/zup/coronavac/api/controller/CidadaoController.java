package com.zup.coronavac.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.zup.coronavac.api.dto.CidadaoRequest;
import com.zup.coronavac.api.dto.CidadaoResponse;
import com.zup.coronavac.domain.model.Cidadao;
import com.zup.coronavac.domain.repository.CidadaoRepository;
import com.zup.coronavac.domain.service.CadastroCidadaoService;

/**
 * Recebe as requisições HTTP e envia a resposta.
 * @author Marcelo Gomes
 *
 */
@RestController
@RequestMapping("/cidadao")
 public class CidadaoController {
	private final CadastroCidadaoService cadastroCidadaoService;
	private final CidadaoRepository cidadaoRepository;
	
	/**
	 * Implementação de Injeção de dependência por Construtor
	 * @param cadastroCidadaoService
	 * @param cidadaoRepository
	 */
	@Autowired
	CidadaoController(CadastroCidadaoService cadastroCidadaoService, CidadaoRepository cidadaoRepository){
		this.cadastroCidadaoService = cadastroCidadaoService;
		this.cidadaoRepository = cidadaoRepository;
	}
	
	/**
	 * Método para executar a criação de um novo recurso no sistema
	 * @param cidadaoRequest
	 * @return 201 se o recurso foi criado com sucesso
	 * @throws Exception Caso ocorra algum erro, o método chamado irá devolver a exceção
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private ResponseEntity<CidadaoResponse> criarCidadao(@Validated @RequestBody CidadaoRequest cidadaoRequest) 
			throws Exception {
		
		Cidadao novoCidadao = cidadaoRequest.criarNovoCidadao();
		cadastroCidadaoService.salvar(novoCidadao);
		
		CidadaoResponse cidadaoRetorno = novoCidadao.resposta();
		return ResponseEntity.status(HttpStatus.CREATED).body(cidadaoRetorno);
	}

	/**
	 * Lista todos os cidadãos criados no sistema.<br> 
	 * Utiliza função Lambda para serializar os objetos retornados.
	 * @return cidadaoRepository
	 */
	@GetMapping
	private List<CidadaoResponse> listar() {
		return cidadaoRepository.findAll().stream()
			    .map(e -> new CidadaoResponse(e.getId(), e.getNome(), e.getEmail()))
			    .collect(Collectors.toList());
	}
	
	/**
	 * 
	 * @param parametro
	 * @return
	 */
	@GetMapping("/{parametro}")
	private ResponseEntity<Cidadao> buscaPorId(@PathVariable Long parametro) {
		Optional<Cidadao> cidadao = cidadaoRepository.findById(parametro);
		
		if (cidadao.isPresent()) {
			return ResponseEntity.ok(cidadao.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	/**
	 * 
	 * @param email
	 * @return 
	 * @throws Exception Caso ocorra algum erro, o método chamado irá devolver a exceção
	 */
	@GetMapping("/email/{email}")
	private ResponseEntity<List<Cidadao>> buscaPorEmail(@PathVariable String email) throws Exception {
			
			List<Cidadao> cidadaoRetorno = cadastroCidadaoService.buscaEmail(email);
			return ResponseEntity.status(HttpStatus.OK).body(cidadaoRetorno);
		}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 * @throws Exception Caso ocorra algum erro, o método chamado irá devolver a exceção
	 */
	@GetMapping("/cpf/{cpf}")
	private ResponseEntity<List<Cidadao>> buscaPorCpf(@PathVariable String cpf) throws Exception {
			
			List<Cidadao> cidadaoRetorno = cadastroCidadaoService.buscaCpf(cpf);
			return ResponseEntity.status(HttpStatus.OK).body(cidadaoRetorno);
		}
	
}