package br.pucminas.tcc.controller;

import java.util.List;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.Valid;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.pucminas.tcc.model.entity.AgendaMedica;
import br.pucminas.tcc.model.entity.ChaveCompostaAgenda;
import br.pucminas.tcc.model.entity.ChavePesquisa;
import br.pucminas.tcc.model.entity.Funcionario;
import br.pucminas.tcc.model.service.AgendaMedicaServiceRest;

@RestController
@RequestMapping("/agendasMedicasRest")
public class AgendaMedicaControllerRest {
	
	@Autowired
	private AgendaMedicaServiceRest service;
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<AgendaMedica> finById(@PathVariable("id") Long id) {
		AgendaMedica obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	public ResponseEntity<AgendaMedica> finByChaveCompostaAgenda(@PathVariable("id") String chavePesquisa) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			ChavePesquisa t1 = mapper.readValue(chavePesquisa, ChavePesquisa.class);
			LocalDateTime localDateTime = LocalDateTime.of(t1.getAnoData(),t1.getMesData(), t1.getDiaData(), t1.getHoraData(), t1.getMinutoData(), t1.getSegundoData());
			ChaveCompostaAgenda chaveComp = new ChaveCompostaAgenda();
			chaveComp.setCodigoMedicoId(t1.getCodigoMedicoId());
			chaveComp.setDataAgenda(localDateTime);
			AgendaMedica obj = service.findByChaveCompostaAgenda(chaveComp);
			return ResponseEntity.ok().body(obj);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(404).build();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(404).build();
		}
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
	
	@PutMapping(value="/{id}")
	public ResponseEntity<AgendaMedica> editar(@PathVariable Long id, @RequestBody AgendaMedica obj){
		AgendaMedica newObj = service.update(id,obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
