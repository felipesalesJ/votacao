package br.com.atividadevi.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;

import br.com.atividadevi.Modelo.Pessoa;
import br.com.atividadevi.Dao.EleitorDao;
import br.com.atividadevi.Dao.PessoaDao;
import br.com.atividadevi.Exception.Callback;
import br.com.atividadevi.Exception.IdadeInvalidaException;

@Stateless
public class LoginService {
	
	private static final Logger logger = Logger.getGlobal();
	@EJB
	private PessoaDao pessoaDao;
	
	@EJB
	private EleitorDao eleitorDao;
	
	@EJB
	private LoginValidaService loginValidaService;
	
	public void login(Pessoa pessoa, Callback<Pessoa> callback){
		try{
			loginValidaService.validaCpf(pessoa);
			boolean existeEleitor = eleitorDao.findEleitor(pessoa.getCpf()) != null;
			if(existeEleitor){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", pessoa);
			}
		}catch(Exception e){
			logger.log(Level.SEVERE, e.getMessage(), e);
			callback.onFailure(e);
			throw new Exception();
		}
	}

	public String logout(Pessoa pessoa, Callback<Pessoa> callback) {
		try{
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuario", pessoa);
		}catch(Exception e){
			logger.log(Level.SEVERE, e.getMessage(), e);
			callback.onFailure(e);
		}
		return null;
		
	}
	
	public static Logger getLogger() {
		return logger;
	}

	public PessoaDao getPessoaDao() {
		return pessoaDao;
	}

	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}

	public EleitorDao getEleitorDao() {
		return eleitorDao;
	}

	public void setEleitorDao(EleitorDao eleitorDao) {
		this.eleitorDao = eleitorDao;
	}

	

}
