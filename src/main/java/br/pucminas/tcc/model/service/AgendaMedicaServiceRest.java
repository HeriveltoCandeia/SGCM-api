package br.pucminas.tcc.model.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
	
	public void createLote(Funcionario medico, LocalDate dataInicio, LocalDate dataFim, Integer recorrencia )
	{
		medico = new Funcionario();
		medico.setId(3L);
		dataInicio = LocalDate.of(2022, 8, 14);
		dataFim = LocalDate.of(2022, 8, 15);

		LocalTime horaInicio = LocalTime.of(8, 0);
		LocalTime horaFim = LocalTime.of(17, 0);

		LocalDateTime dataHoraInicio = LocalDateTime.of(dataInicio, horaInicio);
		LocalDateTime dataHoraFim = LocalDateTime.of(dataFim, horaFim);
		
		LocalDate dataReg = dataInicio;
		LocalDateTime dataAgenda = dataHoraInicio;
		int duplicados = 0;
		for(int i=0;dataAgenda.compareTo(dataHoraFim)<0 && i<35;i++)
		{
			AgendaMedica agendaMedica = new AgendaMedica();
			agendaMedica.setCodigoSituacao(1);
			agendaMedica.setCodigoTipo(1);
			agendaMedica.setMedico(medico);
			agendaMedica.setDataReg(dataReg);
			agendaMedica.setDataAgenda(dataAgenda);
			try
			{
				repository.save(agendaMedica);
			}
			catch(Exception e)
			{
				System.out.println(e);
				duplicados++;
			}

			if ((dataAgenda.getMinute() + recorrencia)<60)
			{
				System.out.println("Dentro do IF");
				System.out.println(dataAgenda.getMinute());
				System.out.println(dataAgenda.getMinute() + recorrencia);
				dataAgenda = dataAgenda.of(dataAgenda.getYear(),dataAgenda.getMonthValue(),dataAgenda.getDayOfMonth(),dataAgenda.getHour(),dataAgenda.getMinute() + recorrencia);
			}
			else
			{
				if (dataAgenda.getHour() < 17)
				{
					dataAgenda = dataAgenda.of(dataAgenda.getYear(),dataAgenda.getMonthValue(),dataAgenda.getDayOfMonth(),dataAgenda.getHour() + 1, 0);
				}
				else
				{
					dataAgenda = dataAgenda.of(dataAgenda.getYear(),dataAgenda.getMonthValue(),dataAgenda.getDayOfMonth() + 1 , 8, 0);
					dataReg = dataReg.of(dataReg.getYear(), dataReg.getMonthValue(), dataReg.getDayOfMonth() + 1);
				}
			}
		}
	}
	
	public AgendaMedica create(AgendaMedica obj) {
	//	createLote(null, null, null, 20);
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
