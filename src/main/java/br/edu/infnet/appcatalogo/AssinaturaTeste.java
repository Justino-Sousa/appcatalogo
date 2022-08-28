package br.edu.infnet.appcatalogo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appcatalogo.controller.AssinaController;
import br.edu.infnet.appcatalogo.model.domain.Assinatura;
import br.edu.infnet.appcatalogo.model.exceptions.PrecoInvalidoException;

@Component
@Order(2)
public class AssinaturaTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) {

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

						Assinatura a2 = new Assinatura(campos[0].charAt(0), campos[1],
								BigDecimal.valueOf(Double.valueOf(campos[2])));
						AssinaController.incluir(a2);
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
