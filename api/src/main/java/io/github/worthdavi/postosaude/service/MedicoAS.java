package io.github.worthdavi.postosaude.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.worthdavi.postosaude.model.Agenda;
import io.github.worthdavi.postosaude.model.Medico;
import io.github.worthdavi.postosaude.model.Usuario;
import io.github.worthdavi.postosaude.repository.AgendaRepository;
import io.github.worthdavi.postosaude.repository.MedicoRepository;
import io.github.worthdavi.postosaude.to.AgendaTO;
import io.github.worthdavi.postosaude.to.MedicoTO;

@Service
public class MedicoAS implements MedicoASLocal {

	@Autowired
	private AgendaASLocal agendaAS;

	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private UsuarioASLocal usuarioAS;
	
	@Autowired
	private AgendaRepository agendaRepository;
	

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
		medicoRepository.findAllByOrderByIdMedicoAsc().stream().forEach(medico -> {
			MedicoTO medicoTO = new MedicoTO(medico.getIdMedico(), medico.getCRM(), medico.getUsuario().getIdUsuario());
			lista.add(medicoTO);
		});
		return lista;
	}
	
	@Override
	public List<MedicoTO> listarPorCRM(String crm) {
		List<MedicoTO> lista = new ArrayList<MedicoTO>();
		medicoRepository.findAllByCRMContains(crm).stream().forEach(medico -> {
			MedicoTO medicoTO = new MedicoTO(medico.getIdMedico(), medico.getCRM(), medico.getUsuario().getIdUsuario());
			lista.add(medicoTO);
		});
		return lista;
	}
	
	@Override
	public MedicoTO buscarPorUsuario(Integer idUsuario) {
		Optional<Usuario> usuarioOptional = usuarioAS.buscar(idUsuario);
		if(usuarioOptional.isEmpty()|| !usuarioOptional.isPresent()) {
			return null;
		}
		Usuario usuario = usuarioOptional.get();
		Medico medico = medicoRepository.findByUsuario(usuario);
		if(medico != null) {
			return medico.toForm();
		}
		return null;
	}

	@Override
	public ResponseEntity<Void> atualizar(Integer id, MedicoTO medicoTO) {
		Medico medico = medicoRepository.findByIdMedico(id);
		if(medico != null) {
			medico.setCRM(medicoTO.getCRM());
			medicoRepository.save(medico);		
		}		
		return ResponseEntity.ok().build();
	}
	
	@Override
	public ResponseEntity<Void> deletar(Integer id) {
		Optional<Medico> medicoOptional = medicoRepository.findById(id);
		if (!medicoOptional.isPresent() || medicoOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Medico medico = medicoOptional.get();
		List<Agenda> agendas = agendaRepository.findByMedico(medico);
		if (agendas != null) {
			for(Agenda agenda : agendas) {
				agendaRepository.delete(agenda);
			}
		}
		Integer idUsuario = medico.getUsuario().getIdUsuario();
		medicoRepository.delete(medico);
		usuarioAS.deletar(idUsuario);
		return ResponseEntity.ok().build();	
	}

}
