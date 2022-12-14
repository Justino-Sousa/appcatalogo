package br.edu.infnet.appcatalogo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appcatalogo.model.domain.Assinatura;
import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.model.exceptions.PrecoInvalidoException;
import br.edu.infnet.appcatalogo.service.AssinaService;

@Component
@Order(2)
public class AssinaturaTeste implements ApplicationRunner {

	@Autowired
	AssinaService assinaService; 

	@Override
	public void run(ApplicationArguments args) {

		Usuario user = new Usuario();
		user.setId(1);
		
		
		// Inicio do catalogo
		System.out.println("### Assinatura início ####" + "\r\n");

		String dir = "/home/justino/Documentos/Programação/STS-workspace/appcatalogo/data/";
		String arq = "assinatura.txt";

		try {

			try {
				FileReader fileReader = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				String linha = leitura.readLine();
				while (linha != null) {

					try {

						String[] campos = linha.split("[;]");

						Assinatura a2 = new Assinatura(campos[0], campos[1],
								BigDecimal.valueOf(Double.valueOf(campos[2])));
						a2.setUsuario(user);
						assinaService.incluir(a2);
						
					} catch (PrecoInvalidoException e) {
						System.out.println("[ERROR]" + e.getMessage());
					}

					linha = leitura.readLine();
				}

				leitura.close();
				fileReader.close();

			} catch (FileNotFoundException e) {
				System.out.println("[ERROR] O arquivo não existe!");
			} catch (IOException e) {
				System.out.println("[ERROR] Problema no fechamento do arquivo!");
			}

		} finally {
			System.out.println("Terminou!");
		}

		// Fim do catalogo
		System.out.println("\r\n" + "### Assinatura Fim ####" + "\r\n");
	}
}
