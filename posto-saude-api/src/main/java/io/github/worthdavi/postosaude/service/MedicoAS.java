package io.github.worthdavi.postosaude.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.worthdavi.postosaude.to.AgendaTO;

@Service
public class MedicoAS implements MedicoASLocal {
	
	@Autowired
	private AgendaASLocal agendaAS;
	
	@Override
	public AgendaTO criarAgenda(Integer id, AgendaTO agendaTO) {
		return agendaAS.criarAgenda(id, agendaTO);
	}
	
	@Override
	public List<AgendaTO> listarAgendas(Integer id){
		return agendaAS.listarAgendasPorMedico(id);
	}
	
}
