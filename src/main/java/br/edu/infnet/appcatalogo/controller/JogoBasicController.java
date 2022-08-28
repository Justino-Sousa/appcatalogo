package br.edu.infnet.appcatalogo.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.appcatalogo.model.domain.JogoBasic;
import br.edu.infnet.appcatalogo.model.test.AppCatalogo;

@Controller
@RequestMapping("/jogoBasic")
public class JogoBasicController {
	
	private static Map<Integer, JogoBasic> mapaJogoBasic = new HashMap<>();
	private static Integer codigo = 1;
	
	public static void incluir(JogoBasic jogo) {
		
		jogo.setCodigo(codigo++);
		mapaJogoBasic.put(jogo.getCodigo(), jogo);
		AppCatalogo.relatorio("Inclusão do jogo " + jogo.getNome()+" realizada com sucesso!", jogo);
	}
	
	public static Collection<JogoBasic> obterLista(){
		return mapaJogoBasic.values();
	}
	
	public static void excluir(Integer id) {
		mapaJogoBasic.remove(id);
	}
	
	@GetMapping("/list")
	public String telaLista(Model model) {	
		model.addAttribute("listagem", obterLista());
		return "/jogoBasic/list";
	}
	
	@GetMapping("/{id}/delete")
	public String excluirDaTela(@PathVariable Integer id) {
		
		excluir(id);
		return "redirect:/jogoBasic/list";
	}
}
