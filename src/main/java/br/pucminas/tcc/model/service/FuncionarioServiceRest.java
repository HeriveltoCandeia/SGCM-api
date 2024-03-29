package br.pucminas.tcc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

	public List<Funcionario> findByCodigoCargo(Long id) {
		Optional<List<Funcionario>> obj = repository.findByCodigoCargo(id);
		return obj.orElse(null);
	}	

	public Funcionario findByUsuario(String usuario) {
		Optional<Funcionario> obj = repository.findByUsuario(usuario);
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
		objA.setUsuario(obj.getUsuario());
		objA.setSenha(obj.getSenha());
		return repository.save(objA);
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch	(DataIntegrityViolationException e)
		{
			throw new br.pucminas.tcc.util.erros.DataIntegrityViolationException("Funcionário não pode ser excluído. Já vinculado à Prontuários.", null);
		}		
	}

}
