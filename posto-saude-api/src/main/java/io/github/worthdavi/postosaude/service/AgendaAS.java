package io.github.worthdavi.postosaude.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	String pattern = "yyyy-MM-dd";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

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

	@Override
	public List<AgendaTO> listarAgendasPorData(String data) {
		List<AgendaTO> lista = new ArrayList<AgendaTO>();
		agendaRepository.findAll().stream().forEach(agenda -> {
			String dataAgenda = simpleDateFormat.format(agenda.getData());
			if(dataAgenda.equals(data)) {
				AgendaTO agendaTO = new AgendaTO(agenda.getIdAgenda(), agenda.getData(), agenda.getHorario(),
						agenda.getDisponibilidade(), agenda.getMedico().toForm());
				lista.add(agendaTO);
			}
		});
		return lista;
	}

	@Override
	public Optional<Agenda> buscar(Integer id) {
		return agendaRepository.findById(id);
	}

}
