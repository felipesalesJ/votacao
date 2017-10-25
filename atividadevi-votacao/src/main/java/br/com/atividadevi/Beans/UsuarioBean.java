package br.com.atividadevi.Beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.atividadevi.Modelo.Pessoa;

//import br.com.atividadevi.Service.CandidatoService;
//import br.com.atividadevi.Service.UsuarioService;

@Named("usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	@EJB
//	private UsuarioService usuarioService;


	public Pessoa getCurrentUser(){
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession httpSession = (HttpSession) externalContext.getSession(true);
		Pessoa eleitorLogador = (Pessoa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		return eleitorLogador;
	}
}
