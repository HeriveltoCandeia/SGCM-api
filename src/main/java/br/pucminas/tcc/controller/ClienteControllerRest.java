package br.pucminas.tcc.controller;

import java.util.List;
import java.net.URI;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.pucminas.tcc.model.entity.Cliente;
import br.pucminas.tcc.model.service.ClienteServiceRest;

@RestController
@RequestMapping("/clientesRest")
public class ClienteControllerRest {
	
	@Autowired
	private ClienteServiceRest service;
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> finById(@PathVariable("id") Long id) {
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Cliente>> finByAll() {
		List <Cliente> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Cliente> incluir(@RequestBody Cliente obj) {
		
		obj=service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).body(obj);
	}
	
	@CrossOrigin
	@PutMapping(value="/{id}")
	public ResponseEntity<Cliente> editar(@PathVariable Long id, @RequestBody Cliente obj){
		Cliente newObj = service.update(id,obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@CrossOrigin
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
