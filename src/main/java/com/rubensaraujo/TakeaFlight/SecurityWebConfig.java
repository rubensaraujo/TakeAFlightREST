package com.rubensaraujo.TakeaFlight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rubensaraujo.TakeaFlight.Security.TakeAFlightUserDetailsService;

@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	TakeAFlightUserDetailsService userDetails;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
        	.antMatchers("/resources/**", "/webjars/**").permitAll()
        	.antMatchers("GET", "/home", "/", "/usuario/").permitAll()
        	.antMatchers("POST", "/usuario/new").permitAll()
        	.anyRequest().authenticated()
        .and()
        .formLogin()
        	.loginPage("/login").permitAll()
		.and()
		.rememberMe();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.userDetailsService(userDetails)
			.passwordEncoder(new BCryptPasswordEncoder());
		
	}
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
