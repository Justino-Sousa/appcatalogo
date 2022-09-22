package br.edu.infnet.appcatalogo.model.domain.app;

import java.util.List;

import br.edu.infnet.appcatalogo.interfaces.IPrinter;

public class Projeto implements IPrinter{
	private String nome;
	private String descricao;
	private List<Classe> classes;
	
	public String getDescricao() {
		return descricao;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

	public void setDescricao(String descrição) {
		this.descricao = descrição;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public void impressao() {
		System.out.println("-"+nome+" | "+descricao);
		for (Classe c : classes) {
			c.impressao();
		}
	}
	
}
