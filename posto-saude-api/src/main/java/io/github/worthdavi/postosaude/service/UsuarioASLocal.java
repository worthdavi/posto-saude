package io.github.worthdavi.postosaude.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import io.github.worthdavi.postosaude.model.Endereco;
import io.github.worthdavi.postosaude.model.Usuario;
import io.github.worthdavi.postosaude.to.EnderecoTO;
import io.github.worthdavi.postosaude.to.UsuarioTO;

public interface UsuarioASLocal {
	
	Optional<Usuario> buscarUsuarioById(Integer id);

	List<UsuarioTO> listarUsuarios();
	
	UsuarioTO inserirUsuario(UsuarioTO usuarioTO);

}
