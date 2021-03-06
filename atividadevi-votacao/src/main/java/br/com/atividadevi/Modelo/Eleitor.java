package br.com.atividadevi.Modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Eleitor")
public class Eleitor implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SequenceIdEleitorGenerator", sequenceName="ID_ELEITOR_SEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SequenceIdEleitorGenerator")
	@Column(name = "ID_ELEITOR")
	private Integer eleitorId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PESSOA")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "ID_TELEFONE")
	private Telefone telefone;

	@ManyToOne
	@JoinColumn(name="ID_ENDERECO")
	private Endereco endereco;
	
	public Integer getEleitorId() {
		return eleitorId;
	}

	public void setEleitorId(Integer eleitorId) {
		this.eleitorId = eleitorId;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}	


}
