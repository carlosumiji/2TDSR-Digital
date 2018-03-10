package br.com.fiap.inventario.view;

import java.util.Scanner;

import org.apache.axis2.AxisFault;

import br.com.fiap.inventario.EstoqueBOStub;
import br.com.fiap.inventario.EstoqueBOStub.ConsultaProduto;
import br.com.fiap.inventario.EstoqueBOStub.ConsultaProdutoResponse;
import br.com.fiap.inventario.EstoqueBOStub.ProdutoTO;

public class TerminalConsulta {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			
			EstoqueBOStub stub = new EstoqueBOStub();
			
			ConsultaProduto params = new ConsultaProduto();
			System.out.println("Digite o código: ");
			params.setCodigo(sc.nextInt());
			
			ConsultaProdutoResponse resp=  stub.consultaProduto(params);
			
			ProdutoTO produto = resp.get_return();
			System.out.println(produto.getNome());
			System.out.println(produto.getPrecoUnitario());
			System.out.println(produto.getQuantidade());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
