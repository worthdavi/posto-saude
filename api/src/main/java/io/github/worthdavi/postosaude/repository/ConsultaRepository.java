package io.github.worthdavi.postosaude.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.worthdavi.postosaude.model.Agenda;
import io.github.worthdavi.postosaude.model.Consulta;
import io.github.worthdavi.postosaude.model.Paciente;


public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
	List<Consulta> findAllByAgenda(Agenda agenda);
	List<Consulta> findByPaciente(Paciente paciente);
	Consulta findByAgenda(Agenda agenda);
}
