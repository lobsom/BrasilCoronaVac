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
import org.springframework.web.server.ResponseStatusException;

import com.zup.coronavac.api.dto.VacinaRequest;
import com.zup.coronavac.api.dto.VacinaResponse;
import com.zup.coronavac.api.dto.VacinaResponseAllData;
import com.zup.coronavac.domain.model.Vacina;
import com.zup.coronavac.domain.service.VacinaService;

/**
 * Controller para gerenciar os recursos do tipo Vacina
 * @author Marcelo Gomes
 *
 */
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

	/**
	 * Cria o recurso Vacina no Banco de Dados
	 * @param vacinaRequest 
	 * @return VacinaResponseAllData - Retorna todos os membros de Classe de Vacina
	 * @throws Exception O Método chamado lança exceção caso tenha algum problema no Repository
	 */
	@PostMapping
	private ResponseEntity<VacinaResponseAllData> inserirVacina(@Validated @RequestBody VacinaRequest vacinaRequest)
		throws Exception{
		
		Vacina vacina = vacinaRequest.criarVacina();
		vacinaService.salvarVacina(vacina);
		
		VacinaResponseAllData vacinaRetornoResponse = vacina.respostaAllData();
		return ResponseEntity.status(HttpStatus.CREATED).body(vacinaRetornoResponse);
	}
	
	/**
	 * Lista todos os recursos Vacina disponíveis no sistema
	 * @return VacinaResponseAllData - Retorna todos os membros de Classe de Vacina 
	 */
	@GetMapping
	private List<VacinaResponseAllData> listar(){
		return vacinaService.listarVacinas();
	}
	
	/**
	 * 
	 * @param idvacina - id do recurso Vacina disponível no sistema
	 * @return VacinaResponse - Resposta com apenas alguns membros da Classe Vacina
	 * @throws Exception Acusa a inexistência do recurso no sistema - (NOT_FOUND - 404) 
	 */
	@GetMapping("/{idvacina}")
	private List<VacinaResponse> buscaPorId(@PathVariable ("idvacina") Long idvacina) throws Exception {
		List<VacinaResponse> result = vacinaService.listarVacinas(idvacina);
		if (!result.isEmpty()) {
			return result;
		}

		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vacina não encontrada");
	}

}
