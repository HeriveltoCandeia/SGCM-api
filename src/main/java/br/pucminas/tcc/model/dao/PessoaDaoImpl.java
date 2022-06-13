package br.pucminas.tcc.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.pucminas.tcc.model.entity.Pessoa;

@Repository
public class PessoaDaoImpl extends AbstractDao<Pessoa, Long> 
implements PessoaDao{
	@Override
	public List<Pessoa> findByPapelId(Long id) {
		return createQuery("select c from Pessoa  c join fetch c.papeis d where d.id = ?1", id);
	}
}
