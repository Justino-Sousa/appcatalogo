package br.edu.infnet.appcatalogo.service;

import org.springframework.stereotype.Service;

import br.edu.infnet.appcatalogo.model.domain.app.Projeto;
import br.edu.infnet.appcatalogo.model.test.AppCatalogo;

@Service
public class AppService {
	private Projeto projeto;
	
	public void incluir(Projeto projeto) {
		this.projeto = projeto;
		AppCatalogo.relatorio("Exibição do Projeto " + projeto.getNome() + " realizada com sucesso!", projeto);
	}
	
	public Projeto obterProjeto() {
		return projeto;
	}

}
