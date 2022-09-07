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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/listar/{idAgendas}", method = RequestMethod.GET)
	public List<AgendaTO> listarPorIds(@PathVariable List<Integer> idAgendas) {
		return agendaAS.listarPorIds(idAgendas);
	}
	
	@GetMapping("/listar/datatodos/{data}")
	public List<AgendaTO> listarPorDataTodos(@PathVariable String data) {
		return agendaAS.listarAgendasPorDataTodos(data);
	}
	
	@GetMapping("/listar")
	public List<AgendaTO> listarTodas() {
		return agendaAS.listarTodas();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AgendaTO> buscar(@PathVariable Integer id) {
		Optional<Agenda> optionalAgenda = agendaAS.buscar(id);
		if(!optionalAgenda.isPresent() || optionalAgenda.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<AgendaTO>(optionalAgenda.get().toForm(), HttpStatus.OK);
	}

	@PostMapping("/add/{id}")
	public AgendaTO inserir(@RequestBody AgendaTO agenda, @PathVariable Integer id) {
		return agendaAS.criarAgenda(id, agenda);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody AgendaTO agenda) {
		return agendaAS.atualizar(id, agenda);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		return agendaAS.deletar(id);
	}

}
