package br.pucminas.tcc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import br.pucminas.tcc.JavaSpringApplication;
import br.pucminas.tcc.model.entity.AgendaMedica;
import br.pucminas.tcc.model.entity.Cliente;
import br.pucminas.tcc.model.entity.Exame;
import br.pucminas.tcc.model.entity.Funcionario;
import br.pucminas.tcc.model.entity.Medicamento;
import br.pucminas.tcc.model.entity.ProntuarioExame;
import br.pucminas.tcc.model.entity.ProntuarioMedicamento;
import br.pucminas.tcc.model.entity.ProntuarioMedico;
import br.pucminas.tcc.model.entity.TipoExame;
import br.pucminas.tcc.model.service.AgendaMedicaServiceRest;
import br.pucminas.tcc.model.service.ClienteServiceRest;
import br.pucminas.tcc.model.service.ExameServiceRest;
import br.pucminas.tcc.model.service.FuncionarioServiceRest;
import br.pucminas.tcc.model.service.MedicamentoServiceRest;
import br.pucminas.tcc.model.service.ProntuarioExameServiceRest;
import br.pucminas.tcc.model.service.ProntuarioMedicamentoServiceRest;
import br.pucminas.tcc.model.service.ProntuarioMedicoServiceRest;
import br.pucminas.tcc.model.service.TipoExameServiceRest;

@Service
public class DBService {

	@Autowired
	private TipoExameServiceRest service;

	@Autowired
	private ExameServiceRest serviceEx;

	@Autowired
	private MedicamentoServiceRest serviceMedic;
	
	@Autowired
	private FuncionarioServiceRest serviceFunc;

	@Autowired
	private ClienteServiceRest serviceCli;

	@Autowired
	private AgendaMedicaServiceRest serviceAgenda;	

	@Autowired
	private ProntuarioMedicoServiceRest serviceProntuario;	

	@Autowired
	private ProntuarioMedicamentoServiceRest serviceProntuarioMedicamento;	

	@Autowired
	private ProntuarioExameServiceRest serviceProntuarioExame;	
	
	public void instanciaBaseDeDados() {
		List<TipoExame> listaTipoExame = service.findAll();
		if (!listaTipoExame.isEmpty() )
		{
			return;
		}

		carregarTipoExame();
		carregarUsuarios();
		carregarClientes();		
		carregarExame();		
		carregarMedicamento();
		carregarAgenda();
		carregarProntuario();
		carregarProntuarioMedicamento();
		carregarProntuarioExame();
				
	}
	
	private void carregarTipoExame() {
		TipoExame tipoExame = new TipoExame();
		tipoExame.setDescricao("Exame de Sangue");
		service.create(tipoExame);
		tipoExame.setDescricao("Exame de Urina");
		service.create(tipoExame);
		tipoExame.setDescricao("Exame de Fezes");
		service.create(tipoExame);
		tipoExame.setDescricao("Exame de Imagem");
		service.create(tipoExame);		
	}

	private void carregarExame() {
		Exame exame = new Exame();
		exame.setDescricao("Glicose");
		TipoExame tipoExame = new TipoExame();
		tipoExame.setId(1L);
		exame.setTipoExame(tipoExame);
		serviceEx.create(exame);

		exame.setDescricao("Urocultura");
		tipoExame = new TipoExame();
		tipoExame.setId(2L);
		exame.setTipoExame(tipoExame);
		serviceEx.create(exame);

	}

	private void carregarMedicamento() {
		Medicamento medicamento = new Medicamento();
		medicamento.setNomeFabrica("Novalgina");
		medicamento.setNomeGenerico("Dipirona");
		medicamento.setNomeFabricante("Medley");
		serviceMedic.create(medicamento);

		medicamento.setNomeFabrica("Nexium");
		medicamento.setNomeGenerico("Esomeprazol");
		medicamento.setNomeFabricante("Medley");
		serviceMedic.create(medicamento);

	}
	
	private void carregarUsuarios() {
		Funcionario funcionario = new Funcionario();
		funcionario.setCodigoCargo(1L);
		funcionario.setCpf("123.456.789-10");
		funcionario.setDataAdmissao("01/01/2022");
		funcionario.setDataNascimento("01/01/2000");
		funcionario.setEmail("teste@teste.com.br");
		funcionario.setNome("Herivelto Candeia");
		funcionario.setSenha("12345678");
		funcionario.setSexo("M");
		funcionario.setUsuario("Candeia");
		serviceFunc.create(funcionario);

		funcionario.setCodigoCargo(2L);
		funcionario.setCpf("123.456.789-11");
		funcionario.setDataAdmissao("01/01/2022");
		funcionario.setDataNascimento("01/01/2000");
		funcionario.setEmail("teste@teste.com.br");
		funcionario.setNome("Maria Júlia Chaves Candeia");
		funcionario.setSenha("12345678");
		funcionario.setSexo("F");
		funcionario.setUsuario("Maju");
		serviceFunc.create(funcionario);

		funcionario.setCodigoCargo(3L);
		funcionario.setCpf("123.456.789-12");
		funcionario.setDataAdmissao("01/01/2022");
		funcionario.setDataNascimento("01/01/2000");
		funcionario.setEmail("teste@teste.com.br");
		funcionario.setNome("Ana Clara Chaves Candeia");
		funcionario.setSenha("12345678");
		funcionario.setSexo("F");
		funcionario.setUsuario("AnaClara");
		serviceFunc.create(funcionario);
		
	}
	

