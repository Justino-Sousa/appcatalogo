package br.edu.infnet.appcatalogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/assinatura")
public class AssinaController {
	
	@GetMapping("/list")
	public String assinaturas() {
		return "/assinatura/list";
	}
}	
