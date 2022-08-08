package br.edu.infnet.appcatalogo.model.domain;

public class Catalogo {

	private Integer codigo;
	private String nome;
	private String descricao;
	
	

	public Catalogo(Integer codigo, String nome, String descricao) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
	}

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
