package br.edu.infnet.appcatalogo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appcatalogo.model.domain.JogoBasic;
import br.edu.infnet.appcatalogo.model.test.AppCatalogo;

@Service
public class JogoBasicService {
	
	private static Map<Integer, JogoBasic> mapaJogoBasic = new HashMap<>();
	private static Integer codigo = 1;

	public  void incluir(JogoBasic jogo) {

		jogo.setCodigo(codigo++);
		mapaJogoBasic.put(jogo.getCodigo(), jogo);
		AppCatalogo.relatorio("Inclusão do jogo " + jogo.getNome() + " realizada com sucesso!", jogo);
	}

	public  Collection<JogoBasic> obterLista() {
		return mapaJogoBasic.values();
	}

	public  void excluir(Integer id) {
		mapaJogoBasic.remove(id);
	}
}
