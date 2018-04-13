package br.com.fiap.jsf.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {

	private String nome ;
	private String senha ;
	
	public void validarLogin() {
		
		if (nome.equals("a") && senha.equals("a")) {
			System.out.println("Login concluido");
		}else {
			System.out.println("Login invalido");
		}

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
