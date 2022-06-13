package br.pucminas.tcc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.pucminas.tcc.model.dao.PapelDao;
import br.pucminas.tcc.model.entity.Papel;

@Service @Transactional(readOnly = false)
public class PapelServiceImpl implements PapelService {
	
	@Autowired
	private PapelDao dao;

	@Override
	public void salvar(Papel papel) {
		dao.save(papel);
	}

	@Override
	public void editar(Papel papel) {
		dao.update(papel);		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Override
	public Papel buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Papel> buscarTodos() {
		return dao.findAll();
	}

}
