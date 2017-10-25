package br.com.atividadevi.Beans;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.atividadevi.Modelo.Eleitor;
import br.com.atividadevi.Modelo.Pessoa;
import br.com.atividadevi.Dao.EleitorDao;
import br.com.atividadevi.Dao.PessoaDao;


@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();
	
	private Eleitor eleitor = new Eleitor();
	
	private Integer pessoaId;
//	
//	private FacesContext fc = FacesContext.getCurrentInstance();
//	
//	private HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
	
	@Inject
	private PessoaDao pessoaDao;

	@Inject
	private EleitorDao eleitorDao;

	public String login(){
//		boolean existePessoa = pessoaDao.verifyPessoa(pessoa);
		boolean existeEleitor = pessoaDao.verifyEleitor(pessoa);
		if(existeEleitor){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.pessoa);
			return "menu?faces-redirects=true";
		}
		return null;
		
	}
	
	public String deslogar(){
		return null;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Eleitor getEleitor() {
		return eleitor;
	}
	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

	public EleitorDao getEleitorDao() {
		return eleitorDao;
	}
	public void setEleitorDao(EleitorDao eleitorDao) {
		this.eleitorDao = eleitorDao;
	}
	
	public PessoaDao getPessoaDao() {
		return pessoaDao;
	}
	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}

	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}	
}
