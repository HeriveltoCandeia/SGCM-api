package br.pucminas.tcc.model.dao;

import java.util.List;

import br.pucminas.tcc.model.entity.Medicamento;

public interface MedicamentoDao {
	
	void save(Medicamento medicamento);
	
	void update(Medicamento medicamento);
	
	void delete(Long id);
	
	Medicamento findById(Long id);
	
	List<Medicamento> findAll();

}
