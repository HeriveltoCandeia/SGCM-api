package br.pucminas.tcc.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.tcc.model.entity.ProntuarioExame;
import br.pucminas.tcc.model.entity.ProntuarioMedicamento;
import br.pucminas.tcc.model.entity.ProntuarioMedico;

@Repository
public interface ProntuarioExameRest extends JpaRepository<ProntuarioExame, Long>{

	Optional<List<ProntuarioExame>> findByProntuarioMedico(ProntuarioMedico prontuarioMedico);	
	
}
