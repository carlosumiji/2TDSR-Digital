package br.com.fiap.view;

import java.rmi.RemoteException;
import java.util.Scanner;

import br.com.fiap.bo.NotaBOStub;
import br.com.fiap.bo.NotaBOStub.CalcularMediaResponse;
import br.com.fiap.bo.NotaBOStub.CalcularPS;
import br.com.fiap.bo.NotaBOStub.CalcularPSResponse;

public class PsView {

	public static void main(String[] args) {
		try {
			NotaBOStub stub = new NotaBOStub();
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Digite a nota de NAC: ");
			float nac = sc.nextFloat();
			System.out.println("Digite a nota de AM");
			float am = sc.nextFloat();
			
			CalcularPS parametros = new CalcularPS();
			parametros.setNac(nac);
			parametros.setAm(am);
			
			CalcularPSResponse resposta = stub.calcularPS(parametros);
			
			System.out.println("vc precisar tirar " + resposta.get_return() + " na ps");
			sc.close();
			
			} catch (RemoteException e) {
				
				e.printStackTrace();
			}
			
			
	}

}
