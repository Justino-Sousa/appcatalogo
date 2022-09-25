package br.edu.infnet.appcatalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.appcatalogo.model.domain.Assinatura;
import br.edu.infnet.appcatalogo.service.AssinaService;

@Controller
@RequestMapping("/assinatura")
public class AssinaController {
	

	@Autowired
	AssinaService assinaService;
	
	@GetMapping("/list")
	public String telaLista(Model model) {
		
		model.addAttribute("listagem", assinaService.obterLista());
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
	public String incluir (Assinatura assinatura) {
		
		assinaService.incluir(assinatura);
		return "redirect:/assinatura/list";
	} 
	
	
}	
