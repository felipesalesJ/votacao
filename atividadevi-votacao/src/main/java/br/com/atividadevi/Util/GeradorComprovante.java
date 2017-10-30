package br.com.atividadevi.Util;

import java.util.Random;

public class GeradorComprovante {

	public Integer geradorid(){
		Random random = new Random();
		int num = random.nextInt(999) + 1;
		return num;
	}
}
