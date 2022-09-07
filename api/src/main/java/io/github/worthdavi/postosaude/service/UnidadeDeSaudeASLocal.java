package io.github.worthdavi.postosaude.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import io.github.worthdavi.postosaude.to.UnidadeDeSaudeTO;

public interface UnidadeDeSaudeASLocal {
	
	ResponseEntity<UnidadeDeSaudeTO> inserir(UnidadeDeSaudeTO unidade);
	ResponseEntity<UnidadeDeSaudeTO> buscar(Integer id);
	List<UnidadeDeSaudeTO> listar();
	List<UnidadeDeSaudeTO> listarPorNome(String nome);
	ResponseEntity<Void> atualizar(Integer id, UnidadeDeSaudeTO unidade);
	ResponseEntity<Void> deletar(Integer id);
	
}
