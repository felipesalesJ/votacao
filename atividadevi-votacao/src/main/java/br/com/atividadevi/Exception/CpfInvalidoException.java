package br.com.atividadevi.Exception;

public class CpfInvalidoException extends RuntimeException{

	public CpfInvalidoException(String string) {
		super(String.format(string));
	}
}
