package io.github.worthdavi.postosaude.to;

import io.github.worthdavi.postosaude.model.Endereco;

public class EnderecoTO {
	
	private Integer idEndereco;
	private String rua;
	private Integer numero;
	private String bairro;
	private String estado;
	private String pais;
	
	/**
	 * 
	 */
	public EnderecoTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idEndereco
	 * @param rua
	 * @param numero
	 * @param bairro
	 * @param estado
	 * @param pais
	 */
	public EnderecoTO(Integer idEndereco, String rua, Integer numero, String bairro, String estado, String pais) {
		super();
		this.idEndereco = idEndereco;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.estado = estado;
		this.pais = pais;
	}
	/**
	 * @return the idEndereco
	 */
	public Integer getIdEndereco() {
		return idEndereco;
	}
	/**
	 * @param idEndereco the idEndereco to set
	 */
	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	/**
	 * @return the rua
	 */
	public String getRua() {
		return rua;
	}
	/**
	 * @param rua the rua to set
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}
	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}
	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Endereco toModel() {
		Endereco endereco = new Endereco();
		endereco.setRua(this.rua);
		endereco.setBairro(this.bairro);
		endereco.setEstado(this.estado);
		endereco.setNumero(this.numero);
		endereco.setPais(this.pais);
		return endereco;
	}
	
}
