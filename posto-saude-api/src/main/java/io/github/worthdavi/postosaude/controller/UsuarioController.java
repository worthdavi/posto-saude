package io.github.worthdavi.postosaude.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.worthdavi.postosaude.model.Usuario;
import io.github.worthdavi.postosaude.service.UsuarioASLocal;
import io.github.worthdavi.postosaude.to.EnderecoTO;
import io.github.worthdavi.postosaude.to.UsuarioTO;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioASLocal usuarioAS;

	@GetMapping("{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Integer id) {
		Optional<Usuario> usuarioData = usuarioAS.buscarUsuarioById(id);
		if (usuarioData.isPresent()) {
			return new ResponseEntity<>(usuarioData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(usuarioData.get(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add")
	public UsuarioTO inserirUsuario(@RequestBody UsuarioTO usuarioTO) {
		return usuarioAS.inserirUsuario(usuarioTO);
	}

	@GetMapping("/listar")
	public List<UsuarioTO> listarUsuarios() {
		return usuarioAS.listarUsuarios();
	}

}
