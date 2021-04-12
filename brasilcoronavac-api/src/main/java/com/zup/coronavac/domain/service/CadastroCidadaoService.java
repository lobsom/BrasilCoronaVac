package com.zup.coronavac.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.zup.coronavac.domain.model.Cidadao;
import com.zup.coronavac.domain.repository.CidadaoRepository;

@Service
public class CadastroCidadaoService {
	
	@Autowired
	private CidadaoRepository cidadaoRepository;

	
	public Cidadao salvar(Cidadao cidadao) throws Exception {
		if (existeEmail(cidadao.getEmail())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail já existe.");
		} else if (existeCPF(cidadao.getCpf())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF já existe.");
		}
		return cidadaoRepository.save(cidadao);
	}
	
	public boolean existeEmail(String email) {
		List<Cidadao> verificaEmail =  cidadaoRepository.findByEmail(email);
		if ((verificaEmail != null) && (!verificaEmail.isEmpty())) {
			return true;
		}
		return false;
	}

	public boolean existeCPF(String cpf) {
		List<Cidadao> verificaCpf = cidadaoRepository.findByCpf(cpf);
		if ((verificaCpf != null) && (!verificaCpf.isEmpty())) {
			return true;
		}
		return false;
	}

}
