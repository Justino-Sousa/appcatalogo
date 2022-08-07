package br.edu.infnet.appcatalogo.model.domain;

public class Jogo {
	
	public Integer codigo;
	public String nome;
	public String descricao;
	
	
	@Override
	public String toString() {
		return codigo + ";" + nome + ";" + descricao;
	}
}
