package io.github.worthdavi.postosaude.to;

import io.github.worthdavi.postosaude.model.Medico;

public class MedicoTO {

	private Integer idMedico;
	private String crm;
	private Integer idUsuario;

	/**
	 * 
	 */
	public MedicoTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idMedico
	 * @param crm
	 * @param idUsuario
	 */
	public MedicoTO(Integer idMedico, String crm, Integer idUsuario) {
		super();
		this.idMedico = idMedico;
		this.crm = crm;
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the idMedico
	 */
	public Integer getIdMedico() {
		return idMedico;
	}

	/**
	 * @param idMedico the idMedico to set
	 */
	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}

	/**
	 * @return the crm
	 */
	public String getCRM() {
		return crm;
	}

	/**
	 * @param crm the crm to set
	 */
	public void setCRM(String crm) {
		this.crm = crm;
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
