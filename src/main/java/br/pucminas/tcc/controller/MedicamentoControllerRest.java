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

import br.pucminas.tcc.model.entity.Medicamento;
import br.pucminas.tcc.model.service.MedicamentoServiceRest;

@RestController
@RequestMapping("/medicamentosRest")
public class MedicamentoControllerRest {
	
	@Autowired
	private MedicamentoServiceRest service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Medicamento> finById(@PathVariable("id") Long id) {
		Medicamento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Medicamento>> finByAll() {
		List <Medicamento> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Medicamento> incluir(@RequestBody Medicamento obj) {
		obj=service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Medicamento> editar(@PathVariable Long id, @RequestBody Medicamento obj){
		Medicamento newObj = service.update(id,obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
