package br.pucminas.tcc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.model.dao.FuncionarioRepositoryRest;
import br.pucminas.tcc.model.entity.Funcionario;

@Service
public class UsuarioService implements UserDetailsService{

	@Autowired
	private FuncionarioRepositoryRest repository;
	
	@Autowired
	private FuncionarioServiceRest service; 
	
	@Override
	public UserDetails loadUserByUsername(String usuarioNome) throws UsernameNotFoundException {
		Funcionario usuario = repository
								.findByUsuario(usuarioNome)
								.orElseThrow(()-> new UsernameNotFoundException("Usuário não encontrado."));
		
		return User
					.builder()
					.username(usuario.getUsuario())
					.password(usuario.getSenha())
					.roles("USER")
					.build();
	}

	public Long verificaAcessoUsuario(int[] codigoCargo) throws Exception
	{
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("Usuário" + username);
		Funcionario func = service.findByUsuario(username);
		for(int i = 0; i < codigoCargo.length; i++)
		{
			if (func.getCodigoCargo() == codigoCargo[i])
			{
				return func.getCodigoCargo();
			}
		}
		throw new Exception("Usuário sem permissão");

//		return false;
	}
}
