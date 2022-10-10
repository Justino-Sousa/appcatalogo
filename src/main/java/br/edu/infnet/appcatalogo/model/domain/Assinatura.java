package br.edu.infnet.appcatalogo.model.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.infnet.appcatalogo.interfaces.IPrinter;
import br.edu.infnet.appcatalogo.model.exceptions.PrecoInvalidoException;

@Entity
public class Assinatura implements IPrinter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String tipoAssinatura;
	private String nome;
	private BigDecimal preco;
	private LocalDate data;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;


	public Assinatura() {}


	public Assinatura(String tipoAssinatura, String nome, BigDecimal preco) throws PrecoInvalidoException {
		
		if(preco == null) {
			throw new PrecoInvalidoException("Assinatura precisa ter um preço");
		}

		this.tipoAssinatura = tipoAssinatura;
		this.nome = nome;
		this.preco = preco;
		this.data = LocalDate.now();
	}
	
	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getTipoAssinatura() {
		return tipoAssinatura;
	}


	public void setTipoAssinatura(String tipoAssinatura) {
		this.tipoAssinatura = tipoAssinatura;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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