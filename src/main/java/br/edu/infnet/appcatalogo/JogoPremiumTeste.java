package br.edu.infnet.appcatalogo;

import java.math.BigDecimal;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appcatalogo.model.domain.JogoPremium;

@Component
public class JogoPremiumTeste implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("#JogoPremium");
		JogoPremium jp1 = new JogoPremium();
		jp1.valor = new BigDecimal(250.00);
		jp1.descricao = "Crash Bandicoot é um jogo eletrônico de plataforma desenvolvido pela Naughty Dog e publicado pela Sony Computer Entertainment em 1996 para o console PlayStation. É o primeiro episódio da série Crash Bandicoot.";
		jp1.genero = "Ação e aventura";
		System.out.println(jp1);
		
		JogoPremium jp2 = new JogoPremium();
		jp2.valor = new BigDecimal(200.00);
		jp2.descricao = "eFootball é uma série de jogos eletrônicos de simulação de futebol desenvolvido e publicado pela Konami desde 1995. Consiste em dezoito jogos principais e vários spin-offs que foram lançados em diversas plataformas diferentes. A série alcançou sucesso crítico e comercial.";
		jp2.genero = "Esportes";
		System.out.println(jp2);
		
		JogoPremium jp3 = new JogoPremium();
		jp3.valor = new BigDecimal(280.00);
		jp3.descricao = "Returnal é um jogo eletrônico de tiro em terceira pessoa roguelike desenvolvido pela Housemarque e publicado pela Sony Interactive Entertainment. Foi lançado exclusivamente para PlayStation 5 em 30 de abril de 2021.";
		jp3.genero = "Tiro/terceira pessoa";
		System.out.println(jp3);
		
	}
}