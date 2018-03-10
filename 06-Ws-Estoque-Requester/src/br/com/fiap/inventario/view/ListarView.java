package br.com.fiap.inventario.view;

import java.util.Arrays;
import java.util.List;

import org.apache.axis2.AxisFault;

import br.com.fiap.inventario.EstoqueBOStub;
import br.com.fiap.inventario.EstoqueBOStub.Listar;
import br.com.fiap.inventario.EstoqueBOStub.ListarResponse;
import br.com.fiap.inventario.EstoqueBOStub.ProdutoTO;


public class ListarView {

	public static void main(String[] args) {
	
		try {
			EstoqueBOStub stub = new EstoqueBOStub();
			Listar params = new Listar();
			ListarResponse resp=  stub.listar(params);
			
			ProdutoTO[] array = resp.get_return();
			
			//Transformar o array em lista
			List<ProdutoTO> lista = Arrays.asList(array);
			
			for (ProdutoTO p : lista) {
				System.out.println(p.getNome());
				System.out.println(p.getPrecoUnitario());
				System.out.println(p.getQuantidade());
				System.out.println("===================");
				System.out.println("");
			}
			
			
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		
		
		
	}

}
