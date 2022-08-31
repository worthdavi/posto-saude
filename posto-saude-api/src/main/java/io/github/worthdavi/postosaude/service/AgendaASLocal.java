package io.github.worthdavi.postosaude.service;

import java.util.List;

import io.github.worthdavi.postosaude.to.AgendaTO;

public interface AgendaASLocal {

	List<AgendaTO> listarAgendasPorMedico(Integer idMedico);

	AgendaTO criarAgenda(Integer idMedico, AgendaTO agendaTO);

}
