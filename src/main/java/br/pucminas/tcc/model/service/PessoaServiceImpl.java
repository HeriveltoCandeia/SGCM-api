package br.pucminas.tcc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.pucminas.tcc.model.dao.PessoaDao;
import br.pucminas.tcc.model.entity.PessoaGenerica;

@Service @Transactional(readOnly = false)
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	private PessoaDao dao;

	@Override
	public void salvar(PessoaGenerica pessoa) {
		dao.save(pessoa);
	}

	@Override
	public void editar(PessoaGenerica pessoa) {
		dao.update(pessoa);		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Override
	public PessoaGenerica buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<PessoaGenerica> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public List<PessoaGenerica> buscarPorPapelId(Long id) {
		return dao.findByPapelId(id);
	}
	
	
}
