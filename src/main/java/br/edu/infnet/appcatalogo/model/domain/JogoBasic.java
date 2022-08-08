package br.edu.infnet.appcatalogo.model.domain;

import java.math.BigDecimal;

public class JogoBasic {

	public BigDecimal valor;
	public String descricao;
	public String genero;

	@Override
	public String toString() {
		return valor + ";" + descricao + ";" + genero;
	}
}
