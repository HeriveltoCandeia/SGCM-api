package br.pucminas.tcc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.model.dao.MedicamentoRepositoryRest;
import br.pucminas.tcc.model.entity.Medicamento;

@Service 
public class MedicamentoServiceRest {
	@Autowired
	private MedicamentoRepositoryRest repository;
	public Medicamento findById(Long id) {
		Optional<Medicamento> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Medicamento> findAll() {
		return repository.findAll();
	}
	
	public Medicamento create(Medicamento obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Medicamento update(Long id, Medicamento obj) {
		Medicamento  objA  = findById(id);
		objA.setDescricao(obj.getDescricao());
		return repository.save(objA);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
