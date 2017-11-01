package br.com.atividadevi.Beans;


import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.atividadevi.Modelo.Eleitor;
import br.com.atividadevi.Modelo.Pessoa;
import br.com.atividadevi.Service.LoginService;
import br.com.atividadevi.Exception.Callback;
import static br.com.atividadevi.Util.ExcepctionUtil.getExceptionCauseMessage;


@Named("loginBean")
@SessionScoped
public class LoginBean extends Beans{

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();
	
	private Eleitor eleitor = new Eleitor();
	
	private NavegarBean navegarBean;
	
	@EJB
	private LoginService loginService;


	public String login(){	
		try{
			loginService.login(pessoa, new Callback<Pessoa>(){	
				@Override
				public void onSuccess(Pessoa object) {
					addMensageInfo(String.format("Logou com sucesso")); 
				}	
				@Override
				public void onFailure(Exception e) {
					addMensageError(getExceptionCauseMessage (e));
				}
			});
			return "menu?faces-redirects=true"; 		 
		}catch(Exception e){
			return "criarCandidato?faces-redirects=true"; 		 
		}
	}
	
	public String deslogar(){
		try{
			loginService.logout(pessoa, new Callback<Pessoa>(){
	
				@Override
				public void onSuccess(Pessoa object) {
					addMensageInfo(String.format("Logou com sucesso")); 
				}
	
				@Override
				public void onFailure(Exception e) {
					addMensageError(getExceptionCauseMessage (e));
				}
			
			});
			return "login?faces-redirects=true";
		}catch(Exception e){
			return "menu?faces-redirects=true"; 
		}
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

	public NavegarBean getNavegarBean() {
		return navegarBean;
	}

	public void setNavegarBean(NavegarBean navegarBean) {
		this.navegarBean = navegarBean;
	}
}
