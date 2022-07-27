package br.pucminas.tcc.util.erros;

public class UsuarioCadastradoException extends RuntimeException {

	public UsuarioCadastradoException(String usuario)
	{
		super("Usuário já cadastrado para o login" + usuario );
	}
}
