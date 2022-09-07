package io.github.worthdavi.postosaude.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.worthdavi.postosaude.model.UnidadeDeSaude;

public interface UnidadeDeSaudeRepository extends JpaRepository<UnidadeDeSaude, Integer> {
	List<UnidadeDeSaude> findAllByNomeContains(String nome);
}
