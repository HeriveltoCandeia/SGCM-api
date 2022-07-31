package br.pucminas.tcc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.model.dao.ProntuarioExameRest;
import br.pucminas.tcc.model.entity.ProntuarioExame;

@Service 
public class ProntuarioExameServiceRest {
	@Autowired
	private ProntuarioExameRest repository;
	public ProntuarioExame findById(Long id) {
		Optional<ProntuarioExame> obj = repository.findById(id);
		return obj.orElse(null);
	}


	public List<ProntuarioExame> findAll() {
		return repository.findAll();
	}
	
	public ProntuarioExame create(ProntuarioExame obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public ProntuarioExame update(Long id, ProntuarioExame obj) {
		ProntuarioExame  objA  = findById(id);
		objA.setExame(obj.getExame());
		objA.setOrientacoes(obj.getOrientacoes());
		objA.setCodigoSituacao(obj.getCodigoSituacao());
		objA.setResultado(obj.getResultado());	
		return repository.save(objA);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
