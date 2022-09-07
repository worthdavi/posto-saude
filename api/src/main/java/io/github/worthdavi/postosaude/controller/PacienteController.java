package io.github.worthdavi.postosaude.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.worthdavi.postosaude.model.Paciente;
import io.github.worthdavi.postosaude.service.PacienteASLocal;
import io.github.worthdavi.postosaude.to.PacienteTO;
import io.github.worthdavi.postosaude.to.UsuarioTO;

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
	
	@GetMapping("/buscarPorUsuario/{idUsuario}")
	public PacienteTO listar(@PathVariable Integer idUsuario) {
		return pacienteAS.buscarPorUsuario(idUsuario);
	}
	
	@GetMapping("/buscarUsuarioDoPaciente/{idPaciente}")
	public UsuarioTO buscarUsuarioDoPaciente(@PathVariable Integer idPaciente) {
		return pacienteAS.buscarUsuarioDoPaciente(idPaciente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody PacienteTO paciente) {
		return pacienteAS.atualizar(id, paciente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		return pacienteAS.deletar(id);
	}
	
	@GetMapping("/listar/{cpf}")
	public List<PacienteTO> listarPorCpf(@PathVariable String cpf) {
		return pacienteAS.listarPorCpf(cpf);
	}
	
	@GetMapping("/listar")
	public List<PacienteTO> listar() {
		return pacienteAS.listar();
	}
}
