package br.edu.infnet.appcatalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/list")
	public String usuarios(Model model) {
		
		model.addAttribute("listagem",usuarioService.obterLista());
		return "/usuario/list";
	}
	
	@GetMapping("/{email}/delete")
	public String excluirDaTela(@PathVariable String email) {
		
		usuarioService.excluir(email);
		return "redirect:/usuario/list";
	}
	

	@GetMapping(value="/cadastro")
	public String telaCadastro() {
		
		return "/usuario/cadastro";
	}
	
	@PostMapping(value="incluir")
	public String inclusao(Usuario usuario) {
	
		usuarioService.incluir(usuario);
		return "redirect:/";
	}
	
}	
