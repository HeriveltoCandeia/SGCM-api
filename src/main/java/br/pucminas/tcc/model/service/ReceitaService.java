package br.pucminas.tcc.model.service;

import java.util.List;

import br.pucminas.tcc.model.entity.Receita;

public interface ReceitaService {
	
	void salvar(Receita receita);
	
	void editar(Receita receita);
	
	void excluir(Long id);

	void excluirMedicamento(Long id_receita, Long id_medicamento);
	
	Receita buscarPorId(Long id);
	
	List<Receita> buscarTodos();

	List<Receita> buscarPorMedicamentoId(Long id);
	
	List<Receita> buscarPorPessoa(Long id);	
	
}
