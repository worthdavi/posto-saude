package io.github.worthdavi.postosaude.service;

import java.util.Date;

import io.github.worthdavi.postosaude.enums.StatusConsultaEnum;
import io.github.worthdavi.postosaude.model.Agenda;
import io.github.worthdavi.postosaude.repository.AgendaRepository;
import io.github.worthdavi.postosaude.to.AgendaTO;
import io.github.worthdavi.postosaude.to.PacienteTO;

public class PacienteAS {
	
	AgendaRepository agendaRepository;
	
	public void marcarConsulta(AgendaTO agendaTO, PacienteTO paciente, Date data) {
		agendaTO.setStatus(StatusConsultaEnum.MARCADA.getNome());
		Agenda agenda = agendaTO.tranformIntoEntity();
		agendaRepository.save(agenda);
	}
}