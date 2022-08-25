package io.github.worthdavi.postosaude.service;

import java.util.List;

import io.github.worthdavi.postosaude.to.ConsultaTO;

public interface ConsultaASLocal {

	ConsultaTO marcarConsulta(Integer idPaciente, Integer idAgenda);
	List<ConsultaTO> listarTodasConsultas();
}
