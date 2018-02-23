package br.com.fiap.loja.bo;

import br.com.fiap.to.ProdutoTO;

public class EstoqueBO {

	public ProdutoTO consultaProduto(int codigo) {
		ProdutoTO to = null;
		switch (codigo) {
		case 401:
			to = new ProdutoTO(401, "Camiseta Masculina", 50, 10);
			
			break;
		case 402:
			to = new ProdutoTO(402, "Camiseta Feminina", 40, 10);
		}
		return to;
	}
	
}
