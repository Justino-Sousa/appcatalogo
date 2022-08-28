package br.edu.infnet.appcatalogo.model.test;

import br.edu.infnet.appcatalogo.interfaces.IPrinter;

public class AppCatalogo {

	public static void relatorio(String mensagem, IPrinter iPrinter) {
		System.out.println(mensagem);
		iPrinter.impressao();
	}
}