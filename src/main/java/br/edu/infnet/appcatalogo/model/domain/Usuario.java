package br.edu.infnet.appcatalogo.model.domain;

import br.edu.infnet.appcatalogo.interfaces.IPrinter;

public class Usuario implements IPrinter {

	private String nome;
	private String email;
	private String senha;
	
	public Usuario(String nome,String email, String senha) {
		 this.nome = nome;
		 this.email = email;
		 this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return nome + ";" + email + ";" + senha;
	}

	@Override
	public void impressao() {
		System.out.println("#Usuario");
		System.out.println(this);
	}

}
