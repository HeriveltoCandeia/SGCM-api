package br.pucminas.tcc.model.dao;

import java.util.List;

import br.pucminas.tcc.model.entity.Medicamento;
import br.pucminas.tcc.model.entity.MedicamentosReceita;
import br.pucminas.tcc.model.entity.Receita;
//import br.pucminas.tcc.model.entity.ReceitasMedicamentosReceita;

public interface MedicamentosReceitaDao {
	
	void save(MedicamentosReceita medicamento);
	
	void update(MedicamentosReceita medicamento);
	
	void delete(Long id);
	
	MedicamentosReceita findById(Long id);
	
	List<MedicamentosReceita> findAll();
	
	List<MedicamentosReceita> findByMedicamentosReceitaId(Long id);
	

}
