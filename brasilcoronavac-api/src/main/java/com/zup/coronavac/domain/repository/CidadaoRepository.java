package com.zup.coronavac.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zup.coronavac.domain.model.Cidadao;

@Repository
public interface CidadaoRepository extends JpaRepository <Cidadao, Long> {

	List<Cidadao> findByEmail(String email);
	List<Cidadao> findByCpf(String cpf);

}