package br.edu.infnet.appcatalogo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appcatalogo.controller.CatalogoController;
import br.edu.infnet.appcatalogo.model.domain.Assinatura;
import br.edu.infnet.appcatalogo.model.domain.Catalogo;
import br.edu.infnet.appcatalogo.model.domain.Jogo;
import br.edu.infnet.appcatalogo.model.domain.JogoBasic;
import br.edu.infnet.appcatalogo.model.domain.JogoDeluxe;
import br.edu.infnet.appcatalogo.model.domain.JogoPremium;
import br.edu.infnet.appcatalogo.model.exceptions.AssinaturaNullException;
import br.edu.infnet.appcatalogo.model.exceptions.CatalogoSemJogosException;
import br.edu.infnet.appcatalogo.model.exceptions.PrecoInvalidoException;

@Component
@Order(1)
public class CatalogoTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) {

		JogoBasic jb1 = new JogoBasic();
		jb1.setValor(new BigDecimal(150.00));
		jb1.setDescricao("Jogos da memoria");
		jb1.setGenero("estratégia");
		jb1.setCodigo(1);
		jb1.setDesenvolvedor("SONY");
		jb1.setNome("Memory game");

		JogoBasic jb2 = new JogoBasic();
		jb2.setValor(new BigDecimal(100.00));
		jb2.setDescricao("Bilhar online");
		jb2.setGenero("Diversão");
		jb2.setCodigo(2);
		jb2.setDesenvolvedor("Santa monica");
		jb2.setNome("Bilhar2");

		JogoBasic jb3 = new JogoBasic();
		jb3.setValor(new BigDecimal(130.00));
		jb3.setDescricao("Gamão online");
		jb3.setGenero("Diversão");
		jb3.setCodigo(3);
		jb3.setDesenvolvedor("Division");
		jb3.setNome("Super Gamão");

		JogoPremium jp1 = new JogoPremium();
		jp1.setValor(new BigDecimal(250.00));
		jp1.setDescricao(
				"Crash Bandicoot é um jogo eletrônico de plataforma desenvolvido pela Naughty Dog e publicado pela Sony Computer Entertainment em 1996 para o console PlayStation. É o primeiro episódio da série Crash Bandicoot.");
		jp1.setGenero("Aventura");
		jp1.setCodigo(4);
		jp1.setDesenvolvedor("Naughty Dog");
		jp1.setNome("Crash Bandicoot");

		JogoPremium jp2 = new JogoPremium();
		jp2.setValor(new BigDecimal(200.00));
		jp2.setDescricao(
				"eFootball é uma série de jogos eletrônicos de simulação de futebol desenvolvido e publicado pela Konami desde 1995. Consiste em dezoito jogos principais e vários spin-offs que foram lançados em diversas plataformas diferentes. A série alcançou sucesso crítico e comercial.");
		jp2.setGenero("Esportes");
		jp2.setCodigo(5);
		jp2.setDesenvolvedor("Konami");
		jp2.setNome("eFootball");

		JogoPremium jp3 = new JogoPremium();
		jp3.setValor(new BigDecimal(280.00));
		jp3.setDescricao(
				"Returnal é um jogo eletrônico de tiro em terceira pessoa roguelike desenvolvido pela Housemarque e publicado pela Sony Interactive Entertainment. Foi lançado exclusivamente para PlayStation 5 em 30 de abril de 2021.");
		jp3.setGenero("Tiro/terceira pessoa");
		jp3.setCodigo(6);
		jp3.setDesenvolvedor("Housemarque");
		jp3.setNome("Returnal");

		JogoDeluxe jd1 = new JogoDeluxe();
		jd1.setValor(new BigDecimal(300));
		jd1.setDescricao(
				"The Last of Us é um jogo eletrônico de ação-aventura e sobrevivência desenvolvido pela Naughty Dog e publicado pela Sony Computer Entertainment.");
		jd1.setGenero("Ação e aventura/Survival horror");
		jd1.setCodigo(7);
		jd1.setDesenvolvedor("Naughty Dog");
		jd1.setNome("The Last of Us");

		JogoDeluxe jd2 = new JogoDeluxe();
		jd2.setValor(new BigDecimal(300));
		jd2.setDescricao(
				"God of War Ragnarök é um futuro jogo eletrônico de ação-aventura desenvolvido pela Santa Monica Studio e publicado pela Sony Interactive Entertainment. Está programado para ser lançado em 9 de novembro de 2022 para PlayStation 4 e PlayStation 5.");
		jd2.setGenero("Ação e aventura/luta/hack and slash");
		jd2.setCodigo(8);
		jd2.setDesenvolvedor("Santa monica");
		jd2.setNome("God of War Ragnarök");

		JogoDeluxe jd3 = new JogoDeluxe();
		jd3.setValor(new BigDecimal(350));
		jd3.setDescricao(
				"FIFA 22 é um jogo eletrônico de simulação de futebol desenvolvido e publicado pela Electronic Arts.");
		jd3.setGenero("Esportes");
		jd3.setCodigo(9);
		jd3.setDesenvolvedor("EA");
		jd3.setNome("FIFA 22");

		// Inicio do catalogo
		System.out.println("### Catalogo início ####" + "\r\n");

		String dir = "/home/justino/Documentos/Programação/STS-workspace/appcatalogo/data/";
		String arq = "catalogo.txt";

		try {

			try {
				FileReader fileReader = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				String linha = leitura.readLine();
				while (linha != null) {

					try {

						String[] campos = linha.split("[;]");

						Assinatura a1 = new Assinatura(campos[0].charAt(0), campos[1],
								BigDecimal.valueOf(Double.valueOf(campos[2])));
						Set<Jogo> jogosDoCatalogoB = new HashSet<Jogo>();
						jogosDoCatalogoB.add(jb1);
						jogosDoCatalogoB.add(jb2);
						jogosDoCatalogoB.add(jb3);

						Catalogo c1 = new Catalogo(a1, jogosDoCatalogoB);

						c1.setDescricao(campos[3]);
						c1.setNome(campos[4]);
						CatalogoController.incluir(c1);

					} catch (AssinaturaNullException | PrecoInvalidoException | CatalogoSemJogosException e) {
						System.out.println("[ERROR - Pedido] " + e.getMessage());
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
			System.out.println("### Fim do carregamento");
		}

		// Fim do catalogo
		System.out.println("\r\n" + "### Catalogo Fim ####" + "\r\n");

	}
}
