package br.edu.infnet.appcatalogo;

import java.math.BigDecimal;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appcatalogo.model.domain.Assinatura;
import br.edu.infnet.appcatalogo.model.domain.Catalogo;

@Component
public class AssinaturaTeste implements ApplicationRunner{
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("#Assinatura");	
		Assinatura a2 = new Assinatura();
		a2.tipoAssinatura = 'B';
		a2.preco = new BigDecimal(100.00);
		a2.catalogo = new Catalogo();
		System.out.println(a2);
		
		Assinatura a1 = new Assinatura();
		a1.tipoAssinatura = 'P';
		a1.preco = new BigDecimal(200.00);
		a1.catalogo = new Catalogo();
		System.out.println(a1);
		
		Assinatura a3 = new Assinatura();
		a3.tipoAssinatura = 'D';
		a3.preco = new BigDecimal(300.00);
		a3.catalogo = new Catalogo();
		System.out.println(a3);
	}
}
