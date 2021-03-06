package com.rubensaraujo.TakeaFlight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.rubensaraujo.TakeaFlight.Security.TakeAFlightUserDetailsService;

@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	TakeAFlightUserDetailsService userDetails;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
        	.antMatchers("/webjars/**", "/images/**", "/css/**", "/js/**", "/fonts/**").permitAll()
        	.antMatchers("GET", "/home", "/", "/usuario/").permitAll()
        	.antMatchers("POST", "/usuario/new").permitAll()
        	.anyRequest().authenticated()
        .and()
        .formLogin()
        	.loginPage("/login").permitAll()
        	.defaultSuccessUrl("/usuario/index")
		.and()
		.rememberMe()
		.and().logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/").and().exceptionHandling()
		.accessDeniedPage("/access-denied");
	}
	
	/*public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**", "/images/**", "/css/**", "/js/**", "/fonts/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/",
							  "classpath:/static/images/",
							  "classpath:/static/css/",
							  "classpath:/static/js/",
							  "classpath:/static/fonts/");
	}*/
	
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
