package br.com.atividadevi.Modelo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Pessoa")

public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ID_PES_SEQ", sequenceName="ID_PESSOA_SEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ID_PES_SEQ")
	@Column(name = "ID_PESSOA")
	private Integer idPessoa; 
	
	@Column(name = "NM_PESSOA")
	private String nome;
	
	@Column(name = "CPF")
	private String cpf;
	
	@Column(name = "GENERO")
	private String genero;
	
	@Column(name = "EMAIL_PESSOA")
	private String email;
	
	@Column(name = "DATA_NASCIMENTO")
	private Calendar datanascimento = Calendar.getInstance();

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Calendar datanascimento) {
		this.datanascimento = datanascimento;
	}
}
