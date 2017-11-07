package br.com.atividadevi.Exception;


public class ErroEmVotoException extends RuntimeException{

	public ErroEmVotoException(String string) {
		super(String.format(string));
	}
}
