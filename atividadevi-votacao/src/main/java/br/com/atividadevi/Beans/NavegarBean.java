package br.com.atividadevi.Beans;

import java.io.Serializable;

public class NavegarBean implements Serializable{

	private static final long serialVersionUID = 1L;

	public String pgVotar(){
		return "criarCandidato?faces-redirects=true"; 		
	}
}
