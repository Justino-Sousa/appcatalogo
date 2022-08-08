package br.edu.infnet.appcatalogo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appcatalogo.model.domain.Catalogo;

@Component
public class CatalogoTeste implements ApplicationRunner{
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("#Catalogo");
		Catalogo c1 = new Catalogo();
		c1.codigo = 1;
		c1.descricao = "Catalogo de jogos basico";
		c1.nome ="Catalogo Basic";
		System.out.println(c1);
		
		Catalogo c2 = new Catalogo();
		c2.codigo = 2;
		c2.descricao = "Catalogo de jogos premium";
		c2.nome ="Catalogo Premium";
		System.out.println(c2);
		
		Catalogo c3 = new Catalogo();
		c3.codigo = 1;
		c3.descricao = "Catalogo de jogos deluxe";
		c3.nome ="Catalogo Deluxe";
		System.out.println(c3);
	}
}
