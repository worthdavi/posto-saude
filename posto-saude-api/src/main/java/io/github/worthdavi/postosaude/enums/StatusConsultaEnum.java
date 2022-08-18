/**
 * 
 */
package io.github.worthdavi.postosaude.enums;

/**
 * @author worthdavi
 *
 */
public enum StatusConsultaEnum {
	ABERTO(0, "Aberta"),
	MARCADA(1, "Marcada"),
	CANCELADA(2, "Cancelada");
	
	private final Integer id;
	private String nome;

	StatusConsultaEnum(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public static StatusConsultaEnum getInstance(final Integer id) {
		for (StatusConsultaEnum r : StatusConsultaEnum.values()) {
			if (r.getId().equals(id)) {
				return r;
			}
		}
		return null;
	}
}
