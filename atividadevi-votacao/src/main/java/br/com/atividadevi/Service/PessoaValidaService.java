package br.com.atividadevi.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.ejb.Stateless;

import br.com.atividadevi.Exception.CpfInvalidoException;
import br.com.atividadevi.Exception.IdadeInferiorException;
import br.com.atividadevi.Exception.LoginCpfErradoException;
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
	
	public void valiDataCandidato(Calendar datanascimento){
			Calendar data18;
			data18 = GregorianCalendar.getInstance();
			data18.add(Calendar.YEAR, -18);
			if(datanascimento.getTime().after(data18.getTime())){
				throw new IdadeInferiorException("Não é possivel cadastrar candidatos com idade inferior à uma idade inferior à 18 anos");
			}
	}
	
	public void valiDataEleitor(Calendar datanascimento){
			Calendar data16 = GregorianCalendar.getInstance();
			data16.add(Calendar.YEAR, -16);
			if(datanascimento.getTime().after(data16.getTime())){
				throw new IdadeInferiorException("Não é possivel cadastrar eleitores com idade inferior à uma idade inferior à 16 anos");
			}
	}
//	public boolean valiDataEleitor(Calendar datanascimento) throws Exception{
//		boolean valida = false;
//		try{
//			Calendar data16;
//			data16 = GregorianCalendar.getInstance();
//			data16.add(Calendar.YEAR, -16);
//			if(datanascimento.getTime().before(data16.getTime())){
//				valida = true;
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return valida;
//	}

}
