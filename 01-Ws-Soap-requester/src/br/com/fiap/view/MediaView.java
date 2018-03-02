package br.com.fiap.view;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.NotaBOStub;
import br.com.fiap.bo.NotaBOStub.CalcularMedia;
import br.com.fiap.bo.NotaBOStub.CalcularMediaResponse;

public class MediaView {

	public static void main(String[] args) {
		try {
			NotaBOStub stub = new NotaBOStub();
			//Valores para enviar para oweb service
			CalcularMedia parametros = new CalcularMedia();
			parametros.setAm(7);
			parametros.setNac(10);
			parametros.setPs(1);
			
			//chama o ws e recupera o retorno
			CalcularMediaResponse resp = stub.calcularMedia(parametros);
			
			//Exibir nota
			System.out.println(resp.get_return());
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

}
