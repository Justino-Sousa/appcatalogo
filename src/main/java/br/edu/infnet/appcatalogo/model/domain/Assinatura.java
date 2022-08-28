package br.edu.infnet.appcatalogo.model.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.edu.infnet.appcatalogo.interfaces.IPrinter;

public class Assinatura implements IPrinter {

	private Integer codigo;
	private char tipoAssinatura;
	private String nome;
	private BigDecimal preco;
	private LocalDate data;

	public Assinatura(char tipoAssinatura, String nome, BigDecimal preco) {

		this.tipoAssinatura = tipoAssinatura;
		this.nome = nome;
		this.preco = preco;
		this.data = LocalDate.now();
	}

	public String getNome() {
		return nome;
	}
	
	public char getTipoAssinatura() {
		return tipoAssinatura;
	}
	
	public String getPreco() {
		return preco.toString();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return tipoAssinatura + ";" + nome + ";" + preco + data;
	}

	@Override
	public void impressao() {
		System.out.println("#Assinatura");
		System.out.println(this);
	}

}
