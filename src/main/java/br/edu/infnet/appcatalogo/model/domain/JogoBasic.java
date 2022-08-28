package br.edu.infnet.appcatalogo.model.domain;

import br.edu.infnet.appcatalogo.model.exceptions.ValorZeradoException;

public class JogoBasic extends Jogo {

	private static final Double taxaBasic = 1.5;
	private String desenvolvedor;
	private String genero;
	private String descricao;

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
		System.out.println("#JogoBasic");
		System.out.println(this);
	}

	@Override
	public Double calcularVendaAvulsa() throws ValorZeradoException {
		
		if(getValor().doubleValue() == 0) {
			throw new ValorZeradoException("Valor de um jogo basic("+ getValor() +") 0.");
		}
		
		return taxaBasic * getValor().doubleValue();
	}
	 
	@Override
	public String toString() {
		return descricao + ";" + desenvolvedor + ";" + genero + super.toString();
	}

}
