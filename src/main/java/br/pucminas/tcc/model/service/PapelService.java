package br.pucminas.tcc.model.service;

import java.util.List;

import br.pucminas.tcc.model.entity.Papel;

public interface PapelService {
	
	void salvar(Papel papel);
	
	void editar(Papel papel);
	
	void excluir(Long id);
	
	Papel buscarPorId(Long id);
	
	List<Papel> buscarTodos();

}
