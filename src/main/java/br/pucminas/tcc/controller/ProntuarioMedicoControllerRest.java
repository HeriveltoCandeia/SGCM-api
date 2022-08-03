package br.pucminas.tcc.controller;

import java.util.List;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.pucminas.tcc.model.entity.ChaveCompostaAgenda;
import br.pucminas.tcc.model.entity.ChavePesquisa;
import br.pucminas.tcc.model.entity.Cliente;
import br.pucminas.tcc.model.entity.Funcionario;
import br.pucminas.tcc.model.entity.ProntuarioMedico;
import br.pucminas.tcc.model.service.ProntuarioMedicoServiceRest;

@RestController
@RequestMapping("/prontuariosMedicosRest")
public class ProntuarioMedicoControllerRest {
	
	@Autowired
	private ProntuarioMedicoServiceRest service;
	
	@GetMapping("/{id}")
	public ResponseEntity<ProntuarioMedico> finById(@PathVariable("id") Long id) {
		ProntuarioMedico obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<ProntuarioMedico>> finByAll() {
		List <ProntuarioMedico> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/{id}/{id2}/{id3}")
	public ResponseEntity<List<ProntuarioMedico>> finByFiltros(@PathVariable("id") String id, @PathVariable("id2") String id2, @PathVariable("id3") String id3) {
		ObjectMapper mapper = new ObjectMapper();
		Funcionario med = new Funcionario();
		Cliente cli = new Cliente();
		Boolean filMed=false, filCli=false, filData=false;
		LocalDate dataReg = LocalDate.of(9999,12,31);
		try {
			if (!"NO".equals(id))
				{
					med = mapper.readValue(id, Funcionario.class);
					filMed=true;
				}
			if (!"NO".equals(id2))
			{
				cli = mapper.readValue(id2, Cliente.class);
				filCli=true;
			}
			if (!"NO".equals(id3))
			{
				dataReg = LocalDate.of(Integer.parseInt(id3.substring(4, 8)),Integer.parseInt(id3.substring(2, 4)), Integer.parseInt(id3.substring(0, 2)));
				filData=true;
			}
			List <ProntuarioMedico> obj = service.findByProntuarioFiltros(med, cli, dataReg, filMed, filCli, filData);
			return ResponseEntity.ok().body(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(404).build();		
		}

	}

	@PostMapping
	public ResponseEntity<ProntuarioMedico> incluir(@RequestBody ProntuarioMedico obj) {
		System.out.println(obj);
		obj=service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ProntuarioMedico> editar(@PathVariable Long id, @RequestBody ProntuarioMedico obj){
		ProntuarioMedico newObj = service.update(id,obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
