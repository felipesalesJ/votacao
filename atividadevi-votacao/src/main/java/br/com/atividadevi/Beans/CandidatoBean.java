package br.com.atividadevi.Beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.atividadevi.Dao.CandidatoDao;
import br.com.atividadevi.Dao.PessoaDao;
import br.com.atividadevi.Modelo.Candidato;
import br.com.atividadevi.Modelo.Pessoa;
import br.com.atividadevi.Service.CandidatoService;


@Named("candidatoBean")
@SessionScoped
public class CandidatoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();

	private Candidato candidato = new Candidato();

	private Integer pessoaId;
	
	private Integer idCandidato;
	
	private List<Candidato> candidatos;
	
//	@Inject
//	private PessoaDao pessoaDao;
//	
//	@Inject
//	private CandidatoDao candidatoDao;
	
	@EJB
	private CandidatoService candidatoService;
	
//	public void gravar(){
//		try{
//			this.pessoa.setIdPessoa(0);
//			this.candidato.setCandidatoId(0);
//			this.pessoaDao.create(this.pessoa);
//			this.candidato.setPessoa(pessoa);
//			this.candidatoDao.create(this.candidato);
//		}finally{
//			this.candidato = new Candidato();
//			this.pessoa = new Pessoa();
//			this.candidato.setCandidatoId(0);
//			this.pessoa.setIdPessoa(0);
//		}
//	}
	public void gravar(){
		candidatoService.gravar(pessoa, candidato, pessoaId, idCandidato);
	}

	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}

	public Integer getCandidatoId() {
		return idCandidato;
	}

	public void setCandidatoId(Integer idCandidato) {
		this.idCandidato = idCandidato;
	}

//	public PessoaDao getPessoaDao() {
//		return pessoaDao;
//	}

//	public CandidatoDao getCandidatoDao() {
//		return candidatoDao;
//	}
//
//	public void setCandidatoDao(CandidatoDao candidatoDao) {
//		this.candidatoDao = candidatoDao;
//	}
//	
//	public void setPessoaDao(PessoaDao pessoaDao) {
//		this.pessoaDao = pessoaDao;
//	}

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
//
//	public List<Candidato> getCandidatos() {
//		this.candidatos = this.candidatoDao.readTodos();
//		return candidatos;
//	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
}
