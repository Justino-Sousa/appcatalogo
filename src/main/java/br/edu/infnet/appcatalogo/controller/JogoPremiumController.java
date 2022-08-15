package br.edu.infnet.appcatalogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jogoPremium")
public class JogoPremiumController {

	@GetMapping("/list")
	public String jogoPremium() {
		return "/jogoPremium/list";
	}
}
