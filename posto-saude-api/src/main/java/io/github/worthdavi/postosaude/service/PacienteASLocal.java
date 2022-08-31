package io.github.worthdavi.postosaude.service;

import io.github.worthdavi.postosaude.to.ConsultaTO;

public interface PacienteASLocal {

	ConsultaTO marcarConsulta(Integer idPaciente, Integer idAgenda);
}
