package br.com.fiap.loja.singleton;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertySingleton {

	private static final Logger log = LoggerFactory.getLogger(PropertySingleton.class);
	private static Properties p;
	
	private PropertySingleton() {
		
	}
	
	public static Properties getInstance() {
		if(p == null) {
			p = new Properties();
			try {
				log.info("Carregando as propriedades do sistemas");
				p.load(PropertySingleton.class.getResourceAsStream("/loja.properties"));
			}catch(IOException e) {
				log.error("Propriedades não foram carregadas");
				e.printStackTrace();
			}
		}
		return p;
	}
	
}
