package br.edu.infnet.appcatalogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {
	@GetMapping("/list")
	public String catalogo() {
		return "/catalogo/list";
	}
}
