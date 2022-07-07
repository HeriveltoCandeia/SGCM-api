package br.pucminas.tcc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.model.dao.CargoRepositoryRest;
import br.pucminas.tcc.model.entity.Cargo;

@Service 
public class CargoServiceRest {
	@Autowired
	private CargoRepositoryRest repository;
	public Cargo findById(Long id) {
		Optional<Cargo> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Cargo> findAll() {
		return repository.findAll();
	}
	
	public Cargo create(Cargo obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Cargo update(Long id, Cargo obj) {
		Cargo  objA  = findById(id);
		objA.setDescricao(obj.getDescricao());
		return repository.save(objA);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
