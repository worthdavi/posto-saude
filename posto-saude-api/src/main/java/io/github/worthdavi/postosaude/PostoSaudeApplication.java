package io.github.worthdavi.postosaude;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.worthdavi.postosaude.enums.StatusConsultaEnum;
import io.github.worthdavi.postosaude.enums.TipoUsuarioEnum;
import io.github.worthdavi.postosaude.model.Agenda;
import io.github.worthdavi.postosaude.model.Consulta;
import io.github.worthdavi.postosaude.model.Endereco;
import io.github.worthdavi.postosaude.model.Medico;
import io.github.worthdavi.postosaude.model.Paciente;
import io.github.worthdavi.postosaude.model.Usuario;
import io.github.worthdavi.postosaude.repository.MedicoRepository;

@SpringBootApplication
public class PostoSaudeApplication {
	
	private static final Logger log = LoggerFactory.getLogger(PostoSaudeApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PostoSaudeApplication.class, args);	
	}
	
	
	/*
	@Bean
	public CommandLineRunner demo(MedicoRepository repository) {
		Endereco endereco = new Endereco();
		endereco.setBairro("heliópolis");
		endereco.setId(1);
		endereco.setRua("rua ronaldo");
		endereco.setNumero("500");
		
		TipoUsuarioEnum tipo = TipoUsuarioEnum.FUNCIONARIO;
		
		Usuario usuarioAdd = new Usuario();
		usuarioAdd.setId(1);
		usuarioAdd.setNome("Davi");
		usuarioAdd.setNascimento(new Date());
		usuarioAdd.setLogin("login");
		usuarioAdd.setPassword("senha");
		usuarioAdd.setTipoUsuario(tipo);
		usuarioAdd.setEndereco(endereco);
		
		Paciente paciente = new Paciente();
		paciente.setCpf("19231823");
		paciente.setId(1);
		paciente.setUsuario(usuarioAdd);
		
		StatusConsultaEnum status = StatusConsultaEnum.ABERTO;
		
		Consulta consulta = new Consulta();
		consulta.setDescricao("consulta de corno");
		consulta.setId(1);
		consulta.setPaciente(paciente);
		
		List<Agenda> lista = new ArrayList<Agenda>();
		Agenda agenda1 = new Agenda();
		agenda1.setConsulta(consulta);
		agenda1.setData(new Date());
		agenda1.setId(2);
		agenda1.setStatus(status.getNome());
		lista.add(agenda1);
		
		Medico medico = new Medico();
		medico.setId(1);
		medico.setCrm("81273-R");
		medico.setUsuario(usuarioAdd);
		medico.setAgenda(agenda1);

		
		return (args) -> {
			repository.save(medico);
			log.info("Medicos found with findAll():");
			log.info("-------------------------------");
			for (Medico end : repository.findAll()) {
				log.info(end.toString());
			}
			log.info("");
		};
	}
	*/
}
