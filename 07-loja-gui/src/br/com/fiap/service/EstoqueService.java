package br.com.fiap.service;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import br.com.fiap.inventario.EstoqueBOStub;
import br.com.fiap.inventario.EstoqueBOStub.ConsultaProduto;
import br.com.fiap.inventario.EstoqueBOStub.ConsultaProdutoResponse;
import br.com.fiap.inventario.EstoqueBOStub.ProdutoTO;

public class EstoqueService {

	private EstoqueBOStub stub; 
	
	public EstoqueService() throws AxisFault {
		stub = new EstoqueBOStub();
	}
	
	public ProdutoTO consultaProduto(int codigo) throws RemoteException{

		ConsultaProduto params = new ConsultaProduto();
		
		ConsultaProdutoResponse resp = stub.consultaProduto(params);
		
		return resp.get_return();
	
	}
}
