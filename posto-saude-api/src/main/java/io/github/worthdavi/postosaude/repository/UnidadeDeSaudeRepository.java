package io.github.worthdavi.postosaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.worthdavi.postosaude.model.Agenda;
import io.github.worthdavi.postosaude.model.UnidadeDeSaude;


public interface UnidadeDeSaudeRepository extends JpaRepository<UnidadeDeSaude, Integer> {
	
}
