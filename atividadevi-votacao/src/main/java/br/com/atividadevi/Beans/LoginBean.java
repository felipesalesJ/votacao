package br.com.atividadevi.Beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.atividadevi.Modelo.Eleitor;
import br.com.atividadevi.Modelo.Pessoa;


@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();
	
	private Eleitor eleitor = new Eleitor();
	
	private Integer pessoaid;

	public String logar(){
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

	public Integer getPessoaid() {
		return pessoaid;
	}

	public void setPessoaid(Integer pessoaid) {
		this.pessoaid = pessoaid;
	}
	
}
