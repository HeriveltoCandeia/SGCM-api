package br.pucminas.tcc.model.service;

import java.util.List;

import br.pucminas.tcc.model.entity.Medicamento;

public interface MedicamentoService {
	
	void salvar(Medicamento medicamento);
	
	void editar(Medicamento medicamento);
	
	void excluir(Long id);
	
	Medicamento buscarPorId(Long id);
	
	List<Medicamento> buscarTodos();

}
