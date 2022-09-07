/**
 * 
 */
package io.github.worthdavi.postosaude.enums;

/**
 * @author worthdavi
 *
 */
public enum TipoUsuarioEnum {
	PACIENTE(1, "Paciente"),
	MEDICO(2, "Medico"),
	FUNCIONARIO(3, "Funcionario"),
	ADMINISTRADOR(4, "Administrador");
	
	private Integer id;
	private String nome;

	TipoUsuarioEnum(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}
