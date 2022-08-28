package br.edu.infnet.appcatalogo.model.domain;

import br.edu.infnet.appcatalogo.model.exceptions.GeneroNaoPodeSerNull;

public class JogoDeluxe extends Jogo {

	private static final Double taxaDeluxe = 2.5;
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
		System.out.println("#JogoDeluxe");
		System.out.println(this);
	}

	@Override
	public Double calcularVendaAvulsa() throws GeneroNaoPodeSerNull {
		
		if(getGenero() == null) {
			throw new GeneroNaoPodeSerNull("O Genero("+ getGenero() +") Não pode ser null");
		}
		
		return taxaDeluxe * getValor().doubleValue();
	}
	
	@Override
	public String toString() {
		return descricao + ";" + desenvolvedor + ";" + genero + super.toString();
	}
}
