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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.worthdavi.postosaude.model.Usuario;
import io.github.worthdavi.postosaude.service.UsuarioASLocal;
import io.github.worthdavi.postosaude.to.UsuarioTO;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioASLocal usuarioAS;

	@GetMapping("{id}")
	public ResponseEntity<UsuarioTO> buscar(@PathVariable Integer id) {
		Optional<Usuario> optionalUsuario = usuarioAS.buscar(id);
		if(!optionalUsuario.isPresent() || optionalUsuario.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<UsuarioTO>(optionalUsuario.get().toForm(), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody UsuarioTO usuario) {
		return usuarioAS.atualizar(id, usuario);
	}

	@PostMapping("/add")
	public UsuarioTO inserir(@RequestBody UsuarioTO usuarioTO) {
		return usuarioAS.inserir(usuarioTO);
	}

	@GetMapping("/listar")
	public List<UsuarioTO> listar() {
		return usuarioAS.listar();
	}
	
}
