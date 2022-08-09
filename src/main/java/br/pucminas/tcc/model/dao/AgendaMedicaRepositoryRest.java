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

	Optional<List<AgendaMedica>> findByMedicoOrderByDataRegDescDataAgendaAsc(Funcionario medico);	

	Optional<List<AgendaMedica>> findByMedicoAndDataRegOrderByDataRegDescDataAgendaAsc(Funcionario medico, LocalDate dataReg);	
	
	Optional<List<AgendaMedica>> findByClienteOrderByDataRegDescDataAgendaAsc(Cliente cliente);	

	Optional<List<AgendaMedica>> findByClienteAndDataRegOrderByDataRegDescDataAgendaAsc(Cliente cliente, LocalDate dataReg);	

	Optional<List<AgendaMedica>> findByClienteAndMedicoOrderByDataRegDescDataAgendaAsc(Cliente cliente, Funcionario medico);	

	Optional<List<AgendaMedica>> findByClienteAndMedicoAndDataRegOrderByDataRegDescDataAgendaAsc(Cliente cliente, Funcionario medico, LocalDate dataReg);	
	
	Optional<List<AgendaMedica>> findByDataRegOrderByDataRegDescDataAgendaAsc(LocalDate dataReg);	
	
	//filtro com o código da Situação
	
	Optional<List<AgendaMedica>> findByMedicoAndCodigoSituacaoOrderByDataRegDescDataAgendaAsc(Funcionario medico, Integer codigoSituacao);	

	Optional<List<AgendaMedica>> findByMedicoAndDataRegAndCodigoSituacaoOrderByDataRegDescDataAgendaAsc(Funcionario medico, LocalDate dataReg, Integer codigoSituacao);	
	
	Optional<List<AgendaMedica>> findByClienteAndCodigoSituacaoOrderByDataRegDescDataAgendaAsc(Cliente cliente, Integer codigoSituacao);	

	Optional<List<AgendaMedica>> findByClienteAndDataRegAndCodigoSituacaoOrderByDataRegDescDataAgendaAsc(Cliente cliente, LocalDate dataReg, Integer codigoSituacao);	

	Optional<List<AgendaMedica>> findByClienteAndMedicoAndCodigoSituacaoOrderByDataRegDescDataAgendaAsc(Cliente cliente, Funcionario medico, Integer codigoSituacao);	

	Optional<List<AgendaMedica>> findByClienteAndMedicoAndDataRegAndCodigoSituacaoOrderByDataRegDescDataAgendaAsc(Cliente cliente, Funcionario medico, LocalDate dataReg, Integer codigoSituacao);	
	
	Optional<List<AgendaMedica>> findByDataRegAndCodigoSituacaoOrderByDataRegDescDataAgendaAsc(LocalDate dataReg, Integer codigoSituacao);	

	Optional<List<AgendaMedica>> findByCodigoSituacaoOrderByDataRegDescDataAgendaAsc(Integer codigoSituacao);		
	
}
