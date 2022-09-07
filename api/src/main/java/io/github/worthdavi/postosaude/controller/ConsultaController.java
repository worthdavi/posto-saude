package io.github.worthdavi.postosaude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.worthdavi.postosaude.service.ConsultaASLocal;
import io.github.worthdavi.postosaude.service.PacienteASLocal;
import io.github.worthdavi.postosaude.to.ConsultaTO;

@RestController
@RequestMapping("/api/consulta")
@CrossOrigin("*")
public class ConsultaController {

	@Autowired
	private PacienteASLocal pacienteAS;
	
	@Autowired
	private ConsultaASLocal consultaAS;
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		return consultaAS.deletar(id);
	}
	
	@GetMapping("/listar")
	public List<ConsultaTO> listar() {
		return consultaAS.listarTodasConsultas();
	}
	
	@GetMapping("/listar/{idPaciente}")
	public List<ConsultaTO> listarPorPaciente(@PathVariable Integer idPaciente) {
		return consultaAS.listarPorPaciente(idPaciente);
	}
	
	@GetMapping("/buscarPorIdAgenda/{idAgenda}")
	public ConsultaTO buscarPorIdAgenda(@PathVariable Integer idAgenda) {
		return consultaAS.buscarPorIdAgenda(idAgenda);
	}

	@PostMapping("/add/{idPaciente}/{idAgenda}")
	public ConsultaTO marcarConsulta(@PathVariable Integer idPaciente, @PathVariable Integer idAgenda) {
		return pacienteAS.marcarConsulta(idPaciente, idAgenda);
	}

}
