package br.pucminas.tcc.model.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.model.dao.AgendaMedicaRepositoryRest;
import br.pucminas.tcc.model.entity.AgendaMedica;
import br.pucminas.tcc.model.entity.ChaveCompostaAgenda;
import br.pucminas.tcc.model.entity.Cliente;
import br.pucminas.tcc.model.entity.Funcionario;
import br.pucminas.tcc.model.entity.ProntuarioMedico;

@Service 
public class AgendaMedicaServiceRest {
	@Autowired
	private AgendaMedicaRepositoryRest repository;
	public AgendaMedica findById(Long id) {
		Optional<AgendaMedica> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<AgendaMedica> findAll() {
		return repository.findAll();
	}
	
	public List<AgendaMedica> findByAgendaMedicaFiltros(Funcionario medico, Cliente cliente, LocalDate dataReg, Integer codigoSituacao, Boolean filMed, Boolean filCli, Boolean filData, Boolean filSituacao) {

		System.out.println(dataReg);
		System.out.println(filData);
		
		if(filSituacao)
		{
			if (filData)
			{
				if(filCli)
				{
					if(filMed)
					{
						Optional<List<AgendaMedica>> obj = repository.findByClienteAndMedicoAndDataRegAndCodigoSituacaoOrderByDataRegDescDataAgendaAsc(cliente, medico, dataReg, codigoSituacao);
						return obj.orElse(null);					
					}
					Optional<List<AgendaMedica>> obj = repository.findByClienteAndDataRegAndCodigoSituacaoOrderByDataRegDescDataAgendaAsc(cliente, dataReg, codigoSituacao);
					return obj.orElse(null);				
				}
				
				if(filMed)
				{
					Optional<List<AgendaMedica>> obj = repository.findByMedicoAndDataRegAndCodigoSituacaoOrderByDataRegDescDataAgendaAsc(medico, dataReg, codigoSituacao);			
					return obj.orElse(null);
				}
				Optional<List<AgendaMedica>> obj = repository.findByDataRegAndCodigoSituacaoOrderByDataRegDescDataAgendaAsc(dataReg, codigoSituacao);
				return obj.orElse(null);
			}
			
			if(filMed)
			{
				if(filCli)
				{
					Optional<List<AgendaMedica>> obj = repository.findByClienteAndMedicoAndCodigoSituacaoOrderByDataRegDescDataAgendaAsc(cliente, medico, codigoSituacao);			
					return obj.orElse(null);			
				}
	
				Optional<List<AgendaMedica>> obj = repository.findByMedicoAndCodigoSituacaoOrderByDataRegDescDataAgendaAsc(medico, codigoSituacao);			
				return obj.orElse(null);
			}
			
			if(filCli)
			{
				Optional<List<AgendaMedica>> obj = repository.findByClienteAndCodigoSituacaoOrderByDataRegDescDataAgendaAsc(cliente, codigoSituacao);			
				return obj.orElse(null);			
			}

			Optional<List<AgendaMedica>> obj = repository.findByCodigoSituacaoOrderByDataRegDescDataAgendaAsc(codigoSituacao);			
			return obj.orElse(null);						
		}
		
		if (filData)
		{
			if(filCli)
			{
				if(filMed)
				{
					Optional<List<AgendaMedica>> obj = repository.findByClienteAndMedicoAndDataRegOrderByDataRegDescDataAgendaAsc(cliente, medico, dataReg);
					return obj.orElse(null);					
				}
				Optional<List<AgendaMedica>> obj = repository.findByClienteAndDataRegOrderByDataRegDescDataAgendaAsc(cliente, dataReg);
				return obj.orElse(null);				
			}
			
			if(filMed)
			{
				Optional<List<AgendaMedica>> obj = repository.findByMedicoAndDataRegOrderByDataRegDescDataAgendaAsc(medico, dataReg);			
				return obj.orElse(null);
			}
			
			Optional<List<AgendaMedica>> obj = repository.findByDataRegOrderByDataRegDescDataAgendaAsc(dataReg);
			return obj.orElse(null);
		}
		
		if(filMed)
		{
			if(filCli)
			{
				Optional<List<AgendaMedica>> obj = repository.findByClienteAndMedicoOrderByDataRegDescDataAgendaAsc(cliente, medico);			
				return obj.orElse(null);			
			}

			Optional<List<AgendaMedica>> obj = repository.findByMedicoOrderByDataRegDescDataAgendaAsc(medico);			
			return obj.orElse(null);
		}
		
		if(filCli)
		{
			Optional<List<AgendaMedica>> obj = repository.findByClienteOrderByDataRegDescDataAgendaAsc(cliente);			
			return obj.orElse(null);			
		}
		return (null);	
	}		
	
	
	public AgendaMedica create(AgendaMedica obj) {
		return repository.save(obj);
	}

	public AgendaMedica update(Long id, AgendaMedica obj) {
		AgendaMedica  objA  = findById(id);
		objA.setDataAgenda(obj.getDataAgenda());
		objA.setMedico(obj.getMedico());
		objA.setCliente(obj.getCliente());
		objA.setCodigoSituacao(obj.getCodigoSituacao());
		objA.setCodigoTipo(obj.getCodigoTipo());
		objA.setDataReg(obj.getDataReg());
		return repository.save(objA);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
