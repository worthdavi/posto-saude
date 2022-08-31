package io.github.worthdavi.postosaude.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.worthdavi.postosaude.model.UnidadeDeSaude;
import io.github.worthdavi.postosaude.repository.UnidadeDeSaudeRepository;
import io.github.worthdavi.postosaude.to.UnidadeDeSaudeTO;

@Service
public class UnidadeDeSaudeAS implements UnidadeDeSaudeASLocal {
	
	@Autowired
	private UnidadeDeSaudeRepository unidadeDeSaudeRepository;
	
	@Override
	public ResponseEntity<UnidadeDeSaudeTO> buscar(Integer id) {
		Optional<UnidadeDeSaude> unidadeOpcional = unidadeDeSaudeRepository.findById(id);
		if(!unidadeOpcional.isPresent() || unidadeOpcional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<UnidadeDeSaudeTO>(unidadeOpcional.get().toForm(), HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Void> atualizar(Integer id, UnidadeDeSaudeTO unidade) {
		Optional<UnidadeDeSaude> unidadeOpcional = unidadeDeSaudeRepository.findById(id);
		if(!unidadeOpcional.isPresent() || unidadeOpcional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		UnidadeDeSaude unidadeEntity = unidadeOpcional.get();
		unidadeEntity.setNome(unidade.getNome());
		unidadeDeSaudeRepository.save(unidadeEntity);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<UnidadeDeSaudeTO> inserir(UnidadeDeSaudeTO unidade) {
		UnidadeDeSaude unidadeEntity = new UnidadeDeSaude();
		unidadeEntity.setIdUnidade(unidade.getIdUnidade());
		unidadeEntity.setNome(unidade.getNome());
		unidadeDeSaudeRepository.save(unidadeEntity);
		return new ResponseEntity<UnidadeDeSaudeTO>(unidadeEntity.toForm(), HttpStatus.OK);
	}
	
	@Override
	public List<UnidadeDeSaudeTO> listar() {
		List<UnidadeDeSaudeTO> lista = new ArrayList<UnidadeDeSaudeTO>();
		unidadeDeSaudeRepository.findAll().stream().forEach(unidade -> {
			UnidadeDeSaudeTO unidadeTO = new UnidadeDeSaudeTO(unidade.getIdUnidade(), unidade.getNome());
			lista.add(unidadeTO);
		});
		return lista;
	}
}
