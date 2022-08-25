/**
 * 
 */
package io.github.worthdavi.postosaude.enums;

/**
 * @author worthdavi
 *
 */
public enum DisponibilidadeEnum {
	ABERTO("Aberta"),
	MARCADA("Marcada"),
	CANCELADA("Cancelada");
	
	private String disponibilidade;

	DisponibilidadeEnum(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getNome() {
		return disponibilidade;
	}
}
