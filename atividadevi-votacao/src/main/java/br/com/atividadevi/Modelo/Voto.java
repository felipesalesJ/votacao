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

@Entity
public class Voto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SequenceIdVotoGenerator", sequenceName="ID_VOTO_SEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SequenceIdVotoGenerator")
	@Column(name = "ID_VOTO")
	private Integer idvoto;
	
	
	@SequenceGenerator(name="SequenceComprovante", sequenceName="ID_COMPROVANTE_SEQ")
	@GeneratedValue(strategy= GenerationType.IDENTITY, generator = "SequenceComprovante")
	@Column(name="ID_COMPROVANTE")
	private Integer idcomprovante;
	
	@OneToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name = "ID_ELEITOR")
	private Eleitor eleitor;
	
	@OneToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name = "ID_CANDIDATO")
	private Candidato candidato;

	public Integer getIdvoto() {
		return idvoto;
	}

	public void setIdvoto(Integer idvoto) {
		this.idvoto = idvoto;
	}

	public Eleitor getEleitorid() {
		return eleitor;
	}

	public void setEleitorid(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

	public Candidato getCandidatoid() {
		return candidato;
	}

	public void setCandidatoid(Candidato candidato) {
		this.candidato = candidato;
	}

	public Integer getIdcomprovante() {
		return idcomprovante;
	}

	public void setIdcomprovante(Integer idcomprovante) {
		this.idcomprovante = idcomprovante;
	}

	}
