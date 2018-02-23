package br.com.fiap.loja.view;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import br.com.fiap.loja.bo.EstoqueBO;
import br.com.fiap.loja.singleton.PropertySingleton;
import br.com.fiap.to.ProdutoTO;

public class TerminalConsulta {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		EstoqueBO bo = new EstoqueBO();
		DecimalFormat df = new DecimalFormat("R$ ##,###.00");

		Calendar hoje = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String nome = PropertySingleton.getInstance().getProperty("nome");

		System.out.println( nome+"        " + sdf.format(hoje.getTime()));
		System.out.println("**********************");
		int codigo ;

		do {
			System.out.print("Código do produto: ");
			codigo = sc.nextInt();// ler código

			if(codigo != 0) {
				ProdutoTO prod = bo.consultaProduto(codigo);

				if(prod != null) {
					System.out.println(prod.getNome());
					System.out.println(df.format(prod.getPrecoUnitario()));
					System.out.println(prod.getQuantidade());
				}else {
					System.out.println("Produto não cadastrado");
				}
			}

		}while(codigo != 0 );
		System.out.println("Fim da aplicação");
		sc.close();

	}

}
