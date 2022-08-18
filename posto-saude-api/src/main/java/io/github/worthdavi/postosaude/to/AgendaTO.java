package io.github.worthdavi.postosaude.to;

import java.util.Date;

import javax.persistence.Transient;

import io.github.worthdavi.postosaude.enums.StatusConsultaEnum;
import io.github.worthdavi.postosaude.model.Agenda;
import io.github.worthdavi.postosaude.model.Usuario;

public class AgendaTO {

	private Integer id;
	private Date data;
	private String status;
	private StatusConsultaEnum statusEnum;

	public AgendaTO() {
		super();
	}
	
	public AgendaTO(Integer id, Date data, String status) {
		super();
		this.id = id;
		this.data = data;
		this.status = status;
	}
	
	public Agenda tranformIntoEntity() {
		Agenda agenda = new Agenda();
		agenda.setId(id);
		agenda.setData(data);
		agenda.setStatus(status);
		return agenda;
	}
	
	public static AgendaTO transformIntoTO(Agenda agenda) {
		AgendaTO agendaTO = new AgendaTO();
		agendaTO.setId(agenda.getId());
		agendaTO.setData(agenda.getData());
		agendaTO.setStatus(agenda.getStatus());
		return agendaTO;
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

	public StatusConsultaEnum getStatusEnum() {
		return statusEnum;
	}

	public void setStatusEnum(StatusConsultaEnum statusEnum) {
		this.statusEnum = statusEnum;
	}
	
	
	
}