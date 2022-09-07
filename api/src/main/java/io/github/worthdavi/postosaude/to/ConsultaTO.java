package io.github.worthdavi.postosaude.to;

public class ConsultaTO {
	
	private Integer idConsulta;
	private Integer idAgenda;
	private Integer idPaciente;
	
	/**
	 * 
	 */
	public ConsultaTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idConsulta
	 * @param idAgenda
	 * @param idPaciente
	 */
	public ConsultaTO(Integer idConsulta, Integer idAgenda, Integer idPaciente) {
		super();
		this.idConsulta = idConsulta;
		this.idAgenda = idAgenda;
		this.idPaciente = idPaciente;
	}
	/**
	 * @return the idConsulta
	 */
	public Integer getIdConsulta() {
		return idConsulta;
	}
	/**
	 * @param idConsulta the idConsulta to set
	 */
	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}
	/**
	 * @return the idAgenda
	 */
	public Integer getIdAgenda() {
		return idAgenda;
	}
	/**
	 * @param idAgenda the idAgenda to set
	 */
	public void setIdAgenda(Integer idAgenda) {
		this.idAgenda = idAgenda;
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

}
