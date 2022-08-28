package br.edu.infnet.appcatalogo.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.appcatalogo.model.domain.Assinatura;
import br.edu.infnet.appcatalogo.model.test.AppCatalogo;

@Controller
@RequestMapping("/assinatura")
public class AssinaController {
	
	private static Map<Integer, Assinatura> mapaAssinatura = new HashMap<>();
	private static Integer codigo = 1;
	
	public static void incluir(Assinatura assinatura) {
		
		assinatura.setCodigo(codigo++);
		mapaAssinatura.put(assinatura.getCodigo(), assinatura);
		AppCatalogo.relatorio("Inclusão da Assinatura " + assinatura.getNome()+" realizada com sucesso!", assinatura);
	}
	
	public static Collection<Assinatura> obterLista(){
		return mapaAssinatura.values();
	}
	
	public static void excluir(Integer id) {
		mapaAssinatura.remove(id);
	}
	
	@GetMapping("/list")
	public String assinaturas(Model model) {
		
		model.addAttribute("listagem", obterLista());
		return "/assinatura/list";
	}
	
	@GetMapping("/{id}/delete")
	public String excluirDaTela(@PathVariable Integer id) {
		
		excluir(id);
		return "redirect:/assinatura/list";
	}
}	
