package io.github.worthdavi.postosaude.to;

import io.github.worthdavi.postosaude.model.Paciente;

public class PacienteTO {

	private Integer idPaciente;
	private String cpf;
	private Integer idUsuario;
		
	/**
	 * 
	 */
	public PacienteTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idPaciente
	 * @param cpf
	 * @param idUsuario
	 */
	public PacienteTO(Integer idPaciente, String cpf, Integer idUsuario) {
		super();
		this.idPaciente = idPaciente;
		this.cpf = cpf;
		this.idUsuario = idUsuario;
	}
		
	public static PacienteTO transformIntoTO(Paciente paciente) {
		return new PacienteTO(paciente.getIdPaciente(), paciente.getCpf(), paciente.getUsuario().getIdUsuario());
	}
	
	/**
	 * @return the idPaciente
	 */
	public Integer getIdPaciente() {
		return idPaciente;
	}
	/**
	 * @param idPaciente the idPaciente to set
	 */
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	
	
}