package br.edu.infnet.appcatalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.appcatalogo.model.domain.Assinatura;
import br.edu.infnet.appcatalogo.model.domain.Catalogo;
import br.edu.infnet.appcatalogo.service.AssinaService;
import br.edu.infnet.appcatalogo.service.CatalogoService;
import br.edu.infnet.appcatalogo.service.JogoService;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {
	
	
	@Autowired
	CatalogoService catalogoService;
	
	@Autowired
	AssinaService assinaService;
	
	@Autowired
	JogoService jogoService;
	
	@GetMapping("/list")
	public String telaCatalogo(Model model) {
		model.addAttribute("listagem", catalogoService.obterLista());
		return "/catalogo/list";
	}
	
	@GetMapping("/{id}/delete")
	public String excluirDaTela(@PathVariable Integer id) {
		
		catalogoService.excluir(id);
		return "redirect:/catalogo/list";
	}
	
	@GetMapping(value="/cadastro")
	public String telaCadastro(Model model) {
		model.addAttribute("listagem", assinaService.obterLista());
		model.addAttribute("jogos", jogoService.obterLista());
		return "/catalogo/cadastro";
	}
	
	@PostMapping(value ="/incluir")
	public String incluir (Catalogo catalogo, @RequestParam String tipoAssinatura) {
		
		Assinatura a = assinaService.getAssinaByTipo(tipoAssinatura);
		catalogo.setAssinatura(a);
		catalogoService.incluir(catalogo);
		return "redirect:/catalogo/list";
	} 
}
