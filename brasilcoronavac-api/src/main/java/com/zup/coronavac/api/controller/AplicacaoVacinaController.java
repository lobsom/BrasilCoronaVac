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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.zup.coronavac.api.dto.VacinaRequest;
import com.zup.coronavac.api.dto.VacinaResponse;
import com.zup.coronavac.domain.model.AplicacaoVacina;
import com.zup.coronavac.domain.model.Cidadao;
import com.zup.coronavac.domain.repository.CidadaoRepository;
import com.zup.coronavac.domain.repository.VacinaRepository;
import com.zup.coronavac.domain.service.CadastroVacinaService;

@RestController
@RequestMapping("/vacina")
public class AplicacaoVacinaController {
	private final VacinaRepository vacinaRepository;
	private final CadastroVacinaService cadastroVacinaService; 
	private final CidadaoRepository cidadaoRepository;
	
	/**
	 * 
	 * @param vacinaRepository
	 * @param cadastroVacina
	 */
	@Autowired
	AplicacaoVacinaController(VacinaRepository vacinaRepository, 
			CadastroVacinaService cadastroVacinaService,
			CidadaoRepository cidadaoRepository){
		this.vacinaRepository = vacinaRepository;
		this.cadastroVacinaService = cadastroVacinaService;
		this.cidadaoRepository = cidadaoRepository;
	}
	
	/**
	 * 
	 * @param
	 * @return ResponseEntity<VacinaResponse> Entidade de resposta com campos não sensíveis
	 * @throws Exception
	 */
	@PostMapping("/{cidadaoId}")
	public ResponseEntity<VacinaResponse> aplicarVacina(@Validated @RequestBody VacinaRequest vacinaRequest, @PathVariable("cidadaoId") Long cidadaoId) 
			throws Exception {
		Cidadao cidadao = cidadaoRepository.findById(cidadaoId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidadao não encontrado"));
		AplicacaoVacina novaVacina = vacinaRequest.criarNovaVacina();
		novaVacina.setCidadao(cidadao);
		cadastroVacinaService.salvar(novaVacina);
		
		VacinaResponse vacinaRetorno = novaVacina.resposta();
		return ResponseEntity.status(HttpStatus.CREATED).body(vacinaRetorno);
	}
	/**
	 * 
	 * @return
	 */
	@GetMapping
	public List<AplicacaoVacina> listar() {
		return vacinaRepository.findAll();
	}
	
	@GetMapping("/{vacinaId}")
	public ResponseEntity<AplicacaoVacina> buscar(@PathVariable Long vacinaId) {
		Optional<AplicacaoVacina> vacina = vacinaRepository.findById(vacinaId);
		
		if (vacina.isPresent()) {
			return ResponseEntity.ok(vacina.get());
		}
		
		return ResponseEntity.notFound().build();
	}

	
	
}