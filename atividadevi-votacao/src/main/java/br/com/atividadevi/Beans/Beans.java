package br.com.atividadevi.Beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@SessionScoped
public class Beans implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public void addMensageError(String mensage){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensage, mensage));
	}
	
	public void addMensageInfo(String mensage){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensage, mensage));
	}
}
