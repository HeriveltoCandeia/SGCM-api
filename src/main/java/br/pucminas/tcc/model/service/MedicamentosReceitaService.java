package br.pucminas.tcc.model.service;

import java.util.List;

import br.pucminas.tcc.model.entity.Medicamento;
import br.pucminas.tcc.model.entity.MedicamentosReceita;
import br.pucminas.tcc.model.entity.Receita;
//import br.pucminas.tcc.model.entity.ReceitasMedicamentosReceita;

public interface MedicamentosReceitaService {
	
	void salvar(MedicamentosReceita medicamento);
	
	void editar(MedicamentosReceita medicamento);
	
	void excluir(Long id);
	
	MedicamentosReceita buscarPorId(Long id, Long id2);
	
	List<MedicamentosReceita> buscarTodos();
	
	List<MedicamentosReceita> buscarPorId(Long id);
	
	
}
