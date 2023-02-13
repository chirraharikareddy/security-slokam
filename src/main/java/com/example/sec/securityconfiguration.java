package com.example.sec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class securityconfiguration extends WebSecurityConfigurerAdapter {
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails userdetails=User.builder().username("harika")
		.password("{noop}harika").roles("ADMIN").build();
		UserDetails slokam=User.builder().username("reddy")
		.password("{noop}reddy").roles("USER").build();
		return new InMemoryUserDetailsManager(userdetails,slokam);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable().authorizeRequests()
	.antMatchers(HttpMethod.GET,"/api/**")
	.permitAll()
	.antMatchers("/api/auth/**")
	.permitAll()
	.anyRequest()
	.authenticated();
	}

}
