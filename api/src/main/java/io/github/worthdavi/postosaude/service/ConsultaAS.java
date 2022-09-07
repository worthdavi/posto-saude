package io.github.worthdavi.postosaude.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.worthdavi.postosaude.model.Agenda;
import io.github.worthdavi.postosaude.model.Consulta;
import io.github.worthdavi.postosaude.model.Paciente;
import io.github.worthdavi.postosaude.repository.AgendaRepository;
import io.github.worthdavi.postosaude.repository.ConsultaRepository;
import io.github.worthdavi.postosaude.repository.PacienteRepository;
import io.github.worthdavi.postosaude.to.ConsultaTO;

@Service
public class ConsultaAS implements ConsultaASLocal {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private AgendaRepository agendaRepository;
	
	@Autowired
	private ConsultaRepository consultaRepository;

	@Override
	public ConsultaTO marcarConsulta(Integer idPaciente, Integer idAgenda) {
		Consulta consulta = new Consulta();
		Optional<Paciente> pacienteTemp = pacienteRepository.findById(idPaciente);
		if(pacienteTemp.isEmpty() || !pacienteTemp.isPresent()) {
			throw new EntityNotFoundException("Paciente não existe.");
		}
		Optional<Agenda> agendaTemp = agendaRepository.findById(idAgenda);
		if(agendaTemp.isEmpty() || !agendaTemp.isPresent()) {
			throw new EntityNotFoundException("Agenda não existe.");
		}
		Paciente paciente = pacienteTemp.get();
		Agenda agenda = agendaTemp.get();
		agenda.setDisponibilidade("OCUPADO");
		consulta.setAgenda(agenda);
		consulta.setPaciente(paciente);
		consultaRepository.save(consulta);
		return new ConsultaTO(consulta.getIdConsulta(), paciente.getIdPaciente(), agenda.getIdAgenda());
	}
	
	@Override
	public List<ConsultaTO> listarTodasConsultas() {
		List<ConsultaTO> lista = new ArrayList<ConsultaTO>();
		consultaRepository.findAll().stream().forEach(consulta -> {
			ConsultaTO consultaTO = new ConsultaTO(consulta.getIdConsulta(), consulta.getPaciente().getIdPaciente(), consulta.getAgenda().getIdAgenda());
			lista.add(consultaTO);
		});
		return lista;
	}

	@Override
	public List<ConsultaTO> listarPorPaciente(Integer idPaciente) {
		Paciente paciente = pacienteRepository.findByIdPaciente(idPaciente);
		if(paciente != null) {
			List<ConsultaTO> lista = new ArrayList<ConsultaTO>();
			consultaRepository.findByPaciente(paciente).stream().forEach(consulta -> {
				ConsultaTO consultaTO = new ConsultaTO(consulta.getIdConsulta(), consulta.getAgenda().getIdAgenda(), consulta.getPaciente().getIdPaciente());
				lista.add(consultaTO);
			});
			return lista;
		}
		return null;
	}
	
	@Override
	public ConsultaTO buscarPorIdAgenda(Integer idAgenda) {
		Agenda agenda = agendaRepository.findByIdAgenda(idAgenda);
		if(agenda != null) {
			Consulta consulta = consultaRepository.findByAgenda(agenda);
			if(consulta != null) {
				ConsultaTO consultaTO = new ConsultaTO(consulta.getIdConsulta(), consulta.getAgenda().getIdAgenda(), consulta.getPaciente().getIdPaciente());
				return consultaTO;
			}		
		}
		return null;
	}

	@Override
	public ResponseEntity<Void> deletar(Integer id) {
		Optional<Consulta> consultaOptional = consultaRepository.findById(id);
		if (!consultaOptional.isPresent() || consultaOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Consulta consulta = consultaOptional.get();
		Agenda agenda = consulta.getAgenda();
		agenda.setDisponibilidade("LIVRE");
		agendaRepository.save(agenda);
		consultaRepository.delete(consulta);
		return ResponseEntity.ok().build();	
	}
	
}
