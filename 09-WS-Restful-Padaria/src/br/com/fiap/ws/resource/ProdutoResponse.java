package br.com.fiap.ws.resource;

import javax.persistence.EntityManager;

import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

public class ProdutoResponse {

	public ProdutoResponse() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	}

}
