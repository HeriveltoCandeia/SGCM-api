package br.pucminas.tcc.controller;

import java.util.List;
import java.net.URI;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.pucminas.tcc.model.entity.Funcionario;
import br.pucminas.tcc.model.service.FuncionarioServiceRest;
import br.pucminas.tcc.util.erros.UsuarioCadastradoException;

@RestController
@RequestMapping("/funcionariosRest")
public class FuncionarioControllerRest {
	
	@Autowired
	private FuncionarioServiceRest service;
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> finById(@PathVariable("id") Long id) {
		Funcionario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Funcionario>> finByAll() {
		List <Funcionario> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Funcionario> incluir(@RequestBody Funcionario obj) {
		System.out.println("Funcionário");
		System.out.println(obj.getNome());
		System.out.println(obj.getCpf());		
		System.out.println(obj.getCodigoCargo());
		try
		{
			obj=service.create(obj);			
		}
		catch(UsuarioCadastradoException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).body(obj);
	}
	
	@CrossOrigin
	@PutMapping(value="/{id}")
	public ResponseEntity<Funcionario> editar(@PathVariable Long id, @RequestBody Funcionario obj){
		Funcionario newObj = service.update(id,obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@CrossOrigin
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
