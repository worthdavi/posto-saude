package io.github.worthdavi.postosaude.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.worthdavi.postosaude.model.Endereco;
import io.github.worthdavi.postosaude.model.UnidadeDeSaude;
import io.github.worthdavi.postosaude.model.Usuario;
import io.github.worthdavi.postosaude.repository.EnderecoRepository;
import io.github.worthdavi.postosaude.repository.UsuarioRepository;
import io.github.worthdavi.postosaude.to.UsuarioTO;

@Service
public class UsuarioAS implements UsuarioASLocal {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
		
	@Override
	public Optional<Usuario> buscarUsuarioById(Integer id) {		
		return usuarioRepository.findById(id);
	}
	
	@Override
	public UsuarioTO inserirUsuario(UsuarioTO usuarioTO) {
		Endereco endereco = usuarioTO.getEndereco().toModel();
		Usuario usuario = usuarioTO.toModel();
		UnidadeDeSaude unidade = usuarioTO.getUnidadeDeSaude().toModel();
		usuario.setEndereco(endereco);
		usuario.setUnidadeDeSaude(unidade);
		enderecoRepository.save(endereco);
		usuarioRepository.save(usuario);
		return usuarioTO;
	}
	
	@Override
	public List<UsuarioTO> listarUsuarios() {
		List<UsuarioTO> lista = new ArrayList<UsuarioTO>();
		usuarioRepository.findAll().stream().forEach(usuario -> {
			UsuarioTO usuarioTO = new UsuarioTO(usuario.getIdUsuario(), usuario.getLogin(),
					usuario.getSenha(), usuario.getNome(), usuario.getTelefone(), usuario.getEndereco().toForm(), usuario.getUnidadeDeSaude().toForm());
			lista.add(usuarioTO);
		});		
		return lista;
	}

}
