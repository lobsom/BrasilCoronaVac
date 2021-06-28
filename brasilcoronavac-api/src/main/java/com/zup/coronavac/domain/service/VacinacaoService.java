package com.zup.coronavac.domain.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.coronavac.domain.model.Vacinacao;
import com.zup.coronavac.domain.repository.VacinacaoRepository;

@Service
public class VacinacaoService {
	private final VacinacaoRepository vacinacaoRepository;

	@Autowired
	public VacinacaoService(VacinacaoRepository vacinacaoRepository) {
		this.vacinacaoRepository = vacinacaoRepository;
	}

	public Date dataRetorno(Date proximaDose, Integer integer) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(proximaDose);
		cal.add(Calendar.DATE, integer);
		return cal.getTime();

		
	}

	public Vacinacao salvar(Vacinacao vacinacao) {
		return vacinacaoRepository.save(vacinacao);
		
	}

	public List<Vacinacao> listarVacinas() {
		return vacinacaoRepository.findAll();
	}
}
