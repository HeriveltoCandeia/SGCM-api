package br.pucminas.tcc.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.pucminas.tcc.model.entity.Medicamento;
import br.pucminas.tcc.model.entity.ProntuarioMedicamento;
import br.pucminas.tcc.model.entity.ProntuarioMedico;

@Repository
public interface ProntuarioMedicamentoRest extends JpaRepository<ProntuarioMedicamento, Long>{

	
	Optional<List<ProntuarioMedicamento>> findByProntuarioMedico(ProntuarioMedico prontuarioMedico);	
		
}
