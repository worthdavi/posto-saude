package io.github.worthdavi.postosaude.to;

import java.util.Date;

import io.github.worthdavi.postosaude.enums.TipoUsuarioEnum;
import io.github.worthdavi.postosaude.model.Endereco;
import io.github.worthdavi.postosaude.model.Usuario;

public class UsuarioTO {

	private Integer id;
	private Endereco endereco;
	private String nome;
	private Date nascimento;
	private String login;
	private String password;
	private TipoUsuarioEnum tipoUsuario;

	public UsuarioTO() {
		super();
	}
	
	public UsuarioTO(Integer id, Endereco endereco, String nome, Date nascimento, String login, String password, TipoUsuarioEnum tipoUsuario) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.nome = nome;
		this.nascimento = nascimento;
		this.login = login;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
	}
	
	public Usuario tranformIntoEntity() {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setEndereco(endereco);
		usuario.setNome(nome);
		usuario.setNascimento(nascimento);
		usuario.setLogin(login);
		usuario.setPassword(password);
		usuario.setTipoUsuario(tipoUsuario);
		return usuario;
	}
	
	public static UsuarioTO transformIntoTO(Usuario usuario) {
		return new UsuarioTO(usuario.getId(), usuario.getEndereco(), usuario.getNome(), usuario.getNascimento(), usuario.getLogin(), usuario.getPassword(), usuario.getTipoUsuario());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TipoUsuarioEnum getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuarioEnum tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
}