package com.zup.coronavac.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.coronavac.api.dto.VacinaRequest;
import com.zup.coronavac.api.dto.VacinaResponse;
import com.zup.coronavac.domain.model.Vacina;
import com.zup.coronavac.domain.service.VacinaService;


@RestController
@RequestMapping("/vacina")
public class VacinaController {
	private final VacinaService vacinaService;
	
	/**
	 * @param vacinaResponse
	 * @param vacinaService
	 */
	@Autowired
	VacinaController(VacinaService vacinaService) {
		this.vacinaService = vacinaService;
	}

	@PostMapping
	private ResponseEntity<VacinaResponse> inserirVacina(@Validated @RequestBody VacinaRequest vacinaRequest)
		throws Exception{
		
		Vacina vacina = vacinaRequest.criarVacina();
		vacinaService.salvarVacina(vacina);
		
		VacinaResponse vacinaRetornoResponse = vacina.resposta();
		return ResponseEntity.status(HttpStatus.CREATED).body(vacinaRetornoResponse);
	}
	
	@GetMapping
	private List<Vacina> listar(){
		return vacinaService.listarVacinas();
	}

}
