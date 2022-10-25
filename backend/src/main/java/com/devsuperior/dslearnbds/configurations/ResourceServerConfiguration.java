package com.devsuperior.dslearnbds.configurations;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	@Autowired
	private Environment environment;

	@Autowired
	private JwtTokenStore tokenStore;
	
	// rotas publicas
	private static final String[] PUBLIC = { "/oauth/token", "/h2-console/**" };

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		
		// metodo responsavel por decodificar o token e analisar se o mesmo eh valido
		// se esta expirado etc
		
		resources.tokenStore(tokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		// configuracao especifica pra liberar o h2
		// no caso verifica se o profile que está em execucao
		// eh o profile de test
		
		if(Arrays.asList(environment.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}
		
		// configuracao de rotas
		
		http.authorizeRequests()
		.antMatchers(PUBLIC).permitAll()
		.anyRequest().authenticated();
		
	}

}
