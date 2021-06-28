package com.zup.coronavac.domain.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.coronavac.api.dto.VacinacaoResponse;
import com.zup.coronavac.domain.model.Vacinacao;
import com.zup.coronavac.domain.repository.VacinacaoRepository;

@Service
public class VacinacaoService {
	private final VacinacaoRepository vacinacaoRepository;

	@Autowired
	public VacinacaoService(VacinacaoRepository vacinacaoRepository) {
		this.vacinacaoRepository = vacinacaoRepository;
	}

	/**
	 * Calcula a data para o cidadão receber a segunda dose da vacina
	 * @param primeiraDose - Date Data que foi realizada a vacinação
	 * @param intervaloDias - Integer Número de dias entre a primeira e segunda dose da vacina
	 * @return Date - Data que o cidadão deve retornar ao posto para receber a segunda dose de vacina
	 */
	public Date dataRetorno(Date primeiraDose, Integer intervaloDias) {	
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(primeiraDose);
		calendar.add(Calendar.DATE, intervaloDias);
		return calendar.getTime();
	}

	/**
	 * Cria o recurso Vacinacao no sistema 
	 * @param vacinacao - Objeto com todas as informações colhidas no Post e processadas
	 * @return Vacinacao
	 */
	public Vacinacao salvar(Vacinacao vacinacao) {
		return vacinacaoRepository.save(vacinacao);
		
	}

	/**
	 * Lista todos os recursos Vacinacao criados no sistema
	 * @return VacinacaoResponse
	 */
	public List<VacinacaoResponse> listarVacinacao() {
		return vacinacaoRepository
				.findAll()
				.stream()
			    .map(e -> new VacinacaoResponse(e.getId(), e.getCidadao(), e.getVacina(), e.getDataVacinacao(), e.getProximaDose()))
			    .collect(Collectors.toList());
	}
	
	/**
	 * Lista o recurso Vacinacao caso exista no sistema
	 * @param idvacinacao - Integer id do recurso que será listado
	 * @return VacinacaoResponse
	 */
	public List<VacinacaoResponse> listarVacinacao(Long idvacinacao) {
		return vacinacaoRepository
				.findById(idvacinacao)
				.stream()
			    .map(e -> new VacinacaoResponse(e.getId(), e.getCidadao(), e.getVacina(), e.getDataVacinacao(), e.getProximaDose()))
			    .collect(Collectors.toList());
	}
	
}
