package br.edu.infnet.appcatalogo.model.domain;

import java.math.BigDecimal;

public class JogoPremium extends Jogo {

	private BigDecimal valor;
	private String descricao;
	private String genero;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return valor + ";" + descricao + ";" + genero + super.toString();
	}
}
