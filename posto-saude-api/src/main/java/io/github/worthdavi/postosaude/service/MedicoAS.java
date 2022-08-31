package io.github.worthdavi.postosaude.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.worthdavi.postosaude.model.Medico;
import io.github.worthdavi.postosaude.model.Paciente;
import io.github.worthdavi.postosaude.model.Usuario;
import io.github.worthdavi.postosaude.repository.MedicoRepository;
import io.github.worthdavi.postosaude.repository.UsuarioRepository;
import io.github.worthdavi.postosaude.to.AgendaTO;
import io.github.worthdavi.postosaude.to.MedicoTO;

@Service
public class MedicoAS implements MedicoASLocal {

	@Autowired
	private AgendaASLocal agendaAS;

	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public AgendaTO criarAgenda(Integer id, AgendaTO agendaTO) {
		return agendaAS.criarAgenda(id, agendaTO);
	}

	@Override
	public List<AgendaTO> listarAgendas(Integer id) {
		return agendaAS.listarAgendasPorMedico(id);
	}
	
	@Override
	public Optional<Medico> buscar(Integer id) {
		return medicoRepository.findById(id);
	}

	@Override
	public List<MedicoTO> listar() {
		List<MedicoTO> lista = new ArrayList<MedicoTO>();
		medicoRepository.findAll().stream().forEach(medico -> {
			MedicoTO medicoTO = new MedicoTO(medico.getIdMedico(), medico.getCRM(), medico.getUsuario().getIdUsuario());
			lista.add(medicoTO);
		});
		return lista;
	}

	@Override
	public ResponseEntity<Void> atualizar(Integer id, MedicoTO medicoTO) {
		Optional<Medico> medicoOptional = medicoRepository.findById(id);
		if (!medicoOptional.isPresent() || medicoOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Medico medicoEntity = medicoOptional.get();
		medicoEntity.setCRM(medicoTO.getCRM());
		medicoRepository.save(medicoEntity);
		return ResponseEntity.ok().build();
	}

}
