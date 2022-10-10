package br.edu.infnet.appcatalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appcatalogo.model.domain.Assinatura;
import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.model.exceptions.PrecoInvalidoException;
import br.edu.infnet.appcatalogo.service.AssinaService;

@Controller
@RequestMapping("/assinatura")
public class AssinaController {
	

	@Autowired
	AssinaService assinaService;
	
	@GetMapping("/list")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("listagem", assinaService.obterLista(usuario));
		return "/assinatura/list";
	}
	
	@GetMapping("/{id}/delete")
	public String excluirDaTela(@PathVariable Integer id) {
		
		assinaService.excluir(id);
		return "redirect:/assinatura/list";
	}

	@GetMapping(value="/cadastro")
	public String telaCadastro() {
		return "/assinatura/cadastro";
	}
	
	@PostMapping(value ="/incluir")
	public String incluir (Assinatura assinatura, @SessionAttribute("user") Usuario usuario) {
		
		try {
			Assinatura assinatura2 = new Assinatura(assinatura.getTipoAssinatura(), assinatura.getNome(), assinatura.getPreco());
			assinatura2.setUsuario(usuario);
			assinaService.incluir(assinatura2);
		} catch (PrecoInvalidoException e) {
			e.printStackTrace();
		}
	
		return "redirect:/assinatura/list";
	} 
	
	
}	
