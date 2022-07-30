package br.pucminas.tcc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.model.dao.AgendaMedicaRepositoryRest;
import br.pucminas.tcc.model.entity.AgendaMedica;
import br.pucminas.tcc.model.entity.ChaveCompostaAgenda;

@Service 
public class AgendaMedicaServiceRest {
	@Autowired
	private AgendaMedicaRepositoryRest repository;
	public AgendaMedica findById(Long id) {
		Optional<AgendaMedica> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public AgendaMedica findByChaveCompostaAgenda(ChaveCompostaAgenda chaveCompostaAgenda) {
		Optional<AgendaMedica> obj = repository.findByChaveCompostaAgenda(chaveCompostaAgenda);
		return obj.orElse(null);
	}
	
	public List<AgendaMedica> findAll() {
		return repository.findAll();
	}
	
	public AgendaMedica create(AgendaMedica obj) {
		return repository.save(obj);
	}

	public AgendaMedica update(Long id, AgendaMedica obj) {
		AgendaMedica  objA  = findById(id);
		objA.setCliente(obj.getCliente());
		objA.setCodigoSituacao(obj.getCodigoSituacao());
		objA.setCodigoTipo(obj.getCodigoTipo());
		objA.setDataReg(obj.getDataReg());
		objA.setChaveCompostaAgenda(obj.getChaveCompostaAgenda());
		return repository.save(objA);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
