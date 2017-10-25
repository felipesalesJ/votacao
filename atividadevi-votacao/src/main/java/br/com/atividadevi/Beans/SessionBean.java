package br.com.atividadevi.Beans;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class SessionBean{

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	
	public static String getCPF() {
		HttpSession session  = getSession();
				if(session != null)
					return (String) session.getAttribute("CPF");
				else
					return null;
	}
}
