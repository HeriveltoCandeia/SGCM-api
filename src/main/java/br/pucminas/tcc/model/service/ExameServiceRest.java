package br.pucminas.tcc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.model.dao.ExameRepositoryRest;
import br.pucminas.tcc.model.entity.Exame;

@Service 
public class ExameServiceRest {
	@Autowired
	private ExameRepositoryRest repository;
	public Exame findById(Long id) {
		Optional<Exame> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Exame> findAll() {
		return repository.findAll();
	}
	
	public Exame create(Exame obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Exame update(Long id, Exame obj) {
		Exame  objA  = findById(id);
		objA.setDescricao(obj.getDescricao());
		return repository.save(objA);
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch	(DataIntegrityViolationException e)
		{
			throw new br.pucminas.tcc.util.erros.DataIntegrityViolationException("Exame não pode ser excluído. Já vinculado à Prontuários.", null);
		}		
	}

}
