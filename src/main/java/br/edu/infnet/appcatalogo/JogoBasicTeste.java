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

import br.edu.infnet.appcatalogo.model.domain.JogoBasic;
import br.edu.infnet.appcatalogo.model.exceptions.ValorZeradoException;
import br.edu.infnet.appcatalogo.service.JogoBasicService;

@Component
@Order(4)
public class JogoBasicTeste implements ApplicationRunner {
	
	@Autowired
	JogoBasicService jogoBasicService;

	@Override
	public void run(ApplicationArguments args) {

		System.out.println("### Jogo Basic início ####" + "\r\n");

		String dir = "/home/justino/Documentos/Programação/STS-workspace/appcatalogo/data/";
		String arq = "jogoBasic.txt";

		try {

			try {
				FileReader fileReader = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				String linha = leitura.readLine();
				while (linha != null) {

					try {

						String[] campos = linha.split("[;]");

						JogoBasic jb1 = new JogoBasic();
						jb1.setValor(BigDecimal.valueOf(Double.valueOf(campos[0])));
						jb1.setDescricao(campos[1]);
						jb1.setGenero(campos[2]);
						jb1.setDesenvolvedor(campos[3]);
						jb1.setNome(campos[4]);
						System.out.println("Calculo de venda avulsa: " + jb1.calcularVendaAvulsa());
						jogoBasicService.incluir(jb1);
					} catch (ValorZeradoException e) {
						System.out.println("[ERROR - JogoBasic] " + e.getMessage());
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
		System.out.println("\r\n" + "### Jogo Basic Fim ####" + "\r\n");

	}
}
