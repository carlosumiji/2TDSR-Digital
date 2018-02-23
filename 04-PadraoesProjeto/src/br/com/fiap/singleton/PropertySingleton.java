package br.com.fiap.singleton;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertySingleton {
	
	private static final Logger log = LoggerFactory.getLogger(PropertySingleton.class);

	//1-Atributo estático que armazen a instancia única
	private static Properties prop;
	
	//3-Construtor privado
	private PropertySingleton() {
	
	}
	
	//2-Método estático que retorna a intância única
	public static Properties getInstance() {
		log.debug("Recuperando o objeto de propriedades");
		if(prop == null) {
			//Inicializa o objeto
			prop = new Properties();
			//Carrega o objeto com as configurações do arquivo
			try {
				log.info("Carregando as propriedades do sistemas");
				prop.load(PropertySingleton.class.getResourceAsStream("/propriedades.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("Propriedades não foram carregadas");
			}
		}
		return prop;
	}
}
