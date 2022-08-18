package io.github.worthdavi.postosaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.worthdavi.postosaude.model.Consulta;


public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
	
}
