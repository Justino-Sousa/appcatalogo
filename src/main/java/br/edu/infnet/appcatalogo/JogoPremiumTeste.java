package br.edu.infnet.appcatalogo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appcatalogo.model.domain.JogoPremium;
import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.model.exceptions.ValorInvalidoException;
import br.edu.infnet.appcatalogo.service.JogoPremiumService;

@Component
public class JogoPremiumTeste implements ApplicationRunner {

	@Autowired
	JogoPremiumService jogoPremiumService;

	@Override
	public void run(ApplicationArguments args) {

		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		System.out.println("### Jogo Premium início ####" + "\r\n");
		String dir = "/home/justino/Documentos/Programação/STS-workspace/appcatalogo/data/";
		String arq = "jogo.txt";

		try {
			FileReader fileReader = new FileReader(dir + arq);
			BufferedReader leitura = new BufferedReader(fileReader);
			String linha = leitura.readLine();
			while (linha != null) {

				String[] campos = linha.split("[;]");
				if (campos[0].equalsIgnoreCase("JP")) {

					try {
						JogoPremium jp1 = new JogoPremium();
						jp1.setValor(BigDecimal.valueOf(Double.valueOf(campos[1])));
						jp1.setDescricao(campos[2]);
						jp1.setGenero(campos[3]);
						jp1.setDesenvolvedor(campos[4]);
						jp1.setNome(campos[5]);
						jp1.setUsuario(usuario);
						jogoPremiumService.incluir(jp1);
						System.out.println("Calculo de venda avulsa: " + jp1.calcularVendaAvulsa());
					} catch (ValorInvalidoException e) {
						System.out.println("[ERROR - JogoPremium] " + e.getMessage());
					}
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

		finally {
			System.out.println("Terminou!");
		}

		// Fim do catalogo
		System.out.println("\r\n" + "### Jogo Premium Fim ####" + "\r\n");

	}
}
