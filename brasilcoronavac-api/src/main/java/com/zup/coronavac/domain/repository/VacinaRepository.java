package com.zup.coronavac.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.coronavac.domain.model.AplicacaoVacina;

public interface VacinaRepository extends JpaRepository <AplicacaoVacina, Long> {

}
