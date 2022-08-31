package io.github.worthdavi.postosaude.model;

import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.github.worthdavi.postosaude.to.AgendaTO;

@Entity
@Table(name = "agenda")
public class Agenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idagenda")
	private Integer idAgenda;

	private Date data;

	@JsonFormat(pattern = "YYYY-MM-dd HH:mm")
	private Date horario;

	@Column(name = "disponibilidade")
	private Integer disponibilidade;

	@OneToOne
	@JoinColumn(name = "idmedico")
	private Medico medico;

	@PostPersist
	public void postPersist() throws ParseException {
		setHorario(new Date(horario.getTime()));
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
	public Date getHorario() {
		return horario;
	}

	/**
	 * @param horario the horario to set
	 */
	public void setHorario(Date horario) {
		this.horario = horario;
	}

	/**
	 * @return the medico
	 */
	public Medico getMedico() {
		return medico;
	}

	/**
	 * @param medico the medico to set
	 */
	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	/**
	 * @return the idAgenda
	 */
	public Integer getIdAgenda() {
		return idAgenda;
	}

	/**
	 * @return the disponibilidade
	 */
	public Integer getDisponibilidade() {
		return disponibilidade;
	}

	/**
	 * @param disponibilidade the disponibilidade to set
	 */
	public void setDisponibilidade(Integer disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public AgendaTO toForm() {
		return new AgendaTO(this.idAgenda, this.data, this.horario, this.disponibilidade, this.medico.toForm());
	}

}
