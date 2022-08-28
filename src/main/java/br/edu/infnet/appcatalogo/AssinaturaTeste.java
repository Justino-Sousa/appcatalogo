package br.edu.infnet.appcatalogo;

import java.math.BigDecimal;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appcatalogo.controller.AssinaController;
import br.edu.infnet.appcatalogo.model.domain.Assinatura;

@Component
@Order(2)
public class AssinaturaTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		//Inicio do catalogo		
		System.out.println("### Assinatura início ####"+"\r\n");

		Assinatura a2 = new Assinatura('B', "Basic", new BigDecimal(100.00));
		AssinaController.incluir(a2);

		Assinatura a1 = new Assinatura('P', "Premium", new BigDecimal(200.00));
		AssinaController.incluir(a1);

		Assinatura a3 = new Assinatura('D', "Deluxe", new BigDecimal(300.00));
		AssinaController.incluir(a3);
		
		//Fim do catalogo		
		System.out.println("\r\n"+"### Assinatura Fim ####"+"\r\n");
	}
}
