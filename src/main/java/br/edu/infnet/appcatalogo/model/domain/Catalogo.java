package br.edu.infnet.appcatalogo.model.domain;

public class Catalogo {
	
	public Integer codigo;
	public String nome;
	public String descricao;
	
	@Override
	public String toString() {
		return codigo + ";" + nome + ";" + descricao;
	}

}
