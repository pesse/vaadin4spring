package org.vaadin.spring.samples.navigation;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.vaadin.spring.security.annotation.EnableVaadinSecurity;

@Configuration
public class SecurityConfig
{
	@Configuration
    @EnableVaadinSecurity
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter
    {
		@Override
	    public void configure( HttpSecurity http ) throws Exception
	    {
	    	
        	http
        		.authorizeRequests()
					.antMatchers("/**").permitAll()
					.and()	
				.csrf().disable();
	    }
    }

}
