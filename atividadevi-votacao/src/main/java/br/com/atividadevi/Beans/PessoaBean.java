package br.com.atividadevi.Beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.atividadevi.Dao.PessoaDao;
import br.com.atividadevi.Modelo.Pessoa;

@Named("pessoaBean")
@SessionScoped
public class PessoaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();
	
	private Integer pessoaId;
	
	@Inject
	private PessoaDao pessoaDao;
	
	public void gravar(){
		this.pessoa.setIdPessoa(0);
		this.pessoaDao.create(this.pessoa);
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}

	public PessoaDao getPessoaDao() {
		return pessoaDao;
	}

	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}
}
