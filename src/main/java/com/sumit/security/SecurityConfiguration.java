package com.sumit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("dummy").password("dummy")
				.roles("USER", "ADMIN");
                auth.inMemoryAuthentication().withUser("sumit").password("sumit")
				.roles("USER", "ADMIN");
	}

	@Override
        //yo muni antMatchers vaneko chai kk handa login huna nadine haru ho
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll()
				.antMatchers("/", "/*dashboard*/**", "/*addallcontent*/**", "/*content*/**", "/*contentform*/**").access("hasRole('USER')").and()
				.formLogin().and().exceptionHandling()
				.accessDeniedPage("/access-denied");
	}
}