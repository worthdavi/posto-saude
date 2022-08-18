/**
 * 
 */
package io.github.worthdavi.postosaude.enums;

/**
 * @author worthdavi
 *
 */
public enum TipoUsuarioEnum {
	FUNCIONARIO(0, "Funcionário"),
	ADMINISTRADOR(1, "Administrador");
	
	private final Integer id;
	private String nome;

	TipoUsuarioEnum(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public static TipoUsuarioEnum getInstance(final Integer id) {
		for (TipoUsuarioEnum r : TipoUsuarioEnum.values()) {
			if (r.getId().equals(id)) {
				return r;
			}
		}
		return null;
	}
}
