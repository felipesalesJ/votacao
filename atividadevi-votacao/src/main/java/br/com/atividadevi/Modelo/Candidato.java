package br.com.atividadevi.Modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Candidato")
public class Candidato implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SequenceIdCandiGenerator", sequenceName="ID_CANDIDATO_SEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SequenceIdCandiGenerator")
	@Column(name = "ID_CANDIDATO")
	private int candidatoId;
	
	@OneToOne//(cascade=CascadeType.DETACH)
	@JoinColumn(name = "ID_PESSOA")
	private Pessoa pessoa;

	public Integer getCandidatoId() {
		return candidatoId;
	}

	public void setCandidatoId(Integer candidatoId) {
		this.candidatoId = candidatoId;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
