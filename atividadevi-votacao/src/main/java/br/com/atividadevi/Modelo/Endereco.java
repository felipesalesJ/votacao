package br.com.atividadevi.Modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Endereco")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SequenceIdEnderecoGenerator", sequenceName="ID_ENDERECO_SEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SequenceIdEnderecoGenerator")
	@Column(name="ID_ENDERECO")
	private Integer enderecoId;
	
	@Column(name="LOGRADOURO")
	private String logradouro;
	
	@Column(name="BAIRRO")
	private String bairro;
	
	@Column(name="MUNICIPIO")
	private String municipio;
	
	@Column(name="CEP")
	private String cep;

	public Integer getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
