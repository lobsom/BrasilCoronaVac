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

import com.zup.coronavac.api.dto.AplicacaoVacinaRequest;
import com.zup.coronavac.api.dto.AplicacaoVacinaResponse;
import com.zup.coronavac.domain.model.AplicacaoVacina;
import com.zup.coronavac.domain.model.Cidadao;
import com.zup.coronavac.domain.service.CidadaoService;
import com.zup.coronavac.domain.service.AplicacaoVacinaService;

/**
 * Controller da Aplicação das Vacinas
 * @author Marcelo Gomes
 *
 */
@RestController
@RequestMapping("/aplicarvacina")
public class AplicacaoVacinaController {
	private final AplicacaoVacinaService cadastroVacinaService; 
	private final CidadaoService cadastroCidadaoService;
	
	/**
	 * 
	 * @param vacinaRepository
	 * @param cadastroVacina
	 */
	@Autowired
	AplicacaoVacinaController(
			AplicacaoVacinaService cadastroVacinaService,
			CidadaoService cadastroCidadaoService){
		this.cadastroVacinaService = cadastroVacinaService;
		this.cadastroCidadaoService = cadastroCidadaoService;
	}
	
	/**
	 * 
	 * @param
	 * @return ResponseEntity<VacinaResponse> Entidade de resposta com campos não sensíveis
	 * @throws Exception
	 */
	@PostMapping("/{cidadaoId}")
	public ResponseEntity<AplicacaoVacinaResponse> aplicarVacina(@Validated @RequestBody AplicacaoVacinaRequest vacinaRequest, @PathVariable("cidadaoId") Long cidadaoId) 
			throws Exception {
		Cidadao cidadao = cadastroCidadaoService.existeCidadao(cidadaoId);
		AplicacaoVacina novaVacina = vacinaRequest.criarNovaVacina();
		novaVacina.setCidadao(cidadao);
		cadastroVacinaService.salvar(novaVacina);
		
		AplicacaoVacinaResponse vacinaRetorno = novaVacina.resposta();
		return ResponseEntity.status(HttpStatus.CREATED).body(vacinaRetorno);
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping
	public List<AplicacaoVacina> listar() {
		return cadastroVacinaService.listarVacinas();
	}
	
	@GetMapping("/{vacinaId}")
	public ResponseEntity<AplicacaoVacina> buscar(@PathVariable Long vacinaId) throws Exception {
		Optional<AplicacaoVacina> vacina = cadastroVacinaService.listarVacinas(vacinaId);
		
		if (vacina.isPresent()) {
			return ResponseEntity.ok(vacina.get());
		}
		
		return ResponseEntity.notFound().build();
	}

	
	
}