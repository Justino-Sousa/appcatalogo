package br.edu.infnet.appcatalogo.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.model.test.AppCatalogo;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private static Map<String, Usuario> mapaUsuario = new HashMap<>();
	
	public static void incluir(Usuario usuario) {
		
		mapaUsuario.put(usuario.getEmail(), usuario);
		AppCatalogo.relatorio("Inclusão da Usuário " + usuario.getNome()+" realizada com sucesso!", usuario);
	}
	
	public static Collection<Usuario> obterLista(){
		return mapaUsuario.values();
	}
	
	public static Usuario validar(String email,String senha) {
		
		Usuario usuario = mapaUsuario.get(email);
		
		if(usuario != null && senha.equals(usuario.getSenha())) {
			return usuario;
		}
		return null;
	}
	
	public static void excluir(String email) {
		mapaUsuario.remove(email);
	}
	
	@GetMapping("/list")
	public String usuarios(Model model) {
		
		model.addAttribute("listagem", obterLista());
		return "/usuario/list";
	}
	
	@GetMapping("/{email}/delete")
	public String excluirDaTela(@PathVariable String email) {
		
		excluir(email);
		return "redirect:/usuario/list";
	}
	

	@GetMapping(value="/cadastro")
	public String telaCadastro() {
		
		return "/usuario/cadastro";
	}
	
	@PostMapping(value="incluir")
	public String inclusao(Usuario usuario) {
	
		incluir(usuario);
		return "redirect:/";
	}
	
}	
