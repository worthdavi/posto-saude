package io.github.worthdavi.postosaude.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.worthdavi.postosaude.model.Agenda;
import io.github.worthdavi.postosaude.model.Medico;


public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
	List<Agenda> findByMedico(Medico medico);
	Agenda findByIdAgenda(Integer idAgenda);
	
	@Query("select p from Agenda p WHERE idagenda IN :ids")
	List<Agenda> findAllByIdAgenda(@Param("ids") List<Integer> ids);
}
