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

import br.edu.infnet.appcatalogo.controller.JogoDeluxeController;
import br.edu.infnet.appcatalogo.model.domain.JogoDeluxe;
import br.edu.infnet.appcatalogo.model.exceptions.GeneroNaoPodeSerNull;

@Component
@Order(6)
public class JogoDeluxeTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) {

		System.out.println("### Jogo Deluxe início ####" + "\r\n");
		String dir = "/home/justino/Documentos/Programação/STS-workspace/appcatalogo/data/";
		String arq = "jogoDeluxe.txt";

		try {

			try {
				FileReader fileReader = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				String linha = leitura.readLine();
				while (linha != null) {

					try {

						String[] campos = linha.split("[;]");

						JogoDeluxe jd1 = new JogoDeluxe();
						jd1.setValor(BigDecimal.valueOf(Double.valueOf(campos[0])));
						jd1.setDescricao(campos[1]);
						jd1.setGenero(campos[2]);
						jd1.setDesenvolvedor(campos[3]);
						jd1.setNome(campos[4]);
						JogoDeluxeController.incluir(jd1);
						System.out.println("Calculo de venda avulsa: " + jd1.calcularVendaAvulsa());
					} catch (GeneroNaoPodeSerNull e) {
						System.out.println("[ERROR - JogoDeluxe] " + e.getMessage());
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
		System.out.println("\r\n" + "### Jogo Deluxe Fim ####" + "\r\n");
	}
}
