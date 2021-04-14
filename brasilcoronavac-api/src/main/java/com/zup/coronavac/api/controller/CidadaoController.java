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

@RestController
@RequestMapping("/cidadao")
public class CidadaoController {
	
	@Autowired
	private CadastroCidadaoService cadastroCidadao;
	
	@Autowired
	private CidadaoRepository cidadaoRepository;
	
	public CidadaoController(CidadaoRepository cidadaoRepository) {
		this.cidadaoRepository = cidadaoRepository;
	}
	
	
	@GetMapping("/listarCidadao")
	public List<CidadaoResponse> listar() {
		return cidadaoRepository.findAll().stream()
			    .map(e -> new CidadaoResponse(e.getId(), e.getNome(), e.getEmail()))
			    .collect(Collectors.toList());
	}
	
	@GetMapping("/obterCidadao")
	public CidadaoResponse listaCidadaoId() {
		CidadaoResponse cidadaoTeste = new CidadaoResponse(10087L,"Marcelo teste", "gomes.mr@gmail.com");
		return cidadaoTeste;
	}
	
	@GetMapping("/buscaPorId/{parametro}")
	public ResponseEntity<Cidadao> buscaPorId(@PathVariable Long parametro) {
		Optional<Cidadao> cidadao = cidadaoRepository.findById(parametro);
		
		if (cidadao.isPresent()) {
			return ResponseEntity.ok(cidadao.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/buscaPorEmail/{parametro}")
	public ResponseEntity<List<Cidadao>> buscaPorEmail(@PathVariable String parametro) throws Exception {
			
			List<Cidadao> cidadao = cidadaoRepository.findByEmail(parametro);
			List<Cidadao> cidadaoRetorno = cadastroCidadao.buscaEmail(cidadao);
			return ResponseEntity.status(HttpStatus.OK).body(cidadaoRetorno);
		}
	
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<CidadaoResponse> criarCidadao(@Validated @RequestBody CidadaoRequest cidadaoRequest) 
			throws Exception {
		
		Cidadao novoCidadao = cidadaoRequest.criarNovoCidadao();
		cadastroCidadao.salvar(novoCidadao);
		
		CidadaoResponse cidadaoRetorno = novoCidadao.resposta();
		return ResponseEntity.status(HttpStatus.CREATED).body(cidadaoRetorno);
	}
}