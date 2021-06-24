package com.zup.coronavac.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.coronavac.domain.model.AplicacaoVacina;

public interface VacinaRepository extends JpaRepository <AplicacaoVacina, Long> {
	/**
	 * 
	 * @param email String email de quem recebeu a vacina
	 * @return List - AplicacaoVacina
	 */
	List<AplicacaoVacina> findByEmail(String email);
}
