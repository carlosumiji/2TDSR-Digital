package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.ws.service.ProdutoService;
import br.com.fiap.ws.to.Produto;

public class BuscaView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o código: ");
		int codigo = sc.nextInt();
		
		ProdutoService service = new ProdutoService();
		try {
			Produto produtoduto = service.pesquisar(codigo);
			System.out.println(produtoduto.getNome());
			System.out.println(produtoduto.getPreco());
			System.out.println(produtoduto.isDisponivel());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		
		sc.close();

	}

}
