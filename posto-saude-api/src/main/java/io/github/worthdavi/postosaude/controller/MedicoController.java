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

import io.github.worthdavi.postosaude.model.Medico;
import io.github.worthdavi.postosaude.service.MedicoASLocal;
import io.github.worthdavi.postosaude.to.MedicoTO;

@RestController
@RequestMapping("/api/medico")
@CrossOrigin("*")
public class MedicoController {
	
	@Autowired
	private MedicoASLocal medicoAS;
	
	@GetMapping("/{id}")
	public ResponseEntity<MedicoTO> buscar(@PathVariable Integer id) {
		Optional<Medico> optionalMedico = medicoAS.buscar(id);
		if(!optionalMedico.isPresent() || optionalMedico.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<MedicoTO>(optionalMedico.get().toForm(), HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	public List<MedicoTO> listar() {
		return medicoAS.listar();
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody MedicoTO medico) {
		return medicoAS.atualizar(id, medico);
	}
}
