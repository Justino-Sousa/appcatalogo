package br.edu.infnet.appcatalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appcatalogo.model.domain.JogoPremium;
import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.service.JogoPremiumService;

@Controller
@RequestMapping("/jogoPremium")
public class JogoPremiumController {
	
	@Autowired
	JogoPremiumService jogoPremiumService;

	@GetMapping("/list")
	public String jogoPremium(Model model,@SessionAttribute("user") Usuario usuario) {
		model.addAttribute("listagem", jogoPremiumService.obterLista(usuario));
		return "/jogoPremium/list";
	}

	@GetMapping("/{id}/delete")
	public String excluirDaTela(@PathVariable Integer id) {

		jogoPremiumService.excluir(id);
		return "redirect:/jogoPremium/list";
	}
	
	
	@GetMapping(value="/cadastro")
	public String telaCadastro() {
		return "/jogoPremium/cadastro";
	}
	
	@PostMapping(value ="/incluir")
	public String incluir (JogoPremium jogoPremium,@SessionAttribute("user") Usuario usuario) {
		
		jogoPremium.setUsuario(usuario);
		jogoPremiumService.incluir(jogoPremium);
		return "redirect:/jogoPremium/list";
	} 
}
