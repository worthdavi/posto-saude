package io.github.worthdavi.postosaude.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import io.github.worthdavi.postosaude.model.Usuario;
import io.github.worthdavi.postosaude.to.UsuarioTO;

public interface UsuarioASLocal {

	Optional<Usuario> buscar(Integer id);

	List<UsuarioTO> listar();
	
	ResponseEntity<Void> atualizar(Integer id, UsuarioTO usuario);

	UsuarioTO inserir(UsuarioTO usuarioTO);

}
