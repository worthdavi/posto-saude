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
import io.github.worthdavi.postosaude.repository.UsuarioRepository;
import io.github.worthdavi.postosaude.to.ConsultaTO;
import io.github.worthdavi.postosaude.to.PacienteTO;
import io.github.worthdavi.postosaude.to.UsuarioTO;

@Service
public class PacienteAS implements PacienteASLocal {

	@Autowired
	private ConsultaASLocal consultaAS;

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioASLocal usuarioAS;

	@Override
	public ConsultaTO marcarConsulta(Integer idPaciente, Integer idAgenda) {
		return consultaAS.marcarConsulta(idPaciente, idAgenda);
	}
	
	@Override
	public Optional<Paciente> buscar(Integer id) {
		return pacienteRepository.findById(id);
	}
	
	@Override
	public ResponseEntity<Void> atualizar(Integer id, PacienteTO pacienteTO) {
		Paciente paciente = pacienteRepository.findByIdPaciente(id);
		if(paciente != null) {
			paciente.setCpf(pacienteTO.getCpf());
			pacienteRepository.save(paciente);		
		}		
		return ResponseEntity.ok().build();
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
	public ResponseEntity<Void> deletar(Integer id) {
		Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
		if (!pacienteOptional.isPresent() || pacienteOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Paciente paciente = pacienteOptional.get();
		Integer idUsuario = paciente.getUsuario().getIdUsuario();
		pacienteRepository.delete(paciente);
		usuarioAS.deletar(idUsuario);
		return ResponseEntity.ok().build();	
	}
	
	@Override
	public PacienteTO buscarPorUsuario(Integer idUsuario) {
		Optional<Usuario> usuarioOptional = usuarioAS.buscar(idUsuario);
		if(usuarioOptional.isEmpty()|| !usuarioOptional.isPresent()) {
			return null;
		}
		Usuario usuario = usuarioOptional.get();
		Paciente paciente = pacienteRepository.findByUsuario(usuario);
		if(paciente != null) {
			return paciente.toForm();
		}
		return null;
	}

	@Override
	public List<PacienteTO> listarPorCpf(String cpf) {
		List<PacienteTO> lista = new ArrayList<PacienteTO>();
		pacienteRepository.findAllByCpfContains(cpf).stream().forEach(paciente -> {
			PacienteTO pacienteTO = new PacienteTO(paciente.getIdPaciente(), paciente.getCpf(),
					paciente.getUsuario().getIdUsuario());
			lista.add(pacienteTO);	
		});
		return lista;
	}

	@Override
	public UsuarioTO buscarUsuarioDoPaciente(Integer idPaciente) {
		Paciente paciente = pacienteRepository.findByIdPaciente(idPaciente);
		if(paciente == null) {
			return null;
		}
		Usuario usuario = paciente.getUsuario();
		if(usuario != null) {
			UsuarioTO usuarioTO = new UsuarioTO(usuario.getIdUsuario(), usuario.getLogin(), usuario.getSenha(),
					usuario.getNome(), usuario.getTelefone(), usuario.getEndereco().toForm(),
					usuario.getUnidadeDeSaude().toForm());
			return usuarioTO;
		}
		return null;
	}
}
