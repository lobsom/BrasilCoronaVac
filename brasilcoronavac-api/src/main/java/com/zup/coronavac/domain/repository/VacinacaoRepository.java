package com.zup.coronavac.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.coronavac.domain.model.Vacinacao;

public interface VacinacaoRepository extends JpaRepository<Vacinacao, Long>{

}
