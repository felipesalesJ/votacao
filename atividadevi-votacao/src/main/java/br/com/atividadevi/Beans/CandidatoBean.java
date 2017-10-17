package br.com.atividadevi.Beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.atividadevi.Dao.CandidatoDao;
import br.com.atividadevi.Dao.PessoaDao;
import br.com.atividadevi.Modelo.Candidato;
import br.com.atividadevi.Modelo.Pessoa;


@Named("candidatoBean")
@SessionScoped
public class CandidatoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();

	private Candidato candidato = new Candidato();

	private Integer pessoaId;
	
	private Integer candidatoId;
	
	@Inject
	private PessoaDao pessoaDao;
	
	@Inject
	private CandidatoDao candidatoDao;
	
	public void gravar(){
		this.candidatoDao.begin();
		this.pessoa.setIdPessoa(0);
		this.candidato.setCandidatoId(0);
		this.pessoaDao.create(this.pessoa);
		this.candidatoDao.create(this.candidato);
	}

	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}

	public Integer getCandidatoId() {
		return candidatoId;
	}

	public void setCandidatoId(Integer candidatoId) {
		this.candidatoId = candidatoId;
	}

	public PessoaDao getPessoaDao() {
		return pessoaDao;
	}

	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}

	public CandidatoDao getCandidatoDao() {
		return candidatoDao;
	}

	public void setCandidatoDao(CandidatoDao candidatoDao) {
		this.candidatoDao = candidatoDao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
}
