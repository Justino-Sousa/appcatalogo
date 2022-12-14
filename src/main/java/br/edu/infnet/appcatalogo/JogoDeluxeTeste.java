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

import br.edu.infnet.appcatalogo.model.domain.JogoDeluxe;
import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.model.exceptions.GeneroNaoPodeSerNull;
import br.edu.infnet.appcatalogo.service.JogoDeluxeService;

@Component
public class JogoDeluxeTeste implements ApplicationRunner {

	@Autowired
	JogoDeluxeService jogoDeluxeService;

	@Override
	public void run(ApplicationArguments args) {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);

		System.out.println("### Jogo Deluxe início ####" + "\r\n");
		String dir = "/home/justino/Documentos/Programação/STS-workspace/appcatalogo/data/";
		String arq = "jogo.txt";

		try {
			FileReader fileReader = new FileReader(dir + arq);
			BufferedReader leitura = new BufferedReader(fileReader);
			String linha = leitura.readLine();
			while (linha != null) {

				String[] campos = linha.split("[;]");
				if (campos[0].equalsIgnoreCase("JD")) {
					
					try {
						JogoDeluxe jd1 = new JogoDeluxe();
						jd1.setValor(BigDecimal.valueOf(Double.valueOf(campos[1])));
						jd1.setDescricao(campos[2]);
						jd1.setGenero(campos[3]);
						jd1.setDesenvolvedor(campos[4]);
						jd1.setNome(campos[5]);
						jd1.setUsuario(usuario);
						jogoDeluxeService.incluir(jd1);
						System.out.println("Calculo de venda avulsa: " + jd1.calcularVendaAvulsa());
					} catch (GeneroNaoPodeSerNull e) {
						System.out.println("[ERROR - JogoDeluxe] " + e.getMessage());
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
		System.out.println("\r\n" + "### Jogo Deluxe Fim ####" + "\r\n");
	}
}
