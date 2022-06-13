package br.pucminas.tcc.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.pucminas.tcc.model.entity.Receita;

@Repository
public class ReceitaDaoImpl extends AbstractDao<Receita, Long> 
implements ReceitaDao{
	@Override
	public List<Receita> findByMedicamentoId(Long id) {
		return createQuery("select c from Receita  c join fetch c.medicamentos d where d.id = ?1", id);
	}
	
	@Override
	public List<Receita> findByPessoaId(Long id) {
		return createQuery("select d from Receita  d where d.pessoa.id = ?1", id);
	}

	@Override
	public void deleteMedicamento(Long id_receita, Long id_medicamento) {
		createQuery("delete from receitas_medicamentos_receita  d where d.pessoa.id = ?1", id_receita, id_medicamento);
	}
	
}
