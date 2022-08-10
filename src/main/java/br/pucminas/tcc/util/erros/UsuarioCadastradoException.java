package br.pucminas.tcc.util.erros;

public class UsuarioCadastradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;	
	
	public UsuarioCadastradoException(String usuario)
	{
		super("Usuário já cadastrado para o login" + usuario );
	}
}
