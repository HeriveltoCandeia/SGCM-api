package br.pucminas.tcc.model.dao;

import java.util.List;

import br.pucminas.tcc.model.entity.Papel;

public interface PapelDao {
	
	void save(Papel papel);
	
	void update(Papel papel);
	
	void delete(Long id);
	
	Papel findById(Long id);
	
	List<Papel> findAll();

}
