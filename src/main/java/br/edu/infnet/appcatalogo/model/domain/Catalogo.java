package br.edu.infnet.appcatalogo.model.domain;

import java.util.Set;

import br.edu.infnet.appcatalogo.interfaces.IPrinter;

public class Catalogo implements IPrinter {

	private Integer codigo;
	private String nome;
	private String descricao;
	private Assinatura assinatura;
	private Set<Jogo> jogos;

	public Catalogo(Assinatura assinatura) {
		this.assinatura = assinatura;
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

	public Set<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(Set<Jogo> jogos) {
		this.jogos = jogos;
	}


	@Override
	public void impressao() {
		System.out.println("#Catalogo");
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return codigo + ";" + nome + ";" + descricao + ";" + assinatura + ";" + jogos.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		Catalogo other = (Catalogo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
}
