package br.edu.infnet.appcatalogo.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.appcatalogo.model.domain.JogoDeluxe;
import br.edu.infnet.appcatalogo.model.test.AppCatalogo;

@Controller
@RequestMapping("/jogoDeluxe")
public class JogoDeluxeController {

	private static Map<Integer, JogoDeluxe> mapaJogoDeluxe = new HashMap<>();
	private static Integer codigo = 1;
	
	public static void incluir(JogoDeluxe jogo) {
		
		jogo.setCodigo(codigo++);
		mapaJogoDeluxe.put(jogo.getCodigo(), jogo);
		AppCatalogo.relatorio("Inclusão do jogo " + jogo.getNome()+" realizada com sucesso!", jogo);
	}
	
	public static Collection<JogoDeluxe> obterLista(){
		return mapaJogoDeluxe.values();
	}
	
	public static void excluir(Integer id) {
		mapaJogoDeluxe.remove(id);
	}

	@GetMapping("/list")
	public String jogoDeluxe(Model model) {
		model.addAttribute("listagem", obterLista());
		return "/jogoDeluxe/list";
	}
	
	@GetMapping("/{id}/delete")
	public String excluirDaTela(@PathVariable Integer id) {
		
		excluir(id);
		return "redirect:/jogoDeluxe/list";
	}
}
