package io.github.worthdavi.postosaude.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.worthdavi.postosaude.model.Medico;
import io.github.worthdavi.postosaude.model.Usuario;


public interface MedicoRepository extends JpaRepository<Medico, Integer> {
	
	List<Medico> findAllByCRMContains(String crm);
	
	Medico findByUsuario(Usuario usuario);
	Medico findByIdMedico(Integer idMedico);
	
	
	List<Medico> findAllByOrderByIdMedicoAsc();
}
