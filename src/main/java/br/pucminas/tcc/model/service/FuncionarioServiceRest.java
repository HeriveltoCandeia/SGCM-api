package br.pucminas.tcc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.model.dao.FuncionarioRepositoryRest;
import br.pucminas.tcc.model.entity.Funcionario;
import br.pucminas.tcc.util.erros.UsuarioCadastradoException;

@Service 
public class FuncionarioServiceRest {
	@Autowired
	private FuncionarioRepositoryRest repository;
	public Funcionario findById(Long id) {
		Optional<Funcionario> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Funcionario> findAll() {
		return repository.findAll();
	}
	
	public Funcionario create(Funcionario obj) {
		boolean exists = repository.existsByUsuario(obj.getUsuario());
		if (exists)
		{
			throw new UsuarioCadastradoException(obj.getUsuario());
		}
		obj.setId(null);
		return repository.save(obj);
	}

	public Funcionario update(Long id, Funcionario obj) {
		Funcionario  objA  = findById(id);
		objA.setCodigoCargo(obj.getCodigoCargo());
		objA.setCpf(obj.getCpf());
		objA.setDataAdmissao(obj.getDataAdmissao());
		objA.setDataDesligamento(obj.getDataDesligamento());
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
