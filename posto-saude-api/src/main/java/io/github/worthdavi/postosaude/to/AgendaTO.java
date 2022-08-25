package io.github.worthdavi.postosaude.to;

import java.time.LocalTime;
import java.util.Date;

public class AgendaTO {
	
	private Integer idAgenda;
	
	private Date data;
	private LocalTime horario;
	private String disponibilidade;
	private Integer idMedico;
	
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
	public AgendaTO(Integer idAgenda, Date data, LocalTime horario, String disponibilidade, Integer idMedico) {
		super();
		this.idAgenda = idAgenda;
		this.data = data;
		this.horario = horario;
		this.disponibilidade = disponibilidade;
		this.idMedico = idMedico;
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
	public LocalTime getHorario() {
		return horario;
	}

	/**
	 * @param horario the horario to set
	 */
	public void setHorario(LocalTime horario) {
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
	 * @return the idAgenda
	 */
	public Integer getIdAgenda() {
		return idAgenda;
	}
	
}