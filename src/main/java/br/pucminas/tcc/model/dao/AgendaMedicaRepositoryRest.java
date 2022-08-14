package br.pucminas.tcc.model.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.tcc.model.entity.AgendaMedica;
import br.pucminas.tcc.model.entity.ChaveCompostaAgenda;
import br.pucminas.tcc.model.entity.Cliente;
import br.pucminas.tcc.model.entity.Funcionario;
import br.pucminas.tcc.model.entity.ProntuarioMedico;

@Repository
public interface AgendaMedicaRepositoryRest extends JpaRepository<AgendaMedica, Long>{

	Optional<List<AgendaMedica>> findByMedicoOrderByDataAgendaAsc(Funcionario medico);	

	Optional<List<AgendaMedica>> findByMedicoAndDataRegOrderByDataAgendaAsc(Funcionario medico, LocalDate dataReg);	
	
	Optional<List<AgendaMedica>> findByClienteOrderByDataAgendaAsc(Cliente cliente);	

	Optional<List<AgendaMedica>> findByClienteAndDataRegOrderByDataAgendaAsc(Cliente cliente, LocalDate dataReg);	

	Optional<List<AgendaMedica>> findByClienteAndMedicoOrderByDataAgendaAsc(Cliente cliente, Funcionario medico);	

	Optional<List<AgendaMedica>> findByClienteAndMedicoAndDataRegOrderByDataAgendaAsc(Cliente cliente, Funcionario medico, LocalDate dataReg);	
	
	Optional<List<AgendaMedica>> findByDataRegOrderByDataAgendaAsc(LocalDate dataReg);	
	
	//filtro com o código da Situação
	
	Optional<List<AgendaMedica>> findByMedicoAndCodigoSituacaoOrderByDataAgendaAsc(Funcionario medico, Integer codigoSituacao);	

	Optional<List<AgendaMedica>> findByMedicoAndDataRegAndCodigoSituacaoOrderByDataAgendaAsc(Funcionario medico, LocalDate dataReg, Integer codigoSituacao);	
	
	Optional<List<AgendaMedica>> findByClienteAndCodigoSituacaoOrderByDataAgendaAsc(Cliente cliente, Integer codigoSituacao);	

	Optional<List<AgendaMedica>> findByClienteAndDataRegAndCodigoSituacaoOrderByDataAgendaAsc(Cliente cliente, LocalDate dataReg, Integer codigoSituacao);	

	Optional<List<AgendaMedica>> findByClienteAndMedicoAndCodigoSituacaoOrderByDataAgendaAsc(Cliente cliente, Funcionario medico, Integer codigoSituacao);	

	Optional<List<AgendaMedica>> findByClienteAndMedicoAndDataRegAndCodigoSituacaoOrderByDataAgendaAsc(Cliente cliente, Funcionario medico, LocalDate dataReg, Integer codigoSituacao);	
	
	Optional<List<AgendaMedica>> findByDataRegAndCodigoSituacaoOrderByDataAgendaAsc(LocalDate dataReg, Integer codigoSituacao);	

	Optional<List<AgendaMedica>> findByCodigoSituacaoOrderByDataAgendaAsc(Integer codigoSituacao);		
	
}
