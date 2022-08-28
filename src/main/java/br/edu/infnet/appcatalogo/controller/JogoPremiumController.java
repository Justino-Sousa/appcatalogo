package br.edu.infnet.appcatalogo.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.appcatalogo.model.domain.JogoPremium;
import br.edu.infnet.appcatalogo.model.test.AppCatalogo;

@Controller
@RequestMapping("/jogoPremium")
public class JogoPremiumController {

	private static Map<Integer, JogoPremium> mapaJogoPremium = new HashMap<>();
	private static Integer codigo = 1;
	
	public static void incluir(JogoPremium jogo) {
		
		jogo.setCodigo(codigo++);
		mapaJogoPremium.put(jogo.getCodigo(), jogo);
		AppCatalogo.relatorio("Inclusão do jogo " + jogo.getNome()+" realizada com sucesso!", jogo);
	}
	
	public static Collection<JogoPremium> obterLista(){
		return mapaJogoPremium.values();
	}
	
	public static void excluir(Integer id) {
		mapaJogoPremium.remove(id);
	}
	
	@GetMapping("/list")
	public String jogoPremium(Model model) {
		model.addAttribute("listagem", obterLista());
		return "/jogoPremium/list";
	}
	
	@GetMapping("/{id}/delete")
	public String excluirDaTela(@PathVariable Integer id) {
		
		excluir(id);
		return "redirect:/jogoPremium/list";
	}
}
