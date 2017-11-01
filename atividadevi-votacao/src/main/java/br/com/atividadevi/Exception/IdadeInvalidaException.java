package br.com.atividadevi.Exception;

public class IdadeInvalidaException extends RuntimeException{

	public IdadeInvalidaException(String string) {
		super(String.format(string));
	}
}
