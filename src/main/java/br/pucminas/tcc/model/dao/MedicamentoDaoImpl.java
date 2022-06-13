package br.pucminas.tcc.model.dao;

import org.springframework.stereotype.Repository;

import br.pucminas.tcc.model.entity.Medicamento;
import br.pucminas.tcc.model.entity.Papel;

@Repository
public class MedicamentoDaoImpl extends AbstractDao<Medicamento, Long> 
implements MedicamentoDao{

}
