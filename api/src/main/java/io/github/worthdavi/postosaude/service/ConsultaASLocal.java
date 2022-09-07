package io.github.worthdavi.postosaude.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import io.github.worthdavi.postosaude.to.ConsultaTO;

public interface ConsultaASLocal {
	
	ResponseEntity<Void> deletar(Integer id);
	ConsultaTO marcarConsulta(Integer idPaciente, Integer idAgenda);
	List<ConsultaTO> listarTodasConsultas();
	List<ConsultaTO> listarPorPaciente(Integer idPaciente);
	ConsultaTO buscarPorIdAgenda(Integer idPaciente);
}
