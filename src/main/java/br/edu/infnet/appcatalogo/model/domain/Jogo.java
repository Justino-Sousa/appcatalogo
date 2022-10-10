package br.edu.infnet.appcatalogo.model.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.edu.infnet.appcatalogo.interfaces.IPrinter;
import br.edu.infnet.appcatalogo.model.exceptions.GeneroNaoPodeSerNull;
import br.edu.infnet.appcatalogo.model.exceptions.ValorInvalidoException;
import br.edu.infnet.appcatalogo.model.exceptions.ValorZeradoException;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Jogo implements IPrinter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	private BigDecimal valor;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@ManyToMany(mappedBy = "jogos")
	private List<Catalogo> catalogos;

	public abstract Double calcularVendaAvulsa()
			throws ValorZeradoException, ValorInvalidoException, GeneroNaoPodeSerNull;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Catalogo> getCatalogos() {
		return catalogos;
	}

	public void setCatalogos(List<Catalogo> catalogos) {
		this.catalogos = catalogos;
	}

	@Override
	public String toString() {
		return codigo + ";" + nome + ";" + valor;
	}
}
