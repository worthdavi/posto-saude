package io.github.worthdavi.postosaude.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.worthdavi.postosaude.to.UnidadeDeSaudeTO;

@Service
public class AdministradorAS implements AdministradorASLocal {
	
	@Autowired
	private UnidadeDeSaudeASLocal unidadeDeSaudeAS;

	@Override
	public ResponseEntity<UnidadeDeSaudeTO> inserirUnidadeDeSaude(UnidadeDeSaudeTO unidade) {
		return unidadeDeSaudeAS.inserir(unidade);
	}
	
	@Override
	public ResponseEntity<Void> atualizarUnidadeDeSaude(Integer id, UnidadeDeSaudeTO unidade) {
		return unidadeDeSaudeAS.atualizar(id, unidade);
	}
		
}
