package br.pucminas.tcc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.pucminas.tcc.service.DBService;

@Configuration
@Profile("prd")
public class PrdConfig {

	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instanciaBaseDeDados() {
		System.out.println("AMBIENTE DE PRODUÇÃO");		
//		if(strategy.equalsIgnoreCase("create"))
//		{
			this.dbService.instanciaBaseDeDados();
//		}
		return false;
	}
}
