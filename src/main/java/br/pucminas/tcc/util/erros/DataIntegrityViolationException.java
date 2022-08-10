package br.pucminas.tcc.util.erros;

public class DataIntegrityViolationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DataIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
	}
}
