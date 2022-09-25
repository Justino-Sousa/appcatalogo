package br.edu.infnet.appcatalogo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appcatalogo.model.domain.Jogo;

@Service
public class JogoService {

	@Autowired
	private JogoBasicService jogoBasicService;

	@Autowired
	private JogoPremiumService jogoPremiumService;

	@Autowired
	private JogoDeluxeService jogoDeluxeService;

	public List<Jogo> obterLista() {
		
		List<Jogo> jogos = new ArrayList<Jogo>();
		
		jogos.addAll(jogoBasicService.obterLista());
		jogos.addAll(jogoPremiumService.obterLista());
		jogos.addAll(jogoDeluxeService.obterLista());
		
		return jogos;
		
	}
	
}
