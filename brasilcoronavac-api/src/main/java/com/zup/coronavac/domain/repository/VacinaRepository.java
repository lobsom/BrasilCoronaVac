package com.zup.coronavac.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.coronavac.domain.model.Vacina;

public interface VacinaRepository extends JpaRepository <Vacina, Long>{

}
