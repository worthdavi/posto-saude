package io.github.worthdavi.postosaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.worthdavi.postosaude.model.Medico;


public interface MedicoRepository extends JpaRepository<Medico, Integer> {
	
}
