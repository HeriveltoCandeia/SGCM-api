package br.pucminas.tcc.controller;

import java.util.List;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.pucminas.tcc.model.entity.ProntuarioExame;
import br.pucminas.tcc.model.entity.ProntuarioMedicamento;
import br.pucminas.tcc.model.entity.ProntuarioMedico;
import br.pucminas.tcc.model.service.ProntuarioExameServiceRest;

@RestController
@RequestMapping("/prontuariosExamesRest")
public class ProntuarioExameControllerRest {
	
	@Autowired
	private ProntuarioExameServiceRest service;
	
	@GetMapping("/{id}")
	public ResponseEntity<ProntuarioExame> finById(@PathVariable("id") Long id) {
		ProntuarioExame obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	
	@CrossOrigin
	@GetMapping("/prontuarioExame/{id}")
	public ResponseEntity<List<ProntuarioExame>> findByProntuarioExame(@PathVariable("id") Long id) {
//		ProntuarioMedico pm = service2.findById(id);
		ProntuarioMedico pm = new ProntuarioMedico();
		pm.setId(id);
		List <ProntuarioExame> obj = service.findByProntuarioMedico(pm);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<ProntuarioExame>> finByAll() {
		List <ProntuarioExame> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<ProntuarioExame> incluir(@RequestBody ProntuarioExame obj) {
		System.out.println(obj);
		obj=service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ProntuarioExame> editar(@PathVariable Long id, @RequestBody ProntuarioExame obj){
		ProntuarioExame newObj = service.update(id,obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
