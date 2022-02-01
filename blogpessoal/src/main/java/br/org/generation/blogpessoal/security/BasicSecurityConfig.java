package br.org.generation.blogpessoal.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService; //Checar se a senha usada existe no banco de dados.
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(userDetailsService); //Pode ser usado em qualque implementação.
		auth.inMemoryAuthentication()
		.withUser("root")
		.password(passwordEncoder().encode("root"))
		.authorities("ROLE_USER");
	}
	
	@Bean //Criptografas a senha e checar se ela está certa
	public PasswordEncoder passwordEncoder() {
		return new  BCryptPasswordEncoder ();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{ //Configurar as regras de acesso// Autrização
		http.authorizeRequests()
			.antMatchers("/usuario/logar").permitAll() //Liberar
			.antMatchers("/usuario/cadastrar").permitAll() //liberar
			.antMatchers(HttpMethod.OPTIONS).permitAll() //liberar Opções que virá no cabeçalho da requisição
			.anyRequest().authenticated()
			.and().httpBasic()
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)// Não guarda sessão nenhuma
			.and().cors()
			.and().csrf().disable();
	}
}
