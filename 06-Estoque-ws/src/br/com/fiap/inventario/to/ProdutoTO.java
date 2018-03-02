package br.com.fiap.inventario.to;

public class ProdutoTO {

	private int codigo;
	private String nome;
	private int precoUnitario ;
	private int quantidade ;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(int precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public ProdutoTO(int codigo, String nome, int precoUnitario, int quantidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.quantidade = quantidade;
	}
	public ProdutoTO() {
		super();
		
	}
	
	public String buscarProduto(String codProduto) {
		return codProduto;
	}
	
	
	
}
