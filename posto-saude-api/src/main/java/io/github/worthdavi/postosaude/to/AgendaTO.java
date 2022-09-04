package io.github.worthdavi.postosaude.to;

import java.util.Date;

public class AgendaTO {
	
	private Integer idAgenda;
	
	private Date data;
	private String horario;
	private String disponibilidade;
	private MedicoTO medico;
	
	/**
	 * 
	 */
	public AgendaTO() {
		super();
	}

	/**
	 * @param idAgenda
	 * @param data
	 * @param horario
	 * @param disponibilidade
	 * @param idMedico
	 */
	public AgendaTO(Integer idAgenda, Date data, String horario, String disponibilidade, MedicoTO medico) {
		super();
		this.idAgenda = idAgenda;
		this.data = data;
		this.horario = horario;
		this.disponibilidade = disponibilidade;
		this.medico = medico;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return the horario
	 */
	public String getHorario() {
		return horario;
	}

	/**
	 * @param horario the horario to set
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}

	/**
	 * @return the disponibilidade
	 */
	public String getDisponibilidade() {
		return disponibilidade;
	}

	/**
	 * @param disponibilidade the disponibilidade to set
	 */
	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}


	/**
	 * @return the medico
	 */
	public MedicoTO getMedico() {
		return medico;
	}

	/**
	 * @param medico the medico to set
	 */
	public void setMedico(MedicoTO medico) {
		this.medico = medico;
	}

	/**
	 * @return the idAgenda
	 */
	public Integer getIdAgenda() {
		return idAgenda;
	}
	
}