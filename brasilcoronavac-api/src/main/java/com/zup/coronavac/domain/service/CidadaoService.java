package com.zup.coronavac.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.zup.coronavac.api.dto.CidadaoResponse;
import com.zup.coronavac.domain.model.Cidadao;
import com.zup.coronavac.domain.repository.CidadaoRepository;

@Service
public class CidadaoService {
	private final CidadaoRepository cidadaoRepository;

	/**
	 * Injeção de dependência através do construtor da classe
	 * 
	 * @param cidadaoRepository
	 */
	@Autowired
	private CidadaoService(CidadaoRepository cidadaoRepository) {
		this.cidadaoRepository = cidadaoRepository;
	};

	/**
	 * Método para localizar um registro a partir do e-mail cadastrado
	 * 
	 * @param email Tipo String que será usado como argumento da busca
	 * @return List<Cidadao>: lista de objetos Cidadao
	 * @throws Exception Se o e-mail não consta na base
	 **/
	public List<Cidadao> buscaEmail(String email) throws Exception {
		List<Cidadao> verificaEmail = cidadaoRepository.findByEmail(email);
		if (!verificaEmail.isEmpty()) {
			return (List<Cidadao>) verificaEmail;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "E-mail não existe.");
	}

	/**
	 * 
	 * @param cpf
	 * @return List<Cidadao> Dados do cidadão
	 * @throws Exception 404 se o recurso não foi localizado
	 */
	public List<Cidadao> buscaCpf(String cpf) throws Exception {
		List<Cidadao> verificaCpf = cidadaoRepository.findByCpf(cpf);
		if (!verificaCpf.isEmpty()) {
			return (List<Cidadao>) verificaCpf;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CPF não existe.");
	}

	/**
	 * 
	 * @param cidadao Cria o recurso Cidadão no sistema
	 * @return Objeto Cidadao
	 * @throws Exception Caso os métodos chamados retornem true, será lançada a
	 *                   exceção
	 */
	public Cidadao salvar(Cidadao cidadao) 
			throws Exception {
		if (existeEmail(cidadao.getEmail())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail já existe.");
		} else if (existeCPF(cidadao.getCpf())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF já existe.");
		}
		return cidadaoRepository.save(cidadao);
	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	private boolean existeEmail(String email) {
		List<Cidadao> verificaEmail = cidadaoRepository.findByEmail(email);
		if (!verificaEmail.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param cpf
	 * @return
	 */
	private boolean existeCPF(String cpf) {
		List<Cidadao> verificaCpf = cidadaoRepository.findByCpf(cpf);
		if (!verificaCpf.isEmpty()) {
			return true;
		}
		return false;
	}


	public Cidadao existeCidadao(Long cidadaoId) {
		return cidadaoRepository.findById(cidadaoId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidadao não encontrado"));
		
	}

	public List<CidadaoResponse> listarCidadao() {
		return cidadaoRepository
				.findAll()
				.stream()
			    .map(e -> new CidadaoResponse(e.getId(), e.getNome(), e.getEmail(), e.getVacinasRecebidas()))
			    .collect(Collectors.toList());
	}

	public List<CidadaoResponse> listarCidadao(Long parametro) {
		return cidadaoRepository
				.findById(parametro)
				.stream()
			    .map(e -> new CidadaoResponse(e.getId(), e.getNome(), e.getEmail(), e.getVacinasRecebidas()))
			    .collect(Collectors.toList());
	}

}
