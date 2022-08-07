package br.edu.infnet.appcatalogo.model.domain;

import java.math.BigDecimal;

public class Assinatura {

	private char tipoAssinatura;
	private Catalogo catalogo;
	private BigDecimal preco;

	public char getTipoAssinatura() {
		return tipoAssinatura;
	}

	public void setTipoAssinatura(char tipoAssinatura) {
		this.tipoAssinatura = tipoAssinatura;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Assinatura(char tipoAssinatura, Catalogo catalogo, BigDecimal preco) {

		this.tipoAssinatura = tipoAssinatura;
		this.catalogo = catalogo;
		this.preco = preco;
	}

	@Override
	public String toString() {
		return tipoAssinatura + ";" + catalogo + ";" + preco;
	}

}
