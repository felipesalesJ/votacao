package br.com.atividadevi.Exception;


public class LoginCpfErradoException extends RuntimeException{

	public LoginCpfErradoException(String string) {
		super(String.format(string));
	}
}
