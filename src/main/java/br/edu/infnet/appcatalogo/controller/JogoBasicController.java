package br.edu.infnet.appcatalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appcatalogo.model.domain.JogoBasic;
import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.service.JogoBasicService;

@Controller
@RequestMapping("/jogoBasic")
public class JogoBasicController {
	
	@Autowired
	JogoBasicService jogoBasicService;
		
	@GetMapping("/list")
	public String telaLista(Model model,@SessionAttribute("user") Usuario usuario) {	
		model.addAttribute("listagem", jogoBasicService.obterLista(usuario));
		return "/jogoBasic/list";
	}
	
	@GetMapping("/{id}/delete")
	public String excluirDaTela(@PathVariable Integer id) {
		
		jogoBasicService.excluir(id);
		return "redirect:/jogoBasic/list";
	}
	
	@GetMapping(value="/cadastro")
	public String telaCadastro() {
		return "/jogoBasic/cadastro";
	}
	
	@PostMapping(value ="/incluir")
	public String incluir (JogoBasic jogoBasic,@SessionAttribute("user") Usuario usuario) {
		
		jogoBasic.setUsuario(usuario);
		jogoBasicService.incluir(jogoBasic);
		return "redirect:/jogoBasic/list";
	} 
	
}
