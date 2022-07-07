package br.pucminas.tcc.model.service;

import java.util.List;

import br.pucminas.tcc.model.entity.PessoaGenerica;

public interface PessoaService {
	
	void salvar(PessoaGenerica pessoa);
	
	void editar(PessoaGenerica pessoa);
	
	void excluir(Long id);
	
	PessoaGenerica buscarPorId(Long id);
	
	List<PessoaGenerica> buscarTodos();

	List<PessoaGenerica> buscarPorPapelId(Long id);
	
}
