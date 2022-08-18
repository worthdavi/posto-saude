package io.github.worthdavi.postosaude.to;

import io.github.worthdavi.postosaude.model.Paciente;
import io.github.worthdavi.postosaude.model.Usuario;

public class PacienteTO {

	private Integer id;
	private String cpf;
	private Usuario usuario;

	public PacienteTO() {
		super();
	}
	
	public PacienteTO(Integer id, String cpf, Usuario usuario) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.usuario = usuario;
	}
	
	public Paciente tranformIntoEntity() {
		Paciente paciente = new Paciente();
		paciente.setId(id);
		paciente.setCpf(cpf);
		paciente.setUsuario(usuario);
		return paciente;
	}
	
	public static PacienteTO transformIntoTO(Paciente paciente) {
		return new PacienteTO(paciente.getId(),	paciente.getCpf(), paciente.getUsuario());
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
	
}