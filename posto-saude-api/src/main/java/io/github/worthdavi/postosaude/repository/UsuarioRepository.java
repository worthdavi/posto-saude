package io.github.worthdavi.postosaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.worthdavi.postosaude.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
}
