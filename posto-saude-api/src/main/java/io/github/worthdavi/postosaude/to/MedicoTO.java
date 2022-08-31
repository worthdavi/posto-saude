package io.github.worthdavi.postosaude.to;

import io.github.worthdavi.postosaude.model.Medico;
import io.github.worthdavi.postosaude.model.Usuario;

public class MedicoTO {

	private Integer idMedico;
	private String CRM;
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
	 * @param CRM
	 * @param idUsuario
	 */
	public MedicoTO(Integer idMedico, String CRM, Integer idUsuario) {
		super();
		this.idMedico = idMedico;
		this.CRM = CRM;
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
	 * @return the cRM
	 */
	public String getCRM() {
		return CRM;
	}

	/**
	 * @param cRM the cRM to set
	 */
	public void setCRM(String cRM) {
		CRM = cRM;
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
