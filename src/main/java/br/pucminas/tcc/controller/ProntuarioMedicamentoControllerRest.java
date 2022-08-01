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

import br.pucminas.tcc.model.entity.Funcionario;
import br.pucminas.tcc.model.entity.Medicamento;
import br.pucminas.tcc.model.entity.ProntuarioMedicamento;
import br.pucminas.tcc.model.entity.ProntuarioMedico;
import br.pucminas.tcc.model.service.ProntuarioMedicamentoServiceRest;
import br.pucminas.tcc.model.service.ProntuarioMedicoServiceRest;

@RestController
@RequestMapping("/prontuariosMedicamentosRest")
public class ProntuarioMedicamentoControllerRest {
	
	@Autowired
	private ProntuarioMedicamentoServiceRest service;

	@Autowired
	private ProntuarioMedicoServiceRest service2;
	
	@GetMapping("/{id}")
	public ResponseEntity<ProntuarioMedicamento> finById(@PathVariable("id") Long id) {
		ProntuarioMedicamento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@CrossOrigin
	@GetMapping("/prontuarioMedico/{id}")
	public ResponseEntity<List<ProntuarioMedicamento>> findByProntuarioMedico(@PathVariable("id") Long id) {
//		ProntuarioMedico pm = service2.findById(id);
		ProntuarioMedico pm = new ProntuarioMedico();
		pm.setId(id);
		List <ProntuarioMedicamento> obj = service.findByProntuarioMedico(pm);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@GetMapping
	public ResponseEntity<List<ProntuarioMedicamento>> finByAll() {
		List <ProntuarioMedicamento> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<ProntuarioMedicamento> incluir(@RequestBody ProntuarioMedicamento obj) {
		System.out.println(obj);
		obj=service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ProntuarioMedicamento> editar(@PathVariable Long id, @RequestBody ProntuarioMedicamento obj){
		ProntuarioMedicamento newObj = service.update(id,obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
