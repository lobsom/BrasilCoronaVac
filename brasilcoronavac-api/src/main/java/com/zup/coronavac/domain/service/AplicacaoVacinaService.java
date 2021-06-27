package com.zup.coronavac.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.zup.coronavac.domain.model.AplicacaoVacina;
import com.zup.coronavac.domain.repository.AplicacaoVacinaRepository;

@Service
public class AplicacaoVacinaService {
	private final AplicacaoVacinaRepository aplicacaoVacinaRepository;

	/**
	 * Construtor da classe para a ID do Spring
	 * 
	 * @param vacinaRepository
	 */
	@Autowired
	private AplicacaoVacinaService(AplicacaoVacinaRepository aplicacaoVacinaRepository) {
		this.aplicacaoVacinaRepository = aplicacaoVacinaRepository;
	}

	/**
	 * Método que grava o recurso Vacina no BD
	 * 
	 * @param vacina
	 * @return
	 * @throws Exception
	 */
	public AplicacaoVacina salvar(AplicacaoVacina vacina) throws Exception {
		return aplicacaoVacinaRepository.save(vacina);
	}

	/**
	 * 
	 * @return
	 */
	public List<AplicacaoVacina> listarVacinas() {
		return aplicacaoVacinaRepository.findAll();
	}

	/**
	 * 
	 * @param vacinaId
	 * @return
	 * @throws Exception
	 */
	public Optional<AplicacaoVacina> listarVacinas(Long vacinaId) throws Exception {
		return Optional.of(aplicacaoVacinaRepository.findById(vacinaId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vacina não encontrada")));
	}

}
