package io.github.worthdavi.postosaude.service;

import java.util.List;
import java.util.Optional;

import io.github.worthdavi.postosaude.model.Agenda;
import io.github.worthdavi.postosaude.to.AgendaTO;

public interface AgendaASLocal {

	List<AgendaTO> listarAgendasPorMedico(Integer idMedico);
	
	List<AgendaTO> listarAgendasPorData(String data);
	
	Optional<Agenda> buscar(Integer id);

	AgendaTO criarAgenda(Integer idMedico, AgendaTO agendaTO);

}
