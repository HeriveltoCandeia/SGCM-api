package br.pucminas.tcc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
		objA.setNomeFabrica(obj.getNomeFabrica());
		objA.setNomeGenerico(obj.getNomeGenerico());
		objA.setNomeFabricante(obj.getNomeFabricante());
		return repository.save(objA);
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch	(DataIntegrityViolationException e)
		{
			throw new br.pucminas.tcc.util.erros.DataIntegrityViolationException("Medicamento não pode ser deletado. Já vinculado à Prontuários.", null);
		}
		
	}

}
