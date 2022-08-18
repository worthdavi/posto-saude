package io.github.worthdavi.postosaude.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.worthdavi.postosaude.model.Usuario;
import io.github.worthdavi.postosaude.repository.UsuarioRepository;
import io.github.worthdavi.postosaude.to.UsuarioTO;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping
	public ResponseEntity<UsuarioTO> salvar(@RequestBody UsuarioTO request) {
		Usuario usuario = request.tranformIntoEntity();
		repository.save(usuario);
		return ResponseEntity.ok(UsuarioTO.transformIntoTO(usuario));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> atualizar(
			@PathVariable Integer id,
			@RequestBody UsuarioTO request) {
		
		Optional<Usuario> pacienteExistente = repository.findById(id);
		if(pacienteExistente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Usuario usuario = request.tranformIntoEntity();
		usuario.setId(id.intValue());
		repository.save(usuario);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<UsuarioTO> getById(@PathVariable Integer id){
		return repository.findById(id)
				.map(UsuarioTO::transformIntoTO)
				.map(pacienteFR -> ResponseEntity.ok(pacienteFR) )
				.orElseGet( () -> ResponseEntity.notFound().build()  );				
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id){
		return repository.findById(id).map(usuario -> {
					repository.delete(usuario);
					return ResponseEntity.noContent().build();
				}).orElseGet( () -> ResponseEntity.notFound().build());			
	}
	
}
