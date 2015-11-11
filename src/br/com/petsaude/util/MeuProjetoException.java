package br.com.petsaude.util;

public class MeuProjetoException extends Exception {
	private static final long serialVersionUID = 1L;
	public MeuProjetoException(Throwable mensagem){
		super(mensagem);
	}
	public MeuProjetoException(String mensagem) {
		super(mensagem);
	}
	public MeuProjetoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
