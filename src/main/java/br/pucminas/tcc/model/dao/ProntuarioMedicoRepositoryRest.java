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

	Optional<List<ProntuarioMedico>> findByMedicoOrderByDataRegDescDataTimeProntuarioAsc(Funcionario medico);	

	Optional<List<ProntuarioMedico>> findByMedicoAndDataRegOrderByDataRegDescDataTimeProntuarioAsc(Funcionario medico, LocalDate dataReg);	
	
	Optional<List<ProntuarioMedico>> findByClienteOrderByDataRegDescDataTimeProntuarioAsc(Cliente cliente);	

	Optional<List<ProntuarioMedico>> findByClienteAndDataRegOrderByDataRegDescDataTimeProntuarioAsc(Cliente cliente, LocalDate dataReg);	

	Optional<List<ProntuarioMedico>> findByClienteAndMedicoOrderByDataRegDescDataTimeProntuarioAsc(Cliente cliente, Funcionario medico);	

	Optional<List<ProntuarioMedico>> findByClienteAndMedicoAndDataRegOrderByDataRegDescDataTimeProntuarioAsc(Cliente cliente, Funcionario medico, LocalDate dataReg);	
	
	Optional<List<ProntuarioMedico>> findByDataRegOrderByDataRegDescDataTimeProntuarioAsc(LocalDate dataReg);	

	//filtro com o código da Situação

	Optional<List<ProntuarioMedico>> findByMedicoAndCodigoSituacaoOrderByDataRegDescDataTimeProntuarioAsc(Funcionario medico, Integer codigoSituacao);	

	Optional<List<ProntuarioMedico>> findByMedicoAndDataRegAndCodigoSituacaoOrderByDataRegDescDataTimeProntuarioAsc(Funcionario medico, LocalDate dataReg, Integer codigoSituacao);	
	
	Optional<List<ProntuarioMedico>> findByClienteAndCodigoSituacaoOrderByDataRegDescDataTimeProntuarioAsc(Cliente cliente, Integer codigoSituacao);	

	Optional<List<ProntuarioMedico>> findByClienteAndDataRegAndCodigoSituacaoOrderByDataRegDescDataTimeProntuarioAsc(Cliente cliente, LocalDate dataReg, Integer codigoSituacao);	

	Optional<List<ProntuarioMedico>> findByClienteAndMedicoAndCodigoSituacaoOrderByDataRegDescDataTimeProntuarioAsc(Cliente cliente, Funcionario medico, Integer codigoSituacao);	

	Optional<List<ProntuarioMedico>> findByClienteAndMedicoAndDataRegAndCodigoSituacaoOrderByDataRegDescDataTimeProntuarioAsc(Cliente cliente, Funcionario medico, LocalDate dataReg, Integer codigoSituacao);	
	
	Optional<List<ProntuarioMedico>> findByDataRegAndCodigoSituacaoOrderByDataRegDescDataTimeProntuarioAsc(LocalDate dataReg, Integer codigoSituacao);	

	Optional<List<ProntuarioMedico>> findByCodigoSituacaoOrderByDataRegDescDataTimeProntuarioAsc(Integer codigoSituacao);	
	
}
