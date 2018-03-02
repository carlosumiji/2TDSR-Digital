package br.com.fiap.view;

import java.rmi.RemoteException;
import java.util.Scanner;

import org.apache.axis2.AxisFault;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class ConsoleView {

	public static void main(String[] args) {
		try {
			
		CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("CEP de Origem: ");
		String cepOrigem = sc.next()+sc.nextLine();
		
		System.out.println("CEP de Destino");
		String cepDestino = sc.next()+sc.nextLine(); 
		
		//Calcular o prazo
		//40010 Servico
		
		CalcPrazo parametros = new CalcPrazo();
		parametros.setSCepOrigem(cepOrigem);
		parametros.setSCepDestino(cepDestino);
		parametros.setNCdServico("40010");
		
		CalcPrazoResponse resposta = stub.calcPrazo(parametros);
		
		System.out.println("O prazo é: " + resposta.getCalcPrazoResult().getServicos().getCServico()[0].getPrazoEntrega());
		System.out.println("A data de entrega é: " + resposta.getCalcPrazoResult().getServicos().getCServico()[0].getDataMaxEntrega());
		
		sc.close();

		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
	}

}
