package io.github.worthdavi.postosaude.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.github.worthdavi.postosaude.enums.StatusConsultaEnum;

@Entity
@Table(name = "agenda")
public class Agenda {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Date data;
	private String status;
	
	@Transient
	private StatusConsultaEnum statusEnum;
		
	@OneToOne
	@JoinColumn(name = "consulta_id")
	private Consulta consulta;
	
	public Agenda(Integer id, Date data, String status, Consulta consulta) {
		super();
		this.id = id;
		this.data = data;
		this.status = status;
		this.consulta = consulta;
	}

	public Agenda() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

}
