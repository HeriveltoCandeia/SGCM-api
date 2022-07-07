package br.pucminas.tcc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.model.dao.ConvenioRepositoryRest;
import br.pucminas.tcc.model.entity.Convenio;

@Service 
public class ConvenioServiceRest {
	@Autowired
	private ConvenioRepositoryRest repository;
	public Convenio findById(Long id) {
		Optional<Convenio> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Convenio> findAll() {
		return repository.findAll();
	}
	
	public Convenio create(Convenio obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Convenio update(Long id, Convenio obj) {
		Convenio  objA  = findById(id);
		objA.setDescricao(obj.getDescricao());
		return repository.save(objA);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
