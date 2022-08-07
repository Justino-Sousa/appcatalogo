package br.edu.infnet.appcatalogo.model.domain;

import java.math.BigDecimal;


public class Assinatura {
	
	public char tipoAssinatura;
	public Catalogo catalogo;
	public BigDecimal preco;
	
	@Override
	public String toString() {
		return tipoAssinatura + ";" + catalogo + ";" + preco;
	}

}
