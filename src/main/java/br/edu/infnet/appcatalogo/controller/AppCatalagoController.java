package br.edu.infnet.appcatalogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.appcatalogo.model.domain.Usuario;

@Controller
@RequestMapping("/")
public class AppCatalagoController {

	@GetMapping(value="/")
	public String telaHome() {
		return "home";
	}
	
	@GetMapping(value="login")
	public String telaLogin() {
		return "login";
	}
	
	@PostMapping(value="/login")
	public String login(Model model,@RequestParam String email,@RequestParam String senha) {

		Usuario usuario = UsuarioController.validar(email, senha);
		
		if(usuario != null) {
			
			model.addAttribute("user",usuario.getNome());
			return "home";
		}
		return "redirect:/login";

	}
	
	@GetMapping(value="logout")
	public String logout(Model model) {
		
		model.addAttribute("user","");
		return "redirect: /";
	}
	
	
}
