package br.com.atividadevi.Util;

public class ExcepctionUtil {

	public static String getExceptionCauseMessage(Exception e) {
		return getExceptionCause(e).getMessage();
	}
	public static Throwable getExceptionCause(Exception e){
		if(e.getCause() == null){
			return e;
		}
		Throwable cause = e.getCause();
		while (cause.getCause() != null){
			cause = cause.getCause();
		}
		return cause;
	}
	public static String getExceptionCauseName(Exception e){
		return getExceptionCause(e).getClass().getName();
	}
}
