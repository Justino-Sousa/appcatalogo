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

import br.edu.infnet.appcatalogo.model.domain.JogoBasic;
import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.model.exceptions.ValorZeradoException;
import br.edu.infnet.appcatalogo.service.JogoBasicService;

@Component
public class JogoBasicTeste implements ApplicationRunner {

	@Autowired
	JogoBasicService jogoBasicService;

	@Override
	public void run(ApplicationArguments args) {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);

		System.out.println("### Jogo Basic início ####" + "\r\n");

		String dir = "/home/justino/Documentos/Programação/STS-workspace/appcatalogo/data/";
		String arq = "jogo.txt";

		try {
			FileReader fileReader = new FileReader(dir + arq);
			BufferedReader leitura = new BufferedReader(fileReader);
			String linha = leitura.readLine();
			while (linha != null) {

				String[] campos = linha.split("[;]");

				if (campos[0].equalsIgnoreCase("JB")) {
					try {
						JogoBasic jb1 = new JogoBasic();
						jb1.setValor(BigDecimal.valueOf(Double.valueOf(campos[1])));
						jb1.setDescricao(campos[2]);
						jb1.setGenero(campos[3]);
						jb1.setDesenvolvedor(campos[4]);
						jb1.setNome(campos[5]);
						jb1.setUsuario(usuario);
						System.out.println("Calculo de venda avulsa: " + jb1.calcularVendaAvulsa());
						jogoBasicService.incluir(jb1);
					} catch (ValorZeradoException e) {
						System.out.println("[ERROR - JogoBasic] " + e.getMessage());
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
		System.out.println("\r\n" + "### Jogo Basic Fim ####" + "\r\n");

	}
}
