package br.pucminas.tcc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.model.dao.ProntuarioExameRest;
import br.pucminas.tcc.model.dao.ProntuarioMedicamentoRest;
import br.pucminas.tcc.model.entity.ProntuarioMedicamento;

@Service 
public class ProntuarioMedicamentoServiceRest {
	@Autowired
	private ProntuarioMedicamentoRest repository;
	public ProntuarioMedicamento findById(Long id) {
		Optional<ProntuarioMedicamento> obj = repository.findById(id);
		return obj.orElse(null);
	}


	public List<ProntuarioMedicamento> findAll() {
		return repository.findAll();
	}
	
	public ProntuarioMedicamento create(ProntuarioMedicamento obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public ProntuarioMedicamento update(Long id, ProntuarioMedicamento obj) {
		ProntuarioMedicamento  objA  = findById(id);
		objA.setMedicamento(obj.getMedicamento());
		objA.setOrientacoes(obj.getOrientacoes());
		return repository.save(objA);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
