package br.edu.infnet.appcatalogo.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.appcatalogo.model.domain.Catalogo;
import br.edu.infnet.appcatalogo.model.test.AppCatalogo;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {
	
	private static Map<Integer, Catalogo> mapaCatalogo = new HashMap<>();
	private static Integer codigo = 1;
	
	public static void incluir(Catalogo catalogo) {
		
		catalogo.setCodigo(codigo++);
		mapaCatalogo.put(catalogo.getCodigo(), catalogo);
		AppCatalogo.relatorio("Inclusão do Catalogo " + catalogo.getNome()+" realizada com sucesso!", catalogo);
	}
	
	public static Collection<Catalogo> obterLista(){
		return mapaCatalogo.values();
	}
	
	public static void excluir(Integer id) {
		mapaCatalogo.remove(id);
	}
	
	@GetMapping("/list")
	public String catalogo(Model model) {
		model.addAttribute("listagem", obterLista());
		return "/catalogo/list";
	}
	
	@GetMapping("/{id}/delete")
	public String excluirDaTela(@PathVariable Integer id) {
		
		excluir(id);
		return "redirect:/catalogo/list";
	}
}
