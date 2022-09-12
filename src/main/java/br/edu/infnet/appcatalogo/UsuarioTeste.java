package br.edu.infnet.appcatalogo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appcatalogo.controller.UsuarioController;
import br.edu.infnet.appcatalogo.model.domain.Usuario;

@Component
@Order(6)
public class UsuarioTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) {

		// Inicio do catalogo
		System.out.println("### Usuario início ####" + "\r\n");

		String dir = "/home/justino/Documentos/Programação/STS-workspace/appcatalogo/data/";
		String arq = "usuario.txt";

		try {

			try {
				FileReader fileReader = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				String linha = leitura.readLine();
				while (linha != null) {

					String[] campos = linha.split("[;]");

					Usuario a2 = new Usuario(campos[0], campos[1],(campos[2]));
					UsuarioController.incluir(a2);

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
		System.out.println("\r\n" + "### Usuário Fim ####" + "\r\n");
	}
}
