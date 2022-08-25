package io.github.worthdavi.postosaude.service;

import java.util.List;

import io.github.worthdavi.postosaude.to.AgendaTO;

public interface MedicoASLocal {

	AgendaTO criarAgenda(Integer id, AgendaTO agendaTO);
	List<AgendaTO> listarAgendas(Integer id);
}
