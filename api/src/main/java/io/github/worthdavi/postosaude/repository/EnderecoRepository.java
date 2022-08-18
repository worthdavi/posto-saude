package io.github.worthdavi.postosaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.worthdavi.postosaude.model.Endereco;


public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	
}
