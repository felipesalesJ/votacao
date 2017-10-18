package br.com.atividadevi.Beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.atividadevi.Dao.EleitorDao;
import br.com.atividadevi.Dao.PessoaDao;
import br.com.atividadevi.Modelo.Eleitor;
import br.com.atividadevi.Modelo.Pessoa;

@Named("eleitorBean")
@SessionScoped
public class EleitorBean  implements Serializable{

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();
	
	private Eleitor eleitor = new Eleitor();
	
	private Integer pessoaId;
	
	private Integer eleitorId;
	
	@Inject
	private PessoaDao pessoaDao;
	
	@Inject
	private EleitorDao eleitorDao;
	
	public void gravar(){
		this.eleitor.setEleitorId(0);
		this.pessoa.setIdPessoa(0);
		this.pessoaDao.create(pessoa);
		this.eleitorDao.create(eleitor);
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

	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}

	public Integer getEleitorId() {
		return eleitorId;
	}

	public void setEleitorId(Integer eleitorId) {
		this.eleitorId = eleitorId;
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
