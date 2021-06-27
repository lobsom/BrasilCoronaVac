package com.zup.coronavac.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.coronavac.domain.model.AplicacaoVacina;
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

}
