package io.github.worthdavi.postosaude.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.worthdavi.postosaude.model.Paciente;
import io.github.worthdavi.postosaude.model.Usuario;


public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
	Paciente findByUsuario(Usuario usuario);
	Paciente findByIdPaciente(Integer idPaciente);
	List<Paciente> findAllByCpfContains(String cpf);
}
