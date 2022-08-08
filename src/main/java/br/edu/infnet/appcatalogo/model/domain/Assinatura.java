package br.edu.infnet.appcatalogo.model.domain;

import java.math.BigDecimal;


public class Assinatura {
	
	public char tipoAssinatura;
	public Catalogo catalogo;
	public BigDecimal preco;
	
	
	public Assinatura(char tipoAssinatura,Catalogo catalogo, BigDecimal preco) {
		
		this.tipoAssinatura = tipoAssinatura;
		this.catalogo = catalogo;
		this.preco = preco;
	}
	
	
	@Override
	public String toString() {
		return tipoAssinatura + ";" + catalogo + ";" + preco;
	}

}
