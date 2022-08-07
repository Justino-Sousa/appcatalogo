package br.edu.infnet.appcatalogo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appcatalogo.model.domain.Catalogo;

@Component
@Order(1)
public class CatalogoTeste implements ApplicationRunner{
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("#Catalogo");
		Catalogo c1 = new Catalogo(1,"Catalogo de jogos basico","Catalogo Basic");
		System.out.println(c1);
		
		Catalogo c2 = new Catalogo(2,"Catalogo de jogos premium","Catalogo Premium");
		System.out.println(c2);
		
		Catalogo c3 = new Catalogo(3,"Catalogo de jogos deluxe","Catalogo Deluxe");
		System.out.println(c3);
	}
}
