package com.zup.coronavac.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.zup.coronavac.domain.model.Vacina;
import com.zup.coronavac.domain.repository.VacinaRepository;

@Service
public class VacinaService {
	private final VacinaRepository vacinaRepository;

	/**
	 * @param vacinaRepository
	 */
	@Autowired
	public VacinaService(VacinaRepository vacinaRepository) {
		this.vacinaRepository = vacinaRepository;
	}

	/**
	 * 
	 * @param vacina
	 */
	public Vacina salvarVacina(Vacina vacina) throws Exception {
		return vacinaRepository.save(vacina);
	}

	public List<Vacina> listarVacinas() {
		return vacinaRepository.findAll();
	}

	public Vacina existeVacina(Long vacinaId) {
		return vacinaRepository.findById(vacinaId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Vacina não encontrada"));
	}

}
