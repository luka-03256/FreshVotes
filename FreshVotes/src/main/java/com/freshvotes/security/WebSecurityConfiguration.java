package com.freshvotes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//we want to make less secure spring-boot-starter-security dependency by configuration using java

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailService;

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		// method asks who are you and prove it
		// tell spring security where are usernames and passwords
		// by building a database of usernames and passwords

		// examine commented code down below some misconception might happened
		// during process of working
		// auth.userDetailsService(userDetailService).passwordEncoder(getPasswordEncoder());

		/*
		 * auth.inMemoryAuthentication() .passwordEncoder(getPasswordEncoder())
		 * .withUser("trevor@craftycodr.com")
		 * .password(getPasswordEncoder().encode("asdfasdf")) .roles("ADMIN");
		 */

		auth.inMemoryAuthentication().passwordEncoder(getPasswordEncoder()).withUser("mtopkovic@mail.com")
				.password(getPasswordEncoder().encode("password123")).roles("USER");

		// authentication

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// authorization

		// when you authenticate your self what access should i gave you
		// are you like administrator or some end point user client

		// .antMatchers("/index").permitAll() // only the index file is allowed to be
		// seen

		// root of the web application is allowed to be seen by anyone only the
		// index file is allowed to be seen
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/register").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN").anyRequest().hasRole("USER").and().formLogin()
				.loginPage("/login").defaultSuccessUrl("/dashboard").permitAll().and().logout().logoutUrl("/logout")
				.permitAll();

	}

	// we need a mapping for login.html page
	// actually we need a listener

	// csrf - stands for () => cross site request forgery
	// hacker knows when you are logged in your bank account
	// and they send you their fake page (redirect you to their page)
	// that page can actually post data to your bank on your behalf

	// in order to protect against this kind of attacks
	// you could have csrf token which represents random number alpha-numeric value
	// basically anything that isn't a get request will be secured

}

// \\A\\$2(a|y|b)?\\$(\\d\\d)\\$[./0-9A-Za-z]{53}
// \A \2a \ \a-z \a-z .6Zb8slz.lkjj28973.sijo2oijs.. {53}
