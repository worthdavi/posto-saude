package io.github.worthdavi.postosaude.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import io.github.worthdavi.postosaude.model.Paciente;
import io.github.worthdavi.postosaude.to.ConsultaTO;
import io.github.worthdavi.postosaude.to.PacienteTO;
import io.github.worthdavi.postosaude.to.UsuarioTO;

public interface PacienteASLocal {

	ConsultaTO marcarConsulta(Integer idPaciente, Integer idAgenda);
	List<PacienteTO> listar();

	ResponseEntity<Void> atualizar(Integer id, PacienteTO paciente);
	ResponseEntity<Void> deletar(Integer id);
	
	Optional<Paciente> buscar(Integer id);
	PacienteTO buscarPorUsuario(Integer idUsuario);
	UsuarioTO buscarUsuarioDoPaciente(Integer idPaciente);
	List<PacienteTO> listarPorCpf(String cpf);
}
