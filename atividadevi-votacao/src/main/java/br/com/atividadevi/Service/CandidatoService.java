package br.com.atividadevi.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.atividadevi.Exception.Callback;
import br.com.atividadevi.Exception.DeletaException;
import br.com.atividadevi.Dao.CandidatoDao;
import br.com.atividadevi.Dao.PessoaDao;
import br.com.atividadevi.Dao.VotoDao;
import br.com.atividadevi.Modelo.Candidato;
import br.com.atividadevi.Modelo.Pessoa;
import br.com.atividadevi.Modelo.Voto;

@Stateless
public class CandidatoService {
	
	private static final Logger logger = Logger.getGlobal();
	@EJB
	private PessoaDao pessoaDao;
	
	@EJB
	private CandidatoDao candidatoDao;
	
	@EJB
	private VotoDao votoDao;
	
	@EJB
	private PessoaValidaService pessoaValidaService;
	
//	public void gravar(Pessoa pessoa, Candidato candidato, Integer pessoaid, Integer candidatoid){
//		try{
//			pessoa.setIdPessoa(0);
//			candidato.setCandidatoId(0);
//			this.pessoaDao.create(pessoa);
//			this.candidatoDao.create(candidato);
//		}finally{
//			candidato = new Candidato();
//			pessoa = new Pessoa();
//			candidato.setCandidatoId(0);
//			pessoa.setIdPessoa(0);
//		}
//	}
//	public void gravar(Pessoa pessoa, Candidato candidato, Integer pessoaid, Integer candidatoid, Callback<Pessoa> callback){
//		try{
//			create(pessoa, candidato);
//			callback.onSuccess(pessoa);
//		}catch(Exception e){
//			logger.log(Level.SEVERE, e.getMessage(), e);
//			callback.onFailure(e);
//		}
//	}
//	
//	public void create(Pessoa pessoa, Candidato candidato){
//		try{
//			candidatoValidaService.validaCpf(pessoa);
//			pessoa.setIdPessoa(0);
//			candidato.setCandidatoId(0);
//			candidato.setPessoa(pessoa);
//			this.pessoaDao.create(pessoa);
//			this.candidatoDao.create(candidato);
//		}finally{
//			candidato = new Candidato();
//			pessoa = new Pessoa();
//			candidato.setCandidatoId(0);
//			pessoa.setIdPessoa(0);
//		}
//	}
	
	public void gravar(Pessoa pessoa, Candidato candidato, Callback<Pessoa> callback){
		try{
			pessoaValidaService.validaCpf(pessoa);
			pessoaValidaService.valiDataCandidato(pessoa.getDatanascimento());
			pessoa.setIdPessoa(0);
			candidato.setCandidatoId(0);
			candidato.setPessoa(pessoa);
			this.pessoaDao.create(pessoa);
			this.candidatoDao.create(candidato);
			callback.onSuccess(pessoa);
		}catch(Exception e){
			logger.log(Level.SEVERE, e.getMessage(), e);
			callback.onFailure(e);
		}finally{
			candidato = new Candidato();
			pessoa = new Pessoa();
			candidato.setCandidatoId(0);
			pessoa.setIdPessoa(0);
		}
	}

	public void deletar(Voto voto, Pessoa pessoa, Candidato candidato, Integer candidatoid, Callback<Pessoa> callback){
		try{
			candidato = this.candidatoDao.buscarPorId(candidatoid);
			pessoa = candidato.getPessoa();
			Integer votoId = this.candidatoDao.findVoto(candidato);
			voto = this.votoDao.buscarPorId(votoId);
			this.votoDao.delete(voto);
			this.candidatoDao.delete(candidato);
			this.pessoaDao.delete(pessoa);
			this.candidatoDao.commit();
			this.candidatoDao.close();
		}catch(Exception e){
			this.candidatoDao.rollback();
			this.pessoaDao.rollback();
			candidato.setCandidatoId(0);
			pessoa.setIdPessoa(0);
			throw new DeletaException("Erro ao deletar");
		}finally{
			candidato = new Candidato();
			pessoa = new Pessoa();
		}
	}
	
	public List<Candidato> readTodos(){
		return candidatoDao.readTodos();
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

}
