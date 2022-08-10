package br.pucminas.tcc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.pucminas.tcc.service.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public void instanciaBaseDeDados() {
		System.out.println("AMBIENTE DE TESTE");
		this.dbService.instanciaBaseDeDados();
	}
}
