package com.uxpsystems.assignment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	 @Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.inMemoryAuthentication().withUser("admin").password(encoder().encode("admin11")).roles("ADMIN")
		.and()
		.withUser("user").password(encoder().encode("unix11")).roles("USER");
	}
	
	@Bean
	public PasswordEncoder encoder() {
		  return PasswordEncoderFactories.createDelegatingPasswordEncoder(); 		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();	

	}

}
