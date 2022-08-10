package br.pucminas.tcc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.model.dao.ClienteRepositoryRest;
import br.pucminas.tcc.model.entity.Cliente;

@Service 
public class ClienteServiceRest {
	@Autowired
	private ClienteRepositoryRest repository;
	public Cliente findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	public Cliente create(Cliente obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Cliente update(Long id, Cliente obj) {
		Cliente  objA  = findById(id);
		objA.setConvenioMedico(obj.getConvenioMedico());
		objA.setCpf(obj.getCpf());
		objA.setDataNascimento(obj.getDataNascimento());
		objA.setEmail(obj.getEmail());
		objA.setNome(obj.getNome());
		objA.setNumeroCarteirinha(obj.getNumeroCarteirinha());
		objA.setSexo(obj.getSexo());
		return repository.save(objA);
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch	(DataIntegrityViolationException e)
		{
			throw new br.pucminas.tcc.util.erros.DataIntegrityViolationException("Cliente não pode ser excluído. Já vinculado à Prontuários/Agendas.", null);
		}		
	}

}
