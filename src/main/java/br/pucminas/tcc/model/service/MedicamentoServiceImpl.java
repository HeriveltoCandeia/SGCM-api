package br.pucminas.tcc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.pucminas.tcc.model.dao.MedicamentoDao;
import br.pucminas.tcc.model.entity.Medicamento;

@Service @Transactional(readOnly = false)
public class MedicamentoServiceImpl implements MedicamentoService {
	
	@Autowired
	private MedicamentoDao dao;

	@Override
	public void salvar(Medicamento medicamento) {
		dao.save(medicamento);
	}

	@Override
	public void editar(Medicamento medicamento) {
		dao.update(medicamento);		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Override
	public Medicamento buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Medicamento> buscarTodos() {
		return dao.findAll();
	}

}
