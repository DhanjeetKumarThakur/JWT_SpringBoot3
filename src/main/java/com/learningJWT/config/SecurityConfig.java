package com.learningJWT.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.learningJWT.security.JwtAuthenticationEntryPoint;
import com.learningJWT.security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {

	@Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	//configuration
    	http.csrf(csrf->csrf.disable())
    		.cors(cors->cors.disable())
    		.authorizeHttpRequests(
    				auth -> auth.requestMatchers("/home/**")
    	//you can even authenticate based on role -- auth.requestMatchers("/home/**").hasRole("ADMIN")  
    				//if you do by role then remove authenticated() method ok
    							.authenticated()
    							.requestMatchers("/auth/login")
    							.permitAll()
    							.anyRequest()
    							.authenticated())
    		.exceptionHandling(ex -> ex.authenticationEntryPoint(point))
    		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    	
    	http.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);
    	
    	return http.build();
    }
}
