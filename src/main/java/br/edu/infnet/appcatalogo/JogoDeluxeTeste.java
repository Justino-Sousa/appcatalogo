package br.edu.infnet.appcatalogo;

import java.math.BigDecimal;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appcatalogo.model.domain.JogoDeluxe;

@Component
public class JogoDeluxeTeste implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("#JogoDeluxe");
		JogoDeluxe jd1 = new JogoDeluxe();
		jd1.valor = new BigDecimal(300);
		jd1.descricao = "The Last of Us é um jogo eletrônico de ação-aventura e sobrevivência desenvolvido pela Naughty Dog e publicado pela Sony Computer Entertainment.";
		jd1.genero = "Ação e aventura";
		System.out.println(jd1);
		
		JogoDeluxe jd2= new JogoDeluxe();
		jd2.valor = new BigDecimal(300);
		jd2.descricao = "God of War Ragnarök é um futuro jogo eletrônico de ação-aventura desenvolvido pela Santa Monica Studio e publicado pela Sony Interactive Entertainment. Está programado para ser lançado em 9 de novembro de 2022 para PlayStation 4 e PlayStation 5.";
		jd2.genero = "Ação e aventura/luta/hack and slash";
		System.out.println(jd2);
		
		JogoDeluxe jd3 = new JogoDeluxe();
		jd3.valor = new BigDecimal(350);
		jd3.descricao = "FIFA 22 é um jogo eletrônico de simulação de futebol desenvolvido e publicado pela Electronic Arts.";
		jd3.genero = "Esportes";
		System.out.println(jd3);
	}
	
}
