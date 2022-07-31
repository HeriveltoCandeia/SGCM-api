package br.pucminas.tcc.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.tcc.model.entity.ProntuarioMedico;

@Repository
public interface ProntuarioMedicoRepositoryRest extends JpaRepository<ProntuarioMedico, Long>{

}
