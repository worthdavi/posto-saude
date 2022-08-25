package io.github.worthdavi.postosaude.to;

import io.github.worthdavi.postosaude.model.Usuario;

public class UsuarioTO {

	private Integer idUsuario;
	private String login;
	private String senha;
	private String nome;
	private String telefone;
	private EnderecoTO endereco;
	private UnidadeDeSaudeTO unidade;
	private Integer tipoUsuario;
	private String CPF;
	private String CRM;

	/**
	 * 
	 */
	public UsuarioTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idUsuario
	 * @param login
	 * @param senha
	 * @param nome
	 * @param telefone
	 * @param nascimento
	 * @param endereco
	 */
	public UsuarioTO(Integer idUsuario, String login, String senha, String nome, String telefone, EnderecoTO endereco,
			UnidadeDeSaudeTO unidade) {
		super();
		this.idUsuario = idUsuario;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	/**
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

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
	public EnderecoTO getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(EnderecoTO endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the unidade
	 */
	public UnidadeDeSaudeTO getUnidadeDeSaude() {
		return unidade;
	}

	/**
	 * @param unidade the unidade to set
	 */
	public void setUnidadeDeSaude(UnidadeDeSaudeTO unidade) {
		this.unidade = unidade;
	}

	/**
	 * @return the unidade
	 */
	public UnidadeDeSaudeTO getUnidade() {
		return unidade;
	}

	/**
	 * @param unidade the unidade to set
	 */
	public void setUnidade(UnidadeDeSaudeTO unidade) {
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

	public Usuario toModel() {
		Usuario usuario = new Usuario();
		usuario.setLogin(this.login);
		usuario.setSenha(this.senha);
		usuario.setNome(this.nome);
		usuario.setTelefone(this.telefone);
		usuario.setEndereco(null);
		usuario.setTipoUsuario(this.tipoUsuario);
		return usuario;
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

}