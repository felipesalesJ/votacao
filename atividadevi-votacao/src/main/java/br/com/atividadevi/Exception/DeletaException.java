package br.com.atividadevi.Exception;

public class DeletaException extends RuntimeException{

	public DeletaException(String string){
		super(String.format(string));
	}
}
