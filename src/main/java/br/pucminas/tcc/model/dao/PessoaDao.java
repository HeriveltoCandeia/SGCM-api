package br.pucminas.tcc.model.dao;

import java.util.List;

import br.pucminas.tcc.model.entity.Pessoa;

public interface PessoaDao {
	
	void save(Pessoa pessoa);
	
	void update(Pessoa pessoa);
	
	void delete(Long id);
	
	Pessoa findById(Long id);
	
	List<Pessoa> findAll();

	List<Pessoa> findByPapelId(Long id);

}
