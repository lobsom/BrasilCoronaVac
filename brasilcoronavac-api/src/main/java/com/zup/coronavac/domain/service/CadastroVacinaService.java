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
	
	@Autowired
	private VacinaRepository vacinaRepository;
	
	@Autowired
	private CidadaoRepository cidadaoRepository;
	
	
	
	public AplicacaoVacina salvar(AplicacaoVacina vacina)  throws Exception {
		if (existeEmail(vacina.getEmail())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cidadão não cadastrado no sistema.");
		}
		return vacinaRepository.save(vacina);
}
	
	public boolean existeEmail(String email) {
		List<Cidadao> verificaEmail =  cidadaoRepository.findByEmail(email);
		if ((verificaEmail != null) && (!verificaEmail.isEmpty())) {
			return false;
		}
		return true;
	}
}
