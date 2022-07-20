package br.pucminas.tcc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.model.dao.PessoaRepositoryRest;
import br.pucminas.tcc.model.entity.Pessoa;

@Service 
public class PessoaServiceRest {
	@Autowired
	private PessoaRepositoryRest repository;
	public Pessoa findById(Long id) {
		Optional<Pessoa> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Pessoa> findAll() {
		return repository.findAll();
	}
	
	public Pessoa create(Pessoa obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Pessoa update(Long id, Pessoa obj) {
		Pessoa  objA  = findById(id);
		objA.setCpf(obj.getCpf());
		objA.setDataNascimento(obj.getDataNascimento());
		objA.setEmail(obj.getEmail());
		objA.setNome(obj.getNome());
		objA.setSexo(obj.getSexo());
		return repository.save(objA);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
