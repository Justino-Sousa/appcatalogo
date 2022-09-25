package br.edu.infnet.appcatalogo.model.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.infnet.appcatalogo.interfaces.IPrinter;
import br.edu.infnet.appcatalogo.model.exceptions.AssinaturaNullException;
import br.edu.infnet.appcatalogo.model.exceptions.CatalogoSemJogosException;

@Entity
public class Catalogo implements IPrinter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	private String descricao;
	private Assinatura assinatura;
	private Set<Jogo> jogos;

	public Catalogo(Assinatura assinatura, Set<Jogo> jogos) throws AssinaturaNullException, CatalogoSemJogosException{
		
//		if(assinatura == null) {
//			throw new AssinaturaNullException("Impossivel criar um catalogo sem assinatura!");
//		}
//		if(jogos.size() < 1) {
//			throw new CatalogoSemJogosException("Impossivel criar um catalogo sem jogos!");
//		}
		
		this.assinatura = assinatura;
		this.jogos = jogos;
	}

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public Assinatura getAssinatura() {
		return assinatura;
	}
	
	public void setAssinatura(Assinatura assinatura) {
		this.assinatura = assinatura;
	}

	@Override
	public void impressao() {
		System.out.println("#Catalogo");
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return codigo + ";" + nome + ";" + descricao + ";" + assinatura + ";" + jogos.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		Catalogo other = (Catalogo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
}
