package io.github.worthdavi.postosaude.model;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.github.worthdavi.postosaude.enums.DisponibilidadeEnum;

@Entity
@Table(name = "agenda")
public class Agenda {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idagenda")
	private Integer idAgenda;
	
	private Date data;
	private LocalTime horario;
	
	@Column(name="disponibilidade")
	@Enumerated(EnumType.STRING)
	private DisponibilidadeEnum disponibilidade;
		
	@OneToOne
	@JoinColumn(name = "idmedico")
	private Medico medico;

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
	public DisponibilidadeEnum getDisponibilidade() {
		return disponibilidade;
	}

	/**
	 * @param disponibilidade the disponibilidade to set
	 */
	public void setDisponibilidade(DisponibilidadeEnum disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	
}
