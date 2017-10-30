package br.com.atividadevi.Exception;

public interface Callback<T> {

	void onSuccess(T object);
	
	void onFailure(Exception e);
}
