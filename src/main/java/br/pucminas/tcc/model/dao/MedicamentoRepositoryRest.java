package br.pucminas.tcc.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.tcc.model.entity.Medicamento;

@Repository
public interface MedicamentoRepositoryRest extends JpaRepository<Medicamento, Long>{

}
