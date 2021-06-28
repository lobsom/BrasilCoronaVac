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
import org.springframework.web.bind.annotation.RestController;

import com.zup.coronavac.api.dto.VacinacaoRequest;
import com.zup.coronavac.api.dto.VacinacaoResponse;
import com.zup.coronavac.domain.model.Cidadao;
import com.zup.coronavac.domain.model.Vacina;
import com.zup.coronavac.domain.model.Vacinacao;
import com.zup.coronavac.domain.service.CidadaoService;
import com.zup.coronavac.domain.service.VacinaService;
import com.zup.coronavac.domain.service.VacinacaoService;

/**
 * Controller para gerenciar os recursos do tipo Vacinacao
 * @author Marcelo Gomes
 *
 */
@RestController
@RequestMapping("/vacinacao")
public class VacinacaoController {
	private final VacinacaoService vacinacaoService;
	private final VacinaService vacinaService;
	private final CidadaoService cidadaoService;
	
	/**
	 * Injeção de dependência por construtor
	 * @param vacinacaoService
	 * @param vacinaService
	 * @param cidadaoService
	 */
	@Autowired
	public VacinacaoController(VacinacaoService vacinacaoService, VacinaService vacinaService,
			CidadaoService cidadaoService) {
		this.vacinacaoService = vacinacaoService;
		this.vacinaService = vacinaService;
		this.cidadaoService = cidadaoService;
	}
	
	/**
	 * Cria o recurso Vacinacao no sistema
	 * @param vacinacaoRequest - Recebe os dados enviados pelo usuário
	 * @param cidadaoId - id do recurso Cidadao que vai ser vacinado
	 * @param vacinaId - id do recurso Vacina que será aplicada
	 * @return VacinacaoResponse - Dados a serem retornados para o usuário sobre o recurso criado
	 * @throws Exception Acusa a inexistência dos recursos Cidadao ou Vacina (NOT_FOUND - 404)
	 */
	@PostMapping("/{cidadaoId}/{vacinaId}")
	public ResponseEntity<VacinacaoResponse> vacinarCidadao(@Validated @RequestBody VacinacaoRequest vacinacaoRequest, 
			@PathVariable ("cidadaoId") Long cidadaoId, 
			@PathVariable ("vacinaId") Long vacinaId)
		throws Exception {
		Cidadao cidadao = cidadaoService.existeCidadao(cidadaoId);
		Vacina vacina = vacinaService.existeVacina(vacinaId);
		Vacinacao vacinacao = vacinacaoRequest.criarVacinacao();
		vacinacao.setCidadao(cidadao);
		vacinacao.setVacina(vacina);
		vacinacao.setProximaDose(vacinacaoService.dataRetorno(vacinacaoRequest.getDataVacinacao(), vacina.getProximaDose()));
		vacinacaoService.salvar(vacinacao);
		
		VacinacaoResponse vacinacaoResponse = vacinacao.resposta();
		return ResponseEntity.status(HttpStatus.CREATED).body(vacinacaoResponse);
	}
	
	/**
	 * Lista todos os recursos do tipo Vacinacao criados no sistema
	 * @return VacinacaoResponse
	 */
	@GetMapping
	public List<VacinacaoResponse> listarVacinasAplicadas() {
		return vacinacaoService.listarVacinacao();
	}

	@GetMapping("/{idvacinacao}")
	public List<VacinacaoResponse> listarVacinasAplicadas(@PathVariable ("idvacinacao") Long idvacinacao) {
		return vacinacaoService.listarVacinacao(idvacinacao);
	}

}
