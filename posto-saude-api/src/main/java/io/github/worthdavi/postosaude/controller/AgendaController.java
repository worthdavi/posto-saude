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

import io.github.worthdavi.postosaude.model.Agenda;
import io.github.worthdavi.postosaude.service.AgendaASLocal;
import io.github.worthdavi.postosaude.to.AgendaTO;

@RestController
@RequestMapping("/api/agenda")
@CrossOrigin("*")
public class AgendaController {

	@Autowired
	private AgendaASLocal agendaAS;

	@GetMapping("/listar/medico/{id}")
	public List<AgendaTO> listarPorMedico(@PathVariable Integer id) {
		return agendaAS.listarAgendasPorMedico(id);
	}
	
	@GetMapping("/listar/data/{data}")
	public List<AgendaTO> listarPorData(@PathVariable String data) {
		return agendaAS.listarAgendasPorData(data);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<AgendaTO> buscar(@PathVariable Integer id) {
		Optional<Agenda> optionalAgenda = agendaAS.buscar(id);
		if(!optionalAgenda.isPresent() || optionalAgenda.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<AgendaTO>(optionalAgenda.get().toForm(), HttpStatus.OK);
	}

	@PostMapping("/criar/{id}")
	public AgendaTO inserir(@RequestBody AgendaTO agenda, @PathVariable Integer id) {
		return agendaAS.criarAgenda(id, agenda);
	}

}
