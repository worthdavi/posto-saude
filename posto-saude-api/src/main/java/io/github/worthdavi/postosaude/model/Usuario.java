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
import javax.persistence.Transient;

import io.github.worthdavi.postosaude.to.UsuarioTO;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuario")
	private Integer idUsuario;

	private String login;
	private String senha;
	private String nome;
	private String telefone;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idendereco")
	private Endereco endereco;

	@OneToOne
	@JoinColumn(name = "idunidadedesaude")
	private UnidadeDeSaude unidade;

	@Transient
	private Integer tipoUsuario;

	@Transient
	private String CPF;

	@Transient
	private String CRM;
	
	

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
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
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

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
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @return the unidade
	 */
	public UnidadeDeSaude getUnidadeDeSaude() {
		return unidade;
	}

	/**
	 * @param unidade the unidade to set
	 */
	public void setUnidadeDeSaude(UnidadeDeSaude unidade) {
		this.unidade = unidade;
	}

	/**
	 * @return the tipoUsuario
	 */
	public Integer getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * @param tipoUsuario the tipoUsuario to set
	 */
	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	/**
	 * @return the CPF
	 */
	public String getCPF() {
		return CPF;
	}

	/**
	 * @param CPF the CPF to set
	 */
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	/**
	 * @return the CRM
	 */
	public String getCRM() {
		return CRM;
	}

	/**
	 * @param CRM the CRM to set
	 */
	public void setCRM(String CRM) {
		this.CRM = CRM;
	}
	
	/**
	 * @return the unidade
	 */
	public UnidadeDeSaude getUnidade() {
		return unidade;
	}

	/**
	 * @param unidade the unidade to set
	 */
	public void setUnidade(UnidadeDeSaude unidade) {
		this.unidade = unidade;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public UsuarioTO toForm() {
		return new UsuarioTO(this.idUsuario, this.login, this.senha, this.nome, this.telefone, this.endereco.toForm(), this.unidade.toForm());
	}
}
