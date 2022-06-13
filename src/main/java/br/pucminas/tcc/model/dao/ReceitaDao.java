package br.pucminas.tcc.model.dao;

import java.util.List;

import br.pucminas.tcc.model.entity.Receita;

public interface ReceitaDao {
	
	void save(Receita receita);
	
	void update(Receita receita);
	
	void delete(Long id);
	
	void deleteMedicamento(Long id_receita, Long id_medicamento);
	
	Receita findById(Long id);
	
	List<Receita> findAll();

	List<Receita> findByMedicamentoId(Long id);
	
	List<Receita> findByPessoaId(Long id);	

}
