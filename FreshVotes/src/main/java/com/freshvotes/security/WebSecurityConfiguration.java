package com.freshvotes.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// we want to make less secure spring-boot-starter-security dependency by configuration using java

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		// method asks who are you and prove it
		// tell spring security where are usenames and passwords
		// by building a database of usernames and passwords
		auth.inMemoryAuthentication()
			.withUser("jal3lsl23s")
			.password("3lj289sjz297sl249sljj239sljf")
			.roles("USER"); // authentication
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		// when you authenticate your self what access should i gave you
		// are you like administrator or some end point user client 
		http.csrf().disable()
			.authorizeRequests()
			//.antMatchers("/index").permitAll() // only the index file is allowed to be seen
			.antMatchers("/").permitAll() //  root of the web application is allowed to be seen by anyone only the index file is allowed to be seen
			.anyRequest().hasRole("USER").and()
			.formLogin()
				.loginPage("/login")
				.permitAll() // only authorized people should see login page
				.and()
			.logout()
				.logoutUrl("/logout")
				.permitAll();
		
	}
	
	
	// we need a mapping for login.html page
	// actually we need a listener
	
	

	
	
}








