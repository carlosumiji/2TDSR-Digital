package br.com.fiap.service;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.NotaBOStub;
import br.com.fiap.bo.NotaBOStub.CalcularPS;
import br.com.fiap.bo.NotaBOStub.CalcularPSResponse;

public class NotaService {

	private NotaBOStub stub;
	
	public NotaService() throws AxisFault {
		stub = new NotaBOStub();
	}
	
	public float cacularPs(float am, float nac) throws RemoteException {
		CalcularPS valores = new CalcularPS();
		valores.setAm(am);
		valores.setNac(nac);
		CalcularPSResponse resp = stub.calcularPS(valores);
		
		return resp.get_return();
	}
}
