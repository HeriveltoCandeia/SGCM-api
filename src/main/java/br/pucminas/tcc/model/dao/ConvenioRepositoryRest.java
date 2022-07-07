package br.pucminas.tcc.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.tcc.model.entity.Convenio;

@Repository
public interface ConvenioRepositoryRest extends JpaRepository<Convenio, Long>{

}
