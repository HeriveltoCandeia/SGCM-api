package br.pucminas.tcc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.model.dao.ProntuarioMedicoRepositoryRest;
import br.pucminas.tcc.model.entity.ProntuarioMedico;

@Service 
public class ProntuarioMedicoServiceRest {
	@Autowired
	private ProntuarioMedicoRepositoryRest repository;
	public ProntuarioMedico findById(Long id) {
		Optional<ProntuarioMedico> obj = repository.findById(id);
		return obj.orElse(null);
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
