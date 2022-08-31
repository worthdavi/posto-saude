package io.github.worthdavi.postosaude.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import io.github.worthdavi.postosaude.model.Medico;
import io.github.worthdavi.postosaude.to.AgendaTO;
import io.github.worthdavi.postosaude.to.MedicoTO;

public interface MedicoASLocal {

	AgendaTO criarAgenda(Integer id, AgendaTO agendaTO);
	List<AgendaTO> listarAgendas(Integer id);
	List<MedicoTO> listar();
	ResponseEntity<Void> atualizar(Integer id, MedicoTO usuario);
	Optional<Medico> buscar(Integer id);
}
