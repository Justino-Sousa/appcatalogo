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

import br.edu.infnet.appcatalogo.model.domain.JogoPremium;
import br.edu.infnet.appcatalogo.model.exceptions.ValorInvalidoException;
import br.edu.infnet.appcatalogo.service.JogoPremiumService;

@Component
@Order(5)
public class JogoPremiumTeste implements ApplicationRunner {
	

	@Autowired
	JogoPremiumService jogoPremiumService;

	@Override
	public void run(ApplicationArguments args) {

		System.out.println("### Jogo Premium início ####" + "\r\n");

		String dir = "/home/justino/Documentos/Programação/STS-workspace/appcatalogo/data/";
		String arq = "jogoPremium.txt";

		try {

			try {
				FileReader fileReader = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				String linha = leitura.readLine();
				while (linha != null) {

					try {

						String[] campos = linha.split("[;]");

						JogoPremium jp1 = new JogoPremium();
						jp1.setValor(BigDecimal.valueOf(Double.valueOf(campos[0])));
						jp1.setDescricao(campos[1]);
						jp1.setGenero(campos[2]);
						jp1.setDesenvolvedor(campos[3]);
						jp1.setNome(campos[4]);
						jogoPremiumService.incluir(jp1);
						System.out.println("Calculo de venda avulsa: " + jp1.calcularVendaAvulsa());
					} catch (ValorInvalidoException e) {
						System.out.println("[ERROR - JogoPremium] " + e.getMessage());
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
		System.out.println("\r\n" + "### Jogo Premium Fim ####" + "\r\n");

	}
}
