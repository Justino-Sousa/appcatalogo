package br.edu.infnet.appcatalogo;

import java.math.BigDecimal;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appcatalogo.controller.JogoBasicController;
import br.edu.infnet.appcatalogo.model.domain.JogoBasic;

@Component
@Order(4)
public class JogoBasicTeste implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		//Inicio do catalogo		
		System.out.println("### Jogo Basic início ####"+"\r\n");		
		
		JogoBasic jb1 = new JogoBasic();
		jb1.setValor(new BigDecimal(150.00));
		jb1.setDescricao("Jogos da memoria");
		jb1.setGenero("estratégia");
		jb1.setDesenvolvedor("SONY");
		jb1.setNome("Memory game");
		JogoBasicController.incluir(jb1);
		
		JogoBasic jb2 = new JogoBasic();
		jb2.setValor(new BigDecimal(100.00));
		jb2.setDescricao("Bilhar online");
		jb2.setGenero("Diversão");
		jb2.setDesenvolvedor("Santa monica");
		jb2.setNome("Bilhar2");
		JogoBasicController.incluir(jb2);
		
		JogoBasic jb3 = new JogoBasic();
		jb3.setValor(new BigDecimal(130.00)); 
		jb3.setDescricao("Gamão online");
		jb3.setGenero("Diversão");
		jb3.setDesenvolvedor("Division");
		jb3.setNome("Super Gamão");
		JogoBasicController.incluir(jb3);

		//Fim do catalogo		
		System.out.println("\r\n"+"### Jogo Basic Fim ####"+"\r\n");
		
	}
}
