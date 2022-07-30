package br.pucminas.tcc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.model.dao.TipoExameRepositoryRest;
import br.pucminas.tcc.model.entity.TipoExame;

@Service 
public class TipoExameServiceRest {
	@Autowired
	private TipoExameRepositoryRest repository;
	public TipoExame findById(Long id) {
		Optional<TipoExame> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<TipoExame> findAll() {
		return repository.findAll();
	}
	
	public TipoExame create(TipoExame obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public TipoExame update(Long id, TipoExame obj) {
		TipoExame  objA  = findById(id);
		objA.setDescricao(obj.getDescricao());
		return repository.save(objA);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
