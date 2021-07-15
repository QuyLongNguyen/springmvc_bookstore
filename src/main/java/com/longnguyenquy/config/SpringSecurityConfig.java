package com.longnguyenquy.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource myDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();
		/*
		auth.inMemoryAuthentication().withUser(users.username("long1").password("123456").roles("admin","customer"));
		auth.inMemoryAuthentication().withUser(users.username("long2").password("123456").roles("customer"));
		*/
		auth.jdbcAuthentication().dataSource(myDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.formLogin().loginPage("/login").loginProcessingUrl("/authenticate")
		.and().logout()
		.and().exceptionHandling().accessDeniedPage("/login/access-denied")
		.and().csrf().disable();
		
		http.authorizeRequests().antMatchers("/admin/**").hasAnyRole("ADMIN");
	
	}

}
