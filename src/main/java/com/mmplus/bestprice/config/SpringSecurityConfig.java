package com.mmplus.bestprice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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

		auth.inMemoryAuthentication().withUser(users.username("j@g.com").password("test123").roles("EMPLOYEE")).withUser(users.username("marry").password("test123").roles("MANAGER"))
				.withUser(users.username("dmytro").password("test123").roles("ADMIN"));

	}

}
