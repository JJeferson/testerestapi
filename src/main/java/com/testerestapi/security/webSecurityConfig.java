package com.testerestapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class webSecurityConfig extends WebSecurityConfigurerAdapter  {


//	@Autowired
//	private ImplementsUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").permitAll()
		.antMatchers(HttpMethod.GET,   "/usuarios").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST,  "/usuarios").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT,   "/usuarios").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/usuarios").hasRole("ADMIN")
		//----
		.antMatchers(HttpMethod.GET,   "/produtos").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST,  "/produtos").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT,   "/produtos").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/produtos").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
		.withUser("teste").password("123").roles("ADMIN");
		//.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception{
		//web.ignoring().antMatchers("/materialize/**", "/style/**");
	}
	
}
