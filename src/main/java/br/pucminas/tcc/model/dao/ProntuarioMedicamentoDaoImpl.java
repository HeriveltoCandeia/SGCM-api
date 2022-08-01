package br.pucminas.tcc.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.pucminas.tcc.model.entity.ProntuarioMedicamento;
import br.pucminas.tcc.model.entity.Receita;

@Repository
public class ProntuarioMedicamentoDaoImpl extends AbstractDao<ProntuarioMedicamento, Long> 
implements ProntuarioMedicamentoDao{
	
	@Override
	public Optional <List<ProntuarioMedicamento>> findByProntuarioId(Long id) {
		return Optional.of(createQuery("select d from ProntuarioMedicamento  d where d.prontuarioMedico.id = ?1", id));
	}

	
}
