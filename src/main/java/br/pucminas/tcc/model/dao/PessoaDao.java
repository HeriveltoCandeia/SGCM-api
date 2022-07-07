package br.pucminas.tcc.model.dao;

import java.util.List;

import br.pucminas.tcc.model.entity.PessoaGenerica;

public interface PessoaDao {
	
	void save(PessoaGenerica pessoa);
	
	void update(PessoaGenerica pessoa);
	
	void delete(Long id);
	
	PessoaGenerica findById(Long id);
	
	List<PessoaGenerica> findAll();

	List<PessoaGenerica> findByPapelId(Long id);

}
