package io.github.worthdavi.postosaude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.worthdavi.postosaude.service.AgendaASLocal;
import io.github.worthdavi.postosaude.to.AgendaTO;

@RestController
@RequestMapping("/api/agenda")
@CrossOrigin("*")
public class AgendaController {

	@Autowired
	private AgendaASLocal agendaAS;

	@GetMapping("/listar/{id}")
	public List<AgendaTO> listarPorMedico(@PathVariable Integer id) {
		return agendaAS.listarAgendasPorMedico(id);
	}

	@PostMapping("/criar/{id}")
	public AgendaTO inserir(@RequestBody AgendaTO agenda, @PathVariable Integer id) {
		return agendaAS.criarAgenda(id, agenda);
	}

}
