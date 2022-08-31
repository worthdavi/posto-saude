package io.github.worthdavi.postosaude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@GetMapping("/listar")
	public List<ConsultaTO> listar() {
		return consultaAS.listarTodasConsultas();
	}

	@PostMapping("/marcar/{idPaciente}/{idAgenda}")
	public ConsultaTO marcarConsulta(@PathVariable Integer idPaciente, @PathVariable Integer idAgenda) {
		return pacienteAS.marcarConsulta(idPaciente, idAgenda);
	}

}
