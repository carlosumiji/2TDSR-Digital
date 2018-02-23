package br.com.fiap.teste;

import java.util.Properties;
import br.com.fiap.singleton.PropertySingleton;

public class Teste {

	public static void main(String[] args) {
		Properties p = PropertySingleton.getInstance();
		System.out.println(p.getProperty("url"));
		System.out.println(p.getProperty("login"));
	}

}
