package com.zup.coronavac.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.zup.coronavac.api.dto.VacinaResponse;
import com.zup.coronavac.api.dto.VacinaResponseAllData;
import com.zup.coronavac.domain.model.Vacina;
import com.zup.coronavac.domain.repository.VacinaRepository;

@Service
public class VacinaService {
	private final VacinaRepository vacinaRepository;

	/**
	 * Injeção de Dependência por composição
	 * @param vacinaRepository - Bean para acesso ao Repository
	 */
	@Autowired
	public VacinaService(VacinaRepository vacinaRepository) {
		this.vacinaRepository = vacinaRepository;
	}

	/**
	 * Cria o recurso no sistema a partir do método save() no Repository
	 * @param vacina - Vacina a ser incluída no sistema
	 */
	public Vacina salvarVacina(Vacina vacina) throws Exception {
		return vacinaRepository.save(vacina);
	}

	/**
	 * Verifica a existência do recurso Vacina com o id {vacinaId} 
	 * @param vacinaId não pode ser {@literal null} ou conter qualquer valor {@literal null}
	 * @return Vacina caso o recurso exista no sistema
	 */
	public Vacina existeVacina(Long vacinaId) {
		return vacinaRepository.findById(vacinaId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vacina não encontrada"));
	}

	/**
	 * Lista todos os recursos do tipo Vacina criados no sistema
	 * @return VacinaResponseAllData - Retorna todos os membros de classe de Vacina
	 */
	public List<VacinaResponseAllData> listarVacinas() {
		return vacinaRepository.findAll().stream().map(e -> new VacinaResponseAllData(e.getId(), e.getNomeVacina(),
				e.getLote(), e.getValidade(), e.getProximaDose())).collect(Collectors.toList());
	}

	/**
	 * Lista um recurso específico do tipo Vacina, caso exista no sistema
	 * @param idvacina 
	 * @return VacinaResponse - Retorna apenas alguns membros de classe de Vacina
	 */
	public List<VacinaResponse> listarVacinas(Long idvacina) {
		return vacinaRepository.findById(idvacina).stream()
				.map(e -> new VacinaResponse(e.getNomeVacina(), e.getLote(), e.getValidade(), e.getProximaDose()))
				.collect(Collectors.toList());
	}
}
