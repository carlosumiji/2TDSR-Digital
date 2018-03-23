package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.ws.service.ProdutoService;
import br.com.fiap.ws.to.Produto;

public class AtualizaView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Produto produto = new Produto();
		
		System.out.println("Codigo: ");
		produto.setCodigo(sc.nextInt());
		
		System.out.println("Nome: ");
		produto.setNome(sc.next() + sc.nextLine());
		
		System.out.println("Pre�o: " );
		produto.setPreco(sc.nextDouble());
		
		System.out.println("Disponivel: ");
		produto.setDisponivel(sc.nextBoolean());
		
		ProdutoService service = new ProdutoService();
		
		try {
			service.atualizar(produto);
			System.out.println("Atualizado!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		sc.close();
	}

}
