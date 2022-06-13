package br.pucminas.tcc.model.service;

import java.util.List;

import br.pucminas.tcc.model.entity.Pessoa;

public interface PessoaService {
	
	void salvar(Pessoa pessoa);
	
	void editar(Pessoa pessoa);
	
	void excluir(Long id);
	
	Pessoa buscarPorId(Long id);
	
	List<Pessoa> buscarTodos();

	List<Pessoa> buscarPorPapelId(Long id);
	
}
