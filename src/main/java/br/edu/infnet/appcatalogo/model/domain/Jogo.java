package br.edu.infnet.appcatalogo.model.domain;

public class Jogo {

	private Integer codigo;
	private String nome;
	private String descricao;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return codigo + ";" + nome + ";" + descricao;
	}
}
