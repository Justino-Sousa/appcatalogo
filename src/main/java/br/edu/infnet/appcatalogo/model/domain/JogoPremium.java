package br.edu.infnet.appcatalogo.model.domain;

import br.edu.infnet.appcatalogo.model.exceptions.ValorInvalidoException;

public class JogoPremium extends Jogo {

	private static final Double taxaPremium = 2.0;
	private String descricao;
	private String desenvolvedor;
	private String genero;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		System.out.println("#JogoPremium");
		System.out.println(this);
	}

	@Override
	public Double calcularVendaAvulsa() throws ValorInvalidoException {
		
		if(getValor().doubleValue() < 150.00) {
			throw new ValorInvalidoException("Valor de um jogo Premium("+ getValor() +") não pode ser menor que 150.");
		}
		return taxaPremium * getValor().doubleValue();
	}

	@Override
	public String toString() {
		return descricao + ";" + desenvolvedor + ";" + genero + super.toString();
	}

}
