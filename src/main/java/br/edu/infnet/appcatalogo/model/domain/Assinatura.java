package br.edu.infnet.appcatalogo.model.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.infnet.appcatalogo.interfaces.IPrinter;
import br.edu.infnet.appcatalogo.model.exceptions.PrecoInvalidoException;

@Entity
public class Assinatura implements IPrinter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private Character tipoAssinatura;
	private String nome;
	private BigDecimal preco;
	private LocalDate data;

	public Assinatura(char tipoAssinatura, String nome, BigDecimal preco) throws PrecoInvalidoException {
		
		if(preco == null) {
			throw new PrecoInvalidoException("Assinatura precisa ter um preço");
		}

		this.tipoAssinatura = tipoAssinatura;
		this.nome = nome;
		this.preco = preco;
		this.data = LocalDate.now();
	}

	public String getNome() {
		return nome;
	}
	
	public Character getTipoAssinatura() {
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