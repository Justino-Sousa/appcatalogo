package br.edu.infnet.appcatalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.appcatalogo.service.JogoBasicService;

@Controller
@RequestMapping("/jogoBasic")
public class JogoBasicController {
	
	@Autowired
	JogoBasicService jogoBasicService;
		
	@GetMapping("/list")
	public String telaLista(Model model) {	
		model.addAttribute("listagem", jogoBasicService.obterLista());
		return "/jogoBasic/list";
	}
	
	@GetMapping("/{id}/delete")
	public String excluirDaTela(@PathVariable Integer id) {
		
		jogoBasicService.excluir(id);
		return "redirect:/jogoBasic/list";
	}
}
