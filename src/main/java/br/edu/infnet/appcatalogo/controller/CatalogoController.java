package br.edu.infnet.appcatalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.appcatalogo.service.CatalogoService;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {
	
	
	@Autowired
	CatalogoService catalogoService;	
	
	@GetMapping("/list")
	public String catalogo(Model model) {
		model.addAttribute("listagem", catalogoService.obterLista());
		return "/catalogo/list";
	}
	
	@GetMapping("/{id}/delete")
	public String excluirDaTela(@PathVariable Integer id) {
		
		catalogoService.excluir(id);
		return "redirect:/catalogo/list";
	}
}
