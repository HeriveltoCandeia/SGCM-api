package br.pucminas.tcc.model.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.tcc.model.entity.Cliente;
import br.pucminas.tcc.model.entity.Funcionario;
import br.pucminas.tcc.model.entity.ProntuarioMedicamento;
import br.pucminas.tcc.model.entity.ProntuarioMedico;

@Repository
public interface ProntuarioMedicoRepositoryRest extends JpaRepository<ProntuarioMedico, Long>{

	Optional<List<ProntuarioMedico>> findByMedico(Funcionario medico);	

	Optional<List<ProntuarioMedico>> findByMedicoAndDataReg(Funcionario medico, LocalDate dataReg);	
	
	Optional<List<ProntuarioMedico>> findByCliente(Cliente cliente);	

	Optional<List<ProntuarioMedico>> findByClienteAndDataReg(Cliente cliente, LocalDate dataReg);	

	Optional<List<ProntuarioMedico>> findByClienteAndMedico(Cliente cliente, Funcionario medico);	

	Optional<List<ProntuarioMedico>> findByClienteAndMedicoAndDataReg(Cliente cliente, Funcionario medico, LocalDate dataReg);	
	
	Optional<List<ProntuarioMedico>> findByDataReg(LocalDate dataReg);	
	
}
