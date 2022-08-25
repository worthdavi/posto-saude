package io.github.worthdavi.postosaude.to;

import io.github.worthdavi.postosaude.model.UnidadeDeSaude;

public class UnidadeDeSaudeTO {
	
	private Integer idUnidade;
	private String nome;
	
	/**
	 * @param idUnidade
	 * @param nome
	 */
	public UnidadeDeSaudeTO(Integer idUnidade, String nome) {
		super();
		this.idUnidade = idUnidade;
		this.nome = nome;
	}
	/**
	 * @return the idUnidade
	 */
	public Integer getIdUnidade() {
		return idUnidade;
	}
	/**
	 * @param idUnidade the idUnidade to set
	 */
	public void setIdUnidade(Integer idUnidade) {
		this.idUnidade = idUnidade;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public UnidadeDeSaude toModel() {
		UnidadeDeSaude unidade = new UnidadeDeSaude();
		unidade.setIdUnidade(this.idUnidade);
		unidade.setNome(this.nome);
		return unidade;
	}
	
}
