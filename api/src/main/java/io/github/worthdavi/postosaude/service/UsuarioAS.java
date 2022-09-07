package io.github.worthdavi.postosaude.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.worthdavi.postosaude.model.Endereco;
import io.github.worthdavi.postosaude.model.Medico;
import io.github.worthdavi.postosaude.model.Paciente;
import io.github.worthdavi.postosaude.model.UnidadeDeSaude;
import io.github.worthdavi.postosaude.model.Usuario;
import io.github.worthdavi.postosaude.repository.EnderecoRepository;
import io.github.worthdavi.postosaude.repository.MedicoRepository;
import io.github.worthdavi.postosaude.repository.PacienteRepository;
import io.github.worthdavi.postosaude.repository.UsuarioRepository;
import io.github.worthdavi.postosaude.to.EnderecoTO;
import io.github.worthdavi.postosaude.to.UsuarioTO;

@Service
public class UsuarioAS implements UsuarioASLocal {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PacienteRepository pacienteRepository;
		
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private MedicoRepository medicoRepository;

	@Override
	public Optional<Usuario> buscar(Integer id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public UsuarioTO inserir(UsuarioTO usuarioTO) {
		Endereco endereco = usuarioTO.getEndereco().toModel();
		Usuario usuario = usuarioTO.toModel();
		UnidadeDeSaude unidade = usuarioTO.getUnidadeDeSaude().toModel();
		usuario.setEndereco(endereco);
		usuario.setUnidadeDeSaude(unidade);
		usuarioRepository.save(usuario);
		switch (usuarioTO.getTipoUsuario()) {
		case 1:
			Paciente paciente = new Paciente();
			paciente.setCpf(usuarioTO.getCPF());
			paciente.setUsuario(usuario);
			pacienteRepository.save(paciente);
			break;
		case 2:
			Medico medico = new Medico();
			medico.setCRM(usuarioTO.getCRM());
			medico.setUsuario(usuario);
			medicoRepository.save(medico);
			break;
		default:
			break;
		}
		return usuarioTO;
	}

	@Override
	public List<UsuarioTO> listar() {
		List<UsuarioTO> lista = new ArrayList<UsuarioTO>();
		usuarioRepository.findAll().stream().forEach(usuario -> {
			UsuarioTO usuarioTO = new UsuarioTO(usuario.getIdUsuario(), usuario.getLogin(), usuario.getSenha(),
					usuario.getNome(), usuario.getTelefone(), usuario.getEndereco().toForm(),
					usuario.getUnidadeDeSaude().toForm());
			lista.add(usuarioTO);
		});
		return lista;
	}

	@Override
	public ResponseEntity<Void> atualizar(Integer id, UsuarioTO usuarioTO) {
		Usuario usuario = usuarioRepository.findByIdUsuario(id);
		if(usuario != null) {
			EnderecoTO enderecoToSave = usuarioTO.getEndereco();
			enderecoToSave.setIdEndereco(usuario.getEndereco().getIdEndereco());
			Usuario usuarioToSave = usuarioTO.toModel();
			usuarioToSave.setIdUsuario(usuario.getIdUsuario());
			usuarioToSave.setEndereco(enderecoToSave.toModel());
			usuarioRepository.save(usuarioToSave);
		}
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<Void> deletar(Integer id) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		if (!usuarioOptional.isPresent() || usuarioOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Usuario usuario = usuarioOptional.get();
		usuarioRepository.delete(usuario);
		return ResponseEntity.ok().build();	
	}

}
