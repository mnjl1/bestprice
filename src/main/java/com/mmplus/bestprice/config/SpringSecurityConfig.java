package com.mmplus.bestprice.config;

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
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		
		@SuppressWarnings("deprecation")
		UserBuilder users = User.withDefaultPasswordEncoder();

		auth
			.inMemoryAuthentication()
				.withUser(users.username("f@g.com").password("123").roles("COMPANY"))
				.withUser(users.username("v@g.com").password("123").roles("MANAGER"))
				.withUser(users.username("admin@g.com").password("admin").roles("BUYER"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/welcome-page").permitAll()
			.antMatchers("/mmplus/**").hasAnyRole("MANAGER")
			.antMatchers("/company/hot-price-schedule-list").hasAnyRole("COMPANY", "MANAGER")
			.antMatchers("/buyer/companyForm").hasAnyRole("BUYER")
				.and()
			.formLogin().loginPage("/login").defaultSuccessUrl("/home").permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");		
	}
}
