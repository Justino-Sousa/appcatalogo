package br.edu.infnet.appcatalogo;

import java.math.BigDecimal;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appcatalogo.model.domain.Assinatura;
import br.edu.infnet.appcatalogo.model.domain.Catalogo;

@Component
@Order(2)
public class AssinaturaTeste implements ApplicationRunner{
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("#Assinatura");
		
		Assinatura a2 = new Assinatura('B',new Catalogo(1,"Catalogo de jogos basico","Catalogo Basic"),new BigDecimal(100.00));
		System.out.println(a2);
		
		Assinatura a1 = new Assinatura('P',new Catalogo(2,"Catalogo de jogos premium","Catalogo Premium"),new BigDecimal(200.00));
		System.out.println(a1);
		
		Assinatura a3 = new Assinatura('D',new Catalogo(3,"Catalogo de jogos deluxe","Catalogo Deluxe"),new BigDecimal(300.00));
		System.out.println(a3);
	}
}
