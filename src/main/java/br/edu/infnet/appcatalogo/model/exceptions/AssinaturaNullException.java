package br.edu.infnet.appcatalogo.model.exceptions;

public class AssinaturaNullException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public AssinaturaNullException(String mensagem) {
		super(mensagem);
	}
}
