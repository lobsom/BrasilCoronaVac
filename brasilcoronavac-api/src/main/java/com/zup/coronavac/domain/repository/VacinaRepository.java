package com.zup.coronavac.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.coronavac.domain.model.AplicacaoVacina;
import com.zup.coronavac.domain.model.Cidadao;

public interface VacinaRepository extends JpaRepository <AplicacaoVacina, Long> {
	List<AplicacaoVacina> findByCidadaoId(Cidadao cidadao);
}
