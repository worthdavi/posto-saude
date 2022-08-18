package io.github.worthdavi.postosaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.worthdavi.postosaude.model.Paciente;


public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
	
}
