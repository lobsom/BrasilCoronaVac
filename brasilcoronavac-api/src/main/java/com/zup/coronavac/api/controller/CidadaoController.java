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
	
	@Autowired
	private CadastroCidadaoService cadastroCidadaoService;
	
	@Autowired
	private CidadaoRepository cidadaoRepository;
	
	/**
	 * Método construtor
	 * @param cidadaoRepository - Interface de busca de variáveis de instância
	 */
	public CidadaoController(CidadaoRepository cidadaoRepository) {
		this.cidadaoRepository = cidadaoRepository;
	}
	
	/**
	 * Endpoint para listar os cidadãos solicitados no sistema
	 * @return cidadaoRepository
	 */
	@GetMapping
	public List<CidadaoResponse> listar() {
		return cidadaoRepository.findAll().stream()
			    .map(e -> new CidadaoResponse(e.getId(), e.getNome(), e.getEmail()))
			    .collect(Collectors.toList());
	}
	
	/**
	 * 
	 * @param parametro
	 * @return
	 */
	@GetMapping("/buscaPorId/{parametro}")
	public ResponseEntity<Cidadao> buscaPorId(@PathVariable Long parametro) {
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
	 * @throws Exception
	 */
	@GetMapping("/buscaPorEmail/{email}")
	public ResponseEntity<List<Cidadao>> buscaPorEmail(@PathVariable String email) throws Exception {
			
			List<Cidadao> cidadaoRetorno = cadastroCidadaoService.buscaEmail(email);
			return ResponseEntity.status(HttpStatus.OK).body(cidadaoRetorno);
		}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/buscaPorCpf/{cpf}")
	public ResponseEntity<List<Cidadao>> buscaPorCpf(@PathVariable String cpf) throws Exception {
			
			List<Cidadao> cidadaoRetorno = cadastroCidadaoService.buscaCpf(cpf);
			return ResponseEntity.status(HttpStatus.OK).body(cidadaoRetorno);
		}
	
	/**
	 * 
	 * @param cidadaoRequest
	 * @return
	 * @throws Exception
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<CidadaoResponse> criarCidadao(@Validated @RequestBody CidadaoRequest cidadaoRequest) 
			throws Exception {
		
		Cidadao novoCidadao = cidadaoRequest.criarNovoCidadao();
		cadastroCidadaoService.salvar(novoCidadao);
		
		CidadaoResponse cidadaoRetorno = novoCidadao.resposta();
		return ResponseEntity.status(HttpStatus.CREATED).body(cidadaoRetorno);
	}
}