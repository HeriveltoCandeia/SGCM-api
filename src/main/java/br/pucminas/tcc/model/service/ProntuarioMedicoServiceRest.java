package br.pucminas.tcc.model.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.model.dao.ProntuarioMedicoRepositoryRest;
import br.pucminas.tcc.model.entity.Cliente;
import br.pucminas.tcc.model.entity.Funcionario;
import br.pucminas.tcc.model.entity.ProntuarioMedicamento;
import br.pucminas.tcc.model.entity.ProntuarioMedico;

@Service 
public class ProntuarioMedicoServiceRest {
	@Autowired
	private ProntuarioMedicoRepositoryRest repository;
	public ProntuarioMedico findById(Long id) {
		Optional<ProntuarioMedico> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<ProntuarioMedico> findByProntuarioFiltros(Funcionario medico, Cliente cliente, LocalDate dataReg, Integer codigoSituacao, Boolean filMed, Boolean filCli, Boolean filData, Boolean filSituacao) {

		if (filSituacao)
		{
			if (filData)
			{
				if(filCli)
				{
					if(filMed)
					{
						Optional<List<ProntuarioMedico>> obj = repository.findByClienteAndMedicoAndDataRegAndCodigoSituacaoOrderByDataRegDescDataTimeProntuarioAsc(cliente, medico, dataReg, codigoSituacao);
						return obj.orElse(null);					
					}
					Optional<List<ProntuarioMedico>> obj = repository.findByClienteAndDataRegAndCodigoSituacaoOrderByDataRegDescDataTimeProntuarioAsc(cliente, dataReg, codigoSituacao);
					return obj.orElse(null);				
				}
				
				if(filMed)
				{
					Optional<List<ProntuarioMedico>> obj = repository.findByMedicoAndDataRegAndCodigoSituacaoOrderByDataRegDescDataTimeProntuarioAsc(medico, dataReg, codigoSituacao);			
					return obj.orElse(null);
				}
				
				Optional<List<ProntuarioMedico>> obj = repository.findByDataRegAndCodigoSituacaoOrderByDataRegDescDataTimeProntuarioAsc(dataReg, codigoSituacao);
				return obj.orElse(null);
			}
			
			if(filMed)
			{
				if(filCli)
				{
					Optional<List<ProntuarioMedico>> obj = repository.findByClienteAndMedicoAndCodigoSituacaoOrderByDataRegDescDataTimeProntuarioAsc(cliente, medico, codigoSituacao);			
					return obj.orElse(null);			
				}
	
				Optional<List<ProntuarioMedico>> obj = repository.findByMedicoAndCodigoSituacaoOrderByDataRegDescDataTimeProntuarioAsc(medico, codigoSituacao);			
				return obj.orElse(null);
			}
			
			if(filCli)
			{
				Optional<List<ProntuarioMedico>> obj = repository.findByClienteAndCodigoSituacaoOrderByDataRegDescDataTimeProntuarioAsc(cliente, codigoSituacao);			
				return obj.orElse(null);			
			}

			Optional<List<ProntuarioMedico>> obj = repository.findByCodigoSituacaoOrderByDataRegDescDataTimeProntuarioAsc(codigoSituacao);			
			return obj.orElse(null);			
		}
		
		
		
		if (filData)
		{
			if(filCli)
			{
				if(filMed)
				{
					Optional<List<ProntuarioMedico>> obj = repository.findByClienteAndMedicoAndDataRegOrderByDataRegDescDataTimeProntuarioAsc(cliente, medico, dataReg);
					return obj.orElse(null);					
				}
				Optional<List<ProntuarioMedico>> obj = repository.findByClienteAndDataRegOrderByDataRegDescDataTimeProntuarioAsc(cliente, dataReg);
				return obj.orElse(null);				
			}
			
			if(filMed)
			{
				Optional<List<ProntuarioMedico>> obj = repository.findByMedicoAndDataRegOrderByDataRegDescDataTimeProntuarioAsc(medico, dataReg);			
				return obj.orElse(null);
			}
			
			Optional<List<ProntuarioMedico>> obj = repository.findByDataRegOrderByDataRegDescDataTimeProntuarioAsc(dataReg);
			return obj.orElse(null);
		}
		
		if(filMed)
		{
			if(filCli)
			{
				Optional<List<ProntuarioMedico>> obj = repository.findByClienteAndMedicoOrderByDataRegDescDataTimeProntuarioAsc(cliente, medico);			
				return obj.orElse(null);			
			}

			Optional<List<ProntuarioMedico>> obj = repository.findByMedicoOrderByDataRegDescDataTimeProntuarioAsc(medico);			
			return obj.orElse(null);
		}
		
		if(filCli)
		{
			Optional<List<ProntuarioMedico>> obj = repository.findByClienteOrderByDataRegDescDataTimeProntuarioAsc(cliente);			
			return obj.orElse(null);			
		}
		return (null);	
	}		

	public List<ProntuarioMedico> findAll() {
		return repository.findAll();
	}
	
	public ProntuarioMedico create(ProntuarioMedico obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public ProntuarioMedico update(Long id, ProntuarioMedico obj) {
		ProntuarioMedico  objA  = findById(id);
		objA.setCliente(obj.getCliente());
		objA.setMedico(obj.getMedico());
		objA.setOrientacoes(obj.getOrientacoes());
		objA.setCodigoSituacao(obj.getCodigoSituacao());
		return repository.save(objA);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
