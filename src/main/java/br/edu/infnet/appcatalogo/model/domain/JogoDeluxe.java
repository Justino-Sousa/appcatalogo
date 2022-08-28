package br.edu.infnet.appcatalogo.model.domain;

import java.math.BigDecimal;

public class JogoDeluxe extends Jogo {

	private BigDecimal valor;
	private String desenvolvedor;
	private String genero;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(String desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public void impressao() {
		System.out.println("#JogoDeluxe");
		System.out.println(this);
	}

	@Override
	public Double calcularVendaAvulsa() {
		Double retorno = getCodigo() * valor.doubleValue() * 0.5;
		return retorno;
	}
	
	@Override
	public String toString() {
		return valor + ";" + desenvolvedor + ";" + genero + super.toString();
	}
}
