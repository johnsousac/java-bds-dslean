/**
 * Configuração provisória para liberar os enpoints
 * mesmo estando com o pacote do spring security 
 * habilitado no projeto
 */
package com.devsuperior.dslearnbds.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// implementacao:
		// qual algoritmo eh usado para encriptar a senha que no nosso caso eh o bcrypt
		// qual eh o nosso UserDetailsService
		
		// com isso o spring security no momento da autenticacao vai saber 
		// como buscar o usuario por email (userDetailsService) e como vai ser que analisar a senha criptografada
		// (passwordEncoder)
		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
//		liberando todos os endpoints sem oauth2
//		web.ignoring().antMatchers("/**");
		
//		liberando todos os endpoints com o oauth2
		web.ignoring().antMatchers("/actuator/**");
	}

	// estamos disponibilizando o metodo como um bean do sistema ou seja um componente
	// por que quando formos implementar o authorization server vamos precisar
	// desse objeto
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
}
