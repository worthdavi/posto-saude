package io.github.worthdavi.postosaude.controller;

import java.util.List;

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

import io.github.worthdavi.postosaude.model.UnidadeDeSaude;
import io.github.worthdavi.postosaude.service.AdministradorASLocal;
import io.github.worthdavi.postosaude.service.UnidadeDeSaudeASLocal;
import io.github.worthdavi.postosaude.to.UnidadeDeSaudeTO;

@RestController
@RequestMapping("/api/unidade")
@CrossOrigin("*")
public class UnidadeDeSaudeController {

	@Autowired
	private AdministradorASLocal administradorAS;
	
	@Autowired
	private UnidadeDeSaudeASLocal unidadeDeSaudeAS;

	@GetMapping("{id}")
	public ResponseEntity<UnidadeDeSaudeTO> buscar(@PathVariable Integer id) {
		return unidadeDeSaudeAS.buscar(id);
	}

	@PostMapping("/add")
	public ResponseEntity<UnidadeDeSaudeTO> inserir(@RequestBody UnidadeDeSaudeTO unidade) {
		return administradorAS.inserirUnidadeDeSaude(unidade);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody UnidadeDeSaudeTO unidade) {
		return administradorAS.atualizarUnidadeDeSaude(id, unidade);
	}
	
	@GetMapping("/listar")
	public List<UnidadeDeSaude> listar() {
		return unidadeDeSaudeAS.listar();
	}
	
	@GetMapping("/listar/{nome}")
	public List<UnidadeDeSaudeTO> listarPorNome(@PathVariable String nome) {
		return unidadeDeSaudeAS.listarPorNome(nome);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) throws Exception {
		try {
			return unidadeDeSaudeAS.deletar(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
	}

}
