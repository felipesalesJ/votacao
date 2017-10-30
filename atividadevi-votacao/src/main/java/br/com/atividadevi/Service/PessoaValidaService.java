package br.com.atividadevi.Service;

import javax.ejb.Stateless;

import br.com.atividadevi.Exception.CpfInvalidoException;
import br.com.atividadevi.Modelo.Pessoa;

@Stateless
public class PessoaValidaService {
	
	public void validaCpf(Pessoa pessoa){
		String cpf = pessoa.getCpf();
		tamanhoCPF(cpf);
		verificarNumeroCPF(cpf);
	}
	
	private void tamanhoCPF(String cpf){
		if(cpf.length() < 11 || cpf.length() > 11){
			throw new CpfInvalidoException("Verifique o n�mero de digitos de CPF");
		}
	}
	
	private void verificarNumeroCPF(String cpf){
		try{
			@SuppressWarnings("unused")
			double db = Double.parseDouble(cpf);
		}catch(Exception e){
			throw new CpfInvalidoException("Use somente numeros ao digitar o CPF");
		} 
	}
	
	public void verificarEmail(){
		
	}
}