	private void carregarClientes() {
		Cliente cliente = new Cliente();
		cliente.setCpf("123.456.789-13");
		cliente.setDataNascimento("01/01/2000");
		cliente.setEmail("teste@teste.com.br");
		cliente.setNome("Carla Cristina Chaves Candeia");
		cliente.setSexo("F");
		cliente.setConvenioMedico("cassi");
		cliente.setNumeroCarteirinha("123456789");
		serviceCli.create(cliente);

		cliente.setCpf("123.456.789-14");
		cliente.setDataNascimento("01/01/2000");
		cliente.setEmail("teste@teste.com.br");
		cliente.setNome("João Vítor Chaves Candeia");
		cliente.setSexo("F");
		cliente.setConvenioMedico("cassi");
		cliente.setNumeroCarteirinha("12345678910");
		serviceCli.create(cliente);
		
	}

	private void carregarAgenda() {
		AgendaMedica agendaMedica = new AgendaMedica();
		Funcionario med = new Funcionario();
		LocalDate dtAtu = LocalDate.of(2022, 8, 8);
		LocalTime hrAtu = LocalTime.of(8, 30);
		LocalDateTime dtTimeAtu = LocalDateTime.of(dtAtu, hrAtu);
		med.setId(3L);
		agendaMedica.setMedico(med);
		agendaMedica.setCodigoSituacao(1);
		agendaMedica.setCodigoTipo(1);
		agendaMedica.setDataReg(dtAtu);
		agendaMedica.setDataAgenda(dtTimeAtu);
		serviceAgenda.create(agendaMedica);		

		agendaMedica.setMedico(med);
		agendaMedica.setCodigoSituacao(1);
		agendaMedica.setCodigoTipo(1);
		agendaMedica.setDataReg(dtAtu);
		hrAtu = LocalTime.of(9, 00);		
		dtTimeAtu = LocalDateTime.of(dtAtu, hrAtu);
		agendaMedica.setDataAgenda(dtTimeAtu);
		serviceAgenda.create(agendaMedica);				
	}

	private void carregarProntuario() {
		ProntuarioMedico prontuarioMedico = new ProntuarioMedico();
		Funcionario med = new Funcionario();
		Cliente cli = new Cliente();
		LocalDate dtAtu = LocalDate.of(2022, 8, 8);
		LocalTime hrAtu = LocalTime.of(8, 30);
		LocalDateTime dtTimeAtu = LocalDateTime.of(dtAtu, hrAtu);
		med.setId(3L);
		cli.setId(4L);
		prontuarioMedico.setMedico(med);
		prontuarioMedico.setCodigoSituacao(1);
		prontuarioMedico.setCliente(cli);
		prontuarioMedico.setDataReg(dtAtu);
		prontuarioMedico.setDataTimeProntuario(dtTimeAtu);
		serviceProntuario.create(prontuarioMedico);		

		prontuarioMedico.setMedico(med);
		prontuarioMedico.setCodigoSituacao(1);
		cli.setId(5L);
		prontuarioMedico.setCliente(cli);
		prontuarioMedico.setDataReg(dtAtu);
		hrAtu = LocalTime.of(9, 00);		
		dtTimeAtu = LocalDateTime.of(dtAtu, hrAtu);
		prontuarioMedico.setDataTimeProntuario(dtTimeAtu);
		serviceProntuario.create(prontuarioMedico);				
	}

	
	private void carregarProntuarioMedicamento() {
		ProntuarioMedico prontuarioMedico = new ProntuarioMedico();
		ProntuarioMedicamento prontuarioMedicamento = new ProntuarioMedicamento();
		Medicamento medicamento = new Medicamento();
		medicamento.setId(1L);
		prontuarioMedico.setId(1L);
		prontuarioMedicamento.setProntuarioMedico(prontuarioMedico);
		prontuarioMedicamento.setMedicamento(medicamento);
		prontuarioMedicamento.setOrientacoes("3 x ao dia");
		serviceProntuarioMedicamento.create(prontuarioMedicamento);		

		medicamento.setId(2L);
		prontuarioMedico.setId(1L);
		prontuarioMedicamento.setProntuarioMedico(prontuarioMedico);
		prontuarioMedicamento.setMedicamento(medicamento);
		prontuarioMedicamento.setOrientacoes("1 x ao dia");
		serviceProntuarioMedicamento.create(prontuarioMedicamento);		

		medicamento.setId(2L);
		prontuarioMedico.setId(1L);
		prontuarioMedicamento.setProntuarioMedico(prontuarioMedico);
		prontuarioMedicamento.setMedicamento(medicamento);
		prontuarioMedicamento.setOrientacoes("3 x ao dia");
		serviceProntuarioMedicamento.create(prontuarioMedicamento);		
		
	}

	private void carregarProntuarioExame() {
		ProntuarioMedico prontuarioMedico = new ProntuarioMedico();
		ProntuarioExame prontuarioExame = new ProntuarioExame();
		Exame exame = new Exame();
		exame.setId(1L);
		prontuarioMedico.setId(1L);
		prontuarioExame.setProntuarioMedico(prontuarioMedico);
		prontuarioExame.setExame(exame);
		prontuarioExame.setOrientacoes("Jejum");
		prontuarioExame.setCodigoSituacao(1);		
		serviceProntuarioExame.create(prontuarioExame);		

		exame.setId(2L);
		prontuarioExame.setId(1L);
		prontuarioExame.setProntuarioMedico(prontuarioMedico);
		prontuarioExame.setExame(exame);
		prontuarioExame.setCodigoSituacao(1);
		serviceProntuarioExame.create(prontuarioExame);		

		exame.setId(2L);
		prontuarioExame.setId(1L);
		prontuarioExame.setProntuarioMedico(prontuarioMedico);
		prontuarioExame.setExame(exame);
		prontuarioExame.setOrientacoes("Jejum");
		prontuarioExame.setCodigoSituacao(1);
		serviceProntuarioExame.create(prontuarioExame);		
		
	}
	

}
