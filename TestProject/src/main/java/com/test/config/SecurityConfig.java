package com.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.test.service.UserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired private UserDetailService userDetailsService;
	@Autowired private AuthenticationFailureHandler authFailureHandler;
	@Autowired private AuthenticationSuccessHandler authSuccessHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
            .formLogin()
            	.usernameParameter("email")
            	.passwordParameter("password")
            	.successHandler(authSuccessHandler)
            	.failureHandler(authFailureHandler)
                .permitAll(true)
                .and()
            .logout()
            	.permitAll()
            	.invalidateHttpSession(true)
            	.clearAuthentication(true)
            	.and()
            .csrf()
            	.disable();
        http
        	.sessionManagement()
        		.maximumSessions(1);
    }
    
}