package br.pucminas.tcc.model.dao;

import java.util.List;
import java.util.Optional;

import br.pucminas.tcc.model.entity.ProntuarioMedicamento;
import br.pucminas.tcc.model.entity.Receita;

public interface ProntuarioMedicamentoDao {
	
	void save(ProntuarioMedicamento prontuarioMedicamento);
	
	void update(ProntuarioMedicamento prontuarioMedicamento);
	
	void delete(Long id);
	
	ProntuarioMedicamento findById(Long id);
	
	List<ProntuarioMedicamento> findAll();

	Optional<List<ProntuarioMedicamento>> findByProntuarioId(Long id);
	
}
