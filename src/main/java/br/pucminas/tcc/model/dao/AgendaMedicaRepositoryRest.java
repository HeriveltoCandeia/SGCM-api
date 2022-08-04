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

	Optional<List<AgendaMedica>> findByMedico(Funcionario medico);	

	Optional<List<AgendaMedica>> findByMedicoAndDataReg(Funcionario medico, LocalDate dataReg);	
	
	Optional<List<AgendaMedica>> findByCliente(Cliente cliente);	

	Optional<List<AgendaMedica>> findByClienteAndDataReg(Cliente cliente, LocalDate dataReg);	

	Optional<List<AgendaMedica>> findByClienteAndMedico(Cliente cliente, Funcionario medico);	

	Optional<List<AgendaMedica>> findByClienteAndMedicoAndDataReg(Cliente cliente, Funcionario medico, LocalDate dataReg);	
	
	Optional<List<AgendaMedica>> findByDataReg(LocalDate dataReg);	

	//filtro com o código da Situação
	
	Optional<List<AgendaMedica>> findByMedicoAndCodigoSituacao(Funcionario medico, Integer codigoSituacao);	

	Optional<List<AgendaMedica>> findByMedicoAndDataRegAndCodigoSituacao(Funcionario medico, LocalDate dataReg, Integer codigoSituacao);	
	
	Optional<List<AgendaMedica>> findByClienteAndCodigoSituacao(Cliente cliente, Integer codigoSituacao);	

	Optional<List<AgendaMedica>> findByClienteAndDataRegAndCodigoSituacao(Cliente cliente, LocalDate dataReg, Integer codigoSituacao);	

	Optional<List<AgendaMedica>> findByClienteAndMedicoAndCodigoSituacao(Cliente cliente, Funcionario medico, Integer codigoSituacao);	

	Optional<List<AgendaMedica>> findByClienteAndMedicoAndDataRegAndCodigoSituacao(Cliente cliente, Funcionario medico, LocalDate dataReg, Integer codigoSituacao);	
	
	Optional<List<AgendaMedica>> findByDataRegAndCodigoSituacao(LocalDate dataReg, Integer codigoSituacao);	

	Optional<List<AgendaMedica>> findByCodigoSituacao(Integer codigoSituacao);		
	
}
