package io.github.worthdavi.postosaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.worthdavi.postosaude.model.Agenda;


public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
	
}
