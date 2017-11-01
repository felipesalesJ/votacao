package br.com.atividadevi.Exception;

public class IdadeInferiorException extends RuntimeException{
	
	public IdadeInferiorException(String string) {
		super(String.format(string));
	}
}
