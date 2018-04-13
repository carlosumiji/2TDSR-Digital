package br.com.fiap.ws.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ws.to.Produto;

public class ProdutoService {

	private Client client = Client.create();
	private static final String URL = "http://10.20.72.16:8080/07-WS-Restful-Server/rest/produto/";
	
	public void remover(int codigo) throws Exception {
		WebResource w = client.resource(URL)
				.path(String.valueOf(codigo));
		
		ClientResponse response = w.delete(ClientResponse.class);
		
		//204 - No Content
		if(response.getStatus() != 204) {
			throw new Exception("Erro: " + response.getStatus());
		}
	}
	
	public void atualizar(Produto produto) throws Exception {
		WebResource w = client.resource(URL)
				.path(String.valueOf(produto.getCodigo()));
		
		ClientResponse response = w
				//Tipo de dados (JSON)
				.type(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class,produto);
		
		//status 200 OK
		if(response.getStatus() != 200) {
			throw new Exception("Erro " + response.getStatus());
		}
	}
	
	public void cadastrar(Produto produto) throws Exception {
		WebResource w = client.resource(URL);
		ClientResponse response = w
				//tipo de dados que serao enviados
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class,produto);
		if(response.getStatus() != 201) {
			throw new Exception("Erro " + response.getStatus());
		}
				
	}
	
	
	public List<Produto> listar() throws Exception{
		WebResource w = client.resource(URL);
				
		ClientResponse response = 
				w.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		if(response.getStatus() != 200) {
			throw new Exception("Erro 0" + response.getStatus());
		}
				
		return Arrays.asList(response.getEntity(Produto[].class));
	}
	
	public Produto pesquisar (int codigo) throws Exception {
		//Cria a URL com o c�digo no final
		WebResource w = client.resource (URL).path(String.valueOf(codigo));
		//Chama o WebService
		ClientResponse response = w
				//Recepe JSON
				.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if(response.getStatus() != 200) {
			throw new Exception("Erro " + response.getStatus());
		}
		//Retorna o produto encontrado
		return response.getEntity(Produto.class);
	}
	
}
