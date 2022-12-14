package br.edu.infnet.appcatalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appcatalogo.model.domain.JogoDeluxe;
import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.service.JogoDeluxeService;

@Controller
@RequestMapping("/jogoDeluxe")
public class JogoDeluxeController {
	
	@Autowired
	JogoDeluxeService jogoDeluxeService;
	
	@GetMapping("/list")
	public String jogoDeluxe(Model model,@SessionAttribute("user") Usuario usuario) {
		model.addAttribute("listagem", jogoDeluxeService.obterLista(usuario));
		return "/jogoDeluxe/list";
	}
	
	@GetMapping("/{id}/delete")
	public String excluirDaTela(@PathVariable Integer id) {
		
		jogoDeluxeService.excluir(id);
		return "redirect:/jogoDeluxe/list";
	}
	
	
	@GetMapping(value="/cadastro")
	public String telaCadastro() {
		return "/jogoDeluxe/cadastro";
	}
	
	@PostMapping(value ="/incluir")
	public String incluir (JogoDeluxe jogoDeluxe,@SessionAttribute("user") Usuario usuario) {
		jogoDeluxe.setUsuario(usuario);
		jogoDeluxeService.incluir(jogoDeluxe);
		return "redirect:/jogoDeluxe/list";
	} 
}
