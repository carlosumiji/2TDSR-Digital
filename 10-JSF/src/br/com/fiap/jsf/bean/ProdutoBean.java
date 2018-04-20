package br.com.fiap.jsf.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;// import correto
import javax.faces.context.FacesContext;

import br.com.fiap.ws.service.ProdutoService;
import br.com.fiap.ws.to.Produto;

@ManagedBean
public class ProdutoBean {

	private Produto produto;
	
	private ProdutoService service;
	
	//metodo que é acionado quando a tela é criada
	@PostConstruct
	private void init() {
		produto = new Produto();
		service = new ProdutoService();
	}
	
	//metodo para o clique do botao excluir
	public void excluir(int codigo) {
		FacesMessage msg;
		try {
			service.remover(codigo);
			msg = new FacesMessage("Removido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao remover");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	

	//metodo para enviar a lista de produto pata a tela
	public List<Produto> getProdutos(){
		try {
			return service.listar();
		} catch (Exception e) {
			return null;
		}
	}
	
	//Método para o clique do botãoSalvar
	public String salvar() {
		FacesMessage msg; //Mensagem para a tela
		try {
			//verificar se deve cadastrar ou atulizar
			if(produto.getCodigo() == 0) {
				service.cadastrar(produto);
				msg = new FacesMessage("Cadastro com sucesso!");
			}else {
				service.atualizar(produto);
				msg = new FacesMessage("Atulizado com sucesso!");
				return "lista-produtos";//retorna para a listagem,
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao cadastrar, tente novamente");
		}
		//adcicionar a mensagem para a tela 
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "produto";
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
