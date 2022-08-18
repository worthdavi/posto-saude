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

import io.github.worthdavi.postosaude.model.Paciente;
import io.github.worthdavi.postosaude.repository.PacienteRepository;
import io.github.worthdavi.postosaude.to.PacienteTO;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin("*")
public class PacienteController {

	@Autowired
	private PacienteRepository repository;
	
	@PostMapping
	public ResponseEntity<PacienteTO> salvar(@RequestBody PacienteTO request) {
		Paciente paciente = request.tranformIntoEntity();
		repository.save(paciente);
		return ResponseEntity.ok(PacienteTO.transformIntoTO(paciente));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> atualizar(
			@PathVariable Integer id,
			@RequestBody PacienteTO request) {
		
		Optional<Paciente> pacienteExistente = repository.findById(id);
		if(pacienteExistente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Paciente paciente = request.tranformIntoEntity();
		paciente.setId(id.intValue());
		repository.save(paciente);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<PacienteTO> getById(@PathVariable Integer id){
		return repository.findById(id)
				.map(PacienteTO::transformIntoTO)
				.map(pacienteFR -> ResponseEntity.ok(pacienteFR) )
				.orElseGet( () -> ResponseEntity.notFound().build()  );				
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id){
		return repository.findById(id).map(paciente -> {
					repository.delete(paciente);
					return ResponseEntity.noContent().build();
				}).orElseGet( () -> ResponseEntity.notFound().build());			
	}
	
}
