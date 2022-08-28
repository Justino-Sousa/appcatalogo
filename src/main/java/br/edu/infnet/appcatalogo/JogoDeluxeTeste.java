package br.edu.infnet.appcatalogo;

import java.math.BigDecimal;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appcatalogo.controller.JogoDeluxeController;
import br.edu.infnet.appcatalogo.model.domain.JogoDeluxe;

@Component
@Order(6)
public class JogoDeluxeTeste implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		//Inicio do catalogo		
		System.out.println("### Jogo Deluxe início ####"+"\r\n");
		
		JogoDeluxe jd1 = new JogoDeluxe();
		jd1.setValor(new BigDecimal(300));
		jd1.setDescricao("The Last of Us é um jogo eletrônico de ação-aventura e sobrevivência desenvolvido pela Naughty Dog e publicado pela Sony Computer Entertainment."); 
		jd1.setGenero("Ação e aventura/Survival horror");
		jd1.setCodigo(7);
		jd1.setDesenvolvedor("Naughty Dog");
		jd1.setNome("The Last of Us");
		JogoDeluxeController.incluir(jd1);
		
		JogoDeluxe jd2= new JogoDeluxe();
		jd2.setValor(new BigDecimal(300));
		jd2.setDescricao("God of War Ragnarök é um futuro jogo eletrônico de ação-aventura desenvolvido pela Santa Monica Studio e publicado pela Sony Interactive Entertainment. Está programado para ser lançado em 9 de novembro de 2022 para PlayStation 4 e PlayStation 5.");
		jd2.setGenero("Ação e aventura/luta/hack and slash");
		jd2.setCodigo(8);
		jd2.setDesenvolvedor("Santa monica");
		jd2.setNome("God of War Ragnarök");
		JogoDeluxeController.incluir(jd2);
		
		JogoDeluxe jd3 = new JogoDeluxe();
		jd3.setValor(new BigDecimal(350));
		jd3.setDescricao("FIFA 22 é um jogo eletrônico de simulação de futebol desenvolvido e publicado pela Electronic Arts.");
		jd3.setGenero("Esportes");
		jd3.setCodigo(9);
		jd3.setDesenvolvedor("EA");
		jd3.setNome("FIFA 22");
		JogoDeluxeController.incluir(jd3);
		
		//Fim do catalogo		
		System.out.println("\r\n"+"### Jogo Deluxe Fim ####"+"\r\n");
	}
}
