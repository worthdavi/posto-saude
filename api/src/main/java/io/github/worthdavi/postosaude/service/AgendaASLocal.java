package io.github.worthdavi.postosaude.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.github.worthdavi.postosaude.model.Agenda;
import io.github.worthdavi.postosaude.to.AgendaTO;

public interface AgendaASLocal {

	List<AgendaTO> listarAgendasPorMedico(Integer idMedico);
	
	List<AgendaTO> listarAgendasPorData(String data);
		
	List<AgendaTO> listarAgendasPorDataTodos(String data);
	
	List<AgendaTO> listarTodas();
	
	Optional<Agenda> buscar(Integer id);

	AgendaTO criarAgenda(Integer idMedico, AgendaTO agendaTO);
	
	ResponseEntity<Void> deletar(@PathVariable Integer id);
	
	ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody AgendaTO agendaTO);

	List<AgendaTO> listarPorIds(List<Integer> ids);

}
