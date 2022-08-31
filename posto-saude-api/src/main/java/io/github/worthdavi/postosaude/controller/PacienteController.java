package io.github.worthdavi.postosaude.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.worthdavi.postosaude.model.Paciente;
import io.github.worthdavi.postosaude.service.PacienteASLocal;
import io.github.worthdavi.postosaude.to.PacienteTO;

@RestController
@RequestMapping("/api/paciente")
@CrossOrigin("*")
public class PacienteController {

	@Autowired
	private PacienteASLocal pacienteAS;
	
	@GetMapping("/{id}")
	public ResponseEntity<PacienteTO> buscar(@PathVariable Integer id) {
		Optional<Paciente> optionalPaciente = pacienteAS.buscar(id);
		if(!optionalPaciente.isPresent() || optionalPaciente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<PacienteTO>(optionalPaciente.get().toForm(), HttpStatus.OK);
	}

	@GetMapping("/listar")
	public List<PacienteTO> listar() {
		return pacienteAS.listar();
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody PacienteTO paciente) {
		return pacienteAS.atualizar(id, paciente);
	}
}
