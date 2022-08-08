package br.edu.infnet.appcatalogo;

import java.math.BigDecimal;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appcatalogo.model.domain.JogoBasic;

@Component
public class JogoBasicTeste implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("#JogoBasic");
		JogoBasic jb1 = new JogoBasic();
		jb1.valor = new BigDecimal(150.00);
		jb1.descricao = "Jogos da memoria";
		jb1.genero = "estratégia";
		System.out.println(jb1);
		
		JogoBasic jb2 = new JogoBasic();
		jb2.valor = new BigDecimal(100.00);
		jb2.descricao = "Bilhar online";
		jb2.genero = "Diversão";
		System.out.println(jb2);
		
		JogoBasic jb3 = new JogoBasic();
		jb3.valor = new BigDecimal(130.00);
		jb3.descricao = "Gamão online";
		jb3.genero = "Diversão";
		System.out.println(jb3);
		
	}
}
