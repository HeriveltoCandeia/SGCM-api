package br.pucminas.tcc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.pucminas.tcc.model.entity.Cliente;
import br.pucminas.tcc.model.entity.Exame;
import br.pucminas.tcc.model.entity.Funcionario;
import br.pucminas.tcc.model.entity.Medicamento;
import br.pucminas.tcc.model.entity.TipoExame;
import br.pucminas.tcc.model.service.ClienteServiceRest;
import br.pucminas.tcc.model.service.ExameServiceRest;
import br.pucminas.tcc.model.service.FuncionarioServiceRest;
import br.pucminas.tcc.model.service.MedicamentoServiceRest;
import br.pucminas.tcc.model.service.TipoExameServiceRest;

@SpringBootApplication
public class JavaSpringApplication implements CommandLineRunner{
	
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
	
	public static void main(String[] args) {
		SpringApplication.run(JavaSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		carregarTipoExame();
//		carregarUsuarios();
//		carregarClientes();		
//		carregarExame();		
//		carregarMedicamento();	
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
		exame.setDescricao("Hemograma");
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
	
}
