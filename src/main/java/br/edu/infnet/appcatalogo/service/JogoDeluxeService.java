package br.edu.infnet.appcatalogo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appcatalogo.model.domain.JogoDeluxe;
import br.edu.infnet.appcatalogo.model.test.AppCatalogo;

@Service
public class JogoDeluxeService {
	
	private static Map<Integer, JogoDeluxe> mapaJogoDeluxe = new HashMap<>();
	private static Integer codigo = 1;
	
	public  void incluir(JogoDeluxe jogo) {
		
		jogo.setCodigo(codigo++);
		mapaJogoDeluxe.put(jogo.getCodigo(), jogo);
		AppCatalogo.relatorio("Inclusão do jogo " + jogo.getNome()+" realizada com sucesso!", jogo);
	}
	
	public  Collection<JogoDeluxe> obterLista(){
		return mapaJogoDeluxe.values();
	}
	
	public  void excluir(Integer id) {
		mapaJogoDeluxe.remove(id);
	}
}
