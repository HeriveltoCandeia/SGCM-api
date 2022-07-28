package br.pucminas.tcc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//permitir apenas usuários da role USER
		//** na url significa qualquer coisa
		http
			.authorizeRequests()
			.antMatchers("/clientesRest/**","/funcionariosRest/**").authenticated()
			.antMatchers("/examesRest/**","/medicamentosRest/**").hasRole("USER")
			.anyRequest().denyAll(); // para qualquer outra, negue todas.
		//.antMatchers("/clientesRest/**").hasRole("USER"); apenas determinada role
		//.antMatchers("/clientesRest/**").hasAnyRole("USER", "ADMIN"); => várias roles
		//.antMatchers("/clientesRest/**").permitAll(); => permite qualquer acionamento
		// desnecessário => .antMatchers("/oauth/**").permitAll()
	}

}
