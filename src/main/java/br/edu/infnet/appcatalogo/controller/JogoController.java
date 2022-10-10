package br.edu.infnet.appcatalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.service.JogoService;

@Controller
@RequestMapping("/jogo")
public class JogoController {
	
	@Autowired
	JogoService jogoService;
	
	@GetMapping("/list")
	public String telaLista(Model model,@SessionAttribute("user") Usuario usuario) {	
		model.addAttribute("listagem", jogoService.obterLista(usuario));
		return "/jogo/list";
	}
	
	@GetMapping("/{id}/delete")
	public String excluirDaTela(@PathVariable Integer id) {
		
		jogoService.excluir(id);
		return "redirect:/jogo/list";
	}

}
