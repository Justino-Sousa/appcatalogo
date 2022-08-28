package br.edu.infnet.appcatalogo.model.domain;

import java.math.BigDecimal;

import br.edu.infnet.appcatalogo.interfaces.IPrinter;
import br.edu.infnet.appcatalogo.model.exceptions.GeneroNaoPodeSerNull;
import br.edu.infnet.appcatalogo.model.exceptions.ValorInvalidoException;
import br.edu.infnet.appcatalogo.model.exceptions.ValorZeradoException;

public abstract class Jogo implements IPrinter {

	private Integer codigo;
	private String nome;
	private BigDecimal valor;
	
	public abstract Double calcularVendaAvulsa() throws ValorZeradoException, ValorInvalidoException, GeneroNaoPodeSerNull;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return codigo + ";" + nome + ";" + valor;
	}
}
