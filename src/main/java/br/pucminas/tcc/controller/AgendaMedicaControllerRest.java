package br.pucminas.tcc.controller;

import java.util.List;
import java.net.URI;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.pucminas.tcc.model.entity.AgendaMedica;
import br.pucminas.tcc.model.entity.ChaveCompostaAgenda;
import br.pucminas.tcc.model.service.AgendaMedicaServiceRest;

@RestController
@RequestMapping("/agendasMedicasRest")
public class AgendaMedicaControllerRest {
	
	@Autowired
	private AgendaMedicaServiceRest service;
	
	@GetMapping("/{id}")
	public ResponseEntity<AgendaMedica> finByChaveCompostaAgenda(@PathVariable("id") ChaveCompostaAgenda chaveCompostaAgenda) {
		AgendaMedica obj = service.findByChaveCompostaAgenda(chaveCompostaAgenda);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<AgendaMedica>> finByAll() {
		List <AgendaMedica> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<AgendaMedica> incluir(@RequestBody AgendaMedica obj) {
		System.out.println(obj);
		obj=service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{chaveCompostaAgenda}").buildAndExpand(obj.getChaveCompostaAgenda()).toUri(); 
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value="/{chaveCompostaAgenda}")
	public ResponseEntity<AgendaMedica> editar(@PathVariable ChaveCompostaAgenda chaveCompostaAgenda, @RequestBody AgendaMedica obj){
		AgendaMedica newObj = service.update(chaveCompostaAgenda,obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value="/{chaveCompostaAgenda}")
	public ResponseEntity<Void> excluir(@PathVariable ChaveCompostaAgenda chaveCompostaAgenda){
		service.delete(chaveCompostaAgenda);
		return ResponseEntity.noContent().build();
	}
}
