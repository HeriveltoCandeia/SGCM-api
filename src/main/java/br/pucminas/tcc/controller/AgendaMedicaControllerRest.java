package br.pucminas.tcc.controller;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.pucminas.tcc.model.entity.AgendaMedica;
import br.pucminas.tcc.model.entity.AgendaMedicaLote;
import br.pucminas.tcc.model.entity.Cliente;
import br.pucminas.tcc.model.entity.Funcionario;
import br.pucminas.tcc.model.service.AgendaMedicaServiceRest;
import br.pucminas.tcc.model.service.FuncionarioServiceRest;
import br.pucminas.tcc.model.service.UsuarioService;

@RestController
@RequestMapping("/agendasMedicasRest")
public class AgendaMedicaControllerRest {
	
	@Autowired
	private AgendaMedicaServiceRest service;
	
	@Autowired
	private FuncionarioServiceRest serviceFunc; 
	
	@Autowired
	private UsuarioService serviceUsu;

	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<AgendaMedica> finById(@PathVariable("id") Long id) {
		AgendaMedica obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<AgendaMedica>> finByAll() {
		List <AgendaMedica> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping("/{id}/{id2}/{id3}/{id4}")
	public ResponseEntity<List<AgendaMedica>> finByFiltros(@PathVariable("id") String id, @PathVariable("id2") String id2, @PathVariable("id3") String id3,  @PathVariable("id4") String id4) {
		ObjectMapper mapper = new ObjectMapper();
		Funcionario med = new Funcionario();
		Cliente cli = new Cliente();
		Boolean filMed=false, filCli=false, filData=false, filSituacao=false;
		LocalDate dataReg = LocalDate.of(9999,12,31);
		Integer codigoSituacao=0;
		System.out.println("Data Reg");
		System.out.println(id3);
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
			if (!"NO".equals(id4))
			{
				codigoSituacao = Integer.parseInt(id4);
				filSituacao=true;
			}
			List <AgendaMedica> obj = service.findByAgendaMedicaFiltros(med, cli, dataReg, codigoSituacao, filMed, filCli, filData, filSituacao);
			return ResponseEntity.ok().body(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(404).build();		
		}

	}	
	
	@PostMapping
	public ResponseEntity<AgendaMedica> incluir(@RequestBody AgendaMedica obj) throws Exception {
		
//      *****************************************************	
//		Verifica os acessos para o Cargo do usuário logado.
//      *****************************************************
//		// 1 -> Administrador , 2 -> Atendente, 3-> Médico	
		int[] ace = { 1, 3};
		Long cargo = serviceUsu.verificaAcessoUsuario(ace);
//      *****************************************************
		
		if (obj.getCliente().getId() == 0)
		{
			obj.setCliente(null);
		}
/*		for(int i = 8;i<18;i++)
		{
			for (int j = 0;  j<60; j++)
			{
				LocalDateTime dT = LocalDateTime.of(obj.getDataAgenda().getYear(),obj.getDataAgenda().getMonth(),obj.getDataAgenda().getDayOfMonth(),i,j);
				System.out.println(dT);
				obj.setId(null);
				obj.setDataAgenda(dT);
				obj=service.create(obj);
				j=j+20;
			}
			i++;
		}*/
		obj=service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PostMapping("/lote")
	public ResponseEntity<AgendaMedicaLote> incluirLote(@RequestBody AgendaMedicaLote obj) throws Exception {
		
//      *****************************************************	
//		Verifica os acessos para o Cargo do usuário logado.
//      *****************************************************
//		// 1 -> Administrador , 2 -> Atendente, 3-> Médico	
		int[] ace = { 1, 3};
		Long cargo = serviceUsu.verificaAcessoUsuario(ace);
//      *****************************************************
		
		System.out.println("Objeto Recebido");
		System.out.println(obj.getDataInicial());
		System.out.println(obj.getDataFinal());
		System.out.println(obj.getHoraInicial());
		System.out.println(obj.getHoraFinal());
		System.out.println(obj.getCodigoSituacao());
		System.out.println(obj.getCodigoTipo());
		System.out.println(obj.getCodigoTempo());

//		return ResponseEntity.ok().build();
		service.createLote(obj.getMedico(), obj.getDataInicial(), obj.getDataFinal(), obj.getHoraInicial(), obj.getHoraFinal(), obj.getCodigoSituacao(), obj.getCodigoTipo(), obj.getCodigoTempo());
		return ResponseEntity.ok().body(obj);
	}

	@PutMapping(value="/{id}")
	public ResponseEntity<AgendaMedica> editar(@PathVariable Long id, @RequestBody AgendaMedica obj) throws Exception{

		if (obj.getCliente().getId() == 0)
		{
			obj.setCliente(null);
		}
		AgendaMedica newObj = service.update(id,obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) throws Exception{
//      *****************************************************	
//		Verifica os acessos para o Cargo do usuário logado.
//      *****************************************************
//		// 1 -> Administrador , 2 -> Atendente, 3-> Médico	
		int[] ace = { 1, 3};
		Long cargo = serviceUsu.verificaAcessoUsuario(ace);
//      *****************************************************

		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
