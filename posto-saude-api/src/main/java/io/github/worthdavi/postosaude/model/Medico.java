package io.github.worthdavi.postosaude.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idmedico")
	private Integer idMedico;
	
	@Column(name="crm")
	private String CRM;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
	private Usuario usuario;

	/**
	 * @return the cRM
	 */
	public String getCRM() {
		return CRM;
	}

	/**
	 * @param cRM the cRM to set
	 */
	public void setCRM(String CRM) {
		this.CRM = CRM;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the idMedico
	 */
	public Integer getIdMedico() {
		return idMedico;
	}	
	
	
}
