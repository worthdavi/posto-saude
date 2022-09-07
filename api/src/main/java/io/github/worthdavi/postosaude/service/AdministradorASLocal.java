package io.github.worthdavi.postosaude.service;

import org.springframework.http.ResponseEntity;

import io.github.worthdavi.postosaude.to.UnidadeDeSaudeTO;

public interface AdministradorASLocal {

	ResponseEntity<UnidadeDeSaudeTO> inserirUnidadeDeSaude(UnidadeDeSaudeTO unidade);
	ResponseEntity<Void> atualizarUnidadeDeSaude(Integer id, UnidadeDeSaudeTO unidade);
}
