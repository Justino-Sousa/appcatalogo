package br.edu.infnet.appcatalogo.model.exceptions;

public class PrecoInvalidoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public PrecoInvalidoException(String mensagem) {
		super(mensagem);
	}
}
