package io.github.worthdavi.postosaude.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.worthdavi.postosaude.to.ConsultaTO;

@Service
public class PacienteAS implements PacienteASLocal {

	@Autowired
	private ConsultaASLocal consultaAS;

	@Override
	public ConsultaTO marcarConsulta(Integer idPaciente, Integer idAgenda) {
		return consultaAS.marcarConsulta(idPaciente, idAgenda);
	}
}
