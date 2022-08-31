package io.github.worthdavi.postosaude.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.worthdavi.postosaude.model.Agenda;
import io.github.worthdavi.postosaude.model.Medico;
import io.github.worthdavi.postosaude.repository.AgendaRepository;
import io.github.worthdavi.postosaude.repository.MedicoRepository;
import io.github.worthdavi.postosaude.to.AgendaTO;

@Service
public class AgendaAS implements AgendaASLocal {

	@Autowired
	private AgendaRepository agendaRepository;

	@Autowired
	private MedicoRepository medicoRepository;

	DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;

	@Override
	public AgendaTO criarAgenda(Integer idMedico, AgendaTO agendaTO) {
		Optional<Medico> medicoOptional = medicoRepository.findById(idMedico);
		if (medicoOptional == null) {
			throw new EntityNotFoundException();
		}
		Medico medico = medicoOptional.get();
		Agenda agenda = new Agenda();
		agenda.setData(agendaTO.getData());
		agenda.setDisponibilidade(agendaTO.getDisponibilidade());
		agenda.setHorario(agendaTO.getHorario());
		agenda.setMedico(medico);
		agendaRepository.save(agenda);
		return new AgendaTO(agenda.getIdAgenda(), agenda.getData(), agenda.getHorario(), agenda.getDisponibilidade(),
				agenda.getMedico().toForm());
	}

	@Override
	public List<AgendaTO> listarAgendasPorMedico(Integer id) {
		List<AgendaTO> lista = new ArrayList<AgendaTO>();
		agendaRepository.findAll().stream().forEach(agenda -> {
			if (agenda.getMedico().getIdMedico() == id) {
				AgendaTO agendaTO = new AgendaTO(agenda.getIdAgenda(), agenda.getData(), agenda.getHorario(),
						agenda.getDisponibilidade(), agenda.getMedico().toForm());
				lista.add(agendaTO);
			}
		});
		return lista;
	}

}
