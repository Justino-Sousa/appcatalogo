package br.edu.infnet.appcatalogo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appcatalogo.model.domain.JogoPremium;
import br.edu.infnet.appcatalogo.model.test.AppCatalogo;

@Service
public class JogoPremiumService {

	private static Map<Integer, JogoPremium> mapaJogoPremium = new HashMap<>();
	private static Integer codigo = 1;

	public void incluir(JogoPremium jogo) {

		jogo.setCodigo(codigo++);
		mapaJogoPremium.put(jogo.getCodigo(), jogo);
		AppCatalogo.relatorio("Inclusão do jogo " + jogo.getNome() + " realizada com sucesso!", jogo);
	}

	public Collection<JogoPremium> obterLista() {
		return mapaJogoPremium.values();
	}

	public void excluir(Integer id) {
		mapaJogoPremium.remove(id);
	}
}
