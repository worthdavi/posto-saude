package io.github.worthdavi.postosaude.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.github.worthdavi.postosaude.to.UnidadeDeSaudeTO;

@Entity
@Table(name = "unidadedesaude")
public class UnidadeDeSaude {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idunidadedesaude")
	private Integer idUnidade;
	
	String nome;

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

	public UnidadeDeSaudeTO toForm() {
		return new UnidadeDeSaudeTO(this.idUnidade, this.nome);
	}
	
}
