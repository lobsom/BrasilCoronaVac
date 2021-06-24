package com.zup.coronavac.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.zup.coronavac.domain.model.AplicacaoVacina;
import com.zup.coronavac.domain.model.Cidadao;
import com.zup.coronavac.domain.repository.CidadaoRepository;
import com.zup.coronavac.domain.repository.VacinaRepository;

@Service
public class CadastroVacinaService {
	private final VacinaRepository vacinaRepository;
	private final CidadaoRepository cidadaoRepository;
	/** Construtor da classe para a ID do Spring
	 * @param vacinaRepository
	 */
	@Autowired
	private CadastroVacinaService(VacinaRepository vacinaRepository, CidadaoRepository cidadaoRepository) {
		this.vacinaRepository = vacinaRepository;
		this.cidadaoRepository = cidadaoRepository;
	}
	
	/**
	 * Aqui devemos verificar se o cidadão consta no banco
	 * @param vacina
	 * @return
	 * @throws Exception
	 */
	public AplicacaoVacina salvar(AplicacaoVacina vacina)  throws Exception {
		if (!existeEmail(vacina.getEmail())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cidadão não cadastrado no sistema.");
		}
		
		return vacinaRepository.save(vacina);
	}
	
	/**
	 * Testa se existe cidadão na base para que o recurso da vacina possa ser criado
	 * @param email email do cidadão
	 * @return true se o cidadão já existe no sistema
	 */
	private boolean existeEmail(String email) {
		List<Cidadao> verificaEmail =  cidadaoRepository.findByEmail(email);
		if ((verificaEmail != null) && (!verificaEmail.isEmpty())) {
			return true;
		}
		return false;
	}
}
