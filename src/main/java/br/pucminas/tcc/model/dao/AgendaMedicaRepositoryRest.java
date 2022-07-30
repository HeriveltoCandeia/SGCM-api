package br.pucminas.tcc.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.tcc.model.entity.AgendaMedica;
import br.pucminas.tcc.model.entity.ChaveCompostaAgenda;

@Repository
public interface AgendaMedicaRepositoryRest extends JpaRepository<AgendaMedica, Long>{

	Optional<AgendaMedica> findByChaveCompostaAgenda(ChaveCompostaAgenda id);

	void deleteByChaveCompostaAgenda(ChaveCompostaAgenda chaveCompostaAgenda);

}
