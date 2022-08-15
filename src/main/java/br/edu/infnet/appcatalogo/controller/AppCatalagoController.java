package br.edu.infnet.appcatalogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppCatalagoController {

	@GetMapping(name="/")
	public String telaHome() {
		return "home";
	}
}
