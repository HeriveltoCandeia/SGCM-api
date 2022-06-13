package br.pucminas.tcc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.pucminas.tcc.model.dao.ReceitaDao;
import br.pucminas.tcc.model.entity.Receita;

@Service @Transactional(readOnly = false)
public class ReceitaServiceImpl implements ReceitaService {
	
	@Autowired
	private ReceitaDao dao;

	@Override
	public void salvar(Receita receita) {
		dao.save(receita);
	}

	@Override
	public void editar(Receita receita) {
		dao.update(receita);		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Override
	public Receita buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Receita> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public List<Receita> buscarPorMedicamentoId(Long id) {
		return dao.findByMedicamentoId(id);
	}
	
	@Override
	public List<Receita> buscarPorPessoa(Long id) {
		return dao.findByPessoaId(id);
	}

	@Override
	public void excluirMedicamento(Long id_receita, Long id_medicamento) {
		dao.deleteMedicamento(id_receita, id_medicamento);
	}
	
}
