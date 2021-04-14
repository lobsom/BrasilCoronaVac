package com.zup.coronavac.api.controller;

import java.util.List;
import java.util.Optional;

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
import com.zup.coronavac.domain.model.Cidadao;
import com.zup.coronavac.domain.repository.CidadaoRepository;
import com.zup.coronavac.domain.service.CadastroCidadaoService;

@RestController
@RequestMapping("/cidadao")
public class CidadaoController {
	
	@Autowired
	private CidadaoRepository cidadaoRepository;
	
	@Autowired
	private CadastroCidadaoService cadastroCidadao;
	
	@GetMapping("/listarCidadao")
	public List<Cidadao> listar() {
		return cidadaoRepository.findAll();
	}
	
	@GetMapping("/obterCidadao")
	public Cidadao listaCidadaoId() {
		Cidadao cidadao = new Cidadao("Marcelo", "gomes,mr@gmail.com", "09124768855", "02/10/1971");
		return cidadao;
	}
	
	@GetMapping("/{cidadaoId}")
	public ResponseEntity<Cidadao> buscar(@PathVariable Long cidadaoId) {
		Optional<Cidadao> cidadao = cidadaoRepository.findById(cidadaoId);
		
		if (cidadao.isPresent()) {
			return ResponseEntity.ok(cidadao.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cidadao adicionar(@Validated @RequestBody Cidadao cidadao) throws Exception {
		return cadastroCidadao.salvar(cidadao);
	}
}