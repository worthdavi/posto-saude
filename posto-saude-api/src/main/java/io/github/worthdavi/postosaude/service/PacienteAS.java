package io.github.worthdavi.postosaude.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.worthdavi.postosaude.model.Paciente;
import io.github.worthdavi.postosaude.model.Usuario;
import io.github.worthdavi.postosaude.repository.PacienteRepository;
import io.github.worthdavi.postosaude.to.ConsultaTO;
import io.github.worthdavi.postosaude.to.PacienteTO;

@Service
public class PacienteAS implements PacienteASLocal {

	@Autowired
	private ConsultaASLocal consultaAS;

	@Autowired
	private PacienteRepository pacienteRepository;

	@Override
	public ConsultaTO marcarConsulta(Integer idPaciente, Integer idAgenda) {
		return consultaAS.marcarConsulta(idPaciente, idAgenda);
	}
	
	@Override
	public Optional<Paciente> buscar(Integer id) {
		return pacienteRepository.findById(id);
	}

	@Override
	public List<PacienteTO> listar() {
		List<PacienteTO> lista = new ArrayList<PacienteTO>();
		pacienteRepository.findAll().stream().forEach(paciente -> {
			PacienteTO pacienteTO = new PacienteTO(paciente.getIdPaciente(), paciente.getCpf(),
					paciente.getUsuario().getIdUsuario());
			lista.add(pacienteTO);
		});
		return lista;
	}

	@Override
	public ResponseEntity<Void> atualizar(Integer id, PacienteTO pacienteTO) {
		Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
		if (!pacienteOptional.isPresent() || pacienteOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Paciente pacienteEntity = pacienteOptional.get();
		pacienteEntity.setCpf(pacienteTO.getCpf());
		pacienteRepository.save(pacienteEntity);
		return ResponseEntity.ok().build();
	}
}
