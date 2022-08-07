package br.edu.infnet.appcatalogo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appcatalogo.model.domain.Jogo;

@Component
public class JogoTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("#Jogo");
		Jogo j1 = new Jogo();
		j1.codigo = 1;
		j1.nome = "The last of Us";
		j1.descricao = "The Last of Us é um jogo eletrônico de ação-aventura e sobrevivência desenvolvido pela Naughty Dog e publicado pela Sony Computer Entertainment.";
		System.out.println(j1);
		
		Jogo j2 = new Jogo();
		j2.codigo = 2;
		j2.nome = "God of War é um jogo eletrônico de ação-aventura desenvolvido pela Santa Monica Studio e publicado pela Sony Interactive Entertainment.";
		j2.descricao = "";
		System.out.println(j2);
		
		Jogo j3 = new Jogo();
		j3.codigo = 3;
		j3.nome = "FIFA 22";
		j3.descricao = "FIFA 22 é um jogo eletrônico de simulação de futebol desenvolvido e publicado pela Electronic Arts.";
		System.out.println(j3);
	}
}
