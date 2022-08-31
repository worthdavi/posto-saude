package io.github.worthdavi.postosaude.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import io.github.worthdavi.postosaude.model.Paciente;
import io.github.worthdavi.postosaude.to.ConsultaTO;
import io.github.worthdavi.postosaude.to.PacienteTO;

public interface PacienteASLocal {

	ConsultaTO marcarConsulta(Integer idPaciente, Integer idAgenda);
	List<PacienteTO> listar();

	ResponseEntity<Void> atualizar(Integer id, PacienteTO paciente);
	Optional<Paciente> buscar(Integer id);
}
