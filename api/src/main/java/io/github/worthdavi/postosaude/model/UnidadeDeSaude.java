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

import io.github.worthdavi.postosaude.to.UnidadeDeSaudeTO;

@Entity
@Table(name = "unidadedesaude")
public class UnidadeDeSaude {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idunidadedesaude")
	private Integer idUnidade;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idendereco")
	private Endereco endereco;
	
	String nome;
	
	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
		return new UnidadeDeSaudeTO(this.idUnidade, this.nome, this.endereco.toForm());
	}
	
}
