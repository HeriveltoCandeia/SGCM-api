package br.pucminas.tcc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.pucminas.tcc.model.dao.MedicamentoDao;
import br.pucminas.tcc.model.dao.MedicamentosReceitaDao;
import br.pucminas.tcc.model.dao.ReceitaDao;
//import br.pucminas.tcc.model.dao.ReceitaMedicamentosDao;
import br.pucminas.tcc.model.entity.Medicamento;
import br.pucminas.tcc.model.entity.MedicamentosReceita;
import br.pucminas.tcc.model.entity.Receita;
//import br.pucminas.tcc.model.entity.ReceitasMedicamentosReceita;

@Service @Transactional(readOnly = false)
public class MedicamentosReceitaServiceImpl implements MedicamentosReceitaService {
	
	@Autowired
	private MedicamentosReceitaDao dao;


	@Override
	public List<MedicamentosReceita> buscarPorId(Long id) {
		return dao.findByMedicamentosReceitaId(id);
	}


	@Override
	public void salvar(MedicamentosReceita medicamento) {
		dao.save(medicamento);
	}

	@Override
	public void editar(MedicamentosReceita medicamento) {
		dao.update(medicamento);		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Override
	public MedicamentosReceita buscarPorId(Long id, Long id2) {
		return dao.findById(id);
	}

	@Override
	public List<MedicamentosReceita> buscarTodos() {
		return dao.findAll();
	}
	
	
	
}
