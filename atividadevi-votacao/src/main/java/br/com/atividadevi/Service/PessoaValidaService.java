package br.com.atividadevi.Service;

import java.util.Calendar;

import javax.ejb.Stateless;

import br.com.atividadevi.Exception.CpfInvalidoException;
import br.com.atividadevi.Exception.IdadeInvalidaException;
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
			throw new CpfInvalidoException("Verifique o número de digitos de CPF");
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
	
	public void verificarIdadeCandidato(Calendar datanascimento){
		try{
			Calendar data18 = Calendar.getInstance();
			data18.add(Calendar.YEAR, -18);
			if(data18.after(datanascimento)){
				return;
			}
		}catch(Exception e){
			throw new IdadeInvalidaException("Idade de candidatos não pode ser inferior à 18 anos");			
		}
	}
	
	public void verificarIdadeEleitor(Calendar datanascimento){
		try{
			Calendar data16 = Calendar.getInstance();
			data16.add(Calendar.YEAR, -16);
			if(data16.after(datanascimento)){
				return;
			}
		}catch(Exception e){
			throw new IdadeInvalidaException("Idade de eleitores não pode ser inferior à 16 anos");			
		}
	}
}
