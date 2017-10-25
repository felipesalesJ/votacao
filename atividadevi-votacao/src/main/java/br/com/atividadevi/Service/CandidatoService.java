package br.com.atividadevi.Service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.atividadevi.Exception.CpfInvalidoException;
import br.com.atividadevi.Dao.CandidatoDao;
import br.com.atividadevi.Dao.PessoaDao;
import br.com.atividadevi.Modelo.Candidato;
import br.com.atividadevi.Modelo.Pessoa;

@Stateless
public class CandidatoService {

	@EJB
	private PessoaDao pessoaDao;
	
	@EJB
	private CandidatoDao candidatoDao;
	
	public void gravar(Pessoa pessoa, Candidato candidato, Integer pessoaid, Integer candidatoid){
		try{
			pessoa.setIdPessoa(0);
			candidato.setCandidatoId(0);
			this.pessoaDao.create(pessoa);
			this.candidatoDao.create(candidato);
		}finally{
			candidato = new Candidato();
			pessoa = new Pessoa();
			candidato.setCandidatoId(0);
			pessoa.setIdPessoa(0);
		}
	}
	
//	public void cpfinvalido(Pessoa pessoa) throws CpfInvalidoException{
//		if(pessoa.getCpf()!= null || pessoa.getCpf())
//	}

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

}
